package mixey.agent.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class Client extends Organization {

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "pc_id")
    protected PriceCategory priceCategory;

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }
}
