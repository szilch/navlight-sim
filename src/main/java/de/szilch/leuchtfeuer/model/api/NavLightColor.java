package de.szilch.leuchtfeuer.model.api;

import de.szilch.leuchtfeuer.util.ResourceUtils;

/**
 * Created by szilch on 09.09.16.
 *
 * NavLight Colors
 */
public enum NavLightColor {
    BLUE("#0101DF", "color.blue"),
    YELLOW("#FFFF00", "color.yellow"),
    GREEN("#7BC618", "color.green"),
    ORANGE("#FFBF00", "color.orange"),
    RED("#FF0000", "color.red"),
    VIOLET("#BF00FF", "color.violet"),
    WHITE("#FFFFC6", "color.white");


    private String hexValue;
    /**
     * used for the frontend in order to be multilingual
     */
    private String resourceKey;

    NavLightColor(String hexValue, String resourceKey) {
        this.hexValue = hexValue;
        this.resourceKey = resourceKey;
    }

    public String getHexValue() {
        return this.hexValue;
    }

    @Override
    public String toString() {
        return ResourceUtils.getInstance().getString(resourceKey);
    }
}
