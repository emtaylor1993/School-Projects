/**
 * reddit.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will test the student's ability to use Node's
 *    lodash dependency.
 * 
 * @usage
 *    node reddit.js <filename>
 */

const fs = require("fs");
const _ = require("lodash");
const data = JSON.parse(fs.readFileSync(process.argv[2], "utf8"));

console.log("Part 1:");
const usernames = _.map(data, "username");
console.log(usernames);

console.log("---------------")
console.log("Part 2:");
const groupedNames = _.groupBy(data, "username");
console.log(groupedNames);

console.log("---------------")
console.log("Part 3:");
const uniqueNames = _.uniq(_.map(data, "username"));
console.log(uniqueNames);

console.log("---------------")
console.log("Part 4:");
const sortedNames = _.orderBy(data, "username", ["asc"]);
console.log(sortedNames);