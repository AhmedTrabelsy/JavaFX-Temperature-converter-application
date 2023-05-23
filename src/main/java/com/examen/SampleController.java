package com.examen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class SampleController implements Initializable {
  private double value = 40;
  private double converted;
  String[] choix = { "From celsius to Fahrenheit", "From Fahrenheit to celsius" };
  @FXML
  ComboBox<String> listeChoix;

  @FXML
  private void Convert() throws IOException {
    converted = (value - 32) / 1.8;

    System.out.println(converted);
  }

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    listeChoix.getItems().setAll(choix);
  }
}
