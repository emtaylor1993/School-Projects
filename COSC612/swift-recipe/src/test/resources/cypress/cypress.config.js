const { defineConfig } = require("cypress");
const preprocessor = require("@badeball/cypress-cucumber-preprocessor");
const browserify = require("@badeball/cypress-cucumber-preprocessor/browserify");

async function setupNodeEvents(cypressOn, config) {
  const on = require("cypress-on-fix")(cypressOn)
  await preprocessor.addCucumberPreprocessorPlugin(on, config);
  on("file:preprocessor", browserify.default(config));
  return config
}

module.exports = defineConfig({
  projectId: 'dqgtfx',
  defaultCommandTimeout: 6000,
  env: {
    url: "http://localhost:8080/login"
  },
  retries: {
    runMode: 1
  },
  e2e: {
    setupNodeEvents,
    specPattern: "cypress/integration/features/*.feature"
  },
});