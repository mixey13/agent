package mixey.agent.model;

import javax.persistence.*;

@Entity
@Table(name = "price_product")
public class PriceProduct {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    private Integer id;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    private Price price;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "value")
    private Integer value;

    public PriceProduct() {
    }

    public PriceProduct(Product product, Integer value) {
        this.product = product;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "PriceProduct{" +
                "id=" + id +
                ", price=" + price +
                ", product=" + product +
                ", value=" + value +
                '}';
    }
}
