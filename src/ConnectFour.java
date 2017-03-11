import java.util.*;

/**
 * Connect Four 
 * 
 * @author Ana Coutinho up200303059
 * @author Ana Germano up201105083         
 */

public class ConnectFour {
	public static int escolha;
	public static int jogador;
	public static int simbolo;
	
	public static void main(String args[]){
		Scanner stdin = new Scanner(System.in);
		
		//leitura da consola
		System.out.print("Escolha o algoritmo que pretende usar:\n" +
						 "1 -> Minimax\n" + "2 -> AlfaBeta\n");
		
		//escolha do algoritmo
		escolha = stdin.nextInt(); 
		
		System.out.print("Escolha o jogador que inicia o jogo\n" + 
						 "1 -> Humano\n" + "2 -> Computador\n");
		
		//escolha de quem inicia o jogo
		//1 é sempre o humana e o 2 é sempre o computador
		jogador = stdin.nextInt();
		
		System.out.print("Escolha um simbolo\n" +
						 "1 -> X\n" + "2 -> O\n");
		
		//escolha do simbolo
		//1 é sempre o X e o 2 é sempre a bola
		simbolo = stdin.nextInt();	
		
		
		switch(jogador){
		
			case 1: //imprime a matriz incial toda com tracinhos
					Node.printMatrizInicial();
					break;
			case 2: //imprime a mtriz com a jogada do computador
					
					break;
			default: //caso o numero de escolha seja diferente dos valores pedidos para a execucao
					 System.out.println("Nao intruduziu um valor correcto, por favor intruduza o numero 1 ou o numero 2");
					 break;	
		}
	}
	
}
