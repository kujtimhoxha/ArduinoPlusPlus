package Arduino.BaseFunctions;

/**
 * The Base class.
 * This class contains the base functions of the arduino code.
 */
public class Base {

    public static final String OUTPUT="OUTPUT";
    public static final String INPUT="INPUT";

    public String digitalWrite(int pin,boolean value)
    {
        return "    digitalWrite("+pin+","+value+");\n";
    }
    public String analogWrite(int pin,int value)
    {
        return "analogWrite("+pin+","+value+");\n";
    }
    public String _digitalRead(int pin)
    {

        return "digitalRead("+pin+")";
    }
    public String digitalRead(int pin)
    {
        return "    digitalRead("+pin+");\n";
    }
    public String pinMode(int pin,String mode)
    {
        return "    pinMode("+pin+","+mode+");\n";
    }
    public String _analogRead(int pin)
    {
        return "analogRead("+pin+")";
    }
    public String analogRead(int pin)
    {
        return "    analogRead("+pin+");\n";
    }
    public String serialBegin(int baud)
    {
        return "    Serial.begin("+baud+");\n";
    }
    public String _serialAvailable()
    {
        return "Serial.available()";
    }
    public String serialAvailable()
    {
        return "    Serial.available();\n";
    }
    public String serialRead()
    {
        return "    Serial.read();\n";
    }
    public String _serialRead()
    {
        return "Serial.read()";
    }
    public String _millis()
    {
        return "millis()";
    }
    public String millis()
    {
        return "millis();\n";
    }

    public String test()
    {
        return "test";
    }
}
