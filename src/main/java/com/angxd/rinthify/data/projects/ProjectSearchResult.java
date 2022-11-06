package com.angxd.rinthify.data.projects;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ProjectSearchResult {
    public ArrayList<SearchHit> hits;
    public int offset;
    public int limit;
    @SerializedName("total_hits")
    public int totalHits;
}
