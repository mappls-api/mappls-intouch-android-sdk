[<img src="https://about.mappls.com/images/mappls-b-logo.svg" height="60"/> </p>](https://www.mapmyindia.com/api)

## 6.0 Trips

The trips module helps you to create a Trip and assign it to the vehicle and the trip compliance. InTouch provides the three major functionalities of Trips modules.

Trip Module Features -

1.  Start a trip with or without destination and via points or with scheduled end time,
2.  Get the latest trip information. ( Total traveled distance during the trip, Travelled path vs planned route, ETA to the destination, etc.)
3.  Trip completion.
    -   Trips can be completed/closed in three different ways.
        -   Based on the scheduled end time
        -   On reaching the destination.
        -   Manually close.

When the trip is created with a destination, InTouch will provide the actual time of the destination and waypoints.

#### 6.1 Create Trip

InTouch provides four ways to create a new trip. Depending on the use case, You can use the below methods to start a new trip. Based on the selected trip creation method, either trip gets closed/completed automatically or by calling the manual method.

-   Trips without a destination
-   Trips with scheduled end time but without a destination
-   Trips with destination and scheduled end time.
-   Trips with destination but without a scheduled end time.

#### 1. 1. 1 Create Trip without a destination
This method can be used to share a live location with someone else. In this case, the trip shall be closed by calling the close trip method (6.4).

Also, if the force close is enabled then on the new trip assignment, the active old trip will be force closed.

```java
InTouch.createTrip(<trip name>, <device id>, <metadata>, <isFroceCloseEnable>,new ICreateTripListener() {  
	  @Override  
	  public void onSuccess(String tripId) {  
	        // write your code here.
	  }  
  
    @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
        // error description gives a message for a particular error.  
  }  
});
```
### Kotlin

```kotlin
InTouch.createTrip(<trip name>, <device id>, <metadata>, <isFroceCloseEnable>, object: ICreateTripListener{  
   override
   fun onSuccess(tripId : String?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.  
   }  
})
```
#### 6. 1. 2  Create Trip with Destination and Geofences.

This method helps to create trips with a destination and waypoints.  Here trip will get close only if the vehicle reaches the destination. otherwise, the manual close trip option can be used to close the trip.

Also if the force close is enabled then on the new trip assignment, the active old trip will be force closed.


```java
InTouch.createTrip(<trip name>, <device id>, <metadata>, <TripDestination class object>, <TripGeoFences class object>,<isFroceCloseEnable>, new ICreateTripListener() {  
	  @Override  
	  public void onSuccess(String tripId) {  
	        // write your code here.
	  }  
  
    @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
        // error description gives a message for a particular error.  
  }  
});
```
### Kotlin
```kotlin
InTouch.createTrip(<trip name>, <device id>, <metadata>,<TripDestination class object>, <TripGeoFences class object>,<isFroceCloseEnable>, object: ICreateTripListener{  
   override fun onSuccess(tripId : String?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.  
   }  
})
```
#### 6. 1. 3  Create Trip with Destination and Geofences using scheduled end time.

In this method, the trip will get close to the scheduled end time. It is based on the trip duration. Irrespective of the vehicle arrival status on the geofence, the trip will get close after the trip duration (Scheduled end time).  Otherwise, the manual close trip option can be used.

Also, if the force close is enabled then on the new trip assignment , active old trip will be force closed.
```java
InTouch.createTrip(<trip name>, <device id>,<scheduleEndTime>, <metadata>,<TripDestination class object>, <TripGeoFences class object>,<isFroceCloseEnable>, new ICreateTripListener() {  
	  @Override  
	  public void onSuccess(String tripId) {  
	        // write your code here.
	  }  
  
    @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
        // error description gives a message for a particular error.  
  }  
});
```
### Kotlin
```kotlin
InTouch.createTrip(<trip name>, <device id>, <scheduleEndTime>, <metadata>,<TripDestination class object>, <TripGeoFences class object>,<isFroceCloseEnable>, object: ICreateTripListener{  
   override fun onSuccess(tripId : String?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.  
   }  
})
```
### Request Parameters
1. ```tripName``` - Name of the trip.
2. ```deviceId(long)``` - Intouch unique Id of the device for which the trip is getting created.
3. ```metadata(HashMap<String, String)``` - This can be any key-value data pair. It can be used to tag additional information like customer name or it can be a unique trip ID of your platform.
4. ```tripDestination(TripDestination)``` - Destination of the trip. This is an optional object.
5. ```scheduledEndTime(long)``` - Tentative time in seconds to close the trip. The trip will be closed once the duration gets complete. This is an optional object.
6.  ```tripGeoFences(List<TripGeoFences>)``` - List of GeoFences points of the trip. This is an optional object.
7. ```isFroceCloseEnable(boolean)``` - if true then the trip will get automatically closed as soon as the device gets associated with another trip.

### TripDestination Parameters
1. ```geometry(Geometry)``` - Geometry of destination points coordinates.
2. ```metadata(HashMap<String, String)``` - This can be any key-value data pair.
3. ```radius(Integer)``` - Radius for point type geofence.
4. ```scheduledAt(long)``` - scheduled timestamp in seconds at which the device reaches the destination.
### TripGeofence Parameters
1. ```geometry(Geometry)``` - geometry of destination points coordinates.
2. ```metadata(HashMap<String, String)``` - this can be any key-value data pair.
3. ```radius(Integer)``` - radius of the point.
4. ```scheduledAt(long)``` - scheduled timestamp in seconds at which the device reaches the destination.
### Geometry Parameters
1. ```type(String)``` - Type of geometry. Two geometries are allowed. Point or Polygon
2. ```coordinates(List<Double>)``` - List of Longitude and Latitude. For example:-
```
List<Double> coordinates = new ArrayList<>();
coordinates.add(longitude);  
coordinates.add(latitude);
```

### Response Code

#### Success
1.  200 To denote a successful record is being created.

#### Client-side issues

1.  400 Bad Request, The User made an error while creating a valid request.
2.  401 Unauthorized, Developer’s key is not allowed to send a request with restricted parameters.
3.  403 Forbidden, the Developer’s key has hit its daily hourly limit.

#### Server-Side Issues

1.  500 Internal Server Error, the request caused an error in our systems.
2.  503 Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)
1. 200 Success
2. 203 Device Not Found
3. 400 Bad Request - Invalid device ID supplied or invalid data type. For example, input attribute id is an integer but the string value gets passed.
4. 401 Unauthorized Request. Access to API is forbidden.
5. 404 Not Found - URL Not Found


### 6.2 Get List of Trips.

Use this method to get the list of trips which is created under your account. You can get all trips or a filtered list of trips based on creation date, device id, trip status, etc.

#### 6.2.1  Get List of all Trips
Using the below method you can get all the trip which is created under your account.

### Java
```java
\\\ Get all Alarm config
// IGetTripsListener- returns all trips if success, else error as callback methods.
InTouch.getTrips(new IGetTripsListener() {  
  @Override  
  public void onSuccess(TripsResponse response) {  
		 // write your code here. 
    }  
  @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
		// reason gives the error type. 
        // errorIdentifier gives information about error code. 
        // error description gives a message for a particular error.
    }  
});
```
### Kotlin
```kotlin
InTouch.getTrips(object: IGetTripsListener{  
   override fun onSuccess(t: TripsResponse?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error. 
   }  
})
```
#### 6.2.2  Get List of trips with filters.

Use the below method to get the selected list of trips. you can filter the trip using trip status, start and end time of the trip creation date.

### Java
```java
InTouch.getTrips(<limit>, <status>, <statTimeStamp>, <endTimeStamp>, new IGetTripsListener() {  
  @Override  
  public void onSuccess(TripsResponse response) {  
		 // write your code here.
    }  
  @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
			  // reason gives the error type. 
              // errorIdentifier gives information about error code. 
              // error description gives a message for a particular error.
    }  
});
```
### Kotlin
```kotlin
InTouch.getTrips(<limit>, <status>, <statTimeStamp>, <endTimeStamp>, object: IGetTripsListener{  
   override fun onSuccess(t: TripsResponse?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error. 
   }  
})
```
#### 6.2.2  Get trips for selected devices with filters.
Use the below method to get the trips that are being associated with the list of devices along with other filter options.

### Java
```java
InTouch.getTrips(<array of device ids>, <limit>, <status>, <statTimeStamp>, <endTimeStamp>, new IGetTripsListener() {  
  @Override  
  public void onSuccess(TripsResponse response) {  
		 // write your code here.
    }  
  @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
			  // reason gives the error type. 
              // errorIdentifier gives information about error code. 
              // error description gives a message for a particular error.
    }  
});
```
### Kotlin
```kotlin
InTouch.getTrips(<array of device ids>, <limit>, <status>, <statTimeStamp>, <endTimeStamp>, object: IGetTripsListener{  
   override fun onSuccess(t: TripsResponse?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error. 
   }  
})
```

### Request Parameters
1. ```limit(int)``` - Will limit the records as per the passed value.
2. ```deviceIds (Long[])``` - Device IDs if you want to get trips associated with particular devices.
3. ```status(int)``` - Pass 1 to get active trips & 2 for completed trips.
4. ```startTime(long)``` - Start timestamp of the trip.  This is epoch timestamp in seconds.
5. ```endTime(long)``` - End timestamp of the trip. This is epoch timestamp in seconds.


### Response Code
#### Success
1.  200 To denote a successful API call.
#### Client-side issues

1.  400 Bad Request, The User made an error while creating a valid request.
2.  401 Unauthorized, Developer’s key is not allowed to send a request with restricted parameters.
3.  403 Forbidden, the Developer’s key has hit its daily hourly limit.

#### Server-Side Issues

1.  500 Internal Server Error, the request caused an error in our systems.
2.  503 Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)
1. 200 Success
2. 203 Device Not Found
3. 400 Bad Request - Invalid device ID supplied or invalid data type. For example, input attribute id is an integer but string value gets passed.
4. 401 Unauthorized Request. Access to API is forbidden.
5. 404 Not Found - URL Not Found
### Response Parameter
`TripsResponse` class object returns the API response as a JSON object.

#### Trip result parameters
1. ```tripId(String)``` - Unique id for the trip.
2. ```deviceId(long)``` - Unique Id of the device which is associated with the trip.
3. ```status(Integer)``` - 1 - Active trip. 2 - Completed trip.
4. ```closureType(Integer)``` - Type of trip closure. 1 - the trip will get closed based on the scheduled end time. 2 - the trip will close when the device enters the destination area/geofence. 3 - the trip will get closed manually by the user.
5. ```forceClose(Boolean)``` - If true then the trip will get automatically closed as soon as the device gets associated with another trip.
6. ```name(String)``` - The name of the trip.
7. ```destination(Destination)``` - This will only get returned in case this object was explicitly defined while creating a trip.
8. ```geofences(List<Geofence>)``` - A trip may have various points. This will only get returned in case these geofence points were explicitly mentioned while creating a trip.
9.  ```summary(Summary)``` -  returns a summary of a particular trip.
10. ```links(Links)``` - returns an object of Links class.
##### Destination Parameters
1. ```geometry(Geometry)```- Destination points coordinate geometry. This is standard geojson format.
2. ```radius(integer)```- Radius of the point.
3. ```plannedTime(Long)``` - Planned timestamp at which device reach the destination.
4. ```arrivalTime(Long)```- Actual timestamp at which device reach the destination.
5. ```departureTime(Long)``` - Departure timestamp at which device leaves the destination.
6. ```address(String)```- Address of the destination point.
7. ```time(Long)```- Planned timestamp is taken to reach the destination from the previous point.
8. ```distance(Integer)```- Planned distance is taken to reach the destination from the previous point.
9. ```pointName(String)```- The name given to the destination point.
10. ```metadata(Object)``` - This can be any key-value data pair and will get returned only if it was mentioned while creating a trip.

##### Geofence Parameters
1. ```geometry(Geometry)```- Geofence points coordinate geometry. This is in the standard geo JSON format.
2. ```radius(integer)```- Radius of the point.
3. ```plannedTime(Long)``` - Planned timestamp at which the device reaches the geofence.
4. ```arrivalTime(Long)```- Actual timestamp at which device reach the geofence.
5. ```departureTime(Long)``` - Departure timestamp at which device leaves the geofence.
6. ```address(String)```- Address of the destination point.
7. ```time(Long)```- planned timestamp is taken to reach the geofence from the previous point.
8. ```distance(Integer)```- Planned distance is taken to reach the destination from the previous point.
9. ```pointName(String)```- The name given to the geofence point.
10. ```metadata(Object)``` - This can be any key-value data pair and will get returned only if it was mentioned while creating a trip.

##### Summary Parameters
1. ```startedOn(Long)```- The actual start timestamp of the trip.
2. ```duration(Long)```- The actual duration time (in seconds) of the trip.
3. ```distance(Double)``` - The actual distance (in meters) covered in the trip.
4. ```endedOn(Long)```- The actual end timestamp of the trip.
5. ```delayedBy(Long)``` - the actual timestamp by which the trip got delayed.
6. ```plannedEndTime(Long)```- The planned end timestamp of the trip.
7. ```plannedStartTime(Long)```- The planned start timestamp of the trip.
8. ```plannedDuration(long)```- The planned duration time (in seconds) of the trip.
9. ```plannedDistance(Integer)```- The planned distance (in meters) of the trip.
##### Links Parameters
1. ```embedUrl(String)``` - An embedded URL link of the trip. You can use this link to visualize the trip on your web or mobile app.
### 6. 3 Trip Info

Use the below method to get the detailed trip information using trip Id.

#### 6.3.1  Get  Trip by id.
### Java
```java
// ITripInfoListener- returns TripInfoResponse if success, else error as callback methods.
InTouch.getTripInfo(<trip id>, new ITripInfoListener() {  
  @Override  
  public void onSuccess(TripInfoResponse response) {  
		  // write your vode here.
  }  
  @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
			  // reason gives the error type. 
              // errorIdentifier gives information about error code. 
              // error description gives a message for a particular error.
  }  
})
```
### Kotlin
```kotlin
InTouch.getTripInfo(<trip id>, object: ITripInfoListener{  
   override fun onSuccess(t : TripInfoResponse?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error. 
   }  
})
```
#### 6.3.2  Get Trip by id with filters.

Using the below method you can get the limited set of information against the trip Ids. In this method, you can enable or disable some objects based on the requirement.

### Java
```java
// ITripInfoListener- returns TripInfoResponse if success, else error as callback methods.
InTouch.getTripInfo(<trip id>, <isPositionEventsEnable>, <isLocationEnable>, <isPolylineEnable>, new ITripInfoListener() {  
  @Override  
  public void onSuccess(TripInfoResponse response) {  
		  // write your vode here.
  }  
  @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
			  // reason gives the error type. 
              // errorIdentifier gives information about error code. 
              // error description gives a message for a particular error.
  }  
})
```
### Kotlin
```kotlin
InTouch.getTripInfo(<trip id>, <isEventsEnable>, <isLocationEnable>, <isPolylineEnable>, object: ITripInfoListener{  
   override fun onSuccess(t : TripInfoResponse?) {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error. 
   }  
})
```
### Request Parameters
1. ```tripId(String)``` - id of the trip which you want to fetch.
2. ```isEventsEnable(boolean)``` - will return all the position events of the device.
3. ```isLocationEnable(boolean)``` - will return the last know device location details.
4. ```isPolylineEnable(boolean)``` - will return the entire polyline locations of the route which was created for the trip.


### Response Code
#### Success
1.  200 To denote a successful API call.
#### Client-side issues

1.  400 Bad Request, The User made an error while creating a valid request.
2.  401 Unauthorized, Developer’s key is not allowed to send a request with restricted parameters.
3.  403 Forbidden, the Developer’s key has hit its daily hourly limit.

#### Server-Side Issues

1.  500 Internal Server Error, the request caused an error in our systems.
2.  503 Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)
1. 200 Success
2. 203 Device Not Found
3. 400 Bad Request - Invalid device ID supplied or invalid data type. For example, input attribute id is an integer but string value gets passed.
4. 401 Unauthorized Request. Access to API is forbidden.
5. 404 Not Found - URL Not Found


### Response Parameter
`TripInfoResponse` class object returns the API response as a JSON object.

#### TripInfo result parameters
1. ```tripId(String)``` - Id of the trip.
2. ```deviceId(long)``` - Id of the device which is associated with the trip.
3. ```status(Integer)``` - 1 - active trip. 2 - completed trip.
4. ```closureType(Integer)``` - Type of trip closure. 1 - the trip will get closed based on the scheduled end time. 2 - the trip will close when the device enters the destination area/geofence. 3 - the trip will get closed manually by the user.
5. ```forceClose(Boolean)``` - If true then the trip will get automatically closed as soon as the device gets associated with another trip.
6. ```name(String)``` - The name of the trip.
7. ```destination(Destination)``` - This will only get returned in case this object was explicitly defined while creating a trip.
8. ```geofences(List<Geofence>)``` - A trip may have various points. This will only get returned in case these geofence points were explicitly mentioned while creating a trip.
9.  ```summary(Summary)``` -  Returns a summary of the particular trip.
10. ```polylinePoints(PolylinePoint)``` - This is the route polyline.
11.  ```location(Location)``` - Location data of the device.
12.  ```positionEvents(List<PositionEvent>)``` -  Position events data of the device.
13. ```links(Links)``` - returns an object of Links class.
##### Destination Parameters
1. ```geometry(Geometry)```- Destination points coordinate geometry. This is standard geojson format.
2. ```radius(integer)```- Radius of the point.
3. ```plannedTime(Long)``` - Planned timestamp at which device reach the destination.
4. ```arrivalTime(Long)```- Actual timestamp at which device reach the destination.
5. ```departureTime(Long)``` - Departure timestamp at which device leaves the destination.
6. ```address(String)```- Address of the destination point.
7. ```time(Long)```- Planned time to reach the destination from the previous point.
8. ```distance(Integer)```- Planned distance to reach the destination from the previous point.
9. ```pointName(String)```- Destination point name.
10. ```metadata(Object)``` - This can be any key-value data pair, and will get returned only if it was mentioned while creating a trip.

##### Geofence Parameters
1. ```geometry(Geometry)```- Geofence points coordinate geometry.This is standard geojson format.
2. ```radius(integer)```- Radius of the point.
3. ```plannedTime(Long)``` - Planned timestamp at which device reach the geofence.
4. ```arrivalTime(Long)```- Actual timestamp at which device reach the geofence.
5. ```departureTime(Long)``` - Departure timestamp at which device leaves the geofence.
6. ```address(String)```- Address of the destination point.
7. ```time(Long)```- Planned time to reach the geofence from the previous point.
8. ```distance(Integer)```- Planned distance to reach the destination from the previous point.
9. ```pointName(String)```- Geofence/Stop point name.
10. ```metadata(Object)``` - This can be any key-value data pair, and will get returned only if it was mentioned while creating a trip.

##### Summary Parameters
1. ```startedOn(Long)```- The actual start timestamp of the trip.
2. ```duration(Long)```- The actual duration time (in seconds) of the trip.
3. ```distance(Double)``` - The actual distance (in meters) covered in the trip.
4. ```endedOn(Long)```- The actual end timestamp of the trip.
5. ```delayedBy(Long)``` - The actual timestamp by which the trip got delayed.
6. ```plannedEndTime(Long)```- The planned end timestamp of the trip.
7. ```plannedStartTime(Long)```- The planned start timestamp of the trip.
8. ```plannedDuration(long)```- The planned duration time (in seconds) of the trip.
9. ```plannedDistance(Integer)```- The planned distance (in meters) of the trip.
##### PolylinePoint Parameters
1. ```coordinates(Coordinate)``` - Coordinates of polyline.
##### Coordinate Parameters
1. ```lat(double)``` - Latitude value of polyline point.
2. ```lng(double)``` - Longitude value of polyline point.

##### Location Parameters
1. ```gpsTime(Long)```- Gps time of the device.
2. ```gprsTime(Long)```- Gprs time of the device.
3. ```latitude(Double)``` - Latitude value of location.
4. ```longitude(Double)```- Longitude value of location.
5. ```address(String)``` - Last location address of the device.
6. ```status(Integer)```- Movement status of the device.  
   1 - Moving, 2 - Idle, 3 - stopped, 4 - towing, 5 - No Data, 6 - power off i,e the device's battery is disconnected from the vehicle battery, 7 - No GPS, and 12 - Activation Pending. i,e) the device is not yet active and is yet to send the first ping.

##### PositionEvent Parameters
1. ```timestamp(long)```- The timestamp of position event.
2. ```longitude(Double)```-  Longitude value of position event.
3. ```latitude(Double)``` - Latitude value of position event.
##### Links Parameters
1. ```embedUrl(String)``` - An embedded URL link of the trip. You can use this link to visualize the trip on your web or mobile app.
#### 6. 4  Close Trip
The below method helps to close the trip manually. Just pass the trip Id in the method to close or complete the trip.
### Java
```java

// IResultListener- returns success if trip closed successfully, else error as callback methods.
InTouch.closeTrip(<trip id>, new IResultListener() {  
  @Override  
  public void onSuccess() {  
		// write your code here.
  }  
  @Override  
  public void onError(String reason, String errorIdentifier, String errorDescription) {  
		// reason gives the error type. 
        // errorIdentifier gives information about error code. 
        // error description gives a message for a particular error.
  }  
});
 ```
### Kotlin
```kotlin
InTouch.closeTrip(<trip id>, object: IResultListener{  
   override fun onSuccess() {  
        // write your code here.  
   }  
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type.  
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error. 
   }  
})
```

### Request Parameters
1. ```tripId(String)``` - id of the trip which you want to close.

### Response Code
#### Success
1.  200 - To denote a successful API call.
#### Client-side issues

1.  400 - Bad Request, User made an error while creating a valid request.
2.  401 - Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403 - Forbidden, the Developer’s key has hit its daily hourly limit.

#### Server-Side Issues

1.  500 - Internal Server Error, the request caused an error in our systems.
2.  503 - Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)
1. 200 - Success
2. 203 - Device Not Found
3. 204: No Content Or No Data Found
4. 400 - Bad Request - Invalid device ID supplied or invalid data type. For example, input attribute id is an integer but the string value gets passed.
5. 401 - Unauthorized Request. Access to API is forbidden.
6. 404 - Not Found - URL Not Found.


<br></br>

<br></br>
For any queries and support, please contact:

[<img src="https://about.mappls.com/images/mappls-logo.svg" height="40"/> </p>](https://about.mappls.com/api/)

Email us at [apisupport@mappls.com](mailto:apisupport@mappls.com)

![](https://www.mapmyindia.com/api/img/icons/support.png)

[Support](https://about.mappls.com/contact/)

Need support? contact us!

<br></br>

<br></br>

[<p align="center"> <img src="https://www.mapmyindia.com/api/img/icons/stack-overflow.png"/> ](https://stackoverflow.com/questions/tagged/mappls-api)[![](https://www.mapmyindia.com/api/img/icons/blog.png)](https://about.mappls.com/blog/)[![](https://www.mapmyindia.com/api/img/icons/gethub.png)](https://github.com/Mappls-api)[<img src="https://mmi-api-team.s3.ap-south-1.amazonaws.com/API-Team/npm-logo.one-third%5B1%5D.png" height="40"/> </p>](https://www.npmjs.com/org/mapmyindia)

[<p align="center"> <img src="https://www.mapmyindia.com/june-newsletter/icon4.png"/> ](https://www.facebook.com/Mapplsofficial)[![](https://www.mapmyindia.com/june-newsletter/icon2.png)](https://twitter.com/mappls)[![](https://www.mapmyindia.com/newsletter/2017/aug/llinkedin.png)](https://www.linkedin.com/company/mappls/)[![](https://www.mapmyindia.com/june-newsletter/icon3.png)](https://www.youtube.com/channel/UCAWvWsh-dZLLeUU7_J9HiOA)

<div  align="center">@ Copyright 2022 CE Info Systems Ltd. All Rights Reserved.</div>

<div  align="center">  <a  href="https://about.mappls.com/api/terms-&-conditions">Terms & Conditions</a> | <a  href="https://about.mappls.com/about/privacy-policy">Privacy Policy</a> | <a  href="https://about.mappls.com/pdf/mapmyIndia-sustainability-policy-healt-labour-rules-supplir-sustainability.pdf">Supplier Sustainability Policy</a> | <a  href="https://about.mappls.com/pdf/Health-Safety-Management.pdf">Health & Safety Policy</a> | <a  href="https://about.mappls.com/pdf/Environment-Sustainability-Policy-CSR-Report.pdf">Environmental Policy & CSR Report</a>

<div  align="center">Customer Care: +91-9999333223</div>
