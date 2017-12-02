package by.ilyacoding.servicehotels.locale;

import java.util.ResourceBundle;

/**
 * Created by ilyacoding on 11/24/2017.
 */
public enum LocalePropertyManager {
    INSTANCE;

    private final ResourceBundle bundle = ResourceBundle.getBundle("locale");

    public String getProperty(String key){
        return bundle.getString(key);
    }
}
