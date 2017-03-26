import java.util.*;

public class Minimax extends ConnectFour{
	private final int MAIS_INF = Integer.MAX_VALUE;
	private final int MENOS_INF = Integer.MIN_VALUE;

	
	//execucao do Minimax
	public int decisionMinimax(String m[][]){
		LinkedList<Node> list;
		Node n = new Node(m,0,0,0);
		//gera os filhos
		list = n.makedescendants(n, "X");
		
		int v = MENOS_INF;
		
		//verifica para cada no da lista dos descendentes 
		for(Node child : list ){
			
			// calcula o valor da utilidade e depois guarda o valor
			v = Math.max(v,minValue(child));
			child.utilidade=v;
		}
		
		for(Node child : list){
            
            if(child.utilidade==v){
            	return child.getColuna()+1;
            }
        }
		return -1;
	}

	//calcula o max
	private int maxValue(Node no){
		
		int v = MENOS_INF;


		//terminal
		if(no.jaGanhei(no))
			return 512;
		if(no.jaPerdi(no))
			return -512;
		if(no.haEmpate(no))
			return 0;
		if(no.isFinal(no)){
			return no.utility(no);
		}

		LinkedList<Node> filhosGerados =  no.makedescendants(no, "X");
		for(Node child : filhosGerados){
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.max(v, minValue(child));
            child.utilidade = v;
            
          
        }		
		return v;
	}
	
	//calcula o min
	private int minValue(Node no){
		
		int v = MAIS_INF;

		//terminal
		if(no.jaGanhei(no))
			return 512;
		if(no.jaPerdi(no))
			return -512;
		if(no.haEmpate(no))
			return 0;
		if(no.isFinal(no)){
			return no.utility(no);
		}

		LinkedList<Node> filhosGerados =  no.makedescendants(no, "O");
		for(Node child : filhosGerados){
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.min(v, maxValue(child));
            child.utilidade = v;
        }
		return v;
		
	}
}
