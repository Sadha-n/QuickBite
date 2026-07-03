# 🍔 QuickBite – Food Delivery Web Application

QuickBite is a Java Full Stack Food Delivery Web Application inspired by platforms like Swiggy and Zomato. It allows users to browse restaurants, explore menus, add items to the cart, place orders, and manage their profiles. The application follows the MVC architecture and is developed using Java, JSP, Servlets, JDBC, MySQL, HTML, and CSS.

---

## 🚀 Features

### 👤 User Features
- User Registration & Login
- Secure Authentication
- Browse Restaurants
- View Restaurant Menus
- Add/Remove Items from Cart
- Update Item Quantity
- Checkout & Place Orders
- Order Success Page
- View Order History
- View Order Details
- User Profile Management
- Logout

---

## 🏪 Restaurant Features

- Restaurant Listing
- Restaurant Details
- Dynamic Menu Display
- Restaurant Ratings
- Estimated Delivery Time
- Restaurant Status (Open/Closed)

---

## 🛒 Cart Features

- Add to Cart
- Remove from Cart
- Update Quantity
- Calculate Total Price
- Session-Based Cart Management

---

## 📦 Order Features

- Place Orders
- View Previous Orders
- View Ordered Items
- Order Confirmation

---

## 🛠️ Tech Stack

### Backend
- Java
- Servlets
- JSP
- JDBC

### Frontend
- HTML
- CSS

### Database
- MySQL

### Server
- Apache Tomcat 10

### IDE
- Eclipse IDE

---

## 🏗️ Architecture

The project follows the **MVC (Model-View-Controller)** architecture.

- **Model** → Java Beans
- **View** → JSP Pages
- **Controller** → Servlets
- **Database Layer** → JDBC & DAO Pattern

---

## 📂 Project Structure

```
src/
 └── main/
      ├── java/
      │     ├── DAO
      │     ├── DAOImpl
      │     ├── model
      │     ├── servlets
      │     └── Utility
      │
      ├── resources
      │     └── password.properties (Ignored from Git)
      │
      └── webapp/
            ├── images
            ├── WEB-INF
            └── JSP Pages
```

---

## ⚙️ Setup Instructions

1. Clone the repository

```
git clone https://github.com/Sadha-n/QuickBite.git
```

2. Import the project into Eclipse.

3. Configure Apache Tomcat.

4. Create a MySQL database.

5. Update the database credentials.

Create the following file:

```
src/main/resources/password.properties
```

Example:

```
db.password=YOUR_MYSQL_PASSWORD
```

Also update the username inside `DBConnection.java` if required.

6. Run the project on Apache Tomcat.

---

## 📸 Screenshots

![image alt](https://github.com/Sadha-n/QuickBite/blob/c896760a5b4a08d50833cb83b2df5cade577fb76/github_quickybites.jpg)

## 👨‍💻 Developed By

**Sadha N**

Java Full Stack Developer

GitHub: https://github.com/Sadha-n

LinkedIn:https://www.linkedin.com/in/sadha-n/

---

## ⭐ If you found this project useful, don't forget to Star the repository!
