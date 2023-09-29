package edu.up.isgc.cg.raytracer.lights;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*PointLight extends also from the abstract class Light and it will need to receive the following parameters: position , color
* intensity, ambient and reflection. */
public class PointLight extends Light{
    private Vector3D position;
    /*This is the constructor, we can see that it will request almost the same as directional, but in here instead
    * of a direction on the light it will need a position value*/
    public PointLight(Vector3D position, Color color, double intensity, double ambient, double reflection, double frac) {
        super(Vector3D.ZERO(), color, intensity, ambient, reflection, frac);
        setPosition(Vector3D.normalize(position));
    }

    public Vector3D getPosition() {
        return position;
    }
    public Vector3D getDirection(Vector3D posIntersction) {
        return Vector3D.normalize(Vector3D.substract(posIntersction, position));
    }

    public void setPosition(Vector3D direction) {
        this.position = direction;
    }

    /*here we have the override method and it will ask for a Intersection parameter, it will do almost the same procedura as
    * directionalLight class did, but here the formula to get the max value will be a bit differen.*/
    @Override
    public double getNDotL(Intersection intersection) {
        return Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.scalarMultiplication(getDirection(intersection.getPosition()), -1.0)), 0.0);
    }
}
