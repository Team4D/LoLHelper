/**
 * 
 */
package com.team4d.lolhelper.api.dto.staticdata;


public class Metadata {
	private boolean isRune;
	private String tier;
	private String type;
	/**
	 * @return the isRune
	 */
	public boolean isRune() {
		return isRune;
	}
	/**
	 * @param isRune the isRune to set
	 */
	public void setRune(boolean isRune) {
		this.isRune = isRune;
	}
	/**
	 * @return the tier
	 */
	public String getTier() {
		return tier;
	}
	/**
	 * @param tier the tier to set
	 */
	public void setTier(String tier) {
		this.tier = tier;
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
}
