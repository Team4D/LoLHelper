/**
 * 
 */
package com.fourfoureight.lolhelper.api.dto.staticdata.Champion;

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
