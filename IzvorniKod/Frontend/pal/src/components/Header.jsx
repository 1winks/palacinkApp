// Header.jsx
import React, {useState} from 'react';
import { Link } from 'react-router-dom';
import "./Header.css";
import Sidebar from "./Sidebar";
//import Sidebar from './Sidebar'

const Header = (props) => {
    const isLoggedIn = props.isLoggedIn;
    const onLogout = props.onLogout;
    const name = localStorage.getItem('username'); // Assuming you store the username in localStorage
    const [sidebarOpen, setSidebarOpen] = useState(false); // State to handle sidebar visibility

    const toggleSidebar = () => {
        setSidebarOpen(!sidebarOpen); // Toggle the state
    };

    return (
        <header className="Header">
            {isLoggedIn ? (
                <div className="Header">
                    <button onClick={toggleSidebar}>☰</button> {/* Sidebar toggle button */}
                    {sidebarOpen && <Sidebar onLogout={onLogout} className="open" />}
                    {/* Render Sidebar conditionally based on state */}
                    <div className="LoggedIn">Pozdrav, {name}! Ulogirani ste u sustav.</div>
                    <div className="LoggedIn"><button onClick={onLogout}>Logout</button></div>
                </div>
            ) : (
                <div>
                    <Link to="/register">
                        <button>Register</button>
                    </Link>
                    <Link to="/login">
                        <button>Login</button>
                    </Link>
                </div>
            )}
        </header>
    );
};

export default Header;