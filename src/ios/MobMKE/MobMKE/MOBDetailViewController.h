//
//  MOBDetailViewController.h
//  MobMKE
//
//  Created by Curtis Allen Gibeaut Jr on 8/27/12.
//  Copyright (c) 2012 Curtis Allen Gibeaut Jr. All rights reserved.
//

#import <UIKit/UIKit.h>

@interface MOBDetailViewController : UIViewController <UISplitViewControllerDelegate>

@property (strong, nonatomic) id detailItem;

@property (weak, nonatomic) IBOutlet UILabel *titleLabel;
@property (weak, nonatomic) IBOutlet UILabel *startLabel;
@property (weak, nonatomic) IBOutlet UILabel *endLabel;
@property (weak, nonatomic) IBOutlet UILabel *locationLabel;
@property (weak, nonatomic) IBOutlet UILabel *speakerLabel;
@end
