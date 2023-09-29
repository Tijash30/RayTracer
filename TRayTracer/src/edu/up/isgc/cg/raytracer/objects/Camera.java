package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;
import edu.up.isgc.cg.raytracer.Vector3D;

import java.awt.*;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*Camera class also extends from Object3D class, so it will share some atributes, but this class will also have by itself some private variables
* fieldofView, defaultZ, resolution and nearFarPlanes, this four will be used to get the angle and "screen" of the camera, it also has the varaibles shared
* with the Object3D*/
public class Camera extends Object3D{
    private double[] fieldOfView = new double[2];
    private double defaultZ = 15.0;
    /**/
    private int[] resolution;
    private double[] nearFarPlanes = new double[2];
    /*
    * This is the constructor, and in here is all pretty normal, it just assign the variables them values, and pass them all the way to
    * class Object#d */
    public Camera(Vector3D position, double fieldOfViewHorizontal, double fieldOfViewVertical,
                  int widthResolution, int heightResolution, double nearPlane, double farPlane, double ambient, double reflection, double frac) {
        super(position, Color.BLACK, ambient,reflection, frac);
        setFieldOfViewHorizontal(fieldOfViewHorizontal);
        setFieldOfViewVertical(fieldOfViewVertical);
        setResolution(new int[]{widthResolution, heightResolution});
        setNearFarPlanes(new double[]{nearPlane, farPlane});
    }

    public double[] getNearFarPlanes() {
        return nearFarPlanes;
    }

    private void setNearFarPlanes(double[] nearFarPlanes) {
        this.nearFarPlanes = nearFarPlanes;
    }

    public double[] getFieldOfView() {
        return fieldOfView;
    }

    private void setFieldOfView(double[] fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    public double getFieldOfViewHorizontal() {
        return fieldOfView[0];
    }

    public void setFieldOfViewHorizontal(double fieldOfViewHorizontal) {
        fieldOfView[0] = fieldOfViewHorizontal;
    }

    public double getFieldOfViewVertical() {
        return fieldOfView[1];
    }

    public void setFieldOfViewVertical(double fieldOfViewVertical) {
        fieldOfView[1] = fieldOfViewVertical;
    }

    public double getDefaultZ() {
        return defaultZ;
    }

    public void setDefaultZ(double defaultZ) {
        this.defaultZ = defaultZ;
    }

    public int[] getResolution() {
        return resolution;
    }

    public int getResolutionWidth() {
        return resolution[0];
    }

    public int getResolutionHeight() {
        return resolution[1];
    }

    private void setResolution(int[] resolution) {
        this.resolution = resolution;
    }
    /*
    * This function as it names says will calculate the position in which each ray intersects with the scene, it will help to get
    * by vectors all the field of view*/
    public Vector3D[][] calculatePositionsToRay() {
        double angleMaxX = getFieldOfViewHorizontal() / 2.0;
        double radiusMaxX = getDefaultZ() / (double) Math.cos(Math.toRadians(angleMaxX));

        double maxX = (double) Math.sin(Math.toRadians(angleMaxX)) * radiusMaxX;
        double minX = -maxX;

        double angleMaxY = getFieldOfViewVertical() / 2.0;
        double radiusMaxY = getDefaultZ() / (double) Math.cos(Math.toRadians(angleMaxY));

        double maxY = (double) Math.sin(Math.toRadians(angleMaxY)) * radiusMaxY;
        double minY = -maxY;

        Vector3D[][] positions = new Vector3D[getResolutionWidth()][getResolutionHeight()];
        double posZ = getDefaultZ();

        for (int x = 0; x < positions.length; x++) {
            for (int y = 0; y < positions[x].length; y++) {
                double posX = minX + (((maxX - minX) / (double) getResolutionWidth()) * x);
                double posY = maxY - (((maxY - minY) / (double) getResolutionHeight()) * y);
                positions[x][y] = new Vector3D(posX, posY, posZ);
            }
        }

        return positions;
    }
    /*
    * This is an override method form class Object3D that implements the interface iintersectable, so in here the method getIntersection
    * will return an Intersection object*/
    @Override
    public Intersection getIntersection(Ray ray) {
        return new Intersection(Vector3D.ZERO(), -1, Vector3D.ZERO(), null);
    }

}
