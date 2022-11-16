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
