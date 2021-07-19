package uk.sky.Exception;

public class FileFormatException extends RuntimeException {
    public FileFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
