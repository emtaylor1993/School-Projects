/**
 * Signup.jsx
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This component defines the signup page where users can create an account
 *    by providing their username, email, password, and an optional avatar image.
 *    It performs client-side validations and handles API communication to register
 *    the user.
 */

import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import PixelArtConverter from "../PixelArtConverter";
import "../../styles/Signup.css";

const Signup = () => {
  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [avatar, setAvatar] = useState(null);
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleImageConverted = (convertedImage) => {
    setAvatar(convertedImage);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setError(""); // Clear any previous errors

    // Validation checks
    if (username.length < 4 || username.length > 16) {
      setError("Username must be 1-16 characters.");
      return;
    }

    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d).{6,}$/;
    if (!passwordRegex.test(password)) {
      setError(
        "Password must be at least 6 characters and include 1 lowercase, 1 uppercase, and 1 number."
      );
      return;
    }

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!emailRegex.test(email)) {
      setError("Invalid email format.");
      return;
    }

    // Convert username and email to lowercase
    const lowercasedUsername = username.toLowerCase();
    const lowercasedEmail = email.toLowerCase();

    try {
      // Prepare the data to send
      const signupData = {
        username: lowercasedUsername,
        email: lowercasedEmail,
        password,
        avatar: avatar
      };

      const response = await axios.post(
        "http://localhost:3002/api/signup", 
        signupData,
        {
          headers: {
            'Content-Type': 'application/json'
          }
        }
      );

      // Handle successful signup
      console.log("Signup successful", response.data);
      navigate("/login");

    } catch (error) {
      // Handle signup errors
      console.error("Error during signup:", error);
      
      if (error.response) {
        setError(error.response.data.message || "Signup failed. Please try again.");
      } else if (error.request) {
        setError("No response from server. Please check your connection.");
      } else {
        setError("Signup failed. Please try again.");
      }
    }
  };

  return (
    <div className="signup-container">
      <h1>Signup</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Username:</label>
          <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Email:</label>
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            required
          />
        </div>
        <div>
          <label>Avatar:</label>
          <PixelArtConverter onImageConverted={handleImageConverted} />
        </div>
        {error && <p style={{ color: "red" }}>{error}</p>}
        <button type="submit">Create Account</button>
        <p>
          Already have an account? <a href="/login">Login</a>
        </p>
      </form>
    </div>
  );
};

export default Signup;