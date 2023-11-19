# Description of Fields in User
| Property | Type                | Default | Nullable | Relationship               | Notes                                                       |
|----------|---------------------|---------|----------|----------------------------|-------------------------------------------------------------|
| UserId   | Primary Key,<br>int |         | No       | Relate to <br>Sales.UserId | Automatically generated <br>when new user signs up          |
| username | string              |         | No       |                            | created by user                                             |
| password | string              |         | No       |                            | Needs to be 6 characters at <br>minimum, created by user    |
| isAdmin  | boolean             | false   | No       |                            | Tells whether or not user has <br>administrator privileges  |

# Description of Fields in Sales
| Property       | Type                | Default | Nullable | Relationship                              | Notes                                                                    |
|----------------|---------------------|---------|----------|-------------------------------------------|--------------------------------------------------------------------------|
| saleId         | Primary Key,<br>int |         | No       |                                           | Automatically generated <br>on new sale creation                         |
| UserId         | Foreign Key,<br>int |         | No       | Relates to<br>User.UserId                 | Automatically generated <br>when new user signs up                       |
| inventoryId    | Foreign Key,<br>int |         | No       | Relates to <br>Inventory.inventoryId      | Each item in inventory has <br>a unique id                               |
| shippingTypeId | Foreign Key,<br>int |         | No       | Relates to<br>ShippingType.shippingTypeId | When the user chooses a shipping <br>type, it is converted to an int 0-2 |
| soldDate       | date                |         | No       |                                           | Date the sale occurred is saved                                          |
| grandTotal     | double              |         | No       |                                           | Double of the total cost including <br>shipping and tax                  |

# Description of Fields in Inventory
| Property    | Type                | Default | Nullable | Relationship                     | Notes                                                                   |
|-------------|---------------------|---------|----------|----------------------------------|-------------------------------------------------------------------------|
| inventoryId | Primary Key,<br>int |         | No       | Relates to,<br>Sales.inventoryId | Each item in inventory has <br>a unique id                              |
| name        | string              |         | No       |                                  | Name of inventory item, given <br>on creation of inventory item         |
| description | string              |         | No       |                                  | Text describing inventory item, given <br>on creation of inventory item |
| price       | double              |         | No       |                                  | Price of inventory item, given <br>on creation of inventory item        |

# Description of Fields in ShippingType
| Property       | Type                | Default | Nullable | Relationship                        | Notes                                                                    |
|----------------|---------------------|---------|----------|-------------------------------------|--------------------------------------------------------------------------|
| shippingTypeId | Primary Key,<br>int |         | No       | Relates to,<br>Sales.shippingTypeId | When the user chooses a shipping <br>type, it is converted to an int 0-2 |
| name           | string              |         | No       |                                     | Name of shipping type, string is <br>determined by shippingTypeId        |
| cost           | double              |         | No       |                                     | Cost of shipping type, double is <br>determined by shippingTypeId        |
