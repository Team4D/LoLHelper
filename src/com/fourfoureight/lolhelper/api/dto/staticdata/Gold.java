/**
 * 
 */
package com.fourfoureight.lolhelper.api.dto.staticdata;

/**
 * @author Shyos
 * 
 */
public class Gold {
	private int base;
	private boolean purchasable;
	private int sell;
	private int total;
	/**
	 * @return the base
	 */
	public int getBase() {
		return base;
	}
	/**
	 * @param base the base to set
	 */
	public void setBase(int base) {
		this.base = base;
	}
	/**
	 * @return the purchasable
	 */
	public boolean isPurchasable() {
		return purchasable;
	}
	/**
	 * @param purchasable the purchasable to set
	 */
	public void setPurchasable(boolean purchasable) {
		this.purchasable = purchasable;
	}
	/**
	 * @return the sell
	 */
	public int getSell() {
		return sell;
	}
	/**
	 * @param sell the sell to set
	 */
	public void setSell(int sell) {
		this.sell = sell;
	}
	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
