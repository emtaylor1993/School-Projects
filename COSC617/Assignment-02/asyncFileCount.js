/**
 * asyncFileCount.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will read the contents of a directory, and return
 *    the number of files present of a certain extension.
 * 
 * @usage
 *    node asyncFileCount.js <directory> <extension>
 */

const fs = require("fs");
const path = require("path");

if (process.argv.length != 4) {
    console.log("There should be at four arguments.");
} else {
    fs.readdir(process.argv[2], "utf8", (err, data) => {
        if (err) {
            console.error(err);
        }

        var filteredFiles = []

        data.forEach(function(element) {
            if (process.argv[3] == path.extname(element)) {
                filteredFiles.push(element);
            }
        });

        console.log(filteredFiles);
    });
}