package mixey.agent.to;

import mixey.agent.model.Balance;

import java.util.ArrayList;
import java.util.List;

public class BalanceTo {
    private String product;

    private Double amount;

    public BalanceTo() {
    }

    public BalanceTo(String product, Double amount) {
        this.product = product;
        this.amount = amount;
    }

    public static BalanceTo asTo(Balance balance) {
        return new BalanceTo(balance.getProduct().getTitle(), balance.getAmount());
    }

    public static List<BalanceTo> listAsTo(List<Balance> list) {
        List<BalanceTo> newList = new ArrayList<>();
        for (Balance b : list) {
            newList.add(asTo(b));
        }
        return newList;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
