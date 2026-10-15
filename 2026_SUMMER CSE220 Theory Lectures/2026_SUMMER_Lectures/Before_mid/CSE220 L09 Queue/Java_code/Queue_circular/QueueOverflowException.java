// Custom exception classes
class QueueOverflowException extends Exception {
    public QueueOverflowException(String message) {
        super(message);
    }
}