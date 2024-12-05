/**
 * REDIS
 * 
 * @author Ryan Tiffany
 * 
 * @description
 *    This file establishes a connection to a Redis server and handles error
 *    logging and connection status. It also exports the Redis client for use
 *    throughout the application.
 */

import { createClient } from "redis";

const redis = createClient({
  url: "redis://redis:6379",
});

redis.on("error", (err) => console.error("Redis Client Error", err));
redis.on("connect", () => console.log("Connected to Redis"));

await redis.connect();

export default redis;