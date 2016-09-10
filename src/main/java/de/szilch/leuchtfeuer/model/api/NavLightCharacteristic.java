package de.szilch.leuchtfeuer.model.api;

import java.util.List;

/**
 * Created by szilch on 09.09.16.
 */
public interface NavLightCharacteristic {

    List<Phase> create(int recurrence, int groups);

}
