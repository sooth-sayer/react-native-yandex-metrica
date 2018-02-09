package com.soothsayer.YandexMetricaBridge;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.Promise;

import com.yandex.metrica.YandexMetrica;

import java.util.HashMap;
import java.util.Map;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class YandexMetricaBridge extends ReactContextBaseJavaModule {

  public static String TAG = "YandexMetricaBridge";

  public YandexMetricaBridge(ReactApplicationContext reactContext) {
    super(reactContext);
  }

  private boolean dryRun = false;
  private boolean initialized = false;
  private static boolean initializedStatic = false;

  @Override
  public String getName() {
    return TAG;
  }

  @ReactMethod
  public void activateWithApiKey(String apiKey) {
    initialized = true;
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
    try {
      YandexMetrica.reportEvent(event);
    } catch (Exception e) {
      Log.e(TAG, "Unable to report Yandex Mobile Metrica event: " + e);
    }
  }

  @ReactMethod
  public void setDryRun(Boolean enabled) {
    dryRun = enabled;
  }

  @ReactMethod
  public void isInitialized(Promise promise) {
    promise.resolve(initialized || initializedStatic);
  }

  public static void activate(Context context, String apiKey) {
    YandexMetrica.activate(context, apiKey);
    initializedStatic = true;
  }

  public static void enableActivityAutoTracking(final Application app) {
    YandexMetrica.enableActivityAutoTracking(app);
  }
}
