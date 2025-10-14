const form = document.querySelector('form');

form.addEventListener('submit', async function (e) {
    e.preventDefault();

    const name = form.querySelector('input[placeholder="Name"]').value.trim();
    const surname = form.querySelector('input[placeholder="Surname"]').value.trim();
    const email = form.querySelector('input[placeholder="Email"]').value.trim();
    const username = form.querySelector('input[placeholder="Username"]').value.trim();
    const password = form.querySelector('input[placeholder="Password"]').value;

    if (!name || !surname || !email || !username || !password) {
        alert('Please fill in all fields!');
        return;
    }

    if (!validateEmail(email)) {
        alert('Please enter a valid email!');
        return;
    }

    const response = await fetch('http://localhost:8086/users/register', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ name, surname, email, username, password })
    });

    
    if (response.ok) {
        form.reset();
        alert('Qeydiyyat ugurla tamamlandi')
    }else{
        const data = await response.json();
        alert(data.message);
    }

});

function validateEmail(email) {
    const re = /\S+@\S+\.\S+/;
    return re.test(email);
}
