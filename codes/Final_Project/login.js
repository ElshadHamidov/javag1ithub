// Select the form
const form = document.querySelector('form');

form.addEventListener('submit', async function (e) {
    e.preventDefault();

    const username = form.querySelector('input[placeholder="Username"]').value.trim();
    const password = form.querySelector('input[placeholder="Password"]').value;

    if (!username || !password) {
        alert('Please enter both username and password!');
        return;
    }

    try {
        const response = await fetch('http://localhost:3306/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        const data = await response.json();

        if (response.ok) {
            alert('Login successful! Welcome ' + data.username);
            // Optionally redirect to profile or dashboard
            window.location.href = './profile.html';
        } else {
            alert(data.message);
        }
    } catch (err) {
        alert('Error connecting to server');
        console.error(err);
    }
});
