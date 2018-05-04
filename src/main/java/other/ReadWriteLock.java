package other;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class ReadWriteLock {

    public static void main(String[] args) {
        ReadWrite readWrite = new ReadWrite();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {

            Thread thread = new Thread(() -> {
                try {
                    Integer sleep = new Random().nextInt(1000);
                    System.out.println("sleeping thread: " + Thread.currentThread().getName() + " for : " + sleep);
                    Thread.sleep(sleep);
                    String readKey = random.nextInt(10) + "";
                    System.out.println(Thread.currentThread().getName() + "-> " + readKey + " : " + readWrite.read(readKey));


                    sleep = new Random().nextInt(1000);
                    System.out.println("sleeping thread: " + Thread.currentThread().getName() + " for : " + sleep);
                    Thread.sleep(sleep);
                    String newKey = random.nextInt(10) + "";
                    readWrite.write(newKey, random.nextInt(1000) + "");


                    sleep = new Random().nextInt(1000);
                    System.out.println("sleeping thread: " + Thread.currentThread().getName() + " for : " + sleep);
                    Thread.sleep(sleep);
                    System.out.println(Thread.currentThread().getName() + "-> " + newKey + " : " + readWrite.read(newKey));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            thread.setName("Thread: " + i);
            thread.start();
        }
    }

    private static class ReadWrite {

        Integer threadWriting = 0;
        Map<String, String> row = new HashMap<>();

        String read(String key) {
            System.out.println("Reading thread: " + Thread.currentThread().getName());
            while (threadWriting > 0) {
                System.out.println("Read : ThreadCount = " + threadWriting);
            }
            return this.row.get(key);
        }

        void write(String key, String value) {
            System.out.println("Writing thread: " + Thread.currentThread().getName());
            while (threadWriting >= 1) {
                System.out.println("Write : ThreadCount = " + threadWriting);
            }
            threadWriting++;
            this.row.put(key, value);
            threadWriting--;
        }
    }
}
