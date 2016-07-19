CREATE TABLE IF NOT EXISTS registrations (
    id INT PRIMARY KEY default unique_rowid(),
    event_id INT references event(id) NOT NULL,
    subscriber INT references user(id) NOT NULL,
    participant INT references user(id) NOT NULL,
    vat STRING,
    hash STRING,
    insert_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS event (
    id INT PRIMARY KEY default unique_rowid(),
    name STRING NOT NULL,
    seats INT NOT NULL,
    insert_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);CREATE TABLE IF NOT EXISTS user (
    id INT PRIMARY KEY default unique_rowid(),
    email STRING UNIQUE NOT NULL,
    first_name STRING NOT NULL,
    last_name STRING NOT NULL,
    is_admin BOOL DEFAULT false
    insert_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

