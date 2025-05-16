import java.io.*;

public class Deserializer {
    public static Animal[] deserializeAnimalArray(byte[] data) throws ClassNotFoundException {
        try (ByteArrayInputStream byteArray = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(byteArray)
        ) {
            int arraySize = ois.readInt();

            if (arraySize <= 0 || arraySize > Integer.MAX_VALUE) {
                throw new IllegalArgumentException("Недопустимый размер массив");
            }

            Animal[] result = new Animal[arraySize];

            for (int i = 0; i < arraySize; i++) {
                Object animal = ois.readObject();

                if (!(animal instanceof Animal)) {
                    throw new IllegalArgumentException("Не экземпляр Animal");
                }

                result[i] = (Animal) animal;
            }

            return result;
        } catch (IOException | RuntimeException e) {
            throw new IllegalArgumentException("Недопустимые данные для десериализации");
        }

    }
}
