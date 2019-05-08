package sample.model;

public class PuzzleState implements Comparable< PuzzleState >{
    public PuzzleState parent;
    public int[][] matrix;
    public int x, y;
    public int cost;
    public int step;


    public PuzzleState(int[][] matrix, int x, int y, int newX, int newY, int step, PuzzleState parent){
        this.parent = parent;
        this.cost = Integer.MAX_VALUE;
        this.step = step;
        this.x = newX;
        this.y = newY;
        this.matrix = new int[matrix.length][matrix.length];
        for(int i=0; i < matrix.length;i++)
            this.matrix[i] = matrix[i].clone();
        int temp = this.matrix[x][y];
        this.matrix[x][y] = this.matrix[newX][newY];
        this.matrix[newX][newY] = temp;
    }


    @Override
    public int compareTo(PuzzleState that) {
        return (this.cost + this.step) - (that.cost+that.step);
    }
}