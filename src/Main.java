import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ProcessBuilder pb = new ProcessBuilder("open", "-a", "Firefox");
        Process myProcess = null;
        ArrayList <Process> browsers = new ArrayList<>();

        try  {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el número de procesos");
            int numBrowsers = sc.nextInt();

            for (int i = 0; i < numBrowsers; i++) {
                myProcess = pb.start();
                browsers.add(myProcess);
                System.out.println("Process " + i + " started : " + LocalTime.now());
                browsers.add(myProcess);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}