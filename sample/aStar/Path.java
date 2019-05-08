package sample.aStar;

import sample.model.PuzzleState;

public class Path {

    public static String write(int[][] matrix) {
        String result = "";
        for(int i=0; i < Core.rowSize; i++) {
            for(int j=0; j < Core.rowSize ; j++) {
                result += matrix[i][j]+",";
            }
        }
        return result;
    }

    public static void make(PuzzleState root) {
        if(root == null) {
            return;
        }
        make(root.parent);
        printMax(root.matrix);
        System.err.println();
    }

    public static void printMax(int[][] matrix) {
        String path = "";
        for(int i=0; i < Core.rowSize;i++) {
            for(int j= 0; j < Core.rowSize; j++) {
                System.err.print(matrix[i][j]);
                path+= ""+matrix[i][j];
            }
            System.err.println();
        }
        Core.steps.add(path);
    }
}
