[<img src="https://about.mappls.com/images/mappls-b-logo.svg" height="60"/> </p>](https://www.mapmyindia.com/api)

# Mappls Intouch Android SDK

## Introduction

Get Real-Time Location Tracking for your apps with Mappls InTouch SDK. Track a user's live location with our simplified InTouch SDK integration (for Android), highly customizable to your specific needs.

The InTouch SDK comes with a variety of events that enable better control and power over your tracking needs. Get ready made events to create,, Geo-Fences, Event Alerts, and Trails of telematics/ phone devices. Also get location benefits built for various applications including logistics, delivery tracking, employee tracking, and live location sharing.

To get started, explore the InTouch Demo App.

Already have an application? Give it a boost with the powerful features of InTouch. Learn how to [Integrate the InTouch SDK](#IntegrateIntouchSDK)

- [Setup](#Setup): Please contact apisupport@mappls.com to get the Intouch SDK authorisation for your Client ID and Client Secret.
- [Quick Start](https://github.com/mappls-api/mappls-intouch-android-sdk#intouchdemo-app): Start with a ready-to-go app
- [Integrate the SDK](./GettingStarted.md): Integrate the SDK into your app
- [Dashboard](./Dashboard.md): See all your devices' locations on Mappls InTouch Dashboard
- [InTouch Telematics APIs](./Dashboard.md): Use InTouch APIs to get the details of the devices.

## Setup

We use your Client ID to identify your account details and assign all your user's devices under a single account.

To get your Outh2 Rest API Client ID and Client Secret please login to Mappls [API Dashboard](https://about.mappls.com/api/signup)

Please contact [apisupport@mappls.com](mailto:apisupport@mappls.com) to get InTouch SDK access to your Client ID

After getting the access, you can [start with the InTouchDemo app](#InTouchDemoApp), or [Integrate the InTouch SDK](#IntegrateIntouchSDK) in your app.

## InTouchDemo app

This guide allows you to add live location tracking to an Android app. [Android Studio](https://developer.android.com/studio/index.html) is the recommended development environment for building an app with the Mappls InTouch SDK for Android.

#### Step 1. Download the InTouchDemo App.

[Click here](https://github.com/mappls-api/mapmyindia-intouch-android-sdk/archive/master.zip) to download the InTouchDemo App Project. Open this project in [Android Studio](https://developer.android.com/studio/index.html)

#### Step 2. Set your Publishable key

1.  Add the publishable key to [SetUpKeyFragment Fragment](https://github.com/mappls-api/mappls-intouch-android-sdk) file.
2.  Run project on your device using simulator instance.
3.  Go through run-time [permission flow](https://developer.android.com/training/permissions/requesting) (applicable for Android M and later).

#### Step 3. Check your location on the InTouch [dashboard](https://intouch.mappls.com/nextgen)

## Integrate the InTouch SDK

- [Add InTouch SDK](#AddInTouchSDK)
- [Start tracking](#StartTracking)
- [InTouch Telematics APIs](./Dashboard.md)
- [Utility methods](./UtilityMethods.md)

## Step 1: Setup a project

1.  Start Android Studio.
2.  Create a new project as follows:
    - If you see the **Welcome to Android Studio** dialog, choose **Start a new Android Studio project**, available under 'Quick Start' on the right of the dialog.
    - Otherwise, click **File** in the Android Studio menu bar, click **New**-> **New Project**.
    - Select the form factors you need for your app. If you're not sure what you need, just select **Phone and Tablet**.
    - Select **Add No Activity** and click **Next**.
3.  Enter your app name, package name, project location, language and minimum API version as prompted. Click **Next**.
4.  Create a **Basic Activity** in the 'Add an activity to Mobile' dialog. Click **Next**.
5.  Enter the activity name, layout name and title as prompted. Click **Finish**.

Android Studio starts Gradle and builds your project. This may take a few seconds. For more information about creating a project in Android Studio, see the [Android Studio documentation](https://developer.android.com/studio/projects/create-project.html).

The next few sections contain the code samples that you need to add to your activity's java file as well as its xml layout file for creating an app with Mappls InTouch SDK for live tracking.

## Step 2. Add InTouch SDK

Follow these steps to add the SDK to your project –

- Create a new project in Android Studio
- Add Mappls repository in your project level `build.gradle`

```java
allprojects {
    repositories {

        maven {
            url 'https://maven.mappls.com/repository/mappls/'
        }
    }
}
```

- Add below dependency in your app-level `build.gradle`

```groovy
implementation 'com.mappls.sdk:intouch-sdk:1.4.6'
```

### Add Java 17 Support to the project

```groovy
compileOptions {
      sourceCompatibility JavaVersion.VERSION_17
      targetCompatibility JavaVersion.VERSION_17
  }
```

```groovy
 //Required Minimum sdk version
 minSdkVersion 19
```

## Step 3: Initialize InTouch SDK

Initialization can be done either of the below mentioned method. Keep the same method accross your project.

### To set CI/CS
#### Java
~~~java
MapplsAccountManager.getInstance().setAtlasClientId(key_ci);
MapplsAccountManager.getInstance().setAtlasClientSecret(key_cs);
~~~

#### Kotlin
~~~kotlin
MapplsAccountManager.getInstance().atlasClientId = key_ci;
MapplsAccountManager.getInstance().atlasClientSecret = key_cs;
~~~

#### Method 1:

Initialize the SDK without unique Id. Intouch SDK will create a unique Id for the device. On every new device Login , a new device will be created and the new device id will be returned.

#### Java

```java
// IAuthListener - returns authorization results in the forms of callbacks.
InTouch.initialize(<device name>, new IAuthListener() {
	@Override
	public void onSuccess(Long id) {
			  //write your code here
	}
	@Override
	public void onError(String reason, String identifier, String description) {
	         // reason gives the error type.
            // errorIdentifier gives information about error code.
           // errorDescription gives a message for a particular error.
	}
});

```

#### Kotlin

```Kotlin
InTouch.initialize(<device name>, object : IAuthListener {
    override fun onSuccess() {
         //write your code here
    }
	override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
       // reason gives the error type.
      // errorIdentifier gives information about error code.
      // errorDescription gives a message for a particular error.
    }

})
```

### or

#### Method 2:

Initialize the SDK with your own Unique Id. It is recommended to use when you maintain the unique Id for your users. Now when ever this Unique Id is passed same device id will be returned in the response, even if the user s logs from different devices.

#### Java

```java
// IAuthListener - returns authorization results in the forms of callbacks.
InTouch.initialize(<device name>, <uniqueId>, <fcmToken>, new IAuthListener() {
	@Override
	public void onSuccess(Long id) {
			  //write your code here
	}
	@Override
	public void onError(String reason, String identifier, String description) {
	         // reason gives the error type.
            // errorIdentifier gives information about error code.
           // errorDescription gives a message for a particular error.
	}
});

```

#### Kotlin

```Kotlin
InTouch.initialize(<device name>, <uniqueId>, <fcmToken>, object : IAuthListener {
    override fun onSuccess(Long entityId) {
         //write your code here
    }
	override fun onError(reason: String?, errorIdentifier: String?, errorDescription: String?) {
       // reason gives the error type.
      // errorIdentifier gives information about error code.
      // errorDescription gives a message for a particular error.
    }

})
```

On sucessful registration you will get the Id, use this Id in APIs to get the live location or to create trips against the user.

## <a name="StartTracking">Step 4: Start Tracking</a>

Track your app user's phone live location by using the below method.

#### Java

```java
InTouch.startTracking();
```

#### Kotlin

```Kotlin
InTouch.startTracking
```

## <a name="StopTracking">Step 4: Stop Tracking</a>

#### Java

```java
InTouch.stopTracking();
```

#### Kotlin

```Kotlin
InTouch.stopTracking
```

## Supported Plugin

### - [Mappls BLE Plugin](https://github.com/Mappls/Mappls-intouch-android-sdk/wiki/Mappls-BLE-Plugin)


<br><br><br>

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
