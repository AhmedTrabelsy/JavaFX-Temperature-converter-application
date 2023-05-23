module com.examen {
  requires javafx.controls;
  requires javafx.fxml;

  opens com.examen to javafx.fxml;

  exports com.examen;
}
