import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AlgoStrategyClassLoader extends ClassLoader {

    private String name;

    public AlgoStrategyClassLoader(String name) {
        this.name = name;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Path filePath =  Paths.get("/home/einstalek/strategies/" + this.name + ".class");
        try {
            byte v[] = Files.readAllBytes((java.nio.file.Path) filePath);
//            System.out.println(v.length);
            return defineClass(name, v, 0, v.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        AlgoStrategyClassLoader cl = new AlgoStrategyClassLoader("Person");
        Class<?> clazz = cl.findClass(cl.name);
        System.out.println(clazz);
    }
}
