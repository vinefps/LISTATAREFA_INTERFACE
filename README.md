# LISTATAREFA_INTERFACE



Requisitos: Java Development Kit (JDK): Versão 8 ou superior. Bibliotecas Utilizadas: java.util.Scanner: Para leitura de entrada do usuário. java.util.Random: Para gerar números aleatórios.

Como Rodar o Projeto: Instale o JDK: Certifique-se de ter o JDK instalado em seu sistema e utilize SHIFT + F10.

O código apresentado representa um aplicativo Java que visa fornecer uma solução para o gerenciamento de uma lista de tarefas por meio de uma interface gráfica. É importante notar que a interface gráfica é criada usando a biblioteca Swing.



A funcionalidade do aplicativo pode ser resumida da seguinte forma:

-Interface Gráfica Amigável: O programa apresenta uma janela com uma interface gráfica intuitiva que permite ao usuário interagir com as tarefas de maneira simples e amigável.

-Adição de Tarefas: O botão "Adicionar Tarefa" permite que o usuário insira o nome de uma tarefa em uma caixa de diálogo. Quando a tarefa é adicionada, ela é armazenada na lista de tarefas. Cada tarefa é identificada com um código único que é automaticamente gerado e atribuído a ela.

-Remoção de Tarefas: O botão "Remover Tarefa" permite que o usuário especifique o índice da tarefa que deseja remover da lista. A tarefa correspondente é então excluída da lista, desde que o índice fornecido seja válido. Caso contrário, o aplicativo emite uma mensagem de "Índice inválido" para informar o usuário sobre o erro.

-Listagem de Tarefas: O botão "Listar Tarefas" permite que o usuário veja a lista de tarefas existentes. A lista é apresentada em uma caixa de diálogo que exibe o código e o nome de cada tarefa. Isso facilita o acompanhamento das tarefas disponíveis.

-Serialização em JSON: Dois botões, "Gerar JSON" e "Ler JSON", proporcionam funcionalidades de exportação e importação de dados. Quando o botão "Gerar JSON" é acionado, o aplicativo converte a lista de tarefas em formato JSON e a salva em um arquivo chamado "tarefas.json". Isso permite que o usuário exporte a lista de tarefas para um formato universalmente reconhecido.

-Leitura de Dados JSON: Quando o botão "Ler JSON" é pressionado, o aplicativo lê o conteúdo do arquivo "tarefas.json", se estiver disponível. Em seguida, ele converte o JSON de volta para objetos de tarefa e os armazena na lista de tarefas. Isso possibilita a importação de listas de tarefas previamente salvas.
