package com.angxd.rinthify.endpoints;

import com.angxd.rinthify.ModrinthApi;
import com.angxd.rinthify.data.projects.Project;
import com.angxd.rinthify.data.users.User;
import com.angxd.rinthify.util.Endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsersEndpoint extends Endpoint {

    public UsersEndpoint(ModrinthApi modrinthApi) {
        super(modrinthApi);
    }

    public User getUser(String username) {
        User user = deserialize(get("user/" + username, false), User.class);
        return user;
    }

    public List<User> getMultipleUsers(String... usernames) {
        List<User> users = new ArrayList<>();
        for(String username : usernames) {
            users.add(getUser(username));
        }
        return users;
    }

    public List<Project> getUsersProjects(String username) {
        Project[] projects = deserialize(get("user/" + username + "/projects", false),Project[].class);
        return Arrays.stream(projects).toList();
    }

    public List<Project> getUsersFollowedProjects(String username) {
        Project[] projects = deserialize(get("user/" + username + "/follows", true), Project[].class);
        return Arrays.stream(projects).toList();
    }

    public User getAuthenticatedUser() {
        User user = deserialize(get("user", true), User.class);
        return user;
    }
}
