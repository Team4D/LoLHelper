package com.fourfoureight.lolhelper.General_Info;

public class ChampionInfo
{

	// Name, Title, and Roles
	private String name;
	private String title;
	private String primary;
	private String secondary;

	// Physical Stats Basic
	private double armor;
	private double attackDam;
	private double attackSpeed;
	private double range;
	private String rangeType;
	private double movespeed;

	// Health and Magic Stats
	private double health;
	private double healthRegen;
	private double mana;
	private double manaRegen;
	private double magicRes;

	private String typeOfMana; // could be energy or mana or health or fury

	// Per Level Stats
	private double healthPerLevel;
	private double healthRegenPerLevel;
	private double manaPerLevel;
	private double manaRegenPerLevel;
	private double attackDamPerLevel;
	private double attackSpeedPerLevel;
	private double armorPerLevel;
	private double magicResPerLevel;

	// Skill Rankings
	private int attack;
	private int defense;
	private int difficulty;
	private int magicAbility;

	// Spells
	private SpellInfo spells[];

	// Attributes
	private int attributes[];

	// Default Constructor of ChampionInfo
	public ChampionInfo()
	{
		name = "";
		title = "";
		primary = "";
		secondary = "";
		armor = 0;
		attackDam = 0;
		attackSpeed = 0;
		range = 0;
		rangeType = "";
		health = 0;
		healthRegen = 0;
		movespeed = 0;
		mana = 0;
		manaRegen = 0;
		magicRes = 0;
		attack = 0;
		defense = 0;
		difficulty = 0;
		magicAbility = 0;
		spells = null;
	}

	// Setters

	// sets the name and title of the champion
	public void setNameTitle(String nameOf, String titleOf)
	{
		name = nameOf;
		title = titleOf;

	}

	// sets the primary and secondary types of the champion
	public void setTypes(String prim, String sec)
	{
		primary = prim;
		secondary = sec;
	}

	// sets the attack, defense, ability, and difficulty levels of the champion
	public void setInfo(int att, int def, int mag, int diff)
	{
		attack = att;
		defense = def;
		difficulty = diff;
		magicAbility = mag;

	}

	// sets the attack damage (basic and per level increase) of champion
	public void setAttackDam(double attDam, double attDamGrowth)
	{
		attackDam = attDam;
		attackDamPerLevel = attDamGrowth;

	}

	// sets the attack speed (basic and per level increase) of champion
	public void setAttackSpeed(double attSpeed, double attSpeedGrowth)
	{

		attackSpeed = attSpeed;
		attackSpeedPerLevel = attSpeedGrowth;

	}

	// sets the attack range and range type of champion
	public void setRange(double attRange, String ragType)
	{

		range = attRange;
		rangeType = ragType;

	}

	// sets the armor (basic and per level increase) of champion
	public void setArmor(double arm, double armorGrowth)
	{
		armor = arm;
		armorPerLevel = armorGrowth;
	}

	// sets the move speed of the champion
	public void setMoveSpeed(double ms)
	{
		movespeed = ms;
	}

	// sets the health and health regeneration (basic and per level increase) of champion
	public void setHealthInfo(double heal, double healGrowth, double healreg, double healregGrowth)
	{
		health = heal;
		healthPerLevel = healGrowth;
		healthRegen = healreg;
		healthRegenPerLevel = healregGrowth;
	}

	// sets the mana and mana regeneration (basic and per level increase) and type it is (mana, fury, ferocity, energy)
	// of champion
	public void setManaInfo(double mn, double mnGrowth, double mnreg, double mnregGrowth, String typeMana)
	{
		mana = mn;
		manaPerLevel = mnGrowth;
		manaRegen = mnreg;
		manaRegenPerLevel = mnregGrowth;
		typeOfMana = typeMana;
	}

	// sets the magic resistance (basic and per level increase) of champion
	public void setMagicRes(double magRes, double magResGrowth)
	{
		magicRes = magRes;
		magicResPerLevel = magResGrowth;
	}

	// sets the spells specific to that champion
	public void setSpells(SpellInfo spellArray[])
	{
		spells = new SpellInfo[spellArray.length];

		for (int i = 0; i < spells.length; i++)
		{
			spells[i] = spellArray[i];
		}
	}

	// sets the attributes of the champion
	public void setAttributes(int att[])
	{
		attributes = new int[att.length];

		for (int i = 0; i < attributes.length; i++)
		{
			attributes[i] = att[i];
		}
	}

	// getters for names/titles
	public String getName()
	{
		return name;
	}

	public String getTitle()
	{
		return title;
	}

	public String getPrimary()
	{
		return primary;
	}

	public String getSecondary()
	{
		return secondary;
	}

	// getters for champion levels
	public int getAttack()
	{
		return attack;
	}

	public int getDefense()
	{
		return defense;
	}

	public int getDifficulty()
	{
		return difficulty;
	}

	public int getMagicOrAbility()
	{
		return magicAbility;
	}

	// getters for Stats

	// Armor Info
	public double getArmor()
	{
		return armor;
	}

	public double getArmorPerLevel()
	{
		return armorPerLevel;
	}

	// Attack Damage Info
	public double getAttackDam()
	{
		return attackDam;
	}

	public double getAttackDamPerLevel()
	{
		return attackDamPerLevel;
	}

	// Attack Speed Info
	public double getAttackSpeed()
	{
		return attackSpeed;
	}

	public double getAttackSpeedPerLevel()
	{
		return attackSpeedPerLevel;
	}

	// Range Info
	public double getRange()
	{
		return range;
	}

	public String getRangeType()
	{
		return rangeType;
	}

	// Health Info
	public double getHealth()
	{
		return health;
	}

	public double getHealthPerLevel()
	{
		return healthPerLevel;
	}

	// Health Regen Info
	public double getHealthRegen()
	{
		return healthRegen;
	}

	public double getHealthRegenPerLevel()
	{
		return healthRegenPerLevel;
	}

	// Mana Info
	public String getTypeOfMana()
	{
		return typeOfMana;
	}

	public double getMana()
	{
		return mana;
	}

	public double getManaPerLevel()
	{
		return manaPerLevel;
	}

	// Mana Regen Info
	public double getManaRegen()
	{
		return manaRegen;
	}

	public double getManaRegenPerLevel()
	{
		return manaRegenPerLevel;
	}

	// Magic Res Info
	public double getMagicRes()
	{
		return magicRes;
	}

	public double getMagicResPerLevel()
	{
		return magicResPerLevel;
	}

	// Movespeed Info
	public double getMoveSpeed()
	{
		return movespeed;
	}

	// Spell Info
	public SpellInfo[] getSpells()
	{
		return spells;
	}

	// TeamBuilder Attributes
	public int[] getAttributes()
	{
		return attributes;
	}

}
