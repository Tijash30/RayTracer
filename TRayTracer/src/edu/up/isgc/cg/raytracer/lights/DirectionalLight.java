package edu.up.isgc.cg.raytracer.lights;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */

/*
* This class at it saids right below this, extends the abstract class Light, when a new directionalLight object
* is created it will request thw following parameters: direction, color, intensity, ambient and reflection, this last two
* will never be used in this class, so it will automatically ignored them because their value will always be 0.
* */
public class DirectionalLight extends Light{

    private Vector3D direction;
    /*
    * the constructor assign and pass the parameters to the next class, and direction gets a new value thanks
    * to the normalize method in the class Vector3D, the value of the direction will now be normalize*/
    public DirectionalLight(Vector3D direction, Color color, double intensity, double ambient, double reflection, double frac) {
        super(Vector3D.ZERO(), color, intensity, ambient, reflection, frac);
        setDirection(Vector3D.normalize(direction));
    }

    public Vector3D getDirection() {
        return direction;
    }

    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }

    /*
    * Here we override the abstract method expressed in the abstract class Light, it will return the greater number between
    * the dotProduct of the normal of the intersection and another vector, and it will check with the result of this dot product
    * and 0.*/
    @Override
    public double getNDotL(Intersection intersection) {
        return Math.max(Vector3D.dotProduct(intersection.getNormal(), Vector3D.scalarMultiplication(getDirection(), -1.0)), 0.0);
    }
}
