package com.epam.task1;

import java.util.regex.Pattern;

public class SphereValidator {

    // check string for numeric values
    public boolean isSphere(String line) {
        final String separators = "\\s*(\\s|,)\\s*";
        final String number = "[+-]?[0-9]+(\\.[0-9]+)?([Ee][+-]?[0-9]+)?";
        final String patternString = "\\s*" + number + separators + number + separators +
                number + separators + number + "\\s*";

        return Pattern.matches(patternString, line);
    }
}
