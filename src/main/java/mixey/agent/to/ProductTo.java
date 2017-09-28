package mixey.agent.to;

import mixey.agent.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductTo {
    private Integer id;

    private Integer organization;

    private String organizationName;

    private String title;

    private String description;

    public ProductTo() {
    }

    public ProductTo(Integer id, Integer organization, String organizationName, String title, String description) {
        this.id = id;
        this.organization = organization;
        this.organizationName = organizationName;
        this.title = title;
        this.description = description;
    }

    public static ProductTo asTo(Product product) {
        return new ProductTo(product.getId(), product.getOrganization().getId(), product.getOrganization().getName(), product.getTitle(), product.getDescription());
    }

    public static List<ProductTo> listAsTo(List<Product> list) {
        List<ProductTo> newList = new ArrayList<>();
        for(Product p : list) {
            newList.add(asTo(p));
        }
        return newList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
