package retail;

import java.util.ArrayList;

public class GenericAction <T extends SuperSection> {
    public boolean add(ArrayList<T> list, T t){
        for (T c : list) {
            if(c.getId().equals(t.getId()))
                return false;
        }
        list.add(t);
        return true;
    }
    public boolean delete(ArrayList<T> list, String s){
        for (T c : list) {
            if(c.getId().equals(s)) {
                list.remove(c);
                return true;
            }
        }
        return false;
    }
    public boolean edit(ArrayList<T> list, T t){
        for (T c : list){
            if(c.getId().equals(t.getId())){
                delete(list, c.getId());
                add(list, t);
                return true;
            }
        }
        return false;
    }

    public T search(ArrayList<T> list, String customerId){
        for (T c : list) {
            if(c.getId().equals(customerId)) {
                return c;
            }
        }
        return null;
    }
    public boolean view(ArrayList<Customer> list, Customer customer){
        if (list.size() < 1)
            return false;
        System.out.println("ID" + "\t" + "NAME" + "\t" + "ADDRESS" + "\t" + "CONTACT NUMBER");
        for (Customer c : list) {
            System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getAddress() + "\t" + c.getContactNumber());
        }
        return true;
    }
    public boolean view(ArrayList<Product> list, Product product){
        if (list.size() < 1)
            return false;
        System.out.println("ID" + "\t" + "NAME" + "\t" + "RATE" + "\t Fragile");
        for (Product c : list) {
            System.out.println(c.getId() + "\t" + c.getName() + "\t" + c.getRate() + "\t" + c.isFragile());
        }
        return true;
    }
    public boolean view(ArrayList<Order> list, ArrayList<Product> products){
        if (list.size() < 1)
            return false;
        System.out.println("ID" + "\t" + "CUSTOMER ID" + "\t" + "NUMBER OF ITEMS"+ "\t" + "COST" + "\t" + "PRODUCTS" );
        for (Order c : list) {
            System.out.print(c.getId() + "\t" + c.getCustomerId() + "\t" + c.getItemNumber() + "\t" + c.getCost());
            for (OrderItem oi : c.getOrderItems()){
                for (Product p : products){
                    if (p.getId().equals(oi.getProductId()))
                        System.out.print(" " +p.getName() );
                }
            }
            System.out.println("");
        }
        return true;
    }
    protected double cost(ArrayList<Product> products){
        if (products.size() < 1)
            return 0;
        double count = 0;
        for (Product p : products){
            count += p.getRate();
            if (p.isFragile())
                count += 10;
            else
                count += 5;
        }
        return count;
    }
}
