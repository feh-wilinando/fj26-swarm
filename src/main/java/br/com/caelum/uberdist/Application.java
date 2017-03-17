package br.com.caelum.uberdist;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.undertow.WARArchive;

import java.io.File;

/**
 * Created by nando on 13/02/17.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm(args);

        swarm.start();


        WARArchive deployment = ShrinkWrap.create(WARArchive.class);

        deployment.addPackages(true, Package.getPackage("br.com.caelum.uberdist"));
        ClassLoader classLoader = Application.class.getClassLoader();

        deployment.addAsWebInfResource(classLoader.getResource("META-INF/persistence.xml"), "classes/META-INF/persistence.xml");
        deployment.addAsWebInfResource(classLoader.getResource("META-INF/beans.xml"), "classes/META-INF/beans.xml");

        addFolderToWebResource("src/main/webapp/", new File("src/main/webapp/"), deployment, false);


        deployment.addAllDependencies();

        swarm.deploy(deployment);

    }


    private static void addFolderToWebResource(String basePath, File path, WARArchive deployment, boolean isWebInf) throws Exception {

        if (!path.isDirectory()) {
            throw new Exception("Not a directory");
        }

        for (File file : path.listFiles()) {

            if (file.isDirectory()) {
                addFolderToWebResource(basePath, file, deployment, file.getPath().contains("src/main/webapp/WEB-INF"));
            } else {
                if (isWebInf) {
                    deployment.addAsWebInfResource(file, file.getPath().replaceAll(basePath + "WEB-INF/", ""));
                } else {
                    deployment.addAsWebResource(file, file.getPath().replaceAll(basePath, ""));
                }
            }

        }

    }

}
