package de.moralis.vs;

import de.moralis.vs.logging.xslt.LoggingTransformer;

public class TransformLog {
    public static void main(String[] args) {
        new LoggingTransformer().createHtml();
    }
}
