## Municipality Request Management System

### Overview
The Municipality Request Management System is a Java application designed to facilitate the management of various types of requests made by different types of users to a municipality or local government authority. It provides functionalities for users such as employees, individuals, students, retirees, and legal entities to submit requests for various administrative tasks, such as document replacements, registrations, and authorizations.

### Features
1. **User Types**: Supports different types of users including employees, individuals, students, retirees, and legal entities.
2. **Request Submission**: Users can submit requests for different administrative tasks.
3. **Request Validation**: The system validates submitted requests based on the user type and the type of request.
4. **Request Processing**: Once validated, requests are processed and approved by the relevant authority.
5. **Request Tracking**: Users can track the status of their submitted requests.
6. **File Management**: Supports reading input files containing request data and writing output files with processed request information.
7. **Sorting and Filtering**: Requests are sorted chronologically and filtered based on the type of user and request.

### User Types and Request Types
1. **Employee**: Can submit requests related to administrative tasks within their company.
   - Request Types: Document replacements, salary income registration.

2. **Individual**: Regular citizens who can request administrative services.
   - Request Types: Document replacements, driver's license replacements.

3. **Student**: Students enrolled in educational institutions who can request administrative services related to their schooling.
   - Request Types: Document replacements, student ID card replacements.

4. **Retiree**: Pensioners who can request administrative services related to their pension benefits.
   - Request Types: Document replacements, pension coupons registration.

5. **Legal Entity**: Companies or organizations that can request administrative services on behalf of their entity.
   - Request Types: Establishment of articles of incorporation, renewal of permits.

### Technology Stack
- Java
- File I/O for input/output operations
- Object-oriented programming principles

### How to Use
1. Compile the Java files.
2. Run the `ManagementPrimarie` class with appropriate command-line arguments specifying input files.
3. View processed requests in the output files.
