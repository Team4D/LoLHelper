package com.fourfoureight.lolhelper.api.dto.staticdata.Mastery;

import java.util.Map;

public class MasteryList {
	private Map<String, Mastery> data;
	private MasteryTree tree;
	private String type;
	private String version;
	/**
	 * @return the data
	 */
	public Map<String, Mastery> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Mastery> data) {
		this.data = data;
	}
	/**
	 * @return the tree
	 */
	public MasteryTree getTree() {
		return tree;
	}
	/**
	 * @param tree the tree to set
	 */
	public void setTree(MasteryTree tree) {
		this.tree = tree;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
}
