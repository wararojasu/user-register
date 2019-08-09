# Simple Web App - Register User

This web application is for practicing DevOps. It was developed with java technology.<br />
This application has one web form to register an user once it was registered the application is going to display the user information.

## Getting Started

These instructions will get you started for getting a copy of the project and running on your local machine for development and testing purposes.

### Prerequisites

For Developing and Testing using an IDE.
- Eclipse IDE as Editor.
- Java 8

For Testing only.
- Browser like Google Chrome/Firefox, etc.

### Installing

**For Developing**.<br /><br />
Get the app.
```
git clone -b develop https://github.com/awt-03/user-register.git
```
Update the dependencies for the project.
- Open the App with Eclise IDE.
- Once it was opened, Right Click on the projet.
- From context menu, do mouse Over to **"Gradle"** option.
- Click on **"Refresh Gradle Project"** option.
- Then the dependencies are going to be updated. Wait ultil it was done.
- Finally you can start to coding.

**For testing using an ide**.<br /><br />
Get the app.
```
git clone -b develop https://github.com/awt-03/user-register.git
```
Update the dependencies for the project.
- Open the App with Eclise IDE.
- Once it was opened, Right Click on the projet.
- From context menu, do mouse Over to **"Gradle"** option.
- Click on **"Refresh Gradle Project"** option.
- Then the dependencies are going to be updated. Wait ultil it was done.<br /><br />

Build the application.<br />
- Go to the Gradle view 
- Find the project, then with focus in the project display the drop down.
- Go to **"build"** folder display the drop down.
- Right click on **"build"** and click on **"Tun Gradle Tasks"**.
- Then the application is going to be builded. Wait ultil it was done.
- Finally to Testing. Go to the browser that you like and type.
```
http://localhost:8080/user-register/index.jsp
```

**For testing without using an ide**. <br /><br />
Get the app.
```
git clone -b develop https://github.com/awt-03/user-register.git
```
- Go to the project folder
```
cd user-register
```
Update the dependencies and Build the application.
```
./gradlew build
```
- Create an image with the builded application.
```
 sudo docker build -t user-register .
```
- Deploy the application created as an image.
```
 sudo docker run -d -it -p 8787:8080 user-register
```
- Finally for Testing. Go to the browser that you like and type.
```
http://localhost:8080/user-register/index.jsp
```
## Authors

* **Wara Rojas** - *Working on my project* - [Git Hub Repo](https://github.com/awt-03/user-register.git)
See also [Gui Automated test for this application](https://github.com/awt-03/user-register_gui_test.git)

## License

This project is Open source licensed.
