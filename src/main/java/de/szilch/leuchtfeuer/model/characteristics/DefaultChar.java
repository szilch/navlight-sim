package de.szilch.leuchtfeuer.model.characteristics;

import de.szilch.leuchtfeuer.model.api.NavLightCharacteristic;
import de.szilch.leuchtfeuer.model.api.Phase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szilch on 09.09.16.
 */
public class DefaultChar implements NavLightCharacteristic {

    public static final Phase OCCULTING_ON = new Phase(false,1000);
    public static final Phase OCCULTING_OFF = new Phase(true,2000);

    public static final Phase LONG_FLASH_ON = new Phase(true,2000);
    public static final Phase LONG_FLASH_OFF = new Phase(false,3000);

    public static final Phase FLASH_ON = new Phase(true,1000);
    public static final Phase FLASH_OFF = new Phase(false,2000);

    public static final Phase QUICK_ON = new Phase(true,500);
    public static final Phase QUICK_OFF = new Phase(false,500);

    public static final Phase VERY_QUICK_ON = new Phase(true,250);
    public static final Phase VERY_QUICK_OFF = new Phase(false,250);

    private Phase phaseOn;
    private Phase phaseOff;

    public DefaultChar(Phase on, Phase off) {
        this.phaseOn = on;
        this.phaseOff = off;
    }

    @Override
    public List<Phase> create(int recurrence, int groups) {
        List<Phase> character = new ArrayList<>();
        for (int i = 0; i < groups; i++) {
            character.add(phaseOn);
            character.add(phaseOff);
        }
        long restRecurrence = (recurrence * 1000) - getCalculatedRecurrence(character);
        if (restRecurrence > 0) {
            character.add(new Phase(phaseOff.isOn(),restRecurrence));
        }
        return character;
    }

    private long getCalculatedRecurrence(List<Phase> character) {
        return character.stream().mapToLong(Phase::getMillis).sum();
    }
}
