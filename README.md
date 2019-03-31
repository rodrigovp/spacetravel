A solução foi escrita usando Spring Boot como ferramenta principal.
Foi utilizada também a arquitetura em camadas sugerida pelo Domain Driven Design e pelo próprio Spring. Logo, foram ou serão construídas classes controller, service e de domínio.

Para a escrita de código, utilizou-se TDD, fazendo com que a cobertura fique acima de 80%.
Também utilizou-se o framework Lombok para criação de métodos equals() e hashCode() via anotações.
Para aplicação de testes, utilizou-se os frameworks JUnit e Hamcrest.

Outras informações:

  * inicialmente, pensei em utilizar a classe java.awt.Point para representar um ponto. Entretanto, resolvi utiilizar uma de minha autoria mesmo, visto que teria mais flexibilidade para 
 mudar a classe se necessário, além do fato de que essa classe da biblioteca padrão do Java possui métodos que não são necessários para a resolução do problema proposto.
  * não foram necessários ifs/elses explícitos em nenhum lugar do código;
  * as classes Posicao e SondaEspacialService contém testes que simulam os exemplos fornecidos no enunciado do teste;
  
 Status: estão prontas as camadas de domínio e service, faltando apenas o controller e seus testes.