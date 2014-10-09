/**
 * 
 */
package com.team4d.lolhelper.api.dto.staticdata.rune;

import java.util.List;
import java.util.Map;

import com.team4d.lolhelper.api.dto.staticdata.BasicDataStats;
import com.team4d.lolhelper.api.dto.staticdata.Gold;
import com.team4d.lolhelper.api.dto.staticdata.Image;
import com.team4d.lolhelper.api.dto.staticdata.Metadata;

/**
 * @author Shyos
 *
 */
public class Rune {
	private String colloq;
	private Boolean consumeOnFull;
	private Boolean consumed;
	private int depth;
	private String description;
	private List<String> from;
	private Gold gold;
	private String group;
	private Boolean hideFromAll;
	private Image image;
	private Boolean inStore;
	private List<String> into;
	private Map<String, Boolean> maps;
	private String name;
	private String plaintext;
	private String requiredChampion;
	private Metadata rune;
	private int specialRecipe;
	private int stacks;
	private BasicDataStats stats;
	private List<String> tags;
	/**
	 * @return the colloq
	 */
	public String getColloq() {
		return colloq;
	}
	/**
	 * @param colloq the colloq to set
	 */
	public void setColloq(String colloq) {
		this.colloq = colloq;
	}
	/**
	 * @return the consumeOnFull
	 */
	public Boolean getConsumeOnFull() {
		return consumeOnFull;
	}
	/**
	 * @param consumeOnFull the consumeOnFull to set
	 */
	public void setConsumeOnFull(Boolean consumeOnFull) {
		this.consumeOnFull = consumeOnFull;
	}
	/**
	 * @return the consumed
	 */
	public Boolean getConsumed() {
		return consumed;
	}
	/**
	 * @param consumed the consumed to set
	 */
	public void setConsumed(Boolean consumed) {
		this.consumed = consumed;
	}
	/**
	 * @return the depth
	 */
	public int getDepth() {
		return depth;
	}
	/**
	 * @param depth the depth to set
	 */
	public void setDepth(int depth) {
		this.depth = depth;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the from
	 */
	public List<String> getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(List<String> from) {
		this.from = from;
	}
	/**
	 * @return the gold
	 */
	public Gold getGold() {
		return gold;
	}
	/**
	 * @param gold the gold to set
	 */
	public void setGold(Gold gold) {
		this.gold = gold;
	}
	/**
	 * @return the group
	 */
	public String getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(String group) {
		this.group = group;
	}
	/**
	 * @return the hideFromAll
	 */
	public Boolean getHideFromAll() {
		return hideFromAll;
	}
	/**
	 * @param hideFromAll the hideFromAll to set
	 */
	public void setHideFromAll(Boolean hideFromAll) {
		this.hideFromAll = hideFromAll;
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
	 * @return the inStore
	 */
	public Boolean getInStore() {
		return inStore;
	}
	/**
	 * @param inStore the inStore to set
	 */
	public void setInStore(Boolean inStore) {
		this.inStore = inStore;
	}
	/**
	 * @return the into
	 */
	public List<String> getInto() {
		return into;
	}
	/**
	 * @param into the into to set
	 */
	public void setInto(List<String> into) {
		this.into = into;
	}
	/**
	 * @return the maps
	 */
	public Map<String, Boolean> getMaps() {
		return maps;
	}
	/**
	 * @param maps the maps to set
	 */
	public void setMaps(Map<String, Boolean> maps) {
		this.maps = maps;
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
	 * @return the plaintext
	 */
	public String getPlaintext() {
		return plaintext;
	}
	/**
	 * @param plaintext the plaintext to set
	 */
	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}
	/**
	 * @return the requiredChampion
	 */
	public String getRequiredChampion() {
		return requiredChampion;
	}
	/**
	 * @param requiredChampion the requiredChampion to set
	 */
	public void setRequiredChampion(String requiredChampion) {
		this.requiredChampion = requiredChampion;
	}
	/**
	 * @return the rune
	 */
	public Metadata getRune() {
		return rune;
	}
	/**
	 * @param rune the rune to set
	 */
	public void setRune(Metadata rune) {
		this.rune = rune;
	}
	/**
	 * @return the specialRecipe
	 */
	public int getSpecialRecipe() {
		return specialRecipe;
	}
	/**
	 * @param specialRecipe the specialRecipe to set
	 */
	public void setSpecialRecipe(int specialRecipe) {
		this.specialRecipe = specialRecipe;
	}
	/**
	 * @return the stacks
	 */
	public int getStacks() {
		return stacks;
	}
	/**
	 * @param stacks the stacks to set
	 */
	public void setStacks(int stacks) {
		this.stacks = stacks;
	}
	/**
	 * @return the stats
	 */
	public BasicDataStats getStats() {
		return stats;
	}
	/**
	 * @param stats the stats to set
	 */
	public void setStats(BasicDataStats stats) {
		this.stats = stats;
	}
	/**
	 * @return the tags
	 */
	public List<String> getTags() {
		return tags;
	}
	/**
	 * @param tags the tags to set
	 */
	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}
