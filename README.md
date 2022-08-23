# Multi-Tenancy

## Para que serve o Multi-Tenancy
```
- Teremos um schema Public, com as tabelas Customer é User.
- Dentro da Tabela tem uma coluna com o nome schema.
- Quando for salvar uma trip um interceptor vai pegar o token, extrair um claim com o nome schema
- Depois de extrair esse claim, ele vai tentar criar o schema, caso o schema exista ele vai salvar a trip no schema daquele customer
- Para cada Customer teremos um schema diferente 
```

## Construído com as seguintes tecnologias

```
* Spring Boot 
* Java
* Jwt
* Mapstruct
* Flyway
* OpenAPi
* Jpa 
* Hibernate
```
## Executando o aplicativo localmente
```
- Faça o clone o repositório via https "git clone https://github.com/LuccasLpn/multi-tenancy.git"
- Abra a Pasta src/main/resources
- Execute -> Linux "sudo docker-compose up -d"
- Execute -> Windows "docker-compose up -d"
- Abra o IntelliJ IDEA
   - Open -> Navegue até a pasta onde está o projeto
   - Selecione o projeto clonado do git
- Escolha o arquivo do aplicativo de inicialização do Spring (pesquise @SpringBootApplication)
- Clique com o botão direito do mouse no arquivo e execute
```
## Fazer Login
```
- Use o endpoint "http://localhost:7077/multi-tenancy/auth/login"
- Coloque esse JsonObject ->
{
    "email": "master@outlook.com",
    "password": "master"
}
- Retornando HttpStatus 200 Ok, pegue o token que será gerado nos Headers da request
- Esse Token deve ser passado nas próximo requisições
- Com base nos claims do token ele vai criar um schema diferente, é vai executar a migration do flyway, criando uma tabela trip
- Caso o schema já exista ele ira salvar a trip naquele schema
```

## URL USER
|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:7077/multi-tenancy/driver/save` | POST | |
|`http://localhost:7077/multi-tenancy/driver/delete/{id}` | DELETE | |
```
```
## URL TRIP
|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:7077/multi-tenancy/trip/save` | POST | |
|`http://localhost:7077/multi-tenancy/trip/delete/{id}` | DELETE | |
```
```
## URL AUTH
|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:7077/multi-tenancy/auth/login` | POST | |
```
```
## URL CUSTOMER
|  URL |  Method | Remarks |
|----------|--------------|--------------|
|`http://localhost:7077/multi-tenancy/customer/save` | POST | |
|`http://localhost:7077/multi-tenancy/customer/delete/{id}` | DELETE | |
```
```