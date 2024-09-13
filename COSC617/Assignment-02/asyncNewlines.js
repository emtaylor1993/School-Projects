/**
 * asyncNewlines.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will use a single asynchronous function to read in
 *    a file and print out the number of new line characters it has
 *    to stdout.
 * 
 * @usage
 *    node asyncNewlines.js <filename>
 */

const fs = require("fs");

if (process.argv.length != 3) {
    console.log("There should be three arguments.");
} else {
    fs.readFile(process.argv[2], "utf8", (err, data) => {
        if (err) {
            console.err(err);
            return;
        } 

        const dataSplits = data.split("\n");
        console.log("There are " + (dataSplits.length - 1) + " newline characters.");
    });
}