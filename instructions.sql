CREATE TABLE IF NOT EXISTS registrations (
    id INT PRIMARY KEY default unique_rowid(),
    first_name STRING,
    last_name String,
    email STRING,
    vat STRING,
    hash STRING,
    insert_date TIMESTAMP
);

