CREATE TABLE J
(
    j_num VARCHAR(10) NOT NULL,
    j_name VARCHAR(20) NOT NULL,
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (j_num)
);

CREATE TABLE P
(
    p_num VARCHAR(10) NOT NULL,
    pname VARCHAR(10) NOT NULL,
    color VARCHAR(10) NOT NULL,
    weight INTEGER NOT NULL,
    city VARCHAR(10) NOT NULL,
    PRIMARY KEY (p_num)
);

CREATE TABLE S
(
    s_num VARCHAR(10) NOT NULL,
    s_name VARCHAR(10) NOT NULL,
    status INTEGER NOT NULL,
    city VARCHAR(10) NOT NULL,
    PRIMARY KEY (s_num)
);

CREATE TABLE SPJ
(
    s_num VARCHAR(10) NOT NULL,
    p_num VARCHAR(10) NOT NULL,
    j_num VARCHAR(10) NOT NULL,
    qty INTEGER NOT NULL,
    PRIMARY KEY (s_num, p_num, j_num),
    FOREIGN KEY (s_num) REFERENCES S (s_num),
    FOREIGN KEY (p_num) REFERENCES P (p_num),
    FOREIGN KEY (j_num) REFERENCES J (j_num)
);

INSERT INTO J VALUES ('J1', 'Sorter', 'Paris');
INSERT INTO J VALUES ('J2', 'Punch', 'Rome');
INSERT INTO J VALUES ('J3', 'Reader', 'Athens');
INSERT INTO J VALUES ('J4', 'Console', 'Athens');
INSERT INTO J VALUES ('J5', 'Collator', 'London');
INSERT INTO J VALUES ('J6', 'Terminal', 'Oslo');
INSERT INTO J VALUES ('J7', 'Tape', 'London');

INSERT INTO P VALUES ('p1', 'Nut', 'Red', 12, 'London');
INSERT INTO P VALUES ('p2', 'Bolt', 'Green', 17, 'Paris');
INSERT INTO P VALUES ('p3', 'Screw', 'Blue', 17, 'Rome');
INSERT INTO P VALUES ('p4', 'Screw', 'Red', 14, 'London');
INSERT INTO P VALUES ('p5', 'Cam', 'Blue', 12, 'Paris');
INSERT INTO P VALUES ('p6', 'Cog', 'Red', 19, 'London');

INSERT INTO S VALUES ('s1', 'Smith', 20, 'London');
INSERT INTO S VALUES ('s2', 'Jones', 10, 'Paris');
INSERT INTO S VALUES ('s3', 'Blake', 30, 'Paris');
INSERT INTO S VALUES ('s4', 'Clark', 20, 'London');
INSERT INTO S VALUES ('s5', 'Adams', 30, 'Athens');

INSERT INTO SPJ VALUES ('s1', 'p1', 'j1', 200);
INSERT INTO SPJ VALUES ('s1', 'p1', 'j4', 700);
INSERT INTO SPJ VALUES ('s2', 'p3', 'j1', 400);
INSERT INTO SPJ VALUES ('s2', 'p3', 'j2', 200);
INSERT INTO SPJ VALUES ('s2', 'p3', 'j3', 200);
INSERT INTO SPJ VALUES ('s2', 'p3', 'j4', 500);
INSERT INTO SPJ VALUES ('s2', 'p3', 'j5', 600);
INSERT INTO SPJ VALUES ('s2', 'p3', 'j6', 400);
INSERT INTO SPJ VALUES ('s2', 'p3', 'j7', 800);
INSERT INTO SPJ VALUES ('s2', 'p5', 'j2', 100);
INSERT INTO SPJ VALUES ('s3', 'p3', 'j1', 200);
INSERT INTO SPJ VALUES ('s3', 'p4', 'j2', 500);
INSERT INTO SPJ VALUES ('s4', 'p6', 'j3', 300);
INSERT INTO SPJ VALUES ('s4', 'p6', 'j7', 300);
INSERT INTO SPJ VALUES ('s5', 'p1', 'j4', 100);
INSERT INTO SPJ VALUES ('s5', 'p2', 'j2', 200);
INSERT INTO SPJ VALUES ('s5', 'p2', 'j4', 100);
INSERT INTO SPJ VALUES ('s5', 'p3', 'j4', 200);
INSERT INTO SPJ VALUES ('s5', 'p4', 'j4', 800);
INSERT INTO SPJ VALUES ('s5' ,'p5', 'j4', 400);
INSERT INTO SPJ VALUES ('s5', 'p5', 'j5', 500);
INSERT INTO SPJ VALUES ('s5', 'p5', 'j7', 100);
INSERT INTO SPJ VALUES ('s5', 'p6', 'j2', 200);
INSERT INTO SPJ VALUES ('s5', 'p6', 'j4', 500);

ALTER TABLE SPJ ADD CONSTRAINT SPJ_snum FOREIGN KEY (s_num) REFERENCES S (s_num);
ALTER TABLE SPJ ADD CONSTRAINT SPJ_pnum FOREIGN KEY (p_num) REFERENCES P (p_num);
ALTER TABLE SPJ ADD CONSTRAINT SPJ_jnum FOREIGN KEY (j_num) REFERENCES J (j_num);
