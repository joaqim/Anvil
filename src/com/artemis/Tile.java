package com.artemis;

import com.artemis.utils.Bag;
import org.newdawn.slick.Color;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/15/13
 * Time: 2:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Tile extends Component {
    private TileType tileType;

    public Tile() {
    }

    public Tile(TileType tileType) {
        this.tileType = tileType;
    }

    public TileType getTileType() {
        return tileType;
    }

    public void setTileType(TileType tileType) {
        this.tileType = tileType;
    }
}
