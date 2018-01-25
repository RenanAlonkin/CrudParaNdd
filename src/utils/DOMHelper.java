/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.xml.sax.SAXException;

/**
 *
 * @author Renan Nunes Steinck <renan.alonkin@gmail.com>
 */
public class DOMHelper {

    public static Document getDocument(String pathToFile) {
        Document d = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            d = db.parse(pathToFile);
        } catch (SAXException ex) {
            Logger.getLogger(DOMHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DOMHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {

            Logger.getLogger(DOMHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }

    public static String getXMLContent(Document d) {
        String result = "";
        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            StringWriter sw = new StringWriter();
            StreamResult sr = new StreamResult(sw);
            DOMSource source = new DOMSource(d);
            tf.transform(source, sr);
            result = sw.toString();
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DOMHelper.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DOMHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public static void saveXMLContent(Document d, String pathToFile) {

        try {
            TransformerFactory tff = TransformerFactory.newInstance();
            Transformer tf = tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource ds = new DOMSource(d);
            StreamResult sr = new StreamResult(pathToFile);
            tf.transform(ds, sr);
        } catch (TransformerException ex) {
            Logger.getLogger(DOMHelper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
