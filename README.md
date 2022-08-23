# Multi-Tenancy

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