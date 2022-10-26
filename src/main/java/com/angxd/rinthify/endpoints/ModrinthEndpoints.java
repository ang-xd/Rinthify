package com.angxd.rinthify.endpoints;

import com.angxd.rinthify.ModrinthApi;

public class ModrinthEndpoints {
    public final ProjectsEndpoint PROJECTS;
    public final UsersEndpoint USERS;
    public final VersionsEndpoint VERSIONS;

    public ModrinthEndpoints(ModrinthApi api) {
        this.PROJECTS = new ProjectsEndpoint(api);
        this.USERS = new UsersEndpoint(api);
        this.VERSIONS = new VersionsEndpoint(api);
    }
}
