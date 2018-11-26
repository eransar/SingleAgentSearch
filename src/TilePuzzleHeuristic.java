
public class TilePuzzleHeuristic implements IHeuristic {

	@Override
	public double getHeuristic
			(
					IProblemState problemState
			) {
		int sum=0;
		if (problemState instanceof TilePuzzleState) {
			int[][] ints1 = ((TilePuzzleState) problemState)._tilePuzzle;
			for (int i = 0; i < ints1.length; i++) {
				for (int k = 0; k < ints1.length; k++) {
					int row = (ints1[i][k]-1)/ints1.length;
					int col =(ints1[i][k]-1)%ints1.length;
					sum = sum + (Math.abs(i-row)+Math.abs(k-col))*ints1[i][k];
				}
			}
		}
		return sum;
	}
}
