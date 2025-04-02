package com.monster.Monster.Hunter.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImgBBResponseDTO {
	 private DataDTO data;
	    
	    public DataDTO getData() { return data; }
	    public void setData(DataDTO data) { this.data = data; }

	    public static class DataDTO {
	        private String url;

	        @JsonProperty("display_url")
	        private String displayUrl;

	        public String getUrl() { return url; }
	        public void setUrl(String url) { this.url = url; }

	        public String getDisplayUrl() { return displayUrl; }
	        public void setDisplayUrl(String displayUrl) { this.displayUrl = displayUrl; }
	    }
}
