package mixey.agent.to;

public class OrderProductTo {
    private Integer product;

    private Double cost;

    private Double amount;

    public OrderProductTo() {
    }

    public OrderProductTo(Integer product, Double cost, Double amount) {
        this.product = product;
        this.cost = cost;
        this.amount = amount;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
