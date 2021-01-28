# inventory-app
Inventory Management System Java project repository

## Team description
  - Institute name: Rajarambapu Institute of Technology (RBIT)
  - Institute city: Uran Islampur (Sangli), Maharashtra (India)

**Team members:**
  - Mr. Akash Mahajan (Lead)
  - Mr. Hrishikesh Mhetre
  - Mr. Sanket Kale
  - Mr. Shubham Teke
  - Mr. Aditya Dalavi

## Overview
Inventory Management System is an application written in Java used to manage and buy/sell inventory in an godown. Traditional godown uses the account book which is paper-based. There are numerous causes of losing this paper based data. Inventory Management System resolves this problem by enabling the user to put data on computer and manage it through either Command-line Interface (CLI) or a separate web app can be created using Spring Boot.

## List of APIs
  - LinkedList
  - Common
  - Admin
  - User
  - Inventory

### Description of APIs

  - LinkedList (LinkedList.java)
    - Stores a bought item from inventory in memory as a linkedlist
    - The number of items on an list of bought items is unpredictable hence, linkedlist is used.
    - Dependancy: None
   
  - Common (Common.java)
    - Has a list of methods defined and declared inside an abstract class Common
    - Collects common method which are similar to Admin and User of application
    - Dependancy: None
    
  - Admin (Admin.java)
    - Admin is important role in application
    - Admin has permission to modify inventory and its details, view list of product etc.
    - Dependancy: Common API
    
  - User (User.java)
    - User is another important role in application
    - User has permission to buy products, create and empty product cart, create bill only. No access to modify inventory.
    - Dependancy: Common API, LinkedList API
    
  - Inventory (Inventory.java)
    - This is entrypoint of application gives user and admin an interface to interact with above mentioned APIs and database
    - Dependancy: Common API, Admin API and User API
    
### Technical description
  - Java version: JDK 11.0.9.1 or OpenJDK-11-amd64
  - MySQL version: mysqlnd 7.4.14
  - Other details: Ubuntu 20.04 Focal Fossa platform used, XAMPP with Apache + MariaDB + PHP + Perl for Linux

### Application Internal Description
  - Before you can execute Inventory.java, do following:
    - Import _inventory.sql_ in your MyPHPAdmin or MySQL database
    - The default connection string used is _http://localhost:3306/inventory_
    - Also make sure that, _com.mysql.cj.jdbc.Driver_ driver is installed and ready to use on your system
    
### Developer's contact
**Created by Akash Mahajan <akashmahajan025@gmail.com>, Hrishikesh Mhetre <hrmhetre@gmail.com>**
