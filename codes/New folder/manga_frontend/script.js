const token = localStorage.getItem("token");
const genreItems = document.querySelectorAll('.genre-list li');
const cartsContainer = document.querySelector(".carts");

// Expanded test data with more genres
const testBooks = [
    { title: "Naruto", genre: "Shounen, Action", rating: "8.5" },
    { title: "One Piece", genre: "Shounen, Adventure", rating: "9.0" },
    { title: "Death Note", genre: "Supernatural, Thriller", rating: "9.2" },
    { title: "Tokyo Ghoul", genre: "Horror, Supernatural", rating: "7.8" },
    { title: "Your Lie in April", genre: "Drama, Romance", rating: "8.0" },
    { title: "Attack on Titan", genre: "Action, Shounen", rating: "9.1" },
    { title: "Fullmetal Alchemist", genre: "Shounen, Adventure", rating: "9.3" },
    { title: "Demon Slayer", genre: "Action, Supernatural", rating: "9.5" },
    { title: "My Hero Academia", genre: "Shounen, Action", rating: "8.7" },
    { title: "Sword Art Online", genre: "Action, Fantasy", rating: "8.2" },
    { title: "Bleach", genre: "Action, Supernatural", rating: "8.4" },
    { title: "One Punch Man", genre: "Action, Comedy", rating: "8.8" },
    { title: "Hunter x Hunter", genre: "Shounen, Adventure", rating: "9.4" },
    { title: "Steins;Gate", genre: "Supernatural, Sci-Fi", rating: "9.0" },
    { title: "Tokyo Revengers", genre: "Action, Drama", rating: "8.6" },
    { title: "Neon Genesis Evangelion", genre: "Supernatural, Mecha", rating: "8.9" },
    { title: "Fruits Basket", genre: "Drama, Romance", rating: "8.1" },
    { title: "Attack on Titan: Junior High", genre: "Comedy, Parody", rating: "7.5" },
    { title: "Black Clover", genre: "Shounen, Fantasy", rating: "8.3" },
    { title: "JoJo's Bizarre Adventure", genre: "Action, Adventure", rating: "8.6" },
    { title: "Trigun", genre: "Action, Western", rating: "8.0" },
    { title: "Inuyasha", genre: "Supernatural, Romance", rating: "8.2" },
    { title: "Mob Psycho 100", genre: "Action, Supernatural", rating: "8.7" },
    { title: "One Punch Man", genre: "Action, Comedy", rating: "8.8" }
];

// Uncomment the following lines when your API is ready
/*
fetch("http://localhost:9999/books/getAll", {
    method: 'GET',
    headers: {
        "Authorization": `Bearer ${token}`
    }
})
.then(response => response.json())
.then(result => {
    const books = result.books;
*/
const books = testBooks; // Use this for temporary testing

books.forEach(book => {
    const cart = document.createElement('div');
    cart.classList.add('cart');
    cart.setAttribute('data-genre', book.genre.toLowerCase());  // Genre converted to lowercase for consistency

    const title = document.createElement('h3');
    title.textContent = book.title;

    const genre = document.createElement('p');
    genre.textContent = book.genre;

    const badge = document.createElement('div');
    badge.classList.add('rating-badge');

    const rating = parseFloat(book.rating);
    badge.textContent = rating.toFixed(1);

    if (rating >= 9) {
        badge.setAttribute('data-rating', 'high');
    } else if (rating >= 7) {
        badge.setAttribute('data-rating', 'medium');
    } else {
        badge.setAttribute('data-rating', 'low');
    }

    cart.appendChild(title);
    cart.appendChild(genre);
    cart.appendChild(badge);

    cartsContainer.appendChild(cart);
});
// Uncomment this to use the API's response
/*
})
.catch(error => {
    console.error('Error fetching books:', error);
});
*/

genreItems.forEach(item => {
    item.addEventListener('click', () => {
        genreItems.forEach(i => i.classList.remove('active'));
        item.classList.add('active');

        const selected = item.getAttribute('data-genre').toLowerCase();

        const allCarts = document.querySelectorAll('.cart');
        allCarts.forEach(card => {
            const genres = card.getAttribute('data-genre');
            if (selected === 'all' || genres.includes(selected)) {
                card.style.display = 'block';
            } else {
                card.style.display = 'none';
            }
        });
    });
});
const returnButton = document.getElementById('return-button');

returnButton.addEventListener('click', () => {
    window.location.href = 'main.html';
});
