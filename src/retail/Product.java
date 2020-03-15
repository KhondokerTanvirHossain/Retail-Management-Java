package retail;

public class Product extends SuperSection {
//    private String id;
    private String name;
    private Double rate;
    private boolean fragile;

    public Product() {
    }

    public Product(String id, String name, Double rate, boolean fragile) {
        super(id);
        this.name = name;
        this.rate = rate;
        this.fragile = fragile;
    }

    public Product(String name, Double rate, boolean fragile) {
        this.name = name;
        this.rate = rate;
        this.fragile = fragile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }


}
