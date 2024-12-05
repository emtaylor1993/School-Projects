/**
 * Join.jsx
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This component defines the page where users can enter a room code to join
 *    an existing room. It verifies the room's existence, manages form state, 
 *    and handles navigation upon success or failure.
 */

import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import Header from "../Header.jsx";
import "../../styles/Join.css";

const API_BASE_URL = "http://localhost:3002/api";

const Join = () => {
  const navigate = useNavigate();
  const [formState, setFormState] = useState({
    roomCode: "",
    errorMessage: "",
    successMessage: ""
  });

  const updateFormState = (updates) => {
    setFormState(prev => ({ ...prev, ...updates }));
  };

  const clearMessages = () => {
    updateFormState({ errorMessage: "", successMessage: "" });
  };

  const verifyRoom = async (token) => {
    try {
      const response = await fetch(`${API_BASE_URL}/room/${formState.roomCode}`, {
        headers: { Authorization: `Bearer ${token}` }
      });
  
      if (!response.ok) {
        const text = await response.text();
  
        if (response.status === 404) {
          throw new Error("Room not found. Please check the room code.");
        }
        throw new Error("Failed to verify room");
      }
    } catch (error) {
      throw error;
    }
  };
  
  const joinRoom = async (token) => {
    try {
      const response = await fetch(`${API_BASE_URL}/room/${formState.roomCode}/join`, {
        method: "POST",
        headers: {
          Authorization: `Bearer ${token}`,
          'Content-Type': 'application/json'
        }
      });
  
      if (!response.ok) {
        const text = await response.text();
        
        throw new Error("Failed to join room");
      }
    } catch (error) {
      console.error('Full error:', error);
      throw error;
    }
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    clearMessages();

    const token = localStorage.getItem('token');
    if (!token) {
      updateFormState({ errorMessage: "Please log in to join a room" });
      navigate('/login');
      return;
    }

    try {
      await verifyRoom(token);
      await joinRoom(token);
      
      updateFormState({ successMessage: "Joined room successfully!" });
      navigate(`/room/${formState.roomCode}`);
    } catch (error) {
      console.error("Error:", error);
      updateFormState({ 
        errorMessage: error.message || "Failed to join the room. Please check your connection." 
      });
    }
  };

  useEffect(() => {
    const token = localStorage.getItem('token');
    if (!token) {
      navigate('/login');
    }
  }, [navigate]);

  return (
    <div className="join-container">
      <Header title="Join a Room" />
      <form onSubmit={handleSubmit} className="join-form">
        <div className="form-group">
          <label>Room Code:</label>
          <input
            type="text"
            id="roomCode"
            value={formState.roomCode}
            onChange={(e) => updateFormState({ 
              roomCode: e.target.value.toUpperCase() 
            })}
            required
            maxLength={4}
            placeholder="Enter room code"
            className="room-code-input"
          />
        </div>

        {formState.errorMessage && (
          <p className="error-message">{formState.errorMessage}</p>
        )}
        {formState.successMessage && (
          <p className="success-message">{formState.successMessage}</p>
        )}
        
        <button className="join-button" type="submit">
          Join Room
        </button>
      </form>
    </div>
  );
};

export default Join;