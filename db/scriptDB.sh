#! /bin/bash
#echo Connecting to user posgres
BASE_DIR=/home/paul/Documents/scripts
echo start scipt
export PGPASSWORD=postgres
psql -Upostgres -f $BASE_DIR/createDB.sql
echo "PASS1: $PGPASSWORD"
export PGPASSWORD=pavel
echo "PASS2: $PGPASSWORD"
echo reading files
for file in $BASE_DIR/dbscripts/*; do
	psql -Upavel -dmylogistics -f "$file"
done
echo complete
