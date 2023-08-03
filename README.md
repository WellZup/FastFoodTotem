# 🍟 FastFoodTotem
Totem de atendimento da ZupFood

<p align="center">
<img src="https://img.shields.io/badge/Status-Programador_em_Desenvolvimento-red"></p>

# Totem de Autoatendimento - Documentação
## 📝 Descrição
O Totem de Autoatendimento é um sistema desenvolvido para uma lanchonete FastFood, que permite que os clientes façam seus pedidos de forma autônoma e retirem seus pedidos prontos no balcão. O objetivo do sistema é liberar os operadores de caixa para outras funções, tornando o processo de atendimento mais eficiente.

## 📊Requisitos
### O sistema deve atender aos seguintes requisitos:

- `A tela inicial` `deve ter um menu onde o usuário pode selecionar se deseja comprar um lanche ou uma bebida.`
- `O sistema deve aceitar apenas o número da opção para escolher entre lanche ou bebida.`
- `Caso o usuário tente inserir alguma informação do tipo String, o sistema deve retornar uma mensagem de formato inválido.`
- `Ao escolher lanche, o sistema deve exibir as opções disponíveis e permitir que o usuário selecione a quantidade desejada.`
- `Ao escolher bebida, o sistema deve exibir as opções disponíveis e permitir que o usuário selecione a quantidade desejada.`
- `O sistema deve permitir ao usuário adicionar, editar ou remover itens do carrinho de compras.`
- `Ao finalizar o pedido, o sistema deve mostrar o valor total da compra e as opções de pagamento disponíveis.`
- 
## 🚥 Funcionamento
### O sistema foi desenvolvido em Java e utiliza o banco de dados PostgreSQL para armazenar os itens do cardápio, preços e os pedidos dos clientes.

## 🎲Estrutura do Banco de Dados
O banco de dados possui as seguintes tabelas:

- `lanche: armazena os lanches disponíveis no cardápio, com seus nomes e valores.`
- `bebida: armazena as bebidas disponíveis no cardápio, com seus nomes e valores.`
- `carrinho: armazena os carrinhos de compras dos clientes, com o valor total da compra.`
- `item_carrinho: armazena os itens adicionados aos carrinhos de compras, com as referências para os lanches e bebidas.`
- 
## 🖥 Uso do Sistema
Ao iniciar o programa, o usuário será apresentado a um menu inicial onde poderá escolher entre comprar um lanche, uma bebida, editar o carrinho ou finalizar o pedido. O usuário deve inserir o número correspondente à opção desejada.

Para comprar um lanche, o usuário deverá selecionar a opção 1 no menu inicial. Em seguida, o sistema exibirá as opções de lanches disponíveis, onde o usuário deve escolher o lanche desejado e a quantidade. O valor total da compra será atualizado conforme o usuário adiciona itens ao carrinho.

Para comprar uma bebida, o usuário deverá selecionar a opção 2 no menu inicial. O processo é similar à compra de lanches, onde o usuário escolhe a bebida e a quantidade desejada.

Para editar o carrinho, o usuário deve selecionar a opção 3 no menu inicial. Nessa opção, o usuário pode adicionar, remover ou editar a quantidade de itens no carrinho.

Ao finalizar o pedido, o usuário deve selecionar a opção 4 no menu inicial. O sistema mostrará o valor total da compra e as opções de pagamento disponíveis. O pedido será registrado no banco de dados com as informações do carrinho.

## 🛠 Testes
Para garantir a qualidade do sistema, foram criados testes unitários para a classe CarrinhoDeCompras. Os testes verificam se as funcionalidades de adicionar, remover e editar itens no carrinho e calcular o valor total estão funcionando corretamente.

## 📀 Como executar o programa
### Para executar o programa, siga os passos abaixo:

Clone o repositório para o seu ambiente local.
Importe o projeto em sua IDE preferida (o projeto foi desenvolvido em Java).
Certifique-se de que o banco de dados PostgreSQL esteja instalado e configurado corretamente.
Execute o arquivo Main.java para iniciar o programa.
Siga as instruções no console para utilizar o totem de autoatendimento.
## 👥 Contribuição
O projeto foi desenvolvido como parte de um desafio. Se você quiser contribuir para o desenvolvimento do sistema de totem de autoatendimento, sinta-se à vontade para fazer um fork do repositório e enviar suas melhorias através de pull requests.

## ✔️ Técnicas e tecnologias utilizadas

- ``Java ``
- ``InteliJ IDEA``
- ``Mentoria``
- ``Revisão de aulas JOY ``
- ``DEV Media``



![Stack Overflow](https://img.shields.io/badge/-Stackoverflow-FE7A16?style=for-the-badge&logo=stack-overflow&logoColor=white)
![LeetCode](https://img.shields.io/badge/LeetCode-000000?style=for-the-badge&logo=LeetCode&logoColor=#d16c06)
![Udemy](https://img.shields.io/badge/Udemy-A435F0?style=for-the-badge&logo=Udemy&logoColor=white)
![Oracle](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
![IntelliJ IDEA](https://img.shields.io/badge/IntelliJIDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)


