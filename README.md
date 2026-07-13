# acompanhamento-escolar-inteligencia-artificial
Sistema de Monitoramento Pedagógico do Uso de IA em Programação

Sistema em Java, orientado a objetos e baseado em vetores, para auxiliar professores no acompanhamento do uso de Inteligência Artificial pelos alunos em atividades de programação, com cálculo automático de risco pedagógico.

Sumário


Sobre o projeto
Funcionalidades
Estrutura do projeto
Modelo de classes
Regra de cálculo do risco pedagógico
Como executar
Menu do sistema
Ferramentas de IA utilizadas
Autores


Sobre o projeto

O sistema permite cadastrar alunos, registrar bolsistas de Iniciação Científica (IC), acompanhar o uso de IA em atividades de programação e calcular o risco pedagógico de cada estudante com base em indicadores objetivos. Também disponibiliza funções auxiliares como listagem de alunos, geração de lista de chamada e exibição de estatísticas da turma — tudo por meio de um menu interativo via terminal.

Funcionalidades


Cadastro de alunos e de bolsistas de Iniciação Científica
Registro do acompanhamento do uso de IA por aluno
Cálculo automático do risco pedagógico (baixo, moderado ou alto)
Listagem de alunos e de bolsistas cadastrados
Identificação do nome mais longo entre os alunos
Contagem de vogais nos nomes cadastrados
Cálculo do percentual de alunos por curso
Cálculo da média de idade da turma
Criação e exibição de lista de chamada (ordenada alfabeticamente)
Listagem de alunos classificados em risco alto
Exibição de estatísticas gerais da turma


Estrutura do projeto

Main.java              # Menu interativo e ponto de entrada do programa
acompanhamentoIA.java  # Núcleo funcional: cadastros, cálculos, listagens e estatísticas
Aluno.java             # Dados acadêmicos do estudante
BolsistaIC.java        # Dados do aluno bolsista de Iniciação Científica
Pessoa.java            # Dados pessoais básicos (nome, idade, local de nascimento)

Modelo de classes

O sistema é organizado em cinco classes que se relacionam por composição. A classe Pessoa armazena os dados pessoais básicos do estudante: nome, idade e local de nascimento. A classe Aluno representa o estudante cadastrado na turma e possui um objeto Pessoa, além de atributos próprios como curso, matrícula, semestre, ano e um campo booleano indicando se o aluno é bolsista de Iniciação Científica. A classe BolsistaIC representa o aluno vinculado a um projeto de Iniciação Científica, possuindo um objeto Aluno, além do nome do projeto e do orientador responsável. A classe acompanhamentoIA registra o uso de IA nas atividades do aluno — atividades entregues, uso declarado de IA, explicações corretas, modificações feitas sem ajuda e conteúdos ainda não estudados — e também concentra os métodos estáticos responsáveis pelas principais operações do sistema, como cadastros, cálculo de risco, listagens e estatísticas, funcionando como o núcleo funcional do programa. Por fim, a classe Main é responsável por exibir o menu interativo, capturar a escolha do usuário e direcionar a execução para os métodos correspondentes nas demais classes.

Regra de cálculo do risco pedagógico

O risco é calculado a partir de quatro indicadores percentuais, calculados sobre o total de atividades entregues:


Percentual de atividades feitas com uso de IA
Percentual de atividades explicadas corretamente
Percentual de códigos modificados sem ajuda
Percentual de entregas com conteúdos ainda não estudados


Para cada condição satisfeita, é somado 1 ponto: se o percentual de atividades feitas com uso de IA for maior que 60%; se o percentual de atividades explicadas corretamente for menor que 40%; se o percentual de códigos modificados sem ajuda for menor que 40%; e se o percentual de entregas com conteúdo ainda não estudado for maior que 60%.

Ao final, a soma dos pontos define a classificação: 0 pontos resulta em risco baixo, 1 ou 2 pontos resultam em risco moderado, e 3 ou 4 pontos resultam em risco alto.

Como executar

Pré-requisito: JDK instalado (Java 8 ou superior).

bash# Compilar todas as classes
javac *.java

# Executar o programa
java Main

Menu do sistema

1  - Cadastrar aluno
2  - Cadastrar bolsista de IC
3  - Registrar acompanhamento do uso de IA
4  - Listar todos os alunos
5  - Listar bolsistas de IC
6  - Mostrar nome mais longo
7  - Contar vogais nos nomes cadastrados
8  - Percentual de alunos por curso
9  - Média de idade dos alunos
10 - Criar ou atualizar lista de chamada
11 - Exibir lista de chamada
12 - Calcular risco pedagógico relacionado ao uso de IA
13 - Exibir alunos em risco alto
14 - Estatística da turma
0  - Sair

Ao iniciar, o sistema já carrega cinco alunos de exemplo (três deles bolsistas de IC) para permitir testar as funcionalidades imediatamente.

Autor:

Lorenzo Luís Postal
