package mixey.agent.util;

import mixey.agent.model.Price;
import mixey.agent.model.PriceProduct;
import mixey.agent.to.PriceProductTo;
import mixey.agent.to.PriceTo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TOUtil {
    public static Price asModel(PriceTo priceTo) {
        return new Price(priceTo.getId(), priceTo.getNumber(), LocalDate.parse(priceTo.getDate()));
    }

    public static PriceTo asTo(Price price) {
        return new PriceTo(price.getId(), price.getNumber(), price.getPriceCategory().getId(), price.getPriceCategory().getName(), price.getDate().toString());
    }

    public static PriceTo asToFull(Price price) {
        PriceTo priceTo = asTo(price);
        List<PriceProductTo> list = new ArrayList<>();
        for (PriceProduct pp : price.getPriceProducts()) {
            PriceProductTo priceProductTo = new PriceProductTo(pp.getProduct().getId(), pp.getValue());
            list.add(priceProductTo);
        }
        priceTo.setPriceProductTos(list);
        return priceTo;
    }


    public static List<PriceTo> listAsTo(List<Price> list) {
        List<PriceTo> newList = new ArrayList<>();
        for (Price p : list) {
            newList.add(asTo(p));
        }
        return newList;
    }
}
