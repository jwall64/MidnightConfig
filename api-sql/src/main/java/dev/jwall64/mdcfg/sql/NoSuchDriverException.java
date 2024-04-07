package dev.jwall64.mdcfg.sql;

public class NoSuchDriverException extends RuntimeException {
    public NoSuchDriverException(String message) {
        super(message);
    }

    public NoSuchDriverException(String message, Throwable cause) {
        super(message, cause);
    }
}
