import React from 'react'
import { useState, useEffect } from 'react'

function TrackServiceRequest() {
    const [todos, setTodos] = useState([])

    useEffect( ()=> {
        fetch("https://jsonplaceholder.typicode.com/todos")
        .then(res => res.json())
        .then((result) => {
            setTodos(result);
        });
    });

    return (
        <div>
            <h2>Todo Data</h2>
            <table border="1">
                 <thead>
                     <tr><th>UserID</th><th>ID</th><th>title</th><th>completed</th></tr>
                 </thead>
                 <tbody>
                     {todos.map( todo => (
                         <tr key={todo.userId}>
                             <td>{todo.userId}</td>
                             <td>{todo.id}</td>
                             <td>{todo.title}</td>
                             <td>{todo.completed}</td>
                         </tr>
                      ))}
                 </tbody>
             </table>

        </div>
    )
}

export default TrackServiceRequest
