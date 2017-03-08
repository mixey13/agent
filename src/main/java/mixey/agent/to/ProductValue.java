package mixey.agent.to;

public class ProductValue {
    Integer productId;
    Integer value;

    public ProductValue() {
    }

    public ProductValue(Integer productId, Integer value) {
        this.productId = productId;
        this.value = value;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ProductValue{" +
                "productId=" + productId +
                ", value=" + value +
                '}';
    }
}
