/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domcreator;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author kunalmalhotra
 */
public class DOMCreator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DocumentBuilderFactory mDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder mDocumentBuilder = mDocumentBuilderFactory.newDocumentBuilder();
            Document mDocument = mDocumentBuilder.newDocument();
            
            // create root node
            
            Element root = mDocument.createElement("StudentList");
            
            // create child node
            
            Element child1 = mDocument.createElement("Student");
            
            // create child elements
            
            Element StudentID = mDocument.createElement("StudentID");
            Text idValue = mDocument.createTextNode("2014A7TS354U");
            StudentID.appendChild(idValue);
            
            Element StudentName = mDocument.createElement("StudentName");
            Text nameValue = mDocument.createTextNode("Kunal Malhotra");
            StudentName.appendChild(nameValue);
            
            Element StudentMarks = mDocument.createElement("Marks");
            Text marksValue = mDocument.createTextNode("20");
            StudentMarks.appendChild(marksValue);
            
            // adding elements to the node
            
            child1.appendChild(StudentID);
            child1.appendChild(StudentName);
            child1.appendChild(StudentMarks);
            
            // adding node to the root
            
            root.appendChild(child1);
            
            
            // adding root to the document
            mDocument.appendChild(root);
            
            DOMSource mDOMSource = new DOMSource(mDocument);
            
            String path = "/Users/kunalmalhotra/NetBeansProjects/DOMCreator/src/domcreator/studentlist.xml";
            File mFile = new File(path);
            
            Result mResult = new StreamResult(mFile);
            
            TransformerFactory mTransformerFactory = TransformerFactory.newInstance();
            Transformer mTransformer = mTransformerFactory.newTransformer();
            mTransformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION , "no");
            mTransformer.setOutputProperty(OutputKeys.INDENT, "yes");
            mTransformer.transform(mDOMSource, mResult);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(DOMCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(DOMCreator.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(DOMCreator.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
