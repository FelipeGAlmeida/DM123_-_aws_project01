# DM123 - aws_project01

Repositório criado para versionamento do código desenvolvido durante a aula DM123, ministrada pelo professor Paulo Cesar Siecola.
O código é uma aplicação Java (API RESTful), que foi configurada para operar nas seguintes condições:
- Ser executado dentro de um container Docker;
- Ser hospedado em um cluster na AWS;
- Fazer operações com um banco de dados relacional MySQL hospedado na AWS;
- Envio de notificações SNS para um usuário especificado no serviço SNS da AWS;
- Exibição de logs;

## Funcionamento

O projeto conta com uma API completa para CRUD de produtos e ainda interação com alguns serviços AWS, entre eles: SNS, SQS, CloudWatch, S3 além de ser feito para ser hospedado em um Cluster ECS.

A cada requisição de CRUD nos produtos é gerada uma notificação via e-mail (usando o SNS), uma nova mensagem em uma fila SQS e adicionado um log no CloudWatch. A parte que envia uma nova mensagem à fila SQS (serviço de filas do AWS), adiciona os eventos (de CRUD) do produto como mensagens em uma fila, que é consumida pelo outro projeto de nome [DM123 - aws_project02](https://github.com/FelipeGAlmeida/DM123_-_aws_project02).

Adicionalmente, foi implementado também uma rotina de conexão com o serviço de armazenamento S3, onde o usuário pode requisitar um link para o upload de faturas (textos em JSON), que também são transformadas em mensagens e colocadas em outra fila do SQS para que sejam consumidas pelo projeto [DM123 - aws_project02](https://github.com/FelipeGAlmeida/DM123_-_aws_project02).

## Chamadas de API

**URL base:** *project01-lb-1746321782.us-east-1.elb.amazonaws.com:8080*

### Requests de teste (Exercício 1)

**GET** */api/test/dog/{{name}}*  
Response:  200 -> Name: {{name}}

**GET** *api/test/dogcolor/{{name}}*  
Response: 200 -> Always Black!

### Resquests CRUD Produtos:

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

### Resquest link de upload do S3:
**POST** *api/invoices*  
Response: 200 -> {{ Link para PUT de arquivo }}

### Resquest de listagem de invoices:

**GET** *api/invoices*  
Response: 200 -> {{Invoice List}}

**GET** *api/invoices/{{custumer}}*  
Response: 200 -> {{Invoice List}}  
&emsp;&emsp;&emsp;&emsp;&thinsp;&thinsp; 404 -> Not Found

_**Observações:** Por motivos de tempo, não foram feitas todas validações e tratamento de exceções nesta API._
