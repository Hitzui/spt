package com.dysconcsa.sondeo.dao;

import com.gluonhq.attach.storage.StorageService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.attach.util.Services;
import org.sqldroid.SQLDroidDriver;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DataConnection {
    Connection connection;
    private final static String DB_NAME = "sondeo.db";
    Logger logger = Logger.getLogger(getClass().getName());

    public Connection getConnection() {
        try {
            connection = DriverManager.getConnection(readDB());
            connection.setReadOnly(false);
        } catch (SQLException e) {
            logger.warning("Error: " + e.getMessage());
            e.printStackTrace();
        }
        return this.connection;
    }

    private String readDB() throws SQLException {
        logger.info("Reading an existing Database with SQLite");
        String dbUrl = "jdbc:sqlite:";
        if (Platform.isDesktop()) {
            //dbUrl = dbUrl + ":resource:" + Objects.requireNonNull(SondeoApplication.class.getResource("/databases/" + DB_NAME)).toExternalForm();
            dbUrl = dbUrl + DB_NAME;
        } else {
            try {
                var resource = getClass().getClassLoader().getResource("databases/sondeo.db");
                DriverManager.registerDriver(new SQLDroidDriver());
                var privateStorage = Services.get(StorageService.class)
                        .flatMap(StorageService::getPrivateStorage)
                        .orElseThrow(() -> new IOException("Error: PrivateStorage not available"));
                var publicStorage = Services.get(StorageService.class)
                        .flatMap(storageService -> storageService.getPublicStorage("Documents"))
                        .orElseThrow(() -> new IOException("error al leer la carpeta publica de Documents"));
                File db = new File(publicStorage, DB_NAME);
                /*if (resource != null) {
                    var file = new File(resource.getFile());
                    logger.info("Copying database " + DB_NAME + " to private storage");
                    logger.info("Resource: " + file.getAbsolutePath());
                    DBUtils.copyDatabase(file.getParent() + "/", publicStorage.getAbsolutePath(), DB_NAME);
                    DBUtils.copyDatabase(publicStorage.getAbsolutePath(), privateStorage.getAbsolutePath(), DB_NAME);
                }*/
                dbUrl = dbUrl + db.getAbsolutePath();
            } catch (IOException ex) {
                logger.warning("IO error " + ex.getMessage());
                ex.printStackTrace();
            }
        }
        logger.info("Path of url: " + dbUrl);
        return dbUrl;
    }

    public DataConnection() {
        try {
            Class<?> c = null;
            if (Platform.isAndroid()) {
                c = Class.forName("org.sqldroid.SQLDroidDriver");
            } else if (Platform.isIOS()) {
                c = Class.forName("SQLite.JDBCDriver");
            } else if (Platform.isDesktop()) {
                c = Class.forName("org.sqlite.JDBC");
            } else if (System.getProperty("os.arch").toUpperCase().contains("ARM")) {
                c = Class.forName("org.sqldroid.SQLDroidDriver");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error class not found " + e);
        }
    }
}
