package mixey.agent.to;

import mixey.agent.model.PriceCategory;

import java.util.ArrayList;
import java.util.List;

public class PriceCategoryTo {
    private Integer id;
    private String name;
    private String description;

    public PriceCategoryTo() {
    }

    public PriceCategoryTo(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public static PriceCategoryTo asTo(PriceCategory priceCategory) {
        return new PriceCategoryTo(priceCategory.getId(), priceCategory.getName(), priceCategory.getDescription());
    }

    public static List<PriceCategoryTo> listAsTo (List<PriceCategory> list) {
        List<PriceCategoryTo> newList = new ArrayList<>();
        for (PriceCategory l : list) {
            newList.add(asTo(l));
        }
        return newList;
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

    @Override
    public String toString() {
        return "PriceCategoryTo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
