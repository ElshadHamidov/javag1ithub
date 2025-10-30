document.addEventListener("DOMContentLoaded", async () => {
  const productId = new URLSearchParams(window.location.search).get("id");
  const BASE_URL = "http://localhost:8086/api/products";
  const CART_API = "http://localhost:8086/api/cart";
  const token = localStorage.getItem("token");

  if (!productId) {
    console.error("No product ID found in URL");
    document.querySelector(".product-page").innerHTML = "<h2>Product not found.</h2>";
    return;
  }

  async function fetchWithAuth(url) {
    const response = await fetch(url, {
      headers: {
        "Authorization": token ? `Bearer ${token}` : "",
        "Content-Type": "application/json"
      }
    });
    if (!response.ok) throw new Error(`Failed to fetch: ${response.status}`);
    return response.json();
  }

  async function loadProduct() {
    try {
      const product = await fetchWithAuth(`${BASE_URL}/getById/${productId}`);

      // ✅ Populate product details
      document.getElementById("product-name").textContent = product.name;
      document.getElementById("product-price").textContent = `$${product.price?.toFixed(2) || "0.00"}`;
      document.getElementById("product-description").textContent = product.description || "No description available.";
      document.getElementById("product-image").src = product.image || "placeholder.jpg";

      // ⭐ Rating stars
      const stars = "★".repeat(Math.round(product.rating || 0)) || "No ratings yet";
      document.getElementById("product-rating").textContent = stars;

      // 🛒 Add to cart event
      document.querySelector(".add-btn").addEventListener("click", () => {
        addToCart(product.id);
      });

      // 📦 Load related products
      if (product.category) {
        loadRelated(product.category, product.id);
      }
    } catch (err) {
      console.error("Error fetching product:", err);
      document.querySelector(".product-page").innerHTML = "<h2>Failed to load product.</h2>";
    }
  }

  async function addToCart(productId) {
    try {
      const res = await fetch(`${CART_API}/add`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
          ...(token ? { "Authorization": `Bearer ${token}` } : {})
        },
        body: JSON.stringify({ productId, quantity: 1 })
      });

      if (!res.ok) throw new Error("Failed to add product to cart");
      alert("✅ Product added to cart!");
    } catch (err) {
      console.error("Add to cart error:", err);
      alert("⚠️ Unable to add to cart. Please log in or try again.");
    }
  }

  async function loadRelated(category, excludeId) {
    try {
      const data = await fetchWithAuth(`${BASE_URL}/getAll`);
      const allProducts = data?.products || [];

      const relatedProducts = allProducts
        .filter(p => p.category === category && p.id !== parseInt(excludeId))
        .slice(0, 4);

      const relatedContainer = document.getElementById("related-products");
      relatedContainer.innerHTML = "";

      if (!relatedProducts.length) {
        relatedContainer.innerHTML = "<p>No related products found.</p>";
        return;
      }

      relatedProducts.forEach(p => {
        const div = document.createElement("div");
        div.classList.add("related-item");
        div.innerHTML = `
          <img src="${p.image}" alt="${p.name}">
          <h4>${p.name}</h4>
          <p>$${p.price?.toFixed(2) || 0}</p>
        `;
        div.addEventListener("click", () => {
          window.location.href = `product.html?id=${p.id}`;
        });
        relatedContainer.appendChild(div);
      });
    } catch (err) {
      console.error("Error loading related products:", err);
    }
  }

  loadProduct();
});
