package com.angxd;

import com.angxd.rinthify.ModrinthApi;
import com.angxd.rinthify.data.misc.Category;
import com.angxd.rinthify.data.projects.Project;
import com.angxd.rinthify.util.enums.SortingOrder;
import com.angxd.rinthify.util.query.SearchProjectsQuery;

import java.util.List;
import java.util.function.Consumer;

public class Testing {
    public static void main(String[] args) {
        Consumer<Exception> listener = e -> {
            System.out.println(e.toString());
        };

        ModrinthApi modrinthApi = ModrinthApi.builder()
                .apiKey("hahuthought")
                .exceptionListener(listener)
                .build();

        System.out.println(modrinthApi.getEndpoints().PROJECTS.getVersions("deeperdarker").get(0).name);

        for(Category category : modrinthApi.getEndpoints().TAGS.getCategories().stream().filter(category -> category.project_type.equals("mod")).toList()) {
            System.out.println(category.name);
        }
    }
}
