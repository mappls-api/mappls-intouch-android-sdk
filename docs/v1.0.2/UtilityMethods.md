[<img src="https://about.mappls.com/images/mappls-b-logo.svg" height="60"/> </p>](https://www.mapmyindia.com/api)
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
 public void onLocationUpdate(Location location, boolean isFake, boolean isAccurate) {
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
    override fun onLocationUpdate(location : Location, isFake : Boolean , isAccurate : Boolean ) {
         //write your code here
    }
	override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
       // reason gives the error type.
      // errorIdentifier gives information about error code.
      // errorDescription gives a message for a particular error.
    }
})
```
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
