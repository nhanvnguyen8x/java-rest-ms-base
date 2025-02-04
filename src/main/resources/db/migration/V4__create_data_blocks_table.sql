CREATE TABLE modelex_ai.data_blocks (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    file_url VARCHAR(255) NOT NULL,
    hash_wb TEXT NOT NULL,
    node_id INTEGER NOT NULL
);

INSERT INTO modelex_ai.data_blocks (name, file_url, hash_wb, node_id)
VALUES ('financial_news.csv', 'financial_news.csv', '71aa99d0d37feced03c999ec23b5b25302c92f39d69b6acb0a37aa076c5420e8', 1);
