# Warehouse Pack Tracker

## Description 

I'm currently working for distributor of liquid admixture for concrete in 1000lt. packs,
some clients stack packs for months without sending it back, and it gets hard to trace
and monitor the exact count packs that went there. 

I wanted to make things better and
created a Java application with database where my colleagues can write pack's ID and
location when sending to keep track of each pack.


The app was tested and launched six months ago and since then is used daily. Some of
the advantages are: preventing duplicate records and human mistake factor, fast and
easy searching with specific criteria, separating duplicated records in different table,
export to Excel file with table form, keyboard shortcuts and more.

Developed to replace old techniques for tracking and monitoring warehouse activity, avoiding human mistake the app turns warehouse monitoring into an easy task.
## Table of Contents 

* [Installation](#installation)
* [Usage](#usage)


 

## Usage
* [UI](#userinterface)
* [Database](#database)
* [Export](#export)
* [Search](#searchfilter)
* [Functionallity](#functionallity)

## UserInterface
 Creating new records or Updating existing. 
![Main](https://user-images.githubusercontent.com/90547780/169278929-b6190aad-58f2-4b6a-8172-e744f6865edb.PNG)

![import](https://user-images.githubusercontent.com/90547780/169279981-70fd22f9-fd77-42e7-8e1e-5e379b012c53.PNG)
## Database
Database file and trace are created on first start after packing an installer in the installation directory folder,
easy tracking erors and activity by oppening the db.trace file.

![Capture](https://user-images.githubusercontent.com/90547780/169279311-4044d5e7-a31b-4d00-b39b-1a6da15a740f.PNG)

## Export
 Export to Xcel table with functionallity to export selected by search field records, ordered by columns or just all records.

![Export](https://user-images.githubusercontent.com/90547780/169279380-5b37a5fe-844e-446f-a805-9af00ee3c726.PNG)
## SearchFilter
When search filter is applied the excel export is only with the current table results, that by it self makes individual client monitoring easier.

![Filter](https://user-images.githubusercontent.com/90547780/169279606-042790d2-7eea-4a9e-8bd0-f603f499ea07.PNG)
## Functionallity
Recognising duplicated pack-numbers, handling exceptions and moving duplicated numbers to different database table.
Comments if some event happens to certain pack.

Duplicated packs are moved to special table where they wait to get assigned with new number. When the problem pack gets the new number it can be returned to the main table with all other packs.
 
 ![CommentsTable](https://user-images.githubusercontent.com/90547780/169280009-ffa5fdc6-90c7-44a2-92b9-4bafff30eec7.PNG)


## Installation 
* ### Change Database connection querry with your installation dirrectory
* ### [download](https://github.com/TeodorGjava/warehouse-simple/blob/main/NewTrackPack/Installer/FinalSetup.exe)
* ### Install setup and run.
