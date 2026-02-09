# RESTful API Assignment

## Base URL
`http://localhost:8080/api`

## Book API Endpoints

### 1. Get All Books
- **GET** `/books`
- Returns all books in the library
- Example: `http://localhost:8080/api/books`

### 2. Get Book by ID
- **GET** `/books/{id}`
- Returns a specific book by ID
- Example: `http://localhost:8080/api/books/1`

### 3. Search Book by Title
- **GET** `/books/search?title={title}`
- Search for a book by exact title
- Example: `http://localhost:8080/api/books/search?title=Chernobyl`

### 4. Add New Book
- **POST** `/books?title={title}&id={id}`
- Adds a new book to the library
- Example: `http://localhost:8080/api/books?title=New Book&id=4`

### 5. Delete Book
- **DELETE** `/books/{id}`
- Deletes a book by ID
- Example: `http://localhost:8080/api/books/1`

## Student API Endpoints

### 1. Get All Students
- **GET** `/students`
- Returns all students
- Example: `http://localhost:8080/api/students`

### 2. Get Student by ID
- **GET** `/students/{id}`
- Returns a specific student by ID
- Example: `http://localhost:8080/api/students/1`

### 3. Get Students by Major
- **GET** `/students/major/{major}`
- Returns all students in a specific major
- Example: `http://localhost:8080/api/students/major/Computer Science`

### 4. Filter Students by GPA
- **GET** `/students/filter?gpa={gpa}`
- Returns students with GPA greater than or equal to specified value
- Example: `http://localhost:8080/api/students/filter?gpa=3.5`

### 5. Add New Student
- **POST** `/students?firstname={firstname}&lastname={lastname}&email={email}&major={major}&gpa={gpa}`
- Adds a new student
- Example: `http://localhost:8080/api/students?firstname=John&lastname=Doe&email=john@auca.edu.bi&major=Engineering&gpa=3.7`

### 6. Update Student
- **PUT** `/students/{id}?firstname={firstname}&lastname={lastname}&email={email}&major={major}&gpa={gpa}`
- Updates an existing student by ID
- Example: `http://localhost:8080/api/students/1?firstname=Jane&lastname=Smith&email=jane@auca.edu.bi&major=Business&gpa=3.9`

## Product API Endpoints

### 1. Get All Products
- **GET** `/products`
- Returns all products
- Example: `http://localhost:8080/api/products`

### 2. Get Product by ID
- **GET** `/products/{id}`
- Returns a specific product by ID
- Example: `http://localhost:8080/api/products/1`

### 3. Get Products by Category
- **GET** `/products/category/{category}`
- Returns all products in a specific category
- Example: `http://localhost:8080/api/products/category/Electronics`

### 4. Get Products by Brand
- **GET** `/products/brand/{brand}`
- Returns all products from a specific brand
- Example: `http://localhost:8080/api/products/brand/Acme`

### 5. Search Products by Keyword
- **GET** `/products/search?keyword={keyword}`
- Searches products by name or description (case-insensitive)
- Example: `http://localhost:8080/api/products/search?keyword=phone`

### 6. Get Products by Price Range
- **GET** `/products/price-range?min={min}&max={max}`
- Returns products within specified price range
- Example: `http://localhost:8080/api/products/price-range?min=10&max=200`

### 7. Get In-Stock Products
- **GET** `/products/in-stock`
- Returns only products with stock quantity greater than 0
- Example: `http://localhost:8080/api/products/in-stock`

### 8. Add New Product
- **POST** `/products?name={name}&description={description}&price={price}&category={category}&stockQuantity={stockQuantity}&brand={brand}`
- Adds a new product
- Example: `http://localhost:8080/api/products?name=Laptop&description=Gaming laptop&price=1299.99&category=Electronics&stockQuantity=15&brand=TechBrand`

### 9. Update Product
- **PUT** `/products/{id}?name={name}&description={description}&price={price}&category={category}&stockQuantity={stockQuantity}&brand={brand}`
- Updates an existing product by ID
- Example: `http://localhost:8080/api/products/1?name=Updated Phone&description=New description&price=599.99&category=Electronics&stockQuantity=40&brand=Acme`

### 10. Update Product Stock
- **PUT** `/products/{id}/stock?quantity={quantity}`
- Updates only the stock quantity of a product
- Example: `http://localhost:8080/api/products/1/stock?quantity=100`

### 11. Delete Product
- **DELETE** `/products/{id}`
- Deletes a product by ID
- Example: `http://localhost:8080/api/products/1`

## Task Management API Endpoints

### 1. Get All Tasks
- **GET** `/tasks`
- Returns all tasks
- Example: `http://localhost:8080/api/tasks`

### 2. Get Task by ID
- **GET** `/tasks/{id}`
- Returns a specific task by ID
- Example: `http://localhost:8080/api/tasks/1`

### 3. Get Tasks by Status
- **GET** `/tasks/status?completed={true|false}`
- Returns tasks filtered by completion status
- Example: `http://localhost:8080/api/tasks/status?completed=true`

### 4. Get Tasks by Priority
- **GET** `/tasks/priority/{priority}`
- Returns tasks with specified priority (LOW, MEDIUM, HIGH)
- Example: `http://localhost:8080/api/tasks/priority/HIGH`

### 5. Add New Task
- **POST** `/tasks?title={title}&description={description}&completed={true|false}&priority={priority}&dueDate={dueDate}`
- Creates a new task
- Example: `http://localhost:8080/api/tasks?title=New Task&description=Task description&completed=false&priority=MEDIUM&dueDate=2024-12-25`

### 6. Update Task
- **PUT** `/tasks/{id}?title={title}&description={description}&completed={true|false}&priority={priority}&dueDate={dueDate}`
- Updates an existing task by ID
- Example: `http://localhost:8080/api/tasks/1?title=Updated Task&description=New description&completed=false&priority=HIGH&dueDate=2024-12-30`

### 7. Mark Task as Complete
- **PATCH** `/tasks/{id}/complete`
- Marks a task as completed
- Example: `http://localhost:8080/api/tasks/1/complete`

### 8. Delete Task
- **DELETE** `/tasks/{id}`
- Deletes a task by ID
- Example: `http://localhost:8080/api/tasks/1`

## User Profile API Endpoints

Note: All User Profile endpoints return responses wrapped in an ApiResponse object with `success`, `message`, and `data` fields.

### 1. Get All Users
- **GET** `/users`
- Returns all user profiles
- Example: `http://localhost:8080/api/users`

### 2. Get User by ID
- **GET** `/users/{id}`
- Returns a specific user profile by ID
- Example: `http://localhost:8080/api/users/1`

### 3. Search User by Username
- **GET** `/users/search/username/{username}`
- Returns user profile by username
- Example: `http://localhost:8080/api/users/search/username/john_doe`

### 4. Get Users by Country
- **GET** `/users/country/{country}`
- Returns all users from a specific country
- Example: `http://localhost:8080/api/users/country/USA`

### 5. Get Users by Age Range
- **GET** `/users/age-range?min={min}&max={max}`
- Returns users within specified age range
- Example: `http://localhost:8080/api/users/age-range?min=20&max=30`

### 6. Add New User
- **POST** `/users?username={username}&email={email}&fullName={fullName}&age={age}&country={country}&bio={bio}`
- Creates a new user profile (active by default)
- Example: `http://localhost:8080/api/users?username=new_user&email=user@example.com&fullName=New User&age=25&country=USA&bio=Developer`

### 7. Update User
- **PUT** `/users/{id}?username={username}&email={email}&fullName={fullName}&age={age}&country={country}&bio={bio}`
- Updates an existing user profile by ID
- Example: `http://localhost:8080/api/users/1?username=updated_user&email=updated@example.com&fullName=Updated Name&age=26&country=Canada&bio=Senior Developer`

### 8. Activate User
- **PATCH** `/users/{id}/activate`
- Activates a user profile
- Example: `http://localhost:8080/api/users/1/activate`

### 9. Deactivate User
- **PATCH** `/users/{id}/deactivate`
- Deactivates a user profile
- Example: `http://localhost:8080/api/users/1/deactivate`

### 10. Delete User
- **DELETE** `/users/{id}`
- Deletes a user profile by ID
- Example: `http://localhost:8080/api/users/1`

## Menu API Endpoints

### 1. Get All Menu Items
- **GET** `/menu`
- Returns all menu items
- Example: `http://localhost:8080/api/menu`

### 2. Get Menu Item by ID
- **GET** `/menu/{id}`
- Returns a specific menu item by ID
- Example: `http://localhost:8080/api/menu/1`

### 3. Get Items by Category
- **GET** `/menu/category/{category}`
- Returns menu items in the specified category (case-insensitive)
- Example: `http://localhost:8080/api/menu/category/Main%20Course`

### 4. Get Only Available Items
- **GET** `/menu/available?available={true|false}`
- Returns items filtered by availability. If `available` is omitted, returns all items.
- Example: `http://localhost:8080/api/menu/available?available=true`

### 5. Search Menu Items by Name
- **GET** `/menu/search?name={name}`
- Searches menu items by name (partial, case-insensitive)
- Example: `http://localhost:8080/api/menu/search?name=burger`

### 6. Add New Menu Item
- **POST** `/menu`
- Adds a new menu item. Provide JSON body with `name`, `price`, `category`, and optional `available` (defaults to `true` if omitted).
- Example JSON body:

```json
{
	"name": "Veggie Wrap",
	"price": 6.5,
	"category": "Entree",
	"available": true
}
```

Curl example:

```bash
curl -X POST http://localhost:8080/api/menu \
	-H "Content-Type: application/json" \
	-d '{"name":"Veggie Wrap","price":6.5,"category":"Entree","available":true}'
```

### 7. Toggle Item Availability
- **PUT** `/menu/{id}/availability`
- Toggles the `available` flag for the specified menu item and returns the updated item.
- Example: `http://localhost:8080/api/menu/2/availability`

### 8. Delete Menu Item
- **DELETE** `/menu/{id}`
- Removes the specified menu item. Returns HTTP 204 on success.
- Example: `http://localhost:8080/api/menu/3`
