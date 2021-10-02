# Lojinha API Automação
Automação de testes de API Web de um software denominado Lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.


## 🛰️ Tecnologias Utilizadas   
- [Java](https://www.oracle.com/br/java/technologies/javase-jdk11-downloads.html)
  
- [JUnit](https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0-M1)
  
- [Selenium](https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.0.0-rc-2)
  
- [Maven](https://maven.apache.org/)

- [IntelliJ IDEA](https://www.jetbrains.com/idea/)

## 🤖 Testes Automatizados
Testes para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto deve estar entre R$ 0,01 e R$ 7.000,00.

## 📝 Notas Gerais

- Sempre utilizamos a anotação Before Each para abrir o navegador que será utilizado posteriormente nos métodos de teste, assim, evitamos abrir o navegador várias vezes.
- Sempre utilizamos a anotação After Each para fechar o navegador que foi utilizado pelos métodos de teste, assim, evitando ter diversos navegadores abertos.
- Utilizamos Page Objects que as páginas implementadas nos testes possam ser reaproveitadas, facilitando os testes futuros.
- Nesse projeto fazemos uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em português para nossos testes



> 👍 Automação desenvolvida durante o Programa de Testes e Qualidade de Software de [Julio de Lima](https://www.juliodelima.com.br)