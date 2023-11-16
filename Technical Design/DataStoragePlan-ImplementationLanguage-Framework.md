# Mini-Mobile Development Process
This developer guide will instruct our developers on implementing the desired technical tools to guarantee that the application produces minimal bugs, allows the implementation stage to be more feasible, and ensures the customer is beyond satisfied. 


## Coding Style

- Indent to help organize which elements are within each other.  

- Use Camel Case(Ex. bigNumberOne) when naming variables.

- Name variables with at least the first three letters of each word used. If variables are difficult to understand with shortened words in the name, use each of the letters for each word to avoid confusion.  

- Keep functions within at most 30 lines of code.

- Use comments when describing data structures and algorithms to complete a task. Simple tasks that don't need much understanding are exempt from needing comments.  

- When debugging, isolate the section from which the error line is contained and backtrack previous lines of code or functions used to find the issue. Once the issue is found and there isn't a simple fix, make comments around the error until it is fixed so that other members understand. 


## Why Java? 
[**Java Tutorial**](https://www.w3schools.com/java/default.asp)

Outside of Java being a well-known language by the majority of the development team, it has a great number of positive impacts that other languages may not. This will make using the framework simpler to work with, since all of the beneficial characteristics of Java will be incorporated into that software as well.

- **Strong Library:** Java has a robust and extensive standard library that provides a wide range of built-in classes and methods, making it easier for developers to perform common tasks without having to write code. This accelerates development and ensures consistency across projects. 

- **Multithreading:** Java supports multithreading, allowing developers to create concurrent applications that can execute multiple threads simultaneously. This is particularly useful for improving performance and responsiveness in applications.

- **Object Oriented:** Java is an exceptional programming language for object-oriented programming and incorporating functions since many of the embedded classes and objects within our Java IDEs are made to support this.

- **Platform Independence:** Another advantage of Java is its platform independence. Java programs can run on any device that has a Java Virtual Machine, allowing developers to write code once and run it on different platforms without modification. This will be a necessity so that our developers can collaborate without having to work on the same device.

These characteristics make Java a suitable choice for our most efficient desktop application while providing our customers with the least complex and appealing model. 
    

## Why Swing?
[**Swing Tutorial**](https://www.geeksforgeeks.org/introduction-to-java-swing/)

Java Swing is an established and reliable platform for creating desktop Java applications. It offers an extensive collection of tools and GUI components for developing interactive user interfaces. Because of Swing's flexibility, we can create unique user interfaces for our e-commerce desktop application.

Swing's extensive feature set makes it possible to design responsive and user-friendly interfaces that improve the user experience. A number of considerations went into the selection of Java Swing for our group's desktop e-commerce application :

 - **Platform Independence:** Java Swing applications are platform-independent, allowing our e-commerce application to run seamlessly on different operating systems without significant modifications.

- **Mature and Stable:** Swing has been a part of the Java Edition for many years, making it a mature and stable framework. This reliability is crucial for an e-commerce application handling transactions and inventory management.

- **Extensive Documentation and Community Support:** Java Swing benefits from extensive documentation and a large community of developers. This ensures that your team has access to resources, tutorials, and community support to overcome challenges and efficiently develop the application.

- **Integration Capabilities:** Swing supports easy integration with backend systems and databases, facilitating the seamless management of product listings, orders, and customer data for a miniature car e-commerce platform.

 - **Customization and Theming:** The flexibility of Swing allows your team to create a customized and detailed user interface that provides a unique look and feel for our e-commerce application. This is essential for creating a visually appealing shopping experience.

By utilizing Java Swing's capabilities, our group aims to deliver a reliable, cross-platform, and visually engaging desktop application tailored to the specific requirements of selling miniature cars in the e-commerce domain.


## Data Storage Plan
[**SQL Tutorial**](https://www.w3schools.com/sql/default.asp)

SQLite was chosen as the database solution for our e-commerce desktop application selling miniature cars due to its lightweight, serverless architecture and seamless integration with Java applications. SQLite is a self-contained, file-based database engine, making it easy to deploy and manage, which is advantageous for a desktop application scenario.

The decision to use SQLite is based on the following reasons:

- **Portability:** SQLite databases are simple files, allowing for easy portability and distribution of the database along with the desktop application. This simplicity aligns well with the needs of a miniature car e-commerce platform.

- **Zero Configuration:** SQLite does not require a separate server process or complex setup. This zero-configuration approach simplifies the deployment process, making it more straightforward to manage and maintain the database for the desktop application.

- **Efficient Resource Utilization:** As a serverless database engine, SQLite is known for its low resource requirements. This efficiency is particularly beneficial for a desktop application, ensuring optimal performance even on systems with limited resources.

- **Ease of Use with Java:** SQLite integrates seamlessly with Java applications through JDBC (Java Database Connectivity), simplifying database operations within the Java Swing application. This ease of integration streamlines the development process and allows for efficient interaction with the database.

By opting for SQLite as the database solution, our group aims to achieve a well-optimized, portable, and reliable data storage mechanism that aligns with the specific requirements of the miniature car e-commerce desktop application.




