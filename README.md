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
