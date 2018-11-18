import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class UniformCostSearch   extends ASearch
{
	// Define lists here ...
	PriorityQueue<ASearchNode> openList;
	PriorityQueue<ASearchNode> closeList;

	@Override
	public String getSolverName() 
	{
		return "UCS";
	}

	@Override
	public ASearchNode createSearchRoot
	(
		IProblemState problemState
	) 
	{
		ASearchNode newNode = new BlindSearchNode(problemState);
		return newNode;
	}
	
	@Override
	public void initLists() 
	{

		openList = new PriorityQueue<ASearchNode>( new Comparator<ASearchNode>() {
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
		closeList = new PriorityQueue<ASearchNode>( new Comparator<ASearchNode>() {
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
		if(openList.contains(node))
			return node;
		return null;
	}

	@Override
	public boolean isOpen
	(
		ASearchNode node
	) 
	{
		if(openList.contains(node))
			return true;
		return false;
	}
	
	@Override
	public boolean isClosed
	(
		ASearchNode node
	) 
	{
		if(closeList.contains(node))
			return true;
		return false;
	}

	@Override
	public void addToOpen
	(
		ASearchNode node
	) 
	{
		openList.add(node);
	}

	@Override
	public void addToClosed
	(
		ASearchNode node
	) 
	{
		closeList.add(node);
	}

	@Override
	public int openSize() 
	{
		return openList.size();

	}

	@Override
	public ASearchNode getBest()
	{
		return openList.remove();
	}

}
