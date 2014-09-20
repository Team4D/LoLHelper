/**
 * 
 */
package com.fourfoureight.lolhelper.api.dto.staticdata.Rune;

import java.util.Map;

import com.fourfoureight.lolhelper.api.dto.staticdata.BasicData;

/**
 * @author Shyos
 * 
 */
public class RuneList {
	private BasicData basic;
	private Map<String, Rune> data;
	private String type;
	private String version;
	/**
	 * @return the basic
	 */
	public BasicData getBasic() {
		return basic;
	}
	/**
	 * @param basic the basic to set
	 */
	public void setBasic(BasicData basic) {
		this.basic = basic;
	}
	/**
	 * @return the data
	 */
	public Map<String, Rune> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, Rune> data) {
		this.data = data;
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
