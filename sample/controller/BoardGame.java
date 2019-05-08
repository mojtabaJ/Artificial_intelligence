package sample.controller;

import java.util.List;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import sample.aStar.Core;

public class BoardGame {

    @FXML
    private Label a7;

    @FXML
    private Label a8;

    @FXML
    private Label a9;

    @FXML
    private Label a4;

    @FXML
    private Label a5;

    @FXML
    private Label a6;

    @FXML
    private Label a1;

    @FXML
    private Label a2;

    @FXML
    private Label a3;

    @FXML
    private Label step;

    @FXML
    private Button start;

    @FXML
    private TextField init;


    @FXML
    void initialize() {

        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.err.println(init.getText().toString());
                try {
                    run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static int index = 0;

    public  void run() throws InterruptedException {

        System.err.println(init.getText().toString());
        startGame(init.getText().toString());
        steps = Core.steps;
        set(init.getText().toString());
        setStep(0);
        index = 0;
        try {

            new Thread(){
                @Override
                public void run() {
                    for (int i = 0; i < steps.size(); i++) {
                        index=i;
                        try {
                            Thread.sleep(800);

                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Platform.runLater(new Runnable() {

                            @Override
                            public void run() {
                                set(steps.get(index));
                                setStep(index);

                            }
                        });

                    }



                }
            }.start();

        }catch (Exception e){

            e.printStackTrace();
            return;
        }

    }



    private  void set(String s){

        a1.setText(((s.charAt(0)!='0')? String.valueOf(s.charAt(0)) :""));
        a2.setText(((s.charAt(1)!='0')? String.valueOf(s.charAt(1)) :""));
        a3.setText(((s.charAt(2)!='0')? String.valueOf(s.charAt(2)) :""));
        a4.setText(((s.charAt(3)!='0')? String.valueOf(s.charAt(3)) :""));
        a5.setText(((s.charAt(4)!='0')? String.valueOf(s.charAt(4)) :""));
        a6.setText(((s.charAt(5)!='0')? String.valueOf(s.charAt(5)) :""));
        a7.setText(((s.charAt(6)!='0')? String.valueOf(s.charAt(6)) :""));
        a8.setText(((s.charAt(7)!='0')? String.valueOf(s.charAt(7)) :""));
        a9.setText(((s.charAt(8)!='0')? String.valueOf(s.charAt(8)) :""));

    }

    private  void setStep(long num){
        step.setText("مرحله: " + num);
    }



    private static void startGame(String init){
        int k = 0;
        int[][] initialState = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                initialState[i][j] = Integer.parseInt(String.valueOf(init.charAt(k++)));
            }
        }


        int[][] finalState = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 0}};

        Core.rowSize = 3;
        Core.solve(initialState, finalState);

    }

    public static List<String> steps;
}
