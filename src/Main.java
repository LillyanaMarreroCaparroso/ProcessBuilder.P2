import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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

            browsers.get(0).waitFor(500, TimeUnit.MILLISECONDS);

            for (int i = 0; i < browsers.size(); i++) {
                Process process = browsers.get(i);
                process.destroyForcibly();
                System.out.println("Finished process " + i + " : " + LocalTime.now());
            }

        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }
    }
}