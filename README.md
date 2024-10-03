[<img src="https://about.mappls.com/images/mappls-b-logo.svg" height="60"/> </p>](https://www.mapmyindia.com/api)

# Mappls Intouch Android SDK

Get Real-Time Location Tracking for your apps with Mappls InTouch SDK. Track a user's live location with our simplified InTouch SDK integration (for Android), highly customizable to your specific needs.

The InTouch SDK comes with a variety of events that enable better control and power over your tracking needs. Get ready made events to create,, Geo-Fences, Event Alerts, and Trails of telematics/ phone devices. Also get location benefits built for various applications including logistics, delivery tracking, employee tracking, and live location sharing.

To get started, explore the InTouch Demo App.

Already have an application? Give it a boost with the powerful features of InTouch. Learn how to [Integrate the InTouch SDK](#IntegrateIntouchSDK)

- [Setup](#Setup): Please contact apisupport@mappls.com to get the Intouch SDK authorisation for your Client ID and Client Secret.
- [Quick Start](https://github.com/mappls-api/mappls-intouch-android-sdk#intouchdemo-app): Start with a ready-to-go app
- [Integrate the SDK](#IntegrateIntouchSDK): Integrate the SDK into your app
- [Dashboard](./Dashboard.md): See all your devices' locations on Mappls InTouch Dashboard
- [InTouch Telematics APIs](./Dashboard.md): Use InTouch APIs to get the details of the devices.

## [Documentation History](#Documentation-History)

| Version | Supported SDK Version |
| ---- | ---- |
| [v1.0.2](docs/v1.0.2/README.md) | - Mappls Intouch SDK v1.4.0 |
| [v1.0.1](docs/v1.0.1/README.md) | - Mappls Intouch SDK v1.3.1 |
| [v1.0.0](docs/v1.0.0/README.md) | - Mappls Intouch SDK v1.2.2 |

For more details of previous documentation versions , [click here](docs/v1.0.2/Documentation-History.md).

## [Version History](#Version-History)

| Version | Last Updated | Author | Release Note|
| ---- | ---- | ---- | ---- |
| v1.4.0 | 01 October 2024| Mappls API Team ([MA](https://github.com/mdakram)) ([ST](https://github.com/saksham66)) | - Added Road Details Callback on Every location Change |
| v1.3.1 | 19 July 2024| Mappls API Team ([MA](https://github.com/mdakram)) ([ST](https://github.com/saksham66)) | - Bug Fixes|
| v1.3.0 | 14 June 2024| Mappls API Team ([MA](https://github.com/mdakram)) ([ST](https://github.com/saksham66)) | - Added Android 14 support <br/> - Added feature to open app on click of Notification <br/> - Significant Improvement|
| v1.2.2 | 13 September 2023 | Mappls API Team ([MA](https://github.com/mdakram)) ([DK](https://github.com/katariadeepak86)) | - Bug Fixes|
| v1.2.1 | 29 August 2023 | Mappls API Team ([MA](https://github.com/mdakram)) ([DK](https://github.com/katariadeepak86)) | - Bug Fixes|

For more details of previous versions , [click here](./Version-History.md).

## [Table Of Content](#Table-Of-Content)

- [InTouch Android SDK](docs/v1.0.2/GettingStarted.md)

* [Getting Started](docs/v1.0.2/GettingStarted.md#setup)

* [Add your API keys to the SDK](docs/v1.0.2/GettingStarted.md#step-2-set-your-publishable-key)

* [Add a Mappls InTouch Sdk to your application](docs/v1.0.2/GettingStarted.md#integrate-the-intouch-sdk)

- [Intouch Telematics API's](docs/v1.0.2/Dashboard.md)
    * [Device Details](docs/v1.0.2/DeviceDetails.md)
    * [Event's Data](docs/v1.0.2/Event-Data.md)
    * [Drive's Data](docs/v1.0.2/Drive-Data.md)
    * [GeoFences](docs/v1.0.2/Geofences.md)
    * [Alarms](docs/v1.0.2/Alarms.md)
    * [Trips](docs/v1.0.2/Trips.md)
- [Tracking Error](docs/v1.0.2/TrackingErrors.md)
- [Utility Methods](docs/v1.0.2/UtilityMethods.md)
- [InTouch Constants](docs/v1.0.2/InTouchConstants.md) 
- [MapmyIndia BLE Plugin](docs/v1.0.2/Mappls-BLE-Plugins.md)
- [Road Detail Event](docs/v1.0.2/Road-Event-Detail.md)
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

<div  align="center">@ Copyright 2022 CE Info Systems Ltd. All Rights Reserved.</div>

<div  align="center">  <a  href="https://about.mappls.com/api/terms-&-conditions">Terms & Conditions</a> | <a  href="https://about.mappls.com/about/privacy-policy">Privacy Policy</a> | <a  href="https://about.mappls.com/pdf/mapmyIndia-sustainability-policy-healt-labour-rules-supplir-sustainability.pdf">Supplier Sustainability Policy</a> | <a  href="https://about.mappls.com/pdf/Health-Safety-Management.pdf">Health & Safety Policy</a> | <a  href="https://about.mappls.com/pdf/Environment-Sustainability-Policy-CSR-Report.pdf">Environmental Policy & CSR Report</a>

<div  align="center">Customer Care: +91-9999333223</div>
