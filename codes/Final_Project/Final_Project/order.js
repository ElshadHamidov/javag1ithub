async function getOrderFromDB(orderId) {
  const token = localStorage.getItem("authToken");
  const response = await fetch(`http://localhost:8086/api/order/${orderId}`, {
    headers: {
      "Authorization": token ? `Bearer ${token}` : "",
      "Content-Type": "application/json"
    }
  });
  if (!response.ok) {
    alert("Order not found or server error");
    return null;
  }
  return await response.json();
}

function displayOrder(order) {
  document.getElementById("order-id").textContent = order.order_id;
  document.getElementById("order-date").textContent = new Date(order.date_placed).toLocaleDateString();
  document.getElementById("payment").textContent = order.payment;
  document.getElementById("address").textContent = order.address;
  document.getElementById("delivery").textContent = new Date(order.estimated_delivery).toLocaleDateString();
  updateTracker(order.status);
}

function updateTracker(currentStatus) {
  const steps = document.querySelectorAll(".step");
  let reached = true;
  steps.forEach(step => {
    const stepStatus = step.dataset.status;
    const icon = step.querySelector(".icon");
    if (reached) {
      step.classList.add("active");
      icon.style.backgroundColor = "#2b8df7";
      icon.style.color = "#fff";
    } else {
      step.classList.remove("active");
      icon.style.backgroundColor = "#ddd";
      icon.style.color = "#555";
    }
    if (stepStatus === currentStatus) reached = false;
  });
}

document.addEventListener("DOMContentLoaded", async () => {
  const params = new URLSearchParams(window.location.search);
  const orderId = params.get("id") || "ORD-123456";
  const orderData = await getOrderFromDB(orderId);
  if (orderData) displayOrder(orderData);
});
