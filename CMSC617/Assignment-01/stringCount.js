/**
 * stringCount.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will read input from a text file from the command line and
 *    return the total number of occurrences that the file contains.
 */

const fs = require("fs");
const buffer = fs.readFileSync(process.argv[2]);
const output = buffer.toString();
var count = 0;

const outputSplits = output.split(" ");

/* Goes through each element of the array, formats them to lower case 
   and checks whether each of the necessary words are found. */
outputSplits.forEach(function(element) {
    switch(element.toLowerCase()) {
        case "towson":
            count = count + 1;
            break;
        case "cis":
            count = count + 1;
            break;
        case "web":
            count = count + 1;
            break;
        case "development":
            count = count + 1;
            break;
        default:
            break;
    }
});

console.log(`The total number of occurrences is: ${count}`);