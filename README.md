YandexMobileMetricaBridge
============
**Yandex Mobile Metrica Bridge** provides an interface to the native Yandex Mobile Metrica libraries on both **iOS** and **Android**.

## Installation and linking libraries

* Install with npm: `npm install --save react-native-yandex-metrica`
  Or, install with yarn: `yarn add react-native-yandex-metrica`

* Link with: `react-native link react-native-yandex-metrica`

## Usage
```javascript
import {
  YandexMetrica,
} from 'react-native-yandex-metrica';

// The yandex metrica must be activated
YandexMetrica.activateWithApiKey('app key');

// Event reporting
YandexMetrica.reportEvent('Hello from react-native');

// Disables reporting (must be called before activation)
YandexMetrica.setDryRun(true);
```
