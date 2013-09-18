package com.artemis;

import com.artemis.utils.Bag;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/16/13
 * Time: 6:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Inventory extends Component {
    private Bag<Entity> items;

    public Inventory() {

    }

    public Inventory(Bag<Entity> items) {
        this.items = items;
    }

    public Entity getItem(int i) {
        return items.get(i);
    }

    public void addItem(Entity e) {
        items.add(e);
    }

    public boolean hasItem(Entity e) {
        return items.contains(e);
    }
}
