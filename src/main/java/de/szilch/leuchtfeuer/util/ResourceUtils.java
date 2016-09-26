package de.szilch.leuchtfeuer.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;

/**
 * Created by szilch on 10.09.16.
 */
public class ResourceUtils {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("UIResources");
    private static ResourceUtils instance;
    private MessageFormat formatter;

    private ResourceUtils() {
        formatter = new MessageFormat("");
        formatter.setLocale(BUNDLE.getLocale());
    }

    public static ResourceUtils getInstance() {
        if (instance == null) {
            instance = new ResourceUtils();
        }
        return instance;
    }

    public String getString(String key) {
        return BUNDLE.getString(key);
    }

    public String getString(String key, Object... param) {
        String message = BUNDLE.getString(key);
        formatter.applyPattern(message);
        return formatter.format(param);
    }
}
