package c2g2.engine.graph;

import org.joml.Matrix4f;
import org.joml.Vector3f;

public class Camera {

    public Vector3f position;
    public Vector3f target;
    public Vector3f up;

    
    private final Vector3f rotation;

    
    public Camera() {
        position = new Vector3f(0, 0, 0);
        rotation = new Vector3f(0, 0, 0);
        target = new Vector3f(0, 0, -1);
        up = new Vector3f(0, 1, 0);
    }
    
    public Camera(Vector3f position, Vector3f rotation) {
        this.position = position;
        this.rotation = rotation;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(float x, float y, float z) {
        position.x = x;
        position.y = y;
        position.z = z;
    }
    
    public Vector3f getTarget(){
    	return target;
    }

    public void setTarget(Vector3f t){
        target = t;
    }


    
    public Vector3f getUp(){
    	return up;
    }
    
    public void setUp(Vector3f up){
    	this.up = up;
    }
    
    public void movePosition(float offsetX, float offsetY, float offsetZ) {
        if ( offsetZ != 0 ) {
            position.x += (float)Math.sin(Math.toRadians(rotation.y)) * 1.0f * offsetZ; // -1 here?
            position.z += (float)Math.cos(Math.toRadians(rotation.y)) * offsetZ;
        }
        if ( offsetX != 0) {
            position.x += (float)Math.sin(Math.toRadians(rotation.y - 90)) * -1.0f * offsetX;
            position.z += (float)Math.cos(Math.toRadians(rotation.y - 90)) * offsetX;
        }
        position.y += offsetY;
    }



    public Vector3f getRotation() {
        return rotation;
    }
    
    public void setRotation(float x, float y, float z) {
        rotation.x = x;
        rotation.y = y;
        rotation.z = z;
    }

    public void moveRotation(float offsetX, float offsetY, float offsetZ) {
        rotation.x += offsetX;
        rotation.y += offsetY;
        rotation.z += offsetZ;
    }
}