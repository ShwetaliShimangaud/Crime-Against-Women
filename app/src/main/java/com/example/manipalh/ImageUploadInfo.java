package com.example.manipalh;

public class ImageUploadInfo
{
    public String Id;
    public String imageURL;

    public ImageUploadInfo() {
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public ImageUploadInfo(String imageURL,String Id) {
        this.imageURL = imageURL;
        this.Id=Id;
    }
}
