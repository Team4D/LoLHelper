package lolapi.dto.staticdata.SummonerSpell;

import java.util.List;

import lolapi.dto.staticdata.Image;
import lolapi.dto.staticdata.LevelTip;
import lolapi.dto.staticdata.SpellVars;

public class SummonerSpell {
	private List<Integer> cooldown;
	private String cooldownBurn;
	private List<Integer> cost;
	private String costBurn;
	private String costType;
	private String description;
	private List<Object> effect;
	private List<String> effectBurn;
	private String id;
	private Image image;
	private String key;
	private LevelTip leveltip;
	private String maxrank;
	private List<String> modes;
	private String name;
	private Object range;
	private String rangeBurn;
	private String resource;
	private int summonerLevel;
	private String tooltip;
	private List<SpellVars> vars;
	/**
	 * @return the cooldown
	 */
	public List<Integer> getCooldown() {
		return cooldown;
	}
	/**
	 * @param cooldown the cooldown to set
	 */
	public void setCooldown(List<Integer> cooldown) {
		this.cooldown = cooldown;
	}
	/**
	 * @return the cooldownBurn
	 */
	public String getCooldownBurn() {
		return cooldownBurn;
	}
	/**
	 * @param cooldownBurn the cooldownBurn to set
	 */
	public void setCooldownBurn(String cooldownBurn) {
		this.cooldownBurn = cooldownBurn;
	}
	/**
	 * @return the cost
	 */
	public List<Integer> getCost() {
		return cost;
	}
	/**
	 * @param cost the cost to set
	 */
	public void setCost(List<Integer> cost) {
		this.cost = cost;
	}
	/**
	 * @return the costBurn
	 */
	public String getCostBurn() {
		return costBurn;
	}
	/**
	 * @param costBurn the costBurn to set
	 */
	public void setCostBurn(String costBurn) {
		this.costBurn = costBurn;
	}
	/**
	 * @return the costType
	 */
	public String getCostType() {
		return costType;
	}
	/**
	 * @param costType the costType to set
	 */
	public void setCostType(String costType) {
		this.costType = costType;
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
	 * @return the effect
	 */
	public List<Object> getEffect() {
		return effect;
	}
	/**
	 * @param effect the effect to set
	 */
	public void setEffect(List<Object> effect) {
		this.effect = effect;
	}
	/**
	 * @return the effectBurn
	 */
	public List<String> getEffectBurn() {
		return effectBurn;
	}
	/**
	 * @param effectBurn the effectBurn to set
	 */
	public void setEffectBurn(List<String> effectBurn) {
		this.effectBurn = effectBurn;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the leveltip
	 */
	public LevelTip getLeveltip() {
		return leveltip;
	}
	/**
	 * @param leveltip the leveltip to set
	 */
	public void setLeveltip(LevelTip leveltip) {
		this.leveltip = leveltip;
	}
	/**
	 * @return the maxrank
	 */
	public String getMaxrank() {
		return maxrank;
	}
	/**
	 * @param maxrank the maxrank to set
	 */
	public void setMaxrank(String maxrank) {
		this.maxrank = maxrank;
	}
	/**
	 * @return the modes
	 */
	public List<String> getModes() {
		return modes;
	}
	/**
	 * @param modes the modes to set
	 */
	public void setModes(List<String> modes) {
		this.modes = modes;
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
	 * @return the range
	 */
	public Object getRange() {
		return range;
	}
	/**
	 * @param range the range to set
	 */
	public void setRange(Object range) {
		this.range = range;
	}
	/**
	 * @return the rangeBurn
	 */
	public String getRangeBurn() {
		return rangeBurn;
	}
	/**
	 * @param rangeBurn the rangeBurn to set
	 */
	public void setRangeBurn(String rangeBurn) {
		this.rangeBurn = rangeBurn;
	}
	/**
	 * @return the resource
	 */
	public String getResource() {
		return resource;
	}
	/**
	 * @param resource the resource to set
	 */
	public void setResource(String resource) {
		this.resource = resource;
	}
	/**
	 * @return the summonerLevel
	 */
	public int getSummonerLevel() {
		return summonerLevel;
	}
	/**
	 * @param summonerLevel the summonerLevel to set
	 */
	public void setSummonerLevel(int summonerLevel) {
		this.summonerLevel = summonerLevel;
	}
	/**
	 * @return the tooltip
	 */
	public String getTooltip() {
		return tooltip;
	}
	/**
	 * @param tooltip the tooltip to set
	 */
	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}
	/**
	 * @return the vars
	 */
	public List<SpellVars> getVars() {
		return vars;
	}
	/**
	 * @param vars the vars to set
	 */
	public void setVars(List<SpellVars> vars) {
		this.vars = vars;
	}
}
