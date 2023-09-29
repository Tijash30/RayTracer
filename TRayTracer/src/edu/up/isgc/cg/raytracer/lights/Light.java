package edu.up.isgc.cg.raytracer.lights;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;
import edu.up.isgc.cg.raytracer.Vector3D;
import edu.up.isgc.cg.raytracer.objects.Object3D;

import java.awt.*;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */

/*
* This class will have 2 children, pointLight and DirectionalLight, both of them will request their own values, but when you create a
* Light object it will necessarily have a value nanmed intensity, htis will indicate how much intensity the light will have.
* This class is abstract because it will have its own abstract method named getNDotL() an it will received as a parameter an
* Intersection value, Point and Directional light classes will override this same method by their own ways.
* we can see also that this class extends from the class Object3D, so Point and Directional will too.
* */
public abstract class Light extends Object3D {
    private double intensity;
    /*
    * This constructor is pretty normal, it will just asign the values passed*/
    public Light(Vector3D position, Color color, double intensity, double ambient, double reflection , double frac) {
        super(position, color, ambient, reflection, frac);
        setIntensity(intensity);
    }

    public double getIntensity() {
        return intensity;
    }

    public void setIntensity(double intensity) {
        this.intensity = intensity;
        
    }
    /*For this abstract method, as i said befora it will request an Intersection value, this value will be given by another method
    * here in this class also, named getIntersection, that receives as a parameter a Ray and it will return a new Intersection object.*/
    public abstract double getNDotL(Intersection intersection);

    public Intersection getIntersection(Ray ray) {
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }

}
