package mixey.agent.to;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Map;

public class PriceTo {
    private Integer id;

    private Integer number;

    private Integer priceCategory;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;

    private Map<Integer, Integer> productValue;

    public PriceTo() {
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
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
                ", date=" + date +
                ", productValue=" + productValue +
                '}';
    }
}
