package mixey.agent.to;

import mixey.agent.model.Price;

import java.util.ArrayList;
import java.util.List;

public class PriceView{
    private Integer id;

    private Integer number;

    private Integer priceCategory;

    private String priceCategoryName;

    private String date;

    public PriceView() {
    }

    public PriceView(Integer id, Integer number, Integer priceCategory, String priceCategoryName, String date) {
        this.id = id;
        this.number = number;
        this.priceCategory = priceCategory;
        this.priceCategoryName = priceCategoryName;
        this.date = date;
    }

    public static PriceView asView(Price price) {
        return new PriceView(price.getId(), price.getNumber(), price.getPriceCategory().getId(), price.getPriceCategory().getName(), price.getDate().toString());
    }

    public static List<PriceView> listAsView (List<Price> list) {
        List<PriceView> newList = new ArrayList<>();
        for (Price l : list) {
            newList.add(asView(l));
        }
        return newList;
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

    public Integer getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(Integer priceCategory) {
        this.priceCategory = priceCategory;
    }

    public String getPriceCategoryName() {
        return priceCategoryName;
    }

    public void setPriceCategoryName(String priceCategoryName) {
        this.priceCategoryName = priceCategoryName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PriceView{" +
                "id=" + id +
                ", number=" + number +
                ", priceCategory=" + priceCategory +
                ", priceCategoryName='" + priceCategoryName + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

