### 5.0 Alarms

Users can get an alert whenever a particular event occurs by configuring alarm to your vehicle or user. For example, an alert can be sent to the user whenever the user or vehicle Enters/Exits the particular area or if the vehicle or user is Over Speeding or vehicle battery is low, etc. etc. These alerts are highly configurable based on different requirements.

#### 5. 1 Configure Alarms

Some of the important and more frequently used alarms for different use cases are listed below.

- Geofence
- Ignition
- OverSpeed
- UnPlugged
- Panic
- Stoppage
- Idle
- Towing
- GPRS Connectivity
- Vehicle Battery
- Mileage
- GPS connectivity
- Distance Covered
- Internal Battery Voltage

#### 5. 1. 1 Geofence Alarm

Configure geofence alarm by assigning the vehicle to a particular Geofence to get an alert when the user or vehicle enters/ exits the particular area. Geofence should be created before assigning the vehicle to geofence in alarms configuration. Refer to Create Geofence documentation to create Geofence. Get the Geofence method will fetch Geofence Ids.

##### Mandatory parameters:

- Alarm Type, id(s) of device(s), Id(s) of geofence(s)and Type of geofence

##### 5. 1. 2 Ignition Alarm

Configure the Ignition alarm to trigger an alert when the vehicle ignition is switched On or Off. Assign vehicles against this alarm.

##### Mandatory Parameters

- Alarm Type, Id(s) of the device(s) and type of Ignition

##### 5. 1. 3 Overspeed Alarm

Configure the Overspeed alarm to trigger an alert when the user or vehicle crosses the configured speed limit.

##### Mandatory parameters:

- Alarm Type, Id(s) of the device(s), Limit and Duration

##### 5. 1. 4 Unplugged Alarm

Configure an unplugged alarm to trigger an alert when a vehicle tracking device is removed from the vehicle battery

##### Mandatory parameters:

- Alarm Type and Id(s) of the device(s)

##### 5. 1. 5 Panic Alarm

Configure Panic alert using the below method. Assign this alert to the device to trigger an alert whenever the user presses the panic button.

##### Mandatory parameters:

- Alarm Type and Id(s) of the device(s)

##### 5. 1. 6 Stoppage Alarm

Configure the Stoppage alarm to alert you when the user or vehicle continuously stays in the stopped condition for more than the defined duration.

##### Mandatory parameters:

- Alarm Type, Id(s) of device(s) and Duration

##### 5. 1. 7 Idle Alarm

Configure Idle alarm to alert you when the vehicle continuously stays in the Idle condition (Engine is on but the speed is less than 7 km/hr) for more than the defined duration.

##### Mandatory parameters:

- Alarm Type, Id(s) of device(s) and Duration

##### 5. 1. 8 Towing Alarm

Configure Towing alarm to alert you when the vehicle moves at more than 7km/hr speed in Engine off state.

##### Mandatory parameters:

- Alarm Type, Id(s) of device(s) and Duration

##### 5. 1.9 GPRS Connectivity Alarm

Configure the GPRS connectivity alarm to alert you when the user or vehicle doesn't send the data to the server for more than the defined duration as per configuration.

##### Mandatory parameters:

- Alarm Type, Id(s) of device(s) and Duration

##### 5. 1. 10 Vehicle Battery Alarm

Configure the Vehicle battery alarm to alert you when the vehicle battery goes below the configured voltage value.

##### Mandatory parameters:

- Alarm Type, Id(s) of the device(s), Limit and Duration

##### 5. 1. 11 Mileage Alarm

Configure Mileage alarm to alert you when the vehicle or user travels the configured distance within the time duration. The distance can be configured for Daily and Monthly limit.

##### Mandatory parameters:

- Alarm Type, Id(s) of device(s) , Type and Duration

##### 5. 1. 12 GPS Connectivity Alarm

Configure the GPS connectivity alarm to trigger an alert when the user or vehicle doesn't send the valid location to the server for more than the defined duration as per configuration.

##### Mandatory parameters:

- Alarm Type, Id(s) of device(s) and Duration

##### 5. 1. 13 Distance Covered Alarm

Configure Distance covered alarm to trigger an alert when the vehicle or user covers a particular distance in the given duration or if the user travels less than the limit in the given duration then the alert will be triggered.

There are two types of distance covered alarm.

- At least
- At Most.

For example **At least** will be used whenever a user doesn't travel 30 km within 1 hr.

**At most** can be used when the user travels more than 30 km in 1hr.

##### Mandatory parameters:

- Alarm Type, Id(s) of the device(s), Type, Limit and Duration

##### 5. 1. 14 Internal Battery Voltage Alarm

Configure the Internal battery alarm to alert you when the Vehicle Tracking device Internal battery goes below the configured voltage value for a certain duration.

##### Mandatory parameters:

- Alarm Type, Id(s) of the device(s), Limit and Duration

#### Create Alarm Method

Define the hashmap as mentioned above based on the required alarm then call the below method.

### Java

```java
// ICreateAlarmListener - returns success if alarm created successfully, else error as callback methods.
InTouch.createAlarm(<hashMap of request params>, new ICreateAlarmListener() {
        @Override
  public void onSuccess(CreateAlarmResponse createAlarmResponse) {
	  // write your code here.
  }

        @Override
  public void onError(String reason, String errorIdentifier, String errorDescription) {
	       // reason gives the error type.
              // errorIdentifier gives information about error code.
              // error description gives a message for a particular error.
        }
    });
});
```

### Kotlin

```kotlin
InTouch.createAlarm(<hashMap of request params>, object: ICreateAlarmListener{
   override fun onSuccess(t: createAlarmResponse?) {
        // write your code here.
   }
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
   }
})
```

### Request Parameters based on different Alarms.

1. `deviceId` - Device id(s). You can pass a single device Id or multiple device Ids in the array.
2. `type` - Type is based on different alarms. Only required in case of the Geofence, Ignition, Mileage, and Distance Covered alarm. For this directly you can enter the respective integer values as mentioned below or else you can use the InTouch Constants. e.g: for AlarmType - Geofence(value-26), one of the type value is InTouchConstants.ALARM_GEOFENCE_ENTRY (value -2). [Click](./InTouchConstants.md) to see more values.
3. `duration` - Time duration in seconds. Only required in case of Overspeed, stoppage, idle, towing, GPRS connectivity, vehicle battery, GPS connectivity, distance covered, internal battery alarm.
4. `limit` - Limits for various alarms based on alarm type. It is an integer. eg: 55. Unit changes for different alarm types.
   - Overspeed Alarm - km/hr
   - vehicle battery - millivolts
   - mileage - in km/hr
   - distance covered - meters
   - internal battery alarm - millivolts
5. ` geofenceId`- Geofence Id(s). Only required in case of alarm Type Geofence. You can pass a single geofence ID or multiple geofence IDs in array.
6. `alarmType`- For each type of alarm constant value is being assigned.
   Type of alarm to create. Following are the alarm types & their corresponding IDs. Ignition: 21, Overspeed: 22, Unplugged: 23, Panic: 24, Geofence: 26, Stoppage: 27, Idle: 28, Towing: 29, GPRS Connectivity: 126, Vehicle Battery: 129, Mileage: 133, GPS Connectivity: 146, Distance Covered: 151, Internal Battery Voltage:161

#### Note:- User can use these request parameters as key in HashMap<String, String> according to different alarms type and mandatory fields required for that alarm type.

Users may use [InTouchConstants](./InTouchConstants.md)class of InTouch Sdk for different alarm type values like for geofence alarm type is 26, user can use InTouchConstants.ALARM_GEOFENCE instead of 26.

### Response Code

#### Success

1.  201 To denote a successful record is being created.

#### Client-side issues

1.  400 Bad Request, the user made an error while creating a valid request.
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

### Response Parameter

`CreateAlarmResponse` - class object returns the API response as a JSON object.

#### Create Alarm Response result parameters

`id (Long)` Id of the newly created Alarm.

### 5.2 Get Alarm configurations

Use the below methods to retrieve the configured alarms in your account with a unique alarm ID.

#### 5.2.1 Get All Alarm configurations

Call the GetAlarmConfigs method without any input parameter to display all the configured alarms from the account in response.

### Java

```java
\\\ Get all Alarm config
// IGetAlarmsListener - returns all alarms configurations if success, else error as callback methods.
InTouch.getAlarmConfigs(new IGetAlarmsListener() {
  @Override
  public void onSuccess(InTouchAlarmResponse inTouchAlarmResponse) {
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
InTouch.getAlarmConfigs(object: IGetAlarmsListener{
   override fun onSuccess(t: InTouchAlarmResponse ?) {
        // write your code here.
   }
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
   }
})
```

#### 5.2.2 Get alarm configurations based on the selected parameter

In the getAlarmConfigs(), Input parameters like devices or Alarm type or Alarm Ids can be passed to filter the particular set alarm configurations.

### Java

```java
// Alarms configurations based on different selected parameters. Users can pass null if none of the given parameters is required.

InTouch.getAlarmConfigs(<array of alarmId>, <array of deviceId>, <array of alarmType>,new IGetAlarmsListener() {
  @Override
  public void onSuccess(InTouchAlarmResponse inTouchAlarmResponse) {
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
InTouch.getAlarmConfigs(<array of alarmId>, <array of deviceId>, <array of alarmType>, object: IGetAlarmsListener{
   override fun onSuccess(t: InTouchAlarmResponse ?) {
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

1.`alarmIds (Long[])` - Array of alarm ids. Users can pass alarm ids array to get alarm configurations for provided ids otherwise pass null for all configurations.

2.`deviceIds (Long[])` - Array of device ids. Users can pass device ids array for selected devices alarm configurations otherwise pass null for all configurations.

3.`alarmTypes (Integer[])`- Array of alarm types. Users can pass alarm types array for selected alarm type alarms configurations otherwise pass null for all configurations.

### Response Code

#### Success

1.  200 To denote a successful API call.

#### Client-side issues

1.  400 Bad Request, the user made an error while creating a valid request.
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

### Response Parameter

`InTouchAlarmResponse ` class object returns the API response as a JSON object.

#### InTouchGeoFenceResponse result parameters

`- ListAlarmsConfig`- List of AlarmsConfig.

##### AlarmsConfig Parameters

1. `id(Long)`- Id of alarm
2. `deviceId(Long)`- Device Id(s) on which the alarm config got created.
3. `alarmType(Integer)` -Type of alarm for eg - 21 (InTouchConstants.ALARM_IGNITION) etc.
4. `limit(Integer)`- Min or Max limit for particular alarm.
5. `duration (integer)` - Min or Max duration in second(s) for particular alarm.
6. `type(Integer)`- Values depends on the type of alarm configured for eg for Mileage alarm it should be 0 (InTouchConstants.ALARM_MILEAGE_DAILY) or 1 (InTouchConstants.ALARM_MILEAGE_MONTHLY).
7. `updationTime(Long)`- Epoch Time at which the alarm got updated.
8. `creationTime(Long)`- Epoch Time at which the alarm got configured.
9. `geofenceId(Long[])`- If the returned alarm type is geofence (26), then this will return the list of geofences for which alarms were configured.

   10.`severity(Integer)`- Severity of alarm i.e) 0 (ALARM_SEVERITY_NORMAL) or 1 (ALARM_SEVERITY_HIGH) .

### 5. 3 Update Alarms(s)

Already created alarms can be updated using the below-mentioned methods. It is similar to create alarm but additionally, alarm ID should be the input parameter to update the respective individual alarm configurations.

Alarm Id can be fetched from the Get Alarm config.

Based on the Alarm type, the Mandatory parameter should be passed in the Hashmap.

### Java

```java
// IUpdateAlarmListener - returns success if alarm updated successfully, else error as callback methods.
InTouch.updateAlarm(<alarmId>, <HashMap of Alarm Parameters>, new IUpdateAlarmListener() {
  @Override
  public void onSuccess() {
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
InTouch.updateAlarm(<alarmId>, <HashMap of Alarm Parameters>, object: IUpdateAlarmListener{
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

1. `alarmId(Long)` - Id of the existing alarm.
2. `deviceId (Long[])` - Array of device id(s). You can pass a single device iD or multiple device iDs in an array.
3. `type (Integer)` - Type is based on different alarms i.e) Only required in case of the geofence, ignition, mileage, and Distance Covered alarm.
4. `duration (Integer)` - Time duration in seconds. Only required in case of Overspeed, stoppage, idle, towing, GPRS connectivity, vehicle battery, GPS connectivity, distance covered, internal battery alarm.
5. `limit (Integer)` - Limits for various alarms based on alarm type.
6. ` geofenceId (Long [])` - Array of geofence id(s). Only required in case of alarm Type Geofence. You can pass a single geofence ID or multiple geofence IDs in an array.
7. `alarmType (Integer)` - For each type of alarm constant value is being assigned. Selected alarm id's alarm type should be passed. It can be passed from the IntouchConstants or as an integer value. The following are the alarm types & their corresponding IDs. Ignition: 21, Overspeed: 22, Unplugged: 23, Panic: 24, Geofence: 26, Stoppage: 27, Idle: 28, Towing: 29, GPRS Connectivity: 126, Vehicle Battery: 129, Mileage: 133, GPS Connectivity: 146, Distance Covered: 151, Internal Battery Voltage:161

### Response Code

#### Success

1.  200 To denote a successful API call.

#### Client-side issues

1.  400 Bad Request, the user made an error while creating a valid request.
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

### Response Parameter

API response will return as `IUpdateAlarmListener` onSuccess() or onError(String reason, String errorIdentifier, String errorDescription) methods.

#### 5. 4 Delete Alarm configuration.

`deleteAlarm` method can be used to delete the already configured alarm. In this method, an alarm ID needs to be passed to delete the configurations.

#### 5. 4. 1 Delete single Alarm configuration

### Java

```java
// Delete single alarm
// IResultListener- returns success if alarm deleted successfully, else error as callback methods.
InTouch.deleteAlarm(<alarmId>, new IResultListener() {
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
InTouch.deleteAlarm(<alarmId>, object: IResultListener{
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

#### 5. 4. 2 Delete Multiple Alarm configuration

### Java

```java
//Delete multiple alarm
InTouch.deleteAlarm(<array of alarm ids>, new IResultListener() {
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
InTouch.deleteAlarm(<array of alarm ids>, object: IResultListener{
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

1. `alarmId(Long)` - Id or Long[] ids of the alarm config(s) which user wants to delete.

### Response Code

#### Success

1.  200 To denote a successful API call.

#### Client-side issues

1.  400 Bad Request, the user made an error while creating a valid request.
2.  401 Unauthorized, Developer’s key is not allowed to send a request with restricted parameters.
3.  403 Forbidden, the Developer’s key has hit its daily hourly limit.

#### Server-Side Issues

1.  500 Internal Server Error, the request caused an error in our systems.
2.  503 Service Unavailable, during our maintenance break or server downtimes.

### Response Messages (as HTTP response message)

1. 200 Success
2. 203 Device Not Found
3. 204: No Content Or No Data Found
4. 400 Bad Request - Invalid device ID supplied or invalid data type. For example, input attribute id is an integer but the string value gets passed.
5. 401 Unauthorized Request. Access to API is forbidden.
6. 404 Not Found - URL Not Found

#### 5. 5 Alarm Logs

Once the alert is triggered based on the configured alarms, the below method can be used to get the Alarm log details.
The alarm log gives the information about the device name, Alarm type location, and time at which the alert is being triggered.

#### 5. 5. 1 Get All alarm Logs.

Get all types of alarm logs between the start and end times of the input using the below method.

### Java

```java
// Get Alarm Logs
// IGetAlarmsLogsListener - returns all alram logs if success, else error as callback methods.
InTouch.getAlarmsLogs(<startTime>, <endTime>, new IGetAlarmsLogsListener() {
    @Override
  public void onSuccess(InTouchAlarmLogsResponse inTouchAlarmLogsResponse) {
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
InTouch.getAlarmsLogs(<startTime>, <endTime>, object: IGetAlarmsLogsListener{
   override fun onSuccess(t : InTouchAlarmLogsResponse ?) {
        // write your code here.
   }
   override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
        // reason gives the error type.
        // errorIdentifier gives information about error code.
        // error description gives a message for a particular error.
   }
})
```

#### 5. 5. 2 Get alarm Logs with filter.

Get the filtered alarm log information between the start and end time by sending the filter details like device id, Alarm type.

### Java

```java
//with filter
InTouch.getAlarmsLogs(<deviceIds array>, <alarmType array>,<startTime>, <endTime>, new IGetAlarmsLogsListener() {
    @Override
  public void onSuccess(InTouchAlarmLogsResponse inTouchAlarmLogsResponse) {
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
InTouch.getAlarmsLogs(<deviceIds array>, <alarmType array>,<startTime>, <endTime>, object: IGetAlarmsLogsListener{
   override fun onSuccess(t : InTouchAlarmLogsResponse ?) {
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

1. `startTime(Long)`- Mandatory field. This is start EPOCH timestamp in seconds.
2. `endTime(Long)`- Mandatory field. This is end EPOCH timestamp in seconds
3. `deviceId(Long[])` - Non-mandatory field. This is the ID of the device for which the alarm logs need to be fetched. You can pass a single device ID or multiple device IDs separated by a comma. For eg new Long[]{1L} or null.
4. `alarmType(Integer[])`- Non-mandatory field. This is the type of alarm for which the alarm log needs to be fetched. You can pass a single alarm type or multiple alarm type separated by a comma. For eg new Integer[]{IntouchConstant.ALARM_IGNITION} or new Integer[]{21} or null.

### Response Code

#### Success

1.  200 To denote a successful API call.

#### Client-side issues

1.  400 Bad Request, the user made an error while creating a valid request.
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

`InTouchAlarmResponse `- Class object returns the API response as a JSON object.

#### InTouchAlarmLogsResponse result parameters

`- ListAlarmLogs` - List of AlarmLogs.

##### AlarmsConfig Parameters

1. `deviceId(Long)` - Id of the device for which the alarm got generated.
2. `timestamp(Long)`- EPoch Time at which the alert got generated.
3. `latitude(Double)` - Location latitude
4. `longitude(Double)`- Location longitude.
5. `address(String)` - Location address at which the alarm got generated.
6. `alarmType(Integer)` - Type of alarm to create alarm. The following are the alarm types & their corresponding IDs.  
   Ignition 21, Overspeed 22, Unplugged 23, Panic 24, Geofence 26, Stoppage 27, Idle 28, Towing 29, GPRS connectivity 126, Vehicle Battery 129, Mileage 133, GPS Connectivity 146, Distance Covered 151, Internal Battery Voltage 161,

7. `limit(Integer)`- Alarm limit as set in the config. For example, if an Overspeed alarm set on the limit of 44 km/hr in the alarm config setting, then this attribute will return 44 km/hr.

8. `duration(Integer)` - Alarm duration limit as set in the alarm config section. For example, if the duration of the Overspeed alarm is set as 20 secs, then the alarm will generate when the vehicle over speeds for 20 secs.

9. `actualLimit(Integer)` -The actual data received from the device at that particular moment when the alarm got generated.

10. `actualDuration(Integer)` - Actual duration for which the device breached the alarm config

11. `severity(Integer)` - 0 - Low Severity. 1 - High Severity

12. `data(Integer)`- Describes the state of the alarm. Ignition(type = 21), 0 Off & 1 On.
    AC(type=25), 0 OFF, 1 ON. Geofence (type=26), 1 Entry & Exit Geofence 2 Entry Geofence, 3 Leaving Geofence & 4 Long Stay In Geofence.

13. `geofenceId(Integer)`- This is the ID of the geofence for which the alarm got generated. This will come only when the 'type' field returns 26 i.e) geofence.
