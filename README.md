# 🔗 URL Shortener Application

> A full-stack URL Shortener built with **Spring Boot** and **React**, designed to convert long URLs into short, shareable links and redirect users efficiently.

A full-stack URL Shortener web application that converts long URLs into short, shareable links and redirects users to the original URL when accessed. This project demonstrates real-world full-stack development using **Spring Boot** for the backend and **React** for the frontend.

---

##  Features

* Generate short URLs from long URLs

* Fast redirection to original URLs

* RESTful API architecture

* Clean and responsive UI

* Input validation & exception handling

* CORS-enabled frontend–backend communication

* Cloud deployment (production-ready)

* Convert long URLs into short URLs

* Redirect short URLs to original URLs

* RESTful API-based backend

* Simple and responsive frontend UI

* Input validation and error handling

* Client–server communication using HTTP

* Deployed frontend and backend

---

##  Tech Stack

### Backend

* Java (Java 8+)
* Spring Boot
* Spring Web (REST APIs)
* Spring Data JPA
* MySQL / H2 Database
* Maven

### Frontend

* React.js
* HTML5
* CSS3
* JavaScript (ES6)

### Deployment

* Backend: Render
* Frontend: Netlify

> Live Demo links can be added here once deployed.

---

## Architecture Overview

1. User enters a long URL in the frontend
2. React frontend sends a POST request to backend API
3. Backend generates a unique short code
4. Short URL and original URL are stored in the database
5. Short URL is returned to the frontend
6. When short URL is accessed, backend redirects to original URL

---

##  Project Structure

### Backend (Spring Boot)

```
url-shortener-backend
├── controller
├── service
├── repository
├── model
├── exception
└── UrlShortenerApplication.java
```

### Frontend (React)

```
url-shortener-frontend
├── src
│   ├── components
│   ├── services
│   ├── App.js
│   └── index.js
```

---

## 🔑 API Endpoints

### 1️⃣ Create Short URL

```
POST /api/shorten
```

**Request Body:**

```json
{
  "originalUrl": "https://example.com"
}
```

**Response:**

```json
{
  "shortUrl": "http://localhost:8080/abc123"
}
```

---

### Redirect to Original URL

```
GET /{shortCode}
```

Redirects user to the original URL.

---

## ⚙️ How to Run Locally

### Backend Setup

1. Clone the repository
2. Open backend project in IDE
3. Configure database in `application.properties`
4. Run the Spring Boot application

### Frontend Setup

1. Navigate to frontend folder
2. Install dependencies

   ```bash
   npm install
   ```
3. Start development server

   ```bash
   npm start
   ```

---

## Learning Outcomes

* Understanding REST API development
* Frontend–backend integration
* URL redirection logic
* Database CRUD operations
* Deployment of full-stack applications
* Real-world project structure

---

## Future Enhancements

* User authentication
* URL expiration feature
* Click count analytics
* Custom short URLs
* QR code generation

---

## Author

**JOLIYA D**
Aspiring Software Engineer | Full Stack Developer
GitHub: [https://github.com/joliyaD](https://github.com/joliyaD)

---

## License

This project is licensed under the MIT License.
