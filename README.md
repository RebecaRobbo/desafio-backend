# Desafio-backend

É esperado que esse projeto crie uma conta por usuário, realize transferências gratuitas abaixo de :moneybag: R$ 2.000, depósitos, e saques, porém a conta não poderá ficar negativada

## Configurando o ambiente para rodar o projeto

Para configurar é fácil! Realize o git clone, abra o projeto na sua IDE preferida e como esse projeto possui uma conexão com o banco MySQL que está rodando na AWS configure as seguintes informações em uma IDE de banco de dados (ultilizamos o Datagrip): 

    - URL: jdbc:mysql://projeto-final.cxzj4fkwd61l.us-east-1.rds.amazonaws.com:3306/desafio-backend
    - Host: projeto-final.cxzj4fkwd61l.us-east-1.rds.amazonaws.com
    - Port: 3306
    - User: admin
    - Password: Por questão de segurança não irei mencionar nesse documento


## Realizando teste da aplicação
Realizei os teste da aplicação pelo Postman, segue os principais testes
  
  - Teste de criação de usuário: 
      * Método: Post
      * API utilizada: localhost:8080/api/account
      * Exemplo:
          {
    "numberAccount": "22221",
    "agency": "124",
    "balance" : "0",
    "user":{
        "name":"teste",
        "cpf": "450.457.456-56"
    }
}

  - Teste deposit: 
  
    * Método: Post
    
    * API: localhost:8080/api/account/deposit?accountNumber=22222&cashValue=2000
     
  - Teste withdraw:
   
     * Método: Post
     
     * API: localhost:8080/api/account/withdraw?accountNumber=11111&cashValue=100

    
   - Teste transfer:
   
     * Método: Post
     
     * API: localhost:8080/api/account/transfer?originAccountNumber=11111&targetAccountNumber=22222&cashValue=350


## :computer: Técnicas e tecnologias usadas
- Java 11
- Intelij
- Datagrip 
- AWS
- MySQL
- Postman

