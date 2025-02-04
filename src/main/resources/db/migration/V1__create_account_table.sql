CREATE TABLE modelex_ai.accounts (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    hashed_password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL
);

INSERT INTO modelex_ai.accounts (username, hashed_password, email, full_name)
    VALUES ('john', '$2a$12$hw2tN5j.RpmRlgtHNHK.Tez.cPaxoS.yy/qcdvrG.klgZs2pucTZi', 'John Doe', 'johndoe@example.com');