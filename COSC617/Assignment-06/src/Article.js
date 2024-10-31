import React from 'react';

// Article component to display each article's details
function Article({ article }) {
    const {
        title,
        author,
        comment_count,
        url,
        thumbnail,
    } = article;

    // Construct full thumbnail URL
    const thumbnailUrl = thumbnail?.location + thumbnail?.images?.small;

    return (
        <div className="article">
            <a href={url} target="_blank" rel="noopener noreferrer">
                <h2>{title}</h2>
            </a>
            <img src={thumbnailUrl} alt="Article thumbnail" className="article-thumbnail" />
            <div className="author-info">
                <img src={author.avatar} className="author-avatar" />
                <p>{author.name}</p>
            </div>
            <p>Comments: {comment_count}</p>
        </div>
    );
}

export default Article;