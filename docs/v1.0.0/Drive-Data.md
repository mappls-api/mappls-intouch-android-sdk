
### <a name="GetDrivesData">Drive's Data</a>

Get the drive details of a vehicle/user in an InTouch account using the below method. A drive is a list of reported geo-positions with the start and end location of a vehicle according to pre-defined conditions. Time duration, distance covered during the drive, HA, HB, HC events are also returned along with the drive details.

### Java
```java
// IDrivesListener - returns drives as response if success else returns error.
InTouch.getDrive(<deviceId>, <startTime>, <endTime>, new IDrivesListener() {
            @Override
            public void onSuccess(IntouchDriveResponse intouchDriveResponse) {
               // write your code here.
            }
            @Override
            public void onError(String reason, String errorIdentifier, String errorDescription) {
              // reason gives the error type. 
              // errorIdentifier gives information about error code. 
              // errorDescription gives a message for a particular error.
            }
        });
```
### Kotlin
```kotlin
// IDrivesListener - returns drives as response if success else returns error.
InTouch.getDrive(<deviceId>, <startTime>, <endTime>, object: IDrivesListener{  
   override fun onSuccess(t: IntouchDriveResponse?) {  
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

1.```deviceId(Long)``` - Id of the device for which the drives need to be fetched.

2. ```startTime(Long)``` - The start Epoch timestamp in seconds from which the drives need to be fetched.

3. ```endTime(Long)``` -  The end Epoch timestamp in seconds till which the drives need to be fetched.

### Response Code
#### Success:
1.  200: To denote a successful API call.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the developer’s key has hit its daily/hourly limit.

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
`DriveResponse` Class object returns the API response as a JSON object.

#### DriveResponse result parameters:
1. ```deviceId (Long)``` -  Device id of selected device.
2. ```drivingBehaviourCount (DrivingBehaviourCount)``` - Driving behavior count in the selected drive.
3. ```movement(Movement)``` - Movement info object.
4. ```location (Location)``` - Location info object.

#### Movement parameters:
1. ```duration (Long)``` - Drive duration in seconds.
2. ```distance (Long)``` - The driving distance in KMs.
3. ```idleTime (Long)``` -Idle time in seconds.
4. ```movementTime (Long)``` - Movement time in seconds.
5. ```stoppageTime (Long)``` - Stoppage time in seconds.

#### DrivingBehaviourCount parameters:
1. ```haCount (Integer)``` - Harsh acceleration count.
2. ```hbCount (Integer)``` - Harsh braking count.
3. ```hcCount (Integer)``` - Harsh cornering count.

#### PositionList parameters:
1. ```startAddress(String)``` - Start address of particular drive.
2. ```startTimestamp(Long)``` - Start Epoch time of particular drive.
3. ```endAddress(String)``` - End address of particular drive.
4. ```endTimestamp(Long)``` - Start Epoch time of particular drive.
5. ```avgSpeed(Double)``` - Speed in km/hr.