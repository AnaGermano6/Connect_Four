
public class Tabuleiro extends ConnectFour{
	public static String[][] matriz = new String[6][7];
	
	//inicia o tabuleiro 
    Tabuleiro(){
	
		for(int i=0; i<6; i++){
		    for(int j=0; j<7; j++){
		    	matriz[i][j]="-";
		    }
		}
	}
    
    
    //imprime a matriz
    public static void print(){
    	for(int i=0; i<6; i++){
    		for(int j=0; j<7; j++){
    			System.out.print(matriz[i][j]);
    		}
    		System.out.println();
    	}
    }

    
    //altera na matriz as jogadas 
    public static void altera(String simbolo, int coluna){

    	int i;
	
    	for(int j=0; j<7; j++){
    		if(j == coluna-1){
    			for(i=5; i>=0; i--){
    				//confere se a coluna esta cheia
    				if(matriz[i][j]!="X" && matriz[i][j]!="O"){
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
    public static boolean cheio(){

    	int contador = 0;
	
    	for(int i=0; i<6; i++){
    		for(int j=0; j<7; j++){
    			if(matriz[i][j] != "-")
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
    public static boolean quemGanhou(){

    	int contador1 = 0, contador2 = 0;

    	//verifica se ganhou nalguma linha
    	for(int i=0; i<6; i++){
    	    for(int j=0; j<7; j++){

    	    	if(matriz[i][j] == "O"){
    	    		contador1++;
    	    		if(contador1 == 4){
    	    			System.out.println("Ganhou o jogador 1!!");
    	    			return true;
    	    		}
    	    	}

    	    	else if(matriz[i][j] == "X"){
    	    		contador2++;
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
    	}

    	//verifica se ganhou nalguma coluna
    	for(int j=0; j<7;j++){
    	    for(int i=0; i<6; i++){
    		
    	    	if(matriz[i][j] == "O"){
    	    		contador1++;
    	    		if(contador1 == 4){
    	    			System.out.println("Ganhou o jogador 1!!");
    	    			return true;
    	    		}
    	    	}

    	    	else if(matriz[i][j] == "X"){
    	    		contador2++;
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
    	}

    	//verifica se ganhou nalguma diagonal (\)
    	for(int i=0; i<6; i++){
    	    for(int j=0; j<7; j++){

    	    	if(matriz[i][j] == "O"){
    	    		contador1++;
    	    		if(contador1 == 4){
    	    			System.out.println("Ganhou o jogador 1!!");
    	    			return true;
    	    		}
    	    	}

    	    	if(matriz[i][j] == "X"){
    	    		contador2++;
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
    	}

    	//verifica se ganhou noutra diagonal (/)
    	for(int i=5; i>=0; i--){
    	    for(int j=6; j>=0; j--){
    		
    	    	if(matriz[i][j] == "O"){
    	    		contador1++;
    	    		if(contador1 == 4){
    	    			System.out.println("Ganhou o jogador 1!!");
    	    			return true;
    	    		}
    	    	}

    	    	if(matriz[i][j] == "X"){
    	    		contador2++;
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
    	}
    	return false;
    }   
}
