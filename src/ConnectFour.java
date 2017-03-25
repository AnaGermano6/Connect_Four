import java.util.*;

/**
 * Connect Four 
 * 
 * @author Ana Coutinho up200303059
 * @author Ana Germano up201105083         
 */

public class ConnectFour {
	private static int escolha;
	private static int adversario;
	private static int jogador;
	private static int inicia;
	private static Tabuleiro tab;
	
	private static void instrucoes(){
		Scanner stdin = new Scanner(System.in);
		
		System.out.print("Escolha o adversario que pretende enfrentar:\n" +
						 "1 -> Outro adversario\n" + "2 -> Computador\n");
		
		//escolha do adversario
		adversario = stdin.nextInt();
		
		if(adversario==1){
			System.out.print("Escolha o jogador que inicia o jogo\n" + 
					         "0 -> Jogador 1\n" + "1 -> Jogador 2\n");
			
			jogador = stdin.nextInt();
			
			System.out.println("O jogador 1 vai jogar com o símbolo O e o jogador 2 com o símbolo X");
			System.out.println();
		}
		else if(adversario==2){
			//leitura da consola
			System.out.print("Escolha o algoritmo que pretende usar:\n" +
							 "1 -> Minimax\n" + "2 -> AlfaBeta\n");
			
			//escolha do algoritmo
			escolha = stdin.nextInt();
			
			if(escolha!=1 && escolha!=2){ //caso o numero de escolha seja diferente dos valores pedidos para a execucao
				System.out.println("Nao intruduziu um valor correcto, por favor intruduza o numero 1 ou o numero 2");
				return;
			}
			
			System.out.print("Escolha o jogador que inicia o jogo\n" + 
						     "1 -> Pessoa\n" + "2 -> Computador\n");
			
			inicia = stdin.nextInt();
			
			System.out.println("O jogador vai jogar com o símbolo O e o computador (jogador 2) com o símbolo X");
			System.out.println();
		}
		else{
			System.out.println("Nao intruduziu um valor correcto, por favor intruduza o numero 1 ou o numero 2");
		}
	}
	
	public static void main(String args[]){
		
		//le as instrucaoes na consola
		instrucoes();
		tab = new Tabuleiro();
		tab.print();
							
		//Comeca o jogo, no caso de ser duas pessoas
		if(adversario==1){
		
			while(true){

				if(jogador == 0)
					jog1();

				if(jogador == 1)
					jog2();

				if(tab.quemGanhou() || tab.cheio()) {
					System.out.println("Acabou o jogo!");
					break;
				}

				jogador = 1 - jogador;
			}
		}
		else{
			if(inicia==1){//pessoa
				while(true){

					jog1();
					if(tab.quemGanhou() || tab.cheio()) {
						System.out.println("Acabou o jogo!");
						break;
					}
					System.out.println("########Jogada Oponente#########");
					computer();
					
					if(tab.quemGanhou() || tab.cheio()) {
						System.out.println("Acabou o jogo!");
						break;
					}
				
				}
				
			}else if(inicia==2){//computador
				while(true){
					System.out.println("########Jogada Oponente#########");
					computer();

					if(tab.quemGanhou() || tab.cheio()) {
						System.out.println("Acabou o jogo!");
						break;
					}

					jog1();	
					
					if(tab.quemGanhou() || tab.cheio()) {
						System.out.println("Acabou o jogo!");
						break;
					}
				}
			}
			else{
				System.out.println("Nao intruduziu um valor correcto, por favor intruduza o numero 1 ou o numero 2");
			}
		}
	}
	
	//vez de jogar o jogador1
	private static void jog1(){
		Scanner stdin = new Scanner(System.in);
		
		System.out.println("Insira a coluna onde pretende jogar, jogador 1");
				
		int coluna = stdin.nextInt();

		int i;
		for(i=2; i>0; i--){
		    if(coluna > 7 || coluna < 1){
		    	System.out.printf("Inseriu um valor inválido, por favor insira um valor entre 1 e 7, tem mais %d tentativas\n", i);
		    	coluna = stdin.nextInt();
		    }
		    else{
		    	break;
		    }
		}

		if(i==0)
		    System.out.println("Acabaram as suas tentativas, perdeu a vez.");

		else {
		    tab.altera("O", coluna);

		    tab.print();

		}
		
	 }
	
	
	//vez de jogar o jogador 2
	private static void jog2(){
		Scanner stdin = new Scanner(System.in);

		System.out.println("Insira a coluna onde pretende jogar, jogador 2");

		int coluna = stdin.nextInt();

		int i;
		for(i=2; i>0; i--){
		    if(coluna > 7 || coluna < 1){
		    	System.out.printf("Inseriu um valor inválido, por favor insira um valor entre 1 e 7, tem mais %d tentativas\n", i);
		    	coluna = stdin.nextInt();
		    }
		    else {
		    	break;
		    }
		}
		
		if(i==0)
		    System.out.println("Acabaram as suas tentativas, perdeu a vez.");

		else {
		    tab.altera("X", coluna);
		    tab.print();
			System.out.println("########Jogada Oponente#########");
		}
	}
	
	//vez do computador jogar
	private static void computer(){
		int play;
		Minimax minmax = new Minimax();
		//escolha dos algoritmos
		if(escolha==1){ //Minimax
			play = minmax.decisionMinimax(tab.matriz);
			tab.altera("X", play);
			tab.print();
		}
		else{ //AlfaBeta
			AlfaBeta alfaBeta = new AlfaBeta();
			play = alfaBeta.alphaBetaSearch(tab.matriz);
			tab.altera("X", play);
			tab.print();

							
		}
		
			
	}
}
