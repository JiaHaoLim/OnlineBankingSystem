import React, {useState, useEffect} from 'react';
import axios from "axios";

function ViewStatements() {
    // const [data, setData] = useState([]);
    const [data, setData] = useState(null); 
    const [loading, setLoading] = useState(true); 
    const [error, setError] = useState(null);

    useEffect(() => { 
        axios({
            method: "get",
            url: "https://jsonplaceholder.typicode.com/posts",
             // testing option 1: https://randomuser.me/api 
             // testing option 2: https://jsonplaceholder.typicode.com/posts 
             // our goal is "http://localhost:9090/transactions"
            params:{
                _limit: 10,
            },
        }) 
          .then((response) => { 
            setData(response.data); 
          }) 
          .catch((error) => { 
            console.error("Error fetching data: ", error); 
            setError(error); 
          }) 
          .finally(() => { 
            setLoading(false); 
          }); 
      }, []); 

    if (loading) return "Loading...";
    if (error) return "Error!";

    return (
        <div>
            <h2>Mini Statement</h2>
            <h2>Last 10 transactions</h2>
            <table border="1">
                <thead>
                    <tr><th>Date</th><th>Transaction Details</th><th>Deposit Amount</th><th>Withdrawal Amount</th><th>Balance</th></tr>
                </thead>
                <tbody>
                    {data.map(data => (
                        <tr key={data.userId}>
                            <td>{data.id}</td>
                            <td>{data.title}</td>
                            <td>{data.id}</td>
                            <td>{data.id}</td>
                            <td>{data.id}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default ViewStatements
