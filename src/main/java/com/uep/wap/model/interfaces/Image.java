package com.uep.wap.model.interfaces;

public interface Image {

    // choose image from default images
    public void chooseImage();
    // user can upload own Image
    // should method take a string - path to the image?
    public void uploadImage();

    public void deleteImage(String image);

    public void commentImage();

    public void postImage();
}
