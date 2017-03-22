import java.util.*;

public class Node extends ConnectFour{
	//lista dos descendentes do tabuleiro
	public static LinkedList<Node> descendentes = new LinkedList<Node>();
	public static String matriz[][];
	public int utility;
	
	
	Node(String[][] child){
		Node.matriz=child;
	}

	public String[][] getMatriz(){
		return matriz;
	}
	
	public static void printNode(String[][] matriz){
    	for(int i=0; i<6; i++){
    		for(int j=0; j<7; j++){
    			System.out.print(matriz[i][j]);
    		}
    		System.out.println();
    	}
    }
	
	
	//cria os descendentes
	public static LinkedList<Node> makedescendants(String m[][], String simbolo){

		for(int j=0; j<7; j++){
    		//verifica se a coluna esta cheia 
			if(!isColFull(m)){
				//o j representa a coluna onde se vai colocar a peca
				int linha = lastPosition(m, j);
				Node filho = new Node(newMatriz(linha, j, m, simbolo));
				descendentes.addFirst(filho);					
			}
		}
		return descendentes;
	}
	
	
	//troca o "-" pela jogadas
	public static String[][] newMatriz(int x, int y, String[][] m, String simbolo){
		String[][] child= new String[6][7];
		
		//cria a nova matriz igual a anterior
		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				child[i][j]=m[i][j];
			}
		}
		
		//muda nas coordenadas
		if(simbolo.equals("O"))
			child[x][y]="O";
		if(simbolo.equals("X"))
			child[x][y]="X";
		
		return child;
	}
	
	//verifica se a coluna esta cheia
	public static boolean isColFull(String m[][]){
		
		for(int j=0; j<7; j++){
			//ultima linha fixa 
			if(m[5][j].equals("X") || m[5][j].equals("O"))
				return true;
		}
		return false;
	}
	
	//procura a ultima posicao preenchida
	public static int lastPosition(String m[][], int col){
		
		for(int i=6; i<0; i--){
			if(m[i][col].equals("X") || m[i][col].equals("O"))
				return i+1;
		}
		return -1;
	}
}