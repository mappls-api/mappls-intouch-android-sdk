[<img src="https://about.mappls.com/images/mappls-b-logo.svg" height="60"/> </p>](https://www.mapmyindia.com/api)

# Mappls Bluetooth(BLE) Sensor Android Plugin

## Introduction

Now capture temperature and humidity information in real-time with the Mappls Intouch SDK. The Bluetooth(BLE) Sensor Android Plugin connects with the InTouch SDK to give you real-time temperature and humidity details along with the user's live location.

## Step 1. Add Mappls BLE Plugin

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

```java
implementation 'com.mappls.sdk:intouch-sdk:1.0.0'
implementation 'com.mappls.sdk:ble-plugin:1.0.0'
```

### Add Java 8 Support to the project

```java
compileOptions {
      sourceCompatibility 1.8
      targetCompatibility 1.8
  }
```

```java
 Required Minimum sdk version
 minSdkVersion 18
```

## <a name="StartTracking">Step 2: Start Tracking Location based BLE sensor</a>

Track your app user's phone live location with BLE sensor details (like temperature, Battery and humidity) by using the below method. Before the start tracking method add the MAC address of the BLE sensor for which you need to get the temperature data.

#### Java

```java
BluetoothLEScanHelper.getInstance().setBleDeviceMacId("<Ble Mac address>"); // sample mac address of the BLE sensor is xx:xx:xx:xx:xx:xx
InTouch.startTracking();
```

#### Kotlin

```Kotlin
 BluetoothLEScanHelper.getInstance().setBleDeviceMacId("<Ble Mac address>"); // sample mac address of the BLE sensor is xx:xx:xx:xx:xx:xx
InTouch.startTracking
```

## <a name="StopTracking">Step 3: Stop Tracking BLE Content</a>

#### Java

```java
InTouch.stopTracking();
```

#### Kotlin

```Kotlin
InTouch.stopTracking()
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
