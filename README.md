# App overview
Desktop warehouse-packs-tracking app with embedded h2 database.
  Developed to replace old techniques for tracking and monitoring warehouse activity, avoiding human mistake the app turns warehouse monitoring into an easy task.
![Main](https://user-images.githubusercontent.com/90547780/169278929-b6190aad-58f2-4b6a-8172-e744f6865edb.PNG)

![import](https://user-images.githubusercontent.com/90547780/169279981-70fd22f9-fd77-42e7-8e1e-5e379b012c53.PNG)

# Functionality
<h3>Quick and easy embedded h2 database access.</h3>
Database file and trace are created on first start after packing an installer in the installation directory folder,
easy tracking erors and activity by oppening the db.trace file.

![Capture](https://user-images.githubusercontent.com/90547780/169279311-4044d5e7-a31b-4d00-b39b-1a6da15a740f.PNG)

<h3>Export to Excell option.</h3>
Searching packs rented by specific client in different periods of time when making revision was very difficult and time consuming, the app using the search field filtering by criteria turned this into an easy task.

![Export](https://user-images.githubusercontent.com/90547780/169279380-5b37a5fe-844e-446f-a805-9af00ee3c726.PNG)

When search filter is applied the excel export is only with the current table results that by it self makes individual client monitoring easier.

![Filter](https://user-images.githubusercontent.com/90547780/169279606-042790d2-7eea-4a9e-8bd0-f603f499ea07.PNG)

<h3>Recognising duplicated pack-numbers, handling exceptions and moving duplicated numbers to different database table.
<h3>Comments if some event happens to certain pack.
 
 ![CommentsTable](https://user-images.githubusercontent.com/90547780/169280009-ffa5fdc6-90c7-44a2-92b9-4bafff30eec7.PNG)

duplicated packs are moved to special table where they wait to get assigned with new number. When the problem pack gets the new number it can be returned to the main table with all other packs.
