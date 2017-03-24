
public class Tabuleiro extends ConnectFour{
	public String[][] matriz = new String[6][7];
	
	//inicia o tabuleiro 
    Tabuleiro(){
	
		for(int i=0; i<6; i++){
		    for(int j=0; j<7; j++){
		    	matriz[i][j]="-";
		    }   
		}
	}
    
    
    //imprime a matriz
    public void print(){
    	for(int i=0; i<6; i++){
    		for(int j=0; j<7; j++){
    			System.out.print(matriz[i][j]);
    		}
    		System.out.println();
    	}
    }

    
    //altera na matriz as jogadas 
    public void altera(String simbolo, int coluna){

    	int i;
	
    	for(int j=0; j<7; j++){
    		if(j == coluna-1){
    			for(i=5; i>=0; i--){
    				//confere se a coluna esta cheia
    				if(!matriz[i][j].equals("X") && !matriz[i][j].equals("O")){
    					matriz[i][j] = simbolo;
    					break;
    				}
    			}
    			if(i<0){
    				System.out.println("Jogada inválida! Perdeu a sua vez!");
    				System.out.println();
    			}
    		}
    	}
    }

    
    //verifica se o tabuleiro esta cheio, para caso de empate
    public boolean cheio(){

    	int contador = 0;
	
    	for(int i=0; i<6; i++){
    		for(int j=0; j<7; j++){
    			if(!matriz[i][j].equals("-"))
    				contador++;
    		}
    	}
    	//tamanho total do tabuleiro
    	if(contador == 42){
    		System.out.println("Houve um empate!!!");
    		return true;
    	}
    	else
    		return false;
    }
    
    //verifica o vencedor
    public boolean quemGanhou(){

    	int contador1 = 0, contador2 = 0;

    	//verifica se ganhou nalguma linha
    	for(int i=0; i<6; i++){
    	    for(int j=0; j<7; j++){

    	    	if(matriz[i][j].equals("O")){
    	    		contador1++;
    	    		contador2=0;
    	    		if(contador1 == 4){
    	    			System.out.println("Ganhou o jogador 1!!");
    	    			return true;
    	    		}
    	    	}

    	    	else if(matriz[i][j].equals("X")){
    	    		contador2++;
    	    		contador1=0;
    	    		if(contador2 == 4){
    	    			System.out.println("Ganhou o jogador 2!!");
    	    			return true;
    	    		}
    	    	}
    		
    	    	else {
    	    		contador1 = 0;
    	    		contador2 = 0;
    	    	}
    	    }
    	    contador1 = 0;
    		contador2 = 0;
    	}

    	//verifica se ganhou nalguma coluna
    	for(int j=0; j<7;j++){
    	    for(int i=0; i<6; i++){
    		
    	    	if(matriz[i][j].equals("O")){
    	    		contador1++;
    	    		contador2=0;
    	    		if(contador1 == 4){
    	    			System.out.println("Ganhou o jogador 1!!");
    	    			return true;
    	    		}
    	    	}

    	    	else if(matriz[i][j].equals("X")){
    	    		contador2++;
    	    		contador1=0;
    	    		if(contador2 == 4){
    	    			System.out.println("Ganhou o jogador 2!!");
    	    			return true;
    	    		}
    	    	}
    		
    	    	else {
    	    		contador1 = 0;
    	    		contador2 = 0;
    	    	}
    	    }
    	    contador1 = 0;
    		contador2 = 0;
    	}

    	//verifica se ganhou nalguma diagonal (\)
    	for(int i=0; i<3; i++){
    	    for(int j=0; j<4; j++){
    	    	
    	    	if(matriz[i][j].equals("O")  && matriz[i+1][j+1].equals("O") && 
    	    			matriz[i+2][j+2].equals("O") && matriz[i+3][j+3].equals("O")){
	    			System.out.println("Ganhou o jogador 1!!");
	    			return true;
    	    	}

    	    	if(matriz[i][j].equals("X") && matriz[i+1][j+1].equals("X") && 
    	    			matriz[i+2][j+2].equals("X") && matriz[i+3][j+3].equals("X")){
    	    		System.out.println("Ganhou o jogador 2!!");
	    			return true;
    	    	}
    	    } 
    	    
    	}

    	//verifica se ganhou noutra diagonal (/)
    	for(int i=3; i<6; i++){
    	    for(int j=0; j<4; j++){
    	    	
    	    	
    	    	if(matriz[i][j].equals("O") && matriz[i-1][j+1].equals("O") && 
    	    			matriz[i-2][j+2].equals("O") && matriz[i-3][j+3].equals("O")){
    	    			System.out.println("Ganhou o jogador 1!!");
    	    			return true;
    	    	}

    	    	if(matriz[i][j].equals("X") && matriz[i-1][j+1].equals("X") && 
    	    			matriz[i-2][j+2].equals("X") && matriz[i-3][j+3].equals("X")){
    	    			System.out.println("Ganhou o jogador 2!!");
    	    			return true;
    	    	}
    	    
    	    }
    	}
    	return false;
    }  
}
