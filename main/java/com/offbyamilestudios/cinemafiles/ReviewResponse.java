package com.offbyamilestudios.cinemafiles;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ReviewResponse {

		@SerializedName("id")
	    private Integer id;
	    @SerializedName( "pages" )
	    private Integer page;
	    @SerializedName( "results")
	    private List<Review> results;
	    @SerializedName( "total_pages" )
	    private Integer total_pages;
	    @SerializedName( "total_results" )
	    private Integer total_results;

	    public Integer getId() {
	        return id;
	    }

	    public void setId(Integer id) {
	        this.id = id;
	    }

	    public Integer getPage() {
	        return page;
	    }

	    public void setPage(Integer page) {
	        this.page = page;
	    }

	    public List<Review> getResults() {
	        return results;
	    }

	    public void setResults(List<Review> results) {
	        this.results = results;
	    }

	    public Integer getTotal_pages() {
	        return total_pages;
	    }

	    public void setTotal_pages(Integer total_pages) {
	        this.total_pages = total_pages;
	    }

	    public Integer getTotal_results() {
	        return total_results;
	    }

	    public void setTotal_results(Integer total_results) {
	        this.total_results = total_results;
	    }
	}

