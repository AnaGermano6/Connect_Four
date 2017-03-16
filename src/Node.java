/*import java.util.*;

public class Node extends ConnectFour{
	//lista dos descendentes do tabuleiro
	public static LinkedList<Node> descendentes = new LinkedList<Node>();
	
	
	Node(Node m){
		Node.matriz=m.matriz;
	}

	public String[][] getMatriz(){
		return matriz;
	}
	
	
	//cria os filhos
	public static LinkedList<Node> makedescendants(Node m){

		for(int i=0; i<6; i++){
			for(int j=0; j<7; j++){
				//enquanto o tabuleiro nao esta totalmente preenchido
				if(m.matriz[i][j]!="X" && m.matriz[i][j]!="O"){
					
					//incompleto
					//falta saber ao certo as posições do i e do j para mudar o simbolo
					Node filho = newMatriz(i, j, m);
					descendentes.addFirst(filho);					
				}			
			}
		}
		return descendentes;
	}
	
	
	//troca o "-" pela jogada do jogador humano ou computador
	public static Node newMatriz(int i, int j, Node m){
		
		//se o jogador for o X
		if(simbolo==1)
			m.matriz[i][j]="X";
		
		//se o jogador for o O
		else
			m.matriz[i][j]="O";
		
		return m;
	}
}*/