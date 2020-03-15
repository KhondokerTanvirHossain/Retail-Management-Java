package retail;
import java.util.ArrayList;
public class Customer extends SuperSection implements Login{
    private String name;
    private String password;
    private String address;
    private String contactNumber;

    public Customer() {
    }

    public Customer(String id, String name, String password, String address, String contactNumber) {
        super(id);
        this.id = id;
        this.name = name;
        this.password = password;
        this.address = address;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }


    @Override
    public boolean isLoginSuccessful(String nameStr, String passwordStr) {
        if(!name.equals(nameStr))
            return false;
        if (!password.equals(passwordStr))
            return false;
        return true;
    }
    public boolean addOrder(ArrayList<Order> list, Order order, ArrayList<Product> productList){
        GenericAction<Order> ga = new GenericAction<>();
        boolean b = ga.add(list, order);
        order.addItems(productList);
        double total = ga.cost(productList);
        order.setCost(total);
        return b;
    }

}
