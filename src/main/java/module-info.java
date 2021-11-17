module com.example.bsuir_helper_ {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.json;
    requires javafx.base;

    opens com.example.bsuir_helper_1 to javafx.fxml;
    exports com.example.bsuir_helper_1;
}