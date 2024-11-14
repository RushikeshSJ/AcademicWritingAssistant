import React, { useEffect, useState } from 'react';
import axios from 'axios';

const HistoryList = () => {
    const [history, setHistory] = useState([]);

    useEffect(() => {
        const fetchHistory = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/writing/history");
                setHistory(response.data);
            } catch (error) {
                console.error("Error fetching history:", error);
            }
        };
        fetchHistory();
    }, []);

    return (
        <div>
            <h2>History</h2>
            <ul>
                {history.map((entry, index) => (
                    <li key={index}>
                        <p><strong>Input:</strong> {entry.userInput}</p>
                        <p><strong>Response:</strong> {entry.response}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default HistoryList;
