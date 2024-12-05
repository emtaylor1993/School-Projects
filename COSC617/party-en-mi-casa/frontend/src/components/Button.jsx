/**
 * Button.jsx
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This file defines a reusable button component styled with a retro
 *    8-bit design.
 */

import React from "react";
import "../styles/Button.css";

function Button({ label, className, onClick }) {
  return (
    <button className={`eight-bit-button ${className}`} onClick={onClick}>
      {label}
    </button>
  );
}

export default Button;