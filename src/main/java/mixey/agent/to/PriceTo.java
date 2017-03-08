package mixey.agent.to;

import mixey.agent.model.Price;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PriceTo implements Serializable{
    protected Integer id;

    protected Integer number;

    protected String priceCategory;

    private String date;

    public PriceTo() {
    }

    public PriceTo(Integer id, Integer number, String priceCategory, String date) {
        this.id = id;
        this.number = number;
        this.priceCategory = priceCategory;
        this.date = date;
    }

    public static PriceTo asTo(Price price) {
        return new PriceTo(price.getId(), price.getNumber(), price.getPriceCategory().getName(), price.getDate().toString());
    }

    public static List<PriceTo> listAsTo (List<Price> list) {
        List<PriceTo> newList = new ArrayList<>();
        for (Price l : list) {
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

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPriceCategory() {
        return priceCategory;
    }

    public void setPriceCategory(String priceCategory) {
        this.priceCategory = priceCategory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PriceTo{" +
                "id=" + id +
                ", number=" + number +
                ", priceCategory='" + priceCategory + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}

