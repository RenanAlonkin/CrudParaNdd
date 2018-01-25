/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.VO.GenericDateVO;
import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Renan Nunes Steinck <renan.alonkin@gmail.com>
 */
public class GenericDateDOMTest {

    public GenericDateDOMTest() {
    }

    GenericDateVO g0;
    GenericDateVO g1;
    GenericDateVO g2;
    GenericDateDOM instance;

    @Before
    public void setUp() {
        g0 = new GenericDateVO("Adicionar", new Date(new java.util.Date().getTime()));
        g1 = new GenericDateVO("Pedroca", new Date(new java.util.Date().getTime()));
        g2 = new GenericDateVO("Sabrina", new Date(new java.util.Date().getTime()));
        instance = new GenericDateDOM();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class GenericDateDOM.
     */
    @Ignore
    @Test
    public void testAdd() {
        System.out.println("add");
        instance.add(g0);
        instance.add(g1);
        instance.add(g2);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    @Ignore
    @Test
    public void testDelete() {
        System.out.println("delete");
        g0.setId(1);
        instance.delete(g0);
        // TODO review the generated test code and remove the default call to fail.
        assertTrue(true);
    }

    @Ignore
    @Test
    public void testUpdate() {
        System.out.println("update");
        g0.setName("Patuncio");
        instance.update(g0);
        assertTrue(true);
    }

    @Ignore
    @Test
    public void testSelectAll() {
        System.out.println("selectAll");
        List<GenericDateVO> ldg = instance.selectAll();
        for (GenericDateVO genericDateVO : ldg) {
            System.out.println(genericDateVO);
        }
        assertTrue(true);
    }

    @Ignore
    @Test
    public void testSelect() {
        System.out.println("select");
        GenericDateVO g = instance.select(g0);
        System.out.println(g);
        assertEquals(g0.getName(), g.getName());
    }

}
