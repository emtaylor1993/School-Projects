/**
 * ufc.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file demonstrates the use of GraphQL to query a fighters from a set
 *    of JSON data. Users can query based on the fighter's name or the fighter's
 *    weight class.
 * 
 * @usage
 *    node ufc.js
 */

const express = require('express');
const { graphqlHTTP } = require('express-graphql');
const { buildSchema } = require('graphql');

// Data for 20 UFC fighters to be queried.
const fighters = [
    {
        firstName: "Jon",
        lastName: "Jones",
        nickname: "Bones",
        wins: 27,
        losses: 1,
        height: 1.93,
        weightClass: "Light Heavyweight",
        location: "Rochester, NY"
    },
    {
        firstName: "Israel",
        lastName: "Adesanya",
        nickname: "The Last Stylebender",
        wins: 24,
        losses: 2,
        height: 1.93,
        weightClass: "Middleweight",
        location: "Auckland, New Zealand"
    },
    {
        firstName: "Alexander",
        lastName: "Volkanovski",
        nickname: "The Great",
        wins: 26,
        losses: 2,
        height: 1.68,
        weightClass: "Featherweight",
        location: "Shellharbour, Australia"
    },
    {
        firstName: "Kamaru",
        lastName: "Usman",
        nickname: "The Nigerian Nightmare",
        wins: 20,
        losses: 3,
        height: 1.83,
        weightClass: "Welterweight",
        location: "Auchi, Nigeria"
    },
    {
        firstName: "Francis",
        lastName: "Ngannou",
        nickname: "The Predator",
        wins: 17,
        losses: 3,
        height: 1.93,
        weightClass: "Heavyweight",
        location: "Batie, Cameroon"
    },
    {
        firstName: "Dustin",
        lastName: "Poirier",
        nickname: "The Diamond",
        wins: 29,
        losses: 7,
        height: 1.75,
        weightClass: "Lightweight",
        location: "Lafayette, LA"
    },
    {
        firstName: "Charles",
        lastName: "Oliveira",
        nickname: "Do Bronx",
        wins: 34,
        losses: 9,
        height: 1.78,
        weightClass: "Lightweight",
        location: "Sao Paulo, Brazil"
    },
    {
        firstName: "Max",
        lastName: "Halloway",
        nickname: "Blessed",
        wins: 24,
        losses: 7,
        height: 1.8,
        weightClass: "Featherweight",
        location: "Waianae, HI"
    },
    {
        firstName: "Robert",
        lastName: "Whittaker",
        nickname: "The Reaper",
        wins: 24,
        losses: 6,
        height: 1.83,
        weightClass: "Middleweight",
        location: "Sydney, Australia"
    },
    {
        firstName: "Justin",
        lastName: "Gaethj",
        nickname: "The Highlight",
        wins: 24,
        losses: 4,
        height: 1.8,
        weightClass: "Lightweight",
        location: "Stafford, AZ"
    },
    {
        firstName: "Zhang",
        lastName: "Weili",
        nickname: "Magnum",
        wins: 23,
        losses: 3,
        height: 1.63,
        weightClass: "Strawweight",
        location: "Hebei, China"
    },
    {
        firstName: "Amanda",
        lastName: "Nunes",
        nickname: "The Lioness",
        wins: 23,
        losses: 5,
        height: 1.73,
        weightClass: "Bantamweight",
        location: "Salvador, Brazil"
    },
    {
        firstName: "Stipe",
        lastName: "Miocic",
        nickname: "N/A",
        wins: 20,
        losses: 4,
        height: 1.93,
        weightClass: "Heavyweight",
        location: "Cleveland, OH"
    },
    {
        firstName: "Jan",
        lastName: "Blachowicz",
        nickname: "Prince of Cieszyn",
        wins: 29,
        losses: 9,
        height: 1.88,
        weightClass: "Light Heavyweight",
        location: "Cieszyn, Poland"
    },
    {
        firstName: "Colby",
        lastName: "Covington",
        nickname: "Chaos",
        wins: 17,
        losses: 3,
        height: 1.8,
        weightClass: "Welterweight",
        location: "Clovis, CA"
    },
    {
        firstName: "Valentina",
        lastName: "Shevchenko",
        nickname: "Bullet",
        wins: 23,
        losses: 4,
        height: 1.65,
        weightClass: "Flyweight",
        location: "Bishkek, Kyrgyzstan"
    },
    {
        firstName: "Jorge",
        lastName: "Masvidal",
        nickname: "Gamebred",
        wins: 35,
        losses: 16,
        height: 1.8,
        weightClass: "Welterweight",
        location: "Miami, FL"
    },
    {
        firstName: "Jose",
        lastName: "Aldo",
        nickname: "Junior",
        wins: 31,
        losses: 8,
        height: 1.7,
        weightClass: "Bantamweight",
        location: "Manaus, Brazil"
    },
    {
        firstName: "Paulo",
        lastName: "Costa",
        nickname: "The Eraser",
        wins: 13,
        losses: 2,
        height: 1.85,
        weightClass: "Middleweight",
        location: "Belo Horizonte, Brazil"
    },
    {
        firstName: "Gilbert",
        lastName: "Burns",
        nickname: "Durinho",
        wins: 20,
        losses: 5,
        height: 1.78,
        weightClass: "Welterweight",
        location: "Niteroi, Brazil"
    }
];

// SDL for GraphQL Schema for fighters.
const schema = buildSchema(`
    type Fighter {
        firstName: String!
        lastName: String!
        nickname: String!
        wins: Int!
        losses: Int!
        height: Float!
        weightClass: String!
        location: String!
    }

    type Query {
        getByName(firstName: String!, lastName: String!): Fighter
        getByWeightClass(weightClass: String!): [Fighter]
    }
`);

// Root resolver for getting fighters by name and weight class.
const root = {
    getByName: ({ firstName, lastName }) => {
        return fighters.find(fighter =>
            fighter.firstName === firstName && fighter.lastName === lastName
        );
    },
    getByWeightClass: ({ weightClass }) => {
        return fighters.filter(fighter => fighter.weightClass === weightClass);
    }
};

const app = express();

app.use('/testgraphql', graphqlHTTP({
    schema: schema,
    rootValue: root,
    graphiql: true
}));

app.listen(3000, () => console.log('GraphQL Server is now running on https://localhost:3000/testgraphql.'));