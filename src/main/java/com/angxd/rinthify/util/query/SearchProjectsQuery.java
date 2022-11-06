package com.angxd.rinthify.util.query;

import com.angxd.rinthify.ModrinthApi;
import com.angxd.rinthify.util.enums.SortingOrder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SearchProjectsQuery {
    public final String query, facets;
    public final SortingOrder sortingOrder;
    public final int offset;
    public final int limit;

    private SearchProjectsQuery(String query, String facets, SortingOrder order, int offset, int limit) {
        this.query = query;
        this.facets = facets;
        this.sortingOrder = order;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("search?");
        if(query != null) builder.append("query=" + query + "&");
        if(facets != null) builder.append("facets=" + facets + "&");
        if(sortingOrder != null) builder.append("index=" + sortingOrder.toString().toLowerCase() + "&");
        builder.append("offset=" + offset + "&");
        builder.append("limit=" + limit + "&");
        return builder.toString().replace(" ", "+").replace("\"", "%22");
    }

    public static SearchProjectsQuery.Builder create() {
        return new SearchProjectsQuery.Builder();
    }

    public static final class Builder {
        private String query;
        private String facets;
        private SortingOrder order = SortingOrder.RELEVANCE;
        private int offset = 0;
        private int limit = 10;
        private Builder() {
        }

        public Builder query(String query) {
            this.query = query;
            return this;
        }

        public Builder facets(String facets) {
            this.facets = facets;
            return this;
        }

        public Builder sortingOrder(SortingOrder order) {
            this.order = order;
            return this;
        }

        public Builder offset(int offset) {
            this.offset = offset;
            return this;
        }

        public Builder limit(int limit) {
            this.limit = limit;
            return this;
        }

        public SearchProjectsQuery get() {
            SearchProjectsQuery query = new SearchProjectsQuery(this.query, this.facets, this.order, this.offset, this.limit);
            return query;
        }
    }
}
