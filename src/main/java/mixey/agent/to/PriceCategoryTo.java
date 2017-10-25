package mixey.agent.to;

import mixey.agent.model.PriceCategory;

import java.util.ArrayList;
import java.util.List;

public class PriceCategoryTo {
    private Integer id;

    private String organizationName;

    private String name;

    private String description;

    public PriceCategoryTo() {
    }

    public PriceCategoryTo(Integer id, String organizationName, String name, String description) {
        this.id = id;
        this.organizationName = organizationName;
        this.name = name;
        this.description = description;
    }

    public static PriceCategoryTo asTo(PriceCategory priceCategory) {
        return new PriceCategoryTo(priceCategory.getId(), priceCategory.getOrganization().getName(), priceCategory.getName(), priceCategory.getDescription());
    }

    public static List<PriceCategoryTo> listAsTo(List<PriceCategory> list) {
        List<PriceCategoryTo> newList = new ArrayList<>();
        for(PriceCategory pc : list) {
            newList.add(asTo(pc));
        }
        return newList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
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
}
