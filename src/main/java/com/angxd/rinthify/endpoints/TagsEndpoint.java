package com.angxd.rinthify.endpoints;

import com.angxd.rinthify.ModrinthApi;
import com.angxd.rinthify.data.misc.Category;
import com.angxd.rinthify.data.misc.Version;
import com.angxd.rinthify.util.Endpoint;

import java.util.Arrays;
import java.util.List;

public class TagsEndpoint extends Endpoint {
    public TagsEndpoint(ModrinthApi modrinthApi) {
        super(modrinthApi);
    }

    public List<Category> getCategories() {
        Category[] categories = deserialize(get("tag/category", false), Category[].class);
        return Arrays.stream(categories).toList();
    }
}
