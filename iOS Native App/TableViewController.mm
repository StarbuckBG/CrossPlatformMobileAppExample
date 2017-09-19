//
//  TableViewController.m
//  ProgrammingLanguages
//
//  Created by Martin Kuvandzhiev on 9/15/17.
//  Copyright © 2017 Rapid Development Crew. All rights reserved.
//

#import "TableViewController.h"
#import "DataProvider.h"
#import "DetailsTableViewController.h"

@interface TableViewController ()

@property DataProvider * dataProvider;
@end

@implementation TableViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    
    self.dataProvider = [[DataProvider alloc] init];
    [self.tableView reloadData];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

#pragma mark - Table view data source

- (NSInteger)numberOfSectionsInTableView:(UITableView *)tableView {
    return 1;
}

- (NSInteger)tableView:(UITableView *)tableView numberOfRowsInSection:(NSInteger)section {
    return self.dataProvider.objects.size();
}


- (UITableViewCell *)tableView:(UITableView *)tableView cellForRowAtIndexPath:(NSIndexPath *)indexPath {
    UITableViewCell *cell = [tableView dequeueReusableCellWithIdentifier:@"cell" forIndexPath:indexPath];
    
    Person * object = self.dataProvider.objects.at(indexPath.row);
    cell.textLabel.text = [NSString stringWithFormat:@"%s", object->name.c_str()];
    cell.detailTextLabel.text = [NSString stringWithFormat:@"Age: %d", object->age];
    
    return cell;
}

-(void) tableView:(UITableView *)tableView didSelectRowAtIndexPath:(NSIndexPath *)indexPath {
    NSMutableDictionary * data = [[NSMutableDictionary alloc] init];
    Person * object = self.dataProvider.objects.at(indexPath.row);
    
    for (auto const& item: object->dictionaryData()) {
        NSString * key = [NSString stringWithFormat:@"%s", item.first.c_str()];
        NSString * value = [NSString stringWithFormat:@"%s", item.second.c_str()];
        data[key] = value;
    }
    
    DetailsTableViewController * descriptionController = [[UIStoryboard storyboardWithName:@"Main" bundle:nil] instantiateViewControllerWithIdentifier:@"DetailsTableViewController"];
    descriptionController.dataDict = [NSDictionary dictionaryWithDictionary:data];
    [self.navigationController pushViewController:descriptionController animated:true];
}


@end
