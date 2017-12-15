//
//  RCTYandexMetrica.m
//  RCTYandexMetrica
//
//  Created by Dmitry Chernyatiev on 14/12/2017.
//  Copyright © 2017 Dmitry Chernyatiev. All rights reserved.
//

#import "RCTYandexMetricaBridge.h"
#import <React/RCTLog.h>
#import <React/RCTConvert.h>
#import "YandexMobileMetrica.h"

@implementation RCTYandexMetricaBridge {

}

BOOL dryRun = false;

RCT_EXPORT_MODULE();
RCT_EXPORT_METHOD(activateWithApiKey:(NSString *)apiKey)
{
  if (dryRun) {
    NSLog(@"Dry run mode, skip Yandex Mobile Metrica activation");
    return;
  }
  [YMMYandexMetrica activateWithApiKey:apiKey];
}

RCT_EXPORT_METHOD(reportEvent:(NSString *)event)
{
  if (dryRun) {
    NSLog(@"Dry run mode, skip event reporting");
    return;
  }
  [YMMYandexMetrica reportEvent:event
                      onFailure:^(NSError *error) {
  NSLog(@"DID FAIL REPORT EVENT: %@", event);
  NSLog(@"REPORT ERROR: %@", [error localizedDescription]);
                      }];
}

RCT_EXPORT_METHOD(setDryRun:(BOOL *)enabled)
{
  dryRun = enabled;
}

@end
