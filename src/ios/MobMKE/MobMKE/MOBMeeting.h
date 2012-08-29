//
//  MOBMeeting.h
//  MobMKE
//
//  Created by Curtis Allen Gibeaut Jr on 8/28/12.
//  Copyright (c) 2012 Curtis Allen Gibeaut Jr. All rights reserved.
//

#import <Foundation/Foundation.h>

@interface MOBMeeting : NSObject
@property (weak, nonatomic) NSString *title;
@property (weak, nonatomic) NSString *location;
@property (weak, nonatomic) NSString *speaker;
@property (weak, nonatomic) NSDate *startDate;
@property (weak, nonatomic) NSDate *endDate;


@end
