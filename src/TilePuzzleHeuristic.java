
public class TilePuzzleHeuristic implements IHeuristic {

	@Override
	public double getHeuristic
			(
					IProblemState problemState
			) {
		int x=0;
		int y=0;
		if (problemState instanceof TilePuzzleState) {
			int[][] ints1 = ((TilePuzzleState) problemState)._tilePuzzle;
			int[][] int2 = goAL(ints1.length);
			for (int i = 0; i < ints1.length; i++) {
				for (int k = 0; k < ints1.length; k++) {
					if (ints1[i][k] != int2[i][k]) {
						for (int p = 0; i < int2.length; i++) {
							for (int r = 0; k < int2.length; k++) {
								if (ints1[i][k] == int2[p][r]) {
									x= x+Math.abs(k-r);
									y= y+Math.abs(i-p);
								}
							}
						}
					}
				}
			}
		}
		return x+y;
	}

	private int[][] goAL (int size){
		int j = 1;
		int[][] ints = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int k = 0; k < size; k++) {
				ints[i][k] = j;
				j++;
			}
		}
		ints[size - 1][size - 1] = 0;
		return ints;
	}
}
