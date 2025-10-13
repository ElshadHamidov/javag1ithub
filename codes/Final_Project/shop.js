document.addEventListener("DOMContentLoaded", async () => {
  const productsGrid = document.querySelector(".products-grid");

  async function loadProducts() {
    try {
      const response = await fetch("http://localhost:8086/api/products");
      if (!response.ok) throw new Error("Failed to fetch products");

      const products = await response.json();
      productsGrid.innerHTML = "";

      products.forEach((product) => {
        const card = document.createElement("div");
        card.classList.add("product-card");

        card.innerHTML = `
          <img src="${product.imageUrl}" alt="${product.name}">
          <h4>${product.name}</h4>
          <p class="price">$${product.price.toFixed(2)}</p>
          <div class="rating">${"⭐".repeat(product.rating || 0)}</div>
          <button class="add-to-cart">Add to Cart</button>
        `;

        productsGrid.appendChild(card);
      });
    } catch (err) {
      console.error(err);
      productsGrid.innerHTML = "<p>Failed to load products.</p>";
    }
  }

  loadProducts();
});
