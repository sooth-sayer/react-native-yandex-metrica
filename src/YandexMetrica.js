import { YandexMetrica as YandexMetricaNative } from './NativeModule';

export class YandexMetrica {
  static activateWithApiKey(apiKey) {
    YandexMetricaNative.activateWithApiKey(apiKey);
  }

  static reportEvent(evt) {
    YandexMetricaNative.reportEvent(evt);
  }
}
