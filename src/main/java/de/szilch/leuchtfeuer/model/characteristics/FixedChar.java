package de.szilch.leuchtfeuer.model.characteristics;

import de.szilch.leuchtfeuer.model.api.NavLightCharacteristic;
import de.szilch.leuchtfeuer.model.api.Phase;

import java.util.Collections;
import java.util.List;

/**
 * Created by szilch on 09.09.16.
 * A {@link FixedChar} consists of exact ohne {@link Phase} which is enabled.
 */
public class FixedChar implements NavLightCharacteristic {

    @Override
    public List<Phase> create(int recurrence, int groups) {
        return Collections.singletonList(new Phase(true, 5000));
    }
}
