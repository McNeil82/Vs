package de.moralis.testapi;

import de.moralis.logging.Logger;
import org.testng.annotations.BeforeTest;

import static java.util.logging.Level.ALL;

public abstract class AbstractTest {
    protected final Logger log = Logger.createLogger(this.getClass().getName());

    @BeforeTest
    public void setUp() {
        log.setLogLevel(ALL);
    }
}
