package com.examen;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class SampleController implements Initializable {
  String[] choix = { "From celsius to Fahrenheit", "From Fahrenheit to celsius" };
  @FXML
  TextField inputValue;

  @FXML
  TextField resultValue;

  @FXML
  ListView<String> listeResultat;

  @FXML
  ComboBox<String> listeChoix;

  @Override
  public void initialize(URL arg0, ResourceBundle arg1) {
    listeChoix.getItems().setAll(choix);
    listeChoix.getSelectionModel().select(0);
  }

  String latestConverted;
  String latestInput;

  @FXML
  private void Convert() throws IOException {
    double value = 0;
    double converted = 0;
    try {
      if (listeChoix.getSelectionModel().getSelectedIndex() == 0) {
        value = Double.parseDouble(inputValue.getText());
        converted = (value * 1.8) + 32;
        latestConverted = Double.toString(converted) + "°F";
        resultValue.setText(latestConverted);
        latestInput = Double.toString(value) + "°C";
      } else if (listeChoix.getSelectionModel().getSelectedIndex() == 1) {
        value = Double.parseDouble(inputValue.getText());
        converted = (value - 32) / 1.8;
        latestConverted = Double.toString(converted) + "°C";
        latestInput = Double.toString(value) + "°F";
        resultValue.setText(latestConverted);
      }
    } catch (NumberFormatException e) {
      Alert a = new Alert(Alert.AlertType.ERROR);
      a.setContentText("Invalid input");
      a.show();
    }
  }

  @FXML
  private void Save() {
    if (latestConverted != null && latestConverted != null) {
      listeResultat.getItems().add(latestInput + " = " + latestConverted);
    }
  }

  @FXML
  private void Cancel() {
    inputValue.clear();
    resultValue.clear();
    listeResultat.getItems().clear();
  }
}
