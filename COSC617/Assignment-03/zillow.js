/**
 * zillow.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will serve JSON data when a GET request is received on
 *    three separate endpoints.
 * 
 * @usage
 *    node zillow.js <PORT>
 */

const express = require("express");
const app = express();

if (process.argv.length != 3) {
    console.log("There should be three arguments.");
    console.log("Usage: node zillow.js <PORT>")
} else {
    const data = [{price: 240000, city: "baltimore"}, {price: 300000, city: "austin"},
        {price: 400000, city: "austin"}, {price: 1000000, city: "seattle"}, {price:
        325000, city: "baltimore"}, {price: 550000, city: "seattle"}, {price: 250000,
        city: "boston"}];

    app.get("/v1/zillow/zestimate", function(req, res) {
        if (!req.query.sqft || !req.query.bed || !req.query.bath) {
            res.status(404).json({msg: "Request is incorrect."});
        } else {
            const calculatedZestimate = req.query.sqft * req.query.bed * req.query.bath * 10;
            res.status(200).json({zestimate: calculatedZestimate});
        }
    });
    
    app.get("/v1/zillow/houses", function(req, res) {
        if (!req.query.city) {
            res.status(200).json({houses: []});
        } else {
            const filteredCities = data.filter(filter => filter.city == req.query.city);
            res.status(200).json({houses: filteredCities});
        }
    });

    app.get("/v1/zillow/prices", function(req, res) {
        if (!req.query.usd) {
            res.status(404).json({msg: "Request is incorrect."});
        } else {
            const filteredPrices = data.filter(filter => filter.price <= req.query.price);
            res.status(200).json({houses: filteredPrices});
        }
    });

    app.use((req, res) => {
        res.status(404).json({ msg: "Request is incorrect."});
    })
}

app.listen(process.argv[2]);