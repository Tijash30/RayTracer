package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Vector3D;
import java.awt.*;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*This is one of the most important classes, many classes have this one as a father class, because of its atributes, all of them are needed in
* many other classes, so in here thay are declered and they all have their getters and setters. Object3D also is an abstract class.
* And lastly, it implements the interface IIntersectable, so all of its children classes also implements it. We can see that with this attrivutes
* you can get and set all the information that an object has, thats whay the inportance of this little methods (getters and setters)
* so you can get or set its values simply.   */
public abstract class Object3D implements IIntersectable {
    private Color color;
    private Vector3D position;
    private double reflection;
    private double ambient;
    private double frac;

    public Object3D(Vector3D position, Color color, double ambient, double reflection, double frac) {
        setPosition(position);
        setColor(color);
        setcAmbient(ambient);
        setcReflection(reflection);
        setFrac(frac);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setPosition(Vector3D position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Vector3D getPosition() {
        return position;
    }

    public double getcReflection() {
        return reflection;
    }

    public void setcReflection(double cReflection) {
        this.reflection = cReflection;
    }

    public double getcAmbient() {
        return ambient;
    }

    public void setcAmbient(double cAmbient) {
        this.ambient = cAmbient;
    }
    public double getFrac() {
        return frac;
    }
    public void setFrac(double frac1) {
        this.frac = frac1;
    }

}


