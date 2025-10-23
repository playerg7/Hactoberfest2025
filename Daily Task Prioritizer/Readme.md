# Daily Task Prioritizer

A **daily task prioritization tool** that helps individuals or teams plan their work efficiently based on **Impact ÷ Effort**. Tasks that exceed your daily working hours are automatically carried over to the next day.

---

## Features

- **Set Daily Work Hours:** Customize your workday (default is 8 hours).  
- **Add Tasks:** Enter task **name**, **effort (hours)**, and **impact (1–10)**.  
- **Automatic Prioritization:** Tasks are sorted by `Impact ÷ Effort` for maximum productivity.  
- **Next-Day Overflow:** Tasks that cannot fit into today's schedule are highlighted.  
- **Responsive Design:** Works on desktop and mobile browsers.  

---

## How Priority is Calculated

Displayed mathematically:

Priority= Impact/Effort

- **High priority:** Tasks with higher `Impact ÷ Effort` ratio.  
- **Medium priority:** Moderate ratio.  
- **Low priority:** Low ratio.  

> Example:  
> Task A: 6 hours, Impact 9 → Priority = 9 ÷ 6 = 1.5  
> Task B: 2 hours, Impact 3 → Priority = 3 ÷ 2 = 1.5  

---

## ⚡ How to Use

1. Open `index.html` in your browser.  
2. Enter your **daily work hours**.  
3. Add tasks with **name**, **effort (hours)**, and **impact**.  
4. Click **Add Task**.  
5. Tasks are automatically sorted, and any tasks that exceed your daily hours are marked for the **next day**.  

---

## 📦 Project Files

- `index.html` – Main HTML file  
- `style.css` – Styling for layout and colors  
- `script.js` – Task logic and prioritization  

---

http://127.0.0.1:5500/Daily%20Task%20Prioritizer/index.html