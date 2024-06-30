# Pet Store Application

This project contains a Java console-based application for a Pet Store, designed to manage pets and orders. 
The application includes functionalities for both store owners (admins) and customers.

## Functionality Overview

### User Roles and Operations

1. **Admin User**
   - Login with credentials: loginId=admin, password=admin
   - Can perform all operations:
     - Add new Pet
     - Update Pet details
     - Update order status
     - Display all available pets
     - Order a Pet
     - Check order status by Order Id

2. **Customer**
   - Login with credentials: loginId=c1, password=c1
   - Can perform limited operations:
     - Display all available pets
     - Order a Pet
     - Check order status by Order Id

### Core Classes

- **Pet**
  - Attributes: petId, name, category (enum: CAT, DOG, RABBIT, FISH), unitPrice, stocks
- **Order**
  - Attributes: orderId, petId, quantity, status (enum: PLACED, IN_PROCESS, COMPLETED)

### Menu Options

1. **Login**: Required for both admin and customer to access functionalities.
2. **Add new Pet** (Admin only functionality)
3. **Update Pet details** (Admin only functionality)
4. **Display all available pets**
5. **Order a Pet**
6. **Check order status by Order Id**
7. **Update order status** (Admin only functionality)
8. **Exit**


