module nrainhas.nrainhas_frontend {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens nrainhas.nrainhas_frontend to javafx.fxml;
    exports nrainhas.nrainhas_frontend;
}