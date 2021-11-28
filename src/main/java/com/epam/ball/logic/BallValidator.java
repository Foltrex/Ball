package com.epam.ball.logic;

import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class BallValidator {
    private static final Logger logger = Logger.getLogger(BallValidator.class.getName());

    // check string for numeric values
    public boolean isValidLine(String line) {
        logger.debug("Argument line: " + line);

        final String separators = "\\s*(\\s|,)\\s*";
        final String number = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
        final String patternString = "\\s*" + number + separators + number + separators +
                number + separators + number + "\\s*";

        return Pattern.matches(patternString, line);
    }
}
