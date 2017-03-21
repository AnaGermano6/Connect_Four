import java.util.LinkedList;

public class AlfaBeta {
	
	Tabuleiro tab = new Tabuleiro();
	LinkedList<Node> list = new LinkedList<Node>();
	
	
	/*
	function ALPHA-BETA-SEARCH(state): returns an action
	inputs: state → estado corrente no jogo
	v ← MAX-VALUE(state,-inf,+inf)
	return the action in SUCCESSORS(state) with value v
	function MAX-VALUE(state,alfa,beta) returns a utility value
	inputs: state, alfa → melhor alternativa para MAX, beta → melhor alternativa para MIN
	if TERMINAL TEST(state) then
	return UTILITY(state)
	end if
	v ← -infinito
	for s in SUCCESSORS(state) do
	v ← MAX(v, MIN-VALUE(s,alfa,beta))
	if (v >= beta ) then
	return v // momento da poda
	end if
	alfa ← MAX(alfa,v)
	end for
	return v
	function MIN-VALUE(state,alfa,beta) returns a utility value
	if TERMINAL TEST(state) then
	return UTILITY(state)
	end if
	v ← +infinito
	for s in SUCCESSORS(state) do
	v ← MIN(v, MAX-VALUE(s,alfa,beta))
	if (v <= alfa ) then
	return v // momento da poda
	end if
	beta ← MIN(beta,v)
	end for
	return v
	 */
	
	
	
	

}
