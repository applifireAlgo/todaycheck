




echo $PATH
DB_PATH=/tmp/applifire/db/XCUE2MXC3AD7APQYXIBQRG/61B95991-97C3-4D61-A0CD-9EE7DF872F51
MYSQL=/usr/bin
USER=salesdemo
PASSWORD=salesdemo
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'