package edu.up.isgc.cg.raytracer;

import edu.up.isgc.cg.raytracer.lights.Light;
import edu.up.isgc.cg.raytracer.objects.Camera;
import edu.up.isgc.cg.raytracer.objects.Object3D;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*The scene class will be in charge of storing all the things that will be in the
* scene, that is: a list of objects, a list of lights and a Camera object. These
* three objects will have their own getters and sstters, the list of light objects
* and objects will have their getters a bit interesting, if the value that you have
* does not exist, has not been created or is null a new one is returned empty list,
* indicating that it is totally new because nothing had been created yet.}*/
public class Scene {
    private Camera camera;
    private List<Object3D> objects;
    private List<Light> lights;
    public Scene() {
        setObjects(new ArrayList<>());
        setLights(new ArrayList<>());
    }

    public List<Light> getLights() {
        if (lights == null) {
            setLights(new ArrayList<>());
        }
        return lights;
    }

    public void setLights(List<Light> lights) {
        this.lights = lights;
    }

    public void addLight(Light light) {
        getLights().add(light);
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }
    public void addObject(Object3D object) {
        getObjects().add(object);
    }

    public List<Object3D> getObjects() {
        if (objects == null) {
            objects = new ArrayList<>();
        }
        return objects;
    }

    public void setObjects(List<Object3D> objects) {
        this.objects = objects;
    }
}
