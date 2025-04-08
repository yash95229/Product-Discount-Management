# Product-Discount-Management

🛍️ Product Discount Management System 
This is a Spring Boot-based application that manages products and applies various discount rules. It supports:
•	Flat and percentage-based discounts
•	Optional seasonal discount (25%)
•	Final price calculation based on current date and discount rules
•	Product data persistence with JPA
•	Logging and error handling for clarity and robustness
The project provides REST APIs to add a new product, calculate discounts, and retrieve product details.
	
🔄 Workflow
1.	User sends a request with product details (price, quantity, discount type/value, seasonal flag).
2.	Validation: If quantity is 0 or less, an exception is thrown:
👉 "Product is out of stock."
3.	Main Discount is applied:
o	"flat": subtract discount value
o	"percentage": reduce price by given percentage
4.	Seasonal Discount (25%) is optionally applied if:
o	seasonalDiscountActive = true
o	Current date is within the seasonal range (today ± 5 days)


5.	The final price is calculated and the product is saved to the database.
6.	The response includes all product details and the computed final price.



🚀 How to Run the Project & Test via API
🔧 Prerequisites
•	Java 17+
•	Maven
•	Postgres (or your configured DB)
•	Postman / any REST client


▶️ Steps to Run
1.	Clone or download the project.
Run the app:
	mvn spring-boot:run 
or 
you can directly run from spring devtool and IDE.




📬 API Endpoints
	
✅ Add Product with Discount Calculation
•	POST : http://localhost:8080/product/discount
•	Request Body Example:
{
  "productId": "P5",
  "discountType": "percentage",
  "discountValue": 10,
  "seasonalDiscountActive":true,
  "productPrice": 100,
  "quantity": 5
}

📦 Get Product by ID
•	GET :   http://localhost:8080/product/P5 
