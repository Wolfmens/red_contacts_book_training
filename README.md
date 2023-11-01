<h1 align="center">Red Contacts Book</h1>
<p align="center">

____
### I. Description

==================

Welcome to the contact book app. <br/> The application allows you to work with your contact book. <br/>
Before starting the application, you have access to two of its main properties that characterize the initial contact storage database:<br/>
1) init - initialization by external txt file.<br/>
2) default - initialization by internal application storage.<br/>

_You must specify the value of the initial application parameters in the application.properties file in attributes "spring.profiles.active", which is located in the resources folder in the application root._<br/>

After selecting the initial parameters, the application will select the necessary Java configuration to create beans appropriate for the application (AppDefaultConfig or FileFirstConfig to
bean InitilalRegularBase or inititalFileBase, respectively).<br/>


The main work is carried out in  WorkerWithBook class which, of course, is also a bean.<br/>
Старт приложения начинается с метода _startWork()_.
User provided with 5 functions:
1) E - Exit the application (Breaking the loop in method).
2) A - Adding a user to internal storage with params name, phone number and email. (Works through method _addUserToList()_ 
and what is very important, user data must be specified in a specific format. The method checks the 
correctness of the entered data; if there is an error, you will see a message).
3) R - Removing a user by his email. (Works through method _removeUser()_,as when adding, you need to comply with the format of the entered data and if the data is 
incorrect, there will be an error on the screen asking you to correct it.).
4) L - Show all users on screen.(Works through method _removeUser()_, and working through simple cycle _for_ and _soutc_).
5) S - Saving to an external contact database (based on a txt file). This function is available only when you select the start parameter - _init_.
It is important, when choosing this initial parameter to specify the storage location of the external file in application.properties using the app.init attribute. _(for example app.init=src/main/resources/contacts.txt)_.
The application independently initializes this path in the required place in the business logic.

==================

### II. How to start 
There are two options available to launch the application:
1) Move the repository to your development environment and use the Run function of your environment under the Main class in the application architecture.
The system will build and launch the application.
2) The second option is to package the application in a jar file and use the console application to go to the folder 
with this file and accompanying dependencies. (after packaging via Gradle the file is located at the following path _build/install/RedContactsBook/lib/..._ )


----

