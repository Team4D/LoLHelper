package com.fourfoureight.lolhelper.api.dto.staticdata.Item;

import java.util.List;
import java.util.Map;

import com.fourfoureight.lolhelper.api.dto.staticdata.BasicDataStats;
import com.fourfoureight.lolhelper.api.dto.staticdata.Gold;
import com.fourfoureight.lolhelper.api.dto.staticdata.Image;
import com.fourfoureight.lolhelper.api.dto.staticdata.Metadata;

public class Item {
			
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
	public String getColloq() {
		return colloq;
	}
	public void setColloq(String colloq) {
		this.colloq = colloq;
	}
	public Boolean getConsumeOnFull() {
		return consumeOnFull;
	}
	public void setConsumeOnFull(Boolean consumeOnFull) {
		this.consumeOnFull = consumeOnFull;
	}
	public Boolean getConsumed() {
		return consumed;
	}
	public void setConsumed(Boolean consumed) {
		this.consumed = consumed;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<String> getFrom() {
		return from;
	}
	public void setFrom(List<String> from) {
		this.from = from;
	}
	public Gold getGold() {
		return gold;
	}
	public void setGold(Gold gold) {
		this.gold = gold;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public Boolean getHideFromAll() {
		return hideFromAll;
	}
	public void setHideFromAll(Boolean hideFromAll) {
		this.hideFromAll = hideFromAll;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Boolean getInStore() {
		return inStore;
	}
	public void setInStore(Boolean inStore) {
		this.inStore = inStore;
	}
	public List<String> getInto() {
		return into;
	}
	public void setInto(List<String> into) {
		this.into = into;
	}
	public Map<String, Boolean> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Boolean> maps) {
		this.maps = maps;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPlaintext() {
		return plaintext;
	}
	public void setPlaintext(String plaintext) {
		this.plaintext = plaintext;
	}
	public String getRequiredChampion() {
		return requiredChampion;
	}
	public void setRequiredChampion(String requiredChampion) {
		this.requiredChampion = requiredChampion;
	}
	public Metadata getRune() {
		return rune;
	}
	public void setRune(Metadata rune) {
		this.rune = rune;
	}
	public int getSpecialRecipe() {
		return specialRecipe;
	}
	public void setSpecialRecipe(int specialRecipe) {
		this.specialRecipe = specialRecipe;
	}
	public int getStacks() {
		return stacks;
	}
	public void setStacks(int stacks) {
		this.stacks = stacks;
	}
	public BasicDataStats getStats() {
		return stats;
	}
	public void setStats(BasicDataStats stats) {
		this.stats = stats;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}		
			
}
