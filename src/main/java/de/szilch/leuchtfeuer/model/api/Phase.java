package de.szilch.leuchtfeuer.model.api;

/**
 * Created by szilch on 08.09.16.
 *
 * A {@link Phase} is a period of configured millis where the light is enabled (on) or disabled (off)
 */
public class Phase {

    private boolean isOn;
    private long millis;

    public Phase(boolean isOn, long millis) {
        this.isOn = isOn;
        this.millis = millis;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public long getMillis() {
        return millis;
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }
}
