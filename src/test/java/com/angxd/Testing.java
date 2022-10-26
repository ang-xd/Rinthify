package com.angxd;

public class Testing {
    public static void main(String[] args) {
        ModrinthApi modrinthApi = ModrinthApi.builder()
                .apiKey("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")
                .build();

        System.out.println(modrinthApi.USERS.getAuthenticatedUser().getUsername());

        modrinthApi.PROJECTS.unfollowProject("fabric-api");
    }
}
