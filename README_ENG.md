# Framework 1º DAW

Project for the second quarter of the Programming class created by **Germán Rodríguez**. 


#Function
CRUD Menu written in Java.
The application allows you to  [**Create**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_create.java), [**Read**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_read.java), [**Update**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_update.java) y [**Delete**](src/exer3_1/Modules/Users/Model/BLL/BLL_User/CRUD/Functions_delete.java)
three type of users: 

1.  Administrators 
2.  Clients
3.  Normal Users. 

Each one has his own attributes and some of them are recalculated automatically,
by example the Normal User has more or less points depending on his commentaries. 
The users are saved in three files (JSON, XML, TXT) everytime the application is closed and they're loaded automatically when it's opened.

#Menu characteristics.

**1) Create**
 1. Form with several fields, each one controlled by a regular expression.
 2. Two users with the same ID (Spanish DNI), username or email can't be created.

**2) Read**
 1. This option shows you the information of all the users or one concrete user.
 2. Shows the user's avatar using a class called ImageIcon (3 choosable avatars).
 3. Recalculates the salary of the Administrator and the points of the Client and the Normal User.

**3) Update**
 1. Through a combobox allows you to select the user that you want to update.
 2. Regular expressions to control the change of attributes.
 3. Recalculates the salary of the Administrator and the points of the Client and the Normal User.
 
**4) Delete**
 1. Allows you to delete all the users or just one.

**5) Get**
 1. Shows one concrete attribute of the selected user.
 
**6) Order**
 1. Enables you to sort the users depending on the selected attribute.

**7 y 8) Open and save**
 1. Allows you to open and save a JSON, XML or TXT file with the information of the users.
 2. By default saves the files on JSON.

 
#Setting's menu

Form with elements like JSpinner, combobox and checkbox. This menu allows the user to set his preferences as the mentioned above (The first 
option is used by default):

1. Date format: dd/mm/yyyy, yyyy/mm/dd, dd-mm-yyyy, yyyy-mm-dd
2. Currency:  Euros, Libras o Dolares.
3. Decimal format: .0, .00, .000
4. File format: JSON, XML o TXT.
5. Language: Ingles, Español o Valenciano.
6. Theme: GTK, Motif, Metal o Ninbus
7. Enable or disable automatic user creation.
8. Added 'Reset' Button to go back to the default settings.



**Settings menu saves automatically in a JSON file the user's preferences and they're loaded everytime the appliaction is opened, also if the user
is using the application and he enters back to the preferences menu, they are loaded again.**


#Javadoc

This project is almost fully documented with javadoc so anyone can read it.
