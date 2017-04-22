# Gerenciador de Endereços #
Serviço responsável pelo gerenciamento de endereços dos usuários

# Funcionalidades #
 - Consulta de CEP: Consulta de endereço por cep 
 - Manutenção do endereco: Consulta, inclusão, manutenção e exclusão de endereço
 
# Instruções de Execução #

 - Acessar a pasta do projeto e executar:
   mvn -DskipTests package

 - Após a geração do build com sucesso a aplição poderá ser iniciada
   Ex: mvn spring-boot:run

# Swagger #
Documentação das APIs
localhost:8080/swagger-ui.html

# Exemplos #
GET /enderecos
{
    "logradouro": "Rua Boçoroca",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "04377190",
    "complemento": "Rua 1",
    "bairro": "Vila Mira"
}

# Bibliotecas Utilizadas #
 - Spring Boot: Projeto Spring, criado para facilitar o start inicial de um projeto, efetuando automaticamente algumas configurações
 - Spring MVC: Projeto Spring, facilita na utilização do modelo MVC. É amplamente utilizado pela comunidade, e facilita o desenvolvimento, tornando o código mais limpo e facil de ser mantido. É intuitívo, pois boa parte dos comportamentos são configurados utilizando annotations.
 - Spring Data JPA: Facilita algumas operações de persistência de dados, ou CRUD. É uma abstração das ferramentas ORM. Utilizei, pois facilita e muito as operações com o Banco de dados. Query Metho ajuda bastante.
 - HSQLDB: Banco de dados em memória. Utilizei pois, não existe necessidade de instalação, apenas execução de arquivo jar
 - Swagger: É definido como um framework. É útil para documentar e até mesmo testar suas APIs  

