package com.team4d.lolhelper.generalinfo;

public class SSpell
{
	public String name;
	public String effect;
	public int cooldown;
	public String range;
	public boolean breakstealth;
	public int level;

	public static SSpell[] summonerspells = new SSpell[13];

	public SSpell(String pname, String peffect, int pcooldown, String prange, boolean ptruesight, int plevel)
	{
		name = pname;
		effect = peffect;
		cooldown = pcooldown;
		range = prange;
		breakstealth = ptruesight;
		level = plevel;
	}

	public static String getName(SSpell a)
	{
		return a.name;
	}

	public static String getEffect(SSpell a)
	{
		return a.effect;
	}

	public static String getRange(SSpell a)
	{
		return a.range;
	}

	public static int getCooldown(SSpell a)
	{
		return a.cooldown;
	}

	public static int getLevel(SSpell a)
	{
		return a.level;
	}

	public static boolean getBreakStealth(SSpell a)
	{
		return a.breakstealth;
	}

	public static void runSSpells()
	{
		summonerspells[0] = new SSpell("Barrier",
				"Shields your champion for 115-455 (depending on champion level) for 2 seconds.", 210, "Self", false, 6);
		summonerspells[1] = new SSpell("Clairvoyance", "Reveals a small area of the map for your team for 5 seconds.",
				60, "25000", false, 10);
		summonerspells[2] = new SSpell("Clarity",
				"Restores 40% of your champion's maximum Mana. Also restores allies for 40% of their maximum Mana",
				180, "600", true, 1);
		summonerspells[3] = new SSpell(
				"Cleanse",
				"Removes all disables and summoner spell debuffs affecting your champion and lowers the duration of incoming disables by 65% for 3 seconds.",
				210, "Self", false, 2);
		summonerspells[4] = new SSpell(
				"Exhaust",
				"Exhausts target enemy champion, reducing their Movement Speed and Attack Speed by 30% for 2.5 seconds and reduces their damage dealt by 50% for the duration.",
				210, "650", true, 8);
		summonerspells[5] = new SSpell("Flash",
				"Teleports your champion a short distance toward your cursor's location.", 300, "425", false, 12);
		summonerspells[6] = new SSpell(
				"Garrison",
				"Allied Turret: Grants massive regeneration for 8 seconds. Enemy Turret: Reduces damage dealt by 80% for 8 seconds.",
				210, "1250", false, 1);
		summonerspells[7] = new SSpell("Ghost",
				"Your champion can move through units and has 27% increased Movement Speed for 10 seconds", 210,
				"Self", false, 1);
		summonerspells[8] = new SSpell(
				"Heal",
				"Restores 95-475 Health (depending on champion level) and Grants 30% Movement Speed for 2 seconds to you and target allied champion. Additionally removes any healing reduction effects that afflict either champion.",
				300, "850", true, 1);
		summonerspells[9] = new SSpell(
				"Ignite",
				"Ignites target enemy champion, dealing 70-410 true damage (depending on champion level) over 5 seconds, grants you vision of the target, and reduces healing effects on them for the duration.",
				300, "600", true, 8);
		summonerspells[10] = new SSpell(
				"Revive",
				"Instantly revives your champion at your team's Summoner Platform and increases their Movement Speed for a short duration.",
				540, "Self", false, 1);
		summonerspells[11] = new SSpell("Smite",
				"Deals 390-1000 true damage (depending on champion level) to target monster or enemy minion.", 40,
				"760", true, 3);
		summonerspells[12] = new SSpell("Teleport",
				"After channeling for 3.5 seconds, teleports your champion to target allied minion, turret, or ward.",
				300, "25000", true, 6);
	}

	public static void main(String[] args)
	{

		// keep empty

	}

}
