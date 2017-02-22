package mixey.agent.model;

import javax.persistence.*;

@Entity
@Table(name = "price_categories")
public class PriceCategory {
    @Id
    @SequenceGenerator(name = "global_seq", sequenceName = "global_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "global_seq")
    protected Integer id;

    @Column(name = "name")
    protected String name;

    @Column(name = "description")
    protected String description;

   /* @OneToMany(mappedBy = "priceCategory")
    protected Set<Client> clients = new HashSet<>();*/

    public PriceCategory() {
    }

    public PriceCategory(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public PriceCategory(String name, String description) {
        this(null, name, description);
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

   /* public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }*/

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "PriceCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
