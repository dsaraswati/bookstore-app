create database bookstore-app
	with owner = postgres;

CREATE TABLE author (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    country VARCHAR(64)
);

CREATE TABLE book (
    id INT PRIMARY KEY,
    title VARCHAR(255),
    author_id INT,
    price DOUBLE PRECISION,
    genre VARCHAR(255),
    CONSTRAINT book_authorid_fkey FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE TABLE inventory (
    book_id INT PRIMARY KEY,
    stock INT,
    CONSTRAINT inventory_bookid_fkey FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE student (
    id VARCHAR(64) PRIMARY KEY,
    name VARCHAR(255),
    course VARCHAR(64),
    branch VARCHAR(64),
    aaid VARCHAR(64)
);

CREATE TABLE orderhistory (
	id SERIAL PRIMARY KEY,
	book_id INT,
	student_id VARCHAR(64),
	CONSTRAINT orderhistory_bookid_fkey FOREIGN KEY (book_id) REFERENCES book(id),
	CONSTRAINT orderhistory_studentid_fkey FOREIGN KEY (student_id) REFERENCES student(id)
);

CREATE TABLE admin(
	id SERIAL PRIMARY KEY,
	username VARCHAR(64),
	passsword VARCHAR(256),
	token VARCHAR(1024)
);
