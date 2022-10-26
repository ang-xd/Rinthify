package com.angxd.rinthify.endpoints;

import com.angxd.rinthify.ModrinthApi;
import com.angxd.rinthify.data.misc.Version;
import com.angxd.rinthify.util.Endpoint;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VersionsEndpoint extends Endpoint {
    public VersionsEndpoint(ModrinthApi modrinthApi) {
        super(modrinthApi);
    }

    public Version getVersion(String id) {
        Version version = deserialize(get("version/" + id, false), Version.class);
        return version;
    }

    public List<Version> getMultipleVersions(String... ids) {
        List<Version> versions = new ArrayList<>();
        for(String id : ids) {
            versions.add(getVersion(id));
        }
        return versions;
    }
}
