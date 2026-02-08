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
