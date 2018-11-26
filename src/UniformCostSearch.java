import java.util.*;

public class UniformCostSearch   extends ASearch
{
	// Define lists here ...
	PriorityQueue<ASearchNode> openList;
	Queue<ASearchNode> closeList;

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
		closeList = new ArrayDeque<>();
	}

	@Override
	public ASearchNode getOpen
	(
		ASearchNode node
	) 
	{
			for (ASearchNode node1 : openList)
			{
				if(node.equals(node1)){
					return node1;
				}
			}
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
