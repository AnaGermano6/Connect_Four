import java.util.LinkedList;

public class Minimax extends ConnectFour{
	
	Tabuleiro tab = new Tabuleiro();
	LinkedList<Node> list = new LinkedList<Node>();
	
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
	
	
	
	public Node decision(String m[][]){
		
		//gera os filhos
		list = Node.makedescendants(m); 
		
		int v = Integer.MAX_VALUE;
		
		
		for(Node n : list){
            v = Math.max(v,min(n)); // calcula o valor da utilidade e depois guarda o valor
            n.utility = v;
            
            if(n.utility==v)
            	return n;
        }		
		return null;
	}

	
	public int max(Node no){
		int v = Integer.MIN_VALUE;
		
		for(Node n : Node.makedescendants(no.matriz)){ //Para cada no gerado do utilizador vai guardar o valor minimo entre a utilidade do utilizador com a do CPU
            v = Math.min(v,min(n));
            n.utility = v; // guarda esse valor 
        }
		
		
		return v;
	}
	
	public int min(Node no){
		
		int v = Integer.MAX_VALUE;
		
		for(Node n : Node.makedescendants(no.matriz)){ //Para cada no gerado do utilizador vai guardar o valor minimo entre a utilidade do utilizador com a do CPU
            v = Math.min(v,max(n));
            n.utility = v; // guarda esse valor 
        }
		return v;
		
	}
}
