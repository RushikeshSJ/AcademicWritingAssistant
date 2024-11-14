import React, { useState } from 'react';
import InputForm from './components/InputForm';
import SuggestionDisplay from './components/SuggestionDisplay';
import HistoryList from './components/HistoryList';
import './styles.css'; // Import CSS file

const HomePage = () => {
    const [suggestion, setSuggestion] = useState("");

    return (
        <div className="container">
            <h1>Academic Writing Assistant</h1>
            <InputForm setSuggestion={setSuggestion} />
            <SuggestionDisplay suggestion={suggestion} />
            <HistoryList />
        </div>
    );
};

export default HomePage;
