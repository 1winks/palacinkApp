// HomePage.jsx
import React, { useState } from 'react';
import Header from './components/Header';
import axios from 'axios';

const HomePage = (props) => {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;



    return (
        <div className="page-container">
            <Header isLoggedIn={isLoggedIn} onLogout={onLogout} />
            <main className="main-content">
                <h1>Welcome to the Homepage</h1>

                {/* Rest of the main content */}
            </main>
        </div>
    );
};

export default HomePage;