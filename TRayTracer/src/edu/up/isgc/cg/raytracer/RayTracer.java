package edu.up.isgc.cg.raytracer;

import edu.up.isgc.cg.raytracer.lights.DirectionalLight;
import edu.up.isgc.cg.raytracer.lights.Light;
import edu.up.isgc.cg.raytracer.lights.PointLight;
import edu.up.isgc.cg.raytracer.objects.*;
import edu.up.isgc.cg.raytracer.tools.OBJReader;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Tijash Salamanca
 * @author Jafet Rodríguez
 */
/*
* RayTracer is the main class, where all teh other classes, methods and atributes join to make a super raytracer and render stuff
* here is where i implement all the classes, thay all get use in here. Ray tracer has only one attribute, shininess and 10 functions
* including main, all of this methods work together to create a final image that will show a final render of all the objects and lights
* specified*/
public class RayTracer {
    //deleteeeee
    static double shininess = 100;
    /*It all starts in the main you first got to create a scene object with the specifications that you want of the field of view
    * nearplanes, etc, after this uou gotta tell the program which objects/figures and lights you wnat to include in the scene
    * that will be output, the when you got all ready in th escene, yo call a function named raytrace which will receive as a parameter
    * the name of the scene object. */
    public static void main(String[] args) {
        System.out.println(new Date());

        Scene scene02 = new Scene();
        scene02.setCamera(new Camera(new Vector3D(0, 0, -4), 96, 60, 1920, 1080, 0.6, 50.0, 0.0,0, 0));
        //scene02.setCamera(new Camera(new Vector3D(0, 0, -4), 60, 60, 800, 800, 0.6, 50.0, 0.0,0, 0));


        //Scene11111
        /*scene02.addLight(new PointLight(new Vector3D(0.0, 0.2, 0.0), Color.WHITE, 0.9, 0.0,0));
        scene02.addLight(new DirectionalLight(new Vector3D(0.0, -1.0, 0.0), Color.WHITE, 0.6, 0.0,  0));

        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(-2.3, -2.5, 0.0), Color.BLUE, 0.0,0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 0.0), Color.PINK, 0.0,1));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(-2.3, -2.5, 4.6), Color.PINK, 0.0,1));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 4.6), Color.BLUE, 0.0,0));


        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-2.5, -2.5, 1.0), new Color(255, 255, 255), 0.05,0));
        scene02.addObject(OBJReader.getModel3D("manz.obj", new Vector3D(-2.5, -1.5, 1.0),  Color.RED, 0.0,0));

        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1.0, -2.5, 2.0), new Color(255, 255, 255), 0.05,0));
        scene02.addObject(OBJReader.getModel3D("platanofinal.obj", new Vector3D(1.0, -1.5, 2.0),  Color.YELLOW, 0.0,0));

        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(2.6, -2.5, 1.4), Color.RED, 0.05,0));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(4.0, -2.5, 1.4), Color.RED, 0.05,0));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(3.2, -1.5, 1.4), Color.RED, 0.05,0));

        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(-1.0, -2.5, 6.0),  Color.GREEN, 0.0,0));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(-1.0, -2.5, -0.2),  Color.CYAN, 0.0,0));*/

        //Scene 2:
        scene02.addLight(new PointLight(new Vector3D(-3.0, 4.2, 0.0), Color.WHITE, 0.9, 0.0,0, 0));
        scene02.addLight(new PointLight(new Vector3D(3.0, 4.2, 0.0), Color.WHITE, 0.9, 0.0,0, 0));

        scene02.addLight(new DirectionalLight(new Vector3D(0.0, 0.0, -1.0), Color.WHITE, 0.9, 0.0,  0, 0));
        scene02.addLight(new DirectionalLight(new Vector3D(1.0, 0.0, 0.0), Color.WHITE, 0.9, 0.0,  0, 0));

        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(-2.3, -2.5, 0.0), new Color(0, 123, 89), 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 0.0), new Color(0, 123, 89), 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(-2.3, -2.5, 4.6), new Color(0, 123, 89), 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 4.6), new Color(0, 123, 89), 0.0,0, 0));

        scene02.addObject(OBJReader.getModel3D("fondo.obj", new Vector3D(0.7, -5.5, 2.7), Color.BLUE, 0.0,1, 0));

        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1.7, -2.6, 0.8), Color.ORANGE, 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1.7, -1.6, 0.8), Color.ORANGE, 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(-1.4, -2.7, 1.4), Color.RED, 0.0,0, 0));

        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4.5, -2.6, -1.6), Color.ORANGE, 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(4.5, -1.6, -1.6), Color.ORANGE, 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(4.5, -0.6, -1.6), Color.RED, 0.0,0, 0));

        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0.5, -2.6, 1.0), Color.ORANGE, 0.0,0, 1.3));
        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1.5, -2.6, 1.0), Color.ORANGE, 0.0,0, 1.3));
        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(1.5, -1.6, 1.0), Color.ORANGE, 0.0,0, 1.3));

        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(-1.4, -2.9, -1.2), Color.ORANGE, 0.0,0, 0));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(-1.4, -2.0, -1.2), Color.RED, 0.0,0, 0));

        //scene 3:
        /*scene02.addLight(new PointLight(new Vector3D(0.0, 0.2, 0.0), Color.WHITE, 0.9, 0.0,0, 0));
        scene02.addLight(new PointLight(new Vector3D(0.0, 0.2, 2.0), Color.WHITE, 0.9, 0.0,0, 0));
        scene02.addLight(new DirectionalLight(new Vector3D(0.0, 0.0, -1.0), Color.WHITE, 0.9, 0.0,  0, 0));
        scene02.addLight(new DirectionalLight(new Vector3D(1.0, 0.0, 0.0), Color.WHITE, 0.9, 0.0,  0, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 0.0), Color.BLUE, 0.07,0, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(-2.3, -2.5, 4.6), Color.BLUE, 0.07,0, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 4.6), Color.BLUE, 0.07,0, 0));

        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-4.2, -3.5, 2.0), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-3.0, -3.5, 2.0), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-1.8, -3.5, 2.0), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-0.6, -3.5, 2.0), Color.RED, 0.0,0.5, 0));

        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-4.2, -3.5, 0.8), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-3.0, -3.5, 0.8), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-1.8, -3.5, 0.8), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-0.6, -3.5, 0.8), Color.RED, 0.0,0.5, 0));

        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-4.2, -3.5, -1.6), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-3.0, -3.5, -1.6), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-1.8, -3.5, -1.6), Color.RED, 0.0,0.5, 0));
        scene02.addObject(OBJReader.getModel3D("pico.obj", new Vector3D(-0.6, -3.5, -1.6), Color.RED, 0.0,0.5, 0));

        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(1.8, -2.5, 0.7), Color.GREEN, 0.05,0.0, 1.3));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(-2.8, -2.5, 3.2), Color.PINK, 0.05,0.0, 1));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(0.0, -2.5, 4.0), Color.CYAN, 0.05,0.0, 1));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(3.2, -2.5, 3.2), Color.MAGENTA, 0.05,0.0, 1.3));
        scene02.addObject(OBJReader.getModel3D("cora.obj", new Vector3D(-2.2, 0.1, 2.2), Color.RED, 0.09,0.0, 0));*/


        scene02.addLight(new PointLight(new Vector3D(-2.0, 0.2, 0.0), Color.WHITE, 0.9, 0.0,0, 0));
        scene02.addLight(new PointLight(new Vector3D(2.0, 0.2, 0.0), Color.WHITE, 0.9, 0.0,0, 0));

        //scene02.addLight(new DirectionalLight(new Vector3D(0.0, 0.0, -1.0), Color.WHITE, 0.9, 0.0,  0));
        //scene02.addLight(new DirectionalLight(new Vector3D(1.0, 0.0, 0.0), Color.WHITE, 0.9, 0.0,  0));
        /*scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 0.0), Color.BLUE, 0.07,1, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(-2.3, -2.5, 0.0), Color.BLUE, 0.07,1, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(-2.3, -2.5, 4.6), Color.BLUE, 0.07,1, 0));
        scene02.addObject(OBJReader.getModel3D("plano.obj", new Vector3D(2.3, -2.5, 4.6), Color.BLUE, 0.07,1, 0));
        scene02.addObject(OBJReader.getModel3D("Cube.obj", new Vector3D(0.0, -2.5, 1.0), Color.PINK, 0.00,0, 0));*/
        /*In here is the call to the main function raytrace where the rendering starts, and here i also create the image
        * that will be output*/
        BufferedImage image = raytrace(scene02);
        File outputImage = new File("image.png");
        try {
            ImageIO.write(image, "png", outputImage);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(new Date());
    }
    /*
    * In this function, the raytrace process is going to start, the camera is created, a list of objects and lights,
    * and more importantly, an executorservice type object is created that will serve to parallelize our code and
    * thus make the renders faster. After this, a double for is started that will be the one that goes through each
    * space of the camera's field of view, and each of these pixels will go to another function where they will be
    * assigned a specific color. Passing these two fors, it is important to note that the executorservice that we
    * had previously had to be shutdown must be done. */
    public static BufferedImage raytrace(Scene scene) {

        Camera mainCamera = scene.getCamera();

        BufferedImage image = new BufferedImage(mainCamera.getResolutionWidth(), mainCamera.getResolutionHeight(), BufferedImage.TYPE_INT_RGB);
        List<Object3D> objects = scene.getObjects();
        List<Light> lights = scene.getLights();

        ExecutorService executorService= Executors.newFixedThreadPool(12);


        Vector3D[][] positionsToRaytrace = mainCamera.calculatePositionsToRay();
        for (int i = 0; i < positionsToRaytrace.length; i++) {
            for (int j = 0; j < positionsToRaytrace[i].length; j++) {
                Runnable runnable= draw(i, j, positionsToRaytrace, image, objects, lights, mainCamera);
                executorService.execute(runnable);
            }
        }

        System.out.println(new Date());
        executorService.shutdown();
        try{

            if(!executorService.awaitTermination(10, TimeUnit.MINUTES)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {

            throw new RuntimeException(e);
        } finally {
            if(!executorService.isTerminated()){
                System.err.println("Cancel non-finished");
            }
        }
        executorService.shutdownNow();

        return image;
    }
    public static float clamp(double value, double min, double max) {
        if (value < min) {
            return (float) min;
        }
        if (value > max) {
            return (float) max;
        }
        return (float) value;
    }
    /*This function will join two colors, for example if a pixel was detected to have a reflection
    after having set it to already have a color, then that new color is added to the one it already
    had before. This way the pixels are better painted and with more detail*/
    public static Color addColor(Color original, Color otherColor) {
        float red = clamp((original.getRed() / 255.0) + (otherColor.getRed() / 255.0), 0, 1);
        float green = clamp((original.getGreen() / 255.0) + (otherColor.getGreen() / 255.0), 0, 1);
        float blue = clamp((original.getBlue() / 255.0) + (otherColor.getBlue() / 255.0), 0, 1);
        return new Color(red, green, blue);
    }
    /*Lightning collides in its trajectory with something, some object, light, with nothing. One use
    * of this function is to check for shadows, start the beam at a triangle of an object, and try
    * to get to the position of the light. then it checks, if there is a collision with something in
    * its path, then it means that there is a shadow. it will return an intersection type object,
    * and that's it, this can be used for anything.*/
    public static Intersection raycast(Ray ray, List<Object3D> objects, Object3D caster, double[] clippingPlanes) {
        Intersection closestIntersection = null;

        for (int k = 0; k < objects.size(); k++) {
            Object3D currentObj = objects.get(k);
            if (caster == null || !currentObj.equals(caster)) {
                Intersection intersection = currentObj.getIntersection(ray);
                if (intersection != null) {
                    double distance = intersection.getDistance();
                    double intersectionZ = intersection.getPosition().getZ();
                    if (distance >= 0 &&
                            (closestIntersection == null || distance < closestIntersection.getDistance()) &&
                            (clippingPlanes == null || (intersectionZ >= clippingPlanes[0] && intersectionZ <= clippingPlanes[1]))) {
                        closestIntersection = intersection;
                    }
                }
            }
        }

        return closestIntersection;
    }
    /*draw is the most important function, this is where the colors are assigned to each pixel that
    * goes into this function. It's important to note that at the beginning of this function a method
    *  is made to parallelize this big method and everything inside it. The function itself starts by
    * taking the exact position where the rays are going to be thrown, this is to pass this parameter
    * to the raycast function and it returns the intersection type object, if there is an intersection
    * with something then it goes to the next conditional , if what is returned is null then the pixel
    * is automatically painted black*/
    public static Runnable draw(int i, int j, Vector3D[][] positionsToRaytrace, BufferedImage image, List<Object3D> objects, List<Light> lights, Camera mainCamera){
        //with your help i created the parallel Method
        Runnable aRunnable = new Runnable() {
            @Override
            public void run() {
                double x = positionsToRaytrace[i][j].getX() + mainCamera.getPosition().getX();
                double y = positionsToRaytrace[i][j].getY() + mainCamera.getPosition().getY();
                double z = positionsToRaytrace[i][j].getZ() + mainCamera.getPosition().getZ();
                double[] nearFarPlanes = mainCamera.getNearFarPlanes();
                double cameraZ = mainCamera.getPosition().getZ();

                Ray ray = new Ray(mainCamera.getPosition(), new Vector3D(x, y, z));
                Intersection closestIntersection = raycast(ray, objects,null, new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});

                Color pixelColor = Color.BLACK;
                if (closestIntersection != null) {

                    Color objColor = closestIntersection.getObject().getColor();

                    for (Light light : lights) {
                        /*then as it detected that there is something there in space, then it sends itself to check if there
                        * are shadows, to check this the raycast function is called again but now checking with the position
                        * of the light that is being iterated in the for. If what is returned is null, then that means that the
                        * ray did not collide with anything, then there is no shadow, but if it did collide with something,
                        * it goes away and the pixel is painted directly black*/
                        Vector3D rayPosOrig = Vector3D.add(new Vector3D(0.000000001, 0.000000001, -0.000000001), closestIntersection.getPosition());
                        Ray rayToLight = new Ray(rayPosOrig, Vector3D.substract(light.getPosition(), closestIntersection.getPosition()));
                        Intersection intersectLight = raycast(rayToLight, objects, null, new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
                        if(intersectLight == null) {

                            /*here for the first time the color pixelColor grabs a value by going to the BlinnPhong function
                            * and then checking if the object is reflective with something.*/
                            pixelColor= blinnPhong(closestIntersection, pixelColor, light, mainCamera, 1);

                            //reeeeee
                            pixelColor= getReflection(pixelColor, closestIntersection, light, mainCamera, rayPosOrig, objects, cameraZ, nearFarPlanes);

                            //refrac
                            pixelColor= refraction(pixelColor, closestIntersection, light, mainCamera, rayPosOrig, objects, cameraZ, nearFarPlanes);




                        }else{
                            pixelColor = Color.BLACK;
                        }
                    }
                }
                /*here you pass the coordinate of the image and the color that was found*/
                setRGB(image, i, j, pixelColor);
            }
        };
        return aRunnable;
    }
    public static synchronized void setRGB(BufferedImage image, int x, int y, Color pixelColor){
        image.setRGB(x, y, pixelColor.getRGB());
    }
    /*The getReflection function will serve to identify if any object in the scene has reflective
    * properties, and if it does, to change the color value of pixelColor to the one obtained with
    * the algorithm to deduce the color reflected in other objects.*/
    public static Color getReflection(Color pixelColor, Intersection closestIntersection, Light light, Camera mainCamera, Vector3D rayPosOrig, List<Object3D> objects, double cameraZ, double[] nearFarPlanes){


        /*each object that goes into this function will be identified as a closedintersection, which
        * was the intersection returned earlier in the method passed in. Each object has a constant that
        * gives it a reflection value, if this value is greater than 0, then it enters the function,
        * because it means that this "material" is reflective.*/
        double objReflection = closestIntersection.getObject().getcReflection();
        if (objReflection > 0){
            Color clrCollide = new Color(0,0,0);
            Vector3D objCamDir= Vector3D.substract(closestIntersection.getPosition(), mainCamera.getPosition());
            Vector3D finaldir= Vector3D.substract(objCamDir, Vector3D.scalarMultiplication(closestIntersection.getNormal(), 2*Vector3D.dotProduct(closestIntersection.getNormal(), objCamDir)));

            Ray getReflRay = new Ray(rayPosOrig, finaldir);

            Intersection ntersection = raycast(getReflRay, objects, null, new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
            if (ntersection != null){
                /*These two 3D vectors are extracted to later extract the value of a ray that will later
                * be sent again to the raycast function, and if what it returns is null, then it means
                * that there was no contact with any object, then there is no reflection, but if there
                * was contact with an object, then that pixel is sent to paint with the color it already
                * had before + the color of the object with which it is being reflected*/
                Color ambient = ambDiffSpec(ntersection, 1, light, mainCamera);
                Color diffuse = ambDiffSpec(ntersection, 2, light, mainCamera);
                Color specular = ambDiffSpec(ntersection, 3, light, mainCamera);
                clrCollide = addColor(clrCollide, ambient);
                clrCollide = addColor(clrCollide, diffuse);
                clrCollide = addColor(clrCollide, specular);

                //Color objColorCollide = colorReflected;

                //double[] objColorsCollide = new double[]{clrCollide.getRed() * (double)objReflection / 255.0f, clrCollide.getGreen() * (double)objReflection / 255.0f, clrCollide.getBlue() * (double)objReflection / 255.0f};

                Color reflection = new Color(clamp((clrCollide.getRed() * (double)objReflection / 255.0f), 0, 1),
                        clamp((clrCollide.getGreen() * (double)objReflection / 255.0f), 0, 1), clamp((clrCollide.getBlue() * (double)objReflection / 255.0f), 0, 1));
                pixelColor = addColor(pixelColor, reflection);
            }
        }
        //finally de new pixelColor is returned.
        return pixelColor;
    }

    public static Color ambDiffSpec(Intersection closestIntersection, int switchh, Light light, Camera mainCamera){
        /*What this function does is that it makes the objects have a blinking style, it takes
        out the three colors for that pixel: ambient, diffuse and specular. Depending on the option the user chooses.*/
        /*We get all these values ​​that are going to serve us and then get the values ​​of each color for
        each pixel. In general, for the 3 types of cases, the same values ​​and intensity, shininess, nDotL,
         the color of the object being checked and the color of the light must also be obtained.*/
        Color selectobj = closestIntersection.getObject().getColor();
        double nDotL = light.getNDotL(closestIntersection);;
        double fall = Math.pow(Vector3D.magnitude(Vector3D.substract(light.getPosition(), closestIntersection.getPosition())), 1);
        double intensity = (light.getIntensity() * nDotL)/fall;
        Color lightColor = light.getColor();;
        double[] lightColors = new double[]{lightColor.getRed() / 255.0, lightColor.getGreen() / 255.0, lightColor.getBlue() / 255.0};;
        double[] objClrs= new double[]{selectobj.getRed() / 255.0, selectobj.getGreen() / 255.0, selectobj.getBlue() / 255.0};;
        //For each case color value, it will be returned to wherever it was called for.
        switch(switchh){
            case 1:
                //Ambient
                double ambient = closestIntersection.getObject().getcAmbient();
                double[] objColorsAmbient = new double[]{selectobj.getRed() * (double)ambient / 255.0f,
                        selectobj.getGreen() * (double)ambient  / 255.0f,
                        selectobj.getBlue() * (double)ambient  / 255.0f};

                return new Color(clamp(objColorsAmbient[0], 0, 1), clamp(objColorsAmbient[1], 0, 1), clamp(objColorsAmbient[2], 0, 1));

            case 2:
                //Diffuse
                for (int i = 0; i < objClrs.length; i++) {
                    objClrs[i] *= intensity * lightColors[i];
                }

                return new Color(clamp(objClrs[0], 0, 1), clamp(objClrs[1], 0, 1), clamp(objClrs[2], 0, 1));

            case 3:
                //Specular
                Vector3D vec1 = Vector3D.normalize((Vector3D.substract(mainCamera.getPosition(), closestIntersection.getPosition())));
                Vector3D vec2 = Vector3D.normalize(Vector3D.add(light.getPosition(), vec1));
                double getspecular = Math.pow(Vector3D.dotProduct(closestIntersection.getNormal(), vec2), 4*shininess);
                for (int colorIndex = 0; colorIndex < objClrs.length; colorIndex++) {
                    objClrs[colorIndex] *= intensity * lightColors[colorIndex] * getspecular;
                }
                return new Color(clamp(objClrs[0], 0, 1), clamp(objClrs[1], 0, 1), clamp(objClrs[2], 0, 1));
        }
        return Color.BLACK;
    }
    /*This function is not really necessary, all it does is know if the user
    wants it to render with blinnPhong style or without that style. This option is put manually in the code.*/
    public static Color blinnPhong(Intersection closestIntersection, Color pixelColor, Light light, Camera mainCamera, int option){
        switch (option) {
            case 1:
                Color amb = ambDiffSpec(closestIntersection, 1, light, mainCamera);
                pixelColor = addColor(pixelColor, amb);
                Color diff = ambDiffSpec(closestIntersection, 2, light, mainCamera);
                pixelColor = addColor(pixelColor, diff);
                Color spec = ambDiffSpec(closestIntersection, 3, light, mainCamera);
                pixelColor = addColor(pixelColor, spec);
                break;
            case 2:
                Color objColor = closestIntersection.getObject().getColor();
                double nDotL = light.getNDotL(closestIntersection);
                double intensity = light.getIntensity() * nDotL;
                Color lightColor = light.getColor();

                double[] lightColors = new double[]{lightColor.getRed() / 255.0, lightColor.getGreen() / 255.0, lightColor.getBlue() / 255.0};
                double[] objColors = new double[]{objColor.getRed() / 255.0, objColor.getGreen() / 255.0, objColor.getBlue() / 255.0};
                for (int colorIndex = 0; colorIndex < objColors.length; colorIndex++) {
                    objColors[colorIndex] *= intensity * lightColors[colorIndex];
                }

                Color diffuse = new Color(clamp(objColors[0], 0, 1), clamp(objColors[1], 0, 1), clamp(objColors[2], 0, 1));
                pixelColor = addColor(pixelColor, diffuse);
            break;
        }
        return pixelColor;
    }

    public static Color refraction(Color pixelColor, Intersection closestIntersection, Light light, Camera mainCamera, Vector3D rayPosOrig, List<Object3D> objects, double cameraZ, double[] nearFarPlanes) {

        double doublfrac = closestIntersection.getObject().getFrac();
        if (doublfrac != 0) {

            Vector3D directionI = Vector3D.substract(closestIntersection.getPosition(), mainCamera.getPosition());
            Vector3D directionN = closestIntersection.getNormal();


            double dirvector=Vector3D.dotProduct(directionN, directionI);
            double finalnum=Math.sqrt(1 - Math.pow(doublfrac, 2) * (1 - Math.pow(dirvector, 2)));


            Color clrCollide = new Color(0, 0, 0);
            Vector3D directionT =Vector3D.add(Vector3D.scalarMultiplication(directionI, doublfrac), Vector3D.scalarMultiplication(directionN, doublfrac * dirvector - finalnum));
            Ray getReflRay = new Ray(rayPosOrig, directionT);

            Intersection ntersection = raycast(getReflRay, objects, closestIntersection.getObject(), new double[]{cameraZ + nearFarPlanes[0], cameraZ + nearFarPlanes[1]});
            if (ntersection != null) {

                Color ambient = ambDiffSpec(ntersection, 1, light, mainCamera);
                Color diffuse = ambDiffSpec(ntersection, 2, light, mainCamera);
                Color specular = ambDiffSpec(ntersection, 3, light, mainCamera);

                clrCollide = addColor(clrCollide, ambient);
                clrCollide = addColor(clrCollide, diffuse);
                clrCollide = addColor(clrCollide, specular);

                //Color objColorCollide = colorReflected;


                Color finalrefraction = new Color(clamp(clrCollide.getRed() / 255.0f, 0, 1),
                        clamp(clrCollide.getGreen() / 255.0f, 0, 1), clamp(clrCollide.getBlue() / 255.0f, 0, 1));
                pixelColor = addColor(pixelColor, finalrefraction);
            }

        }
        return pixelColor;
    }

}
