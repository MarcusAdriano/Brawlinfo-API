package io.github.marcusadriano.bscomparatorapi;

import io.github.marcusadriano.bscomparatorapi.converter.Json2ProtoPlayerConverter;
import lombok.Getter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

@Getter
public class Config {

    private static Config INSTANCE = null;
    private static final Object lock = new Object();

    // constants
    public static final String CONFIG_SERVER_PORT = "server.port";
    public static final String CONFIG_BS_API_KEY = "bs.server.apikey";
    public static final String CONFIG_BS_API_URL = "bs.server.apiUrl";

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
            String port = get(CONFIG_SERVER_PORT, "8080");
            return Integer.parseInt(port);
        } catch (NumberFormatException e) {
            return 8080;
        }
    }

    public String getBSApiUrl() {
        return get(CONFIG_BS_API_URL, "API_URL");
    }

    public String getBSApiKey() {
        return get(CONFIG_BS_API_KEY, "API_KEY");
    }

    public String get(String key, String defaultValue) {
        return Optional.ofNullable(System.getenv(CONFIG_SERVER_PORT))
                .orElse(props.getProperty(CONFIG_SERVER_PORT, defaultValue));
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
