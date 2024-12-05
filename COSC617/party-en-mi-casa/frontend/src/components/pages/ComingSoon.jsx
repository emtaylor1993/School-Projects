/**
 * ComingSoon.jsx
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This component defines a placeholder page for games or features that
 *    are not yet implemented. It provides a simple UI to inform users that the 
 *    feature is under development and offers a button to navigate back to the
 *    home page.
 */

import React from "react";
import { useNavigate } from "react-router-dom";
import Header from "../Header";
import Footer from "../Footer";
import { GiConsoleController } from "react-icons/gi";
import "../../styles/ComingSoon.css";

const ComingSoon = () => {
  const navigate = useNavigate();

  return (
    <div className="coming-soon-container">
      <Header title="COMING SOON" />

      <main className="coming-soon-body">
        <div className="coming-soon-content">
          <GiConsoleController
            size={120}
            className="construction-icon"
          />
          <h1>Game Coming Soon!</h1>
          <button 
            className="back-button-home"
            onClick={() => navigate("/home")}
          >
            Back to Home
          </button>
        </div>
      </main>

      <Footer>
        <p style={{ paddingLeft: "2rem" }}>
          partyenmi.casa created as course work for COSC617 at Towson University
        </p>
      </Footer>
    </div>
  );
};

export default ComingSoon;