package com.izv.galeria;

import android.graphics.Bitmap;

import java.io.File;

/**
 * Created by rober on 24/01/2015.
 */
public class ImageItem {


    private File image;
    private String title;

    public ImageItem(File image, String title) {
        super();
        this.image = image;
        this.title = title;
    }

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
