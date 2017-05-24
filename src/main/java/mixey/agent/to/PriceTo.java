package mixey.agent.to;

import mixey.agent.model.Price;
import mixey.agent.model.PriceProduct;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.*;

public class PriceTo {
    private Integer id;

    private Integer number;

    private Integer priceCategory;

    private String priceCategoryName;

    private String date;

    private Map<Integer, Integer> productValue;

    public PriceTo() {
    }

    public PriceTo(Integer id, Integer number, Integer priceCategory, String priceCategoryName, String date) {
        this(id, number, priceCategory, priceCategoryName, date, null);
    }

    public PriceTo(Integer id, Integer number, Integer priceCategory, String priceCategoryName, String date, Map<Integer, Integer> productValue) {
        this.id = id;
        this.number = number;
        this.priceCategory = priceCategory;
        this.priceCategoryName = priceCategoryName;
        this.date = date;
        this.productValue = productValue;
    }

    public static PriceTo asTo(Price price) {
        return new PriceTo(price.getId(), price.getNumber(), price.getPriceCategory().getId(), price.getPriceCategory().getName(), price.getDate().toString());
    }

    public static List<PriceTo> listAsTo(List<Price> list) {
        List<PriceTo> newList = new ArrayList<>();
        for (Price p : list) {
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

    public Map<Integer, Integer> getProductValue() {
        return productValue;
    }

    public void setProductValue(Map<Integer, Integer> productValue) {
        this.productValue = productValue;
    }

    @Override
    public String toString() {
        return "PriceTo{" +
                "id=" + id +
                ", number=" + number +
                ", priceCategory=" + priceCategory +
                ", priceCategoryName='" + priceCategoryName + '\'' +
                ", date='" + date + '\'' +
                ", productValue=" + productValue +
                '}';
    }
}
