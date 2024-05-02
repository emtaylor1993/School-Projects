CREATE TABLE CUSTOMER
(
    customer_id INTEGER     NOT NULL,
    phone       VARCHAR(25) NOT NULL,
    email       VARCHAR(25) NOT NULL,
    address     VARCHAR(25) NOT NULL,
    name        VARCHAR(25) NOT NULL,
    PRIMARY KEY (customer_id)
);

CREATE TABLE CATEGORY
(
    category_id     INTEGER     NOT NULL,
    category_name   VARCHAR(25) NOT NULL,
    PRIMARY KEY (category_id)
);

CREATE TABLE PRODUCT
(
    product_id      INTEGER     NOT NULL,
    name            VARCHAR(25) NOT NULL,
    price           DECIMAL     NOT NULL,
    stock_quantity  INTEGER     NOT NULL,
    category_id     INTEGER     NOT NULL,
    PRIMARY KEY (product_id),
    FOREIGN KEY (category_id) REFERENCES CATEGORY (category_id)
)

CREATE TABLE ORDERS
(
    order_id        INTEGER     NOT NULL,
    date            VARCHAR(25) NOT NULL,
    total_amount    DECIMAL     NOT NULL,
    status          VARCHAR(25) NOT NULL,
    customer_id     INTEGER     NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER (customer_id)
);

CREATE TABLE ORDER_DETAILS
(
    order_id    INTEGER     NOT NULL,
    quantity    INTEGER     NOT NULL,
    price       DECIMAL     NOT NULL,
    product_id  INTEGER     NOT NULL,
    PRIMARY KEY (order_id, product_id),
    FOREIGN KEY (order_id) REFERENCES ORDERS (order_id),
    FOREIGN KEY (product_id) REFERENCES PRODUCT (product_id)
);

CREATE TABLE SUPPLIER
(
    supplier_id         INTEGER     NOT NULL,
    name                VARCHAR(25) NOT NULL,
    contact_information VARCHAR(25) NOT NULL,
    products            VARCHAR(25) NOT NULL,
    PRIMARY KEY (supplier_id)
);

CREATE TABLE SHIPMENT
(
    shipment_id     INTEGER     NOT NULL,
    shipment_date   VARCHAR(25) NOT NULL,
    delivery_date   VARCHAR(25) NOT NULL,
    order_id        INTEGER     NOT NULL,
    supplier_id     INTEGER     NOT NULL,
    PRIMARY KEY (shipment_id),
    FOREIGN KEY (order_id) REFERENCES ORDERS (order_id),
    FOREIGN KEY (supplier_id) REFERENCES SUPPLIER (supplier_id)
);

ALTER TABLE PRODUCT ADD CONSTRAINT PRODUCT_category_id FOREIGN KEY (category_id) REFERENCES CATEGORY (category_id);
ALTER TABLE ORDERS ADD CONSTRAINT ORDERS_customer_id FOREIGN KEY (customer_id) REFERENCES CUSTOMER (customer_id);
ALTER TABLE ORDER_DETAILS ADD CONSTRAINT ORDER_DETAILS_order_id FOREIGN KEY (order_id) REFERENCES ORDERS (order_id);
ALTER TABLE ORDER_DETAILS ADD CONSTRAINT ORDER_DETAILS_product_id FOREIGN KEY (product_id) REFERENCES PRODUCT (product_id);
ALTER TABLE SHIPMENT ADD CONSTRAINT SHIPMENT_order_id FOREIGN KEY (order_id) REFERENCES ORDERS (order_id);
ALTER TABLE SHIPMENT ADD CONSTRAINT SHIPMENT_supplier_id FOREIGN KEY (supplier_id) REFERENCES SUPPLIER (supplier_id);

INSERT INTO CUSTOMER VALUES (101, '123-456-7890', 'alice.brown@email.com', '123 Oak Street', 'Alice Brown');
INSERT INTO CUSTOMER VALUES (102, '234-567-8901', 'bob.smith@email.com', '456 Maple Avenue', 'Bob Smith');
INSERT INTO CUSTOMER VALUES (103, '345-678-9012', 'carol.johnson@email.com', '789 Pine Road', 'Carol Johnson');

INSERT INTO CATEGORY VALUES (1, 'Fruits');
INSERT INTO CATEGORY VALUES (2, 'Dairy');
INSERT INTO CATEGORY VALUES (3, 'Meats');
INSERT INTO CATEGORY VALUES (4, 'Beverages');

INSERT INTO PRODUCT VALUES (501, 'Apple', 0.50, 100, 1);
INSERT INTO PRODUCT VALUES (502, 'Milk', 3.00, 50, 2);
INSERT INTO PRODUCT VALUES (503, 'Chicken Breast', 5.00, 75, 3);

INSERT INTO ORDERS VALUES (201, '2023-12-01', 15.50, 'Shipped', 101);
INSERT INTO ORDERS VALUES (202, '2023-12-02', 5.00, 'Pending', 102);

INSERT INTO ORDER_DETAILS VALUES (201, 3, 15.00, 503);
INSERT INTO ORDER_DETAILS VALUES (201, 2, 2.00, 501);
INSERT INTO ORDER_DETAILS VALUES(202, 1, 5.00, 503);

-- Write an SQL query to update the stock quantity of 'Milk' by reducing it by 10 units.
UPDATE PRODUCT
SET stock_quantity = stock_quantity - 10
WHERE name = 'Milk';

-- Write an SQL query to delete the customer 'Bob Smith' from the database.
DELETE FROM CUSTOMER WHERE name = 'Bob Smith';
SELECT * FROM CUSTOMER;

-- Write an SQL query to find the total revenue generated from each product category.
SELECT c.category_name, SUM(od.price) AS total_revenue
FROM ORDER_DETAILS od 
INNER JOIN PRODUCT p ON od.product_id = p.product_id
INNER JOIN CATEGORY c on p.category_id = c.category_id
GROUP BY c.category_name

-- Write an SQL query to list customers who have placed more than 3 orders.
SELECT c.name
FROM CUSTOMER c INNER JOIN ORDERS o on c.customer_id = o.customer_id
GROUP BY c.name
HAVING COUNT(c.customer_id) > 3;

-- Write an SQL query to display products that have never been ordered.
SELECT name FROM PRODUCT
WHERE name NOT IN (
    SELECT p.name 
    FROM PRODUCT p INNER JOIN ORDER_DETAILS od ON p.product_id = od.product_id
)

