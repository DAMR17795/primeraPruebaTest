package com.example.primerapruebatest;

import com.sun.tools.javac.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.base.WindowMatchers;
import org.testfx.matcher.control.LabeledMatchers;
import org.testfx.matcher.control.TextInputControlMatchers;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
//Hay que ponerlo
@ExtendWith(ApplicationExtension.class)
class HelloApplicationTest {
    Pane mainroot;
    Stage mainstage;

    @Start
    public void start(Stage stage) throws IOException {
        //mainroot = (Pane) new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        mainroot = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        mainstage=stage;
        //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(new Scene(mainroot));
        stage.show();
    }

    @Test
    public void escribirValor(FxRobot robot) throws InterruptedException{
        robot.clickOn("#txtNombre");
        robot.write("David");
        //robot.wait(500000);
    }

    @Test
    public void abrirVentana (FxRobot robot) throws InterruptedException {
        robot.clickOn("#botonAbrir");
        robot.sleep(1000);
        FxAssert.verifyThat(robot.window("Nueva ventana"), WindowMatchers.isShowing());
        robot.targetWindow("Nueva ventana");
        robot.clickOn("#txtNombre");
        robot.write("David");
        FxAssert.verifyThat("#txtNombre", TextInputControlMatchers.hasText("David"));
    }
}