# Library Management System
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![GitHub](https://img.shields.io/badge/GitHub-100000?style=for-the-badge&logo=github&logoColor=white)
## Description
A Java console application that simulates a real library management system.
Built from scratch as a first major Java project, focusing on OOP principles,
clean architecture and data persistence.
---
## Features
- Add, remove and search books
- Add, remove and search members  
- Borrow and return books
- Automatic due date calculation (14 days)
- Overdue book detection
- Auto-generated unique IDs (B001, M001...)
- Data persistence using CSV files
- Input validation and error handling
---
## Technologies Used
- Java SE
- CSV file storage (BufferedReader / BufferedWriter)
- LocalDate for date handling
- OOP — Encapsulation, MVC architecture
---
## How to Run
1. Clone the repository
```bash
git clone https://github.com/Dodopoud/Library-Management-Project
```
2. Open in Eclipse or any Java IDE
3. Run `Main.java`
4. Login with admin credentials (see `Admin.java`)
5. Use the menu to interact with the system
## Project Structure
```
src/
├── Main.java      → Entry point, handles user interaction
├── Library.java   → Brain of the system, manages all logic
├── Book.java      → Represents a book
├── Member.java    → Represents a library member
├── Borrow.java    → Represents a borrow record with due date
```
---
## 👩‍💻 Author
**DIMITRA DODOPOULOU**  
📎 [GitHub](https://github.com/Dodopoud)

