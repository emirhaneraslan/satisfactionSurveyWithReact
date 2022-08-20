import React, { useState } from "react";
import "./Navbar.css";
import {useNavigate} from 'react-router-dom'

const Navbar = () => {
  const navigate = useNavigate()
  const [isOpen, setIsOpen] = useState(false);
  return (
    <div className="Navbar">
      <a className="nav-logo" onClick={()=>{
        navigate('/admin')
      }}>ERASLAN</a>
      <div className={`nav-items ${isOpen && "open"}`}>
        
        <a className="nav-option" onClick={()=>{
          navigate('/userlist')
        }}>USER MANAGEMENT SYSTEM</a>
        
        <a className="nav-option" onClick={()=>{
          navigate('/createsurvey')
        }}>CREATE SURVEY</a>
      </div>
      <div
        className={`nav-toggle ${isOpen && "open"}`}
        onClick={() => setIsOpen(!isOpen)}
      >
        <div className="bar"></div>
      </div>
    </div>
  );
};

export default Navbar;