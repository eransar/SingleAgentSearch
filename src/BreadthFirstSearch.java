import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch  extends ASearch
{
	// Define lists here ...
	Queue<ASearchNode> openList;
	Queue<ASearchNode> closeList;
	
	@Override
	public String getSolverName() 
	{
		return "BFS";
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
		openList = new LinkedList<>();
		closeList = new LinkedList<>();
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
