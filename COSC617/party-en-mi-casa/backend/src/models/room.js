/**
 * ROOM SCHEMA
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This file defines the Room model that is being used in Mongoose.
 *    This model represents a game room where users (fiesteros) can join
 *    and play.
 */

import mongoose from "mongoose";

const roomSchema = new mongoose.Schema({
  code: {
    type: String,
    required: true,
    unique: true
  },
  gameChoice: {
    type: String,
    required: true
  },
  fiesteros: [{
    userId: {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'User'
    },
    username: String,
    avatar: String
  }],
  createdAt: {
    type: Date,
    default: Date.now,
    expires: 86400 // Auto deleted after 24 hours
  }
});

const Room = mongoose.model("Room", roomSchema);

export default Room;