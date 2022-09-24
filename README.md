# Linguagem-Java-Projeto-Hearthstone
Projeto realizado na Disciplina de Programação Orientada a Objetos (MC202) da Universidade Estadual de Campinas.  O objetivo era criar uma classe 'Jogador' que incorporasse determinados comportamentos (cada qual com sua própria estratégia) a fim de alcançar mais de 50% de porcentagem de vitória sobre uma outra classe 'JogadorAleatorio', que seria basicamente a "máquina". 

No código em questão, o WinRate alcançado foi próximo aos 80%.

COMPORTAMENTO CONTROLE: 

	A implementacao do 'Comportamento de Controle' da classe JogadorRA238012 se da da seguinte maneira: 
	Primeiramente temos um grande trecho inicial, no qual é realizado a análise de trocas favoraveis a serem feitas, sendo elas
		(i)Troca na qual meu lacaio destroi um lacaio inimigo sem morrer; 
		(ii)Troca na qual meu lacaio destroi um lacaio inimigo com os dois morrendo no processo, porém o lacaio inimigo tem um maior custo de mana; 
		(iii) ambos morrem porém meu lacaio já havia sido sofrido dano anteriormente. 
	Basicamente, percorremos o ArrayList de lacaios aliados simultaneamente ao ArrayList de lacaios inimigos (sempre verificando a vida do lacaio inimigo antes de atacar
para termos a certeza de que ele é um alvo válido, ou seja, possui vida maior que zero). Apos realizarmos essa verificacao, buscamos entender se um ataque do lacaio aliado vigente contra o lacaio inimigo vigente nos trará algum
tipo de troca favoravel (citadas anteriormente). Caso isso aconteca, iremos aderir a troca favoravel adequada. Vale ressaltar o fato de que após cada ataque ha uma instrucao de 'break' para que nao aconteca do mesmo lacaio atacar
mais de um lacaio inimigo, visto que eh uma jogada invalida dentro do contexto do jogo.
	Caso nao hajam trocas favoraveis para o lacaio aliado em questao, ele eh instruido a atacar diretamente o heroi inimigo.
	Apos essa primeira fase na qual realizamos os ataques de lacaios, vamos realizar a analise das nossas cartas em mao, dando prioridade para baixar magias de area caso haja mais de dois lacaios inimigos (com vida maior que zero)
no campo de batalha (campo de batalha entende-se por 'mesa'). Portanto, percorremos o ArrayList das cartas em nossa mão, e caso haja uma magia de dano em area com custo de mana menor do que a mana do nosso jogador e 2 (ou mais) lacaios 
inimigos na mesa, invocaremos essa carta causando dano aos nossos inimigos. Em seguida, analisamos novamente a situacao das cartas em mao, caso haja uma magia de dano em alvo, a utilizaremos em lacaios inimigos, caso a diferenca de dano
da magia em questao e a vida atual do lacaio inimigo seja no maximo 1 (o lacaio inimigo obrigatoriamente deve possuir vida atual menor do que o dano da magia em questao), caso essa situacao se cumpra, invocaremos a carta e realizaremos
a jogada.
	Por fim, caso ainda nos reste mana e houver alguma magia do tipo Buff em nossa mao, buscaremos o lacaio aliado na mesa com maior ataque e o buffaremos a fim de deixa-lo ainda mais imponente (como nao estamos lidando com magias de efeito
unicos, por exemplo: magia que destroi qualquer lacaio inimigo independente de sua vida, entao intensificar as propriedades de dano e vida de um lacaio forte se mostra ser uma boa estratégia).
	Ao final de todos os comportamentos, temos um ultimo comando que invoca uma jogada de poder heroico no heroi inimigo, caso ainda haja mana para realizar a manobra. É um bom uso para nao desperdicar a mana restante naquele turno.

COMPORTAMENTO CURVA DE MANA:

	A implementacao de 'Comportamento Curva de Mana' da classe JogadorRA238012 se da da seguinte maneira:
	Primeiramente analisamos a mesa, buscando por trocas em que um lacaio aliado consiga destruir um lacaio inimigo sem morrer no processo. Caso esse tipo de troca seja viavel, nos a faremos, do contrario, o lacaio aliado vigente ira
atacar o heroi inimigo. 
	Em seguida, analisamos a nossa mao buscando por lacaios que possuam custo de mana igual a mana que possuimos naquele turno, caso haja, nos o invocaremos.
	Do contrário, utilizaremos 60% da nossa mana naquele momento para baixar um lacaio de custo de mana igual ou menor, e continuamos invocando lacaios ate que o custo de mana designado para esta atividade nao nos possibilite mais executar
essa jogada.
	Caso ainda nos reste mana, iremos buscar por magias de alvo na nossa mao, caso seja possivel baixa-las (custo de mana igual ou menor a mana que nos restou), iremos faze-lo. Inicialmente, buscando destruir lacaios inimigos, mas caso o dano
da magia nao seja o suficiente para tal, entao a utilizamos para atacar o lacaio inimigo de menor vida. Dessa forma, ao menos iremos fragilizar a linha adversaria.
	Novamente, caso ainda nos reste dois ou mais de mana, iremos utilizar o poder heroico diretamente no heroi inimigo.

COMPORTAMENTO AGRESSIVO:

	A implementacao de 'Comportamento Curva de Mana' da classe JogadorRA238012 se da da seguinte maneira:
	Primeiramente utilizamos todos os lacaios aliados na mesa para atacar o heroi inimigo.
	Em seguida, avaliamos a nossa mao naquele momento, buscando por lacaios de ataque alto (aqui defini ataque alto como sendo lacaios com 3 ou mais de ataque), enquanto houverem lacaios desse tipo disponiveis, iremos baixa-los tanto quanto
conseguirmos, até o momento em que nossa mana nao nos deixe descer mais.
	Por fim, caso ainda nos tenha restado dois ou mais de mana, utilizaremos ela para causar dano diretamente no heroi inimigo utilizando nosso poder heroico.
	
	Apos a implementacao desses tres comportamentos, nos restou assumir criterios para quando aplicar cada um.
	Eu particularmente não gosto da estrategia de controle, acredito que assumir uma postura passiva, "esperando" o inimigo montar uma horda de lacaios, para só depois destrui-los nao seja uma boa estrategia, por isso so a implementei em uma 
situacao hipotetica extremamente necessaria, na qual o nosso adversario possua 6 ou mais lacaios baixados na mesa.
	Com relacao aos outros dois comportamentos, utilizei como criterio a vida do heroi inimigo e fiz alguns testes para saber em qual "ponto" eles desempenhariam melhor. Logicamente, o "Curva de Mana" é o mais adequado para o inicio de jogo,
visto que ainda nao teremos tantos lacaios ou mana o suficiente para baixar lacaios de ataque alto. Portanto, o ponto de "virada" que utilizei foi Vida do Heroi Inimigo = 18, ou seja, caso a vida do heroi inimigo seja maior ou igual a 18, nõs
estaremos numa parte mais "inicial" da partida, e dessa forma, configura-se mais adequado o uso do comportamento curva de mana. Quando a vida do heroi inimigo for menor que 18, assumi que seria uma parte do jogo mais latente (caminhando para o fim),
e então o comportamento agressivo torna-se mais adequado, pois assim iremos encurra-lar nosso inimigo causando muito dano com os lacaios ja baixados na mesa e invocando lacaios cada vez mais fortes já que nesse momento do jogo teremos mais mana para
ser utilizada.
