/**
 * TRIVIA
 * 
 * @author Vincent Gruse
 * 
 * @description
 *    This file fetches trivia questiosn from the Open Trivia DB and processes
 *    them for use in the application. It also employes caching with Redis for
 *    efficiency and provides fallback questions in case of API failure.
 */

import axios from 'axios';
import redis from "./redis.js";
import { decode } from 'html-entities';

const TRIVIA_CACHE_KEY = 'trivia:questions';
const CACHE_EXPIRY = 3600; // 1 hour

/**
 * Function: fetchTriviaQuestions
 * @returns Questions from OpenTDB or Fallback Questions.
 * 
 * Checks for cached questions in Redis, otherwise fetches
 * question data from OpenTDB, processes raw JSON and caches
 * them for future use.
 */
export const fetchTriviaQuestions = async () => {
  try {
    // Check cache first.
    const cachedQuestions = await redis.get(TRIVIA_CACHE_KEY);
    if (cachedQuestions) {
      return JSON.parse(cachedQuestions);
    }

    // If not in cache, fetch from API.
    const response = await axios.get('https://opentdb.com/api.php', {
      params: {
        amount: 49,
        category: 18,
        type: 'multiple'
      },
      timeout: 5000 // 5 second timeout.
    });

    if (response.data.response_code !== 0) {
      throw new Error('Failed to fetch trivia questions');
    }

    const questions = transformQuestions(response.data.results);
    
    // Cache the questions.
    await redis.set(TRIVIA_CACHE_KEY, JSON.stringify(questions));
    await redis.expire(TRIVIA_CACHE_KEY, CACHE_EXPIRY);

    return questions;
  } catch (error) {
    console.error('Error fetching trivia questions:', error);

    // Return fallback questions.
    return getFallbackQuestions();
  }
};

/**
 * Function Name: transformQuestions
 * @param {*} rawQuestions 
 * @returns Transformed questions with correct answers and time limits.
 * 
 * Process the raw API responses, combines correct and incorrect answers,
 * shuffles the answers, and decodes HTML entities in the question and answers
 */
const transformQuestions = (rawQuestions) => {
  return rawQuestions.map((q) => {
    const answers = [q.correct_answer, ...q.incorrect_answers];
    
    // Shuffle
    for (let i = answers.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1));
      [answers[i], answers[j]] = [answers[j], answers[i]];
    }

    return {
      question: decode(q.question),
      answers: answers.map(answer => decode(answer)),
      correctAnswer: answers.indexOf(q.correct_answer),
      timeLimit: 10
    };
  });
};

/**
 * Function Name: getFallbackQuestions
 * @returns Fallback Questions
 * 
 * Provides a hardcoded set of fallback trivia questions for use when the
 * API or Redis is unavailable.
 */
const getFallbackQuestions = () => {
  return [
    {
      question: "What does CPU stand for?",
      answers: [
        "Central Processing Unit",
        "Central Program Utility",
        "Computer Personal Unit",
        "Central Processor Utility"
      ],
      correctAnswer: 0,
      timeLimit: 10
    },
    {
      question: "Which programming language is known for its use in web browsers?",
      answers: [
        "JavaScript",
        "Python",
        "Java",
        "C++"
      ],
      correctAnswer: 0,
      timeLimit: 10
    },
    {
      question: "What is the smallest unit of digital information?",
      answers: [
        "Bit",
        "Byte",
        "Kilobyte",
        "Megabyte"
      ],
      correctAnswer: 0,
      timeLimit: 10
    },
    {
      question: "Which data structure operates on a Last-In-First-Out (LIFO) principle?",
      answers: [
        "Stack",
        "Queue",
        "Array",
        "Tree"
      ],
      correctAnswer: 0,
      timeLimit: 10
    },
    {
      question: "What does HTML stand for?",
      answers: [
        "HyperText Markup Language",
        "High Tech Machine Learning",
        "HyperTransfer Markup Language",
        "HyperText Machine Language"
      ],
      correctAnswer: 0,
      timeLimit: 10
    }
  ];
};

export default { fetchTriviaQuestions };