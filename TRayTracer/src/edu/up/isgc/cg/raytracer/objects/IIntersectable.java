package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*IIntersectable is just an interface in which classes Object3D and Triangle will be based off, Object3D will pass this same interface to
* another classes so they can override this same method, its just a simple method that will return an Intersection object, it will receive
* as a parameter a Ray object*/
public interface IIntersectable {
    Intersection getIntersection(Ray ray);
}
