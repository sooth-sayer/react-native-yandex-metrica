import { YandexMetricaBridge as YandexMetricaBridgeNative } from './NativeModule';

export class YandexMetrica {

  static activateWithApiKey(apiKey) {
    YandexMetricaBridgeNative.activateWithApiKey(apiKey);
  }

  static reportEvent(evt) {
    YandexMetricaBridgeNative.reportEvent(evt);
  }

  static setDryRun(enabled) {
    YandexMetricaBridgeNative.setDryRun(enabled);
  }

}
