package mixey.agent.to;

import mixey.agent.model.Order;
import mixey.agent.model.OrderProduct;

import java.util.ArrayList;
import java.util.List;

public class OrderTo {
    private Integer id;

    private Integer organization;

    private String organizationName;

    private Integer client;

    private String clientName;

    private Double total;

    private String date;

    private String time;

    private List<OrderProductTo> orderProductTos;

    public OrderTo() {
    }

    public OrderTo(Integer id, Integer organization, String organizationName, Integer client, String clientName, Double total, String date, String time) {
        this(id, organization, organizationName, client, clientName, total, date, time, null);
    }

    public OrderTo(Integer id, Integer organization, String organizationName, Integer client, String clientName, Double total, String date, String time, List<OrderProductTo> orderProductTos) {
        this.id = id;
        this.organization = organization;
        this.organizationName = organizationName;
        this.client = client;
        this.clientName = clientName;
        this.total = total;
        this.date = date;
        this.time = time;
        this.orderProductTos = orderProductTos;
    }

    public static OrderTo asTo(Order order) {
        return new OrderTo(order.getId(), order.getOrganization().getId(), order.getOrganization().getName(), order.getClient().getId(), order.getClient().getName(), order.getTotal(), order.getDate().toString(), order.getTime().toString());
    }

    public static OrderTo asToFull(Order order) {
        OrderTo orderTo = asTo(order);
        List<OrderProductTo> list = new ArrayList<>();
        for(OrderProduct op : order.getOrderProducts()) {
            OrderProductTo orderProductTo = new OrderProductTo(op.getProduct().getId(), op.getCost(), op.getAmount());
            list.add(orderProductTo);
        }
        orderTo.setOrderProductTos(list);
        return orderTo;
    }

    public static List<OrderTo> listAsTo(List<Order> list) {
        List<OrderTo> newList = new ArrayList<>();
        for(Order o : list) {
            newList.add(asTo(o));
        }
        return newList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrganization() {
        return organization;
    }

    public void setOrganization(Integer organization) {
        this.organization = organization;
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

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
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

    public List<OrderProductTo> getOrderProductTos() {
        return orderProductTos;
    }

    public void setOrderProductTos(List<OrderProductTo> orderProductTos) {
        this.orderProductTos = orderProductTos;
    }
}
