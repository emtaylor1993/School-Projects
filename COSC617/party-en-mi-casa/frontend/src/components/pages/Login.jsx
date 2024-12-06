/**
 * Login.jsx
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This component defines the login page where users can authenticate by
 *    providing their username and password. It performs client-side validation,
 *    interacts with the backend API for authentication, and redirects the user
 *    upon successful login.
 */

import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Footer from "../Footer.jsx";
import "../../styles/Login.css";
import "../../styles/App.css";

const API_BASE_URL = "http://localhost:3002/api";
const ENDPOINTS = {
  login: `${API_BASE_URL}/login`,
  signup: `${API_BASE_URL}/signup`,
  user: `${API_BASE_URL}/user`
};

const loginUser = async (username, password) => {
  const response = await fetch(ENDPOINTS.login, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ username, password }),
  });
  return await response.json();
};

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (event) => {
    event.preventDefault();
    setErrorMessage("");

    try {
      const data = await loginUser(username, password);

      if (data.success) {
        localStorage.setItem("token", data.token);
        localStorage.setItem("username", data.user.username);
        navigate("/home");
      } else {
        setErrorMessage(data.message || "Login failed");
      }
    } catch (error) {
      setErrorMessage("An error occurred during login");
    }
  };

  return (
    <div className="login-container">
      <div className="flashing-text">Party En Mi Casa</div>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="username">Username:</label>
          <input
            type="text"
            id="username"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
            maxLength={16}
          />
        </div>
        <div>
          <label htmlFor="password">Password:</label>
          <input
            type="password"
            id="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        {errorMessage && <p className="error-message">{errorMessage}</p>}
        <button type="submit">LOGIN</button>
        <button type="button" onClick={() => navigate("/signup")}>CREATE AN ACCOUNT</button>
      </form>
      <Footer>
        <p style={{ paddingLeft: "2rem" }}>
          partyenmi.casa created as course work for COSC617 at Towson University
        </p>
      </Footer>
    </div>
  );
};

export default Login;