/**
 * TEST
 * 
 * @author Ryan Tiffany
 * 
 * @description
 *    This file defines test routes that are likely used for debugging or
 *    validating middleware functionality. These routes provide simple responses
 *    to verify that the server is working correctly and middleware is applied
 *    as expected.
 */

import express from "express";
const router = express.Router();
import authMiddleware from "../middleware/auth.js";

router.get("/test", async (req, res) => {
  return res.json({
    key: "value",
  });
});

router.get("/test-middleware", authMiddleware, async (req, res) => {
  return res.json({
    key: "value",
    isAuthenticated: true,
  });
});

export default router;