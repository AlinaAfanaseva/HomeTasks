public class CustomerStorageException extends ArrayIndexOutOfBoundsException{

    private String[] components;


    public CustomerStorageException(String message, String[] components) {
        super(message);
        int len = components.length;
    }

}
