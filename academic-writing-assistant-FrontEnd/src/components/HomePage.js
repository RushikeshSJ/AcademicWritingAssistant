import React, { useState } from 'react';
import InputForm from './InputForm';
import SuggestionDisplay from './SuggestionDisplay';
import HistoryList from './HistoryList';

const HomePage = () => {
    const [suggestion, setSuggestion] = useState("");

    return (
        <div>
            <h1>Academic Writing Assistant</h1>
            <InputForm setSuggestion={setSuggestion} />
            <SuggestionDisplay suggestion={suggestion} />
            <HistoryList />
        </div>
    );
};

export default HomePage;
