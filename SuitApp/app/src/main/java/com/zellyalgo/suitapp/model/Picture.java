package com.zellyalgo.suitapp.model;

import java.io.Serializable;

/**
 * Created by zellyalgo on 2/1/16.
 */
public class Picture implements Serializable {
    private Long id;
    private String imageUri;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }
}
