import java.util.*;

public class Node extends ConnectFour{
	//tabuleiro
	public static String[][] matriz= new String[6][7];
	//lista dos descendentes do tabuleiro
	public static LinkedList<Node> descendentes = new LinkedList<Node>();
	
	Node(Node m){
		Node.matriz=m.matriz;
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
				//enquanto o tabuleiro nao esta totalmente preenchido
				while(m.matriz[i][j]!="X" || m.matriz[i][j]!="O"){
					
					//incompleto
					Node filho = newMatriz(i, j, m);
					descendentes.addFirst(filho);					
				}			
			}
		}
		return descendentes;
	}
	
	public static Node newMatriz(int i, int j, Node m){
		
		//se o jogador for o X
		if(simbolo==1)
			m.matriz[i][j]="X";
		//se o jogador for o O
		else
			Node.matriz[i][j]="O";
		
		return m;
	}
}