# StyleWithPen Stock Management Console Application

This project contains a Java console-based application developed for managing pen stocks for StyleWithPen, an online retailer specializing in stylish pens.

## Functionality

### Operations Available:

1. **Add New Pen**: Allows the admin to add a new pen to the inventory with details such as brand, color, ink color, material, initial stock quantity, price, and discount.

2. **Update Stock of a Pen**: Enables the admin to update the stock quantity of an existing pen.

3. **Set Discount**: Automatically applies a discount of 20% to all pens that have not been sold in the last 3 months.

4. **Remove Pens**: Removes pens from the inventory that have never been sold once listed and have been in stock for 9 months or longer.

## Data Management

- Java collections are used to store pen objects during runtime.
- Each pen is represented by an object of the `Pen` class, capturing attributes such as ID, brand, color, ink color, material, stock quantity, dates for stock update and listing, price, and discount.


