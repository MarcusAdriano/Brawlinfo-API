package io.github.marcusadriano.bscomparatorapi;

import lombok.Getter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

@Getter
public class Config {

    private static Config INSTANCE = null;
    private static final Object lock = new Object();

    // constants
    public static final String CONFIG_SERVER_PORT = "server.port";

    public static Config getInstance() {
        if (INSTANCE == null) {
            synchronized(lock) {
                if (INSTANCE == null) {
                    INSTANCE = new Config();
                }
            }
        }
        return INSTANCE;
    }

    private Properties props;

    private Config() {
        props = readPropertiesFile();
    }

    public int getServerPort() {
        try {
            return Integer.parseInt(props.getProperty(CONFIG_SERVER_PORT, "8080"));
        } catch (NumberFormatException e) {
            return 8080;
        }
    }

    private Properties readPropertiesFile() {
        Properties prop = null;
        try {
            InputStream in = getClass().getResourceAsStream("/application.properties");
            prop = new Properties();
            prop.load(in);
        } catch(IOException e) {
            e.printStackTrace();
        }
        return prop;
    }
}
