CREATE TABLE ms_rest_base.accounts (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    hashed_password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    full_name VARCHAR(255) NOT NULL
);

INSERT INTO ms_rest_base.accounts (username, hashed_password, email, full_name)
    VALUES ('test_account', '$2a$12$hw2tN5j.RpmRlgtHNHK.Tez.cPaxoS.yy/qcdvrG.klgZs2pucTZi',
            'testaccount@gmail.com',
            'Test Account');