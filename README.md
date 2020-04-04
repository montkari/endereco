# crud-endereco

H2 http://localhost:8080/dados-cadastro/h2-console (Existe um registro do CPF gerado através do gerador de CPF (55217715065))

GET - Buscar um cliente pelo CPF -  http://localhost:8080/dados-cadastro/cliente/{cpf}

POST - Cadastrar um novo cliente -  http://localhost:8080/dados-cadastro/cliente

{
    "codigo": null,
    "nome": "João",
    "cpf": "17135301048",
    "profissao": null,
    "cep": "58081132",
    "logradouro": "Rua Francisca Germana da Silva",
    "numero": "80",
    "complemento": null,
    "referencia": null,
    "bairro": "Costa e Silva",
    "municipio": "João Pessoa",
    "uf": "PB"
}

GET - Buscar estados - http://localhost:8080/dados-cadastro/endereco/estados

GET - Buscar municípios pelo ID do estado - http://localhost:8080/dados-cadastro/endereco/{idEstado}/municipios

PUT - Alterar endereço do cliente - http://localhost:8080/dados-cadastro/cliente/endereco/55217715065

{
    "codigo": 1,
    "nome": "João",
    "cpf": "55217715065",
    "dataNascimento": "02/04/1980",
    "profissao": null,
    "cep": "58081132",
    "logradouro": "Rua Teste Germana da Silva",
    "numero": "80",
    "complemento": null,
    "referencia": null,
    "bairro": "Costa e Silva",
    "municipio": "João Pessoa",
    "uf": "PB"
}


