const addTaskBtn = document.getElementById('addTaskBtn');
const taskList = document.getElementById('taskList');

let tasks = [];

addTaskBtn.addEventListener('click', () => {
    const workHoursInput = parseFloat(document.getElementById('workHours').value);
    const workdayHours = workHoursInput && workHoursInput > 0 ? workHoursInput : 8;

    const name = document.getElementById('taskName').value.trim();
    const effort = parseFloat(document.getElementById('effort').value);
    const impact = parseInt(document.getElementById('impact').value);

    if (!name || !effort || !impact) {
        alert("Please fill all fields!");
        return;}

    tasks.push({ name, effort, impact });
    document.getElementById('taskName').value = '';
    document.getElementById('effort').value = '';
    document.getElementById('impact').value = '';

    renderTasks(workdayHours);
});

function renderTasks(workdayHours) {
    tasks.sort((a, b) => (b.impact / b.effort) - (a.impact / a.effort));

    let remainingHours = workdayHours;
    taskList.innerHTML = '';

    tasks.forEach(task => {
        const li = document.createElement('li');
        li.textContent = `${task.name} - ${task.effort} hr(s) | Impact: ${task.impact}`;
        
        if (task.effort <= remainingHours) {
            remainingHours -= task.effort;
        } else {
            li.textContent += ' (Next Day)';
            li.classList.add('next-day');
        }

        taskList.appendChild(li);
    });
}

