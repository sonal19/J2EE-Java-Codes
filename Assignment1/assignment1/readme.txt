									Details about the Console Application
									^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

Input pattern:
^^^^^^^^^^^^^^
User has to pass the input as a string in the following format:
-name 1 { -type 2 [ -quantity 3 -price 4 ] } 

(1,2,3,4 are fields)

There are four Fields in the input string which contains-:
1. Name of item(hyphen is not allowed between two name)
2. Type of item (can be of 3 types-raw,imported,manufactured)
3.Quantity of Item
4.Price of Item

Note: { } -it means the attributes inside this bracket can be kept in any order
Note: [ ] -it means the attributes inside this bracket is optional

Remember-:
A hyphen ' - ' should be used before every attributes.
'name' attribute should be the first attribute.
'type' attribute is the mandatory attribute

More Details to save time from error input-:
1. -name-type raw (error as no space between name and type)
2. -name Maggi -type raw -quantity abc(error as string)
3. Generalized: -name (a) -type (b) -price (c) -quantity (d)
a- can't be empty space or null
b- by default, it is given it is mandatory
c,d- can't be empty space or String or out of range but it can be null(as it is optional)
--------------------------------------------------------------------------------------
Output Pattern:
^^^^^^^^^^^^^^
 Item Name : Field 1
 Item Price : Field 4 
 Item Type : Field 2 
 Item Quantity : Field 3 
 Item Tax : 
 Item Total Cost : 
----------------------------------------------------------------------------------------

Javadocs is available in the project folder.
Link is: Assignment1/doc/index.html
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Theoretical Details-:
 
This is simple console application to calculate Tax for an item.
It basically contains five packages constant, services, presentation, validation,exception.

PACKAGES

constant- This package contains two enum one for storing the business tax rate and another for storing the defined error codes.
There is one property file which stores the error codes with the messages.
A constant class is used to store constant values.

services- This package is having following classes: 
ItemsDetails class: It contains all the item properties with its getter and setter.This is an abstract class and having two abstract function.
ImportedItemType, RawItemType,ManufacturedItemType are three different class which is extending the abstract class ItemsDetails.It contains the tax calculation and total price calculation logic implementation seperatly.

presentation- It contains DisplayAllDetails Class which contains the main method and display the things in console window, and UserInput Class is used to take input from user and it also contails parsing detains which 
is converting the input from the user in HashMap with key value pairs. Later by accessing the key value can be invoked from the the input provided by the user.

validation- It contains a class for validating the user input.
Validation is done by using Regular Expressions and as given type is mandatory field in the user input and it should be raw, imported, manufactured and name should come at the inital position of the input.
In customExceptionHandling one class is created which is extending Exception class.

exception- It contains the custom Exception Handling class
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
