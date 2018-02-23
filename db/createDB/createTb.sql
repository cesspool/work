\connect mylogistics;
CREATE SCHEMA logistics;
CREATE TABLE logistics.boxing(
id SERIAL PRIMARY KEY,
variety varchar(80),
cost real
);

CREATE TABLE logistics.type_node(
id SERIAL PRIMARY KEY,
variety varchar(50)
);

CREATE TABLE logistics.transport(
id SERIAL PRIMARY KEY,
variety varchar(50),
avSpeed real,
costKm real,
maxHeight real,
maxWidth real,
maxLength real,
totalWeight real,
totalCapacity real
);

CREATE TABLE logistics.package(
id SERIAL PRIMARY KEY,
name varchar(50),
envelop boolean,
height real,
width real,
length real,
weight real,
quantity integer,
size real
);

CREATE TABLE logistics.customer(
id SERIAL PRIMARY KEY,
firstName varchar(40),
lastName varchar(40),
patronymic varchar(40),
address varchar(100),
telephone varchar(15),
md5 CHAR(32),
admin boolean
);

CREATE TABLE logistics.node(
id SERIAL PRIMARY KEY,
name varchar(50),
address varchar(100),
coordinateX real, 
coordinateY real,
type_node_id integer REFERENCES logistics.type_node(id)
);

CREATE TABLE logistics.rate(
id SERIAL PRIMARY KEY,
name varchar(40), 
costShipping real,
startActionDate date,
endActionDate date,
transport_id integer REFERENCES logistics.transport(id)
);

CREATE TABLE logistics.order(
id SERIAL PRIMARY KEY,
name integer,
urgency boolean,
customer_id integer REFERENCES logistics.customer (id),
node_id_start integer REFERENCES logistics.node (id),
node_id_end integer REFERENCES logistics.node (id),
rate_id integer REFERENCES logistics.rate (id),
package_id integer REFERENCES logistics.package (id),
boxing_id integer REFERENCES logistics.boxing (id)
);

CREATE TABLE logistics.distance(
id SERIAL PRIMARY KEY,
length real,
transport_id integer REFERENCES logistics.transport(id),
node_id_start integer REFERENCES logistics.node (id),
node_id_end integer REFERENCES logistics.node (id)
);

CREATE TABLE logistics.order_distance(
id SERIAL PRIMARY KEY,
number integer,
distance_id integer REFERENCES logistics.distance(id),
order_id integer REFERENCES logistics.order(id)
);

CREATE TABLE logistics.order_customer(
id SERIAL PRIMARY KEY,
customer_id integer REFERENCES logistics.customer(id),
order_id integer REFERENCES logistics.order(id)
);
