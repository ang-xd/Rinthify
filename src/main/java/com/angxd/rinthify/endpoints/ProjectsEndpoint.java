package com.angxd.rinthify.endpoints;


import com.angxd.rinthify.ModrinthApi;
import com.angxd.rinthify.data.misc.Version;
import com.angxd.rinthify.data.projects.Project;
import com.angxd.rinthify.data.projects.ProjectDependencies;
import com.angxd.rinthify.data.projects.ProjectSearchResult;
import com.angxd.rinthify.util.Endpoint;
import com.angxd.rinthify.util.query.SearchProjectsQuery;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProjectsEndpoint extends Endpoint {

    public ProjectsEndpoint(ModrinthApi modrinthApi) {
        super(modrinthApi);
    }

    public List<Project> getMultipleProjects(String... slugs) {
        List<Project> projects = new ArrayList<>();
        for(String slug : slugs) {
            projects.add(getProject(slug));
        }
        return projects;
    }

    public void followProject(String slug) {
        post("project/" + slug + "/follow", HttpRequest.BodyPublishers.noBody());
    }

    public List<Version> getVersions(String slug) {
        Version[] versions = deserialize(get("project/" + slug + "/version", false), Version[].class);
        return Arrays.stream(versions).toList();
    }

    public void unfollowProject(String slug) {
        del("project/" + slug + "/follow");
    }

    public ProjectDependencies getProjectDependencies(String slug) {
        ProjectDependencies dependencies = deserialize(get("project/" + slug + "/dependencies", false), ProjectDependencies.class);
        return dependencies;
    }

    public ProjectSearchResult searchForProjects(SearchProjectsQuery searchProjectsQuery) {
        ProjectSearchResult projects = deserialize(get(searchProjectsQuery.toString(), false), ProjectSearchResult.class);
        return projects;
    }
    public Project getProject(String slug) {
        Project project = deserialize(get("project/" + slug, false), Project.class);
        return project;
    }
}
