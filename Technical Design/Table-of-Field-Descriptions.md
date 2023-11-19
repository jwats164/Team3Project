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
