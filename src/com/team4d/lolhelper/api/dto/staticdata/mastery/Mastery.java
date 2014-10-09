/**
 * 
 */
package com.team4d.lolhelper.api.dto.staticdata.mastery;

import java.util.List;

import com.team4d.lolhelper.api.dto.staticdata.Image;

/**
 * @author Shyos
 * 
 */
public class Mastery {
	private List<String> description;
	private int id;
	private Image image;
	private String name;
	private String prereq;
	private int ranks;
	/**
	 * @return the description
	 */
	public List<String> getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(List<String> description) {
		this.description = description;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	/**
	 * @param image the image to set
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the prereq
	 */
	public String getPrereq() {
		return prereq;
	}
	/**
	 * @param prereq the prereq to set
	 */
	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}
	/**
	 * @return the ranks
	 */
	public int getRanks() {
		return ranks;
	}
	/**
	 * @param ranks the ranks to set
	 */
	public void setRanks(int ranks) {
		this.ranks = ranks;
	}
}
