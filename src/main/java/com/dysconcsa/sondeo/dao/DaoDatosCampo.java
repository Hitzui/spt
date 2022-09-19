//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.dao;

import com.dysconcsa.sondeo.model.DatosCampoProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class DaoDatosCampo {

    Exception _error;
    private final DataConnection connection = new DataConnection();

    public Exception get_error() {
        return this._error;
    }

    public DaoDatosCampo() {
        try {
            Connection conn = this.connection.getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS datos_campo(    profundidad_inicial number         constraint datos_campo_pk             primary key,     profundidad_final   number,     recobro             int,     golpe1              int,     golpe2              int,     golpe3              int )";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (Exception var4) {
            this._error = var4;
        }

    }

    public ObservableList<DatosCampoProperty> findAll() throws SQLException {
        ObservableList<DatosCampoProperty> datosCampoProperties = FXCollections.observableArrayList();

        try {
            Connection cnn = this.connection.getConnection();
            Throwable var3 = null;

            try {
                String sql = "select * from datos_campo";
                PreparedStatement preparedStatement = cnn.prepareStatement(sql);
                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    DatosCampoProperty datosCampoProperty = new DatosCampoProperty(rs.getDouble("profundidad_inicial"), rs.getDouble("profundidad_final"), rs.getInt("recobro"), rs.getInt("golpe1"), rs.getInt("golpe2"), rs.getInt("golpe3"));
                    datosCampoProperties.add(datosCampoProperty);
                }
            } catch (Throwable var16) {
                var3 = var16;
                throw var16;
            } finally {
                if (cnn != null) {
                    if (var3 != null) {
                        try {
                            cnn.close();
                        } catch (Throwable var15) {
                            var3.addSuppressed(var15);
                        }
                    } else {
                        cnn.close();
                    }
                }

            }
        } catch (Exception var18) {
            this._error = var18;
        }

        return datosCampoProperties;
    }
}
