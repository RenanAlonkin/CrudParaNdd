
import Model.DAO.GenericDateDAO;
import Model.VO.GenericDateVO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Renan Nunes Steinck <renan.alonkin@gmail.com>
 */
public class Main {

    public static void main(String[] args) {

        GenericDateVO g1 = new GenericDateVO("Numero 1", new Date(new java.util.Date().getTime()));
        GenericDateVO g2 = new GenericDateVO("Numero 2", new Date(new java.util.Date().getTime()));
        GenericDateVO g3 = new GenericDateVO("Numero 3", new Date(new java.util.Date().getTime()));

        GenericDateDAO dao = new GenericDateDAO();
        dao.insert(g1);
        dao.insert(g2);
        dao.insert(g3);

        System.out.println("-----------------Select ALL---------------");
        List<GenericDateVO> ldg = dao.selectAll();
        for (GenericDateVO genericDateVO : ldg) {
            System.out.println(genericDateVO);
        }

        GenericDateVO g4 = dao.select("Numero 2");
        System.out.println("-----------------Select---------------");
        System.out.println(g4);
        g4.setName("Pedroca");
        dao.update(g4);
        ldg = dao.selectAll();
        
        System.out.println("-----------------Update---------------");
        for (GenericDateVO genericDateVO : ldg) {
            System.out.println(genericDateVO);
        }

        dao.delete(g4);

        System.out.println("-----------------Delete---------------");
        ldg = dao.selectAll();
        for (GenericDateVO genericDateVO : ldg) {
            System.out.println(genericDateVO);
        }
        
        
    }
}
