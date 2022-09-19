//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.dao;

import com.dysconcsa.sondeo.model.SuelosProperty;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoSuelos {
    Exception _error;
    DataConnection connection = new DataConnection();
    List<SuelosProperty> listSuelos;

    public Exception get_error() {
        return this._error;
    }

    public DaoSuelos() {
        try {
            Connection conn = this.connection.getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS `suelos` ( `id` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `nombre` TEXT NOT NULL, `simbolo` TEXT NOT NULL,color int,pattern int)";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException var4) {
            this._error = var4;
        }

    }

    public List<SuelosProperty> findAll() {
        this.listSuelos = new ArrayList<>();
        try {
            Connection conn = this.connection.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  * FROM suelos");

            while(rs.next()) {
                SuelosProperty suelosProperty = new SuelosProperty(rs.getInt("id"), rs.getString("nombre"), rs.getString("simbolo"), IndexedColors.fromInt(rs.getInt("color")), FillPatternType.forInt(rs.getInt("pattern")));
                this.listSuelos.add(suelosProperty);
            }
        } catch (SQLException var8) {
            this._error = var8;
            listSuelos = new ArrayList<>();
        }
        return listSuelos;
    }

    public SuelosProperty findById(int id) {
        SuelosProperty suelosProperty = null;

        try {
            String sql = "select * from suelos where id = ?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            for(ResultSet resultSet = preparedStatement.executeQuery(); resultSet.next(); suelosProperty = new SuelosProperty(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("simbolo"), IndexedColors.fromInt(resultSet.getInt("color")), FillPatternType.forInt(resultSet.getInt("pattern")))) {
            }

            return suelosProperty;
        } catch (SQLException var7) {
            this._error = var7;
            return suelosProperty;
        }
    }

    public SuelosProperty findBYSimbolo(String simbolo) {
        SuelosProperty suelosProperty = null;

        try {
            String sql = "select * from suelos where simbolo= ?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setString(1, simbolo);
            suelosProperty = this.findOne(preparedStatement);
        } catch (Exception var6) {
            this._error = var6;
        }

        return suelosProperty;
    }

    public SuelosProperty findByIndexedColors(IndexedColors colors) {
        SuelosProperty suelosProperty = null;

        try {
            String sql = "select * from suelos where color = ?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setInt(1, colors.getIndex());
            suelosProperty = this.findOne(preparedStatement);
        } catch (Exception var6) {
            this._error = var6;
        }

        return suelosProperty;
    }

    public void save(SuelosProperty suelosProperty) {
        try {
            String sql = "INSERT INTO suelos(nombre,simbolo,color,pattern) VALUES (?,?,?,?)";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setString(1, (String)suelosProperty.nombreProperty().get());
            preparedStatement.setString(2, (String)suelosProperty.simboloProperty().get());
            preparedStatement.setInt(3, suelosProperty.getColor().getIndex());
            preparedStatement.setInt(4, suelosProperty.getPattern().getCode());
            preparedStatement.executeUpdate();
        } catch (SQLException var5) {
            this._error = var5;
        }

    }

    public void update(SuelosProperty suelosProperty) {
        try {
            String sql = "UPDATE suelos SET nombre = ?, simbolo = ?, color = ?,pattern=? WHERE id=?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setString(1, suelosProperty.getNombre());
            preparedStatement.setString(2, suelosProperty.getSimbolo());
            preparedStatement.setInt(3, suelosProperty.getColor().getIndex());
            preparedStatement.setInt(4, suelosProperty.getPattern().getCode());
            preparedStatement.setInt(5, suelosProperty.getID());
            preparedStatement.executeUpdate();
        } catch (SQLException var5) {
            this._error = var5;
        }

    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM suelos WHERE id = ?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException var5) {
            var5.printStackTrace();
            this._error = var5;
        }

    }

    private SuelosProperty findOne(PreparedStatement preparedStatement) throws SQLException {
        SuelosProperty suelosProperty = null;

        for(ResultSet resultSet = preparedStatement.executeQuery(); resultSet.next(); suelosProperty = new SuelosProperty(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("simbolo"), IndexedColors.fromInt(resultSet.getInt("color")), FillPatternType.forInt(resultSet.getInt("pattern")))) {
        }

        return suelosProperty;
    }
}
