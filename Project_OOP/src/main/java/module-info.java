module project.project_oop {
    requires javafx.controls;
    requires javafx.fxml;


    opens main to javafx.fxml;
    exports controllers;
    exports main;
    opens controllers to javafx.fxml;
    exports main.model;
    opens main.model to javafx.fxml;
    exports controllers.homeP;
    opens controllers.homeP to javafx.fxml;
}
