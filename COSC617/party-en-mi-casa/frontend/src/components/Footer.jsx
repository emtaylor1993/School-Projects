/**
 * Footer.jsx
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This file defines a reusable footer component styled with a retro
 *    8-bit design.
 */

import React from "react";
import "../styles/Footer.css";

const Footer = ({ children }) => {
  return <footer className="footer">{children}</footer>;
};

export default Footer;