import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MyClassLoader extends ClassLoader{

    Class load(Path path){

        byte[]b = new byte[0];
        try {
            b = Files.readAllBytes(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  defineClass(null,b,0,b.length);
    }

}
