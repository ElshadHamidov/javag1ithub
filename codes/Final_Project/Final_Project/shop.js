document.addEventListener("DOMContentLoaded", async () => {
  const productsGrid = document.querySelector(".products-grid");
  const searchInputTop = document.querySelector("#search");
  const searchInputSidebar = document.querySelector("#search-sidebar");
  const sortSelect = document.querySelector("#sort");
  const categorySelect = document.querySelector("#category");
  const ratingFilters = document.querySelectorAll(".rating-filter");

  const BASE_URL = "http://localhost:8086/api/products";
  const CART_API = "http://localhost:8086/api/cart";
  const token = localStorage.getItem("token");

  let allProducts = [];
  let selectedRating = 0; // exact rating filter
  let searchTimeout;

  async function fetchWithAuth(url, options = {}) {
    const response = await fetch(url, {
      headers: {
        "Content-Type": "application/json",
        ...(token ? { "Authorization": `Bearer ${token}` } : {}),
      },
      ...options,
    });
    if (!response.ok) throw new Error(`Request failed: ${response.status}`);
    return response.json();
  }

  async function loadProducts() {
    try {
      const data = await fetchWithAuth(`${BASE_URL}/getAll`);
      allProducts = Array.isArray(data) ? data : data.products || [];
      applyFilters();
    } catch (err) {
      console.error("❌ Load products error:", err);
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
        <img src="${product.image}" alt="${product.name}" class="product-img" data-id="${product.id}">
        <h4 class="product-name" data-id="${product.id}">${product.name}</h4>
        <p class="price">$${(product.price || 0).toFixed(2)}</p>
        <div class="rating">${"⭐".repeat(product.rating || 0)}</div>
        <button class="add-to-cart" data-id="${product.id}">Add to Cart</button>
      `;

      productsGrid.appendChild(card);
    });

    document.querySelectorAll(".add-to-cart").forEach((btn) =>
      btn.addEventListener("click", (e) => addToCart(e.target.dataset.id, 1))
    );

    document.querySelectorAll(".product-img, .product-name").forEach((el) =>
      el.addEventListener("click", (e) => {
        const id = e.target.dataset.id;
        window.location.href = `product.html?id=${id}`;
      })
    );
  }

  async function addToCart(productId, quantity = 1) {
    try {
      const res = await fetch(`${CART_API}/add`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          ...(token ? { "Authorization": `Bearer ${token}` } : {}),
        },
        body: JSON.stringify({ productId, quantity }),
      });
      if (!res.ok) throw new Error("Add to cart failed");
      alert("✅ Product added to cart!");
    } catch (err) {
      console.error("❌ Error adding to cart:", err);
      alert("⚠️ Failed to add product to cart.");
    }
  }

  function applyFilters() {
    let filtered = [...allProducts];

    // Search (top + sidebar)
    const query = (searchInputTop.value + searchInputSidebar.value).trim().toLowerCase();
    if (query) filtered = filtered.filter((p) => p.name.toLowerCase().includes(query));

    // Category
    const category = categorySelect.value;
    if (category && category !== "all") filtered = filtered.filter((p) => p.category === category);

    // Exact rating filter
    if (selectedRating > 0) filtered = filtered.filter((p) => (p.rating || 0) === selectedRating);

    // Sort
    switch (sortSelect.value) {
      case "price-asc":
        filtered.sort((a, b) => (a.price || 0) - (b.price || 0));
        break;
      case "price-desc":
        filtered.sort((a, b) => (b.price || 0) - (a.price || 0));
        break;
      case "rating-asc":
        filtered.sort((a, b) => (a.rating || 0) - (b.rating || 0));
        break;
      case "rating-desc":
        filtered.sort((a, b) => (b.rating || 0) - (a.rating || 0));
        break;
    }

    renderProducts(filtered);
  }

  // Event listeners
  [searchInputTop, searchInputSidebar].forEach((input) =>
    input.addEventListener("input", () => {
      clearTimeout(searchTimeout);
      searchTimeout = setTimeout(applyFilters, 300);
    })
  );

  categorySelect.addEventListener("change", applyFilters);
  sortSelect.addEventListener("change", applyFilters);

  ratingFilters.forEach((el) => {
    el.addEventListener("click", () => {
      selectedRating = parseInt(el.dataset.rating, 10);

      // Highlight selected
      ratingFilters.forEach(r => r.classList.remove("selected-rating"));
      el.classList.add("selected-rating");

      applyFilters();
    });
  });

  loadProducts();
});
