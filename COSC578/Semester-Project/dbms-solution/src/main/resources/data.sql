/*
 * INITIAL DATABASE DATA
 *
 * @author Emmanuel Taylor
 * @author Kwaku Addow
 * @author So Ra Jang
 * @author Leonard Tangban
 * @author Keith Maina
 *
 * @description
 *    This .sql file represents the initial load of data into the database.
 */

INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Keith', 'Maina', 'Administrator', 'kmaina@jjprime.com', 130000, 'kmaina', 'demo1');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Kwaku', 'Addow', 'Program Manager', 'kaddow@jjprime.com', 100000, 'kaddow', 'demo2');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('So Ra', 'Jang', 'Accountant', 'sjang@jjprime.com', 100000, 'sjang', 'demo3');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Georgia', 'Robertson', 'Program Manager', 'grobertson@jjprime.com', 89000, 'grobertson', '`S6o7W4W=-[0');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Syed', 'Wells', 'Accountant', 'swells@jjprime.com', 79000, 'swells', '[827LH?ax,Nr');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Jade', 'Blevins', 'Program Manager', 'jblevins@jjprime.com', 97000, 'jblevins', '_55`RoeCu=t4');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Margaret', 'Love', 'Accountant', 'mlove@jjprime.com', 85000, 'mlove', '5G3Bg54`M!J6');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Robyn', 'Allen', 'Accountant', 'rallen@jjprime.com', 87000, 'rallen', 'u3vGf28YAon&');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Maisie', 'Wade', 'Accountant', 'mwade@jjprime.com', 77000, 'mwade', 'q#96&36x5NOe');
INSERT INTO employee (first_name, last_name, role, email_address, salary, username, password) VALUES ('Jannat', 'Lucero', 'Program Manager', 'jlucero@jjprime.com', 110000, 'jlucero', 'PIyiz<O_2<02');

INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Hoses & Fitting', '2018-07-11', 'Purchase', 544.18, 5);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Demolishing existing concrete and asphalt', '2018-11-04', 'Invoice', 1497.35, 3);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Emergency Trash Removal and Monitoring', '2023-05-11', 'Invoice', 1014.10, 5);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Pallet, Concrete & Glass', '2018-07-12', 'Purchase', 319.38, 7);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Modifications for Bldg 35 Pepco Benning', '2023-06-03', 'Invoice', 5576.89, 8);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Expansion Joints', '2018-07-11', 'Purchase', 48.00, 9);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Shovels, Wire Brush & Picks', '2018-07-12', 'Purchase', 77.59, 8);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Haul Off Other Spoils', '2023-04-28', 'Invoice', 1124.25, 3);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Temporary Access Road', '2023-06-14', 'Invoice', 11502.29, 7);
INSERT INTO financial_data (description, date, category, amount, employee_id) VALUES ('Concrete Mix #136', '2018-07-11', 'Purchase', 1837.00, 9);

INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Emergency Assistance Montgomery', '2023-07-14', 'Pepco MD', 10176, '2023-07-28', 32, 2);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Crane Pad', '2023-07-14', 'Aiton', 10175, '2023-07-28', 21, 2);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Manhole 5A', '2023-06-01', 'Purple Line', 10174, '2023-07-17', 15, 1);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Modifications for Bldg 35 Pepco Benning', '2023-06-03', 'Pepco 35 & 65', 10173, '2023-07-17', 30, 10);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Split Laterals for Manchester 9-11 & 13-15', '2023-06-06', 'Purple Line', 10172, '2023-07-17', 40, 6);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Tree Removal and Clearing', '2023-05-15', 'Aiton', 10171, '2023-06-20', 15, 2);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Flowable Fill', '2023-06-28', 'MLK Phase II', 10170, '2023-07-05', 13, 6);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Temporary Access Road', '2023-06-14', 'Aiton', 10169, '2023-07-07', 24, 4);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Emergency Trash Removal and Monitoring', '2023-05-11', 'Pepco 35 & 36', 10168, '2023-06-26', 5, 10);
INSERT INTO change_order_log (description, date, job_name, job_id, change_date, days_added, employee_id) VALUES ('Haul Off Other Spoils', '2023-04-28', 'Stead Park', 10167, '2023-06-19', 3, 1);

INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Dailys Report', '2018-07-11', 'Office', 10000, 'Lucero', 274.54, 'Mass Press Imaging', 10);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Hoses & Fittings', '2018-07-11', 'DOC Sewer Line', 10001, 'Lucero', 544.18, 'Xylem', 10);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Expansion Joints', '2018-07-11', 'Pappas', 12100, 'Blevins', 48.00, 'HD Supply', 6);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Concrete Mix #136', '2018-07-11', 'Pappas', 10003, 'Cherry', 1837.00, 'Chaney', 1);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Pallet & Concrete', '2018-07-11', 'Bruce Monroe', 10003, 'Gonzalez', 281.85, 'Greenwald', 2);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Hitch-Irvin Truck', '2018-07-11', 'Office', 10072, 'Robertson', 71.90, 'Home Depot', 4);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Broom & Gloves', '2018-07-11', 'Pappas', 10890, 'Cherry', 81.00, 'Greenwald', 1);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Shovels, Wire Brush & Picks', '2018-07-12', '1151 Bladensburg', 10007, 'Lucero', 77.59, 'Greenwald', 10);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('Pallet, Concrete & Glasses', '2018-07-16', 'Pappas', 10003, 'Cherry', 319.38, 'Greenwald', 1);
INSERT INTO purchase_order_log (description, date, job_name, job_id, purchaser, cost, vendor, employee_id) VALUES ('57 Double Wash', '2018-07-17', 'Pappas', 10890, 'Gonzalez', 640.00, 'Vulcan', 2);

INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Prevents leaking of fluids and gas', '2023-04-11', 'Office', 10072, 'O-Ring', 42, 'HR Parts', 1);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Transmits power between driving wheels', '2022-04-16', 'DOC Sewer Line', 10001, 'Rear Axle', 2, 'John Deere', 2);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Translates transmission at the wheels', '2016-06-25', 'Pappas', 12100, 'Clutch Disc', 15, 'John Deere', 3);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Filters the air in a single room or area', '2023-07-22', 'Pappas', 10003, 'Air Cleaner', 7, 'Link-Belt', 4);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Fastens steel to steel, wood to wood', '2017-12-21', 'Bruce Monroe', 10003, 'Hex Bolt', 142, 'Home Depot', 5);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Fastens pieces of lumber together', '2017-12-21', 'Bruce Monroe', 10003, 'Lag Bolt', 113, 'Home Depot', 6);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Delivers strong, rotating force', '2023-04-11', '1151 Bladensburg', 10007, 'Impact Driver', 2, 'DeWalt', 7);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Plumbing, sewage and drainage', '2022-07-13', 'DOC Sewer Line', 10001, 'PVC Pipe', 32, 'Lowes', 8);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Drives screws into wood/metal', '2023-04-11', '1151 Bladensburg', 10007, 'Power Drill', 4, 'DeWalt', 9);
INSERT INTO inventory_log (description, date, job_name, job_id, part_name, quantity, vendor, employee_id) VALUES ('Secures drywall to metal/wood studs', '2019-05-23', 'Office', 10072, 'Drywall Screw', 242, 'Fas-n-Tite', 10);