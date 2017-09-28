package mixey.agent.to;

public class PriceProductTo {
    private Integer product;

    private Integer value;

    public PriceProductTo() {
    }

    public PriceProductTo(Integer product, Integer value) {
        this.product = product;
        this.value = value;
    }

    public Integer getProduct() {
        return product;
    }

    public void setProduct(Integer product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PriceProductTo{" +
                "product=" + product +
                ", value=" + value +
                '}';
    }
}
