import React from 'react';
import { Link } from 'react-router-dom';
import './Sidebar.css'; // Make sure to create a corresponding CSS file for styling

const Sidebar = ({ onLogout, className }) => {
    return (
        <div className={`sidebar ${className}`}>
            <Link to="/">Home page</Link>
            <Link to="/addDodatak">Dodaj Dodatak</Link>
            <Link to="/addPancake">Dodaj Palacinku</Link>
            <Link to="/popisDodatak">Popis Dodataka</Link>
            <Link to="/popisPalacinki">Popis Palacinki</Link>
            <Link to="/naruci">Ponuda</Link>
            <button onClick={onLogout}>Logout</button>
        </div>
    );
};

export default Sidebar;