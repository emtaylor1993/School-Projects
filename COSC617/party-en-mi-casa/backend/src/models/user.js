/**
 * USER SCHEMA
 * 
 * @author Emmanuel Taylor
 * 
 * @description
 *    This file defines the User model that is being used in Mongoose.
 *    This model is responsible for managing user data within the application.
 */

import mongoose from "mongoose";

const userSchema = new mongoose.Schema({
  username: {
    type: String,
    required: true,
    unique: true,
    trim: true,
    minlength: 4,
    maxlength: 16
  },
  email: {
    type: String,
    required: true,
    unique: true,
    trim: true,
    lowercase: true
  },
  password: {
    type: String,
    required: true
  },
  avatar: {
    type: String,
    default: null
  },
  createdAt: {
    type: Date,
    default: Date.now
  }
}, {
  timestamps: true
});

const User = mongoose.model("User", userSchema);

export default User;