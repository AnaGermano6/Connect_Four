import java.util.*;

public class Minimax extends ConnectFour{
	private final static int MAIS_INF = Integer.MAX_VALUE;
	private final static int MENOS_INF = Integer.MIN_VALUE;
	public static LinkedList<Node> list = new LinkedList<Node>();
	
	//execucao do Minimax
	public static int decisionMinimax(String m[][]){
		int col=0;
		
		Node n = new Node(m,0);
		//gera os filhos
		list = Node.makedescendants(n, "X"); 
		
		int v = MENOS_INF;
		
		//verifica para cada no da lista dos descendentes 
		while(!list.isEmpty()){
			Node child = list.removeFirst();
			
			// calcula o valor da utilidade e depois guarda o valor
            int val = minValue(child); 
            
            if(val>v){
            	v=val;
            	col=Node.coluna;
            	
            }
        }
		return col;
	}

	//calcula o max
	public static int maxValue(Node no){
		
		int v = MENOS_INF;
		
		//terminal
		if((Node.jaGanhei(no)) || (Node.jaPerdi(no)) || (Node.haEmpate(no)) || (Node.isFinal(no)))
			return Node.utility(no);
		
		list = Node.makedescendants(no, "X"); 
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
			
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.max(v, minValue(child));
          
        }		
		return v;
	}
	
	//calcula o min
	public static int minValue(Node no){
		
		int v = MAIS_INF;

		//terminal
		if((Node.jaGanhei(no)) || (Node.jaPerdi(no)) || (Node.haEmpate(no)) || (Node.isFinal(no)))
			return Node.utility(no);
		
		list = Node.makedescendants(no, "O"); 
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
		
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.min(v, maxValue(child));
        }
		return v;
		
	}
}
