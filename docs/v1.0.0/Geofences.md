### 4.0 Geofences

A geofence is a user-defined bounded area to trigger Entry and Exit alert of the user/vehicle. Custom areas or places can be created as a Geofence under your account, For example, it could be a hotel, Restaurant, Office, work area, retail store, and so on.

Mappls InTouch SDK supports Point, Circle, and Polygon (Custom Region/Area) geofences. You can Create, Update, or Delete geofences using the below methods. Also, get the total time spent inside the geofence using the below methods.

### 4.1 Create Geofence

The create geofence method helps you to create a geofence under your account. Three types of geofence can be created: Point, Circle, Polygon.

#### 4.1.1 Point Geofence

Input the Lat, long, and the name of the geofence to create the point geofence. A point geofence has a fixed radius of 100 meters, so the user need not put the radius of the geofence. To customize the radius of geofence refers to the circle geofence method.

### Java

```java
// Point type geofence
// ICreateGeoFenceListener - returns success if geofence created else error as callback methods.

InTouch.createGeoFence(<geofence name>, new GeoFencePoint(<Latitude>, <Longitude>), new ICreateGeoFenceListener() {
	 @Override public void onSuccess() {
	 // write your code here.
	 }
	 @Override public void onError(String reason, String errorIdentifier,  String errorDescription) {
			   // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.
     }
});
```

### Kotlin

```kotlin
InTouch.createGeoFence(<geofence name>, new GeoFencePoint(<Latitude>, <Longitude>), object: ICreateGeoFenceListener{
    override fun onSuccess(response: CreateGeoFenceResponse?) {
        // write your code here
    }
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }
})
```

#### 4.1.2 Circle Geofence

Create a circle geofence with a radius of your choice. Input Lat, long, Radius, and name of the geofence to create the circle geofence.

### Java

```java
// Circle type geofence, the radius will be in meters.
// ICreateGeoFenceListener - returns success if geofence created else error as callback methods.

InTouch.createGeoFence(<geofence name>, new GeoFencePoint(<Latitude>, <Longitude>), <range>, new ICreateGeoFenceListener()  {
	 @Override public void onSuccess(CreateGeoFenceResponse response) {
		 // write your code here
	 }
	 @Override public void onError(String reason, String errorIdentifier, String errorDescription) {
           	 // reason gives the error type.
              // errorIdentifier gives information about error code.
              error description gives a message for a particular error.
	 }
 });
```

### Kotlin

```kotlin
InTouch.createGeoFence(<geofence name>, new GeoFencePoint(<Latitude>, <Longitude>), <range>, object: ICreateGeoFenceListener{
    override fun onSuccess(response: CreateGeoFenceResponse?) {
        // write your code here
    }
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }

})
```

#### 4.1.3 Polygon Geofence

To draw a polygon geofence we need at least three points. Multiple points can be added to create the custom shape Geofence. Input a list of geofence points (Lat, long) in the comma-separated format.

### Java

```java
 // Polygon Geofence
 // ICreateGeoFenceListener - returns success if geofence created else error as callback methods.
InTouch.createGeoFence(<geofence name>, <list of GeoFencePoint>, new ICreateGeoFenceListener() {
	 @Override public void onSuccess(CreateGeoFenceResponse response) {
		 // writeyour code here
	 }
	 @Override public void onError(String reason, String identifier, String description) {
			  // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.
	 }
 });
```

### Kotlin

```kotlin
InTouch.createGeoFence(<geofence name>, <list of GeoFencePoint>, object: ICreateGeoFenceListener{
    override fun onSuccess(response: CreateGeoFenceResponse?) {
        // write your code here
    }
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }
})
```

### Request Parameters

1.`geoFenceName(String)`- Name of the geofence.

2.`geoFencePoint(GeoFencePoint)`- Geofence point(s). List of "GeoFencePoint" for polygon else single object required.

### Response Code

#### Success:

1.  201: To denote a successful record is being created.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the Developer’s key has hit its daily/hourly limit.

#### Server-Side Issues:

1.  500: Internal Server Error, the request caused an error in our systems.
2.  503: Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)

1. 200: Success
2. 203: Device Not Found
3. 400: Bad Request - Invalid device ID supplied or invalid data type. For example, the input attribute "id" is an integer but string value gets passed.
4. 401: Unauthorized Request. Access to API is forbidden.
5. 404: Not Found - URL Not Found

### Response Parameter

`CreateGeoFenceResponse` class object returns the API response as a JSON object.

#### CreateGeoFenceResponse result parameters:

`id (Long)`- Id of the newly created geofence.

#### 4.2 Get Geofence(s)

InTouch Get Geofences methods can be used to request the list of geofence areas using the unique geofence IDs which is being assigned by InTouch.

#### 4.2.1 Get All Geofence(s)

Get the geofence response with or without shape by setting ignore geometry value as true/false. for example, the type will be either a point, polygon, or circle.

### Java

```java
// ignoreGeometry is a boolean value. If the user doesn't need geometry with geofence pass true else false.
// IGetGeoFenceListener- returns all geoFences with geometry in response if success else errors as callback methods.
InTouch.getGeoFences(<ignoreGeometry>, new IGetGeoFenceListener() {
    @Override
    public void onSuccess(InTouchGeoFenceResponse response){
	    // write your code here.
    }
    @Override
    public void onError(String reason, String identifier, String   description) {
			  // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.
    }
});
```

### Kotlin

```kotlin
InTouch.getGeoFences(<ignoreGeometry>, object: IGetGeoFenceListener{
   override fun onSuccess(t: InTouchGeoFenceResponse?) {
        // write your code here.
  }
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }
})
```

#### 4.2.2 Get single Geofence

Get a geofence with or without the geometry value like circle, polygon, or point. Set ignoreGeometry value as true/false.

### Java

```java
// Get single geofence with geometry value
// IGetGeoFenceListener- returns single geoFence with geometry in response if success else error as callback methods.
InTouch.getGeoFences(<id of geofence>,<ignoreGeometry>, new IGetGeoFenceListener() {
    @Override
    public void onSuccess(InTouchGeoFenceResponse response) {
	    // write your code here.
    }
    @Override
    public void onError(String reason, String identifier, String   description) {
			  // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.

    }
});
```

### Kotlin

```kotlin
InTouch.getGeoFences(<id of geofence>,<ignoreGeometry>, object: IGetGeoFenceListener{
  override fun onSuccess(t: InTouchGeoFenceResponse?) {
        // write your code here.
  }
  override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }
})
```

#### 4.2.3 Get multiple Geofence with geometry Value.

Get multiple geofences for an array of geofence Ids with ignoreGeometry parameter value set as false.

### Java

```java
// Get multiple geofences with geometry value
// IGetGeoFenceListener- returns multiple geoFences in response if success else error as callback methods.
InTouch.getGeoFences(<Long array of geofence ids>,<ignoreGeometry>, new IGetGeoFenceListener() {
    @Override
    public void onSuccess(InTouchGeoFenceResponse response){
	    // write yor code here.
    }
    @Override
    public void onError(String reason, String identifier, String   description) {
			  // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.
    }
});
```

### Kotlin

```kotlin
InTouch.getGeoFences(<Long array of geofence ids>,<ignoreGeometry>, object: IGetGeoFenceListener{
  override fun onSuccess(t: InTouchGeoFenceResponse?) {
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

1.`id(Long)`- Geofence id. Use this if you want to get details of specific multiple geofence IDs.

2.`ignoreGeometry(boolean)` - Non-mandatory field, boolean value to fetch geometry details.

### Response Code

#### Success:

1.  200: To denote a successful API call.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the Developer’s key has hit its daily/hourly limit.

#### Server-Side Issues:

1.  500: Internal Server Error, the request caused an error in our systems.
2.  503: Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)

1. 200: Success
2. 203: Device Not Found
3. 204: No Content Or No Data Found
4. 400: Bad Request - Invalid device ID supplied or invalid data type. For example, the input attribute "id" is an integer but the string value gets passed.
5. 401: Unauthorized Request. Access to API is forbidden.
6. 404: Not Found - URL Not Found

### Response Parameter

`CreateGeoFenceResponse`- Class object returns the API response as a JSON object.

#### InTouchGeoFenceResponse result parameters:

`- List<GeoFenceResult>`- List of GeoFenceResult.

##### GeoFenceResult Parameters:

1. `id(Long)`- Geofence ID
2. `name(String)`- Name of the geofence
3. `geometry(Geometry)`- Geofence Geometry object.
4. `type(String)`- Depending on the type of geofence this value can be Circle(buffer > 50 meters), Polygon or Point(buffer = 50 mtrs)
5. `buffer(Double)`- Radius(in meters) of a circular geofence
6. `creationTime(long)`- epoch timestamp in seconds at which the geofence was created.
7. `updationTime(Long)`- epoch timestamp in seconds at which the geofence was updated.

##### Geometry Parameters:

1. `type(String)`-This defines the type of geofence, it can be point or polygon.
2. `coordinates(Object)`- Geofence geometry coordinates.
3. `latLng(GeoFencePoint)`- GeoFencePoint object. Use this in case of geofence type "Point or Circle".
4. `points(List<List<GeoFencePoint>>)`- List of GeoFencePoint list. Use this in case of geofence type "Polygon".

#### 4.3 Update Geofence(s)

Use Geofence ID to update Geofence name, latitude, longitude, and radius in the below method

#### 4.3.1 Update point Geofence

Update geofence values like geofence name and lat, long using below method

### Java

```java
// update single geofence
// IUpdateGeoFenceListener - returns success if gefence updated successfully, else error as callback methods.
InTouch.updateGeoFence(<geofence id>, <name of geofence>, <GeoFencePoint>, new IUpdateGeoFenceListener() {
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
InTouch.updateGeoFence(<geofence id>, <name of geofence>, <GeoFencePoint>, object: IUpdateGeoFenceListener{
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

#### 4.3.2 Update circle Geofence

Update geofence name, latitude, longitude, and Radius for a circle geofence using the below method.

### Java

```java
// update single geofence with buffer value. The buffer is like a radius in meters.
InTouch.updateGeoFence(<geofence id>, <name of geofence>, <GeoFencePoint>, <buffer>, new IUpdateGeoFenceListener() {
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
InTouch.updateGeoFence(<geofence id>, <name of geofence>, <GeoFencePoint>, <buffer>, object: IUpdateGeoFenceListener{
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

#### 4.3.3 Update Polygon Geofence

Update the geofence name, and the latitude, longitude of the polygon geofence using the below method.

### Java

```java
// Update polygon geofence.
InTouch.updateGeoFence(<geofence id>, <name of geofence>, <list of GeoFencePoint>, new IUpdateGeoFenceListener() {
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
InTouch.updateGeoFence(<geofence id>, <name of geofence>, <list of GeoFencePoint>, object: IUpdateGeoFenceListener{
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

1. `geoFenceId(Long)`- Id of the existing geofence.
2. `geoFenceName(String)`- Name of the geofence. If you need to update the existing one then use this else pass null.
3. `geoFencePoint(GeoFencePoint)` -List of "GeoFencePoint" for polygon geofence else single object required.

### Response Code

#### Success:

1.  200: To denote a successful API call.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the Developer’s key has hit its daily/hourly limit.

#### Server-Side Issues:

1.  500: Internal Server Error, the request caused an error in our systems.
2.  503: Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)

1. 200: Success
2. 203: Device Not Found
3. 400: Bad Request - Invalid device ID supplied or invalid data type. For example, the input attribute "id" is an integer but string value gets passed.
4. 401: Unauthorized Request. Access to API is forbidden.
5. 404: Not Found - URL Not Found

### Response Parameter

`UpdateGeoFenceResponse`- Class object returns the API response as a JSON object.

#### UpdateGeoFenceResponse parameters:

`message<String>`- Describes the type of error based on the type of response code.

#### 4.4 Delete Geofence

Delete Geofences by mentioning the geofence IDs in the following methods

#### 4.4.1 Delete single Geofence

Use the below method to delete a particular geofence by mentioning the geofence ID.

### Java

```java
// Delete single geofence
 // IResultListener- returns success if gefence deleted successfully, else error as callback methods.
InTouch.deleteGeoFence(<geofence id>, new IResultListener() {
	 @Override public void onSuccess() {
		 // write your code here.
	 }
	 @Override public void onError(String reason, String errorIdentifier, String errorDescription) {
			  // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.
	 }
});
```

### Kotlin

```kotlin
InTouch.deleteGeoFence(<geofence id>, object: IResultListener{
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

#### 4.4.2 Delete multiple Geofence

Use the below method to delete a list of geofence Ids at once.

### Java

```java

// Delete multiple geofences
InTouch.deleteGeoFence(<Long array of geofence ids>, new IResultListener() {
	 @Override public void onSuccess() {
		 // write your code here.
	 }
	 @Override public void onError(String reason, String errorIdentifier, String errorDescription) {
			   // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.
	 }
 });
```

### Kotlin

```kotlin
InTouch.deleteGeoFence(<Long array of geofence ids>, object: IResultListener{
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

1. `geoFenceId(Long)`- Id or array of Ids of existing geofence(s).

### Response Code

#### Success:

1.  200: To denote a successful API call.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the Developer’s key has hit its daily/hourly limit.

#### Server-Side Issues:

1.  500: Internal Server Error, the request caused an error in our systems.
2.  503: Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)

1. 200: Success
2. 203: Device Not Found
3. 400: Bad Request - Invalid device ID supplied or invalid data type. For example, the input attribute "id" is an integer but string value gets passed.
4. 401: Unauthorized Request. Access to API is forbidden.
5. 404: Not Found - URL Not Found

#### 4.5 Get Geofence Activity

The below method helps to fetch the details of all the geofence activities, such as geofence entry time, exit time, etc, and total time spent inside the geofence, which devices perform w.r.t various geofences across a defined date/time range.

#### 4.5.1 Get Geofence Activity for selected devices

### Java

```java
 InTouch.getGeoFenceActivity(<array of device ids>, <start time>, <end time>, new IGeoFenceActivityListener() {
 @Override public void onSuccess(GeoFenceActivityResponse geoFenceActivityResponse) {
	 // Write your code here.
 }
 @Override public void onError(String reason, String errorIdentifier, String errorDescription) {
	    // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }
});
```

### Kotlin

```kotlin
InTouch.getGeoFenceActivity(<array of device ids>, <start time>, <end time>, object: IGeoFenceActivityListener{
  override fun onSuccess(t : GeoFenceActivityResponse?) {
        // write your code here.
  }
  override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }
})
```

#### 4.5.2 Get Geofence Activity for selected devices and geofence(s)

### Java

```java
 InTouch.getGeoFenceActivity(<array of device ids>,<array of gefence ids>, <start time>, <end time>, new IGeoFenceActivityListener() {
 @Override public void onSuccess(GeoFenceActivityResponse geoFenceActivityResponse) {
	 // Write your code here.
 }
 @Override public void onError(String reason, String errorIdentifier, String errorDescription) {
	    // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
  }
});
```

### Kotlin

```kotlin
InTouch.getGeoFenceActivity(<array of device ids>, <array of gefence ids>, <start time>, <end time>, object: IGeoFenceActivityListener{
  override fun onSuccess(t : GeoFenceActivityResponse?) {
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

1. `deviceId(Long[])` - Long array of the device(s) Id(s) for which you want to fetch the geofence activities.
2. ` geofenceId(Long[])` - Long array of the geofence(s) Id(s) for which you want to fetch the geofence activities done by the device.
3. `startTime(long)` - epoch timestamp in seconds. Start time from where you want to fetch the geofence activities
4. `endTime(long)`- epoch timestamp in seconds. End time till where you want to fetch the geofence activities

### Response Code

#### Success:

1.  200: To denote a successful API call.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the Developer’s key has hit its daily/hourly limit.

#### Server-Side Issues:

1.  500: Internal Server Error, the request caused an error in our systems.
2.  503: Service Unavailable, during our maintenance break or server downtimes.

### Response Parameter

`GeoFenceActivityResponse`- Class object returns the API response as a JSON object.

#### InTouchGeoFenceResponse result parameters:

`- List<GeoFenceActivity>`- List of GeoFenceActivity.

##### GeoFenceResult Parameters:

1. `entryLongitude(Double)`- Longitude where the particular device entered the geofence.
2. `entryLatitude(Double)`- Latitude where the particular device entered the geofence.
3. `exitLongitude(Double)`- Longitude where the particular device exited the geofence.
4. `exitLatitude(Double)`- Latitude where the particular device exited the geofence.
5. `entryTimestamp(Integer)`- Time at which the device entered the particular geofence.
6. `exitTimestamp(Integer)`- Time at which the device exited the particular geofence.
7. `geofenceName(String)`- Name of the geofence.
8. `geofenceId(Integer)` - Id of the geofence where the activity took place.
9. `deviceId(Integer)` - Id of the device which is performing the activities w.r.t the geofence.
