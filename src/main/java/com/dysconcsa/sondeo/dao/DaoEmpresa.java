//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.dysconcsa.sondeo.dao;


import com.dysconcsa.sondeo.model.EmpresaProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoEmpresa {

    private Exception _error;
    private final DataConnection connection = new DataConnection();
    private int idAfterSave;

    public int getIdAfterSave() {
        return this.idAfterSave;
    }

    public DaoEmpresa() {
        try {
            Connection conn = this.connection.getConnection();
            String sql = "CREATE TABLE IF NOT EXISTS `empresa` ( `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `cliente` TEXT, `proyecto` TEXT, `fecha` TEXT )";
            Statement statement = conn.createStatement();
            statement.execute(sql);
        } catch (SQLException var4) {
            this._error = var4;
        }

    }

    public void save(EmpresaProperty empresaProperty) {
        try {
            String sql = "INSERT INTO `empresa`(`cliente`,`proyecto`,`fecha`) VALUES (?,?,?)";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql, 1);
            this.parameters(preparedStatement, empresaProperty);
            int getId = preparedStatement.executeUpdate();
            if (getId != 0) {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                Throwable var7 = null;

                try {
                    if (generatedKeys.next()) {
                        this.idAfterSave = generatedKeys.getInt(1);
                    } else {
                        this.idAfterSave = 0;
                    }
                } catch (Throwable var17) {
                    var7 = var17;
                    throw var17;
                } finally {
                    if (generatedKeys != null) {
                        if (var7 != null) {
                            try {
                                generatedKeys.close();
                            } catch (Throwable var16) {
                                var7.addSuppressed(var16);
                            }
                        } else {
                            generatedKeys.close();
                        }
                    }

                }
            }
        } catch (SQLException var19) {
            this._error = var19;
        }

    }

    private void parameters(PreparedStatement preparedStatement, EmpresaProperty empresaProperty) throws SQLException {
        preparedStatement.setString(1, empresaProperty.getCliente());
        preparedStatement.setString(2, empresaProperty.getProyecto());
        preparedStatement.setString(3, empresaProperty.getFecha());
    }

    public void update(EmpresaProperty empresaProperty) {
        try {
            String sql = "UPDATE empresa set cliente = ?, proyecto = ?,fecha = ? WHERE id = ?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            this.parameters(preparedStatement, empresaProperty);
            preparedStatement.setInt(4, empresaProperty.getId());
            this.idAfterSave = preparedStatement.executeUpdate();
        } catch (Exception var5) {
            this._error = var5;
        }

    }

    public void delete(Integer id) {
        try {
            String sql = "DELETE FROM empresa WHERE id = ?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception var5) {
            this._error = var5;
        }

    }

    public Exception get_error() {
        return this._error;
    }

    public List<EmpresaProperty> findAll() {
        ArrayList list = new ArrayList();

        try {
            String sql = "SELECT * FROM empresa";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()) {
                EmpresaProperty empresa = new EmpresaProperty(result.getString("cliente"), result.getString("proyecto"), result.getString("fecha"));
                empresa.setId(result.getInt("id"));
                list.add(empresa);
            }
        } catch (Exception var7) {
            this._error = var7;
        }

        return list;
    }

    public EmpresaProperty find(int getIdEmpresa) {
        EmpresaProperty empresa = null;

        try {
            String sql = "select * from empresa where id = ?";
            Connection cnn = this.connection.getConnection();
            PreparedStatement preparedStatement = cnn.prepareStatement(sql);
            preparedStatement.setInt(1, getIdEmpresa);
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()) {
                empresa = new EmpresaProperty(result.getString("cliente"), result.getString("proyecto"), result.getString("fecha"));
                empresa.setId(result.getInt("id"));
                System.out.println("Id: " + result.getInt("id"));
            }

            return empresa;
        } catch (SQLException var7) {
            this._error = var7;
            return null;
        }
    }
}
