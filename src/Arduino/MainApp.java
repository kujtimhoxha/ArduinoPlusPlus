package Arduino;/**
 * Created by admin on 5/10/2015.
 */

import Arduino.BaseFunctions.TogglePin;
import javafx.application.Application;
import javafx.scene.control.Toggle;
import javafx.stage.Stage;

import java.io.*;

public class MainApp extends Application {

    public static void main(String[] args) throws IOException {
        String path=System.getProperty("user.dir")+"\\sketches\\test\\test.ino";
        new TogglePin(13,500);
        new TogglePin(14,200);
        Sketch sketch=new Sketch();
        sketch.generateCode();
        FileWriter fw = new FileWriter(path);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Sketch.code);
        bw.close();
        String command="C:\\Program Files (x86)\\Arduino\\arduino_debug --board arduino:avr:mega --upload "+path+" --port COM3";
        executeCommand(command);

       // launch(args);
    }

    private static String executeCommand(String command) {
        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            //  p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                //  output.append(line + "\n");
                System.out.println(line);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();
    }

    @Override
    public void start(Stage primaryStage) {

    }
}
