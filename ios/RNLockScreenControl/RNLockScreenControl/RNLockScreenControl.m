//
//  RNLockScreenControl.m
//  RNLockScreenControl
//
//  Created by Robert Stone on 1/7/18.
//  Copyright © 2018 Robert Stone. All rights reserved.
//

#import "RNLockScreenControl.h"
#import "UIKit/UIKit.h"

@implementation RNLockScreenControl

RCT_EXPORT_MODULE(LockScreenControl);

RCT_EXPORT_METHOD( preventLock )
{
    dispatch_async( dispatch_get_main_queue(), ^{
        [
            [UIApplication sharedApplication] setIdleTimerDisabled: true
        ];
    });
}

RCT_EXPORT_METHOD( allowLock )
{
    dispatch_async( dispatch_get_main_queue(), ^{
        [
            [UIApplication sharedApplication] setIdleTimerDisabled: false
        ];
    });
}

@end
