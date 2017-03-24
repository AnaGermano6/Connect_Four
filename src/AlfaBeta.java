import java.util.LinkedList;

public class AlfaBeta extends ConnectFour{
	private final static int MAIS_INF = Integer.MAX_VALUE;
	private final static int MENOS_INF = Integer.MIN_VALUE;
	public static LinkedList<Node> list = new LinkedList<Node>();
	
	//execucao do alfa-beta
	public static int alphaBetaSearch(String[][] m){
		int col=0;
		
		int alfa = MENOS_INF;
		int beta = MAIS_INF;
		int v = MENOS_INF;
		
		Node n = new Node(m,0,0);
		
		list = Node.makedescendants(n, "X");
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
			
			int val = maxValue(child, alfa, beta);
			
			if(val>v){
            	v=val;
            //	col=Node.coluna;
            	
            }
        }
		return col;
	}
	
	//calcula o max
	public static int maxValue(Node no, int alfa, int beta){
		int v = MENOS_INF;
		
		//terminal
		if((Node.jaGanhei(no)) || (Node.jaPerdi(no)) || (Node.haEmpate(no)) || (Node.isFinal(no)))
			return Node.utility(no);
		
		list = Node.makedescendants(no, "O"); 
		
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
		
		//terminal
		if((Node.jaGanhei(no)) || (Node.jaPerdi(no)) || (Node.haEmpate(no)) || (Node.isFinal(no)))
			return Node.utility(no);
		
		list = Node.makedescendants(no, "O"); 
		
		while(!list.isEmpty()){
			Node child = list.removeFirst();
			
			 v = Math.min(v,maxValue(child, alfa, beta)); 
			 
			 if(v<=alfa) 
				 //momento da poda
				 return v; 
			 beta = Math.min(beta, v);
		}
		return v;
	}
}
