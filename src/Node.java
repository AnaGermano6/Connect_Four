import java.util.*;

public class Node extends ConnectFour{
	//lista dos descendentes do tabuleiro
	public static LinkedList<Node> descendentes = new LinkedList<Node>();
	public static String matriz[][];
	public static int coluna;
	public static int depth;
	public Node pai;

	
	Node(String[][] child, int depth){
		this.matriz=child;
		this.depth=depth;
		this.pai=null;
	}

	public static void setMatriz(String[][] matriz) {
		Node.matriz = matriz;
	}

	public String[][] getMatriz(){
		return matriz;
	}
		
	//cria os descendentes
	public static LinkedList<Node> makedescendants(String m[][], String simbolo){

		for(int j=0; j<7; j++){
    		//verifica se a coluna esta cheia 
			if(!isColFull(m, j)){
				//o j representa a coluna onde se vai colocar a peca
				int linha = lastPosition(m, j);
				Node filho = newMatriz(linha, j, m, simbolo);
				descendentes.addFirst(filho);					
			}
		}
		return descendentes;
	}
	
	//verifica se a coluna esta cheia
	public static boolean isColFull(String m[][], int col){
		
		for(int j=0; j<7; j++){
			//ultima linha fixa 
			if(m[5][col].equals("X") || m[5][col].equals("O"))
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
	
	
	//troca o "-" pela jogadas
	public static Node newMatriz(int x, int y, String[][] m, String simbolo){
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
		
		Node copyM = new Node(child, m.depth+1);
		//adiciona mais 1 nivel ao no pai
		copyM.pai=m;
		
		return copyM;
	}
	
	
	 public static int utility(String matriz[][]){
			int contaX=0, contaO=0, sum=0;

			//verifica a utilidade das linhas
			for(int i=0; i<6;i++){
		    	    for(int j=0; j<4; j++){
				for(int k=0; k<4; k++){
				    if(matriz[i][j+k].equals("O")){
					contaO++;
				    }
				    else if(matriz[i][j+k].equals("X")){
					contaX++;
				    }
				}
				sum+= soma(contaX, contaO);
			    }
			}

			//verifica a utilidade das colunas
			for(int j=0; j<7; j++){
			    for(int i=0; i<3; i++){
				for(int k=0; k<4; k++){
				    if(matriz[i+k][j].equals("O")){
					contaO++;
				    }
				    else if(matriz[i+k][j].equals("X")){
					contaX++;
				    }
				}
				sum+= soma(contaX, contaO);
			    }
			}

			//verifica a utilidade das diagonais (\)
			for(int i=0;i<3; i++){
			    for(int j=0; j<4; j++){
				for(int k=0; k<4; k++){
				    if(matriz[i+k][j+k].equals("O")){
					contaO++;
				    }
				    else if(matriz[i+k][j+4].equals("X")){
					contaX++;
				    }
				}
				sum+= soma(contaX, contaO);
			    }
			}

			//verifica a utilizadade das diagonais(/)
			for(int i=3; i<6; i++){
			    for(int j=0; j<4; j++){
				for(int k=0; k<4; k++){
				    if(matriz [i-k][j+k].equals("O")){
					contaO++;
				    }
				    else if(matriz[i-k][j+k].equals("X")){
					contaX++;
				    }
				}
				sum+= soma(contaX, contaO);
			    }
			}
			return sum;
		    }

		    public static int soma(int contadorX, int contadorO){
			if(contadorX == 3 && contadorO == 0)
			    return 50;
			else if(contadorO == 3 && contadorX == 0)
			    return -50;
			else if(contadorX == 2 && contadorO == 0)
			    return 10;
			else if(contadorO == 2 && contadorX == 0)
			    return -10;
			else if(contadorX == 1 && contadorO == 0)
			    return 1;
			else if(contadorO == 1 && contadorX == 0)
			    return -1;
			else
			    return 0;
		    }

		    public static int jaGanhei(String matriz[][]){

			int contaX = 0;
			
			for(int i=0; i<6; i++){
		    	    for(int j=0; j<7; j++){

		    	    	if(matriz[i][j] == "X"){
		    	    		contaX++;
		    	    		if(contaX == 4){
		    	    			return 512;
		    	    		}
		    	    	}
				else
				    contaX = 0;
			    }
			    contaX = 0;
			}

			for(int j=0; j<7;j++){
		    	    for(int i=0; i<6; i++){
		    		
		    	    	if(matriz[i][j] == "X"){
		    	    		contaX++;
		    	    		if(contaX == 4){
		    	    			return 512;
		    	    		}
		    	    	}
				else
				    contaX = 0;
			    }
			    contaX = 0;
			}
			
			for(int i=0; i<3; i++){
		    	    for(int j=0; j<4; j++){

				if(matriz[i][j].equals("X") && matriz[i+1][j+1].equals("X") && matriz[i-2][j+2].equals("X") && matriz[i-3][j+3].equals("X")){
				    return 512;
				}
			    }
			}

			for(int i=3; i<6; i++){
		    	    for(int j=0; j<4; j++){

				if(matriz[i][j].equals("X") && matriz[i+1][j+1].equals("X") && matriz[i-2][j+2].equals("X") && matriz[i-3][j+3].equals("X")){
				    return 512;
				}
			    }
			}
			return 0;
		    }

		    public static int jaPerdi(String matriz[][]){

			int contaO = 0;
			
			for(int i=0; i<6; i++){
		    	    for(int j=0; j<7; j++){

		    	    	if(matriz[i][j] == "O"){
		    	    		contaO++;
		    	    		if(contaO == 4){
		    	    			return -512;
		    	    		}
		    	    	}
				else
				    contaO = 0;
			    }
			    contaO = 0;
			}

			for(int j=0; j<7;j++){
		    	    for(int i=0; i<6; i++){
		    		
		    	    	if(matriz[i][j] == "O"){
		    	    		contaO++;
		    	    		if(contaO == 4){
		    	    			return -512;
		    	    		}
		    	    	}
				else
				    contaO = 0;
			    }
			    contaO = 0;
			}
			
			for(int i=0; i<3; i++){
		    	    for(int j=0; j<4; j++){

				if(matriz[i][j].equals("O") && matriz[i+1][j+1].equals("O") && matriz[i-2][j+2].equals("O") && matriz[i-3][j+3].equals("O")){
				    return -512;
				}
			    }
			}

			for(int i=3; i<6; i++){
		    	    for(int j=0; j<4; j++){

				if(matriz[i][j].equals("O") && matriz[i+1][j+1].equals("O") && matriz[i-2][j+2].equals("O") && matriz[i-3][j+3].equals("O")){
				    return -512;
				}
			    }
			}
			return 0;
		    }

		    //confirmar se aqui retorna um inteiro ou um booleano
		    public static boolean haEmpate(String matriz[][]){
			int contador = 0;
			
		    	for(int i=0; i<6; i++){
		    		for(int j=0; j<7; j++){
		    			if(matriz[i][j] != "-")
		    				contador++;
		    		}
		    	}
		    	//tamanho total do tabuleiro
		    	if(contador == 42){
			    return true;
			}
		    	return false;
		    }
		    public static boolean isFinal(Node matriz[][]){
			if(matriz.de == 5)
			    return true;

			return false;
		    }
}