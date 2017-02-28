package mixey.agent.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "prices")
public class Price {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    @Column(name = "number")
    protected Integer number;


    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "pc_id")
    protected PriceCategory priceCategory;

    @Column(name = "date_time", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    protected LocalDateTime dateTime;

    @OneToMany(mappedBy = "price")
    protected Set<PriceProduct> priceProducts = new HashSet<>();

    public Price() {
    }

    public Price(Integer number, PriceCategory priceCategory, LocalDateTime dateTime) {
        this(null, number, priceCategory, dateTime);
    }

    public Price(Integer id, Integer number, PriceCategory priceCategory, LocalDateTime dateTime) {
        this.id = id;
        this.number = number;
        this.priceCategory = priceCategory;
        this.dateTime = dateTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Set<PriceProduct> getPriceProducts() {
        return priceProducts;
    }

    public void setPriceProducts(Set<PriceProduct> priceProducts) {
        this.priceProducts = priceProducts;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Price{" +
                "id=" + id +
                ", number=" + number +
                ", priceCategory=" + priceCategory +
                ", dateTime=" + dateTime +
                ", priceProducts=" + priceProducts +
                '}';
    }
}
