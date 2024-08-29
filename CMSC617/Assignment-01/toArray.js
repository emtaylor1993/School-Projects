/**
 * toArray.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will read in numbers from the command line and 
 *    add only the even numbers to an array. The array's size
 *    and contents will be printed out in order.
 */

const evenArray = [];
var arrayString = "";

/* Begin placing only even parameters into an array. */
for (let i = 2; i < process.argv.length; i++) {
    if (process.argv[i] % 2 == 0) {
        evenArray.push(process.argv[i]);
    }
}

/* Appends each even element of the array into a string. */
evenArray.forEach(function(element) {
    arrayString += element + ",";
});

/* Removing the last occurrence of the comma. */
lastOccurence = arrayString.lastIndexOf(",");
var finalArrayString = arrayString.substring(0, lastOccurence) + arrayString.substring(lastOccurence + 1);

console.log("The array contains: " + finalArrayString);
console.log("The length of the array is: " + evenArray.length);