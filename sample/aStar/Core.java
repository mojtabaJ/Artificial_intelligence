package sample.aStar;

import sample.model.PuzzleState;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Core {

    public static void solve(int[][] initialState,int[][] finalState) {

        //لیست مراحل
        steps = new ArrayList<>();

        //پیدا کردن مکان خالی
        int x =0, y = 0;
        for(int i = 0; i < rowSize; i++) {
            for(int j = 0; j < rowSize; j++) {
                if(initialState[i][j] == 0) {
                    x = i;
                    y = j;
                }
            }
        }


        //init
        PriorityQueue<PuzzleState> pq = new PriorityQueue<>();
        PuzzleState root = new PuzzleState(initialState, x,y, x,y, 0, null);
        root.cost = AStar.heuristic(initialState, finalState);

        pq.offer(root);
        while(!pq.isEmpty()) {
            PuzzleState current = pq.poll();
            if(current.cost == 0) {
                Path.make(current);
                return;
            }
            for(int[] dir : DIR) {
                int newX = current.x+dir[0];
                int newY = current.y+dir[1];
                //از ماتریکس برون نزند
                if(isInMat(newX, newY)) {
                    PuzzleState child = new PuzzleState(current.matrix, current.x,current.y, newX, newY, current.step+1, current);
                    if(current.parent == null || !Path.write(current.parent.matrix).equals(Path.write(child.matrix))) {
                        child.cost = AStar.heuristic(child.matrix, finalState);
                        pq.offer(child);
                    }
                }
            }
        }
    }

    public static  boolean isInMat(int x, int y){
        return (x >= 0 && x < rowSize && y >= 0 && y < rowSize);
    }




    public static final int[][] DIR  = {{0,1},{1,0},{0,-1},{-1,0}};

    public static int rowSize;

    public static List<String> steps;

}
