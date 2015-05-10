package Arduino.BaseFunctions;

/**
 * The Builders class.
 * This class serves to build some essential programing statements and functions.
 */
public class Builders {
    public static final String END_FUNCTION="}\n";

    public String ifStatement(String value1,String operator,String value2,String todo) {
        return "    if("+value1+" "+operator+" "+value2+"){\n"+todo+"   "+END_FUNCTION;
    }
    public String elseIfStatement(String value1,String operator,String value2,String todo) {
        return "    else if("+value1+" "+operator+" "+value2+"){\n"+todo+"   "+END_FUNCTION;
    }
    public String elseStatement(String todo) {
        return "    else{\n"+todo+"   "+END_FUNCTION;
    }
    public String newLibrary(String name) {
        return "#include "+name;
    }
    public String newHeaderVariable(String type,String name) {
        return type+" "+name+";\n";
    }
    public String newHeaderVariableWithInit(String type,String name,String value) {
        return type+" "+name+" = "+value+";\n";
    }
    public String newFunction(String type, String name, String todo) {
        return type+" "+name+" (){\n"+todo+END_FUNCTION;
    }
    public String equalsStatement(String value1, String value2) {
        return "    "+value1+" = "+value2;
    }
    public String forStatement(String start,String end,String todo) {
        return "for( int i="+start+",;i<"+end+";i++){\n"+todo+"   "+END_FUNCTION;
    }

    //            BaseNoGui.main(new String[]{"--upload",path,"--verbose"});

}
