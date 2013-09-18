package com.artemis;

import org.newdawn.slick.Color;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/16/13
 * Time: 2:38 AM
 * To change this template use File | Settings | File Templates.
 */
public enum TileType {
    Unused {
        public boolean isSolid()
        {
            return false;
        }
        public Color getColor()
        {
            return Color.darkGray;
        }
    },
    Stone {
        public boolean isSolid() {
            return true;
        }
        public Color getColor()
        {
            return Color.white;
        }
    };

    public abstract boolean isSolid();

    public Color getColor() {
        return Color.black;
    }
}
