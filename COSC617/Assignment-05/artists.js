/**
 * artists.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will serve JSON data when a GET request is received on
 *    three separate endpoints.
 * 
 * @usage
 *    node artists.js Tupac Eminem
 */

const fs = require("fs");
const cheerio = require("cheerio");
const request = require("request");
const nodeMailer = require("nodemailer");

const URL = "http://www.popvortex.com/music/charts/top-rap-songs.php";
const TOP_NUM = 25;

var titles = [];
var artists = [];
var userArtists = [];
var combinedArray = [];

if (process.argv.length > 2) {
    // Create an array of artist(s) the user wants to search songs for.
    process.argv.slice(2, process.argv.length).forEach(function(element) {
        userArtists.push(element);
    });

    // Makes a request to the URL specified above.
    request(URL, function(error, response, html) {
        if (!error && response.statusCode == 200) {
            var $ = cheerio.load(html);

            // Creates an array of the top 25 song titles.
            $("cite.title").each(function(i, element) {
                if (i < TOP_NUM) {
                    titles.push($(this).text());
                }
            });

            // Creates an array of the top 25 artists associated with the song title above.
            $("em.artist").each(function(i, element) {
                if (i < TOP_NUM) {
                    artists.push($(this).text());
                }
            });

            if (userArtists.length > 0) {
                userArtists.forEach(function(first_element) {
                    // Check whether or not the user's artists appear in the list of artists.
                    // If so, get the index of the song and add it to the final array.
                    artists.forEach(function(second_element, index) {
                        if (second_element.includes(first_element)) {
                            combinedArray.push(`${second_element}: ${titles[index]}`);
                        }
                    });

                    // Checks whether or not the user's artist appears as a feature in another song.
                    // If so, get the index of the artist and add it to the final array.
                    titles.forEach(function(second_element, index) {
                        if (second_element.includes(first_element)) {
                            combinedArray.push(`${artists[index]}: ${second_element}`);
                        }
                    });
                });

                if (combinedArray.length > 0) {
                    // Format Combined Array to include HTML content.
                    const formattedArray = combinedArray.map(item => {
                        const [artist, title] = item.split(":");
                        return `<li>${artist}: <i>${title.trim()}</i></li>`;
                    }).join("");

                    const jsonData = fs.readFileSync("credentials.json");
                    const data = JSON.parse(jsonData);
                    
                    // Creating the required transported object for sending emails.
                    let transporter = nodeMailer.createTransport({
                        host: "smtp.gmail.com",
                        port: 465,
                        secure: true,
                        auth: {
                            user: data.sender_email,
                            pass: data.sender_password
                        }
                    });

                    // Creating the required mailOptions that takes data from the credentials JSON file.
                    let mailOptions = {
                        from: data.from,
                        to: data.to,
                        subject: `Your artist(s) are: ${userArtists.join(", ")}`,
                        html: `<h2 style="color: black;"><ul style="list-style: none; padding-left: 0;">${formattedArray}</ul></h2>`,
                    };

                    // Sends the email to the recipient.
                    transporter.sendMail(mailOptions, function(error, info) {
                        if (error) {
                            console.log(error);
                        } else {
                            console.log("E-mail Successfully Sent: " + info.response);
                        }
                    });
                } else {
                    console.log("Artist(s) not found.");
                }
            }
        }
    });
} else {
    console.log("No artist(s) specified.");
    console.log("Usage: node artists.js Tupac Eminem");
}
