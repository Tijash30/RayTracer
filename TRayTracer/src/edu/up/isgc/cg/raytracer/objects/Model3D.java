package edu.up.isgc.cg.raytracer.objects;

import edu.up.isgc.cg.raytracer.Intersection;
import edu.up.isgc.cg.raytracer.Ray;
import edu.up.isgc.cg.raytracer.Vector3D;
import edu.up.isgc.cg.raytracer.tools.Barycentric;

import java.awt.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*
* Model3D is child of class Object3D and it will have mainly a vairbale of List of Triangles class objects named traingles,
*  this list will have Objects of traingles of each object that come to this class.*/
public class Model3D extends Object3D{
    private List<Triangle> triangles;

    public Model3D(Vector3D position, Triangle[] triangles, Color color, double ambient,double reflection, double frac) {
        super(position, color, ambient,reflection,frac);
        setTriangles(triangles);
    }

    public List<Triangle> getTriangles() {
        return triangles;
    }
    /*This method will give the value of the vertex of each triangles, each one of them will have their own value by passing on both fors
    * */
    public void setTriangles(Triangle[] triangles) {
        Vector3D position = getPosition();
        Set<Vector3D> uniqueVertices = new HashSet<>();
        for (Triangle triangle : triangles) {
            uniqueVertices.addAll(Arrays.asList(triangle.getVertices()));
        }

        for (Vector3D vertex : uniqueVertices) {
            vertex.setX(vertex.getX() + position.getX());
            vertex.setY(vertex.getY() + position.getY());
            vertex.setZ(vertex.getZ() + position.getZ());
        }

        this.triangles = Arrays.asList(triangles);
    }
    /*This method is form the interface of intersectable, and here Model3D overrides it, returning an Intersection object
    * with the value checking if there is an intersection with any triangle. This method is also used in RayTracer class*/
    @Override
    public Intersection getIntersection(Ray ray) {
        double distance = -1;
        Vector3D normal = Vector3D.ZERO();
        Vector3D position = Vector3D.ZERO();

        for (Triangle triangle : getTriangles()) {
            Intersection intersection = triangle.getIntersection(ray);
            double intersectionDistance = intersection.getDistance();
            if (intersection != null && intersectionDistance > 0 &&
                    (intersectionDistance < distance || distance < 0)) {
                distance = intersectionDistance;
                position = Vector3D.add(ray.getOrigin(), Vector3D.scalarMultiplication(ray.getDirection(), distance));
                //normal = triangle.getNormal();
                normal = Vector3D.ZERO();
                double[] uVw = Barycentric.CalculateBarycentricCoordinates(position, triangle);
                Vector3D[] normals = triangle.getNormals();
                for (int i = 0; i < uVw.length; i++) {
                    normal = Vector3D.add(normal, Vector3D.scalarMultiplication(normals[i], uVw[i]));
                }
            }
        }

        if (distance == -1) {
            return null;
        }

        return new Intersection(position, distance, normal, this);
    }
}
