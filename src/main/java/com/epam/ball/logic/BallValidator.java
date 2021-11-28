package com.epam.ball.logic;

import java.util.regex.Pattern;

public class BallValidator {

    // check string for numeric values
    public boolean isValidLine(String line) {
        final String separators = "\\s*(\\s|,)\\s*";
        final String number = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
        final String patternString = "\\s*" + number + separators + number + separators +
                number + separators + number + "\\s*";

        return Pattern.matches(patternString, line);
    }
}
