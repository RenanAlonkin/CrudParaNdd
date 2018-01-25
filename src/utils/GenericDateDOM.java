/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import Model.VO.GenericDateVO;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author Renan Nunes Steinck <renan.alonkin@gmail.com>
 */
public class GenericDateDOM {

    public void add(GenericDateVO g) {
        Document d = DOMHelper.getDocument(System.getProperty("user.dir") + "\\src\\genericDate.xml");
        Element genericDates = d.getDocumentElement();
        //Create "generic" Tag
        Element genericDate = d.createElement("genericDate");
        //Create ID tag
        Element id = d.createElement("id");
        id.appendChild(d.createTextNode(g.getId() + ""));
        //Create Name Tag
        Element name = d.createElement("name");
        name.appendChild(d.createTextNode(g.getName()));
        //Create date tag
        Element date = d.createElement("date");
        date.appendChild(d.createTextNode(g.getDate().toString()));

        genericDate.appendChild(id);
        genericDate.appendChild(name);
        genericDate.appendChild(date);

        genericDates.appendChild(genericDate);
        DOMHelper.saveXMLContent(d, System.getProperty("user.dir") + "\\src\\genericDate.xml");
    }

    public void delete(GenericDateVO g) {
        Document d = DOMHelper.getDocument(System.getProperty("user.dir") + "\\src\\genericDate.xml");
        NodeList nl = d.getElementsByTagName("genericDate");
        boolean found = false;
        int i = 0;
        while (!found) {
            Element elem = (Element) nl.item(i);
            if (elem.getElementsByTagName("id").item(0).getTextContent().equals(g.getId() + "")) {
                elem.getParentNode().removeChild(elem);
                found = true;
            }
            i++;
        }
        DOMHelper.saveXMLContent(d, System.getProperty("user.dir") + "\\src\\genericDate.xml");
    }

    public void update(GenericDateVO g) {
        Document d = DOMHelper.getDocument(System.getProperty("user.dir") + "\\src\\genericDate.xml");
        NodeList nl = d.getElementsByTagName("genericDate");
        boolean found = false;
        int i = 0;
        while (!found) {
            Element elem = (Element) nl.item(i);
            if (elem.getElementsByTagName("id").item(0).getTextContent().equals(g.getId() + "")) {
                elem.getElementsByTagName("name").item(0).setTextContent(g.getName());
                elem.getElementsByTagName("date").item(0).setTextContent(g.getDate().toString());
                found = true;
                i++;
            }
        }
        DOMHelper.saveXMLContent(d, System.getProperty("user.dir") + "\\src\\genericDate.xml");
    }

    public List<GenericDateVO> selectAll() {
        List<GenericDateVO> ldg = new ArrayList<>();
        Document d = DOMHelper.getDocument(System.getProperty("user.dir") + "\\src\\genericDate.xml");
        NodeList nl = d.getElementsByTagName("genericDate");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < nl.getLength(); i++) {
            try {
                Element elem = (Element) nl.item(i);
                java.util.Date parsed = formatter.parse(elem.getElementsByTagName("date").item(0).getTextContent() + "");
                ldg.add(new GenericDateVO(Integer.parseInt(elem.getElementsByTagName("id").item(0).getTextContent()),
                        elem.getElementsByTagName("name").item(0).getTextContent(),
                        new Date(parsed.getTime())));
            } catch (ParseException ex) {
                Logger.getLogger(GenericDateDOM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return ldg;
    }

    public GenericDateVO select(GenericDateVO g) {
        GenericDateVO gr = null;
        Document d = DOMHelper.getDocument(System.getProperty("user.dir") + "\\src\\genericDate.xml");
        NodeList nl = d.getElementsByTagName("genericDate");
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        boolean found = false;
        int i = 0;
        while (!found) {
            try {
                Element elem = (Element) nl.item(i);
                if (elem.getElementsByTagName("id").item(0).getTextContent().equals(g.getId() + "")) {
                    java.util.Date parsed = formatter.parse(elem.getElementsByTagName("date").item(0).getTextContent() + "");
                    return new GenericDateVO(Integer.parseInt(elem.getElementsByTagName("id").item(0).getTextContent()),
                            elem.getElementsByTagName("name").item(0).getTextContent(),
                            new Date(parsed.getTime()));
                }
                i++;
            } catch (ParseException ex) {
                Logger.getLogger(GenericDateDOM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return gr;
    }
}
