package com.travelset.model.entity;

import javax.persistence.*;
import java.util.Set;
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;

@Entity
@Table(name = "permissions")
public class Permission {
    private int id;
    private String name;
    private String description;

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "role_permission",
            joinColumns={ @JoinColumn(name = "permissionId")},
            inverseJoinColumns = { @JoinColumn(name = "roleId") }
    )
    public Set<Role> roles;


//    @ManyToMany(cascade=CascadeType.ALL)
//    @JoinTable(
//            name = "permissionsRoles",schema = "travelset7", catalog = "",
//            joinColumns={ @JoinColumn(name = "permissionId", referencedColumnName = "id")},
////            joinColumns = { @JoinColumn(name = "permissionId") },
////            inverseJoinColumns = { @JoinColumn(name = "roleId") }
//            inverseJoinColumns = { @JoinColumn(name = "roleId", referencedColumnName = "id") }
//    )
//    private Set<Role> roles;
    // private Collection<Role> roles;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Permission that = (Permission) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }


}
