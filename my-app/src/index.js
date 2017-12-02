import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import registerServiceWorker from './registerServiceWorker';

ReactDOM.render(<App />, document.getElementById('root'));
registerServiceWorker();

const emojiSearch = require('bobby-emoji-search');
console.log(emojiSearch.findEmojis("Hello 🐼! What's up? ✌️"));