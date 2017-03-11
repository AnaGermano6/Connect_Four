import java.util.*;

public class Node extends ConnectFour{
	//tabuleiro
	public static String matriz[][]= new String[6][7];
	//lista dos descendentes do tabuleiro
	public static LinkedList<Node> descendentes = new LinkedList<Node>();
	
	Node(String[][] m){
		matriz=m;
	}
	
	public String[][] getMatriz(){
		return matriz;
	}
	
	
	//imprime a matriz/tabuleiro do jogo inicial
	public static void printMatrizInicial(){
		
		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				matriz[i][j]="-";
				System.out.print(matriz[i][j]);
			}
			System.out.println();
		}
	}
	
	//imprime a matriz/tabuleiro do jogo
	//NAO ESTA ACABADA
	public static void printMatriz(){
		
		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				
				System.out.print(matriz[i][j]);
			}
		}
	}
	
	
	
	//cria os filhos
	public static LinkedList<Node> makedescendants(Node m){

		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				
				
				
			}
		}
		return descendentes;
	}
}