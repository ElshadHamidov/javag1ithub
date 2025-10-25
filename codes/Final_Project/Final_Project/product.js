document.addEventListener("DOMContentLoaded", async () => {
  const productId = new URLSearchParams(window.location.search).get("id");
  const BASE_URL = "http://localhost:8086/api/products";
  const token = localStorage.getItem("token");

  if (!productId) {
    console.error("No product ID found in URL");
    return;
  }

  async function fetchWithAuth(url) {
    const response = await fetch(url, {
      headers: {
        "Authorization": `Bearer ${token}`,
        "Content-Type": "application/json"
      }
    });
    if (!response.ok) throw new Error(`Failed to fetch: ${response.status}`);
    return response.json();
  }

  async function loadProduct() {
    try {
      const product = await fetchWithAuth(`${BASE_URL}/getById/${productId}`);

      document.getElementById("product-name").textContent = product.name;
      document.getElementById("product-price").textContent = `$${product.price?.toFixed(2) || "0.00"}`;
      document.getElementById("product-description").textContent = product.description || "No description available.";
      document.getElementById("product-image").src = product.imageUrl || "placeholder.jpg";

      const stars = "★".repeat(Math.round(product.rating || 0));
      document.getElementById("product-rating").innerHTML = stars || "No ratings yet";

      if (product.category) {
        loadRelated(product.category, product.id);
      }
    } catch (err) {
      console.error("Error fetching product:", err);
      document.getElementById("product-name").textContent = "Product not found.";
    }
  }

  async function loadRelated(category, excludeId) {
    try {
      const data = await fetchWithAuth(`${BASE_URL}/getAll`);
      const allProducts = data?.products || [];

      const relatedProducts = allProducts
        .filter(p => p.category === category && p.id !== parseInt(excludeId))
        .slice(0, 4);

      const related = document.getElementById("related-products");
      related.innerHTML = "";

      if (relatedProducts.length === 0) {
        related.innerHTML = "<p>No related products found.</p>";
        return;
      }

      relatedProducts.forEach(p => {
        const div = document.createElement("div");
        div.classList.add("related-item");
        div.innerHTML = `
          <img src="${p.imageUrl}" alt="${p.name}">
          <h4>${p.name}</h4>
          <p>$${p.price?.toFixed(2) || 0}</p>
        `;
        div.addEventListener("click", () => {
          window.location.href = `product.html?id=${p.id}`;
        });
        related.appendChild(div);
      });
    } catch (err) {
      console.error("Error loading related products:", err);
    }
  }

  loadProduct();
});
