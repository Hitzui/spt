package com.dysconcsa.sondeo;

import com.dysconcsa.sondeo.dao.DaoSuelos;
import com.dysconcsa.sondeo.util.AlertError;
import com.dysconcsa.sondeo.views.AppViewManager;
import com.gluonhq.attach.storage.StorageService;
import com.gluonhq.attach.util.Services;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.Alert;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;
import java.util.logging.Logger;

public class SondeoApplication extends Application {

    Logger logger = Logger.getLogger(getClass().getName());
    private final AppManager appManager = AppManager.initialize(this::postInit);

    @Override
    public void init() {
        AppViewManager.registerViewsAndDrawer();
    }

    @Override
    public void start(Stage primaryStage) {
        appManager.start(primaryStage);
    }

    private void postInit(Scene scene) {
        Swatch.RED.assignTo(scene);
        try {
            var daoSuelos = new DaoSuelos();
            var optionalFile = Services.get(StorageService.class)
                    .flatMap(storageService -> storageService.getPublicStorage("Documents"));
            if (optionalFile.isPresent()) {
                var alert = new Alert(javafx.scene.control.Alert.AlertType.ERROR);
                alert.setTitleText("Error");
                alert.setContentText("No hay archivos en la direccion indicada");
                logger.info(optionalFile.get().getAbsolutePath());
            } else {
                System.out.println("No hay directorio");
                logger.info("No hay archivos disponibles");
            }

        } catch (Exception exception) {
            AlertError.showAlert(exception);
        }
        scene.getStylesheets().add(Objects.requireNonNull(SondeoApplication.class.getResource("style.css")).toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Objects.requireNonNull(SondeoApplication.class.getResourceAsStream("/icon.png"))));
    }

    public static void main(String[] args) {

        launch(args);
    }
}
