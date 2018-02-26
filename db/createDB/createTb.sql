\connect mylogistics;
CREATE SCHEMA logistics;
CREATE TABLE logistics.boxing(
id SERIAL PRIMARY KEY NOT NULL,
variety varchar(80),
cost real
);

CREATE TABLE logistics.transport(
id SERIAL PRIMARY KEY NOT NULL,
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
id SERIAL PRIMARY KEY NOT NULL,
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
id SERIAL PRIMARY KEY NOT NULL,
firstName varchar(40),
lastName varchar(40),
patronymic varchar(40),
address varchar(100),
telephone varchar(15),
email VARCHAR(50),
hashcode CHAR(32),
admin boolean
);

CREATE TABLE logistics.node(
id SERIAL PRIMARY KEY NOT NULL,
name varchar(50),
address varchar(100),
coordinateX real, 
coordinateY real,
code VARCHAR(20)
);

CREATE TABLE logistics.rate(
id SERIAL PRIMARY KEY NOT NULL,
name varchar(40), 
costShipping real,
additionalCost real,
startActionDate date,
endActionDate date,
transport_id integer REFERENCES logistics.transport(id)
);

CREATE TABLE logistics.order(
id SERIAL PRIMARY KEY NOT NULL,
name integer,
urgency boolean,
recipient_id integer REFERENCES logistics.customer (id),
sender_id integer REFERENCES logistics.customer (id),
rate_id integer REFERENCES logistics.rate (id),
package_id integer REFERENCES logistics.package (id),
boxing_id integer REFERENCES logistics.boxing (id)
);

CREATE TABLE logistics.distance(
id SERIAL PRIMARY KEY NOT NULL,
length real,
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