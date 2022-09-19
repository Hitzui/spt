//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.dao;

import com.dysconcsa.sondeo.model.ValoresProperty;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class DaoValores {

    private Exception _error;
    private final DataConnection connection = new DataConnection();

    public Exception get_error() {
        return this._error;
    }

    public DaoValores() {
        try {
            Connection conn = this.connection.getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS `valores` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `espesor` REAL, `trepano` TEXT, `tiposuelo` INTEGER, `limiteliquido` TEXT, `plasticidad` TEXT, `humedad` REAL, `recobro` INTEGER, `golpes` INTEGER, `idempresa` INTEGER)";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (Exception var4) {
            this._error = var4;
        }

    }

    public void save(ValoresProperty valoresProperty) {
        try {
            Connection conn = this.connection.getConnection();
            String sql = "INSERT INTO `valores`(`espesor`,`trepano`,`tiposuelo`,`limiteliquido`,`plasticidad`,`humedad`,`recobro`,`golpes`,`idempresa`) VALUES (?,?,?,?,?,?,?,?,?,?);";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1, valoresProperty.getEspesor());
            preparedStatement.setString(3, valoresProperty.getTrepano());
            preparedStatement.setInt(4, valoresProperty.getTipoSuelo());
            preparedStatement.setString(5, valoresProperty.getLimiteLiquido());
            preparedStatement.setString(6, valoresProperty.getIndicePlasticidad());
            preparedStatement.setDouble(7, valoresProperty.getIndiceHumedad());
            preparedStatement.setInt(8, valoresProperty.getRecobro());
            preparedStatement.setInt(9, valoresProperty.getGolpes());
            preparedStatement.setInt(9, valoresProperty.getIdEmpresa());
            preparedStatement.executeUpdate();
        } catch (Exception var5) {
            this._error = var5;
        }

    }
}
