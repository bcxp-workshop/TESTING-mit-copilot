CREATE TABLE SERIES (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE BOOK (
    id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(255),
    price DECIMAL(10,2),
    available BOOLEAN,
    author VARCHAR(255),
    series_id INT,
    CONSTRAINT fk_series FOREIGN KEY (series_id) REFERENCES SERIES(id)
);