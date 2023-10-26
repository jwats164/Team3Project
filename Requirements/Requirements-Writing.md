# Version 1

## FUTURE USER INTERFACE DESIGN IN MARVEL
  ### T3E-26: DESIGN UI LOGIN PROCESS
    T3S-27: CREATE REGULAR AND ADMIN LOGIN
    
      - Priority: Must Have
      - Estimated Effort: 1-2 Days
      - Functional or Non-Functional: Functional
      - Description: All users can create a login using a unique username and a
                     six-character minimum password. 
      
    T3S-28: ALLOW SELF REGISTRATION

      - Priority: Must Have
      - Estimated Effort: 1-2 days
      - Functional or Non-Functional: Functional
      - Description: Allow users to register an account if it's their first time
                     logging in, and transforming regular accounts into Admin accounts
                     as needed. 

 ### T3E-56: ENABLE ACCESS TO PRODUCTS
    T3S-29: CREATE INVENTORY LIST(INCLUDING SEARCH)     
      
      - Priority: Must Have
      - Estimated Effort: 1-2 days
      - Functional or Non-Functional: Functional
      - Description: Implement a main screen of a list of all available inventory
                     sorted by highest price to lowest price.
    
    T3S-30: CREATE PRODUCT VIEW
    
      - Priority: Must Have
      - Estimated Effort: 3-4 days
      - Functional or Non-Functional: Functional
      - Description: Design a portfolio for each product that includes a name,
                     price, picture, and description. A button will also be added to ensure that
                     desired items can be added to a cart to be viewed later at checkout.
        

### T3E-57 CREATE PURCHASE AND ACQUISITION SYSTEM
    T3S-31: CREATE SHOPPING CART (INCLUDING REMOVAL)     
      
      - Priority: Must Have
      - Estimated Effort: 5 days
      - Functional or Non-Functional: Functional
      - Description: Build a cart where items that the customer is interested in 
                     can accumulate. Allow users to remove items from their carts as
                     well. If there are zero items in the cart or all of the items
                     in the cart were removed, prohibit customers from entering the
                     checkout phase and take them back to the main shopping page.

    T3S-32: CREATE CHECKOUT(INCLUDING PAYMENT ACCEPTANCE AND ON-SCREEN RECEIPT)

      - Priority: Must Have
      - Estimated Effort: 5 days
      - Functional or Non-Functional: Functional
      - Description: Create a checkout system that allows customers to view each of their
                     products, the subtotal of all the products in US dollars, and to remove
                     any undesired items still left in their cart. Incorporate a pay now button
                     where users must enter their shipping address, credit card
                     information(Number, expiration date, and CVV), phone number, and shipping 
                     speed (Overnight: $29, 3-day: $19, Ground: $0). Once they finish, present the
                     confirm order button which will lead them to a list showing their items, their 
                     subtotal, a 6% tax of the subtotal added, shipping speed, and grand total
                     to finalize the process, the user will click the complete order button which
                     will result in their receipt, address, and the last 4 digits of their card
                     being displayed. The inventory the user bought will be removed from the
                     main page and search as well.
      
      
    T3S-33: CREATE SALES REPORT
     
      - Priority: Must Have
      - Estimated Effort: 1-3 days
      - Functional or Non-Functional: Functional
      - Description: Allow Admin users to create sales reports to track sales, inventory,
                     and customers who are making purchases. Along with this, Admin users
                     will be able to add inventory to the designated database as needed.
    

    




## Future Technical Design
  ### T3E-37 Create Technical Design Detailing

    T3S-42: DESIGN SERVICES (User Must be able to self-register and login)

      - Priority: Must Have
      - Estimated Effort: 1 to 2 days 
      - Functional or Non-Functional: Functional
      - Description: The user must be able to log in via the GUI interface provided.
                     The information provided by the user during the login phase will
                     be a username (unique) and a password. This information will be stored   
                     in the database to keep track of users that are registered to the       
                     store. Other requirements for the login process include that the admin  
                     must be able to log in using the same process as an average non-admin 
                     user.
                     
     T3S-41: DESIGN SERVICES (The shopping cart design)

      - Priority: Must Have
      - Estimated Effort: 1 day
      - Functional or Non-Functional: Functional
      - Description: It is required that the shopping cart must be able to contain
                     items that the user wants to purchase. The shopping cart can also
                     be empty. Items in the shopping cart will be implemented in a way
                     that can be modified up to the checkout process. The exact way
                     that the shopping cart will be implemented will be discussed
                     in the technical design milestone.
    
    T3S-43: SEED DATA (Data that must be implemented from the start)

      - Priority: Must Have
      - Estimated Effort: 2 days
      - Functional or Non-Functional: Functional 
      - Description: A user cannot self-register as an admin. The ability to grant
                     a user the admin role can only be done by another admin. This 
                     presents a problem. If there are no admin roles from the beginning
                     then there cannot be any admins at all. Therefore we will seed
                     some data that will grant the online store owner that admin
                     role. 
    
    T3S-44: DESIGN DATA STORAGE (What type of data will be stored)

      - Priority: Must Have
      - Estimated Effort: 1 day
      - Functional or Non-Functional: Functional
      - Description: The type of currency being stored and used for this project
                     will be USD. The format that the money will be displayed  will include
                     the $ symbol, commas, and decimals.
                     An example might look like this, $456.23 or $300.00. Any 
                     currency that will be stored or written in the code will be written
                     as the price in cents and stored as an integer. This will avoid
                     any potential issues with using floating points.
    
    T3S-44: DESIGN DATA STORAGE (Addressing the more Admin powers related to data)

      - Priority: Must Have
      - Estimated Effort: 1 day
      - Functional or Non-Functional: Functional
      - Description: The admin will be able to access the stored data relating to the
                     purchases of the inventory items. The admin will be able to run sales
                     reports that show everything purchased and who purchases it. This 
                     data will be stored using a SQL database. The admin will also be
                     able to add inventory. For version one manually inputing the 
                     data in the database will have to do.
    

## FUTURE IMPLEMENTATION



# Version 2

  ## FUTURE USER INTERFACE DESIGN IN MARVEL
   ### T3E-26: DESIGN UI LOGIN PROCESS
       T3S-62: CREATE UI TO MAKE AN ADMIN
        
        - Priority: Want to Have
        - Estimated Effort: 2 Days
        - 
        - Description: A simple user interface for admins to transform a regular user into an admin
        
   ### T3E-56: ENABLE ACCESS TO PRODUCTS
       T3S-59: ADD ADDITIONAL PICTURES TO EACH INVENTORY ITEM

        - Priority: Want to Have
        - Estimated Effort: 2 Days
        - Functional or Non-Functional: Functional
        - Description: The system supports at least one picture for each item, but this enhancement aims
                       to provide the capability to attach additional images to an inventory item.

       T3S-63: CREATE UI TO ADD NEW INVENTORY TO SYSTEM
        
         - Priority: Want to Have
         - Estimated Effort: 2 Days
         - Functional or Non-Functional: Functional
         - Description: Admins need a way to add new inventory to the system, with a preference for a user 
                        interface but an option for manual data entry.
         
  ### T3E-57 CREATE PURCHASE AND ACQUISITION SYSTEM
      T3S-60: EMAIL RECEIPTS TO THE USER 

        - Priority: Must Have
        - Estimated Effort: 1-2 Days
        - Functional or Non-Functional: Functional
        - Description: When a user successfully completes an order, the system will generate 
                       a receipt containing the details of the purchased items, subtotal, tax, shipping costs,
                       and the grand total. This receipt will then be emailed to the user's registered email 
                       address for their records and reference. 

      TS3-61: ADMIN CAN EXPORT THE SALES REPORT TO CSV

        - Priority: Must Have
        - Estimated Effort: 1-2 Days
        - Functional or Non-Functional: Functional
        - Description: Admins must be able to run a sales report in a CSV showing everything purchased and who
                       purchased it. Admins can click on a sold item and it shows them the receipt related to that.
