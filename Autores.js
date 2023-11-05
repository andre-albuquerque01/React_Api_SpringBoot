const database = 'projetos';

// Create a new database.
use(database);

// Create a new collection.
db.createCollection('livraria');
db.createCollection('autores');



use('projetos');

db.autores.insertMany(
    [{ "id": { "$oid": "65467c24fc13ae5aed553a87" }, "nome": "Eden", "sobrenome": "Gabbott", "email": "egabbott0@ucoz.ru", "telefone": 2553876383, "ativo": true },
    { "id": { "$oid": "65467c24fc13ae5aed553a88" }, "nome": "Novelia", "sobrenome": "Cage", "email": "ncage1@spotify.com", "telefone": 8765445177, "ativo": true },
    { "id": { "$oid": "65467c24fc13ae5aed553a89" }, "nome": "Lib", "sobrenome": "Haworth", "email": "lhaworth2@nifty.com", "telefone": 4318402367, "ativo": false },
    { "id": { "$oid": "65467c24fc13ae5aed553a8a" }, "nome": "Mel", "sobrenome": "Hewson", "email": "mhewson3@newyorker.com", "telefone": 9219828350, "ativo": false },
    { "id": { "$oid": "65467c24fc13ae5aed553a8b" }, "nome": "Irvin", "sobrenome": "Essel", "email": "iessel4@ifeng.com", "telefone": 7489183227, "ativo": true },
    { "id": { "$oid": "65467c24fc13ae5aed553a8c" }, "nome": "Billy", "sobrenome": "Armytage", "email": "barmytage5@php.net", "telefone": 5787622672, "ativo": true },
    { "id": { "$oid": "65467c24fc13ae5aed553a8d" }, "nome": "Alphonse", "sobrenome": "Morfey", "email": "amorfey6@ihg.com", "telefone": 8659426957, "ativo": true },
    { "id": { "$oid": "65467c24fc13ae5aed553a8e" }, "nome": "Teena", "sobrenome": "Parnaby", "email": "tparnaby7@imdb.com", "telefone": 8486372230, "ativo": false },
    { "id": { "$oid": "65467c24fc13ae5aed553a8f" }, "nome": "Clotilda", "sobrenome": "MacAnellye", "email": "cmacanellye8@opensource.org", "telefone": 7377801074, "ativo": false },
    { "id": { "$oid": "65467c24fc13ae5aed553a90" }, "nome": "Wait", "sobrenome": "Dowry", "email": "wdowry9@wikimedia.org", "telefone": 2842024051, "ativo": true }]
);