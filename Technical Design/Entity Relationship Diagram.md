# Entity Relationship Diagram
    User ||--o{ Sales: "has (1 to 0 or many)"
    User {
        int UserId PK
        string username
        string password "At least 6 characters"
    }
    
    Sales o|--|| Inventory: "contains (0 or 1 to 1)"
    Sales {
        int saleID PK 
        int UserId FK
        int inventoryId FK
        string shippingType
        
    }
    Inventory {
        int inventoryId PK
        string name 
        string description
        double price

    }


    
![ER diagram-2023-11-15-144338](https://github.com/jwats164/Team3Project/assets/140277706/25aed9e5-3aec-43da-9a55-7150a4e8612b)

