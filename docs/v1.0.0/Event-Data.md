### <a name="GetEventsData">Event's Data</a>

Get the Trails (Travelled path) of a device in your account using the below methods.

### Java

```java
InTouch.getLocationsEvents(<deviceId>,<startTime>,<endTime>,<skipPeriod> new ILocationEventsListener() {
	 @Override
	 public void onSuccess(LocationEventsResponse locationEventsResponse) {
           // Write your code here.
     }
      @Override
      public void onError(String s, String s1, String s2) {
            // reason gives the error type.
           // errorIdentifier gives information about error code.
           // error description gives a message for a particular error.
            }
        });
```

### Kotlin

```kotlin
InTouch.getLocationsEvents(<deviceId>,<startTime>,<endTime>,<skipPeriod>, object: ILocationEventsListener{
    override fun onSuccess(t: LocationEventsResponse?) {
         // Write your code here.
    }
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?l̥l̥) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
    }

})
```

### Request Parameters

1. `deviceId(Long)` - Id of the device for which the location data need to be fetched.
2. `startTime(Long)` - Start Epoch timestamp in seconds from which the events need to be fetched.
3. `endTime(Long)` - End Epoch timestamp in seconds till which the events need to be fetched.
4. `skipPeriod(int)` - Defined in minutes. For example, if 2 is passed then the returned data packet will have a minimum difference of 2 mins else 0.

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

`LocationEventResponse` class object returns the API response as a JSON object.

#### LocationEventResponse result parameters:

1. `deviceId (Long)` - Device id of selected device.
2. `drivingBehaviourCount (DrivingBehaviourCount)` - Driving behavior count in the selected device.
3. `summary (Summary)` - Brief summary of all locations.
4. `positionList (List<PositionList>)` - List of location positions.

#### Summary parameters:

1. `distance (Double)` - Total drive distance in KM(s).
2. `duration (Long)` - Total drive duration in seconds.
3. `avgSpeed (Double)` - Average speed in km/hr.
4. `startAddress (String)` - Start address of the location.
5. `endAddress (String)` - End address of the location.
6. `startTimestamp (Long)` - Start Epoch time of the event. i,e) the time at which the data first came from the device for the selected day
7. `endTimestamp (Long)` - End Epoch time of the event. i,e) the time at which the last data came from the device for the selected day.

#### DrivingBehaviourCount parameters:

1. `haCount (Integer)` - Harsh acceleration count.
2. `hbCount (Integer)` - Harsh braking count.
3. `hcCount (Integer)` - Harsh cornering count.

#### PositionList parameters:

1. `address (String)` - Address of particular location.
2. `timestamp (Long)` - Epoch Time at a particular location.
3. `longitude (Double)` - Location longitude.
4. `latitude (Double)` - Location latitude.
5. `heading (Double)` - Device heading direction in degrees from North.
6. `speed (Double)` - Device speed at this particular location.
7. `powerSupplyVoltage (Double)` - Battery voltage value in millivolts.
8. `ignition (Boolean)` - Whether vehicle ignition is On or Off. 0 means ignition is OFF and 1 means ignition is ON.
9. `gpsFix (Boolean)` - GPS fixes or not for the device. true means GPS is fixed and false means GPS is not fixed.
10. `validGPS (Boolean)` - Checks whether GPS is valid or not.
11. `accOff (Boolean)` - Checks for whether adaptive cruise control is enabled or not.
12. `movementStatus (String)` - Checks the movement status of the device. 1:Moving, 2:Idle, 3:Stopped, 4:Towing, 5:No Data 6:Power Off, 7:No Gps, 8:On Trip, 9:Free Vehicle
13. `mobileInfos (MobileInfo)` - MobileInfo object

#### MobileInfo parameters:

1. `locationSource (Integer)` - Returns location source i.e 1 - GPS connected, 2 - GPRS connected.
2. `mockLocation (Boolean)` - If true means mock location is enabled else false means real GPS location being sent by the user.
3. `isAirplanemode (Boolean)` - Checks whether mobile's airplane mode is ON or OFF.
4. `callStatus (Integer)` - Current call status like 0:CALL_STATE_IDLE, 1:CALL_STATE_RINGING, 2:CALL_STATE_ONCALL
5. `deviceStatus (Integer)` - Status of the device in the current location. 0: IN_VEHICLE, 1: ON_BICYCLE, 2: ON_FOOT,
   3:STILL, 4:UNKNOWN, 5:TILTING, 6:WALKING, 7:RUNNING.
6. `phoneEvent (Integer)` - Checks the location permission that the user enables/disables in the mobile phone. For eg:- 5 for location permission denied. 6 for location provider off etc.
