package com.angxd.rinthify.data.projects;

import com.angxd.rinthify.data.misc.Version;

import java.util.ArrayList;

public class ProjectDependencies{
    public ArrayList<Project> getProjects() {
        return projects;
    }

    public ArrayList<Version> getVersions() {
        return versions;
    }

    public ArrayList<Project> projects;
    public ArrayList<Version> versions;
}