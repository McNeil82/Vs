package de.moralis.logging;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

import static java.util.logging.LogManager.getLogManager;

public class LoggingTransformer {
    public void createHtml(boolean testFilesOnly) {
        resetAllLoggers();

        File xslt = loadXslt();
        Transformer transformer = createTransformer(xslt);

        File[] xmlFiles = loadXmlFiles(testFilesOnly);

        for (File xmlFile : xmlFiles) {
            tramsformToHtml(transformer, xmlFile);
        }
    }

    private Transformer createTransformer(File xslt) {
        Transformer transformer = null;
        if (xslt != null) {
            TransformerFactory transformerFactory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);
            try {
                transformer = transformerFactory.newTransformer(new StreamSource(xslt));
            } catch (TransformerConfigurationException e) {
                e.printStackTrace();
                System.err.println("wrong transformer configuration: " + e.getMessage());
            }
        }

        return transformer;
    }

    private void tramsformToHtml(Transformer transformer, File xmlFile) {
        if (transformer != null) {
            File html = new File("logs/html/" + xmlFile.getName() + ".html");
            if (!html.exists()) {
                boolean success;
                try {
                    success = html.createNewFile();
                    if (!success) {
                        throw new IOException();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.err.println("can not create file: " + html.getAbsolutePath());
                }
            }

            transformer.setParameter("logName", xmlFile.getName());

            try {
                transformer.transform(new StreamSource(xmlFile), new StreamResult(html));
            } catch (TransformerException e) {
                e.printStackTrace();
                System.err.println("transformer exception: " + e.getMessage());
            }
        }
    }

    private File[] loadXmlFiles(boolean testFilesOnly) {
        File xmlDirectory = new File("logs/xml");

        return xmlDirectory.listFiles(new XmlFileFilter(testFilesOnly));
    }

    private File loadXslt() {
        return new File("src/de/moralis/logging/xslt/LoggingHtml.xslt");
    }

    private void resetAllLoggers() {
        getLogManager().reset();
    }

    private class XmlFileFilter implements FileFilter {
        private boolean testFilesOnly;

        private XmlFileFilter(boolean testFilesOnly) {
            this.testFilesOnly = testFilesOnly;
        }

        public boolean accept(File pathname) {
            String filter = ".xml";
            if (testFilesOnly) {
                filter = "Test.xml";
            }

            return pathname.getName().endsWith(filter);
        }
    }
}
