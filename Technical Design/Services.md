# Authentication Service

## Modules and Classes

**Module:** `auth_service`

**Class:** `UserAuthentication`

### Methods:

1. **registerUser(String username, String password) -> boolean**
   - Registers a new user with the provided username and password. Returns a boolean indicating the success of the registration.

2. **loginUser(String username, String password) -> boolean or Object(error message)**
   - Logs in a user with the provided username and password. Returns a boolean indicating the success of the login or an error message.

3. **grantAdminPrivileges(int userId) -> boolean**
   - Grants admin privileges to the specified user. Returns a boolean indicating the success of granting admin privileges.

4. **changeUserRole(int userId, String newRole) -> boolean**
   - Changes the role of a user to the specified role (e.g., from user to admin). Returns a boolean indicating the success of the role change.

### Relationship

The `UserAuthentication` class is responsible for managing user registration, login, role changes, and admin privileges. This class will inherit from a `DatabaseConnection` class to allow for easy access to the database fields.

# Inventory Management Service

## Modules and Classes

**Module:** `inventory_service`

**Class:** `InventoryManager`

### Methods:

1. **getAvailableInventory() -> List[Object(Photo photo, double price, String name, Sting description)]**
   - Retrieves a list of available inventory items with details. Returns a list of objects containing item information.

2. **searchInventory(String query) -> List[Object(Photo photo, double price, String name, Sting description)]**
   - Searches the inventory based on a provided query (item name or description). Returns a list of objects containing matched item information.

3. **addItemToCart(int userId, int itemId) -> boolean**
   - Adds the specified item to the user's shopping cart. Returns a boolean indicating the success of adding the item to the cart.

### Relationship

The `InventoryManager` class is responsible for retrieving available inventory, searching inventory, and managing items in the shopping cart. This class will also inherit from the `UserAuthentication` class as it will need access to the user's id and whether or not they're an admin. This class will inherit from a `DatabaseConnection` class to allow for easy access to the database fields.

# Shopping Cart Management Service

## Modules and Classes

**Module:** `cart_service`

**Class:** `ShoppingCartManager`

### Methods:

1. **viewShoppingCart(int userId) -> List[Object(Photo photo, double price, String name, Sting description)]**
   - Retrieves the contents of the user's shopping cart. Returns a list of dictionaries containing item information in the cart.

2. **removeItemFromCart(int userId, int itemId) -> boolean**
   - Removes the specified item from the user's shopping cart. Returns a boolean indicating the success of removing the item from the cart.

3. **checkout(int userId) -> List[Object(Photo photo, double price, String name, Sting description)], double grandTotal, int shippingType**
   - Initiates the checkout process for the user, providing a list of items, subtotal, tax, and total cost. Returns either a list of purchase details or an error message.

4. **completeOrder(int userId, Map<String, Object> paymentMethods) -> List[Object(Photo photo, double price, String name, Sting description)], double grandTotal, Date date**
   - Completes the order for the user, deducting items from inventory and generating a receipt. Returns either a list of purchase details or an error message.

### Relationship

The `ShoppingCartManager` class is responsible for managing the user's shopping cart, including viewing, removing items, and completing the checkout process. This class will also inherit from the `UserAuthentication` class as it will need access to the user's id and whether or not they're an admin. This class will inherit from a `DatabaseConnection` class to allow for easy access to the database fields.

