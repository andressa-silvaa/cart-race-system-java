
# Sistema de Corrida de Carrinhos - Java

>📌 Status :  aguardando melhorias 

>Este é um projeto Java que implementa um sistema de corrida de carrinhos. O programa permite que o usuário insira novos carrinhos e os respectivos tempos cronometrados de cada volta da corrida. Os tempos de cada volta são armazenados em uma tabela no banco de dados MySQL e utilizados para calcular o ranking da corrida. Além disso, o sistema gera uma captura de tela "barrada" e um arquivo de texto com as informações da tabela do banco de dados.

> <img src="./imagens/carrinho-removebg-preview.png" alt="Imagem ilustrativa" style="width:200px;height:150px;">

>## 📢Funcionalidades

>- Inserção de tempos de corrida para carrinhos, em formato minutos:segundos.
>- Armazenamento de informações no banco de dados MySQL.
>- Cálculo do tempo total de corrida para cada carrinho.
>- Geração de um ranking de corrida baseado no menor tempo total.
>- Geração de uma captura de tela "barrada" para exemplificar a proteção de dados(Inspirado na Netflix).
>- Criação de um arquivo de texto com informações da tabela do MySQL.

>## ⚠️Como Usar

>1. Configure a conexão com o banco de dados MySQL no pacote `db`.
>2. Execute a classe principal `Main` no pacote `application` para iniciar o sistema.
>3. Siga as instruções do menu para inserir os tempos de corrida dos carrinhos.
>4. Quando não quiser inserir mais carrinhos, saia do loop de menu.
>5. O sistema gerará um ranking dos carrinhos com base nos tempos totais de corrida.
>6. O sistema também gerará uma captura de tela barrada e um arquivo de texto com informações da tabela do banco de dados.

>## 💯Estrutura do Projeto

>- `application`: Contém a classe `Main` que inicia o sistema.
>- `db`: Contém as classes responsáveis pela conexão com o banco de dados.
>- `entities`: Contém as entidades do sistema.

>## 💌Exemplos Adicionais

>Exemplos da captura de tela barrada e relatório de texto da tabela MySQL podem ser encontrados no diretório deste repositório.

>## 🕹️Tecnologias

JAVA | MySQL 
:------:  | :------: 
LTS 17 | 8.0.x

>## 👩Autor

>Andressa Silva

>## 📃Licença

>Este projeto está sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter mais detalhes.





