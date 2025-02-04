CREATE TABLE modelex_ai.models (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    hash_wb TEXT NOT NULL,
    node_id INTEGER NOT NULL
);

INSERT INTO modelex_ai.models (name, hash_wb, node_id) VALUES ('Model_1', '9ba2557bf997b43a64b803e570378de65387d00359bf8868c4fb8c9bf3d22ca3', 1);
INSERT INTO modelex_ai.models (name, hash_wb, node_id) VALUES ('Model_2', '9ba2557bf997b43a64b803e570378de65387d00359bf8868c4fb8c9bf3d22ca3', 1);
INSERT INTO modelex_ai.models (name, hash_wb, node_id) VALUES ('Model_3', '9ba2557bf997b43a64b803e570378de65387d00359bf8868c4fb8c9bf3d22ca3', 1);
