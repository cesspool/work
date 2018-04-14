#!/bin/bash

psql -Upostgres -c 'DROP DATABASE mylogistics'
psql -Upostgres -c 'DROP ROLE pavel'
psql -Upostgres -f ./createDB.sql
psql -Upavel -d mylogistics -f ./createTb.sql
