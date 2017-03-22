import java.util.LinkedList;

public class Minimax extends ConnectFour{
	private final static int MAIS_INF = Integer.MAX_VALUE;
	private final static int MENOS_INF = Integer.MIN_VALUE;
	
	//static Tabuleiro tab = new Tabuleiro();
	public static LinkedList<Node> list = new LinkedList<Node>();
	
	
	/*
	function MINIMAX DECISION(state): returns an action
	inputs: state → estado corrente no jogo
	v ← MAX-VALUE(state)
	return the action in SUCCESSORS(state) with value v
	
	function MAX-VALUE(state) returns a utility value
	if TERMINAL TEST(state) then
	return UTILITY(state)
	end if
	v ← -infinito
	for s in SUCCESSORS(state) do
	v ← MAX(v, MIN-VALUE(s))
	end for
	return v
	
	function MIN-VALUE(state) returns a utility value
	if TERMINAL TEST(state) then
	return UTILITY(state)
	end if
	v ← infinito
	for s in SUCCESSORS(state) do
	v ← MIN(v, MAX-VALUE(s))
	end for
	return v*/
	
	
	
	public static Node decision(String m[][]){
		
		//gera os filhos
		list = Node.makedescendants(m); 
		
		int v = MAIS_INF;
		
	/*	while(!list.isEmpty()){
			Node child = list.removeFirst();*/
			
			for(Node child : list){
			// calcula o valor da utilidade e depois guarda o valor
            v = Math.max(v,min(child)); 
            child.utility = v;
            
            if(child.utility==v)
            	return child;
        
		}
		return null;
	}

	
	public static int max(Node no){
		int v = MENOS_INF;
		
		//terminal
		//if(tab.cheio() || tab.quemGanhou()) //?????
		//	return no.utility;
		for(Node child : Node.makedescendants(no.matriz)){ //Para cada no gerado do utilizador vai guardar o valor minimo entre a utilidade do utilizador com a do CPU
            v = Math.min(v,min(child));
            child.utility = v; // guarda esse valor 
        }		
		return v;
	}
	
	public static int min(Node no){
		
		int v = MAIS_INF;
		
		//terminal ???
		
		for(Node child : Node.makedescendants(no.matriz)){ //Para cada no gerado do utilizador vai guardar o valor minimo entre a utilidade do utilizador com a do CPU
            v = Math.min(v,max(child));
            child.utility = v; // guarda esse valor 
        }
		return v;
		
	}
}
