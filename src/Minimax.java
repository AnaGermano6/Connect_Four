import java.util.LinkedList;

public class Minimax extends ConnectFour{
	private final static int MAIS_INF = Integer.MAX_VALUE;
	private final static int MENOS_INF = Integer.MIN_VALUE;
	public static LinkedList<Node> list = new LinkedList<Node>();
	
	//execucao do Minimax
	public static int decisionMinimax(String m[][]){
		
		//gera os filhos
		list = Node.makedescendants(m, "X"); 
		
		int v = MAIS_INF;
		Node child = new Node(m);
		
		//verifica para cada no da lista dos descendentes 
		while(!list.isEmpty()){
			child = list.removeFirst();
			
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.max(v,minValue(child)); 
            
            //guardar a coluna
		}
		return Node.col;
	}

	//calcula o max
	public static int maxValue(Node no){
		
		int v = MENOS_INF;
		
		list = Node.makedescendants(no.matriz, "O"); 
		
		//terminal???
		/*f TERMINAL TEST(state) then
		return UTILITY(state)
		end if*/
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
			
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.min(v,minValue(child));
          
        }		
		return v;
	}
	
	//calcula o min
	public static int minValue(Node no){
		
		int v = MAIS_INF;
		
		list = Node.makedescendants(no.matriz, "O"); 
		
		//terminal???
		/*if TERMINAL TEST(state) then
		return UTILITY(state)
		end if*/
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
		
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.min(v,maxValue(child));
        }
		return v;
		
	}
}
