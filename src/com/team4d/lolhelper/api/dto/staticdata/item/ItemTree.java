/**
 * 
 */
package com.team4d.lolhelper.api.dto.staticdata.item;

import java.util.List;

/**
 * @author Shyos
 *
 */
public class ItemTree {
	private String header;	
	private List<String> tags;
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
}
