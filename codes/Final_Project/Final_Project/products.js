const API_URL = "http://localhost:8086/api/products";
const token = localStorage.getItem('token');

// let products = [];

// Load all products from backend
async function loadProducts() {
  // const res = await fetch(`${API_URL}/getAll`);
  // products = await res.json();
  fetch(`${API_URL}/getAll`, {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  })
  .then(response => {
    return response.json()
  })
  .then(data => {
    console.log(data);
    // products = data;
    renderTable(data);
  })
}



// async function addOrUpdateProduct(e) {
//   e.preventDefault();
//   const id = document.getElementById("editIndex").value;

//   const product = {
//     brand: document.getElementById("brand").value,
//     model: document.getElementById("model").value,
//     category: document.getElementById("category").value,
//     image: document.getElementById("image").value,
//     price: parseFloat(document.getElementById("price").value),
//     rating: document.getElementById("rating").value
//   };

//   if (id) {
//     await fetch(`${API_URL}/${products[id].id}`, {
//       method: "PUT",
//       headers: { "Content-Type": "application/json" },
//       body: JSON.stringify(product)
//     });
//   } else {
//     await fetch(API_URL, {
//       method: "POST",
//       headers: { "Content-Type": "application/json" },
//       body: JSON.stringify(product)
//     });
//   }

//   document.getElementById("productForm").reset();
//   document.getElementById("editIndex").value = "";
//   loadProducts();
// }

async function deleteProduct(id) {
  await fetch(`${API_URL}/delete/${id}`, { method: "DELETE", headers: {'Authorization': `Bearer ${token}`} });
  loadProducts();
}

// function editProduct(id) {

//   fetch(`${API_URL}/getById/${id}`,{
//     method: 'GET',
//     headers: {
//       'Authorization': `Bearer ${token}`
//     }
//   })
//   .then(response => {
//     return response.json()
//   })
//   .then(product => {
//     console.log(product);
//     // document.getElementById("editIndex").value = product.id;
//     document.getElementById("name").value = product.name;
//     document.getElementById("category").value = product.category;
//     document.getElementById("image").value = product.image;
//     document.getElementById("price").value = product.price;
//     document.getElementById("rating").value = product.rating;    
//   })
// }

// document.getElementById("productForm").addEventListener("submit", addOrUpdateProduct);

function renderTable(data) {
  const tbody = document.querySelector("#productTable tbody");
  tbody.innerHTML = "";
  data.products.forEach((p, index) => {
    tbody.innerHTML += `
      <tr>
        <td>${p.id}</td>
        <td>${p.name}</td>
        <td>${p.category}</td>
        <td><img src="${p.image}" alt="${p.name}" width="70"></td>
        <td>$${p.price.toFixed(2)}</td>
        <td>${p.rating}</td>
        <td>
          <button class="btn btn-warning edit-btn" data-id=${p.id} onclick="editProduct(${p.id})">Edit</button>
          <button class="btn btn-danger" onclick="deleteProduct(${p.id})">Delete</button>
        </td>
      </tr>
    `;
  });
}

loadProducts();

document.addEventListener('click', (e) => {
  if (e.target.classList.contains('edit-btn')) {
    let productId = e.target.getAttribute('data-id');
    window.location.href=`add-product.html?id=${productId}`;
  }
})
