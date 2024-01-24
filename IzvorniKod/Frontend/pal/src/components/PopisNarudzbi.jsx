import React, { useState, useEffect } from 'react';
import Header from './Header';
import axios from 'axios';
import './AddPancake.css';

const PopisNarudzbi = (props) => {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;
    const [narudzbe, setNarudzbe] = useState([]); // Renamed from palacinke to narudzbe

    useEffect(() => {
        const fetchNarudzbe = async () => {
            try {
                const token = localStorage.getItem('jwtToken');
                const response = await axios.get('http://localhost:8080/api/resursi/narudzbe', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                console.log(response.data);
                setNarudzbe(response.data); // Set the state with the fetched orders
            } catch (error) {
                console.error('Error fetching order data:', error);
            }
        };

        fetchNarudzbe();
    }, []);

    return (
        <div className="ponuda-container">
            <Header isLoggedIn={isLoggedIn} onLogout={onLogout} />
            <h2>Popis Narudžbi</h2>
            <ul className="narudzbe-list">
                {narudzbe.map(narudzba => (
                    <li key={narudzba.id} className="narudzba-item">
                        <h3>Narudžba id: {narudzba.id}</h3>
                        <p>{narudzba.cijenaNarudzbe} eura</p>{/* Assume you have these fields in your order object */}
                        <p>Dostava: {narudzba.dostava ? 'Potrebna dostava' : 'Dostava nije potrebna'}</p>
                        <p>Adresa: {narudzba.adresa}</p>
                        {/* You can add more details here */}

                    </li>
                ))}
            </ul>
        </div>
    );
};

export default PopisNarudzbi;
