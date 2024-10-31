import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Article from './Article';

function App() {
    const [articles, setArticles] = useState([]);

    // Fetch articles from the JSON endpoint
    useEffect(() => {
        axios.get('https://www.jalirani.com/files/barstool.json')
            .then(response => {
                console.debug(response.data);
                setArticles(response.data);
            })
            .catch(error => console.error('Error fetching data:', error));
    }, []);

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