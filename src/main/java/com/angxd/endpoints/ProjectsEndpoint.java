package com.angxd.endpoints;


import com.angxd.ModrinthApi;
import com.angxd.data.projects.Project;
import com.angxd.data.projects.ProjectDependencies;
import com.angxd.util.Endpoint;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.ArrayList;
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
        try {
            modrinthApi.SENDER.post("project/" + slug + "/follow", HttpRequest.BodyPublishers.noBody());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void unfollowProject(String slug) {
        try {
            modrinthApi.SENDER.del("project/" + slug + "/follow");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public ProjectDependencies getProjectDependencies(String slug) {
        try {
            ProjectDependencies dependencies = ModrinthApi.GSON.fromJson(modrinthApi.SENDER.get("project/" + slug + "/dependencies", false), ProjectDependencies.class);
            return dependencies;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public Project getProject(String slug) {
        try {
            Project project = ModrinthApi.GSON.fromJson(modrinthApi.SENDER.get("project/" + slug, false), Project.class);
            return project;
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
