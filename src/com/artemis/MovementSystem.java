package com.artemis;

import com.artemis.annotations.Mapper;
import com.artemis.systems.EntityProcessingSystem;
import org.newdawn.slick.GameContainer;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/14/13
 * Time: 9:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class MovementSystem extends EntityProcessingSystem {
    @Mapper ComponentMapper<Position> pm;
    @Mapper ComponentMapper<Velocity> vm;

    public MovementSystem() {
        super(Aspect.getAspectForAll(Position.class, Velocity.class));
    }

    protected void process(Entity e) {
        // Get the components from the entity using component mappers.
        Position position = pm.get(e);
        Velocity velocity = vm.get(e);

        // Update the position.
        position.addX(velocity.getXVector() * world.getDelta());
        position.addY(velocity.getYVector() * world.getDelta());
    }
}
