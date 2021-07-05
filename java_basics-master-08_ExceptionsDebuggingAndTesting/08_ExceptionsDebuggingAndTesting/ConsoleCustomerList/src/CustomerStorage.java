import java.util.HashMap;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) throws ArrayIndexOutOfBoundsException, IllegalArgumentException
    {
        String[] components = data.split("\\s+");
        String name = components[0] + " " + components[1];
        storage.put(name, new Customer(name, components[3], components[2]));
        if (components.length != 4){
            throw new ArrayIndexOutOfBoundsException("Wrong format! Please try again!");
        }
        if (!components[2].equals("^((+7)\\d{3})\\d{3}\\d{2}\\d{2})$"))
            throw new IllegalArgumentException("Wrong mobile number format");
        else if (!components[3].equals("^[__A-Za-z0-9-\\\\+]+(\\\\.[__A-Za-z0-9-]+)**\n" +
                "      @[A-Za-z0-9-]+(\\\\.[A-Za-z0-9]+)** (\\\\.[A-Za-z]{2,})$"))
            throw new IllegalArgumentException("Wrong email address format!");
    }

    public void listCustomers() throws NullPointerException
    {
        storage.values().forEach(System.out::println);
        if (storage.values().isEmpty())
            throw new NullPointerException("List is empty");
    }

    public void removeCustomer(String name) throws IndexOutOfBoundsException
    {
        storage.remove(name);
        if (storage == null)
            throw new IndexOutOfBoundsException("Storage is empty");
    }

    public int getCount()
    {
        return storage.size();
    }
}