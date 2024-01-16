import React, { useEffect, useState } from 'react';
import Header from "./Header";
import axios from "axios";
import Cookies from "js-cookie";
import "./Ponuda.css";


function Ponuda( props ) {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;
    const [palacinke, setPalacinke] = useState([]);

    useEffect(() => {
        const fetchPalacinke = async () => {
            try {
                const token = localStorage.getItem('jwtToken');
                const response = await axios.get('http://localhost:8080/api/resursi/palacinke', {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                setPalacinke(response.data);
            } catch (error) {
                console.error('Error fetching pancake data:', error);
            }
        };

        fetchPalacinke();
    }, []);

    const orderPancake = async (pancakeId) => {
        // Implement the logic to order a pancake
        // This might involve sending a POST request to your orders API
        try {
            const token = localStorage.getItem('jwtToken');
            await axios.post('http://localhost:8080/api/resursi/narudzbe/add', { pancakeId }, {
                headers: {
                    'Authorization': `Bearer ${token}`
                }
            });
            alert('Palacinka narucena!');
        } catch (error) {
            console.error('Error ordering pancake:', error);
        }
    };



    return (
        <div className="ponuda-container">
            <Header isLoggedIn={isLoggedIn} onLogout={onLogout} />
            <h2>Ponuda Palacinki</h2>
            <ul className="palacinke-list">
                {palacinke.map(pancake => (
                    <li key={pancake.id} className="palacinka-item">
                        {pancake.imePalacinke} - {pancake.cijenaPalacinke} kn
                        <button onClick={() => orderPancake(pancake.id)}>Naruci</button>
                    </li>
                ))}
            </ul>
        </div>
    );
}

export default Ponuda;
