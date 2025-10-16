// Fetch order info from backend
async function getOrderFromDB(orderId) {
  const response = await fetch(`http://localhost:8086/api/order/${orderId}`);
  if (!response.ok) {
    alert("Order not found or server error");
    return null;
  }
  return await response.json();
}

// Display data on the page
function displayOrder(order) {
  document.getElementById("order-id").textContent = order.order_id;
  document.getElementById("order-date").textContent = new Date(order.date_placed).toDateString();
  document.getElementById("payment").textContent = order.payment;
  document.getElementById("address").textContent = order.address;
  document.getElementById("delivery").textContent = new Date(order.estimated_delivery).toDateString();

  updateTracker(order.status);
}

// Update progress tracker
function updateTracker(currentStatus) {
  const steps = document.querySelectorAll(".step");
  let reached = true;

  steps.forEach(step => {
    const stepStatus = step.getAttribute("data-status");
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

    if (stepStatus === currentStatus) {
      reached = false;
    }
  });
}

// On page load
document.addEventListener("DOMContentLoaded", async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const orderId = urlParams.get("id") || "ORD-123456"; // fallback order ID

  const orderData = await getOrderFromDB(orderId);
  if (orderData) displayOrder(orderData);
});
