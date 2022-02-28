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
