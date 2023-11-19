Description of fields in User
| Property | Type                | Default | Nullable | Relationship               | Notes                                                       |
|----------|---------------------|---------|----------|----------------------------|-------------------------------------------------------------|
| UserId   | Primary Key,<br>int |         | No       | Relate to <br>Sales.UserId | Automatically generated <br>when new user signs up          |
| username | string              |         | No       |                            | created by user                                             |
| password | string              |         | No       |                            | Needs to be 6 characters at <br>minimum, created by user    |
| isAdmin  | boolean             | false   | No       |                            | Tells whether or not user has <br>administrator privileges  |
