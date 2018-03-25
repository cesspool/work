\connect mylogistics;
CREATE SCHEMA logistics;
CREATE TABLE logistics.boxing(
id SERIAL PRIMARY KEY NOT NULL,
variety varchar(50) NOT NULL,
cost real
);

CREATE TABLE logistics.transport(
id SERIAL PRIMARY KEY NOT NULL,
variety varchar(50) NOT NULL,
avSpeed real NOT NULL,
costKm real NOT NULL,
maxHeight real NOT NULL,
maxWidth real NOT NULL,
maxLength real NOT NULL,
totalWeight real NOT NULL,
totalCapacity real NOT NULL
);

CREATE TABLE logistics.package(
id SERIAL PRIMARY KEY NOT NULL,
name varchar(50) NOT NULL,
envelop boolean,
height real,
width real,
length real,
weight real,
quantity integer NOT NULL,
size real
);

CREATE TABLE logistics.customer(
id SERIAL PRIMARY KEY NOT NULL,
firstName varchar(40) NOT NULL,
lastName varchar(40) NOT NULL,
patronymic varchar(40) NOT NULL,
address varchar(100) NOT NULL,
telephone varchar(20) NOT NULL,
email VARCHAR(50) NOT NULL,
hashcode CHAR(32) NOT NULL,
admin boolean,
manager boolean
);

CREATE TABLE logistics.node(
id SERIAL PRIMARY KEY NOT NULL,
name varchar(50) NOT NULL,
city VARCHAR(50) NOT NULL,
address varchar(100) NOT NULL,
coordinateX real NOT NULL,
coordinateY real NOT NULL,
code VARCHAR(20) NOT NULL
);

CREATE TABLE logistics.rate(
id SERIAL PRIMARY KEY NOT NULL,
name varchar(50) NOT NULL,
costShipping real NOT NULL,
additionalCost real,
startActionDate date NOT NULL,
endActionDate date NOT NULL,
transport_id INTEGER REFERENCES logistics.transport(id)
);

CREATE TABLE logistics.order(
id SERIAL PRIMARY KEY NOT NULL,
name integer NOT NULL,
urgency boolean,
ready BOOLEAN,
recipient_id integer REFERENCES logistics.customer (id),
sender_id integer REFERENCES logistics.customer (id),
rate_id INTEGER REFERENCES logistics.rate (id),
package_id integer REFERENCES logistics.package (id),
boxing_id INTEGER REFERENCES logistics.boxing (id)
);

CREATE TABLE logistics.distance(
id SERIAL PRIMARY KEY NOT NULL,
length real NOT NULL,
node_id_start integer REFERENCES logistics.node (id),
node_id_end integer REFERENCES logistics.node (id)
);

CREATE TABLE logistics.transport_node(
  node_id integer REFERENCES logistics.node(id),
  transport_id INTEGER REFERENCES logistics.transport(id)
);

CREATE TABLE logistics.route(
  order_id INTEGER REFERENCES logistics.order(id),
  node_id INTEGER REFERENCES logistics.node(id),
  number_node INTEGER,
  PRIMARY KEY(order_id, number_node)
);