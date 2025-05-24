import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Animal cat = new Animal("cat");
        Animal dog = new Animal("dog");
        Animal wolf = new Animal("wolf");

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
            oos.writeInt(3);
            oos.writeObject(cat);
            oos.writeObject(dog);
            oos.writeObject(wolf);
        }

        byte[] data = baos.toByteArray();

        Animal[] result = Deserializer.deserializeAnimalArray(data);

        System.out.println(Arrays.toString(result));
    }
}