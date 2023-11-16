# Entity Relationship Diagram
    User ||--o{ Sales: "has (1 to 0 or many)"
    User {
        int UserId PK
        string username
        string password "At least 6 characters"
        boolean isAdmin
    }
    
    Sales o|--|| Inventory: "contains (0 or 1 to 1)"
    Sales {
        int saleID PK 
        int UserId FK
        int inventoryId FK
        int shippingTypeId FK
        date soldDate
        double grandTotal
        
    }
    Inventory {
        int inventoryId PK
        string name 
        string description
        double price

    }
    ShippingType ||--|| Sales: "1 to 1"
    ShippingType{
        int shippingTypeId PK
        string name
        double cost

    }


![ER diagram-2023-11-16-184014](https://github.com/jwats164/Team3Project/assets/140277706/dbf95501-fd51-4e28-8212-827b418be872)


