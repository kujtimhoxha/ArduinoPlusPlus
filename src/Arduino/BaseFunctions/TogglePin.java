package Arduino.BaseFunctions;


import Arduino.Sketch;
import javafx.util.Pair;

public class TogglePin {

    private String intervalVariable ="";
    private String timerVariable="";
    private String functionName ="";
    private int number=1;

    public TogglePin(int pin,long interval)
    {
        addIntervalConstant(interval);
        addTimer();
        addSetupCode(pin);
        addFunctions(pin);
        addLoopCode();

    }

    private void addLoopCode() {
        Sketch.loopCode.add(new Pair<>("ifStatement",
                new Builders().ifStatement("(" + new Base()._millis() + " - " + timerVariable + ")", ">=",
                        intervalVariable, "    " + functionName + " ();\n")));

    }

    private void addFunctions(int pin) {
        number=1;
        Sketch.functionCode.forEach(function ->
        {
            if (function.getKey().endsWith("toggleFunction")) {
                number = number + 1;
            }
        });
        if (number!=1)
        {
            functionName = "togglePin_" + number;
            Sketch.functionCode.add(new Pair<>("toggleFunction", new Builders().newFunction("void", functionName,
                    new Builders().ifStatement(new Base()._digitalRead(pin), " == ", "LOW",
                            new Base().digitalWrite(pin, true)) +
                            new Builders().elseStatement(new Base().digitalWrite(pin, false)))));

        }
        else {
            functionName = "togglePin_1";
            Sketch.functionCode.add(new Pair<>("toggleFunction", new Builders().newFunction("void", functionName,
                    new Builders().ifStatement(new Base()._digitalRead(pin), " == ", "LOW",
                            new Base().digitalWrite(pin, true)) +
                            new Builders().elseStatement(new Base().digitalWrite(pin, false))+new Builders().equalsStatement(timerVariable, new Base().millis()))));

        }

    }

    private void addSetupCode(int pin) {
        Sketch.setupCode.add(new Pair<>("pinMode", new Base().pinMode(pin, Base.OUTPUT)));
        Sketch.setupCode.add(new Pair<>("timerSetVale", new Builders().equalsStatement(timerVariable, new Base().millis())));
    }

    private void addTimer() {

        number=1;
        Sketch.headerCode.forEach(header ->
        {
            if (header.getKey().endsWith("timer")) {
                number = number + 1;
            }
        });
        if(number!=1)
        {
            timerVariable="timer_"+number;
            Sketch.headerCode.add(new Pair<>("timer", new Builders().newHeaderVariable("unsigned long", timerVariable)));

        }
        else
        {
            timerVariable="timer_1";
            Sketch.headerCode.add(new Pair<>("timer", new Builders().newHeaderVariable("unsigned long", timerVariable)));

        }

    }

    public void addIntervalConstant(long interval)
    {
        number=1;
        Sketch.headerCode.forEach(header ->
        {
            if (header.getKey().endsWith("interval")) {
                number = number + 1;
            }
        });
        if(number!=1)
        {
            intervalVariable="interval_"+number;
            Sketch.headerCode.add(new Pair<>("interval", new Builders().newHeaderVariableWithInit("const unsigned long",
                    intervalVariable, String.valueOf(interval))));

        }
        else
        {
            intervalVariable="interval_1";
            Sketch.headerCode.add(new Pair<>("interval", new Builders().newHeaderVariableWithInit("const unsigned long",
                    intervalVariable, String.valueOf(interval))));

        }

    }
}
