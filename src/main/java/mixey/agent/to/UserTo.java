package mixey.agent.to;

import mixey.agent.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserTo {
    private Integer id;

    private String name;

    private String password;

    private Integer organization;

    private String organizationName;

    public UserTo() {
    }

    public UserTo(Integer id, String name, String password, Integer organization, String organizationName) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.organization = organization;
        this.organizationName = organizationName;
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getPassword(), user.getOrganization().getId(), user.getOrganization().getName());
    }

    public static List<UserTo> listAsTo(List<User> list) {
        List<UserTo> newList = new ArrayList<>();
        for(User u : list) {
            newList.add(asTo(u));
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
