# Sensor Application

## Running Instructions
1. Open the command prompt at the projects location
2. Enter the command 'mvnw package'
3. Next enter the command 'cd target'
4. Finally enter 'java -jar sensors-0.0.1-SNAPSHOT.jar' to start the application

## Project Details
This application is built using Spring boot which by default uses hibernate to interact with the database

### Database structure
![Database Structure](Images\DBStructure.png)

### Main classes
1. **Sensor.java**<br>
Entity Class that maps to the sensor table in the database

2. **SensorData.java** <br>
Entity class that maps to the sensor_table in the database

3. **SensorDAO.java**<br>
Data access object used for interacting with the database via hibernate. Its methods are called by SensorRestController.java when it needs to use the database

4. **SensorRestController.java**<br>
Contains the rest api's for the application and uses the SensorDAO class to interact with the database

### Rest API's
1. **/sensor** <br>
POST request used to create a new sensor. <br>
![Example sensor request](Images\sensor.png)

2. **/sensorData**<br>
POST Request used to create new data for a sensor. The id for thr sensor needs to be specified.<br>
![Example sensorData request](Images\sensorData.png)

3. **/allData**<br>
GET Request used to request the average temperature and/or humidity for all sensors. Takes the metrics you wish to see as a parameter.<br>
![Example allData request](Images\allData.png)

4. **/data**<br>
GET Request used to request the average temperature and/or humidity for some sensors. Takes the ids of the sensors and the metrics you wish to see as a parameter.<br>
![Example data request](Images\data.png)
