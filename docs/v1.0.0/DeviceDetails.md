

### <a name="GetDeviceDetails">Device Details</a>

Get accurate live location and related data of vehicles, assets & people with help of connected devices/sensors/mobiles to provide location awareness to users of your app.

Below mentioned methods provide real-time visibility of your tracked objects, giving not just location information, but multiple additional fields which add value to your application.

### 1) Get live device details by single or multiple IDs.

#### a) Get the list of all devices live data in your account.
### Java
```java
InTouch.getDevices(<includeInActive>,<ignoreBeacon>,<lastUpdateTime>, new IDeviceListener() {
       @Override
       public void onSuccess(DevicesResponse devicesResponse) {
	           // write your code here.
	  }
	  @Override
	  public void onError(String reason, String identifier, String description) {
	            // reason gives the error type. 
               // errorIdentifier gives information about error code. 
              // errorDescription gives a message for a particular error.
	            }
	    });
```
### Kotlin
```Kotlin
InTouch.getDevices(<includeInActive>,<ignoreBeacon>,<lastUpdateTime>, object : IDeviceListener {  
    override fun onSuccess(t: DevicesResponse?) {  
        // write your code here. 
    }  
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
       // errorDescription gives a message for a particular error.  
    }  
  
})
```
b)  Get the list of selected devices live data.
### Java
```java
 InTouch.getDevices(<Long[] List of deviceIds>,<includeInActive>,<ignoreBeacon>,<lastUpdateTime>,new IDeviceListener() {
            @Override
            public void onSuccess(DevicesResponse devicesResponse) {
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
 InTouch.getDevices(<Long[] List of deviceIds>,<includeInActive>,<ignoreBeacon>,<lastUpdateTime>,object : IDeviceListener {  
    override fun onSuccess(t: DevicesResponse?) {  
        // write your code here. 
    }  
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
       // errorDescription gives a message for a particular error.  
    }  
  
})
```
c) Get a single device live data
### Java
```java
 InTouch.getDevice(<deviceId>,<lastUpdateTime>, new IDeviceListener() {  
    @Override  
    public void onSuccess(DevicesResponse devicesResponse) {  
        // write your code here.
    }    @Override  
    public void onError(String reason, String errorIdentifier, String errorDescription) {  
		       // reason gives the error type. 
               // errorIdentifier gives information about error code. 
              // errorDescription gives a message for a particular error.
    }  
});
```
### Kotlin
```kotlin
 InTouch.getDevice(<deviceId>,<lastUpdateTime>, object : IDeviceListener {  
    override fun onSuccess(t: DevicesResponse?) {  
        // write your code here. 
    }  
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
       // errorDescription gives a message for a particular error.  
    }  
  
})
```

### Request Parameters

1. ```deviceId```(Long)  - This is the device ID
2. ```includeInActive``` (Boolean)  -If "true" then API response will include inactive devices along with active devices. If "false" then API will return only active devices.
3. ```ignoreBeacon``` (Boolean) - If set to "true" then API will return all devices except those with device type as a beacon(mobile).
4. ```lastUpdateTime``` (Long) - Give EPOCH timestamp in seconds to fetch only those live locations of devices that have come after the given timestamp. If "lastUpdateTime" is given then by default only active devices will be fetched irrespective of the status of "includeInActive" attribute else set the value as 0.


### Response Code (as HTTP response code)

#### Success:

1.  200: To denote a successful API call.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the Developer’s key has hit its daily/hourly limit.

#### Server-Side Issues:

1.  500: Internal Server Error, the request caused an error in our systems.
2.  503: Service Unavailable, It comes during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)
1. 200: Success
2. 203: Device Not Found
3. 204: No Content Or No Data Found
4. 400: Bad Request - Invalid device ID supplied or invalid data type. For example, the input attribute "id" is an integer but string value gets passed.
5. 401: Unauthorized Request. Access to API is forbidden.
6. 404: Not Found - URL Not Found

### Response Parameter
`DevicesResponse` class object returns the API response as a JSON object.

#### DeviceResponse result parameters:
1. ```id (Long)``` - Id of the device.
2. ```active (string) ```- Device active status
3. ```status (string)``` - Device movement status
4. ```vehicleBattery (Double)``` - Device battery status
5. ```location (Location)``` - Device live location object like latitude, longitude etc.
6. ```deviceDetails(DeviceDetails)``` - Device info object like name etc.
7. ```alerts (Alerts)``` - Alert object
8. ```canInfo (CanInfo)``` - Device CanInfo object.
9. ```deviceFaults (ArrayList<DeviceFault>)``` - List of various fault.
10. ```currentGeofence (ArrayList<Long>)``` - list of current geofences id.
11. ```todaysDrive (TodaysDrive)``` - TodaysDrive object.

##### Location parameters:
1. ```gpsTime (Long)``` - Time at which data is being fetched from the device
2. ```gprsTime (Long)``` - Time at which data is being received at the server end.
3. ``` latitude (Double)``` - Device location latitude
4. ```longitude (Double)``` - Device location Longitude
5. ```altitude (Double)``` - Device location Altitude
6. ```heading (Double)``` - Angle at which is the device is moving
7. ```speedKph (Double)``` - Device or vehicle's GPS based speed.
8. ```address (String)``` - Complete address of the location.
9. ```odometer (Double)``` - Either GPS or CAN Odometer based on the configuration.

##### DeviceDetails parameters:
1. ```deviceId (Long)``` - Id of device.
2. ```registrationNumber (String)``` Device registration number.
3. ```deviceType (String)``` - Type of device like a car, truck, bus, bike, tractor, JCB, excavator, etc.

##### Alerts parameters:
1. ```deviceId (Long)``` - Id of device.
2. ```timestamp (Long)``` - EPOCH time at which alarm was generated
3. ```latitude (Double)```- Location latitude of alarm.
4. ```longitude (Double)``` - Location longitude of alarm.
5. ```address (String)``` - Location address at which the alarm got generated
6. ```alarmType (Integer)``` - Type of alarm to create. The following are the alarm types & their corresponding IDs.  
   IGNITION: 21, OVERSPEED: 22, UNPLUGGED: 23, PANIC: 24, GEOFENCE: 26, STOPPAGE: 27, IDLE: 28, TOWING: 29, GPRS CONNECTIVITY: 126, VEHICLE BATTERY: 129, MILEAGE: 133, GPS CONNECTIVITY: 146, DISTANCE COVERED: 151, INTERNAL BATTERY VOLTAGE:161
7. ```limit (Integer)```- Alarm limit as set in the config. For example, if an Overspeed alarm set on the limit of 44 km/hr in the alarm config setting, then this attribute will return 44 km/hr
8. ```duration (Long)``` - Alarm duration limit as set in the alarm config section. For example, if the duration of Overspeed alarm is set as 20 secs, then the alarm will generate when the vehicle over speeds for a duration of 20 secs
9. ```actualLimit (Integer)``` - The actual data received from the device at that particular moment when the alarm got generated. For example, when the over-speed alert generated the vehicle actual speed was 56km/hr.
10. ```actualDuration (Integer)``` - Actual duration for which the device breached the alarm config limit
11. ```severity (Integer)``` -   0:Low Severity. 1:High Severity
12. ```data (Integer)``` - Describes the state of the alarm. IGNITION(type = 21), 0: OFF & 1: ON. AC(type=25), 0: OFF, 1: ON. GEOFENCE(type=26), 1: Entry & Exit Geofence 2: Entry Geofence, 3: Leaving Geofence & 4: Long Stay In Geofence
13. ```geofenceId (Long)``` - Unique ID of the geofence for which the alarm got generated.

##### CanInfo parameters:
1. ```calcEngineVal (Integer) ```- Calculated Engine value.
2. ```greenDriveType (String)``` - HA(Harsh acceleration), HB(Harsh Braking), HC(Harsh Cornering).
3. ```canTimestamp (Long)``` - Exact EPOCH time at which the CAN data got generated by the device.
4. ```coolantTemp (Integer)``` - Coolant temperature.
5. ```engineRPM (Integer)``` - Rpm value of engine.
6. ```accelPedal (Double)``` - This is accelerator pedal value in percentage.
7. ```pedoMeter (Integer)``` - Pedometer value in steps.
8. ```parkBrake (Double)``` - This is the parking brake. 0 means parking brake is disengaged & 1 means parking brake is engaged.
9. ```brakePedal (Double)``` - 1 means brake pedal is engaged & 0 means brake pedal is disengaged.
10. ```fuelLevel (Integer)``` - The level of the fuel in liters.
11. ```driverDoor (Double)``` - 1 means door is open & 0 means door is closed.
12. ```passDoor (Double)``` - 1 means door is open & 0 means door is closed.
13. ```headLights (Double)``` - 1 means ON & 0 means OFF.
14. ```blinker (Double)``` - 1 means ON & 0 means OFF.
15. ```ac (Integer)``` - 1 means AC is ON & 0 means AC is OFF.
16. ```fuelConsAVG (Integer)``` - Fuel constant average.
17. ```intakeAirTemp (Double)``` - Intake air temperature of the engine.
18. ```intakeabsolutePress (Integer)``` - Intake absolute pressure of the engine. It is defined in Pa(Pascal)

##### DeviceFault parameters:
1. ```code (String)``` - Fault code.
2. ```timestamp (Long)``` - Duration as EPOCH Time.
3. ```status (Integer)``` - Describes the status of the fault which was detected. 0: OPEN & 1: Close.
4. ```closedOn (Long)```- The EPOCH time at which fault code closed. This will come for the closed case.

##### TodaysDrive parameters:
1. ```todayKms (Double)``` - Distance in Km(s).
2. ```todayMovementTime (Long)``` - Movement time in sec(s).
3. ```todayIdleTime (Long)``` - Idle time in sec(s).
4. ```todayDriveCount (Long)``` - Drive count for today.

### 2) Get Device info
Below method returns the basic info of devices such as their registration number, type of entity, manufacturer etc.
#### a) Get all devices info
### Java
```java
InTouch.getDevicesInfo(new IDeviceInfoListener() {
       @Override
       public void onSuccess(DeviceInfoResponse response) {
	           // write your code here.
	  }
	  @Override
	  public void onError(String reason, String identifier, String description) {
	            // reason gives the error type. 
               // errorIdentifier gives information about error code. 
              // errorDescription gives a message for a particular error.
	            }
	    });
```
### Kotlin
```Kotlin
InTouch.getDevicesInfo(object : IDeviceInfoListener{  
    override fun onSuccess(t: DeviceInfoResponse ?) {  
        // write your code here. 
    }  
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
       // errorDescription gives a message for a particular error.  
    }  
  
})
```
#### b) Get the selected device info
### Java
```java
InTouch.getDevicesInfo(<array of device id(s)>, new IDeviceInfoListener() {
       @Override
       public void onSuccess(DeviceInfoResponse response) {
	           // write your code here.
	  }
	  @Override
	  public void onError(String reason, String identifier, String description) {
	            // reason gives the error type. 
               // errorIdentifier gives information about error code. 
              // errorDescription gives a message for a particular error.
	            }
	    });
```
### Kotlin
```Kotlin
InTouch.getDevicesInfo(<array of device id(s)>, object : IDeviceInfoListener{  
    override fun onSuccess(t: DeviceInfoResponse ?) {  
        // write your code here. 
    }  
    override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {  
        // reason gives the error type. 
        // errorIdentifier gives information about error code. 
       // errorDescription gives a message for a particular error.  
    }  
  
})
```
### Request Parameters

1. ```id```(Long)  - This is the device ID. You may pass single or multiple ids in an array.


### Response Code (as HTTP response code)

#### Success:

1.  200: To denote a successful API call.

#### Client-side issues:

1.  400: Bad Request, User made an error while creating a valid request.
2.  401: Unauthorized, the Developer’s key is not allowed to send a request with restricted parameters.
3.  403: Forbidden, the Developer’s key has hit its daily/hourly limit.

#### Server-Side Issues:

1.  500: Internal Server Error, the request caused an error in our systems.
2.  503: Service Unavailable, It comes during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)
1. 200: Success
2. 203: Device Not Found
3. 400: Bad Request - Invalid device ID supplied or invalid data type. For example, the input attribute "id" is an integer but string value gets passed.
4. 401: Unauthorized Request. Access to API is forbidden.
5. 404: Not Found - URL Not Found

### Response Parameter
`DeviceInfoResponse` class object returns the API response as a JSON object.

#### DeviceInfo result parameters:
1. ```id (Integer)``` - Id of the device.
2. ```name(string) ```- Name of the device.
3. ```type(Integer)``` - Type of entity like 0 - car, 1 - person, 2 - asset, 3 - bike, 4 - bus, 5 - truck, 6 - tractor.
4. ```creationOn(long)``` - Date when the device was created.
5. ```updationOn(long)``` - Date when device info got updated.
6. ```expiryDate(long)``` - Date when device validity subscription will get expired.
7. ```active(Boolean)``` - Whether device is active or not.
8. ```registrationNumber(String)``` - Device's registration number.
9. ```manufacturer(String)``` - Device manufactured by.
10. ```model(String)``` - Device's model type.
11. ```color(String)``` - Color of the device.
12. ```geofenceIds(List<Integer>)``` - IDs of the geofences associated with the device.
13. ```tag(List<String>)``` - Tag of the vehicle with the custom string value
14. ```chasisNo``` - Chassis number of the device.
15. ```initialOdometer``` - Initial odometer reading.
