package com.acharya.bookkeepingapplication.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class SearchRequest {
    private SearchByType searchByType;
    private String searchString;

    public SearchRequest() {}

    public SearchRequest(SearchByType searchByType, String searchString) {
        this.searchByType = searchByType;
        this.searchString = searchString;
    }

    public SearchByType getSearchByType() {
        return searchByType;
    }

    public void setSearchByType(SearchByType searchByType) {
        this.searchByType = searchByType;
    }

    public String getSearchString() {
        return searchString;
    }

    public void setSearchString(String searchString) {
        this.searchString = searchString;
    }
}
