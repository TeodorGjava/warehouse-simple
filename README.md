# App overview
Desktop warehouse-packs-tracking app with embedded h2 database.
  Developed to replace old techniques for tracking and monitoring warehouse activity, avoiding human mistake the app turns warehouse monitoring into an easy task.
# Functionality
<h3>Quick and easy embedded h2 database access.</h3>
Database file and trace are created on first start after packing an installer in the installation directory folder,
easy tracking erors and activity by oppening the db.trace file.
<h3>Export to Excell option.</h3>
Searching packs rented by specific client in different periods of time when making revision was very difficult and time consuming, the app using the search field filtering by criteria turned this into an easy task.
When search filter is applied the excel export is only with the current table results that by it self makes individual client monitoring easier.
<h3>Recognising duplicated pack-numbers, handling exceptions and moving duplicated numbers to different database table.</h3>
duplicated packs are moved to special table where they wait to get assigned with new number. When the problem pack gets the new number it can be returned to the main table with all other packs.
