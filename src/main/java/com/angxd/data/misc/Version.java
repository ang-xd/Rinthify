package com.angxd.data.misc;

import com.google.gson.annotations.SerializedName;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

public class Version{
    public String id;
    @SerializedName("project_id")
    public String projectId;
    @SerializedName("author_id")
    public String authorId;
    public boolean featured;
    public String name;
    @SerializedName("version_number")
    public String versionNumber;
    public String changelog;
    @SerializedName("changelog_url")
    public Object changelogUrl;
    @SerializedName("date_published")
    public Date datePublished;

    public String getId() {
        return id;
    }

    public String getProjectId() {
        return projectId;
    }

    public String getAuthorId() {
        return authorId;
    }

    public boolean isFeatured() {
        return featured;
    }

    public String getName() {
        return name;
    }

    public String getVersionNumber() {
        return versionNumber;
    }

    public String getChangelog() {
        return changelog;
    }

    public Object getChangelogUrl() {
        return changelogUrl;
    }

    public Date getDatePublished() {
        return datePublished;
    }

    public int getDownloads() {
        return downloads;
    }

    public String getVersionType() {
        return versionType;
    }

    public ArrayList<File> getFiles() {
        return files;
    }

    public ArrayList<Object> getDependencies() {
        return dependencies;
    }

    public ArrayList<String> getGameVersions() {
        return gameVersions;
    }

    public ArrayList<String> getLoaders() {
        return loaders;
    }

    public int downloads;
    @SerializedName("version_type")
    public String versionType;
    public ArrayList<File> files;
    public ArrayList<Object> dependencies;
    @SerializedName("game_versions")
    public ArrayList<String> gameVersions;
    public ArrayList<String> loaders;
}
