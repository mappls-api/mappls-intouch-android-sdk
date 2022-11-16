# Utility Methods

### Update Device Name

a) Use the below method to update the device name when you used method 1 during initialization. (auto-generated uniqueId) . This method is used when initialization happens without user-defined uniqueId.

### Java

```java
InTouch.updateDeviceName(<deviceName>, new IUpdateDeviceListener(){
	 @Override
	 public void onSuccess() {
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
InTouch.updateDeviceName(<deviceName>, object : IUpdateDeviceListener(){
	 override fun onSuccess() {
		 // write your code here.
	 }
	 override fun onError(String reason, String errorIdentifier, String errorDescription) {
	   // reason gives the error type.
       // errorIdentifier gives information about error code.
       // errorDescription gives a message for a particular error.
	 }
})
```

b) Use the below-metioned method to update the device name when you used method 2 (self-generated uniqueId) during initialization. This method is used when initialize happen with user-defined uniqueId.

### Java

```java
InTouch.updateDeviceName(<deviceName>,<uniqueId>, new IUpdateDeviceListener(){
	 @Override
	 public void onSuccess() {
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
InTouch.updateDeviceName(<deviceName>,<uniqueId>, object : IUpdateDeviceListener(){
	 override fun onSuccess() {
		 // write your code here.
	 }
	 override fun onError(String reason, String errorIdentifier, String errorDescription) {
	   // reason gives the error type.
       // errorIdentifier gives information about error code.
       // errorDescription gives a message for a particular error.
	 }
});
```

### Request Parameters

1.  `deviceName(String)` - Updated name of the device.
2.  `uniqueId(String)` - Unique Id of the user to whom name needs to be updated.

### Java

```java
   InTouch.isRunning();
```

### Kotlin

```kotlin
   InTouch.isRunning
```

### Stop Location Tracking

You can stop tracking the user location using the below method.

### Java

```java
   InTouch.stopTracking();
```

### Kotlin

```kotlin
   InTouch.stopTracking
```

### Customize foreground service notification

Mappls InTouch tracking runs as a separate foreground service, so when tracking is started, users will see a persistent notification. By default, it displays your app icon with text {app name} is running but you can customize it anytime after initialization by calling:

### Java

```java
   a)  Intouch.getInstance().addNotificationIconsAndTitle(int smallIconId, int largeIconId, String title, String body);
   b)  Intouch.getInstance().addNotificationIconsAndTitle(int smallIconId, int largeIconId, String title, String body, String callingAction);
   c)  Intouch.getInstance().addNotificationIconsAndTitle(int smallIconId, int largeIconId, String title, String body, String callingAction, int color);

```

### Kotlin

```kotlin
   a)  Intouch.getInstance().addNotificationIconsAndTitle(smallIconId : Int ,largeIconId : Int, title : String , body : String);
   b)  Intouch.getInstance().addNotificationIconsAndTitle(smallIconId : Int ,largeIconId : Int, title : String , body : String, callingAction : String);
   c)  Intouch.getInstance().addNotificationIconsAndTitle(smallIconId : Int ,largeIconId : Int, title : String , body : String, callingAction : String, color : Int);

```

### Request Parameters

1. `smallIconId`(int) - notification small icon.
2. `largeIconId` (int) - notification large icon.
3. `title` (Boolean) - notification title.
4. `body` (Long) - notification body.
5. `callingAction`(String) - Action string to open selected Activity on click notification.  
   for example: In manifest file:-

```xml
<intent-filter>
<action android:name="com.example.notification" />
                     ----------
</intent-filter>
```

Here, com.example.notification is an actionable String. 6. `color` (int) - Notification icon color.

### Change the data Polling configuration.

#### Custom Configuration

Users can customize data polling configuration using below mentioned Config class.

(1) With predefine priorities:-

### Java

```java
	new Config.Builder(context)
        .setPriority(InTouch.BEACON_PRIORITY_FAST)
        .build();
```

### Kotlin

```kotlin
	Config.Builder(context)
        .setPriority(InTouch.BEACON_PRIORITY_FAST)
        .build()
```

(2) With custom parameters:-

### Java

```java
   new CustomConfig.Builder(context)
	    .setBeaconStandByTimeInMins(15)
	    .setDetectDrive(true)
	    .setTimeWhileMovingInSec(15)
	    .build();
```

### Kotlin

```kotlin
   CustomConfig.Builder(context)
	    .setBeaconStandByTimeInMins(15)
	    .setDetectDrive(true)
	    .setTimeWhileMovingInSec(15)
	    .build()
```

Note:- it should be set before startTracking() method.

There are three predefined properties are there.
`InTouch.BEACON_PRIORITY_FAST` - Recommended for short-haul delivery tracking.
`InTouch.BEACON_PRIORITY_SLOW` - Recommended for Long haul delivery tracking.
`InTouch.BEACON_PRIORITY_OPTIMAL` - Recommended for all the other tracking. Data polling frequency is based on the user movement.

By default, InTouch SDK uses the optimal property.

### Get Current Location.

```java
InTouch.getCurrentLocation(new ILocationUpdate(){
 @Override
 public void onLocationUpdate(Location location) {
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

```kotlin
InTouch.getCurrentLocation(object : ILocationUpdate{
    override fun onLocationUpdate(location : Location) {
         //write your code here
    }
	override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
       // reason gives the error type.
      // errorIdentifier gives information about error code.
      // errorDescription gives a message for a particular error.
    }
})
```
