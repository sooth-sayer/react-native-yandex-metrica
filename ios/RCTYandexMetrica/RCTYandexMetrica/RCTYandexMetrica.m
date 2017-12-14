//
//  RCTYandexMetrica.m
//  RCTYandexMetrica
//
//  Created by Dmitry Chernyatiev on 14/12/2017.
//  Copyright © 2017 Dmitry Chernyatiev. All rights reserved.
//

#import "RCTYandexMetrica.h"
#import <React/RCTLog.h>
#import <React/RCTConvert.h>

@implementation RCTYandexMetrica {

}

RCT_EXPORT_MODULE();

RCT_EXPORT_METHOD(sendEvent:(NSString *)event)
{
  [YMMYandexMetrica reportEvent:event
    onFailure:^(NSError *error) {
          NSLog(@"DID FAIL REPORT EVENT: %@", event);
          NSLog(@"REPORT ERROR: %@", [error localizedDescription]);
  }];
}

@end
