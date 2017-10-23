package mixey.agent.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "admins")
public class Admin extends BaseUser{
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "admin_roles", joinColumns = @JoinColumn(name = "admin_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public Admin() {
    }

    public Admin(String name, String password) {
        super(name, password);
    }

    public Admin(Integer id, String name, String password) {
        super(id, name, password);
    }

    @Override
    public Set<Role> getRoles() {
        return roles;
    }

    @Override
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
