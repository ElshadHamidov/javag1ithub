document.addEventListener("DOMContentLoaded", () => {
  const userInfoDiv = document.getElementById("user-info");

  const token = localStorage.getItem('token');

  if (!token) {
    window.location.href = "./login.html";
    return;
  }

  fetch("http://localhost:8086/users/profile", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
      "Authorization": `Bearer ${token}` 
        }
  })
    .then(response => {
      if (response.status === 401) {
        window.location.href = "./login.html";
        return;
      }
      if (!response.ok) {
        userInfoDiv.textContent = "Failed to load user data.";
        return;
      }
      return response.json();
    })
    .then(user => {
      if (!user) return;
      userInfoDiv.innerHTML = `
        <p><strong>Name:</strong> ${user.name || "N/A"}</p>
        <p><strong>Surname:</strong> ${user.surname || "N/A"}</p>
        <p><strong>Email:</strong> ${user.email || "N/A"}</p>
        <p><strong>Username:</strong> ${user.username || "N/A"}</p>
      `;
    })
    .catch(() => {
      userInfoDiv.textContent = "Unable to connect to the server.";
    });
});

document.querySelector('.my-products-btn').addEventListener('click', () => {
  window.location.href = 'products.html';
});
