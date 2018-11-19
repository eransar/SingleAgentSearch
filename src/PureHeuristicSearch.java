import java.util.Comparator;
import java.util.PriorityQueue;

public class PureHeuristicSearch  extends ASearch
{
	PriorityQueue<HeuristicSearchNode> open;
	PriorityQueue<HeuristicSearchNode> close;
	// Define lists here ...
	
	@Override
	public String getSolverName() 
	{
		return "PHS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new HeuristicSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{
		open = new PriorityQueue<HeuristicSearchNode>( new Comparator<ASearchNode>() {
			public int compare(ASearchNode n1, ASearchNode n2) {
				// compare n1 and n2
				if(n1.getG() > n2.getG()){
					return 1;
				}
				else if(n1.getG()==n2.getG()){
					return 0;
				}
				else{
					return -1;
				}
			}});
		close = new PriorityQueue<HeuristicSearchNode>( new Comparator<ASearchNode>() {
			public int compare(ASearchNode n1, ASearchNode n2) {
				// compare n1 and n2
				if(n1.getG() > n2.getG()){
					return 1;
				}
				else if(n1.getG()==n2.getG()){
					return 0;
				}
				else{
					return -1;
				}
			}});
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
		if(open.contains( node))
			return node;
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) {
		if (open.contains(node))
			return true;
		return false;
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		if (close.contains(node))
			return true;
		return false;
	}

	

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		open.add((HeuristicSearchNode)node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		close.add((HeuristicSearchNode)node);
	}

	@Override
	public int openSize() 
	{
		return open.size();
	}

	@Override
	public ASearchNode getBest() 
	{
		return open.remove();
	}

}