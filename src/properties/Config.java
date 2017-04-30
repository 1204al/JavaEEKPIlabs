package properties;

import java.util.ResourceBundle;


public class Config {

    private static Config instance;
    private ResourceBundle resource;
    private static final String BUNDLE_NAME = "properties.config";
    public static final String INDEX = "INDEX";
    public static final String PAGE = "PAGE";


    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
            instance.resource = ResourceBundle.getBundle(BUNDLE_NAME);

        }
        return instance;
    }

    private Config() {
    }

    public String getProperty(String key) {
        return (String) resource.getObject(key);
    }
}

