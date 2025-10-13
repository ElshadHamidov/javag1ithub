const express = require('express');
const mysql = require('mysql2');
const bodyParser = require('body-parser');
const bcrypt = require('bcrypt');
const cors = require('cors');

const app = express();
app.use(bodyParser.json());
app.use(cors());

// Connect to MySQL
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',       // your MySQL username
    password: '',       // your MySQL password
    database: 'ecommerce'
});

db.connect((err) => {
    if (err) throw err;
    console.log('Connected to MySQL');
});

// Signup endpoint
app.post('/signup', async (req, res) => {
    const { name, surname, email, username, password } = req.body;

    if (!name || !surname || !email || !username || !password) {
        return res.status(400).json({ message: 'All fields are required' });
    }

    try {
        const hashedPassword = await bcrypt.hash(password, 10);

        const sql = 'INSERT INTO users (name, surname, email, username, password) VALUES (?, ?, ?, ?, ?)';
        db.query(sql, [name, surname, email, username, hashedPassword], (err, result) => {
            if (err) {
                if (err.code === 'ER_DUP_ENTRY') {
                    return res.status(400).json({ message: 'Email or username already exists' });
                }
                throw err;
            }
            res.json({ message: 'Account created successfully' });
        });
    } catch (error) {
        res.status(500).json({ message: 'Server error' });
    }
});

// Start server
app.listen(3306, () => {
    console.log('Server running on http://localhost:3306');
});
const bcrypt = require('bcrypt'); // already installed

// Login endpoint
app.post('/login', (req, res) => {
    const { username, password } = req.body;

    if (!username || !password) {
        return res.status(400).json({ message: 'Username and password required' });
    }

    const sql = 'SELECT * FROM users WHERE username = ?';
    db.query(sql, [username], async (err, results) => {
        if (err) throw err;

        if (results.length === 0) {
            return res.status(400).json({ message: 'Invalid username or password' });
        }

        const user = results[0];

        const match = await bcrypt.compare(password, user.password);
        if (!match) {
            return res.status(400).json({ message: 'Invalid username or password' });
        }

        // Login successful
        res.json({ message: 'Login successful', username: user.username });
    });
});
