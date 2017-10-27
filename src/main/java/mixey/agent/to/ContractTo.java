package mixey.agent.to;

import mixey.agent.model.Contract;

import java.util.ArrayList;
import java.util.List;

public class ContractTo {
    private Integer id;

    private String organizationName;

    private Integer client;

    private String clientName;

    private Integer priceCategory;

    private String priceCategoryName;

    public ContractTo() {
    }

    public ContractTo(Integer id, String organizationName, Integer client, String clientName, Integer priceCategory, String priceCategoryName) {
        this.id = id;
        this.organizationName = organizationName;
        this.client = client;
        this.clientName = clientName;
        this.priceCategory = priceCategory;
        this.priceCategoryName = priceCategoryName;
    }

    public static ContractTo asTo(Contract contract) {
        return new ContractTo(contract.getId(), contract.getOrganization().getName(), contract.getClient().getId(), contract.getClient().getName(), contract.getPriceCategory().getId(), contract.getPriceCategory().getName());
    }

    public static List<ContractTo> listAsTo(List<Contract> list) {
        List<ContractTo> newList = new ArrayList<>();
        for(Contract c : list) {
            newList.add(asTo(c));
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

    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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
