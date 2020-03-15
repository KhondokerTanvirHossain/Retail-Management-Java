package retail;

import java.util.ArrayList;

public class Order extends SuperSection {
//    private String id;
    private String customerId;
    private int itemNumber;
    private ArrayList<OrderItem> orderItems;
    private double cost;

    public Order() {
    }

    public Order(String id, String customerId, int itemNumber) {
        super(id);
        this.id = id;
        this.customerId = customerId;
        this.itemNumber = itemNumber;
        orderItems = new ArrayList<OrderItem>();
        cost = 0;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public ArrayList<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void addItems(ArrayList<Product> products){
        for (int i = 0; i < itemNumber; i++){
            orderItems.add(new OrderItem(id, products.get(i).getId()));
        }
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
