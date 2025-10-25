const form = document.querySelector('form');

form.addEventListener('submit', async function (e) {
    e.preventDefault();

    const username = form.querySelector('input[placeholder="Username"]').value.trim();
    const password = form.querySelector('input[placeholder="Password"]').value;

    if (!username || !password) {
        alert('Please enter both username and password!');
        return;
    }

        const response = await fetch('http://localhost:8086/users/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({ username, password })
        });

        
        if (response.ok) {
            const token = await response.text();
            localStorage.setItem('token', token);
            alert('Login successful! Welcome ');
            window.location.href = './profile.html';
        } else {
            const data = await response.json();
            alert(data.message);
        }
 
});
