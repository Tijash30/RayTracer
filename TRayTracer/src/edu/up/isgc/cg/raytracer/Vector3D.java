package edu.up.isgc.cg.raytracer;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*
* Vector3D class will definitely be the most used in all the code, for all the calls, assignments
* and uses that these objects have in the code, literally the values ​​that a Vector3D type
* object stores are responsible for making all those operations functions . It has 3 floating private
* variables x, y and z that will be the ones that store the numerics of each vector. It will also
*  attain and initialize a Vector3D called ZERO, that its vna values ​​will be 3 0*/
public class Vector3D {
    private static final Vector3D ZERO = new Vector3D(0.0, 0.0, 0.0);
    private double x, y, z;

    public Vector3D(double x, double y, double z) {
        setX(x);
        setY(y);
        setZ(z);
    }
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public Vector3D clone(){
        return new Vector3D(getX(), getY(), getZ());
    }
    public static Vector3D ZERO(){
        return ZERO.clone();
    }
    @Override
    public String toString() {
        return "Vector3D{" +
                "x=" + getX() +
                ", y=" + getY() +
                ", z=" + getZ() +
                "}";
    }
    /*These functions that this class is going to have are going to be super important to make complicated calculations
    * of distance, normalization, dot product, etc. all these functions are clearly adapted to enter values ​​only
    * of type Vector3D and to return one too, these functions are implemented when working with these Vectors in other classes.*/
    public static double dotProduct(Vector3D vectorA, Vector3D vectorB){
        return (vectorA.getX() * vectorB.getX()) + (vectorA.getY() * vectorB.getY()) + (vectorA.getZ() * vectorB.getZ());
    }
    public static Vector3D crossProduct(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D((vectorA.getY() * vectorB.getZ()) - (vectorA.getZ() * vectorB.getY()),
                (vectorA.getZ() * vectorB.getX()) - (vectorA.getX() * vectorB.getZ()),
                (vectorA.getX() * vectorB.getY()) - (vectorA.getY() * vectorB.getX()));
    }
    public static double magnitude (Vector3D vectorA){
        return Math.sqrt(dotProduct(vectorA, vectorA));
    }
    public static Vector3D add(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D(vectorA.getX() + vectorB.getX(), vectorA.getY() + vectorB.getY(), vectorA.getZ() + vectorB.getZ());
    }
    public static Vector3D substract(Vector3D vectorA, Vector3D vectorB){
        return new Vector3D(vectorA.getX() - vectorB.getX(), vectorA.getY() - vectorB.getY(), vectorA.getZ() - vectorB.getZ());
    }
    public static Vector3D normalize(Vector3D vectorA){
        double mag = Vector3D.magnitude(vectorA);
        return new Vector3D(vectorA.getX() / mag, vectorA.getY() / mag, vectorA.getZ() / mag);
    }
    public static Vector3D scalarMultiplication(Vector3D vectorA, double scalar){
        return new Vector3D(vectorA.getX() * scalar, vectorA.getY() * scalar, vectorA.getZ() * scalar);
    }
}
