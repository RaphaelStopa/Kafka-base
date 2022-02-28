# WIP

Address Get (ViaCep)
http://localhost:8080/zipcode/01001000

POST
http://localhost:8080/zipcode

{
"cep": "01001-000",
"complemento": "lado ímpar",
"numero": 10
}

Olhar as mgs: http://localhost:19000/topic/topic_address_client/messages?partition=0&offset=0&count=100&keyFormat=DEFAULT&format=DEFAULT


Falta um uptare automatico por entidade e isto mas fiz manualmente
create table address
(
id          int auto_increment
primary key,
cep         varchar(200) null,
logradouro  varchar(200) null,
bairro      varchar(200) null,
localidade  varchar(200) null,
uf          varchar(10)  null,
numero      mediumtext   null,
complemento varchar(200) null,
constraint address_id_uindex
unique (id)
);

falta pegar pelo kafka e jogar no db


post
http://localhost:8080/zipcode
{
"cep": "01001-000",
"complemento": "lado ímpar",
"numero": 10
}

