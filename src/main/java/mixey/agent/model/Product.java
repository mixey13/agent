package mixey.agent.model;

/**
 * Created by s_adm on 03.02.2017.
 */
public class Product {
    protected Integer id;
    protected String title;
    protected String description;

    public Product(String title, String description) {
        this(null, title, description);
    }

    public Product(Integer id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
