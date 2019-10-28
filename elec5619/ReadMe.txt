WeatherGram
***************************************************
Overview

Our project aims to offer users weather information and the customized dress recommendation based on the weather conditions.  

***************************************************
Significance

Our project help users solve those problems about how to wear properly in certain weather and make them feel better and happier in bad weather.

***************************************************
Used interface

1.Serialization:
In this project, the product class, user class and admin class use the Serialization interface, which is an empty interface provided by java and enable those class automatically supports serialization. Serialization is the process of converting the state information of an object into a format that can be stored or transmitted.

2. Controller：
 
Spring Web MVC supports a variety of types of interfaces, such as controller is a functional interface and can be used as the assignment target for a lambda expression or method reference. Through implementing controller to achieve page control and click processing.

3.ProductManage

We create an interface called ProductManager to include some abstract method that can be realized in other classes.

method overviews---description
public void increasePrice(int percentage);---increase price by percentage
public List<Product> getProducts();---get product information
public void addProduct(Product product);---add product information
public Product getProductById(long id);---through ID getting product
public void updateProduct(Product product);---update product information
public void deleteProduct(long id);---delete the product through the product ID


***************************************************
Used frameworks

Spring - Web framework

Maven - Dependency Attribute Management

***************************************************
Design pattern

In our project, we need to obtain persistent data for pushing to users.
Therefore, we adopt the DAO design pattern for data layer access. the DAO design pattern includes database connection class; the DAO interface class which is used to include various operations of database, add and delete, update, search the definition of the function; the DAO implementation class to specifically implement the database operation function defined in the DAO interface; the DAO factory class which can provide a static method with a return value of the DAO interface type, and obtain the DAO implementation.

***************************************************

Deployment

The application was built on the SpringMVC, the IDE used was Spring Suite Tool 3
The database used was MySQL. Hibernate was used to build a data access layer to map the java classes to the MySQL database table object, which has provided a huge convenience to save a lot of time from operating sql queries. Maven was also used to manage the package.

1. Configure the Java operation environment, install the JDK and configure the corresponding environment variables. Choose the proper IDE.
2. Install Spring STS. Configure tomcat on STS. Configure tomcat environment variables, create SpringMvc project.
3. Install the database(MySQL).
4. Configure JSTL and create a controller
5. Deploy the project. Put the war package of our web project into Tomcat's webapp package, start tomcat, and enter the address in the browser.


***************************************************
Version control

We have used the Github as our main version tool, which has allowed us to control each version of the project, it has prevented our project from any incidence. 


***************************************************
License

Apache Licens

***************************************************
APIs

We have used the OpenWeatherMap API to get the weather conditions from, which included the temperature information, wind speed, weather conditions, and humidity based on the different cities that users provide to us. 
We have used the data to manipulate to figure out what users should wear for the date and provide the suggestion to them. We also have used the Google Map API which allowed to track the current location of the users, and the map view to display on the website.


***************************************************
Application Environment Setup

1. Use the Spring Suite Tool 3 to open the project folder
2. Maven build the pom.xml file to get all the dependencies 
3. Configure the Tomcat, add the Tomcat 9.0
4. Set up JAVA, The JRE version is 1.8
5. Set HTTPS port to 8080
6. The HTTPS route is elec5619, enter the homepage of the website
7.Meanwhile, the MySQL database need to be set up
8. MySQL version is 8.0.1.2
9. Create a database for the application, the name must be springapp
10. There are three tables need to be created namely admin, outfit, and user. 
11. Then, Google API keys are needed to use Google Maps and the OpenWeatherMap api key to fetch the weather condition.
12. Lastly, hope you enjoy our application!

***************************************************



