const registerForm = document.querySelector('form');

registerForm.addEventListener('submit', (event) => {
    event.preventDefault();

    const user = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        username: document.getElementById('username').value,
        password: document.getElementById('password').value,
        email: document.getElementById('email').value
    }

    fetch('http://localhost:9999/auth/register', {
        method: 'POST',
        headers: {
            'Content-Type':'application/json'
        },
        body: JSON.stringify(user)
    })
    .then(async response => {
        if (response.ok) {
            const message = await response.text();
            Swal.fire({
                title: 'Əla!',
                text: message,
                icon: 'success',
                showConfirmButton: false,
                timer: 2000,
                toast: true,
                position: 'top-end'
            });
            registerForm.reset();
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
