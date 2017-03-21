import java.util.*;

public class Node extends ConnectFour{
	//lista dos descendentes do tabuleiro
	public static LinkedList<Node> descendentes = new LinkedList<Node>();
	public static String matriz[][];
	//public int utility;
	public int utility;
	
	
	Node(String[][] child){
		Node.matriz=child;
	}

	public String[][] getMatriz(){
		return matriz;
	}
	
	
	//cria os filhos
	public static LinkedList<Node> makedescendants(String m[][]){

		for(int j=0; j<7; j++){
    		//if(j == coluna-1){
    			for(int i=5; i>=0; i--){
				//enquanto o tabuleiro nao esta totalmente preenchido
				if(m[i][j]!="X" && m[i][j]!="O"){
					
					//incompleto
					//falta saber ao certo as posições do i e do j para mudar o simbolo
					String child[][] = newMatriz(i, j, m);
					Node filho = new Node(child);
					descendentes.addFirst(filho);					
				}			
			}
		}
		return descendentes;
	}
	
	
	//troca o "-" pela jogada do computador
	public static String[][] newMatriz(int i, int j, String[][] m){
		
		//CPU é o X
		m[i][j]="X";	
		
		return m;
	}
}