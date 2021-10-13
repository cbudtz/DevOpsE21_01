package launch;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Tomcat tomcat = new Tomcat();
        tomcat.setBaseDir("temp");
        String port = Optional.ofNullable(System.getenv("PORT")).orElse("8080"); //Til Heroku
        tomcat.setPort(Integer.parseInt(port));
        tomcat.getConnector(); //Creates a default HTTP connector
        System.out.println("Listening on Port: " + port);


        tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
