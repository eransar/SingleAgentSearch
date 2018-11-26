
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
					int div = ints1[i][k] / ints1.length;
					int mode = ints1[i][k] % ints1.length;
					if(k==ints1.length-1 && i==ints1.length-1)
						continue;
					if (mode == 0) {
						sum = sum+ (Math.abs(k - div)+Math.abs(i - mode + ints1.length))*ints1[i][k];
					} else {
						sum= sum+ (Math.abs(k - (div - 1)) + Math.abs(i - mode))*ints1[i][k];
					}
				}
			}
		}
		return sum;
	}
}
