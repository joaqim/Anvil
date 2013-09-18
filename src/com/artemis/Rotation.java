package com.artemis;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/14/13
 * Time: 9:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class Rotation extends Component {
    private float rot;

    public Rotation() {
    }

    public Rotation(float rot) {
        this.rot = rot;
    }

    public float getRot() {
        return rot;
    }

    public void setRot(float rot) {
        this.rot = rot;
    }

    public void addRot(float rot) {
        this.rot += rot;
    }
}
