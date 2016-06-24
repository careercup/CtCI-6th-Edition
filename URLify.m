//
//  URLify.m
//  Ctci_Programming_Problems
//
//  Created by Baynham Makusha on 6/23/16.
//  Copyright © 2016 Ben Makusha. All rights reserved.
//

#import "URLify.h"

@implementation URLify

-(NSString*) replaceSpaces:(NSString *)str{
    str = [str stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceCharacterSet]];
    
    NSArray *comps = [str componentsSeparatedByCharactersInSet:[NSCharacterSet whitespaceCharacterSet]];
    comps = [comps filteredArrayUsingPredicate:[NSPredicate predicateWithFormat:@"self <> ''"]];
    
    str = [comps componentsJoinedByString:@"%20"];
    return str;
}


@end
