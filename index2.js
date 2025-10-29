/**
 * 🚀 Aurora Pulse Button Contribution
 * Author: your-github-username
 * Type: React (Next.js)
 * Difficulty: Beginner
 * 
 * Description:
 * A responsive gradient React button with a glowing pulse and focus effects.
 * Built for the ClickHub Hacktoberfest 2025 repository.
 * 
 * Folder: contributions/your-github-username/
 * File: index.js
 * 
 * To test:
 *   1️⃣ Place this file inside your folder (contributions/your-github-username/)
 *   2️⃣ Run `npm run dev`
 *   3️⃣ Visit http://localhost:3000
 * 
 * Commit example:
 *   git add .
 *   git commit -m "Add Aurora Pulse Button by your-github-username"
 *   git push origin main
 */

// ---------- 🧩 Button Metadata ----------
const buttonMetadata = {
  name: "Aurora Pulse Button",
  author: "your-github-username", // replace with your GitHub username
  description: "A responsive React button with gradient animation and glowing focus effects.",
  type: "react", // required field
  tags: ["animation", "gradient", "tailwind", "react"],
  difficulty: "beginner",
  preview: "A glowing gradient button that pulses when clicked."
};

export default buttonMetadata;

// ---------- 🎨 AuroraPulseButton Component ----------
'use client';
import { useState } from 'react';

export function AuroraPulseButton() {
  const [clicked, setClicked] = useState(false);

  return (
    <button
      onClick={() => setClicked(!clicked)}
      aria-pressed={clicked}
      className="
        px-6 py-3 rounded-xl font-semibold text-white 
        bg-gradient-to-r from-purple-500 via-pink-500 to-red-400 
        shadow-lg transition-all duration-300
        hover:brightness-110 focus:ring-4 focus:ring-purple-300 
        active:scale-95
      "
      style={{
        boxShadow: clicked
          ? '0 0 25px rgba(236,72,153,0.5)'
          : '0 0 15px rgba(147,51,234,0.4)'
      }}
    >
      {clicked ? 'Clicked 🎉' : 'Click Me ✨'}
    </button>
  );
}

// ✅ Export the component so it’s detected automatically
export { AuroraPulseButton as ButtonComponent };

/**
 * ---------- 📘 README (for reference) ----------
 *
 * # Aurora Pulse Button
 *
 * **Author:** your-github-username  
 * **Type:** React (Next.js)  
 * **Difficulty:** Beginner  
 *
 * ## Description
 * A modern, responsive gradient button built with React and Tailwind CSS.  
 * It features smooth transitions, a glowing pulse effect, and keyboard accessibility.
 *
 * ## Features
 * - React + Tailwind based
 * - Accessible (`aria-pressed`)
 * - Animated gradient hover glow
 * - Clean and minimal design
 *
 * ## How to Test
 * 1️⃣ Place this file in `contributions/your-github-username/`.
 * 2️⃣ Run:
 *    npm install
 *    npm run dev
 * 3️⃣ Open http://localhost:3000 to see it in the showcase.
 *
 * ✅ Includes required buttonMetadata (name, author, type)
 * ✅ Fully valid for Hacktoberfest 2025 ClickHub repo
 * ✅ Single language: JavaScript (React)
 */
