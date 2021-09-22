package com.example.demo2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        final int[] count = new int[1];
        count[0] = 0;
        Check check = new Check();
        Label label = new Label();
        GridPane gridPane = new GridPane();
        Button[][] buttons = new Button[4][4];
        for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++)
            {
                buttons[i][j] = new Button();
                buttons[i][j].setPrefSize(100, 100);
            }
        }
       for(int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++) {
                gridPane.add(buttons[i][j],j, i);
            }
        }

       for(int i = 0; i < 4; i++)
        {
            for(int j = 0; j < 4; j++) {

                int J = j;
                int I = i;
                buttons[I][J].setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        if (count[0] % 2 == 0) {
                            buttons[I][J].setText("X");
                           check.add(I, J, 1);
                           if(check.Win_plus() == 1)
                           {
                               label.setText("Wins X");
                               label.setAlignment(Pos.CENTER);
                               Scene scene1 = new Scene(label, 400, 400);
                               Stage stage1 = new Stage();
                               stage.hide();
                               stage1.setTitle("Winner");
                               stage1.setScene(scene1);
                               stage1.show();
                           }
                        } else {
                            buttons[I][J].setText("O");
                            check.add(I, J, -1);
                            if(check.Win_minus() == 1)
                            {
                                label.setText("Wins O");
                                label.setAlignment(Pos.CENTER);
                                Scene scene2 = new Scene(label, 400, 400);
                                Stage stage2 = new Stage();
                                stage.hide();
                                stage2.setTitle("Winner");
                                stage2.setScene(scene2);
                                stage2.show();
                            }
                        }
                        count[0]++;

                        if((count[0] == 16) && (check.Win_minus() != 1))
                        {
                                label.setText("Nobody wins");
                                label.setAlignment(Pos.CENTER);
                                Scene scene3 = new Scene(label, 400, 400);
                                Stage stage3 = new Stage();
                                stage.hide();
                                stage3.setTitle("Winner");
                                stage3.setScene(scene3);
                                stage3.show();
                        }
                    }
                });
            }
        }


        FlowPane root = new FlowPane(gridPane);
        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.setTitle("X-O");
        stage.show();

   }

    public static void main(String[] args) {launch();
    }
}