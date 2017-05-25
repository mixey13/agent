package mixey.agent.to;

import mixey.agent.model.Client;

import java.util.ArrayList;
import java.util.List;

public class ClientTo {
    private Integer id;

    private String name;

    private String fullName;

    private Long inn;

    private String address;

    private Integer priceCategory;

    private String priceCategoryName;

    public ClientTo() {
    }

    public ClientTo(Integer id, String name, String fullName, Long inn, String address, Integer priceCategory, String priceCategoryName) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.address = address;
        this.priceCategory = priceCategory;
        this.priceCategoryName = priceCategoryName;
    }

    public static ClientTo asTo(Client client) {
        return new ClientTo(client.getId(), client.getName(), client.getFullName(), client.getInn(), client.getAddress(), client.getPriceCategory().getId(), client.getPriceCategory().getName());
    }

    public static List<ClientTo> listAsTo(List<Client> list) {
        List<ClientTo> newList = new ArrayList<>();
        for (Client p : list) {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getInn() {
        return inn;
    }

    public void setInn(Long inn) {
        this.inn = inn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}
