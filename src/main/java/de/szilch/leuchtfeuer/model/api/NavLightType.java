package de.szilch.leuchtfeuer.model.api;

import de.szilch.leuchtfeuer.model.characteristics.DefaultChar;
import de.szilch.leuchtfeuer.model.characteristics.FixedChar;
import de.szilch.leuchtfeuer.model.characteristics.IsophaseChar;
import de.szilch.leuchtfeuer.util.ResourceUtils;

import java.util.ResourceBundle;

/**
 * Created by szilch on 09.09.16.
 */
public enum NavLightType {

    FIXED(false, false, new FixedChar(),"light.fixed"),
    ISOPHASE(true, false, new IsophaseChar(),"light.isophase"),
    OCCULTING(true, true, new DefaultChar(DefaultChar.OCCULTING_ON, DefaultChar.OCCULTING_OFF),"light.occulting"),
    LONG_FLASH(true, true, new DefaultChar(DefaultChar.LONG_FLASH_ON, DefaultChar.LONG_FLASH_OFF),"light.longflash"),
    FLASH(true, true, new DefaultChar(DefaultChar.FLASH_ON, DefaultChar.FLASH_OFF),"light.flash"),
    QUICK(true, true, new DefaultChar(DefaultChar.QUICK_ON, DefaultChar.QUICK_OFF),"light.quick"),
    VERY_QUICK(true, true, new DefaultChar(DefaultChar.VERY_QUICK_ON, DefaultChar.VERY_QUICK_OFF),"light.veryquick");

    private boolean hasRecurrence;
    private boolean hasGroups;
    private String resourceKey;
    private NavLightCharacteristic characteristic;

    NavLightType(boolean hasRecurrence, boolean hasGroups, NavLightCharacteristic characteristic, String resourceKey) {
        this.hasGroups = hasGroups;
        this.hasRecurrence = hasRecurrence;
        this.characteristic = characteristic;
        this.resourceKey = resourceKey;
    }

    public boolean hasRecurrence() {
        return hasRecurrence;
    }

    public boolean hasGroups() {
        return hasGroups;
    }

    public NavLightCharacteristic getCharacteristic() {
        return characteristic;
    }

    @Override
    public String toString() {
        return ResourceUtils.getInstance().getString(resourceKey);
    }
}
