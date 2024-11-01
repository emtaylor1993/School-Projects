/**
 * App.js
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file will serve as the Root component of the application. It will
 *    initialize an empty list to hold the articles, use a side effect to fetch
 *    the articles from the JSON endpoint and render 5 Article components with
 *    information on each article.
 * 
 * @usage
 *    npm start
 */

import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Article from './Article';

function App() {
    const [articles, setArticles] = useState([]);

    // Fetch articles from the JSON endpoint using a side effect.
    // Source:https://jasonwatmore.com/post/2020/07/17/react-axios-http-get-request-examples
    useEffect(() => {
        axios.get('https://www.jalirani.com/files/barstool.json')
            .then(response => {
                console.log(response.data);
                setArticles(response.data);
            })
            .catch(error => console.error('Error fetching data:', error));
    }, []);

    // Loops through each article in the list of articles and displays its information.
    return (
        <div className="App">
            <h1>Barstool Sports Archive</h1>
            <div className="article-list">
                {articles.map((article, index) => (
                    <Article key={index} article={article} />
                ))}
            </div>
        </div>
    );
}

export default App;