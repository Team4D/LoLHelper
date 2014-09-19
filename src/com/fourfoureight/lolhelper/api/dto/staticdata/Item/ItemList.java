/**
 * 
 */
package lolapi.dto.staticdata.Item;

import java.util.List;
import java.util.Map;

import lolapi.dto.staticdata.BasicData;

/**
 * @author Shyos
 * 
 */
public class ItemList {
	private BasicData basic;
	private Map<String, Item> data;
	private List<Group> groups;
	private List<ItemTree> tree;
	private String type;
	private String version;

	public BasicData getBasic() {
		return basic;
	}

	public void setBasic(BasicData basic) {
		this.basic = basic;
	}

	public Map<String, Item> getData() {
		return data;
	}

	public void setData(Map<String, Item> data) {
		this.data = data;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}

	public List<ItemTree> getTree() {
		return tree;
	}

	public void setTree(List<ItemTree> tree) {
		this.tree = tree;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
}
