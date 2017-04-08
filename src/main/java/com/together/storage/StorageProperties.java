package com.together.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by BRF on 2017-04-08.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}