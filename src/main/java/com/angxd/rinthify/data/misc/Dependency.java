package com.angxd.rinthify.data.misc;

import com.google.gson.annotations.SerializedName;

public class Dependency{
    @SerializedName("version_id")
    public String versionId;

    public String getVersionId() {
        return versionId;
    }

    public Object getProjectId() {
        return projectId;
    }

    public Object getFileName() {
        return fileName;
    }

    public String getDependencyType() {
        return dependencyType;
    }

    @SerializedName("project_id")
    public Object projectId;
    @SerializedName("file_name")
    public Object fileName;
    @SerializedName("dependency_type")
    public String dependencyType;
}