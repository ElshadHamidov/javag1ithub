document.addEventListener("DOMContentLoaded", async () => {
  const productsGrid = document.querySelector(".products-grid");
  const searchInput = document.querySelector("#search");
  const sortSelect = document.querySelector("#sort");

  const BASE_URL = "http://localhost:8086/api/products";
  const token = localStorage.getItem("token");

  async function fetchWithAuth(url) {
    const response = await fetch(url, {
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json"
      }
    });
    if (!response.ok) throw new Error("Failed to fetch: " + response.status);
    return response.json();
  }

  async function loadProducts() {
    try {
      const data = await fetchWithAuth(`${BASE_URL}/getAll`);
      const products = data?.products || [];
      renderProducts(products);
    } catch (err) {
      console.error(err);
      productsGrid.innerHTML = "<p>Failed to load products.</p>";
    }
  }

  function renderProducts(products) {
    productsGrid.innerHTML = "";
    if (!products.length) {
      productsGrid.innerHTML = "<p>No products found.</p>";
      return;
    }

    products.forEach((product) => {
      const card = document.createElement("div");
      card.classList.add("product-card");

      card.innerHTML = `
        <img src="${product.imageUrl}" alt="${product.name}">
        <h4>${product.name}</h4>
        <p class="price">$${product.price?.toFixed(2) || 0}</p>
        <div class="rating">${"⭐".repeat(product.rating || 0)}</div>
        <button class="add-to-cart">Add to Cart</button>
      `;

      productsGrid.appendChild(card);
    });
  }

  async function searchProducts(query) {
    try {
      const data = await fetchWithAuth(`${BASE_URL}/search?query=${encodeURIComponent(query)}`);
      renderProducts(data);
    } catch (err) {
      console.error(err);
      productsGrid.innerHTML = "<p>Search failed.</p>";
    }
  }

  async function sortProducts(sortType) {
    try {
      const data = await fetchWithAuth(`${BASE_URL}/sort?sort=${encodeURIComponent(sortType)}`);
      renderProducts(data);
    } catch (err) {
      console.error(err);
      productsGrid.innerHTML = "<p>Sorting failed.</p>";
    }
  }

  if (searchInput) {
    searchInput.addEventListener("input", (e) => {
      const query = e.target.value.trim();
      if (query) searchProducts(query);
      else loadProducts();
    });
  }

  if (sortSelect) {
    sortSelect.addEventListener("change", (e) => {
      const sortType = e.target.value;
      if (sortType) sortProducts(sortType);
      else loadProducts();
    });
  }

  loadProducts();
});
