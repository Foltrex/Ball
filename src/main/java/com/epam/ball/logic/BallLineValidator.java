package com.epam.ball.logic;

import org.apache.log4j.Logger;

import java.util.regex.Pattern;

public class BallLineValidator {
    private static final Logger LOGGER = Logger.getLogger(BallLineValidator.class);

    private final String separators = "\\s*(\\s|,)\\s*";
    private final String number = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";

    // check string for numeric values
    public boolean isValidLine(String line) {
        LOGGER.debug("Argument line: " + line);

        String patternString = "\\s*" + number + separators + number + separators +
                number + separators + number + "\\s*";

        return Pattern.matches(patternString, line);
    }
}
