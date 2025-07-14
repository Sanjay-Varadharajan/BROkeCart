# 🛒 BROkeCart – E-Commerce Backend Application

BROkeCart is a fully functional **Spring Boot-based e-commerce backend** that handles customer, product, order, seller, and rating management via REST APIs. This project is perfect for learning and showcasing backend architecture using Java, MySQL, and Spring Data JPA.

---

## 🚀 Features

- 👤 **Customer Management**: Add, update, delete, and fetch customers
- 🛍️ **Product Management**: Full CRUD for products
- 🧑‍💼 **Seller Management**: Manage sellers and their details
- 📦 **Order Placement**: Customers can place and remove orders
- ⭐ **Review System**: Customers can rate and review sellers
- 🛠️ **Clean Architecture**: Follows service-repo-model-controller structure

---

## 🧰 Tech Stack

- **Java 21**
- **Spring Boot 3**
- **Spring Data JPA**
- **MySQL**
- **Lombok**
- **RESTful APIs**

---

## 📂 Project Structure

com.example.E_Commerce
├── controller/
├── model/
├── repository/
├── service/
└── ECommerceApplication.java

yaml
Copy
Edit

---

## 🔧 Setup & Run

1. Clone this repo  
   `git clone https://github.com/your-username/BROkeCart.git`

2. Import into your IDE (Spring Tool Suite / IntelliJ)

3. Configure `application.properties` with your MySQL credentials

4. Run the project  
   `ECommerceApplication.java`

---

## 📮 API Endpoints

- `GET /BROke_cart/customers`
- `POST /BROke_cart/addcustomer`
- `POST /BROke_cart/addproduct`
- `POST /BROke_cart/placeorder/{cus_id}`
- `POST /BROke_cart/addreview/{cus_id}/{seller_id}?stars=5&comment=Great!`
- ...and many more!

---

## 🤝 Contribution

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

---

## 📜 License

This project is open-source and free to use.

---

### 🔥 Built with dedication by **Sanjay V**  
