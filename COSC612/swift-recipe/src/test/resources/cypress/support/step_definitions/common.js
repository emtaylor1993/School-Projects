/**
 * SWIFTRECIPE APPLICATION COMMON STEP DEFINITIONS
 * 
 * @author Emmanuel Taylor
 * 
 * This file represents all of the common step definitions used within
 * the various feature files of the SwiftRecipe application.
 */

import { Given } from "@badeball/cypress-cucumber-preprocessor";

// This step definition specifies that the user visits the SwiftRecipe home page.
Given("User Visits SwiftRecipe Login Page", function() {
    cy.visit(Cypress.env("url"))
})