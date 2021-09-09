import React from 'react'
import { useState, useEffect } from 'react';

function Post() {
    const [posts, setPosts] = useState([]);

    useEffect(() => {
        fetch("https://jsonplaceholder.typicode.com/posts")
            .then(res => res.json())
            .then((result) => {
                setPosts(result);
            });
    });

    return (
        <div>
            <h2>Posts Data</h2>
            <table border="1">
                <thead>
                    <tr><th>UserID</th><th>ID</th><th>title</th><th>body</th></tr>
                </thead>
                <tbody>
                    {posts.map(post => (
                        <tr key={post.userId}>
                            <td>{post.userId}</td>
                            <td>{post.id}</td>
                            <td>{post.title}</td>
                            <td>{post.body}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default Post
