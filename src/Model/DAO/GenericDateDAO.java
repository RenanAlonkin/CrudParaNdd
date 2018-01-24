/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.DAO;

import Model.VO.GenericDateVO;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Renan Nunes Steinck <renan.alonkin@gmail.com>
 */
public class GenericDateDAO {

    private static final String INSERT_SQL = "INSERT INTO generic_date (date, name) VALUES (?,?);";
    private static final String SELECT_SQL = "SELECT * FROM generic_date;";
    private static final String SELECT_WITH_ARGUMENT_SQL = "SELECT * FROM generic_date WHERE name = ?;";
    private static final String UPDATE_SQL = "UPDATE generic_date SET name = ? WHERE id_generic_date = ?;";
    private static final String DELETE_SQL = "DELETE FROM generic_date WHERE id_generic_date = ?;";

    public void insert(GenericDateVO g) {
        try {
            PreparedStatement prepare = ConnectionDB.getConnection().prepareStatement(INSERT_SQL);
            prepare.setDate(1, g.getDate());
            prepare.setString(2, g.getName());
            prepare.execute();
            ConnectionDB.commit();
        } catch (SQLException ex) {
            System.out.println(ex);
            ConnectionDB.rollback();
        }
    }

    public List<GenericDateVO> selectAll() {

        try {
            PreparedStatement prepare = ConnectionDB.getConnection().prepareStatement(SELECT_SQL);
            prepare.execute();
            ResultSet rs = prepare.getResultSet();
            List<GenericDateVO> ldg = new ArrayList<>();
            GenericDateVO g;

            while (rs.next()) {
                g = new GenericDateVO(rs.getInt(1),
                        rs.getString(3),
                        rs.getDate(2));
                ldg.add(g);
            }

            return ldg;

        } catch (SQLException ex) {
            Logger.getLogger(GenericDateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public GenericDateVO select(String name) {

        try {
            PreparedStatement prepare = ConnectionDB.getConnection().prepareStatement(SELECT_WITH_ARGUMENT_SQL);
            prepare.setString(1, name);
            prepare.execute();
            ResultSet rs = prepare.getResultSet();
            if(rs.next()){
                return new GenericDateVO(rs.getInt(1),
                    rs.getString(3),
                    rs.getDate(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(GenericDateDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void update(GenericDateVO g) {
        try {
            PreparedStatement prepare = ConnectionDB.getConnection().prepareStatement(UPDATE_SQL);
            prepare.setString(1, g.getName());
            prepare.setInt(2, g.getId());
            prepare.execute();
            ConnectionDB.commit();
        } catch (SQLException ex) {
            ConnectionDB.rollback();
            System.out.println(ex);
        }
    }

    public void delete(GenericDateVO g) {
        try {
            PreparedStatement prepare = ConnectionDB.getConnection().prepareStatement(DELETE_SQL);
            prepare.setInt(1, g.getId());
            prepare.execute();
            ConnectionDB.commit();
        } catch (SQLException ex) {
            ConnectionDB.rollback();
            System.out.println(ex);
        }
    }

}
