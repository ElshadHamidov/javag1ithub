const API_URL = "http://localhost:8086/api/products";

let products = [];

// Load all products from backend
async function loadProducts() {
  const res = await fetch(API_URL);
  products = await res.json();
  renderTable();
}

async function addOrUpdateProduct(e) {
  e.preventDefault();
  const id = document.getElementById("editIndex").value;

  const product = {
    brand: document.getElementById("brand").value,
    model: document.getElementById("model").value,
    category: document.getElementById("category").value,
    image: document.getElementById("image").value,
    price: parseFloat(document.getElementById("price").value),
    rating: document.getElementById("rating").value
  };

  if (id) {
    await fetch(`${API_URL}/${products[id].id}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(product)
    });
  } else {
    await fetch(API_URL, {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(product)
    });
  }

  document.getElementById("productForm").reset();
  document.getElementById("editIndex").value = "";
  loadProducts();
}

async function deleteProduct(index) {
  await fetch(`${API_URL}/${products[index].id}`, { method: "DELETE" });
  loadProducts();
}

function editProduct(index) {
  const p = products[index];
  document.getElementById("editIndex").value = index;
  document.getElementById("brand").value = p.brand;
  document.getElementById("model").value = p.model;
  document.getElementById("category").value = p.category;
  document.getElementById("image").value = p.image;
  document.getElementById("price").value = p.price;
  document.getElementById("rating").value = p.rating;
}

document.getElementById("productForm").addEventListener("submit", addOrUpdateProduct);

function renderTable() {
  const tbody = document.querySelector("#productTable tbody");
  tbody.innerHTML = "";
  products.forEach((p, index) => {
    tbody.innerHTML += `
      <tr>
        <td>${p.id}</td>
        <td>${p.brand}</td>
        <td>${p.model}</td>
        <td>${p.category}</td>
        <td><img src="${p.image}" alt="${p.model}" width="70"></td>
        <td>$${p.price.toFixed(2)}</td>
        <td>${p.rating}</td>
        <td>
          <button class="btn btn-warning" onclick="editProduct(${index})">Edit</button>
          <button class="btn btn-danger" onclick="deleteProduct(${index})">Delete</button>
        </td>
      </tr>
    `;
  });
}

loadProducts();
