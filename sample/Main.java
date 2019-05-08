package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.aStar.Core;
import sample.controller.BoardGame;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader ll = new FXMLLoader(Main.class.getResource("file/boardGame.fxml"));
        Parent sss = ll.load();
        Scene  ss= new Scene(sss, 455, 546);
        primaryStage.setTitle("8Puzzle ");
        primaryStage.setScene(ss);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
