package com.travelset.laba3.model.entity;

import javax.persistence.*;
import java.util.Collection;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category {
    private int id;
    private String name;
    private Collection<Itemtype> itemtypes;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @NotNull
    @NotEmpty
    @Column(name = "Name", unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category that = (Category) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "category")
    public Collection<Itemtype> getItemtypes() {
        return itemtypes;
    }

    public void setItemtypes(Collection<Itemtype> itemtypes) {
        this.itemtypes = itemtypes;
    }
}
