package edu.up.isgc.cg.raytracer;

import edu.up.isgc.cg.raytracer.objects.Object3D;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*class intersection is going to be a class on which several (or almost all) other classes are going to be
based. It will have different attributes such as distance, normal, position and object each with its
hetters and setters. That's all this class has, it's only important to stress that this class will
support different methods that are overridden in different classes that implement the IIntersectable interface.
all this attributes gives an object of type Intersection all the information of a ray intersecting
with something or no.*/
public class Intersection {
    private double distance;
    private Vector3D normal;
    private Vector3D position;
    private Object3D object;
    public Intersection(Vector3D position, double distance, Vector3D normal, Object3D object) {
        setPosition(position);
        setDistance(distance);
        setNormal(normal);
        setObject(object);
    }
    public double   getDistance() {
        return distance;
    }
    public Vector3D getNormal() {
        return normal;
    }
    public Vector3D getPosition() {
        return position;
    }
    public Object3D getObject() {
        return object;
    }
    public void setDistance(double distance) {
        this.distance = distance;
    }
    public void setNormal(Vector3D normal) {
        this.normal = normal;
    }
    public void setPosition(Vector3D position) {
        this.position = position;
    }
    public void setObject(Object3D object) {
        this.object = object;
    }

}
