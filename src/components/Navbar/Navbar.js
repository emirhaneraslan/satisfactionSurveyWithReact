import React, { useState } from "react";
import "./Navbar.css";
import {useNavigate} from 'react-router-dom'
const Navbar = () => {
  const navigate = useNavigate()
  const [isOpen, setIsOpen] = useState(false);
  return (
    <div className="Navbar">
      <a onClick={()=> {
          navigate('/firstpage')
        }}  className="nav-logo">ERASLAN</a>

      <div className={`nav-items ${isOpen && "open"}`}>
        <a onClick={()=> {
          navigate('/surveypage')
        }} className="nav-option">SURVEYS</a>

        <a onClick={()=>{
          navigate('/contact')
        }} className="nav-option">CONTACT</a>

        <a onClick={()=>{
          localStorage.setItem('isEntered',false)
          navigate('/')
        }} className="nav-option">EXİT</a>
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