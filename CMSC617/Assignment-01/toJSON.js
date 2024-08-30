/**
 * toJSON.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will read contents from an input text file and
 *    return the contents as a JSON object.
 */

const fs = require("fs");

/* Stops processing if the user does not have three arguments on the command line. */
if (process.argv.length != 3) {
    console.log("There should be three arguments.");
} else {
    const buffer = fs.readFileSync(process.argv[2]);
    const output = buffer.toString();
    const outputSplits = output.split("\n");
    
    /* Stops processing if the file does not contain at least three lines. */
    if (outputSplits.length < 3) {
        console.log("There should be a mininum of three lines in the file.");
    } else {
        /* If the file contains exactly three lines, pop each element off of the
           array and assign the other key the value of "N/A". */
        if (outputSplits.length == 3) {
            const location = outputSplits.pop();
            const lname = outputSplits.pop();
            const fname = outputSplits.pop();    
            const jsonString = {"fname": fname, "lname": lname, "location": location, "other": "N/A"};
            console.log(jsonString);
        } else {
            var otherString = "";
            const firstArray = outputSplits.slice(0, 3);
            const secondArray = outputSplits.slice(3).reverse();

            /* If the file has 4 or more lines, pop each element off of the array
               until you get to the final three. Format the string with spaces. */
            for (let i = secondArray.length; i > 0; i--) {
                otherString += secondArray.pop() + " ";
            }

            const location = firstArray.pop();
            const lname = firstArray.pop();
            const fname = firstArray.pop();
            const jsonString = {"fname": fname, "lname": lname, "location": location, "other": otherString.trim()};
            console.log(jsonString);
        }
    }
}