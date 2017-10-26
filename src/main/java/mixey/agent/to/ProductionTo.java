package mixey.agent.to;

import mixey.agent.model.Production;
import mixey.agent.model.ProductionProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductionTo {
    private Integer id;

    private String organizationName;

    private String date;

    private String time;

    private List<ProductionProductTo> productionProductTos;

    public ProductionTo() {
    }

    public ProductionTo(Integer id, String organizationName, String date, String time) {
        this(id, organizationName, date, time, null);
    }

    public ProductionTo(Integer id, String organizationName, String date, String time, List<ProductionProductTo> productionProductTos) {
        this.id = id;
        this.organizationName = organizationName;
        this.date = date;
        this.time = time;
        this.productionProductTos = productionProductTos;
    }

    public static ProductionTo asTo(Production production) {
        return new ProductionTo(production.getId(), production.getOrganization().getName(), production.getDate().toString(), production.getTime().toString());
    }

    public static ProductionTo asToFull(Production production) {
        ProductionTo productionTo = asTo(production);
        List<ProductionProductTo> list = new ArrayList<>();
        for(ProductionProduct pp : production.getProductionProducts()) {
            ProductionProductTo productionProductTo = new ProductionProductTo(pp.getProduct().getId(), pp.getAmount());
            list.add(productionProductTo);
        }
        productionTo.setProductionProductTos(list);
        return productionTo;
    }

    public static List<ProductionTo> listAsTo(List<Production> list) {
        List<ProductionTo> newList = new ArrayList<>();
        for(Production p : list) {
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<ProductionProductTo> getProductionProductTos() {
        return productionProductTos;
    }

    public void setProductionProductTos(List<ProductionProductTo> productionProductTos) {
        this.productionProductTos = productionProductTos;
    }
}
