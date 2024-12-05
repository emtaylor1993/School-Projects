/**
 * main.jsx
 * 
 * @author Vincent Gruse
 * @author Andy Nguyen
 * 
 * @description
 *    The entry point for the React application. It initializes the app,
 *    renders the root component, and applies global styles.
 */

import { StrictMode } from "react";
import { createRoot } from "react-dom/client";
import App from "./components/App.jsx";
import "./index.css";

createRoot(document.getElementById("root")).render(
  <StrictMode>
    <App />
  </StrictMode>,
);