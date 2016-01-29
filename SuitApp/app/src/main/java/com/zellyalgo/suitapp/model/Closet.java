package com.zellyalgo.suitapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zellyalgo on 28/1/16.
 */
public class Closet implements Serializable{
    private List<Outfit> outfitList;

    public Closet(){
        outfitList = new ArrayList<>();
    }

    public List<Outfit> getOutfitList() {
        return outfitList;
    }

    public Outfit getOutfit (int position){
        return outfitList.get(position);
    }

    public int addOutfit(Outfit outfit){
        outfitList.add(outfit);
        return outfitList.size()-1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Closet closet = (Closet) o;

        return !(outfitList != null ? !outfitList.equals(closet.outfitList) : closet.outfitList != null);

    }

    @Override
    public int hashCode() {
        return outfitList != null ? outfitList.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Closet{" +
                "outfitList=" + outfitList +
                '}';
    }
}
