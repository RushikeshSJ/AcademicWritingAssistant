import React from 'react';

const SuggestionDisplay = ({ suggestion }) => {
    return (
        <div>
            <h2>Suggestion</h2>
            <p>{suggestion}</p>
        </div>
    );
};

export default SuggestionDisplay;
