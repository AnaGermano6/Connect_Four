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
		for(Node child : list ){
			
			// calcula o valor da utilidade e depois guarda o valor
            int val = minValue(child); 
            System.out.println(child.depth + " " + val);
            if(val>v){
            	v=val;
            	System.out.println("ESCOLHI " + col);
            	col=Node.coluna;
            	
            }
        }
		return col;
	}

	//calcula o max
	public static int maxValue(Node no){
		
		int v = MENOS_INF;
		
		//terminal
		if((Node.jaGanhei(no)) || (Node.jaPerdi(no)) || (Node.haEmpate(no)) || (Node.isFinal(no))){
			System.out.println("utility" + Node.utility(no));
			return Node.utility(no);
		}
		list = Node.makedescendants(no, "X"); 
		for(Node child : list ){

			Node.printM(child);
			System.out.println("depth " + child.depth);
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.max(v, minValue(child));
            
          
        }		
		return v;
	}
	
	//calcula o min
	public static int minValue(Node no){
		
		int v = MAIS_INF;

		//terminal
		if((Node.jaGanhei(no)) || (Node.jaPerdi(no)) || (Node.haEmpate(no)) || (Node.isFinal(no))){
			System.out.println("utility" + Node.utility(no));
			return Node.utility(no);
		}
		
		
		list = Node.makedescendants(no, "O"); 
		
		for(Node child : list ){
			Node.printM(child);
			System.out.println("depth " + child.depth);
			
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.min(v, maxValue(child));
        }
		return v;
		
	}
}
