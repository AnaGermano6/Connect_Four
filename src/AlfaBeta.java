import java.util.LinkedList;

public class AlfaBeta extends ConnectFour{
	private final static int MAIS_INF = Integer.MAX_VALUE;
	private final static int MENOS_INF = Integer.MIN_VALUE;
	public static LinkedList<Node> list = new LinkedList<Node>();
	
	//execucao do alfa-beta
	public static String[][] alphaBetaSearch(String[][] m){
		
		int alfa = MENOS_INF;
		int beta = MAIS_INF;
		Node child = new Node(m);
		
		list = Node.makedescendants(m, "X");
		
		while(!list.isEmpty()){
			child = list.removeFirst();
			
			int v = maxValue(child, alfa, beta);
		}
		
		return child.matriz;
	}
	
	//calcula o max
	public static int maxValue(Node no, int alfa, int beta){
		int v = MENOS_INF;
		
		list = Node.makedescendants(no.matriz, "O");
		
		/* TERMINAL
		if TERMINAL TEST(state) then
		return UTILITY(state)
		end if
		*/
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
			
			 v = Math.max(v,minValue(child, alfa, beta));
			 
			 if(v >= alfa) 
				 //momento da poda
				 return v;
			 alfa  = Math.max(alfa, v);
		}
		return v;
	}
	
	//calcula min
	public static int minValue(Node no, int alfa, int beta){
		int v = MAIS_INF;
		
		list = Node.makedescendants(no.matriz, "O");
		
		/* TERMINAL
		if TERMINAL TEST(state) then
		return UTILITY(state)
		end if
		*/
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
			
			 v = Math.max(v,maxValue(child, alfa, beta)); 
			 
			 if(v<=alfa) 
				 //momento da poda
				 return v; 
			 beta = Math.min(beta, v);
		}
		return v;
	}
}
