import React from 'react'
import { useState, useEffect } from 'react'

function Album() {
    const [albums, setAlbums] = useState([])

    useEffect( ()=> {
        fetch("https://jsonplaceholder.typicode.com/albums")
        .then(res => res.json())
        .then((result) => {
            setAlbums(result);
        });
    });

    return (
        <div>
            <h2>Album Data</h2>
            <table border="1">
                 <thead>
                     <tr><th>UserID</th><th>ID</th><th>title</th></tr>
                 </thead>
                 <tbody>
                     {albums.map( album => (
                         <tr key={album.userId}>
                             <td>{album.userId}</td>
                             <td>{album.id}</td>
                             <td>{album.title}</td>
                         </tr>
                      ))}
                 </tbody>
             </table>

        </div>
    )
}

export default Album
