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
const buffer = fs.readFileSync("partOne.txt");
var output = buffer.toString();

if (process.argv.length < 3) {
    console.log("There should be a minimum of three arguments.");
} else if (output.split("\n").length < 3) {
    console.log("There should be a mininum of three lines in the file.");
} else {
    const outputSplits = output.split("\n");
    if (outputSplits.length == 3) {
        const location = outputSplits.pop();
        const lname = outputSplits.pop();
        const fname = outputSplits.pop();
        const jsonString = `{"fname": "${fname}", "lname": "${lname}", "location": "${location}", "other": "N/A"}`;
        console.log(jsonString);
    } else {
        console.log(outputSplits.pop());
    }
}