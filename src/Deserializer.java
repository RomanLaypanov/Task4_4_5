import java.io.*;

public class Deserializer {
    public static Animal[] deserializeAnimalArray(byte[] data) throws ClassNotFoundException, IOException {
        try (ByteArrayInputStream byteArray = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(byteArray)) {
            int arraySize = ois.readInt();

            Animal[] result = new Animal[arraySize];

            for (int i = 0; i < arraySize; i++) {
                Object animal = ois.readObject();

                result[i] = (Animal) animal;
            }

            return result;
        } catch (NegativeArraySizeException | EOFException | ClassCastException e) {
            throw new IllegalArgumentException("Недопустимые данные для десериализации");
        }

    }
}
