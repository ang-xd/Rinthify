package com.angxd;

import com.angxd.rinthify.ModrinthApi;
import com.angxd.rinthify.data.projects.Project;

import java.util.List;

public class Testing {
    public static void main(String[] args) {
        ModrinthApi modrinthApi = ModrinthApi.builder()
                .apiKey("hahuthought")
                .build();

        List<Project> myProjects = modrinthApi.getEndpoints().USERS.getUsersProjects("ang-xd");
    }
}
