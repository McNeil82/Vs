package de.moralis.testapi;

import de.moralis.logging.Logger;
import de.moralis.logging.LoggingTransformer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static java.util.logging.Level.ALL;

public abstract class AbstractTest {
    protected final Logger log = Logger.createLogger(this.getClass().getName());

    @BeforeTest
    public void setUp() {
        log.setLogLevel(ALL);
    }

    @AfterTest
    public void tearDown() {
        new LoggingTransformer().createHtml(true);
    }
}
