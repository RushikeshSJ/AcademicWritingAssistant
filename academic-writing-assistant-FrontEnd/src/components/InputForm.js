import React, { useState } from 'react';
import axios from 'axios';

const InputForm = ({ setSuggestion }) => {
    const [input, setInput] = useState("");

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post("http://localhost:8080/api/writing/suggestion", { prompt: input });
            setSuggestion(response.data);
        } catch (error) {
            console.error("Error fetching suggestion:", error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <textarea value={input} onChange={(e) => setInput(e.target.value)} placeholder="Enter your topic or question..." />
            <button type="submit">Get Suggestion</button>
        </form>
    );
};

export default InputForm;
