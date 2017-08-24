package mixey.agent.model;

import javax.persistence.*;

@Entity
@Table(name = "clients")
public class  Client {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    @Column(name = "name")
    protected String name;

    @Column(name = "full_name")
    protected String fullName;

    @Column(name = "inn")
    protected Long inn;

    @Column(name = "address")
    protected String address;

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "pc_id")
    protected PriceCategory priceCategory;

    public Client() {
    }

    public Client(Integer id, String name, String fullName, Long inn, String address) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.address = address;
    }

    public Client(String name, String fullName, Long inn, String address) {
        this(null, name, fullName, inn, address);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PriceCategory getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(PriceCategory priceCategory) {
        this.priceCategory = priceCategory;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn=" + inn +
                ", address='" + address + '\'' +
                ", priceCategory=" + priceCategory +
                '}';
    }
}
