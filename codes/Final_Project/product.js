const productId = new URLSearchParams(window.location.search).get("id");

fetch(`http://localhost:8086/api/products/${productId}`)
  .then(res => res.json())
  .then(product => {
    document.getElementById("product-name").textContent = product.name;
    document.getElementById("product-price").textContent = `$${product.price}`;
    document.getElementById("product-description").textContent = product.description || "No description available.";
    document.getElementById("product-image").src = product.image;

    let stars = '';
    for (let i = 0; i < Math.round(product.rating || 0); i++) {
      stars += '★';
    }
    document.getElementById("product-rating").innerHTML = stars;

    loadRelated(product.category);
  })
  .catch(err => console.error("Error fetching product:", err));

function loadRelated(category) {
  fetch(`http://localhost:8086/api/products?category=${encodeURIComponent(category)}`)
    .then(res => res.json())
    .then(products => {
      const related = document.getElementById("related-products");
      related.innerHTML = '';
      products.slice(0, 4).forEach(p => {
        const div = document.createElement("div");
        div.classList.add("related-item");
        div.innerHTML = `
          <img src="${p.image}" alt="${p.name}">
          <h4>${p.name}</h4>
          <p>$${p.price}</p>
        `;
        related.appendChild(div);
      });
    });
}
