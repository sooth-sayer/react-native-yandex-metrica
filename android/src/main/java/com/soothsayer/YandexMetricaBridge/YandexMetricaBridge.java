package com.soothsayer.YandexMetricaBridge;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;

import com.yandex.metrica.YandexMetrica;

import java.util.HashMap;
import java.util.Map;
import android.util.Log;

public class YandexMetricaBridge extends ReactContextBaseJavaModule {

  public static String TAG = "YandexMetricaBridge";

  public YandexMetricaBridge(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  private boolean dryRun = false;

  @Override
  public String getName() {
    return TAG;
  }

  @ReactMethod
  public void activateWithApiKey(String apiKey) {
    if (dryRun) {
      Log.i(TAG, "Dry run mode, skip Yandex Mobile Metrica activation");
      return;
    }

    YandexMetrica.activate(getReactApplicationContext(), apiKey);
  }

  @ReactMethod
  public void reportEvent(String event) {
    if (dryRun) {
      Log.i(TAG, "Dry run mode, skip event reporting");
      return;
    }
    YandexMetrica.reportEvent(event);
  }

  @ReactMethod
  public void setDryRun(Boolean enabled) {
    dryRun = enabled;
  }

}
