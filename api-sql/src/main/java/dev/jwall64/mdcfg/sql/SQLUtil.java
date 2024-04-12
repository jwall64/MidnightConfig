package dev.jwall64.mdcfg.sql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dev.jwall64.mdcfg.ConfigPrimitive;

import java.util.regex.Pattern;

public class SQLUtil {

    public static final Logger LOGGER = LoggerFactory.getLogger("MidnightConfig SQL");

    public static final Pattern VALID_NAME = Pattern.compile("^[a-zA-Z_][a-zA-Z0-9_]*$");

    public static void validate(String name) {
        if(!VALID_NAME.matcher(name).matches()) {
            throw new IllegalArgumentException("Invalid name " + name + "!");
        }
    }

}
