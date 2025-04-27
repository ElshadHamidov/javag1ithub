const loginForm = document.querySelector('form');

loginForm.addEventListener('submit', (e) => {
    e.preventDefault();

    const request = {
        username: document.getElementById('username').value,
        password: document.getElementById('password').value
    }

    fetch('http://localhost:9999/auth/login', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(request)
    })
    .then(async response => {
        if (response.ok) {
            const token = await response.text();
            localStorage.setItem('token', token);
            Swal.fire({
                title: 'Giriş uğurlu!',
                text: 'Sistemə daxil oldun!',
                icon: 'success',
                showConfirmButton: false,
                timer: 2000,
                toast: true,
                position: 'top-end'
            });
        } else {
            const data = await response.json();
            Swal.fire({
                title: 'Xəta!',
                text: data.message,
                icon: 'error',
                showConfirmButton: false,
                timer: 3000,
                toast: true,
                position: 'top-end'
            });
        }
    })
})
