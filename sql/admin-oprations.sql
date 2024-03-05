
-- Add a new student who can checkout books from the store
-- The unique student id allows the student to checkout books for themselves.
INSERT INTO STUDENT (id, name, course, branch, aaid)
VALUES ('<generated unique value>', '<name>', 'Bachelor of Engineering', '<branch>', '<aaid>');


-- Add a new author into the store
INSERT INTO author (id, name, country)
VALUES (1, '<author name>', 'country');

-- Add a book into the store
INSERT INTO book (id, title, author_id, price, genre)
VALUES (1, '<title>', <author_id>, <price>, '<genre>');

-- Change the inventory stock to restock or remove stock for a book
INSERT INTO inventory (book_id, store)
VALUES (1, <number of books in inventory>);

-- See the order history table
SELECT * FROM orderhistory;

-- Order history for a book
SELECT * FROM orderhistory WHERE book_id = <bookId>;

-- Order history for a student
SELECT * FROM orderhistory WHERE student_id = <unique studentId>;



