package dev.jwall64.mdcfg.serializer;

/**
 * An exception called when (de)serialization fails
 */
public class SerializeException extends RuntimeException {

    public SerializeException(String message) {
        super(message);
    }

    public SerializeException(Throwable cause) {
        super(cause);
    }

    public SerializeException(String message, Throwable cause) {
        super(message, cause);
    }
}
