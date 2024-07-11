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
  defaultCommandTimeout: 6000,
  env: {
    url: "http://localhost:8080/login",
    username: "etaylor5",
    password: "demo5"
  },
  retries: {
    runMode: 1
  },
  e2e: {
    setupNodeEvents,
    viewportWidth: 2560,
    viewportHeight: 1440,
    specPattern: "cypress/integration/features/*.feature"
  },
});
