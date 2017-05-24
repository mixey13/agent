package mixey.agent.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
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

    @Column(name = "date", nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    protected LocalDate date;

    @OneToMany(mappedBy = "price", cascade = CascadeType.ALL, orphanRemoval = true)
    protected Set<PriceProduct> priceProducts = new HashSet<>();

    public Price() {
    }

    public Price(Integer number, LocalDate date) {
        this(null, number, date);
    }

    public Price(Integer id, Integer number, LocalDate date) {
        this.id = id;
        this.number = number;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

//    @Override
//    public String toString() {
//        return "Price{" +
//                "id=" + id +
//                ", number=" + number +
//                ", priceCategory=" + priceCategory +
//                ", date=" + date +
//                ", priceProducts=" + priceProducts +
//                '}';
//    }
}
