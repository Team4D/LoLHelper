/**
 * 
 */
package com.team4d.lolhelper.api.dto.staticdata.champion;

import java.util.List;

/**
 * @author Shyos
 * 
 */
public class Block {
	private List<BlockItem> items;
	private String type;
	public List<BlockItem> getItems() {
		return items;
	}
	public void setItems(List<BlockItem> items) {
		this.items = items;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
