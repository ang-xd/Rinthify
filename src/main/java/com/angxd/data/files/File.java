package com.angxd.data.files;

public class File{
    public Hashes getHashes() {
        return hashes;
    }

    public String getUrl() {
        return url;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isPrimary() {
        return primary;
    }

    public int getSize() {
        return size;
    }

    public Hashes hashes;
    public String url;
    public String filename;
    public boolean primary;
    public int size;
}