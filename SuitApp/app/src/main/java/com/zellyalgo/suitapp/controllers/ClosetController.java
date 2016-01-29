package com.zellyalgo.suitapp.controllers;

import com.zellyalgo.suitapp.model.Closet;
import com.zellyalgo.suitapp.model.Outfit;

import java.util.Iterator;

/**
 * Created by zellyalgo on 28/1/16.
 */
public class ClosetController {

    private ClosetController INSTANCE;
    private Closet closet;

    private ClosetController(){
        closet = new Closet();
    }

    public ClosetController getInstance (){
        if(INSTANCE == null){
            INSTANCE = new ClosetController();
        }
        return INSTANCE;
    }

    public Outfit getOutfit(Long id){
        Iterator<Outfit> closetIterator = closet.getOutfitList().iterator();
        boolean found = false;
        Outfit OutfitToReturn = null;
        while(closetIterator.hasNext() && !found){
            Outfit outfit = closetIterator.next();
            if(outfit.getId() == id){
                found = true;
                OutfitToReturn = outfit;
            }
        }
        return OutfitToReturn;
    }

    public Closet getCloset () {
        return closet;
    }
}
