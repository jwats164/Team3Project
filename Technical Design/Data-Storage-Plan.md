# Data Storage Plan

SQLite was chosen as the database solution for our e-commerce desktop application selling miniature cars due to its lightweight, serverless architecture and seamless integration with Java applications. SQLite is a self-contained, file-based database engine, making it easy to deploy and manage, which is advantageous for a desktop application scenario.

The decision to use SQLite is based by the following reasons:

- **Portability:** SQLite databases are simple files, allowing for easy portability and distribution of the database along with the desktop application. This simplicity aligns well with the needs of a miniature car e-commerce platform.

- **Zero Configuration:** SQLite does not require a separate server process or complex setup. This zero-configuration approach simplifies the deployment process, making it more straightforward to manage and maintain the database for the desktop application.

- **Efficient Resource Utilization:** As a serverless database engine, SQLite is known for its low resource requirements. This efficiency is particularly beneficial for a desktop application, ensuring optimal performance even on systems with limited resources.

- **Ease of Use with Java:** SQLite integrates seamlessly with Java applications through JDBC (Java Database Connectivity), simplifying database operations within the Java Swing application. This ease of integration streamlines the development process and allows for efficient interaction with the database.

By opting for SQLite as the database solution, our group aims to achieve a well-optimized, portable, and reliable data storage mechanism that aligns with the specific requirements of the miniature car e-commerce desktop application.

