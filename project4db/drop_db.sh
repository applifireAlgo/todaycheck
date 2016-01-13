




echo $PATH
DB_PATH=/tmp/applifire/db/LAFWNT36NYJX0R1A8SKAW/70A5025B-4378-4B2D-A669-6D5558727836
MYSQL=/usr/bin
USER=project4
PASSWORD=project4
HOST=localhost


echo 'drop db starts....'
$MYSQL/mysql -h$HOST -u$USER -p$PASSWORD -e "SOURCE $DB_PATH/drop_db.sql";
echo 'drop db ends....'