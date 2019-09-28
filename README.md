# DM123 - aws_project01

Repositório criado para versionamento do código desenvolvido durante a aula DM123, ministrada pelo professor Paulo Cesar Siecola.
O código é uma aplicação Java (API RESTful), que foi configurada para operar nas seguintes condições:
- Ser executado dentro de um container Docker;
- Ser hospedado em um cluster na AWS;
- Fazer operações com um banco de dados relacional MySQL hospedado na AWS;
- Envio de notificações SNS para um usuário especificado no serviço SNS da AWS;
- Exibição de logs;

## Chamadas de API

**URL base:** *project01-lb-1746321782.us-east-1.elb.amazonaws.com:8080*

### Requests de teste (Exercício 1)

**GET** */api/test/dog/{{name}}*  
Response:  200 -> Name: {{name}}

**GET** *api/test/dogcolor/{{name}}*  
Response: 200 -> Always Black!

### Resquests Gerais:

**GET** *api/products*  
Response: 200 -> {{Product List}}

**GET** *api/products/{{id}}*  
Response: 200 -> {{Product}}  
&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp; 404 -> Not Found

**GET** *api/products* (?code={{code}})  
Param:&emsp;&ensp; code: {{code}}  
Response: 200 -> {{Product}}  
&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp; 404 -> Not Found

**POST** *api/products*  
Body:&emsp;&ensp; {"name": "Name1","model": "Model1","code": "1111","price": 10.0}  
Response: 200 -> {{Product}}

**PUT** *api/products/{{id}}*  
Body:&emsp;&ensp; {"name": "Name1","model": "Model1","code": "1111","price": 10.0}  
Response: 200 -> {{Product}}  
&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp; 404 -> Not Found

**DELETE** *api/products/{{id}}*  
Response: 200 -> {{Product}}  
&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp; 404 -> Not Found

_**Observações:** Por motivos de tempo, não foram feitas todas validações e tratamento de exceções nesta API._