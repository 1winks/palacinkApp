import Header from './Header';
import axios from 'axios';
import { useState } from "react"; // Ensure you have this CSS file for styling
import './AddPancake.css';

const AddPancake = (props) => {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;
    const [imePalacinke, setImePalacinke] = useState('');
    const [cijenaPalacinke, setCijenaPalacinke] = useState('');

    async function save(event) {
        event.preventDefault();
        const token = localStorage.getItem('jwtToken');
        try {
            console.log("Submitting:", imePalacinke, cijenaPalacinke);
            await axios.post("http://localhost:8080/api/resursi/palacinke/add", {
                imePalacinke: imePalacinke,
                cijenaPalacinke: cijenaPalacinke,
            }, {
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': `Bearer ${token}`
                },
            });
            alert("Palacinka uspješno dodana!");
        } catch (err) {
            var noviDiv = document.createElement('div');
            noviDiv.className = 'alert-container';
            noviDiv.textContent = err.response?.data.message || "Došlo je do greške";
            var udiv = document.getElementsByClassName('register-container')[0];
            udiv.insertBefore(noviDiv, document.getElementById("moj"));
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
                        <button type="submit">Dodaj</button>
                    </div>
                </form>
            </div>
        </div>
    );
}

export default AddPancake;
