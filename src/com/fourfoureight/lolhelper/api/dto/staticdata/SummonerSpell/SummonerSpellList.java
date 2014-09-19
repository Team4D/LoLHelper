/**
 * 
 */
package lolapi.dto.staticdata.SummonerSpell;

import java.util.Map;

/**
 * @author Shyos
 * 
 */
public class SummonerSpellList {
	private Map<String, SummonerSpell> data;
	private String type;
	private String version;
	/**
	 * @return the data
	 */
	public Map<String, SummonerSpell> getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Map<String, SummonerSpell> data) {
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
