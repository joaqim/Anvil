package com.artemis;

/**
 * Created with IntelliJ IDEA.
 * User: Joaqim
 * Date: 9/14/13
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Velocity extends Component {
    private float x;
    private float y;
    private float z;

    public Velocity() {
    }

    public Velocity(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float getXVector() {
        return x;
    }

    public float getYVector() {
        return y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setZ(float y) {
        this.y = y;
    }

    public void setVelocity(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void addX(float x) {
        this.x += x;
    }

    public void addY(float y) {
        this.y += y;
    }

    public void addZ(float z) {
        this.z = z;
    }
}
