# 🖼️ Image Conversion API (Spring Boot)

## 📌 Overview

This project is a **Spring Boot–based REST API** that allows users to convert images between formats (**PNG ↔ JPG**) and perform basic image processing operations such as **resize, crop, and rotate**.

It is designed as a backend service using **Java ImageIO**, making it lightweight, fast, and easy to integrate into any frontend or system.

---

## 🚀 Features

* 🔄 Convert image formats (PNG ↔ JPG)
* 📏 Resize images (custom width & height)
* ✂️ Crop images
* 🔁 Rotate images (90°, 180°, 270°)
* ⚡ Fast processing using Java ImageIO
* 🌐 RESTful API endpoints
* ❌ Error handling and validation

---

## 🛠️ Tech Stack

* **Backend:** Spring Boot
* **Language:** Java
* **Image Processing:** Java ImageIO
* **Build Tool:** Maven
* **API Testing:** Postman

---

## 📂 Project Structure

```
image-conversion-api-springboot/
│
├── controller/        # REST Controllers
├── service/           # Business Logic
├── util/              # Image processing logic
├── model/             # Request/Response classes
├── exception/         # Error handling
├── resources/
│   └── application.properties
└── pom.xml
```

---

## 📡 API Endpoints

### 1. Convert Image Format

**POST** `/api/convert`

**Request:**

* File (image)
* Target format (png/jpg)

**Response:**

* Converted image file

---

### 2. Resize Image

**POST** `/api/resize`

**Params:**

* width
* height

---

### 3. Crop Image

**POST** `/api/crop`

**Params:**

* x, y
* width, height

---

### 4. Rotate Image

**POST** `/api/rotate`

**Params:**

* angle (90, 180, 270)

---

## 🧪 Sample Usage (Postman)

### Convert PNG → JPG

* Method: POST
* URL: `http://localhost:8080/api/convert?format=jpg`
* Body: form-data → file upload

---

## ⚙️ How to Run

### Step 1: Clone Repo

```bash
git clone https://github.com/your-username/image-conversion-api-springboot.git
cd image-conversion-api-springboot
```

### Step 2: Build Project

```bash
mvn clean install
```

### Step 3: Run Application

```bash
mvn spring-boot:run
```

### Step 4: Test API

Use Postman or browser:

```
http://localhost:8080
```

---

## ❗ Error Handling

* Invalid file format → returns error message
* Missing parameters → validation error
* Unsupported operations → proper HTTP status codes

---

## 🔒 Limitations (Be honest — this matters)

* Supports only basic formats (PNG, JPG)
* No authentication (not production-ready)
* Large files may affect performance

---

## 📈 Future Improvements

* Add support for more formats (WEBP, BMP)
* Implement file size optimization
* Add authentication & security
* Deploy to cloud (AWS / Docker)
* Add frontend UI

---

## 👨‍💻 Author

Developed as a backend project using Spring Boot to demonstrate **real-world API design and image processing capabilities**.

---

## ⭐ Why This Project Matters

This is not just a "converter" — it demonstrates:

* REST API design
* File handling in backend
* Image processing logic
* Clean project structure

---

## 📌 Final Note

If your README looks weak, people assume your skills are weak.
This version is structured to look **job-ready**, not like a college submission.
