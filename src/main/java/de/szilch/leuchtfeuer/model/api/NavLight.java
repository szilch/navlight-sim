package de.szilch.leuchtfeuer.model.api;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szilch on 08.09.16.
 */
public class NavLight {

    private List<Phase> character = new ArrayList<>();
    private NavLightColor color = NavLightColor.WHITE;
    private NavLightType type;
    private int groups;
    private int recurrence;

    private NavLight(Builder b) {
        this.color = b.color;
        this.recurrence = b.recurrence;
        this.groups = b.groups > 1 ? b.groups : 1;
        this.type = b.type;
        character = type.getCharacteristic().create(recurrence, groups);
    }

    public boolean hasRecurrence() {
        return type.hasRecurrence();
    }

    public boolean hasGroups() {
        return type.hasGroups();
    }

    public List<Phase> getCharacter() {
        return character;
    }

    public int getGroups() {
        return groups;
    }

    public int getRecurrence() {
        return recurrence;
    }

    public NavLightColor getColor() {
        return color;
    }

    public long getMinimumRecurrenceInSec() {
        return ((character.stream().mapToLong(Phase::getMillis).sum()) / 1000);
    }

    public static class Builder {
        private NavLightColor color = NavLightColor.WHITE;
        private int recurrence;
        private int groups;
        private NavLightType type;

        public Builder(NavLightType type) {
            this.type = type;
        }

        public Builder color(NavLightColor color) {
            this.color = color;
            return this;
        }

        public Builder recurrence(int recurrence) {
            this.recurrence = recurrence;
            return this;
        }

        public Builder groups(int groups) {
            this.groups = groups;
            return this;
        }

        public NavLight build() {
            return new NavLight(this);
        }

    }

}
