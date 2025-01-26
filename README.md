# BugBankTesting - Automação de Testes para o BugBank 

## Descrição
Este projeto pessoal tem como objetivo o aprendizado prático de testes de software e desenvolvimento de um framework de automação de testes para o site BugBank. O BugBankTesting foca na garantia da qualidade de funcionalidades essenciais, como cadastro de usuários, login, transferências bancárias e validação de saldo.

## Funcionalidades Testadas
* **Cadastro de Clientes:** Verificação do processo de cadastro com diferentes tipos de dados.
* **Login:**  Teste de login com credenciais válidas e inválidas.
* **Transferência de Valores:**  Validação de transferências entre contas, incluindo cenários de sucesso e falha.
* **Saldo da Conta:**  Confirmação da atualização do saldo após transações.
* **Extrato:** Confirmação de exibição do saldo com valores positivos e negativos.
  
## Arquitetura e Metodologias
* **Behavior Driven Development (BDD):**  Utiliza o Cucumber para definir o comportamento do sistema em linguagem natural (Gherkin), tornando os testes mais claros para stakeholders técnicos e não técnicos.
* **Page Objects Model:**  Organiza o código de automação em torno de objetos de página, melhorando a legibilidade e manutenção.
* **TestNG:** Framework de testes para estruturação e execução dos testes automatizados.

## Tecnologias Utilizadas
* **Java:** Linguagem de programação principal.
* **Selenium WebDriver:**  Interação com o navegador para simular ações do usuário.
* **TestNG:** Framework de execução de testes.
* **Cucumber:** Suporte a BDD (Behavior Driven Development). 
* **Jenkins:**  Integração Contínua (CI) para automatizar a execução de testes a cada novo build.
* **Extent Reports:** Geração de relatórios de teste detalhados e visuais.

## Autor
Lucas Moreno - [Linkedin](https://www.linkedin.com/in/lucas-moreno389/) 
