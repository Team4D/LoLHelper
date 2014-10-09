/**
 * 
 */
package com.team4d.lolhelper.api.dto.staticdata.realm;

import java.util.Map;

/**
 * @author Shyos
 * 
 */
public class Realm {
	private String cdn; // 
	private String css; // 
	private String dd; // Latest changed version of Dragon Magic.
	private String l; // Default language for this realm.
	private String lg; // Legacy script mode for IE6 or older.
	private Map<String, String> n;// Latest changed version for each data type
									// listed.
	private String profileiconmax; // Special behavior number identifying the
									// largest profileicon id that can be used
									// under 500. Any profileicon that is
									// requested between this number and 500
									// should be mapped to 0.
	private String store; // Additional api data drawn from other sources that
							// may be related to data dragon functionality.
	private String v; // Current version of this file for this realm.
	/**
	 * @return the cdn
	 * @description The base CDN url.
	 */
	public String getCdn() {
		return cdn;
	}
	/**
	 * @param cdn the cdn to set
	 * 
	 */
	public void setCdn(String cdn) {
		this.cdn = cdn;
	}
	/**
	 * @return the css
	 * @description Latest changed version of Dragon Magic's css file.
	 */
	public String getCss() {
		return css;
	}
	/**
	 * @param css the css to set
	 */
	public void setCss(String css) {
		this.css = css;
	}
	/**
	 * @return the dd
	 */
	public String getDd() {
		return dd;
	}
	/**
	 * @param dd the dd to set
	 */
	public void setDd(String dd) {
		this.dd = dd;
	}
	/**
	 * @return the l
	 */
	public String getL() {
		return l;
	}
	/**
	 * @param l the l to set
	 */
	public void setL(String l) {
		this.l = l;
	}
	/**
	 * @return the lg
	 */
	public String getLg() {
		return lg;
	}
	/**
	 * @param lg the lg to set
	 */
	public void setLg(String lg) {
		this.lg = lg;
	}
	/**
	 * @return the n
	 */
	public Map<String, String> getN() {
		return n;
	}
	/**
	 * @param n the n to set
	 */
	public void setN(Map<String, String> n) {
		this.n = n;
	}
	/**
	 * @return the profileiconmax
	 */
	public String getProfileiconmax() {
		return profileiconmax;
	}
	/**
	 * @param profileiconmax the profileiconmax to set
	 */
	public void setProfileiconmax(String profileiconmax) {
		this.profileiconmax = profileiconmax;
	}
	/**
	 * @return the store
	 */
	public String getStore() {
		return store;
	}
	/**
	 * @param store the store to set
	 */
	public void setStore(String store) {
		this.store = store;
	}
	/**
	 * @return the v
	 */
	public String getV() {
		return v;
	}
	/**
	 * @param v the v to set
	 */
	public void setV(String v) {
		this.v = v;
	}
}
