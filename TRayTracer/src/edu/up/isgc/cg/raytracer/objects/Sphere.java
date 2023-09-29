package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;
import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*
* Sphere is another class that extends form Object3D, it will have some attributes, that will help to create an Sphere in the scene
* it has, radius as the main variable of this class, it will have only one method that will function as a Intersection checker
* to draw the sphere in the scene*/
public class Sphere extends Object3D{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public Sphere(Vector3D position, double radius, Color color, double ambient, double reflection, double frac) {
        super(position, color, ambient, reflection, frac);
        setRadius(radius);
    }

    /*This is the main method of the class, and all its going to do is check if the cvalue of a formula i greater than 0,
    * if it is then it will return the intersection with its atributes*/
    @Override
    public Intersection getIntersection(Ray ray) {
        Vector3D L = Vector3D.substract(ray.getOrigin(), getPosition());
        double tca = Vector3D.dotProduct(ray.getDirection(), L);
        double L2 = Math.pow(Vector3D.magnitude(L), 2);
        //Intersection
        double d2 = Math.pow(tca, 2) - L2 + Math.pow(getRadius(), 2);
        if(d2 >= 0){
            double d = Math.sqrt(d2);
            double t0 = -tca + d;
            double t1 = -tca - d;

            double distance = Math.min(t0, t1);
            Vector3D position = Vector3D.add(ray.getOrigin(), Vector3D.scalarMultiplication(ray.getDirection(), distance));
            Vector3D normal = Vector3D.normalize(Vector3D.substract(position, getPosition()));
            return new Intersection(position, distance, normal, this);
        }

        return null;
    }
}
