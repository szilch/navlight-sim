package de.szilch.leuchtfeuer.model.characteristics;

import de.szilch.leuchtfeuer.model.api.NavLightCharacteristic;
import de.szilch.leuchtfeuer.model.api.Phase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by szilch on 09.09.16.
 */
public class FixedChar implements NavLightCharacteristic {

    @Override
    public List<Phase> create(int recurrence, int groups) {
        return Arrays.asList(new Phase(true,5000));
    }
}
