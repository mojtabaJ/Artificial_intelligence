package sample.aStar;

public class AStar {


    public static int heuristic(int[][] currentState, int[][] finalState) {
        int cost = 0;
        for(int i = 0; i < Core.rowSize; i++) {
            for(int j = 0; j < Core.rowSize; j++) {
                if(currentState[i][j]!= 0 && currentState[i][j] != finalState[i][j]) {
                    cost++;
                }
            }
        }
        return cost;
    }

}
