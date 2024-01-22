import React, { useState, useEffect } from 'react';
import Header from './Header';
import axios from 'axios';
import './AddPancake.css';

const AddPancake = (props) => {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;
    const [imePalacinke, setImePalacinke] = useState('');
    const [cijenaPalacinke, setCijenaPalacinke] = useState('');
    const [dodatci, setDodatci] = useState([]);
    const [selectedDodatci, setSelectedDodatci] = useState([]);

    useEffect(() => {
        const token = localStorage.getItem('jwtToken');
        const headers = {
            'Authorization': `Bearer ${token}`
        };

        const fetchDodatci = async () => {
            try {
                const response = await axios.get('http://localhost:8080/api/resursi/dodaci', { headers });
                console.log(response.data);
                setDodatci(response.data);
            } catch (error) {
                console.error('Error fetching add-ons data:', error);
            }
        };

        fetchDodatci();
    }, []);

    const handleDodatakChange = (event) => {
        const value = event.target.value;
        setSelectedDodatci(prev => {
            if (prev.includes(value)) {
                return prev.filter(item => item !== value);
            } else {
                return [...prev, value];
            }
        });
    };

    async function save(event) {
        event.preventDefault();
        const token = localStorage.getItem('jwtToken');
        const selectedDodatciForRequest = selectedDodatci.map(dodatakId => {
            const dodatak = dodatci.find(d => d.id.toString() === dodatakId);
            return {
                nazivDodatka: dodatak.nazivDodatka,
                // Convert cijenaDodatka to a float
                cijenaDodatka: parseFloat(dodatak.cijenaDodatka)
            };
        });

        try {
            console.log("Submitting:", imePalacinke, cijenaPalacinke, selectedDodatciForRequest);
            await axios.post("http://localhost:8080/api/resursi/palacinke/add", {
                imePalacinke: imePalacinke,
                cijenaPalacinke: parseFloat(cijenaPalacinke), // Also make sure this is a float if needed
                dodaci: selectedDodatciForRequest
            }, {
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
            });
            alert("Palacinka uspješno dodana!");
        } catch (err) {
            // Error handling
            console.error('Error submitting pancake data:', err);
            // Here you might want to display a user-friendly error message or handle the error in some way
        }
    }

    return (
        <div className="page-container">
            <Header isLoggedIn={isLoggedIn} onLogout={onLogout} />
            <div className="register-container">
                <h2>Dodavanje Palacinke</h2>
                <form onSubmit={save} id="moj">
                    <div className="form-group">
                        <label htmlFor="imePalacinke">Ime Palacinke:</label>
                        <input
                            type="text"
                            id="imePalacinke"
                            value={imePalacinke}
                            onChange={(event) => setImePalacinke(event.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label htmlFor="cijenaPalacinke">Cijena Palacinke:</label>
                        <input
                            type="number"
                            id="cijenaPalacinke"
                            value={cijenaPalacinke}
                            onChange={(event) => setCijenaPalacinke(event.target.value)}
                            required
                        />
                    </div>
                    <div className="form-group">
                        <label>Dodatci:</label>
                        {dodatci.map(dodatak => (
                            <div key={dodatak.id}>
                                <input
                                    type="checkbox"
                                    value={dodatak.id}
                                    onChange={handleDodatakChange}
                                />
                                {dodatak.nazivDodatka}
                            </div>
                        ))}
                    </div>
                    <div className="form-group">
                        <button type="submit">Dodaj</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default AddPancake;
