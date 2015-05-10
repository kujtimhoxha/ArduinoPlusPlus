package Arduino;

import javafx.util.Pair;
import java.util.ArrayList;

public class Sketch {
    public static String code="";
    public static ArrayList<Pair<String,String>> headerCode=new ArrayList<>();
    public static ArrayList<Pair<String,String>> setupCode=new ArrayList<>();
    public static ArrayList<Pair<String,String>> loopCode=new ArrayList<>();
    public static ArrayList<Pair<String,String>> functionCode=new ArrayList<>();

    public static final String SETUP_START ="void setup(){\n";
    public static final String LOOP_START ="void loop(){\n";
    public static final String END_FUNCTION="}\n";

    public void addHeader()
    {
        headerCode.forEach(row->code=code+row.getValue());
    }
    public void addSetup()
    {
        code=code+SETUP_START;
        setupCode.forEach(row->code=code+row.getValue());
        code=code+END_FUNCTION;
    }
    public void addLoop()
    {
        code=code+LOOP_START;
        loopCode.forEach(row->code=code+row.getValue());
        code=code+END_FUNCTION;
    }
    public void addFunctions()
    {
        functionCode.forEach(row->code=code+row.getValue());
    }

    public void generateCode()
    {
        addHeader();
        addSetup();
        addLoop();
        addFunctions();
    }
}
