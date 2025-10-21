# PS39422 Lab4 - Thymeleaf 2

This Spring Boot project implements the following features:

## Features Implemented

### 1. Two-way Data Binding (Bài 1)
- **Staff Bean**: Created with Lombok annotations and validation
- **Staff Form**: Two-way data binding between bean and form
- **Controller**: Handles form submission and data processing
- **URLs**:
  - `/staff/create/form` - Display the form
  - `/staff/create/save` - Process form submission

### 2. Form Validation (Bài 2)
- **Validation Rules**:
  - Email: Required and valid email format
  - Fullname: Required
  - Gender: Required selection
  - Birthday: Required and must be in the past
  - Salary: Required and minimum 1000
- **Error Display**: Red error messages shown next to each field
- **URL**: `/staff/create/save` with validation

### 3. Layout Organization (Bài 4)
- **Layout Template**: Common structure with header, menu, content, footer
- **Pages**:
  - `/home/index` - Home page
  - `/home/about` - About page
- **Template Fragments**: Reusable layout components

### 4. Multilingual Support (Bài 5)
- **Languages**: Vietnamese (default) and English
- **Language Switching**: Click "Tiếng Việt" or "English" links
- **Internationalized Elements**:
  - Header title
  - Menu items
  - Footer copyright
  - Page titles

## How to Run

1. **Prerequisites**:
   - Java 17
   - Eclipse IDE
   - Spring Boot 3.5.6

2. **Run the Application**:
   - Import the project into Eclipse
   - Right-click on `Ps39422Lab4Application.java`
   - Select "Run As" → "Java Application"
   - Or use the Spring Boot run configuration

3. **Access the Application**:
   - Open browser and go to `http://localhost:8080`
   - Navigate to different pages:
     - Home: `http://localhost:8080/home/index`
     - About: `http://localhost:8080/home/about`
     - Staff Form: `http://localhost:8080/staff/create/form`

## Project Structure

```
src/
├── main/
│   ├── java/poly/edu/
│   │   ├── Ps39422Lab4Application.java
│   │   ├── controller/
│   │   │   ├── HomeController.java
│   │   │   └── StaffController.java
│   │   ├── model/
│   │   │   └── Staff.java
│   │   └── config/
│   │       └── MessageConfig.java
│   └── resources/
│       ├── application.properties
│       ├── i18n/
│       │   ├── layout.properties (English)
│       │   └── layout_vi.properties (Vietnamese)
│       ├── static/photos/
│       │   └── photo.jpg
│       └── templates/
│           ├── demo/
│           │   ├── staff-create.html
│           │   └── staff-validate.html
│           ├── home/
│           │   ├── index.html
│           │   └── about.html
│           └── shared/
│               ├── layout.html
│               └── menu.html
```

## Key Technologies Used

- **Spring Boot 3.5.6**
- **Thymeleaf** for templating
- **Lombok** for reducing boilerplate code
- **Bean Validation** for form validation
- **Spring MVC** for web layer
- **Internationalization (i18n)** for multilingual support

## Testing the Features

1. **Data Binding**: Fill out the staff form and submit to see data persistence
2. **Validation**: Submit empty form to see validation error messages
3. **Layout**: Navigate between home and about pages to see consistent layout
4. **Multilingual**: Click language links to switch between Vietnamese and English
