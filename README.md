## Overview
This is a Java code quality training material.

This is a simple Master Data Management. You are a service provider to provide the service to validate data from clients and send statistic reports to state governments.

Application will process data with below requirements:

### Load, validate, and extract data from a TAB file to a Contact list

 TAB file header: id, first_name, last_name, date_of_birth, company_name, address, city, county, state, zip, phone1, phone2, email, web
 
 Contact properties: id, firstName, lastName, dateOfBirth, address, city, state, zipCode, mobilePhone, email
 
 Input file example:
 
```
id	first_name	last_name	company_name	date_of_birth	address	city	county	state	zip	phone1	phone2	email	website
1	James	Butt	Benton, John B Jr	01/06/1929	6649 N Blue Gum St	New Orleans	Orleans	LA	70116	504-621-8927	504-845-1427	jbutt@gmail.com	http://www.bentonjohnbjr.com
2	Josephine	Darakjy	Chanay, Jeffrey A Esq	02/01/1945	4 B Blue Ridge Blvd	Brighton	Livingston	MI	48116	810-292-9388	810-374-9840	josephine_darakjy@darakjy.org	http://www.chanayjeffreyaesq.com
3	Art	Venere	Chemel, James L Cpa	09/02/1960	8 W Cerritos Ave #54	Bridgeport	Gloucester	NJ	8014	856-636-8749	856-264-4130	art@venere	http://www.chemeljameslcpa.com
4	Lenna	Paprocki	Feltz Printing Service	08/01/1915	639 Main St	Anchorage	Anchorage	AK	99501	907-385-4412	907-921-2010	lpaprocki@hotmail.com	http://www.feltzprintingservice.com
5	Donette	Foller	Printing Dimensions	05/14/1950	34 Center St	Hamilton	Butler	OH	45011	513-570-1893	513-549-4561	donette.foller@cox.net	http://www.printingdimensions.com
```

### Validate Contact fields

 Validation rules: not empty, max length, pattern matching, valid reference

### Store ‘valid’ Contact to file system
 
 TAB file header: id, first_name, last_name, date_of_birth, address, city, state, zip_code, mobile_phone, email
 
 Order by zip_code
 
 Output file example:
 
```
id	first_name	last_name	day_of_birth	address	city	state	zip_code	mobile_phone	email
5	Donette	Foller	05/14/1950	34 Center St	Hamilton	OH	45011	513-570-1893	donette.foller@cox.net
2	Josephine	Darakjy	02/01/1945	4 B Blue Ridge Blvd	Brighton	MI	48116	810-292-9388	josephine_darakjy@darakjy.org
1	James	Butt	01/06/1929	6649 N Blue Gum St	New Orleans	LA	70116	504-621-8927	jbutt@gmail.com
4	Lenna	Paprocki	08/01/1915	639 Main St	Anchorage	AK	99501	907-385-4412	lpaprocki@hotmail.com		
```

### Report statistics

#### Contact per states
 TAB file header: state_code, number_of_contact
 
 Output file example:
 
```
state_code	number_of_contact
HI	3
TX	19
FL	20
NV	2
WA	3
NY	35
```

#### Contact per age groups of year 2016
 TAB file header: group, number_of_contact, percent_of_contact
 
 Output file example:
```
group	number_of_contact	percentage_of_contact
Middle age	50	15%
Senior	147	44%
Adolescent	23	6%
Adult	82	24%
Children	29	8%
```
Note: There is a bug that the total percentage of contact is not 100%. Please fix it.

Note: age groups
```
group	age
Children	<9
Adolescent	10-19
Adult	20-45
Middle age	46-60
Senior	>60
```
### Grading table
| Item |                              Definition                              | Grade | Note                         |
|------|----------------------------------------------------------------------|-------|------------------------------|
|    1 | Reading ‘Clean Code’ book (2 random questions)                       |    15 |                              |
|    2 | Applying KMS Java Coding Standards                                   |    10 |                              |
|    3 | Descriptive names, comments                                          |    10 |                              |
|    4 | Error handlings                                                      |    10 |                              |
|    5 | Unit-testing  (80% coverage)                                         |    20 |(-10 if there is no unit test)|
|    6 | Can fix the percentage bug                                           |    5  |                              |
|    7 | Applying OO Principles (SOLID, DRY…), Design Patterns                |    15 |                              |
|    8 | Java techniques (Reflection, Annotation, Java 8 Stream API, Lambda…) |    15 |                              |
|    9 | Performance Improvement (bonus)                                      |    10 |                              |
|      | Total Score                                                          |   110 |                              |
