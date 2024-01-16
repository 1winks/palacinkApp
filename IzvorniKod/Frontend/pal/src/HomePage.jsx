// HomePage.jsx
import React, { useState } from 'react';
import Header from './components/Header';
import axios from 'axios';
import {Link} from "react-router-dom";

const HomePage = (props) => {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;



    return (
        <div className="page-container">
            <Header isLoggedIn={isLoggedIn} onLogout={onLogout} />
            <main className="main-content">
                {isLoggedIn ? (
                    <div className="image">
                        <div className="text">
                            <h1>Dobrodošli!</h1>
                            <Link to="/addDodatak"> Dodajte dodatak</Link>
                            <Link to="/addPancake"> Dodajte palacinku</Link>
                        </div>
                    </div>
                ) : (
                    <div className="image">
                        <div className="text">
                            <h1>Dobrodošli!</h1>
                            <div>
                                <Link to="/login"> Prijavite se</Link>.
                            </div>
                            <div>
                                Nemate račun? <Link to="/register">Registrirajte se</Link>.
                            </div>
                        </div>
                    </div>
                )}
            </main>
        </div>
    );
};

export default HomePage;