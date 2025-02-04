CREATE TABLE modelex_ai.nodes (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    fqdn VARCHAR(255) NOT NULL,
    public_key TEXT NOT NULL,
    ethereum_address VARCHAR(255) NOT NULL,
    p2p_port VARCHAR(50) NOT NULL,
    rpc_port VARCHAR(50) NOT NULL,
    registered boolean NOT NULL
);

INSERT INTO modelex_ai.nodes (name, fqdn, public_key, ethereum_address, p2p_port, rpc_port, registered)
    VALUES ('My node', 'mydomain.com',
            '-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0awProZzw3AuwIuH5ikk\nF2LXexq7wRewu8+5MwZKcelHBVqQ9p6e3rTasUAgaHA9W1WfdMF3gUgjU5lF5pg9\nfyzOpnEsIJlFb3mbM3NCDCX3+J14/CqBHhMP5rKHEUTa6xw+T3G4Z6JHxGBr4c0F\n6Oiw5O4NcBfkD5cOJ4FPniIBJSNxIz5wr6Tq8rYGQWYJBz/1cMmoQAu2g97gIiu0\nIhmuw/eblX3Xrjsx5v2QKTtr+FwXa34JQ2gC9Q6PR7+BpN8M17GrjbT5CU1fnVYE\n5Bc1LEp0vGeQMuNLJXqZA11TfSF/VZF2BFQ85vI9MM71BQK3/TkMdB0LD5oaiUpI\nMwIDAQAB\n-----END PUBLIC KEY-----\n', '0x32Be343B94f860124dC4fEe278FDCBD38C102D88',
            '4443', '8080', true);