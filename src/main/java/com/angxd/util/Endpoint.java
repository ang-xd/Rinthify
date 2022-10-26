package com.angxd.util;

import com.angxd.ModrinthApi;

public abstract class Endpoint {
    public ModrinthApi modrinthApi;

    public Endpoint(ModrinthApi modrinthApi) {
        this.modrinthApi = modrinthApi;
    }
}
