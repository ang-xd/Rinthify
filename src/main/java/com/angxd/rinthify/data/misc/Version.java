package com.angxd.rinthify.data.misc;

import com.angxd.rinthify.data.files.File;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;

public class Version{
    public String id;
    public String project_id;
    public String author_id;
    public boolean featured;
    public String name;
    public String version_number;
    public String changelog;
    public Object changelog_url;
    public Date date_published;
    public int downloads;
    public String version_type;
    public ArrayList<File> files;
    public ArrayList<Dependency> dependencies;
    public ArrayList<String> game_versions;
    public ArrayList<String> loaders;
}
