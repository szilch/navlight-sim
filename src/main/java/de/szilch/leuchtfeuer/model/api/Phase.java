package de.szilch.leuchtfeuer.model.api;

/**
 * Created by szilch on 08.09.16.
 */
public class Phase {

    public static final Phase BLINK = new Phase(true, 2000);
    public static final Phase BLINK_PAUSE = new Phase(true, 3000);
    public static final Phase BLITZ = new Phase(true, 900);
    public static final Phase BLITZ_PAUSE = new Phase(true, 2000);
    public static final Phase FUNKEL = new Phase(true, 500);
    public static final Phase FUNKEL_PAUSE = new Phase(false, 500);
    public static final Phase FUNKEL_SCHNELL = new Phase(true, 250);
    public static final Phase FUNKEL_SCHNELL_PAUSE = new Phase(false, 250);

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
