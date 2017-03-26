import java.util.LinkedList;

public class AlfaBeta extends ConnectFour{
	private final static int MAIS_INF = Integer.MAX_VALUE;
	private final static int MENOS_INF = Integer.MIN_VALUE;

	
	//execucao do alfa-beta
	public int alphaBetaSearch(String[][] m){
		int col=0;
		LinkedList<Node> list;
		int alfa = MENOS_INF;
		int beta = MAIS_INF;
		int v = MENOS_INF;
		
		Node n = new Node(m,0,0,0);
		
		list = n.makedescendants(n, "X");
		
		for(Node child : list ){
			v = Math.max(v, minValue(child,alfa,beta));
			child.utilidade = v;

			if(v >= beta)
				break;
			alfa = Math.max(v,alfa);
        }

        for(Node child : list){
			if(child.utilidade==v){
				return child.getColuna()+1;
			}

		}
		return col;
	}
	
	//calcula o max
	private int maxValue(Node no, int alfa, int beta){
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
					
			 v = Math.max(v,minValue(child, alfa, beta));
			 child.utilidade = v;
			 if(v >= beta)
				 //momento da poda
				 return v;
			 alfa  = Math.max(alfa, v);
		}
		return v;
	}
	
	//calcula min
	private int minValue(Node no, int alfa, int beta){
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
			 v = Math.min(v,maxValue(child, alfa, beta));
			 child.utilidade = v;
			 
			 if(v<=alfa) 
				 //momento da poda
				 return v; 
			 beta = Math.min(beta, v);
		}
		return v;
	}
}
