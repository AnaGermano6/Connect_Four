import java.util.*;

public class Node extends ConnectFour{
	//lista dos descendentes do tabuleiro
	private String matriz[][];
	public static int coluna;
	public static int utilidade;
	public int depth;
	public Node pai;

	
	Node(String[][] child, int depth, int coluna, int utilidade){
		this.matriz=child;
		this.depth=depth;
		this.coluna=coluna;
		this.utilidade=utilidade;
		this.pai=null;
	}
	
	Node(Node other){
		this.matriz=other.getMatriz();
	}
	

	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public void setMatriz(String[][] matriz) {
		this.matriz = matriz;
	}

	public String[][] getMatriz(){
		String [][] res = new String[6][];
		for (int i = 0; i < 6; i++) 
			res[i] = Arrays.copyOf(this.matriz[i], 6);
		return res;
	}
		
	//cria os descendentes
	public static LinkedList<Node> makedescendants(Node m, String simbolo){
		LinkedList<Node> descendentes = new LinkedList<Node>();
		int linha;
		for(int j=0; j<7; j++){
    		//verifica se a coluna esta cheia 
			if(!isColFull(m.matriz, j)){
				//o j representa a coluna onde se vai colocar a peca
				linha = lastPosition(m.matriz, j);
				if(linha!=-1){
					Node filho = newMatriz(linha, j, m, simbolo);
					descendentes.add(filho);
				}
				//m.matriz[linha][j]="-";
			}
			
		}
		
		return descendentes;
	}
	
	//verifica se a coluna esta cheia
	public static boolean isColFull(String m[][], int col){
		//ultima linha fixa 
		if(m[0][col].equals("X") || m[0][col].equals("O"))
			return true;
		return false;
	}
	
	//procura a ultima posicao preenchida
	public static int lastPosition(String m[][], int col){
		
		for(int i=5; i>=0; i--){
			if(!m[i][col].equals("X") && !m[i][col].equals("O"))
				//posicao para colocar a peca
				return i;
		}
		return -1;
	}
	
	
	//troca o "-" pela jogadas
	public static Node newMatriz(int x, int y, Node m, String simbolo){
		String[][] child= new String[6][7];
		
		//cria a nova matriz igual a anterior
		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				child[i][j]=m.matriz[i][j];
			}
		}
		
		
		child[x][y]=simbolo;
		
		//adiciona mais 1 nivel ao no pai
		Node copyM = new Node(child, m.depth+1, y, utilidade);
		copyM.pai=m;
				
		return copyM;
	}
	
	
	public static int utility(Node m){
		int contaX=0, contaO=0, sum=0;

		//verifica a utilidade das linhas
		for(int i=0; i<6;i++){
    	    for(int j=0; j<4; j++){
    	    	for(int k=0; k<4; k++){
    	    		if(m.matriz[i][j+k].equals("O")){
    	    			contaO++;
    	    		}
    	    		else if(m.matriz[i][j+k].equals("X")){
    	    			contaX++;
    	    		}
    	    	}
    	    	sum+= soma(contaX, contaO);
    	    	contaX=0;
    	    	contaO=0;
    	    }
		}

		//verifica a utilidade das colunas
		for(int j=0; j<7; j++){
		    for(int i=0; i<3; i++){
		    	for(int k=0; k<4; k++){
		    		if(m.matriz[i+k][j].equals("O")){
		    			contaO++;
		    		}
		    		else if(m.matriz[i+k][j].equals("X")){
		    			contaX++;
		    		}
		    	}
		    	sum+= soma(contaX, contaO);
    	    	contaX=0;
    	    	contaO=0;
		    }
		}

		//verifica a utilidade das diagonais (\)
		for(int i=0; i<3; i++){
		    for(int j=0; j<4; j++){
		    	for(int k=0; k<4; k++){
		    		if(m.matriz[i+k][j+k].equals("O")){
		    			contaO++;
		    		}
		    		else if(m.matriz[i+k][j+k].equals("X")){
		    			contaX++;
		    		}
		    	}
		    	sum+= soma(contaX, contaO);
    	    	contaX=0;
    	    	contaO=0;
		    }
		}

		//verifica a utilizadade das diagonais(/)
		for(int i=3; i<6; i++){
		    for(int j=0; j<4; j++){
		    	for(int k=0; k<4; k++){
		    		if(m.matriz [i-k][j+k].equals("O")){
		    			contaO++;
		    		}
		    		else if(m.matriz[i-k][j+k].equals("X")){
		    			contaX++;
		    		}
		    	}
			sum+= soma(contaX, contaO);
	    	contaX=0;
	    	contaO=0;
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

	//verifica se o computador ganhou
	public static boolean jaGanhei(Node m){

		int contaX = 0;
		//na horizontal
		for(int i=0; i<6; i++){
    	    for(int j=0; j<7; j++){

    	    	if(m.matriz[i][j].equals("X")){
    	    		contaX++;
    	    		if(contaX == 4){
    	    			return true;
    	    		}
    	    	}
			else
			    contaX = 0;
		    }
		    contaX = 0;
		}
		
		//na vertical
		for(int j=0; j<7;j++){
    	    for(int i=0; i<6; i++){
    		
    	    	if(m.matriz[i][j].equals("X")){
    	    		contaX++;
    	    		if(contaX == 4){
    	    			return true;
    	    		}
    	    	}
			else
			    contaX = 0;
		    }
		    contaX = 0;
		}
		
		//na diagonal \
		for(int i=0; i<3; i++){
	    	for(int j=0; j<4; j++){

	    		if(m.matriz[i][j].equals("X") && m.matriz[i+1][j+1].equals("X") && 
	    				m.matriz[i+2][j+2].equals("X") && m.matriz[i+3][j+3].equals("X")){
	    			return true;
	    		}
		    }
		}

		//na diagonal /
		for(int i=3; i<6; i++){
	    	for(int j=0; j<4; j++){

	    		if(m.matriz[i][j].equals("X") && m.matriz[i-1][j+1].equals("X") && 
	    				m.matriz[i-2][j+2].equals("X") && m.matriz[i-3][j+3].equals("X")){
	    			return true;
	    		}
		    }
		}
		return false;
	 }

	//quando o computador perde
	 public static boolean jaPerdi(Node m){

		int contaO = 0;
		//horizontais
		for(int i=0; i<6; i++){
	   	    for(int j=0; j<7; j++){

	   	    	if(m.matriz[i][j].equals("O")){
	   	    		contaO++;
	   	    		if(contaO == 4){
	   	    			return true;
	   	    		}
	   	    	}
	   	    	else
	   	    		contaO = 0;
	   	    }
		    contaO = 0;
		}
		//verticais
		for(int j=0; j<7;j++){
	        for(int i=0; i<6; i++){
	    		
	        	if(m.matriz[i][j].equals("O")){
	        		contaO++;
	        		if(contaO == 4){
	        			return true;
	        		}
	        	}
	        	else
			     contaO = 0;
		    }
		    contaO = 0;
		}
		//diagonais
		for(int i=0; i<3; i++){
	    	for(int j=0; j<4; j++){

	    		if(m.matriz[i][j].equals("O") && m.matriz[i+1][j+1].equals("O") && 
	    				m.matriz[i+2][j+2].equals("O") && m.matriz[i+3][j+3].equals("O")){
	    			return true;
	    		}
		    }
		}
		//diagonais
		for(int i=3; i<6; i++){
	    	for(int j=0; j<4; j++){

	    		if(m.matriz[i][j].equals("O") && m.matriz[i-1][j+1].equals("O") && 
	    				m.matriz[i-2][j+2].equals("O") && m.matriz[i-3][j+3].equals("O")){
	    			return true;
	    		}
		    }
		}
		return false;
	}

	//confirmar se aqui retorna um inteiro ou um booleano
	public static boolean haEmpate(Node m){
		int contador = 0;
		
    	for(int i=0; i<6; i++){
    		for(int j=0; j<7; j++){
    			if(!m.matriz[i][j].equals("-"))
    				contador++;
    		}
    	}
    	
    	//tamanho total do tabuleiro
    	if(contador == 42){
    		return true;
    	}
    	return false;
	}
	
	
	public static boolean isFinal(Node matriz){
		if(matriz.depth == 3)
		    return true;

		return false;
	}
	
	 public static void printM(Node m){
    	for(int i=0; i<6; i++){
    		for(int j=0; j<7; j++){
    			System.out.print(m.matriz[i][j]);
    		}
    		System.out.println();
    	}
    }
}