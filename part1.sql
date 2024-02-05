--create the suppliers table
CREATE TABLE SUPPLIERS (
    supplier_id INTEGER PRIMARY KEY,
    name VARCHAR(30) NOT NULL
);

--create the items table
CREATE TABLE ITEMS (
    item_id INTEGER PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    supplier_id INT,
    price DECIMAL(10, 2),
    status VARCHAR(15) NOT NULL CHECK (status IN ('in stock', 'out of stock')), --This will ensure that only two values are permitted
    -- This foreign key is to link each item to its supplier in the suppliers table
    FOREIGN KEY (supplier_id) REFERENCES suppliers(supplier_id)
    ON DELETE CASCADE
    -- Here we do CASCADE to delete all the items that no longer have a supplier
);

--create the customers table
CREATE TABLE CUSTOMERS (
    customer_id INTEGER PRIMARY KEY,
    fname varchar(15) NOT NULL,
    lname varchar(15) NOT NULL,
    preferred_product_id INTEGER,
    --This foreign key will map each customer's preferred product to the items table
    FOREIGN KEY (preferred_product_id) REFERENCES items(item_id) 
    ON DELETE SET NULL
    --if an items is deleted, then NULL will be set to the preferred product.
);



INSERT INTO suppliers (supplier_id, name) VALUES (1, 'Apple');
INSERT INTO suppliers (supplier_id, name) VALUES (2, 'Virgin');
INSERT INTO suppliers (supplier_id, name) VALUES (3, 'Carrefour');
INSERT INTO suppliers (supplier_id, name) VALUES (4, 'KU');
INSERT INTO suppliers (supplier_id, name) VALUES (5, 'Sharjah');

INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (1, 'Iphone', 1, 5999.99, 'in stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (2, 'Ipad', 1, 7000.99, 'in stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (3, 'Book1', 2, 9.99, 'in stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (4, 'Apples', 3, 2.99, 'in stock');
--KU will have 5 products that are all OUT OF STOCK
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (5, 'Research CS', 4, 99999.99, 'out of stock'); 
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (6, 'Research BMED', 4, 99999.99, 'out of stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (7, 'Researchs CMPE', 4, 99999.99, 'out of stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (8, 'Research AERO', 4, 99999.99, 'out of stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (9, 'Research MECH', 4, 10000000, 'out of stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (10, 'Cheese', 5, 8.99, 'out of stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (11, 'Airpods', 1, 500, 'in stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (12, 'Ipad case', 1, 99, 'in stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (13, 'Macbook', 1, 9999, 'in stock');
INSERT INTO items (item_id, name, supplier_id, price, status) VALUES (14, 'ipod', 1, 400, 'in stock');
--Apple now has 6 products that are in stock (for bonus task testing)

INSERT INTO customers (customer_id, fname, lname, preferred_product_id) VALUES (1, 'Ahmed', 'Mohamed', 1);
INSERT INTO customers (customer_id, fname, lname, preferred_product_id) VALUES (2, 'Rashed', 'Nasser', 2);
INSERT INTO customers (customer_id, fname, lname, preferred_product_id) VALUES (3, 'Saqer', 'Alkindi', 10);
INSERT INTO customers (customer_id, fname, lname, preferred_product_id) VALUES (4, 'Jaber', 'Salem', 12);
INSERT INTO customers (customer_id, fname, lname, preferred_product_id) VALUES (5, 'Khalid', 'Saeed', 4);


SELECT name
FROM items
WHERE supplier_id = 1; --asume X is 1

SELECT fname, lname
FROM customers, items
WHERE status = 'out of stock' AND preferred_product_id = item_id;

SELECT item_id, name 
FROM items
where price IN (select max(price) 
                 FROM items);


SELECT s.supplier_id, s.name, COUNT(i.item_id) 
FROM SUPPLIERS s, ITEMS i
WHERE i.status = 'in stock' AND s.supplier_id = I.supplier_id
GROUP BY s.name, s.supplier_id
HAVING COUNT(i.item_id) > 5
ORDER BY COUNT(i.item_id) DESC;


