package edu.up.isgc.cg.raytracer;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*lightning class may be the most used class in all the code, it has 2 private variables:
* source and address. It has its getters and setters, but it is important to mention that
* when you want to know the address value (when using the address getter), it returns it to
* you normalized. the other functions are given to you and put as they are.
* The ray class has several uses throughout the code because in reality this code works based
* on what the mathematics of the rays that are thrown say to know what is in the scene and
* what is not. Maybe this class doesn't have any method that has any important function with
* operations, but in other sw classes they use Ray type objects to know about the collisions
* that are in the scene.*/
public class Ray {
    private Vector3D origin;
    private Vector3D direction;
    public Ray(Vector3D origin, Vector3D direction) {
        setOrigin(origin);
        setDirection(direction);
    }
    public Vector3D getOrigin() {
        return origin;
    }
    public Vector3D getDirection() {
        return Vector3D.normalize(direction);
    }
    public void setOrigin(Vector3D origin) {
        this.origin = origin;
    }
    public void setDirection(Vector3D direction) {
        this.direction = direction;
    }
}
