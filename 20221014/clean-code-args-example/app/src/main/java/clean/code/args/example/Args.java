package clean.code.args.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Args {
    private final String schema;
    private final String[] args;
    private final Map<Character, Boolean> booleanArgs;
    private boolean valid = true;
    private List<Character> unexpectedArguments;

    public Args(String schema, String[] args) {
        booleanArgs = new HashMap<>();
        unexpectedArguments = new ArrayList<>();

        this.schema = schema;
        this.args = args;

        parse();
    }

    private void parse() {
        parseSchema();
        parseArguments();
    }

    private void parseSchema() {
        for (String element : schema.split(",")) {
            parseSchemaElement(element);
        }
    }

    private void parseSchemaElement(String element) {
        if (element.length() == 1) {
            parseBooleanSchemaElement(element);
        }
    }

    private void parseBooleanSchemaElement(String element) {
        char character = element.charAt(0);
        if (Character.isLetter(character)) {
            booleanArgs.put(character, false);
        }
    }

    private void parseArguments() {
        for (String arg : args) {
            parseArgument(arg);
        }
    }

    private void parseArgument(String arg) {
        if (arg.startsWith("-")) {
            parseElements(arg.substring(1));
        }
    }

    private void parseElements(String arg) {
        for (char argCharacter : arg.toCharArray()) {
            setBooleanArg(argCharacter);
        }
    }

    private void setBooleanArg(char argCharacter) {
        if (!isBoolean(argCharacter)) {
            valid = false;
            unexpectedArguments.add(argCharacter);
            return;
        }

        booleanArgs.put(argCharacter, true);
    }

    private boolean isBoolean(char argCharacter) {
        return booleanArgs.containsKey(argCharacter);
    }

    public boolean getBoolean(char arg) {
        return booleanArgs.get(arg);
    }

    public int cardinality() {
        return booleanArgs.size();
    }

    public boolean isValid() {
        return valid;
    }

    public String errorMessage() {
        if (unexpectedArguments.isEmpty()) {
            return "";
        }

        StringBuilder arguments = new StringBuilder();
        for (char unexpectedArgument : unexpectedArguments) {
            arguments.append(unexpectedArgument);
        }
        return "Argument(s) -" + arguments + " unexpected.";
    }
}
