package com.zellyalgo.suitapp.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zellyalgo on 28/1/16.
 */
public class Outfit implements Serializable {

    private String name;
    private Long id;
    private List<String> groups;
    private List<Picture> head;
    private List<Picture> chest;
    private List<Picture> legs;
    private List<Picture> feet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public List<Picture> getHead() {
        return head;
    }

    public void addHead(Picture head) {
        this.head.add(head);
    }

    public List<Picture> getChest() {
        return chest;
    }

    public void addChest(Picture chest) {
        this.chest.add(chest);
    }

    public List<Picture> getLegs() {
        return legs;
    }

    public void addtLegs(Picture legs) {
        this.legs.add(legs);
    }

    public List<Picture> getFeet() {
        return feet;
    }

    public void addFeet(Picture feet) {
        this.feet.add(feet);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Outfit outfit = (Outfit) o;

        if (name != null ? !name.equals(outfit.name) : outfit.name != null) return false;
        if (id != null ? !id.equals(outfit.id) : outfit.id != null) return false;
        if (groups != null ? !groups.equals(outfit.groups) : outfit.groups != null) return false;
        if (head != null ? !head.equals(outfit.head) : outfit.head != null) return false;
        if (chest != null ? !chest.equals(outfit.chest) : outfit.chest != null) return false;
        if (legs != null ? !legs.equals(outfit.legs) : outfit.legs != null) return false;
        return !(feet != null ? !feet.equals(outfit.feet) : outfit.feet != null);

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (groups != null ? groups.hashCode() : 0);
        result = 31 * result + (head != null ? head.hashCode() : 0);
        result = 31 * result + (chest != null ? chest.hashCode() : 0);
        result = 31 * result + (legs != null ? legs.hashCode() : 0);
        result = 31 * result + (feet != null ? feet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Outfit{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", groups=" + groups +
                ", head=" + head +
                ", chest=" + chest +
                ", legs=" + legs +
                ", feet=" + feet +
                '}';
    }
}
