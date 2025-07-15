# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

-dontwarn com.google.auto.value.AutoValue$Builder
-dontwarn com.google.auto.value.AutoValue
-dontwarn com.google.firebase.messaging.FirebaseMessaging
-dontwarn com.huawei.hmf.tasks.OnFailureListener
-dontwarn com.huawei.hmf.tasks.OnSuccessListener
-dontwarn com.huawei.hmf.tasks.Task
-dontwarn com.huawei.hms.api.HuaweiApiAvailability
-dontwarn com.huawei.hms.location.ActivityIdentificationData
-dontwarn com.huawei.hms.location.ActivityIdentificationResponse
-dontwarn com.huawei.hms.location.ActivityIdentificationService
-dontwarn com.huawei.hms.location.FusedLocationProviderClient
-dontwarn com.huawei.hms.location.LocationCallback
-dontwarn com.huawei.hms.location.LocationRequest
-dontwarn com.huawei.hms.location.LocationServices
-dontwarn com.mappls.sdk.bleplugin.BleScanResultCallback
-dontwarn com.mappls.sdk.bleplugin.BluetoothLEScanHelper
-dontwarn com.mappls.sdk.bleplugin.ExternalSensor
-dontwarn com.ryanharter.auto.value.gson.GsonTypeAdapterFactory
