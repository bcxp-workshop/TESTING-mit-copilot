-- Reihen
INSERT INTO SERIES (id, name) VALUES (1, 'Scheibenwelt');
INSERT INTO SERIES (id, name) VALUES (2, 'Harry Potter');
INSERT INTO SERIES (id, name) VALUES (3, 'Der Herr der Ringe');
INSERT INTO SERIES (id, name) VALUES (4, 'Per Anhalter durch die Galaxis');
INSERT INTO SERIES (id, name) VALUES (5, 'Die drei Sonnen-Trilogie');

-- Books Scheibenwelt
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES
                                                                             (1, 'Die Farben der Magie', 'Fantasy', 12.99, true, 'Terry Pratchett', 1),
                                                                             (2, 'Das Licht der Phantasie', 'Fantasy', 13.99, false, 'Terry Pratchett', 1),
                                                                             (17, 'Gevatter Tod', 'Fantasy', 13.99, true, 'Terry Pratchett', 1);

-- Books Harry Potter
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES
                                                                             (3, 'Harry Potter und der Stein der Weisen', 'Fantasy', 15.99, true, 'J.K. Rowling', 2),
                                                                             (18, 'Harry Potter und der Feuerkelch', 'Fantasy', 17.99, false, 'J.K. Rowling', 2);

-- Books "Der Herr der Ringe"
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES
                                                                             (19, 'Die Gefährten', 'Fantasy', 13.99, true, 'J.R.R. Tolkien', 3),
                                                                             (20, 'Die zwei Türme', 'Fantasy', 13.99, true, 'J.R.R. Tolkien', 3),
                                                                             (21, 'Die Rückkehr des Königs', 'Fantasy', 13.99, true, 'J.R.R. Tolkien', 3);

-- Books "Per Anhalter durch die Galaxis"
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES
                                                                             (22, 'Per Anhalter durch die Galaxis', 'Science Fiction', 12.99, true, 'Douglas Adams', 4),
                                                                             (23, 'Das Restaurant am Ende des Universums', 'Science Fiction', 12.99, false, 'Douglas Adams', 4);

-- Books "Die drei Sonnen-Trilogie"
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES
                                                                             (24, 'Die drei Sonnen', 'Science Fiction', 14.99, true, 'Cixin Liu', 5),
                                                                             (25, 'Der dunkle Wald', 'Science Fiction', 15.99, true, 'Cixin Liu', 5),
                                                                             (26, 'Jenseits der Zeit', 'Science Fiction', 16.99, false, 'Cixin Liu', 5);

-- Books (without series, series_id = NULL!)
INSERT INTO BOOK (id, title, genre, price, available, author, series_id) VALUES
                                                                             (4, 'Der Alchimist', 'Roman', 10.99, true, 'Paulo Coelho', NULL),
                                                                             (27, 'Der Schwarm', 'Thriller', 15.99, true, 'Frank Schätzing', NULL),
                                                                             (28, 'Mord im Orient Express', 'Krimi', 10.99, false, 'Agatha Christie', NULL),
                                                                             (29, '1984', 'Dystopie', 12.49, false, 'George Orwell', NULL),
                                                                             (30, 'Die Unendliche Geschichte', 'Fantasy', 13.99, true, 'Michael Ende', NULL),
                                                                             (31, 'Wer die Nachtigall stört', 'Roman', 11.99, false, 'Harper Lee', NULL),
                                                                             (32, 'Sophies Welt', 'Roman', 10.99, true, 'Jostein Gaarder', NULL),
                                                                             (33, 'Die Entdeckung der Langsamkeit', 'Roman', 10.99, true, 'Sten Nadolny', NULL);