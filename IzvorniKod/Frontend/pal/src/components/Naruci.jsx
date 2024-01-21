import React, { useEffect, useState } from 'react';
import Header from "./Header";
import axios from "axios";
import Cookies from "js-cookie";
import "./Ponuda.css";
import {Link} from "react-router-dom";


function Naruci( props ) {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;
    const [palacinke, setPalacinke] = useState([]);
    const [kosarica, setKosarica] = useState([]);
    const [adresa, setAdresa] = useState('');
    const [dostava, setDostava] = useState(true);

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

    const dodajUKosaricu = (pancake) => {
        const novaStavka = {
            ime: pancake.imePalacinke,
            cijena: pancake.cijenaPalacinke,
            kolicina: 1 // pretpostavljamo da po defaultu dodajemo jednu palačinku
        };

        // Provjeravamo postoji li već palačinka u košarici
        const postojecaStavka = kosarica.find(stavka => stavka.ime === novaStavka.ime);

        if (postojecaStavka) {
            // Ako postoji, samo povećavamo količinu
            setKosarica(kosarica.map(stavka =>
                stavka.ime === novaStavka.ime ? { ...stavka, kolicina: stavka.kolicina + 1 } : stavka
            ));
        } else {
            // Ako ne postoji, dodajemo novu stavku u košaricu
            setKosarica([...kosarica, novaStavka]);
        }
    };

    const izracunajUkupnuCijenu = () => {
        const ukupnaCijena = kosarica.reduce((ukupno, stavka) => ukupno + stavka.cijena * stavka.kolicina, 0);
        return ukupnaCijena;
    };

    const posaljiNarudzbu = async () => {
        try {
            const narudzba = {
                ukupnaCijena: izracunajUkupnuCijenu(),
                adresaDostave: adresa,
                opcijaDostave: dostava,
            };
            console.log("Podaci koji se šalju:", narudzba);
            const token = localStorage.getItem('jwtToken');
            await axios.post('http://localhost:8080/api/resursi/narudzbe/add', narudzba, {
                headers: {
                    'Authorization': `Bearer ${token}`,
                    'Content-Type': 'application/json'
                }
            });
            alert("Narudžba poslana!");
            setKosarica([]);
            setAdresa('');
        } catch (error) {
            console.error('Greška prilikom slanja narudžbe:', error);
            alert("Došlo je do greške prilikom slanja narudžbe.");
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
                        <button onClick={() => dodajUKosaricu(pancake)}>Dodaj u košaricu</button>
                    </li>
                ))}
            </ul>
            <div className="kosarica">
                <h3>Košarica</h3>
                <ul>
                    {kosarica.map(stavka => (
                        <li key={stavka.ime}>{stavka.ime} - {stavka.kolicina}x - {stavka.cijena} kn</li>
                    ))}
                </ul>
                <p>Ukupna cijena: {izracunajUkupnuCijenu()} kn</p>
                {izracunajUkupnuCijenu() > 0 && (
                    <>
                        <div className="narudzba-forma">
                            <input
                                type="text"
                                placeholder="Unesite adresu dostave"
                                value={adresa}
                                onChange={(e) => setAdresa(e.target.value)}
                            />
                            <label>
                                <input
                                    type="radio"
                                    name="dostava"
                                    checked={dostava}
                                    onChange={() => setDostava(true)}
                                />
                                Dostava
                            </label>
                            <label>
                                <input
                                    type="radio"
                                    name="dostava"
                                    checked={!dostava}
                                    onChange={() => setDostava(false)}
                                />
                                Preuzimanje
                            </label>
                        </div>
                        <button onClick={posaljiNarudzbu} className="auth-button">Naručite!</button>
                    </>
                )}
            </div>
        </div>
    );
}

export default Naruci;