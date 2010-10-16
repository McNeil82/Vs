package de.moralis.vs.logging.xslt;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class LoggingTransformer {
    public void createHtml() {
        try {
            File xslt = new File(new File(".").getCanonicalPath() + "\\src\\de\\moralis\\vs\\logging\\xslt\\LoggingHtml.xslt");

            TransformerFactory transformerFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(xslt));

            File xmlDirectory = new File(new File(".").getCanonicalPath() + "\\logs\\xml");

            File[] xmlFiles = xmlDirectory.listFiles(new XmlFileFilter());
            for (File xmlFile : xmlFiles) {
                File html = new File(new File(".").getCanonicalPath() + "\\logs\\html\\" + xmlFile.getName() + ".html");
                if (!html.exists()) {
                    boolean success = html.createNewFile();
                    if (!success) {
                        throw new IOException("can not create file: " + html.getAbsolutePath());
                    }
                }
                transformer.setParameter("logName", xmlFile.getName());
                transformer.transform(new StreamSource(xmlFile), new StreamResult(html));
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("can not get xml file: " + e.getMessage());
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
            System.err.println("wrong transformer configuration: " + e.getMessage());
        } catch (TransformerException e) {
            e.printStackTrace();
            System.err.println("transformer exception: " + e.getMessage());
        }
    }

    private class XmlFileFilter implements FileFilter {

        public boolean accept(File pathname) {
            return pathname.getName().endsWith(".xml");
        }
    }
}
