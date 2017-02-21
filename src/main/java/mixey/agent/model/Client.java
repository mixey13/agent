package mixey.agent.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends Organization {

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "price_id")
    protected Price price;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}
