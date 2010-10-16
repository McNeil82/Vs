package de.moralis.logging;

import de.moralis.logging.xslt.LoggingTransformer;

public class TransformLog {
    public static void main(String[] args) {
        new LoggingTransformer().createHtml();
    }
}
