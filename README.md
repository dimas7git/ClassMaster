Sistema de Gerenciamento de Aulas Particulares

O sistema foi desenvolvido para facilitar a administração e organização de aulas entre alunos e professores particulares. Ele permite o cadastro de alunos, professores, cursos, materiais de estudo, além de possibilitar a realização de matrículas em cursos e a gestão completa dessas matrículas.

## Funcionalidades Principais

O sistema oferece as seguintes funcionalidades principais:

1. **Cadastro de Alunos e Professores**: Os usuários podem se cadastrar como alunos ou professores no sistema, fornecendo informações pessoais como nome, CPF, e-mail, telefone, endereço etc.

2. **Cadastro de Cursos**: Professores podem cadastrar cursos disponíveis para ensino, fornecendo informações como nome do curso, sigla, descrição, entre outros.

3. **Cadastro de Materiais de Estudo**: Professores podem cadastrar materiais de estudo relacionados aos cursos disponíveis, facilitando o acesso dos alunos a conteúdo relevante.

4. **Matrícula em Cursos**: Alunos podem se matricular nos cursos disponíveis no sistema, permitindo o acesso aos materiais de estudo associados a esses cursos.

5. **Gestão de Matrículas**: Professores e administradores podem gerenciar as matrículas dos alunos nos cursos, permitindo a visualização, alteração e exclusão das mesmas.

## Estrutura do Projeto

O projeto é estruturado em diferentes pacotes, cada um responsável por uma parte específica do sistema. A seguir, uma visão geral da estrutura do projeto:

- **`br.com.avaliacao_lp2.dao`**: Pacote contendo os Data Access Objects (DAOs) responsáveis pela interação com o banco de dados PostgreSQL. Cada DAO gerencia operações relacionadas a uma entidade específica do sistema, como alunos, professores, cursos, materiais e matrículas.

- **`br.com.avaliacao_lp2.dto`**: Pacote contendo os Data Transfer Objects (DTOs), que representam as entidades do sistema e são utilizados para transferir dados entre as camadas do sistema.

- **`br.com.avaliacao_lp2.views`**: Pacote contendo as interfaces gráficas (GUIs) do sistema, implementadas utilizando o framework Swing do Java.

## Tecnologias Utilizadas

O projeto utiliza as seguintes tecnologias e ferramentas:

- **Java**: Linguagem de programação utilizada para desenvolver o sistema.
- **PostgreSQL**: Banco de dados relacional utilizado para armazenar os dados do sistema.
- **Swing**: Framework Java para criação de interfaces gráficas, utilizado para desenvolver as telas do sistema.
