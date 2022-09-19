package com.dysconcsa.sondeo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.logging.Logger;

public class DBUtils {

    static Logger logger = Logger.getLogger(DBUtils.class.getName());

    public static void copyDatabase(String pathIni, String pathEnd, String name) {
        var source = new File(pathIni, name);
        var destination = new File(pathEnd, name);
        try {
            copyFile(source, destination);
        } catch (IOException e) {
            logger.warning("Error al intentar copiar: " + e);
        }
    }

    @SuppressWarnings({"ResultOfMethodCallIgnored", "resource"})
    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if (!destFile.getParentFile().exists())
            destFile.getParentFile().mkdirs();

        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        try (FileChannel source = new FileInputStream(sourceFile).getChannel(); FileChannel destination = new FileOutputStream(destFile).getChannel()) {
            destination.transferFrom(source, 0, source.size());
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
