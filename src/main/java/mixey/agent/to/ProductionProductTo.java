package mixey.agent.to;

public class ProductionProductTo {
    private Integer product;

    private Double amount;

    public ProductionProductTo() {
    }

    public ProductionProductTo(Integer product, Double amount) {
        this.product = product;
        this.amount = amount;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
