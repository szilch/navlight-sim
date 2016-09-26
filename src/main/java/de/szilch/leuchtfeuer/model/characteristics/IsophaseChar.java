package de.szilch.leuchtfeuer.model.characteristics;

import de.szilch.leuchtfeuer.model.api.NavLightCharacteristic;
import de.szilch.leuchtfeuer.model.api.Phase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szilch on 09.09.16.
 *
 * An {@link IsophaseChar} consists of two {@link Phase} from same duration. One {@link Phase} is on and one is off.
 *
 */
public class IsophaseChar implements NavLightCharacteristic {

    @Override
    public List<Phase> create(int recurrence, int groups) {
        int takt = Math.max(Math.abs((recurrence * 1000) / 2),2000);
        List<Phase> character = new ArrayList<>();
        character.add(new Phase(true,takt));
        character.add(new Phase(false,takt));
        return character;
    }
}
