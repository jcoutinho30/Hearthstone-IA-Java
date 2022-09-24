/*TEXTO SOBRE O C”DIGO: 

COMPORTAMENTO CONTROLE: 

	A implementacao do 'Comportamento de Controle' da classe JogadorRA238012 se da da seguinte maneira: 
	Primeiramente temos um grande trecho inicial, no qual È realizado a an·lise de trocas favoraveis a serem feitas, sendo elas
		(i)Troca na qual meu lacaio destroi um lacaio inimigo sem morrer; 
		(ii)Troca na qual meu lacaio destroi um lacaio inimigo com os dois morrendo no processo, porÈm o lacaio inimigo tem um maior custo de mana; 
		(iii) ambos morrem porÈm meu lacaio j· havia sido sofrido dano anteriormente. 
	Basicamente, percorremos o ArrayList de lacaios aliados simultaneamente ao ArrayList de lacaios inimigos (sempre verificando a vida do lacaio inimigo antes de atacar
para termos a certeza de que ele È um alvo v·lido, ou seja, possui vida maior que zero). Apos realizarmos essa verificacao, buscamos entender se um ataque do lacaio aliado vigente contra o lacaio inimigo vigente nos trar· algum
tipo de troca favoravel (citadas anteriormente). Caso isso aconteca, iremos aderir a troca favoravel adequada. Vale ressaltar o fato de que apÛs cada ataque ha uma instrucao de 'break' para que nao aconteca do mesmo lacaio atacar
mais de um lacaio inimigo, visto que eh uma jogada invalida dentro do contexto do jogo.
	Caso nao hajam trocas favoraveis para o lacaio aliado em questao, ele eh instruido a atacar diretamente o heroi inimigo.
	Apos essa primeira fase na qual realizamos os ataques de lacaios, vamos realizar a analise das nossas cartas em mao, dando prioridade para baixar magias de area caso haja mais de dois lacaios inimigos (com vida maior que zero)
no campo de batalha (campo de batalha entende-se por 'mesa'). Portanto, percorremos o ArrayList das cartas em nossa m„o, e caso haja uma magia de dano em area com custo de mana menor do que a mana do nosso jogador e 2 (ou mais) lacaios 
inimigos na mesa, invocaremos essa carta causando dano aos nossos inimigos. Em seguida, analisamos novamente a situacao das cartas em mao, caso haja uma magia de dano em alvo, a utilizaremos em lacaios inimigos, caso a diferenca de dano
da magia em questao e a vida atual do lacaio inimigo seja no maximo 1 (o lacaio inimigo obrigatoriamente deve possuir vida atual menor do que o dano da magia em questao), caso essa situacao se cumpra, invocaremos a carta e realizaremos
a jogada.
	Por fim, caso ainda nos reste mana e houver alguma magia do tipo Buff em nossa mao, buscaremos o lacaio aliado na mesa com maior ataque e o buffaremos a fim de deixa-lo ainda mais imponente (como nao estamos lidando com magias de efeito
unicos, por exemplo: magia que destroi qualquer lacaio inimigo independente de sua vida, entao intensificar as propriedades de dano e vida de um lacaio forte se mostra ser uma boa estratÈgia).
	Ao final de todos os comportamentos, temos um ultimo comando que invoca uma jogada de poder heroico no heroi inimigo, caso ainda haja mana para realizar a manobra. … um bom uso para nao desperdicar a mana restante naquele turno.

COMPORTAMENTO CURVA DE MANA:

	A implementacao de 'Comportamento Curva de Mana' da classe JogadorRA238012 se da da seguinte maneira:
	Primeiramente analisamos a mesa, buscando por trocas em que um lacaio aliado consiga destruir um lacaio inimigo sem morrer no processo. Caso esse tipo de troca seja viavel, nos a faremos, do contrario, o lacaio aliado vigente ira
atacar o heroi inimigo. 
	Em seguida, analisamos a nossa mao buscando por lacaios que possuam custo de mana igual a mana que possuimos naquele turno, caso haja, nos o invocaremos.
	Do contr·rio, utilizaremos 60% da nossa mana naquele momento para baixar um lacaio de custo de mana igual ou menor, e continuamos invocando lacaios ate que o custo de mana designado para esta atividade nao nos possibilite mais executar
essa jogada.
	Caso ainda nos reste mana, iremos buscar por magias de alvo na nossa mao, caso seja possivel baixa-las (custo de mana igual ou menor a mana que nos restou), iremos faze-lo. Inicialmente, buscando destruir lacaios inimigos, mas caso o dano
da magia nao seja o suficiente para tal, entao a utilizamos para atacar o lacaio inimigo de menor vida. Dessa forma, ao menos iremos fragilizar a linha adversaria.
	Novamente, caso ainda nos reste dois ou mais de mana, iremos utilizar o poder heroico diretamente no heroi inimigo.

COMPORTAMENTO AGRESSIVO:

	A implementacao de 'Comportamento Curva de Mana' da classe JogadorRA238012 se da da seguinte maneira:
	Primeiramente utilizamos todos os lacaios aliados na mesa para atacar o heroi inimigo.
	Em seguida, avaliamos a nossa mao naquele momento, buscando por lacaios de ataque alto (aqui defini ataque alto como sendo lacaios com 3 ou mais de ataque), enquanto houverem lacaios desse tipo disponiveis, iremos baixa-los tanto quanto
conseguirmos, atÈ o momento em que nossa mana nao nos deixe descer mais.
	Por fim, caso ainda nos tenha restado dois ou mais de mana, utilizaremos ela para causar dano diretamente no heroi inimigo utilizando nosso poder heroico.
	
	Apos a implementacao desses tres comportamentos, nos restou assumir criterios para quando aplicar cada um.
	Eu particularmente n„o gosto da estrategia de controle, acredito que assumir uma postura passiva, "esperando" o inimigo montar uma horda de lacaios, para sÛ depois destrui-los nao seja uma boa estrategia, por isso so a implementei em uma 
situacao hipotetica extremamente necessaria, na qual o nosso adversario possua 6 ou mais lacaios baixados na mesa.
	Com relacao aos outros dois comportamentos, utilizei como criterio a vida do heroi inimigo e fiz alguns testes para saber em qual "ponto" eles desempenhariam melhor. Logicamente, o "Curva de Mana" È o mais adequado para o inicio de jogo,
visto que ainda nao teremos tantos lacaios ou mana o suficiente para baixar lacaios de ataque alto. Portanto, o ponto de "virada" que utilizei foi Vida do Heroi Inimigo = 18, ou seja, caso a vida do heroi inimigo seja maior ou igual a 18, nıs
estaremos numa parte mais "inicial" da partida, e dessa forma, configura-se mais adequado o uso do comportamento curva de mana. Quando a vida do heroi inimigo for menor que 18, assumi que seria uma parte do jogo mais latente (caminhando para o fim),
e ent„o o comportamento agressivo torna-se mais adequado, pois assim iremos encurra-lar nosso inimigo causando muito dano com os lacaios ja baixados na mesa e invocando lacaios cada vez mais fortes j· que nesse momento do jogo teremos mais mana para
ser utilizada.
*/ 


import java.util.ArrayList;

/**
* Esta classe representa um Jogador aleat√≥rio (realiza jogadas de maneira aleat√≥ria) para o jogo LaMa (Lacaios & Magias).
* @see java.lang.Object
* @author Rafael Arakaki - MC302
*/
public class JogadorRA238012 extends Jogador {
	private ArrayList<CartaLacaio> lacaios;
	private ArrayList<CartaLacaio> lacaiosOponente;
	
	/**
	  * O m√©todo construtor do JogadorAleatorio.
	  * 
	  * @param maoInicial Cont√©m a m√£o inicial do jogador. Deve conter o n√∫mero de cartas correto dependendo se esta classe Jogador que est√° sendo constru√≠da √© o primeiro ou o segundo jogador da partida. 
	  * @param primeiro   Informa se esta classe Jogador que est√° sendo constru√≠da √© o primeiro jogador a iniciar nesta jogada (true) ou se √© o segundo jogador (false).
	  */
	public JogadorRA238012(ArrayList<Carta> maoInicial, boolean primeiro){
		primeiroJogador = primeiro;
		
		mao = maoInicial;
		lacaios = new ArrayList<CartaLacaio>();
		lacaiosOponente = new ArrayList<CartaLacaio>();
		
		// Mensagens de depura√ß√£o:
		System.out.println("*Classe JogadorRA238012* Sou o " + (primeiro?"primeiro":"segundo") + " jogador (classe: JogadorRA238012)");
		System.out.println("Mao inicial:");
		for(int i = 0; i < mao.size(); i++)
			System.out.println("ID " + mao.get(i).getID() + ": " + mao.get(i));
	}
	
	/**
	  * Um m√©todo que processa o turno de cada jogador. Este m√©todo deve retornar as jogadas do Jogador decididas para o turno atual (ArrayList de Jogada).
	  * 
	  * @param mesa   O "estado do jogo" imediatamente antes do in√≠cio do turno corrente. Este objeto de mesa cont√©m todas as informa√ß√µes 'p√∫blicas' do jogo (lacaios vivos e suas vidas, vida dos her√≥is, etc).
	  * @param cartaComprada   A carta que o Jogador recebeu neste turno (comprada do Baralho). Obs: pode ser null se o Baralho estiver vazio ou o Jogador possuir mais de 10 cartas na m√£o.
	  * @param jogadasOponente   Um ArrayList de Jogada que foram os movimentos utilizados pelo oponente no √∫ltimo turno, em ordem.
	  * @return            um ArrayList com as Jogadas decididas
	  */
	public ArrayList<Jogada> processarTurno (Mesa mesa, Carta cartaComprada, ArrayList<Jogada> jogadasOponente){
		int minhaMana, minhaVida;
		if(cartaComprada != null)
			mao.add(cartaComprada);
		if(primeiroJogador){
			minhaMana = mesa.getManaJog1();
			minhaVida = mesa.getVidaHeroi1();
			lacaios = mesa.getLacaiosJog1();
			lacaiosOponente = mesa.getLacaiosJog2();
			//System.out.println("--------------------------------- Comeco de turno pro jogador1");
		}
		else{
			minhaMana = mesa.getManaJog2();
			minhaVida = mesa.getVidaHeroi2();
			lacaios = mesa.getLacaiosJog2();
			lacaiosOponente = mesa.getLacaiosJog1();
			//System.out.println("--------------------------------- Comeco de turno pro jogador2");
		}
		
		ArrayList<Jogada> minhasJogadas = new ArrayList<Jogada>();
		
		int vidaHeroiInimigo = primeiroJogador ? mesa.getVidaHeroi2(): mesa.getVidaHeroi1();
		ArrayList<CartaLacaio> lacaiosOponente2 = primeiroJogador ? mesa.getLacaiosJog2(): mesa.getLacaiosJog1();
		
		//Posturas adotadas durante a partida.
		if(lacaiosOponente2.size() >= 6)
			return comportamentoControle(mesa, cartaComprada, jogadasOponente, minhasJogadas);
		if(vidaHeroiInimigo >= 18)
			return comportamentoCurvaDeMana(mesa, cartaComprada, jogadasOponente, minhasJogadas);
		if(vidaHeroiInimigo < 18)
			return comportamentoAgressivo(mesa, cartaComprada, jogadasOponente, minhasJogadas);
		
		return comportamentoCurvaDeMana(mesa, cartaComprada, jogadasOponente, minhasJogadas);
	}
	
	public ArrayList<Jogada> comportamentoControle(Mesa mesa, Carta cartaComprada, ArrayList<Jogada> jogadasOponente, ArrayList<Jogada> minhasJogadas){
		ArrayList<CartaLacaio> meusLacaios = primeiroJogador ? mesa.getLacaiosJog1() : mesa.getLacaiosJog2();
		ArrayList<CartaLacaio> seusLacaios = primeiroJogador ? mesa.getLacaiosJog2() : mesa.getLacaiosJog1();
		int minhaMana = primeiroJogador ? mesa.getManaJog1() : mesa.getManaJog2();
		
		//Realizando trocas favoraveis
		for(int i = 0; i < meusLacaios.size(); i++) {
			int ataqueiLacaio = 1;
			for(int j = 0; j < seusLacaios.size(); j++) {
				//Meu lacaio destroi lacaio do oponente sem morrer no processo
				if(meusLacaios.get(i).getAtaque() >= seusLacaios.get(j).getVidaAtual() && meusLacaios.get(i).getVidaAtual() > seusLacaios.get(j).getAtaque() && seusLacaios.get(j).getVidaAtual() > 0) {
					Jogada atk = new Jogada(TipoJogada.ATAQUE, meusLacaios.get(i), seusLacaios.get(j));
					minhasJogadas.add(atk);
					meusLacaios.get(i).setVidaAtual(meusLacaios.get(i).getVidaAtual() - seusLacaios.get(j).getAtaque());
					seusLacaios.get(j).setVidaAtual(0);
					ataqueiLacaio = 0;
					break;
				}
				//Ambos morrem mas o custo de mana do lacaio inimigo È maior
				if(meusLacaios.get(i).getAtaque() >= seusLacaios.get(j).getVidaAtual() && meusLacaios.get(i).getMana() < seusLacaios.get(j).getMana() && seusLacaios.get(j).getVidaAtual() > 0) {
					Jogada atk = new Jogada(TipoJogada.ATAQUE, meusLacaios.get(i), seusLacaios.get(j));
					minhasJogadas.add(atk);
					meusLacaios.get(i).setVidaAtual(0);
					seusLacaios.get(j).setVidaAtual(0);
					ataqueiLacaio = 0;
					break;
				}
				//Ambos morrem mas meu lacaio ja estava danificado e tem menos vida do que o lacaio inimigo
				if(meusLacaios.get(i).getAtaque() >= seusLacaios.get(j).getVidaAtual() && meusLacaios.get(i).getVidaMaxima() > meusLacaios.get(i).getVidaAtual() && meusLacaios.get(i).getVidaAtual() < seusLacaios.get(j).getVidaAtual() && seusLacaios.get(j).getVidaAtual() > 0) {
					Jogada atk = new Jogada(TipoJogada.ATAQUE, meusLacaios.get(i), seusLacaios.get(j));
					minhasJogadas.add(atk);
					meusLacaios.get(i).setVidaAtual(0);
					seusLacaios.get(j).setVidaAtual(0);
					ataqueiLacaio = 0;
					break;
				}
				//Nao ha trocas favoraveis, deve-se atacar o heroi inimigo
				if(ataqueiLacaio == 1) {
					Jogada atk = new Jogada(TipoJogada.ATAQUE, meusLacaios.get(i), null);
					minhasJogadas.add(atk);
					break;
				}
			}
		}
		
		//Usando magias
		for(int i = 0; i < mao.size(); i++) {
			if(mao.get(i) instanceof CartaMagia && mao.get(i).getMana() <= minhaMana) {
				CartaMagia magia = (CartaMagia) mao.get(i);
				//Usando magia de area quando houver dois ou mais lacaios inimigos no campo de batalha
				if(magia.getMagiaTipo() == TipoMagia.AREA) {
					int qtdLacInimigos = 0;
					//Cria um contador para checar com eficiencia os lacaios inimigos que ainda estao efetivamente vivos
					for(int j = 0; j < seusLacaios.size(); j++) {
						if(seusLacaios.get(j).getVidaAtual() > 0)
							qtdLacInimigos++;
					}
					if(qtdLacInimigos >= 2) {
						Jogada magiaArea = new Jogada(TipoJogada.MAGIA, magia, null);
						minhasJogadas.add(magiaArea);
						minhaMana -= magia.getMana();
						mao.remove(magia);
						i--;
					}
				}
				//Usando magia de alvo para matar lacaios inimigos em situacoes favoraveis
				if(magia.getMagiaTipo() == TipoMagia.ALVO) {
					for(int j = 0; j < seusLacaios.size(); j++) {
						if(seusLacaios.get(j).getVidaAtual() > 0 && (magia.getMagiaDano() - seusLacaios.get(j).getVidaAtual()) <= 1 && seusLacaios.get(j).getVidaAtual() < magia.getMagiaDano()) {
							Jogada magiaAlvo = new Jogada(TipoJogada.MAGIA, magia, seusLacaios.get(j));
							minhasJogadas.add(magiaAlvo);
							minhaMana -= magia.getMana();
							mao.remove(magia);
							seusLacaios.get(j).setVidaAtual(0);
							i--;
							break;
						}
					}
				}
			}
		}
		
		//Nao usei magia de area e nem alvo, entao se houver um buff, usarei em algum lacaio aliado
		for(int i = 0; i < mao.size(); i++) {
			if(mao.get(i) instanceof CartaMagia && mao.get(i).getMana() <= minhaMana) {
				CartaMagia magia = (CartaMagia) mao.get(i);
				if(magia.getMagiaTipo() == TipoMagia.BUFF) {
					//escolhendo meu lacaio de maior ataque para deixa-lo ainda mais imponente
					int maiorAtaque = 0;
					for(int j = 0; j < meusLacaios.size(); j++) {
						if(j > 0 && meusLacaios.get(j).getAtaque() > meusLacaios.get(j-1).getAtaque() && meusLacaios.get(j).getVidaAtual() > 0 && meusLacaios.get(j-1).getVidaAtual() > 0) {
							maiorAtaque = meusLacaios.get(j).getAtaque();
						}
						if(j == 0 && meusLacaios.get(j).getVidaAtual() > 0)
							maiorAtaque = meusLacaios.get(j).getAtaque();
					}
					//Apos encontrar o lacaio de maior ataque, iremos buffa-lo
					for(int k = 0; k < meusLacaios.size(); k++) {
						if(meusLacaios.get(k).getAtaque() == maiorAtaque && meusLacaios.get(k).getVidaAtual() > 0) {
							Jogada buff = new Jogada(TipoJogada.MAGIA, magia, meusLacaios.get(k));
							minhasJogadas.add(buff);
							minhaMana -= magia.getMana();
							mao.remove(magia);
							i--;
							break;
						}
					}
				}
			}
		}
		//usando poder heroico se sobrar algo
		if(minhaMana >= 2) {
			Jogada poderHeroico = new Jogada(TipoJogada.PODER, null, null);
			minhasJogadas.add(poderHeroico);
			minhaMana = minhaMana -2;
		}
		return minhasJogadas;
	}
	
	public ArrayList<Jogada> comportamentoCurvaDeMana(Mesa mesa, Carta cartaComprada, ArrayList<Jogada> jogadasOponente, ArrayList<Jogada> minhasJogadas){
		ArrayList<CartaLacaio> meusLacaios = primeiroJogador ? mesa.getLacaiosJog1() : mesa.getLacaiosJog2();
		ArrayList<CartaLacaio> seusLacaios = primeiroJogador ? mesa.getLacaiosJog2() : mesa.getLacaiosJog1();
		int qtdMeusLacaios = primeiroJogador ? mesa.getLacaiosJog1().size() : mesa.getLacaiosJog2().size();
		int minhaMana = primeiroJogador ? mesa.getManaJog1() : mesa.getManaJog2();
		int lacIgualMana = 1;
		int mateiLacaio = 1;
		
		//Matando algum Lacaio adversario ou Atacando o heroi inimigo
		for(int i = 0; i < meusLacaios.size(); i++) {
			int mateiLacaio2 = 1;
			for(int j = 0; j < seusLacaios.size(); j++) {
				if(meusLacaios.get(i).getAtaque() >= seusLacaios.get(j).getVidaAtual() && meusLacaios.get(i).getVidaAtual() > seusLacaios.get(j).getAtaque() && seusLacaios.get(j).getVidaAtual() > 0) {
					Jogada ataque = new Jogada(TipoJogada.ATAQUE, meusLacaios.get(i), seusLacaios.get(j));
					meusLacaios.get(i).setVidaAtual(meusLacaios.get(i).getVidaAtual() - seusLacaios.get(j).getAtaque());
					seusLacaios.get(j).setVidaAtual(0);
					minhasJogadas.add(ataque);
					mateiLacaio2 = 0;
					break;
				}
			}
			//Meu lacaio nao mata nenhum lacaio inimigo sem morrer, entao ele ira atacar o heroi inimigo
			if(mateiLacaio2 == 1) {
				Jogada ataqueHeroi = new Jogada(TipoJogada.ATAQUE, meusLacaios.get(i), null);
				minhasJogadas.add(ataqueHeroi);
			}
		}
		
		for(int i = 0; i < mao.size(); i++) {
			if(mao.get(i) instanceof CartaLacaio && mao.get(i).getMana() == minhaMana && qtdMeusLacaios < 7) {
				//Baixando um Lacaio de custo de mana igual ‡ minha mana naquele turno
				Jogada lac = new Jogada(TipoJogada.LACAIO, mao.get(i), null);
				minhaMana = 0;
				minhasJogadas.add(lac);
				mao.remove(mao.get(i));
				i--;
				qtdMeusLacaios++;
				lacIgualMana = 0;
				
				return minhasJogadas;
			}
		}
		//Utilizando 60% da mana para baixar um lacaio e o restante para usar uma magia
		if(lacIgualMana == 1) {
			int manaLac = (int) (minhaMana*(0.6));
			//Baixando lacaio com custo de mana igual a 60% da minha mana atual ou menos
			for(int i = 0; i < mao.size(); i++) {
				if(mao.get(i) instanceof CartaLacaio && mao.get(i).getMana() <= manaLac && qtdMeusLacaios < 7) {
					Jogada lac = new Jogada(TipoJogada.LACAIO, mao.get(i), null);
					minhaMana -= mao.get(i).getMana();
					mao.remove(mao.get(i));
					i--;
					qtdMeusLacaios++;
					minhasJogadas.add(lac);
					manaLac = minhaMana;
				}
			}
			//Baixando magia com o restante de mana
			for(int i = 0; i < mao.size(); i++) {
				if(mao.get(i) instanceof CartaMagia && mao.get(i).getMana() <= minhaMana) {
					CartaMagia cartaMagia = (CartaMagia) mao.get(i);
					if(cartaMagia.getMagiaTipo() == TipoMagia.ALVO) {
						for(int j = 0; j < seusLacaios.size(); j++) {
							//Destruindo um lacaio inimigo com magia de alvo
							if(cartaMagia.getMagiaDano() >= seusLacaios.get(j).getVidaAtual() && (seusLacaios.get(j).getVidaAtual() > 0)) {
								mateiLacaio = 0;
								Jogada magiaAlvo = new Jogada(TipoJogada.MAGIA, cartaMagia, seusLacaios.get(j));
								minhaMana -= cartaMagia.getMana();
								minhasJogadas.add(magiaAlvo);
								mao.remove(cartaMagia);
								i--;
								seusLacaios.get(j).setVidaAtual(0);
								break;
							}
						}
					}
				}
			}
			if(mateiLacaio == 1) {
				for(int i = 0; i < mao.size(); i++) {
					if(mao.get(i) instanceof CartaMagia && mao.get(i).getMana() <= minhaMana) {
						CartaMagia cartaMagia = (CartaMagia) mao.get(i);
						if(cartaMagia.getMagiaTipo() == TipoMagia.ALVO) {
							//Atacar o lacaio inimigo de menor vida
							int lacMenorVida2 = 0;
							if(seusLacaios.size() > 0)
								lacMenorVida2 = seusLacaios.get(0).getVidaAtual();
							for(int j = 0; j < seusLacaios.size(); j++) {
								if(j > 0 && seusLacaios.get(j).getVidaAtual() < seusLacaios.get(j-1).getVidaAtual()) 
									lacMenorVida2 = seusLacaios.get(j).getVidaAtual();
							}
							for(int k = 0; k < seusLacaios.size(); k++) {
								if(seusLacaios.get(k).getVidaAtual() == lacMenorVida2 && lacMenorVida2 > 0) {
									Jogada magiaAlvo = new Jogada(TipoJogada.MAGIA, cartaMagia, seusLacaios.get(k));
									minhaMana -= cartaMagia.getMana();
									minhasJogadas.add(magiaAlvo);
									mao.remove(cartaMagia);
									i--;
									break;
								}
							}
						}
					}
				}
			}
		}
		if(minhaMana >= 2) {
			Jogada poderHeroico = new Jogada(TipoJogada.PODER, null, null);
			minhasJogadas.add(poderHeroico);
			minhaMana = minhaMana -2;
		}
		return minhasJogadas;
	}
	
	//Metodo que descreve o funcionamento do comportamento agressivo
	public ArrayList<Jogada> comportamentoAgressivo (Mesa mesa, Carta cartaComprada, ArrayList<Jogada> jogadasOponente, ArrayList<Jogada> minhasJogadas) {
		ArrayList<CartaLacaio> meusLacaios = primeiroJogador ? mesa.getLacaiosJog1() : mesa.getLacaiosJog2();

		int minhaMana = primeiroJogador ? mesa.getManaJog1() : mesa.getManaJog2();
		int qtdMeusLacaios = primeiroJogador ? mesa.getLacaiosJog1().size() : mesa.getLacaiosJog2().size();
		
		//Usando todos os meus Lacaios em mesa para atacar o heroi inimigo
		for(int i = 0; i < meusLacaios.size(); i++) {
			Jogada ataque = new Jogada(TipoJogada.ATAQUE, meusLacaios.get(i), null);
			minhasJogadas.add(ataque);
		}
		
		for(int i = 0; i < mao.size(); i++) {
			Carta card = mao.get(i);
			//Comportamento agressivo visando baixar lacaio de ataque alto
			if(card instanceof CartaLacaio && card.getMana() <= minhaMana) {
				CartaLacaio lacAux = (CartaLacaio) card;
				if(lacAux.getAtaque() >= 3 && qtdMeusLacaios < 7) {
					Jogada lac = new Jogada(TipoJogada.LACAIO, card, null);
					minhasJogadas.add(lac);
					minhaMana -= card.getMana();
					mao.remove(card);
					qtdMeusLacaios++;
					i--;
				}
			}
		}
		
		//Comportamento agressivo visando baixar magias de alvo
		for(int i = 0; i < mao.size(); i++) {
			Carta card = mao.get(i);
			if(card instanceof CartaMagia && card.getMana() <= minhaMana) {
				CartaMagia cartaMagia = (CartaMagia) card;
				if(cartaMagia.getMagiaTipo() == TipoMagia.ALVO) {
					Jogada mag = new Jogada(TipoJogada.MAGIA, card, null);
					minhasJogadas.add(mag);
					minhaMana -= card.getMana();
					mao.remove(card);
					i--;
				}
			}
		}
		if(minhaMana >= 2) {
			Jogada poderHeroico = new Jogada(TipoJogada.PODER, null, null);
			minhasJogadas.add(poderHeroico);
		}
		return minhasJogadas;
	}
	
	
	
	
	
	
}