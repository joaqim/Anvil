package com.artemis;

import com.artemis.utils.Bag;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/15/13
 * Time: 10:30 PM
 * To change this template use File | Settings | File Templates.
 */
public class TileMap extends Component {
    private ArrayList<Tile> tileArray;

    public TileMap() {

        tileArray = new ArrayList<Tile>(10);
        for(int x=0; x<64; x+=1) {
            for(int y=0; y<64; y+=1) {
                tileArray.add(new Tile(TileType.Stone));
            }
        }
    }

    public Tile getTile(int i) {
        return tileArray.get(i);
    }
}
