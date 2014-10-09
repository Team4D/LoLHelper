package com.team4d.lolhelper.generalinfo;

public class SpellDatabase
{

	public static SpellInfo[][] champSpells = new SpellInfo[118][]; // Champion Spell Array to store the spell arrays

	// to according to the champion number to be
	// stored and use later
	public static void makeSpellDatabase()
	{

		String arrS[] = {};
		// create champion array
		// store spell array of # spells for that champion in champion array, for easy access
		// still create spells individually

		// Creates Spells of the Champion and places them in an array to be referenced and used later
		SpellInfo[] aatroxSpells = new SpellInfo[6];
		aatroxSpells[0] = new SpellInfo(
				"Blood Well",
				"",
				"225",
				"",
				arrS,
				new String[] {
						"Aatrox passively increases his attack speed by 0.6 / 0.7 / 0.8 / 0.9 / 1 / 1.1% for every 2% in the Blood Well.",
						"Upon taking fatal damage, Blood Well activates and places Aatrox in stasis for up to 3 seconds. Over the stasis duration the Blood Well is emptied and Aatrox restores health equal to its contents plus 10.5 + (15.75 × level). Aatrox can cancel the stasis early after 1 second by moving, but this also ends the health regeneration." });
		aatroxSpells[1] = new SpellInfo(
				"Dark Flight",
				"650",
				"16 / 15 / 14 / 13 / 12",
				"10% CURRENT HEALTH",
				new String[] { "PHYSICAL DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 60% bonus AD)" },
				new String[] { "ACTIVE: Aatrox takes flight and slams down at a targeted area, dealing physical damage to nearby enemies upon landing. Enemies in the center of the area are also knocked up for 1 second." });
		aatroxSpells[2] = new SpellInfo(
				"Blood Thirst",
				"",
				"0.5",
				"",
				new String[] { "HEAL: 20 / 25 / 30 / 35 / 40 (+25% bonus AD)",
						"ENHANCED HEAL: 60 / 75 / 90 / 105 / 120 (+75% bonus AD)" },
				new String[] { "TOGGLE OFF: Aatrox heals himself on every third attack. If Aatrox is below 50% health he will heal for three times as much." });
		aatroxSpells[3] = new SpellInfo(
				"Blood Price",
				"",
				"0.5",
				"SPECIAL",
				new String[] { "BONUS PHYSICAL DAMAGE: 60 / 95 / 130 / 165 / 200 (+100% bonus AD)",
						"HEALTH COST ON THIRD ATTACK: 15 / 23.75 / 32.5 / 41.25 / 50 (+25% bonus AD)" },
				new String[] { "TOGGLE ON: Aatrox deals bonus physical damage on every third attack at the cost of health." });
		aatroxSpells[4] = new SpellInfo(
				"Blades of Torment",
				"1000",
				"12 / 11 / 10 / 9 / 8",
				"5% CURRENT HEALTH",
				new String[] { "MAGIC DAMAGE: 75 / 110 / 145 / 180 / 215 (+ 60% AP) (+ 60% bonus AD)",
						"SLOW DURATION: 1.75 / 2 / 2.25 / 2.5 / 2.75" },
				new String[] { "ACTIVE: Aatrox unleashes and sends forward the power of his blade, dealing magic damage to enemies in a line and slowing them by 40% for a few seconds." });
		aatroxSpells[5] = new SpellInfo(
				"Massacre",
				"",
				"100 / 85 / 70",
				"NO COST",
				new String[] { "MAGIC DAMAGE: 200 / 300 / 400 (+ 100% AP)", "ATTACK SPEED: 40 / 50 / 60%" },
				new String[] {
						"ACTIVE: Aatrox draws in the blood of his foes, dealing magic damage to nearby enemy champions.",
						"For the next 12 seconds, Aatrox gains bonus attack speed and 175 bonus attack range (325 total range). His attacks are still considered melee." });
		champSpells[0] = aatroxSpells;

		SpellInfo[] ahriSpells = new SpellInfo[5];
		ahriSpells[0] = new SpellInfo(
				"Essence Theft",
				"",
				"",
				"",
				arrS,
				new String[] {
						"Ahri gains a charge of Essence Theft with each enemy unit hit by any of her spells, with a cap of 3 charges gained per spell cast.",
						"Upon reaching 9 charges, Ahri's next spell will heal her for 2 + (Ahri's level) (+ 9% AP) for each enemy hit." });
		ahriSpells[1] = new SpellInfo(
				"Orb of Deception",
				"880",
				"7",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE / TRUE DAMAGE: 40 / 65 / 90 / 115 / 140 (+ 32.5% AP)",
						"MAX DAMAGE TO THE SAME TARGET: 80 / 130 / 180 / 230 / 280 (+ 65% AP)" },
				new String[] { "ACTIVE: Ahri sends out an orb in a line in front of her and then pulls it back, dealing magic damage on the way out and true damage on the way back." });
		ahriSpells[2] = new SpellInfo(
				"Fox-Fire",
				"800",
				"9 / 8 / 7 / 6 / 5",
				"50 MANA",
				new String[] { "MAGIC DAMAGE PER FOX-FIRE: 40 / 65 / 90 / 115 / 140 (+ 40% AP)",
						"MAGIC DAMAGE TO THREE TARGETS: 120 / 195 / 270 / 345 / 420 (+ 120% AP)",
						"MAGIC DAMAGE TO THE SAME TARGET: 64 / 104 / 144 / 184 / 224 (+ 64% AP)" },
				new String[] {
						"ACTIVE: Ahri releases three fox-fires to surround her for up to 5 seconds. After a short delay after cast, each flame will target the closest visible enemy unit to itself, prioritizing champions, and deal magic damage to the target.",
						"Additional fox-fires that hit the same target will only deal 30% damage." });
		ahriSpells[3] = new SpellInfo(
				"Charm",
				"975",
				"12",
				"85 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 35% AP)",
						"DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] {
						"ACTIVE: Ahri blows a kiss that travels in a line in front of her. The first enemy it hits takes magic damage and is charmed, forcing them to walk harmlessly towards Ahri while being slowed by 50% for the duration.",
						"Enemies hit by Charm take 20% more magic damage from Ahri for 6 seconds. Orb of Deception's true damage is also increased by this effect." });
		ahriSpells[4] = new SpellInfo(
				"Spirit Rush",
				"550",
				"110 / 95 / 80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 110 / 150 (+ 30% AP)",
						"MAX DAMAGE TO SAME TARGET: 210 / 330 / 450 (+ 90% AP)", "DASH RANGE: 450" },
				new String[] { "ACTIVE: Ahri dashes towards the cursor and fires essence bolts, dealing magic damage to up to 3 visible nearby enemies, prioritizing champions. In the next 10 seconds, Spirit Rush can be cast two additional times before going on cooldown. Each enemy can only be hit once per dash." });
		champSpells[1] = ahriSpells;

		SpellInfo[] akaliSpells = new SpellInfo[5];
		akaliSpells[0] = new SpellInfo(
				"Twin Disciplines",
				"",
				"",
				"",
				arrS,
				new String[] {
						"DISCIPLINE OF FORCE: Akali's auto attacks deal 6% (+ 1% per 6 AP) of her attack damage as bonus magic damage.",
						"DISCIPLINE OF MIGHT: Akali gains 6% (+ 1% per 6 bonus AD) spell vamp." });
		akaliSpells[1] = new SpellInfo(
				"Mark of the Assassin",
				"600",
				"6 / 5.5 / 5 / 4.5 / 4",
				"60 ENERGY",
				new String[] { "INITIAL MAGIC DAMAGE: 35 / 55 / 75 / 95 / 115 (+ 40% AP)",
						"DETONATION MAGIC DAMAGE: 45 / 70 / 95 / 120 / 145 (+ 50% AP)",
						"TOTAL MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 90% AP)",
						"ENERGY RESTORED: 20 / 25 / 30 / 35 / 40" },
				new String[] {
						"ACTIVE: Akali throws her kama at a target enemy, dealing magic damage and marking the target for 6 seconds.",
						"Akali's basic attacks or Crescent Slash against a marked target will consume the mark, dealing additional magic damage again and restoring energy." });
		akaliSpells[2] = new SpellInfo(
				"Twilight Shroud",
				"700",
				"20",
				"80 / 75 / 70 / 65 / 60 ENERGY",
				new String[] { "ARMOR & MAGIC RESIST: 10 / 20 / 30 / 40 / 50", "SLOW: 14 / 18 / 22 / 26 / 30%" },
				new String[] { "ACTIVE: Akali creates a sight-granting smoke cloud in a 300-radius area for 8 seconds. While within the cloud, Akali is stealthed and gains bonus armor and magic resistance. Attacking or using abilities reveals her for 0.65 seconds. Enemies inside the smoke are slowed." });
		akaliSpells[3] = new SpellInfo(
				"Crescent Slash",
				"325",
				"7 / 6 / 5 / 4 / 3",
				"60 / 55 / 50 / 45 / 40 ENERGY",
				new String[] { "PHYSICAL DAMAGE: 30 / 55 / 80 / 105 / 130 (+ 30% AP) (+ 60% AD)" },
				new String[] { "ACTIVE: Akali flourishes her kamas, dealing physical damage and triggering any  Mark of the Assassin on nearby enemies." });
		akaliSpells[4] = new SpellInfo(
				"Shadow Dance",
				"800",
				"2 / 1.5 / 1",
				"1 ESSENCE OF SHADOW",
				new String[] { "NEW ESSENCE OF SHADOW: 30 / 22.5 / 15", "MAGIC DAMAGE: 100 / 175 / 250 (+ 50% AP)" },
				new String[] { "ACTIVE: Akali uses an Essence of Shadow, dashing to and dealing magic damage to a target enemy. Akali gains an Essence of Shadow periodically, affected by cooldown reduction, up to a maximum of 3. Additionally, gaining a kill or assist will restore an Essence of Shadow." });
		champSpells[2] = akaliSpells;

		SpellInfo[] alistarSpells = new SpellInfo[5];
		alistarSpells[0] = new SpellInfo(
				"Trample",
				"",
				"",
				"",
				arrS,
				new String[] { "After casting a spell, for 3 seconds Alistar ignores unit collision and deals 6 + (1 × level) (+ 10% AP) magic damage to nearby enemy units and structures each second. Trample deals double damage to minions and monsters, dealing 12 + (2 × level) (+ 20% AP) damage per second." });
		alistarSpells[1] = new SpellInfo(
				"Pulverize",
				"365",
				"17 / 16 / 15 / 14 / 13",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 105 / 150 / 195 / 240 (+50% AP)" },
				new String[] { "ACTIVE: Alistar smashes the ground beneath him, dealing magic damage to nearby enemies and knocking them up for 1 second. Upon landing, they are stunned for 0.5 seconds." });
		alistarSpells[2] = new SpellInfo(
				"Headbutt",
				"650",
				"14 / 13 / 12 / 11 / 10",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 55 / 110 / 165 / 220 / 275 (+70% AP)" },
				new String[] { "ACTIVE: Alistar dashes to an enemy, dealing magic damage, stunning it for 1 sec while knocking it back 650-range." });
		alistarSpells[3] = new SpellInfo(
				"Triumphant Roar",
				"575",
				"12",
				"40 / 50 / 60 / 70 / 80 MANA",
				new String[] { "SELF HEAL: 60 / 90 / 120 / 150 / 180 (+20% AP)",
						"FRIENDLY UNIT HEAL: 30 / 45 / 60 / 75 / 90 (+10% AP)" },
				new String[] { "ACTIVE: Alistar heals himself, with nearby allies healing for half that amount. Triumphant Roar's cooldown is reduced by 2 seconds whenever a nearby enemy unit dies." });
		alistarSpells[4] = new SpellInfo(
				"Unbreakable Will",
				"",
				"120 / 100 / 80",
				"100 MANA",
				new String[] { "ATTACK DAMAGE: 60 / 75 / 90", "DAMAGE REDUCTION: 50 / 60 / 70%" },
				new String[] { "ACTIVE: Alistar roars, removing all crowd control effects on himself. For 7 seconds afterwards, he gains bonus attack damage and takes reduced physical and magic damage." });
		champSpells[3] = alistarSpells;

		SpellInfo[] amumuSpells = new SpellInfo[5];
		amumuSpells[0] = new SpellInfo(
				"Cursed Touch",
				"",
				"",
				"",
				arrS,
				new String[] { "Amumu's autoattacks reduce the target's magic resistance by 15 / 20 / 25 for 3 seconds. This debuff refreshes with every basic attack." });
		amumuSpells[1] = new SpellInfo("Bandage Toss", "1100", "16 / 14 / 12 / 10 / 8",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 70% AP)" }, new String[] { "" });
		amumuSpells[2] = new SpellInfo(
				"Despair",
				"400",
				"1",
				"8 MANA PER SECOND",
				new String[] {
						"BASE MAGIC DAMAGE PER SECOND: 8 / 12 / 16 / 20 / 24",
						"ADDITIONAL DAMAGE PER SECOND: 1.5 / 1.8 / 2.1 / 2.4 / 2.7% (+ 1% per 100 AP) of enemies' maximum health" },
				new String[] { "TOGGLE: Amumu is surrounded by a small pool of damaging tears. Enemies in the area take magic damage each second equal to a base amount plus a percentage of their maximum health." });
		amumuSpells[3] = new SpellInfo(
				"Tantrum",
				"200",
				"10 / 9 / 8 / 7 / 6",
				"35 MANA",
				new String[] { "PHYSICAL DAMAGE REDUCTION: 2 / 4 / 6 / 8 / 10",
						"MAGIC DAMAGE: 75 / 100 / 125 / 150 / 175 (+ 50% AP)" },
				new String[] {
						"PASSIVE: Amumu takes reduced physical damage from autoattacks and abilities.",
						"ACTIVE: Amumu releases his anger, dealing magic damage to surrounding enemies. Each autoattack that hits Amumu will reduce Tantrum's cooldown by 0.5 seconds." });
		amumuSpells[4] = new SpellInfo(
				"Curse of the Sad Mummy",
				"550",
				"150 / 130 / 110",
				"100 / 150 / 200 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 80% AP)" },
				new String[] { "ACTIVE: Amumu entangles surrounding enemy units, dealing magic damage and rendering them unable to move and attack for 2 seconds." });
		champSpells[4] = amumuSpells;

		SpellInfo[] aniviaSpells = new SpellInfo[5];
		aniviaSpells[0] = new SpellInfo(
				"Rebirth",
				"",
				"240",
				"",
				arrS,
				new String[] { "Upon taking lethal damage, Anivia will transform into an egg with 100% health. While in egg form, Anivia is unable to make any actions and her armor and magic resistance are modified by -40 / -25 / -10 / +5 / +20. If her egg survives for 6 seconds, Anivia is revived with the same percentage health that her egg had." });
		aniviaSpells[1] = new SpellInfo(
				"Flash Frost",
				"1100",
				"12 / 11 / 10 / 9 / 8",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 50% AP)",
						"MAXIMUM DAMAGE: 120 / 180 / 240 / 300 / 360 (+ 100% AP)" },
				new String[] {
						"FIRST CAST: Anivia unleashes an orb of ice that travels in a line, dealing magic damage to any enemy it passes through. At maximum range, Flash Frost will detonate automatically.",
						"SECOND CAST: Anivia detonates the orb, dealing magic damage and stunning enemies in a 75-radius area for 1 second. Enemies can be damaged by both parts of Flash Frost.",
						"Enemies damaged by Flash Frost are Chilled for 3 seconds, slowing their movement speed by 20%." });
		aniviaSpells[2] = new SpellInfo(
				"Crystallize",
				"1000",
				"25",
				"70 MANA",
				new String[] { "WALL LENGTH: 400 / 500 / 600 / 700 / 800" },
				new String[] { "ACTIVE: Anivia constructs an impassable wall of ice at the target location for 5 seconds, perpendicular to Anivia's facing. The wall grants sight in a large area around it." });
		aniviaSpells[3] = new SpellInfo(
				"Frostbite",
				"700",
				"5",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 55 / 85 / 115 / 145 / 175 (+ 50% AP)",
						"CHILLED DAMAGE: 110 / 170 / 230 / 290 / 350 (+ 100% AP)" },
				new String[] { "ACTIVE: Anivia fires a shard of ice to deal magic damage to a target enemy. Frostbite deals double damage to enemies that are Chilled." });
		aniviaSpells[4] = new SpellInfo(
				"Glacial Storm",
				"615",
				"6",
				"75 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 80 / 120 / 160 (+ 25% AP)", "MANA PER SECOND: 40 / 50 / 60" },
				new String[] {
						"ACTIVE: Anivia creates a blizzard in a target 400-radius area, that deals magic damage every second to enemies inside. Enemies damaged by Glacial Storm are Chilled for 1 second, slowing their movement speed and attack speed by 20%.",
						"Anivia can re-activate Glacial Storm at any time to disable its effects, and it will deactivate automatically if she gets too far away or runs out of mana. Additionally, Glacial Storm will be deactivated by all forms of interrupting crowd control, excluding fear and taunt. Glacial Storm deals a tick of damage to enemies within when cancelled." });
		champSpells[5] = aniviaSpells;

		SpellInfo[] annieSpells = new SpellInfo[5];
		annieSpells[0] = new SpellInfo(
				"Pyromania",
				"",
				"",
				"",
				arrS,
				new String[] { "Every 4 spell casts, Annie's next offensive spell will stun all damaged enemies for 1.25 / 1.5 / 1.75 seconds." });
		annieSpells[1] = new SpellInfo(
				"Disintegrate",
				"625",
				"4",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 115 / 150 / 185 / 220 (+ 80% AP)" },
				new String[] { "ACTIVE: Annie blasts target enemy with a fireball, dealing magic damage. If Disintegrate kills the target, it refunds its mana cost and its cooldown is halved." });
		annieSpells[2] = new SpellInfo(
				"Incinerate",
				"625",
				"8",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 85% AP)" },
				new String[] { "ACTIVE: Annie scorches all enemies in a 50° conic area in front of her with fire, dealing magic damage." });
		annieSpells[3] = new SpellInfo(
				"Molten Shield",
				"",
				"10",
				"20 MANA",
				new String[] { "ARMOR & MAGIC RESIST: 20 / 30 / 40 / 50 / 60",
						"MAGIC DAMAGE: 20 / 30 / 40 / 50 / 60 (+ 20% AP)" },
				new String[] { "ACTIVE: For 5 seconds, Annie is surrounded by a shield of fire, increasing her armor and magic resistance and dealing magic damage to enemies each time they use a basic attack against her." });
		annieSpells[4] = new SpellInfo(
				"Summon: Tibbers",
				"600",
				"120 / 100 / 80",
				"100 MANA",
				new String[] { "SUMMON MAGIC DAMAGE: 175 / 300 / 425 (+ 80% AP)",
						"TOTAL SUMMON MAGIC DAMAGE: 210 / 335 / 460 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Annie summons  Tibbers to the target location in a burst of flame, dealing magic damage to enemies within 290-range.  Tibbers remains on the field for up to 45 seconds, and Annie can control his movement and attacks.",
						"Tibbers deals magical damage with his attacks, and is also surrounded by a flaming aura that deals 35 (+ 20% AP) magic damage every second to enemies within 200-range of himself." });
		champSpells[6] = annieSpells;

		SpellInfo[] asheSpells = new SpellInfo[5];
		asheSpells[0] = new SpellInfo(
				"Focus",
				"",
				"",
				"",
				arrS,
				new String[] { "If Ashe has not attacked in the last 3 seconds, she gains 4 / 5 / 6 / 7 / 8 Focus stacks per second. At 100 stacks, Ashe will critically strike on her next basic attack. Thereafter, Focus stacks will reset to an amount equal to her critical strike chance." });
		asheSpells[1] = new SpellInfo("Frost Shot", "", "", "8 MANA PER ATTACK",
				new String[] { "SLOW: 15 / 20 / 25 / 30 / 35%" },
				new String[] { "TOGGLE: Ashe enchants her basic attacks with ice, slowing her targets for 2 seconds." });
		asheSpells[2] = new SpellInfo(
				"Volley",
				"1200",
				"16 / 13 / 10 / 7 / 4",
				"60 MANA",
				new String[] { "PHYSICAL DAMAGE PER ARROW: 40 / 50 / 60 / 70 / 80 (+ 100% AD)" },
				new String[] { "ACTIVE: Ashe fires 7 arrows in a 57.5º cone, dealing physical damage to each target hit. Each arrow will only hit one enemy, and each enemy will only be hit by one arrow. Volley also applies the current rank of  Frost Shot, regardless of whether it is toggled on or not." });
		asheSpells[3] = new SpellInfo(
				"Hawkshot",
				"2500 / 3250 / 4000 / 4750 / 5500",
				"60 / 55 / 50 / 45 / 40",
				"NO COST",
				arrS,
				new String[] {
						"PASSIVE: Ashe gains 3 bonus gold each time she kills a unit or destroys a structure.",
						"ACTIVE: Ashe animates a hawk to scout for her, granting sight for 2 seconds as it flies towards a target location. Hawkshot grants a 1000-radius area of sight for 5 seconds when it reaches its destination. The sight extends into brushes." });
		asheSpells[4] = new SpellInfo(
				"Enchanted Crystal Arrow",
				"Global",
				"100 / 90 / 80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 250 / 425 / 600 (+ 100% AP)",
						"SPLASH DAMAGE: 125 / 212.5 / 300 (+ 50% AP)" },
				new String[] { "ACTIVE: Ashe fires a giant arrow in a straight line. If it hits an enemy champion, it will deal magic damage and stun that champion for 1-3.5 second(s), based on the distance the arrow traveled. Additionally, enemies within a 250-radius of the impact take half the damage and are slowed by 50% for 3 seconds." });
		champSpells[7] = asheSpells;

		SpellInfo[] blitzcrankSpells = new SpellInfo[5];
		blitzcrankSpells[0] = new SpellInfo(
				"Mana Barrier",
				"",
				"90",
				"",
				arrS,
				new String[] { "PASSIVE: When Blitzcrank drops below 20% of his maximum health he gains a shield equal to 50% of his current mana that lasts 10 seconds." });
		blitzcrankSpells[1] = new SpellInfo(
				"Rocket Grab",
				"925",
				"20 / 19 / 18 / 17 / 16",
				"120 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 135 / 190 / 245 / 300 (+ 100% AP)" },
				new String[] { "ACTIVE: Blitzcrank extends his right hand in a line. The first enemy hit is pulled to his location, takes magic damage and is stunned for 1 second." });
		blitzcrankSpells[2] = new SpellInfo(
				"Overdrive",
				"",
				"15",
				"75 MANA",
				new String[] { "MOVEMENT SPEED: 16 / 20 / 24 / 28 / 32%", "ATTACK SPEED: 30 / 38 / 46 / 54 / 62%" },
				new String[] { "ACTIVE: Blitzcrank super charges himself, gaining increased movement and attack speed for 8 seconds." });
		blitzcrankSpells[3] = new SpellInfo(
				"Power Fist",
				"",
				"9 / 8 / 7 / 6 / 5",
				"25 MANA",
				arrS,
				new String[] { "ACTIVE: Blitzcrank supercharges his next basic attack, causing it to deal an additional 100% of his attack damage and knocking his target into the air for 1 second." });
		blitzcrankSpells[4] = new SpellInfo(
				"Static Field",
				"",
				"30",
				"150 MANA",
				new String[] { "PASSIVE MAGIC DAMAGE: 100 / 200 / 300 (+ 20% AP)",
						"ACTIVE MAGIC DAMAGE: 250 / 375 / 500 (+ 100% AP)" },
				new String[] {
						"PASSIVE: Every 2.5 seconds, Blitzcrank fires a lightning bolt at a random enemy within 450-range, dealing magic damage. This effect cannot target stealthed enemies.",
						"ACTIVE: Blitzcrank detonates his static field, dealing magic damage to nearby enemies within 600-range and silencing them for 0.5 seconds.",
						"Static Field's passive damage is disabled while its active is on cooldown." });
		champSpells[8] = blitzcrankSpells;

		SpellInfo[] brandSpells = new SpellInfo[5];
		brandSpells[0] = new SpellInfo(
				"Blaze",
				"",
				"",
				"",
				arrS,
				new String[] {
						"Brand's spells light his targets ablaze, dealing 2% of their maximum health as magic damage per second for 4 seconds, for a total of 8% maximum health.",
						"Monsters take a maximum of 80 damage per second from Blaze (320 total damage)." });
		brandSpells[1] = new SpellInfo(
				"Sear",
				"900",
				"8 / 7.5 / 7 / 6.5 / 6",
				"50 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 65% AP)" },
				new String[] {
						"ACTIVE: Brand launches a fireball forward that deals magic damage to the first enemy it hits.",
						"If the target is  ablaze, the target is also stunned for 2 seconds." });
		brandSpells[2] = new SpellInfo(
				"Pillar of Flame",
				"900",
				"10",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 120 / 165 / 210 / 255 (+ 60% AP)",
						"BLAZED MAGIC DAMAGE: 93.75 / 150 / 206.25 / 262.50 / 318.75 (+ 75% AP)" },
				new String[] {
						"ACTIVE: After a 0.625 second delay, Brand creates a burst of fire at target 250-radius area, dealing magic damage to enemies inside.",
						"Units that are  ablaze take an additional 25% damage." });
		brandSpells[3] = new SpellInfo(
				"Conflagration",
				"625",
				"12 / 11 / 10 / 9 / 8",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 105 / 140 / 175 / 210 (+ 55% AP)" },
				new String[] {
						"ACTIVE: Brand blasts target opponent with fire, dealing magic damage.",
						"If the target is  ablaze, Conflagration will also spread to enemies within 300-range of the target." });
		brandSpells[4] = new SpellInfo(
				"Pyroclasm",
				"750",
				"105 / 90 / 75",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 50% AP)",
						"MAX MAGIC DAMAGE TO SAME TARGET: 450 / 750 / 1050 (+ 150% AP)",
						"MAX MAGIC DAMAGE: 750 / 1250 / 1750 (+ 250% AP)" },
				new String[] {
						"ACTIVE: Brand unleashes a devastating torrent of fire to a target that will bounce between enemies, dealing magic damage each time it bounces. It will bounce up to four times for a total of five hits, and can hit the same enemy up to three times.",
						"If a target is  ablaze, Pyroclasm's next bounce will prioritize champions." });
		champSpells[9] = brandSpells;

		SpellInfo[] caitlynSpells = new SpellInfo[5];
		caitlynSpells[0] = new SpellInfo(
				"Headshot",
				"",
				"",
				"",
				arrS,
				new String[] { "Caitlyn's basic attacks generate 1 stack of Headshot. At 7 / 6 / 5 stacks, her next basic attack will deal bonus physical damage equal to 50% of her attack damage. The bonus damage is tripled against minions and monsters. Attacks from brush will grant 2 stacks of Headshot. Attacks against towers will not grant any stacks." });
		caitlynSpells[1] = new SpellInfo(
				"Piltover Peacemaker",
				"1300",
				"10 / 9 / 8 / 7 / 6",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "PHYSICAL DAMAGE: 20 / 60 / 100 / 140 / 180 (+ 130% AD)",
						"MINIMUM DAMAGE: 10 / 30 / 50 / 70 / 90 (+ 65% AD)" },
				new String[] { "ACTIVE: After a 1 second casting time, Caitlyn fires a projectile that deals physical damage to all targets it passes through. Each target hit after the first takes 10% less damage, down to a minimum of 50% of the original damage." });
		caitlynSpells[2] = new SpellInfo(
				"Yordle Snap Trap",
				"800",
				"20 / 17 / 14 / 11 / 8",
				"50 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Caitlyn sets a trap at target location that arms after a brief delay. Enemy champions who come within 67.5 range of the trap will detonate it, becoming rooted and taking magic damage over 1.5 seconds. The trap also grants true sight of the target for 9 seconds.",
						"Caitlyn can set up to 3 traps and each lasts 4 minutes. Traps are visible to both allies and enemies. If she sets a trap when three are already placed, the oldest trap will deactivate itself." });
		caitlynSpells[3] = new SpellInfo(
				"90 Caliber Net",
				"1000",
				"18 / 16 / 14 / 12 / 10",
				"75 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 80% AP)",
						"SLOW DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "ACTIVE: Caitlyn fires a net, knocking herself back 400 units in the opposite direction. The net will deal magic damage and slow the first enemy hit by 50%." });
		caitlynSpells[4] = new SpellInfo(
				"Ace in the Hole",
				"2000 / 2500 / 3000",
				"90 / 75 / 60",
				"100 MANA",
				new String[] { "PHYSICAL DAMAGE: 250 / 475 / 700 (+ 200% bonus AD)" },
				new String[] { "ACTIVE: After a brief delay, Caitlyn locks onto a target enemy champion and channels for 1 second. While channeling, Caitlyn gains true sight of the target. If Caitlyn completes the channel, she will fire a 3200-speed homing projectile toward the target that deals physical damage to the first enemy champion it hits." });
		champSpells[10] = caitlynSpells;

		SpellInfo[] cassiopeiaSpells = new SpellInfo[5];
		cassiopeiaSpells[0] = new SpellInfo(
				"Deadly Cadence",
				"",
				"",
				"",
				arrS,
				new String[] { "Casting a spell causes any subsequent spellcasts within 5 seconds to cost 10% less mana, stacking up to 5 times." });
		cassiopeiaSpells[1] = new SpellInfo(
				"Noxious Blast",
				"850",
				"3",
				"35 / 45 / 55 / 65 / 75 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 25 / 38 / 52 / 65 / 78 (+ 27% AP)",
						"TOTAL MAGIC DAMAGE: 75 / 115 / 155 / 195 / 235 (+ 80% AP)",
						"MOVEMENT SPEED: 15 / 17.5 / 20 / 22.5 / 25%" },
				new String[] {
						"ACTIVE: Cassiopeia hurls poison at the cursor's location, which strikes after a 0.6 second delay. All enemies within the 75-radius area are poisoned, taking magic damage over 3 seconds.",
						"Cassiopeia gains a movement speed boost for 3 seconds if Noxious Blast damages a champion." });
		cassiopeiaSpells[2] = new SpellInfo(
				"Miasma",
				"850",
				"9",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 25 / 35 / 45 / 55 / 65 (+ 15% AP)",
						"MAX MAGIC DAMAGE: 225 / 315 / 405 / 495 / 585 (+ 135% AP)", "SLOW: 15 / 20 / 25 / 30 / 35%" },
				new String[] { "ACTIVE: Cassiopeia throws a growing cloud of poison to a target location, granting sight of the area and growing from a radius of 125 to 250 over 7 seconds. Enemies in the area are poisoned, becoming slowed and taking magic damage per second for 2 seconds. Continual exposure renews the poison." });
		cassiopeiaSpells[3] = new SpellInfo(
				"Twin Fang",
				"700",
				"5",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 50 / 85 / 120 / 155 / 190 (+ 55% AP)" },
				new String[] { "ACTIVE: Cassiopeia fires fangs at an enemy, dealing magic damage. If her target is poisoned, Twin Fang's cooldown is reduced to 0.5 seconds." });
		cassiopeiaSpells[4] = new SpellInfo(
				"Petrifying Gaze",
				"850",
				"130 / 120 / 110",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 200 / 325 / 450 (+ 60% AP)" },
				new String[] { "ACTIVE: After a brief delay, Cassiopeia blasts all enemies in a 80º cone in front of her with her gaze, dealing magic damage to them. Enemies facing her when damaged are stunned for 2 seconds, while enemies facing away are slowed by 60% for 2 seconds instead." });
		champSpells[11] = cassiopeiaSpells;

		SpellInfo[] chogathSpells = new SpellInfo[5];
		chogathSpells[0] = new SpellInfo(
				"Carnivore",
				"",
				"",
				"",
				arrS,
				new String[] { "Whenever Cho'Gath kills a unit, he recovers 17 + (3 × level) health and 3.25 + (0.25 × level) mana." });
		chogathSpells[1] = new SpellInfo(
				"Rupture",
				"950",
				"9",
				"90 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 135 / 190 / 245 / 305 (+ 100% AP)" },
				new String[] { "ACTIVE: Cho'Gath stomps his foot, causing the ground to tremble at the target location for 0.625 seconds. Afterwards, spikes erupt from the ground knocking up all enemies in a 175-radius area for 1 seconds and dealing magic damage. Targets hit are slowed by 60% for 1.5 seconds after landing." });
		chogathSpells[2] = new SpellInfo(
				"Feral Scream",
				"700",
				"13",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 125 / 175 / 225 / 275 (+ 70% AP)",
						"SILENCE: 1.5 / 1.75 / 2 / 2.25 / 2.5" },
				new String[] { "ACTIVE: Cho'Gath roars, dealing magic damage and silencing all enemies in a 60º cone area in front of him." });
		chogathSpells[3] = new SpellInfo(
				"Vorpal Spikes",
				"500",
				"",
				"",
				new String[] { "MAGIC DAMAGE: 20 / 35 / 50 / 65 / 80 (+ 30% AP)" },
				new String[] { "TOGGLE - ON: Whenever Cho'Gath performs a basic attack, he will launch spikes dealing magic damage to enemies in a line in front of him." });
		chogathSpells[4] = new SpellInfo(
				"Feast",
				"150",
				"60",
				"100 MANA",
				new String[] { "TRUE DAMAGE: 300 / 475 / 650 (+ 70% AP)", "HEALTH PER STACK: 90 / 120 / 150",
						"MAX HEALTH INCREASE: 540 / 720 / 900", "ATTACK RANGE PER STACK: 3.8 / 6.1 / 8.3",
						"TOTAL BONUS RANGE: 23 / 37 / 50" },
				new String[] {
						"ACTIVE: Cho'gath devours target enemy, dealing true damage. If Feast kills the target, Cho'Gath grows larger and gains extra health and basic attack range, stacking up to six times. Cho'Gath loses half of these stacks, rounded up (Lost stacks being rounded up, thus, kept stacks rounded down), whenever he dies.",
						"Feast deals 1000 (+ 70% AP) true damage to minions and monsters." });
		champSpells[12] = chogathSpells;

		SpellInfo[] corkiSpells = new SpellInfo[5];
		corkiSpells[0] = new SpellInfo(
				"Hextech Shrapnel Shells",
				"",
				"",
				"",
				arrS,
				new String[] { "Corki's basic attacks deal additional true damage equal to 10% of his attack damage. This bonus damage is not affected by critical hits, nor can it damage structures." });
		corkiSpells[1] = new SpellInfo(
				"Phosphorus Bomb",
				"825",
				"8",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+50% bonus AD) (+ 50% AP)" },
				new String[] { "ACTIVE: Corki launches a bomb at a target 250-radius area, granting sight of the location as it travels and for 6 seconds afterward. Enemies within the area take magic damage and Corki gains sight of them for 6 seconds." });
		corkiSpells[2] = new SpellInfo(
				"Valkyrie",
				"800",
				"26 / 23 / 20 / 17 / 14",
				"50 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 60 / 90 / 120 / 150 / 180 (+ 40% AP)",
						"MAX DAMAGE: 150 / 225 / 300 / 375 / 450 (+ 100% AP)" },
				new String[] { "ACTIVE: Corki flies to a target location at 650 speed, dropping bombs that leave up to 3 blazing patches along his path, depending on his distance traveled. The fire lasts for 2 seconds, dealing magic damage to enemies that remain in the area every 0.5 seconds, for a maximum of 5 ticks of damage." });
		corkiSpells[3] = new SpellInfo(
				"Gatling Gun",
				"600",
				"16",
				"50 MANA",
				new String[] { "PHYSICAL DAMAGE PER SECOND: 20 / 32 / 44 / 56 / 68 (+ 40% bonus AD)",
						"MAX DAMAGE: 80 / 128 / 176 / 224 / 272 (+ 160% bonus AD)",
						"ARMOR REDUCTION PER SECOND: 2 / 4 / 6 / 8 / 10", "MAX REDUCTION: 8 / 16 / 24 / 32 / 40" },
				new String[] {
						"ACTIVE: Corki activates his gatling gun, spraying bullets in a 35° cone in front of him for 4 seconds. Enemies inside the cone take physical damage and have their armor reduced by a stacking amount every 0.5 seconds they remain in the gunfire.",
						"Gatling Gun does not hinder Corki's actions, and its cone will remain in front of him as he moves." });
		corkiSpells[4] = new SpellInfo(
				"Missile Barrage",
				"1225",
				"2",
				"20 MANA",
				new String[] {
						"MAGIC DAMAGE: 100 / 180 / 260 (+ 30% AP) (+ 20 / 30 / 40% AD) MISSILE RELOAD TIME: 12 / 10 / 8",
						"BIG ONE MAGIC DAMAGE: 150 / 270 / 390 (+ 45% AP) (+ 30 / 45 / 60% AD)" },
				new String[] {
						"ACTIVE: Corki fires a missile in a line that explodes if it hits an enemy, dealing magic damage to all enemies within 75 range.",
						"Corki reloads a missile every few seconds, up to a maximum of 7 stored at once; this reload time is affected by cooldown reduction. Upon death, Corki will respawn with 4 missiles.",
						"BIG ONE: Every third missile Corki fires becomes a Big One, dealing 50% additional damage and doubling its explosion range to 150." });
		champSpells[13] = corkiSpells;

		SpellInfo[] dariusSpells = new SpellInfo[5];
		dariusSpells[0] = new SpellInfo(
				"Hemorrhage",
				"",
				"",
				"",
				arrS,
				new String[] {
						"Darius' basic attacks and damaging abilities cause enemies to bleed for 12 / 15 / 18 / 21 / 24 / 27 / 30 / 33 / 36 (9 + 3 at each level) (+ 30% bonus AD) magic damage over 5 seconds. This stacks up to 5 times for a maximum of 60 / 75 / 90 / 105 / 120 / 135 / 150 / 165 / 180 (45 + 15 at each level) (+ 150% bonus AD) magic damage over the duration.",
						"Darius gains 5% movement speed for each bleeding enemy champion." });
		dariusSpells[1] = new SpellInfo(
				"Decimate",
				"425",
				"9 / 8 / 7 / 6 / 5",
				"40 MANA",
				new String[] { "SHAFT PHYSICAL DAMAGE: 70 / 105 / 140 / 175 / 210 (+ 70% bonus AD)",
						"BLADE PHYSICAL DAMAGE: 105 / 157.5 / 210 / 262.5 / 315 (+ 105% bonus AD)" },
				new String[] {
						"ACTIVE: Darius swings his axe, dealing physical damage to all enemies within a 425-radius area around him.",
						"Champions more than 270 units away from him are hit by his axe's blade, and will take 50% additional damage." });
		dariusSpells[2] = new SpellInfo(
				"Crippling Strike",
				"145",
				"8",
				"30 / 35 / 40 / 45 / 50 MANA",
				new String[] { "BONUS PHYSICAL DAMAGE: 20 / 40 / 60 / 80 / 100% AD", "SLOW: 20 / 25 / 30 / 35 / 40%" },
				new String[] {
						"ACTIVE: Darius' next basic attack deals bonus physical damage and slows the target's movement and attack speed for 2 seconds.",
						"Crippling Strike's cooldown is reduced by 1 second for each stack of  Hemorrhage on the target." });
		dariusSpells[3] = new SpellInfo("Apprehend", "540", "24 / 21 / 18 / 15 / 12", "45 MANA",
				new String[] { "ARMOR PENETRATION: 5 / 10 / 15 / 20 / 25%" }, new String[] {
						"PASSIVE: Darius gains armor penetration.",
						"ACTIVE: After a brief delay, Darius pulls in all enemies in front of him." });
		dariusSpells[4] = new SpellInfo(
				"Noxian Guillotine",
				"460",
				"120 / 100 / 80",
				"100 MANA",
				new String[] { "TRUE DAMAGE: 160 / 250 / 340 (+ 75% bonus AD)",
						"MAX TRUE DAMAGE: 320 / 500 / 680 (+ 150% bonus AD)" },
				new String[] {
						"ACTIVE: Darius leaps to an enemy champion and strikes a devastating blow, dealing true damage.",
						"For each stack of  Hemorrhage on the target, Noxian Guillotine deals an additional 20% damage.",
						"When Noxian Guillotine kills the target, it can be recast within the next 20 seconds. This can occur multiple times in succession." });
		champSpells[14] = dariusSpells;

		SpellInfo[] dianaSpells = new SpellInfo[5];
		dianaSpells[0] = new SpellInfo(
				"Moonsilver Blade",
				"",
				"",
				"",
				arrS,
				new String[] {
						"Every 3rd attack cleaves nearby enemies for 20 / 25 / 30 / 35 / 40 / 50 / 60 / 70 / 80 / 90 / 105 / 120 / 135 / 155 / 175 / 200 / 225 / 250 (15 + 5 / 10 / 15 / 20 / 25 at each level) (+ 80% AP) magic damage. The counter will reset if Diana hasn't attacked for 3.5 seconds.",
						"In addition, Diana permanently has 20% bonus attack speed." });
		dianaSpells[1] = new SpellInfo(
				"Crescent Strike",
				"830",
				"10 / 9 / 8 / 7 / 6",
				"55 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 70% AP)" },
				new String[] { "ACTIVE: Diana unleashes a bolt of lunar energy that travels in an arc. Enemies struck take magic damage and are afflicted with Moonlight, granting sight of them for 3 seconds." });
		dianaSpells[2] = new SpellInfo(
				"Pale Cascade",
				"200",
				"10",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "MAGIC DAMAGE PER ORB: 22 / 34 / 46 / 58 / 70 (+ 20% AP)",
						"MAX MAGIC DAMAGE: 66 / 102 / 138 / 174 / 210 (+ 60% AP)",
						"SHIELD STRENGTH: 40 / 55 / 70 / 85 / 100 (+ 30% AP)",
						"MAX SHIELD STRENGTH: 80 / 110 / 140 / 170 / 200 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Diana gains a temporary shield for 5 seconds that absorbs incoming damage. She also creates three spheres that orbit her for up to 5 seconds. The spheres detonate on contact with an enemy unit, dealing magic damage to all nearby enemies.",
						"If all three spheres detonate, the shield is reapplied and the duration is refreshed. This second shield stacks with the original shield." });
		dianaSpells[3] = new SpellInfo(
				"Moonfall",
				"250",
				"26 / 24 / 22 / 20 / 18",
				"70 MANA",
				new String[] { "SLOW: 35 / 40 / 45 / 50 / 55%" },
				new String[] { "ACTIVE: Diana draws in all nearby enemies to her location, slowing them for 2 seconds afterwards." });
		dianaSpells[4] = new SpellInfo(
				"Lunar Rush",
				"825",
				"25 / 20 / 15",
				"50 / 65 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 100 / 160 / 220 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Diana becomes the living embodiment of the vengeful moon, rushing at an enemy and dealing magic damage to it.",
						"When used to teleport to an enemy afflicted with  Moonlight, Lunar Rush's cooldown is refreshed and the Moonlight debuff is consumed. All other enemies will have the Moonlight debuff removed regardless of whether they were the target of Lunar Rush." });
		champSpells[15] = dianaSpells;

		SpellInfo[] drmundoSpells = new SpellInfo[5];
		drmundoSpells[0] = new SpellInfo("Adrenaline Rush", "", "", "", arrS,
				new String[] { "Dr. Mundo regains 0.3% of his maximum health each second." });
		drmundoSpells[1] = new SpellInfo(
				"Infected Cleaver",
				"1000",
				"4",
				"50 / 60 / 70 / 80 / 90 HEALTH",
				new String[] { "MAGIC DAMAGE: 15 / 18 / 21 / 23 / 25% of target's current health",
						"MINIMUM DAMAGE: 80 / 130 / 180 / 230 / 280",
						"MAX DAMAGE VERSUS MONSTERS: 300 / 400 / 500 / 600 / 700" },
				new String[] { "ACTIVE: Dr. Mundo hurls his cleaver in a line. The first enemy it hits takes magic damage equal to a percentage of its current health and is slowed by 40% for 2 seconds. In addition, Dr. Mundo is healed for an amount equal to half the health cost. Infected Cleaver has a minimum damage threshold, and a maximum damage cap versus monsters and minions." });
		drmundoSpells[2] = new SpellInfo(
				"Burning Agony",
				"162.5",
				"4",
				"COST: 10 / 15 / 20 / 25 / 30 HEALTH PER SECOND",
				new String[] { "MAGIC DAMAGE PER SECOND: 35 / 50 / 65 / 80 / 95 (+ 20% AP)",
						"CROWD CONTROL REDUCTION: 10 / 15 / 20 / 25 / 30%" },
				new String[] { "TOGGLE: While active, Dr. Mundo deals magic damage each second to nearby enemies and reduces the duration of crowd control effects on himself." });
		drmundoSpells[3] = new SpellInfo(
				"Masochism",
				"",
				"7",
				"25 / 35 / 45 / 55 / 65 HEALTH",
				new String[] { "ATTACK DAMAGE: 40 / 55 / 70 / 85 / 100 + 0.4 / 0.55 / 0.7 / 0.85 / 1 per 1% of missing health" },
				new String[] { "ACTIVE: For 5 seconds, Dr. Mundo gains bonus attack damage plus additional attack damage for every 1% of his missing health." });
		drmundoSpells[4] = new SpellInfo(
				"Sadism",
				"",
				"75",
				"20% OF CURRENT HEALTH",
				new String[] { "HEAL: 40 / 50 / 60% of maximum health", "MOVEMENT SPEED: 15 / 25 / 35%" },
				new String[] { "ACTIVE: Dr. Mundo regenerates a percentage of his maximum health over a period of 12 seconds. During this time his movement speed is increased." });
		champSpells[16] = drmundoSpells;

		SpellInfo[] dravenSpells = new SpellInfo[5];
		dravenSpells[0] = new SpellInfo(
				"League of Draven",
				"",
				"",
				"",
				arrS,
				new String[] { "When Draven catches a  Spinning Axe, or kills a minion or monster, he gains one stack of Adoration. When Draven kills an enemy champion, he consumes all of his Adoration stacks and gains 50 + (2 × per stack consumed) gold. Draven loses half of his Adoration stacks upon death." });
		dravenSpells[1] = new SpellInfo(
				"Spinning Axe",
				"",
				"12 / 11 / 10 / 9 / 8",
				"COST: 45 MANA",
				new String[] { "BONUS PHYSICAL DAMAGE: 45 / 55 / 65 / 75 / 85% AD" },
				new String[] {
						"ACTIVE: Draven starts spinning his axe, making his next attack within 6 seconds deal bonus physical damage equal to a percentage of his total attack damage.",
						"This axe will ricochet off the target high up into the air, landing 2 seconds later at a location determined by Draven's current movement direction and speed. If Draven catches it, Spinning Axe will be applied to his next attack and he gains a stack of  Adoration.",
						"Draven can hold up to two Spinning Axes spinning at once." });
		dravenSpells[2] = new SpellInfo(
				"Blood Rush",
				"",
				"12",
				"40 MANA",
				new String[] { "MOVEMENT SPEED: 40 / 45 / 50 / 55 / 60%", "ATTACK SPEED: 20 / 25 / 30 / 35 / 40%" },
				new String[] {
						"ACTIVE: Draven gains increased movement speed for 1.5 seconds and increased attack speed for 3 seconds. The movement speed bonus decreases rapidly over its duration.",
						"Catching a  Spinning Axe will refresh Blood Rush's cooldown." });
		dravenSpells[3] = new SpellInfo(
				"Stand Aside",
				"1050",
				"18 / 17 / 16 / 15 / 14",
				"70 MANA",
				new String[] { "PHYSICAL DAMAGE: 70 / 105 / 140 / 175 / 210 (+ 50% bonus AD)",
						"SLOW: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Draven throws his axes in a line. Enemies hit take physical damage, are knocked aside, and are slowed for 2 seconds afterwards." });
		dravenSpells[4] = new SpellInfo(
				"Whirling Death",
				"Global",
				"110 / 100 / 90",
				"120 MANA",
				new String[] { "PHYSICAL DAMAGE (ONE HIT): 175 / 275 / 375 (+ 110% bonus AD)",
						"MAXIMUM PHYSICAL DAMAGE (TWO HITS): 350 / 550 / 750 (+ 220% bonus AD)",
						"MINIMUM PHYSICAL DAMAGE (ONE HIT): 70 / 110 / 150 (+ 44% bonus AD)",
						"MINIMUM PHYSICAL DAMAGE (TWO HITS): 140 / 220 / 300 (+ 88% bonus AD)" },
				new String[] {
						"ACTIVE: Draven hurls two massive axes in a given direction, dealing physical damage to every enemy struck. Upon reaching the edge of the map, striking an enemy champion or upon the reactivation of Whirling Death, the axes will slowly come to a stop before changing direction and returning to Draven, dealing the same damage to every enemy struck on the way back. ",
						"Whirling Death deals 8% less damage for each unit hit, down to a minimum of 40%. The damage reduction resets when the axes reverse direction." });
		champSpells[17] = dravenSpells;

		SpellInfo[] eliseSpells = new SpellInfo[8];
		eliseSpells[0] = new SpellInfo(
				"Spider Swarm",
				"",
				"",
				"",
				arrS,
				new String[] { "When Elise's Human Form spells hit an enemy, she readies a Spiderling. While Elise is in Spider Form, she summons Spiderlings to attack nearby foes. The maximum number of Spiderlings increases with the level of  Spider Form." });
		eliseSpells[1] = new SpellInfo(
				"Neurotoxin",
				"625",
				"6",
				"COST: 80 / 85 / 90 / 95 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 40 / 75 / 110 / 145 / 180",
						"MAX DAMAGE VS. MONSTERS: 50 / 75 / 100 / 125 / 150" },
				new String[] { "ACTIVE: Launches a blast of corrosive poison at target enemy, dealing magic damage equal to a base amount plus 8% (+3% per 100 AP) of target's current health. Damage is capped against monsters." });
		eliseSpells[2] = new SpellInfo(
				"Venomous Bite",
				"475",
				"6",
				"",
				new String[] { "MAGIC DAMAGE: 60 / 100 / 140 / 180 / 220",
						"MAX DAMAGE VS. MONSTERS: 50 / 75 / 100 / 125 / 150" },
				new String[] { "ACTIVE: Lunges at a target enemy with a poisonous bite, dealing magic damage equal to a base amount plus 8% (+3% per 100 AP) of target's missing health. Damage is capped against monsters." });
		eliseSpells[3] = new SpellInfo(
				"Volatile Spiderling",
				"950",
				"12",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 125 / 175 / 225 / 275 (+ 80% AP)" },
				new String[] { "ACTIVE: Summons a venom-gorged Spiderling that moves to the target location and explodes, dealing magic damage to nearby enemies when it nears an enemy unit or after 3 seconds. If the Spiderling does not hit an enemy before reaching the target location it will re-target itself and chase down a nearby enemy, prioritizing champions. The Spiderling's movement speed increases as it gets closer to its target." });
		eliseSpells[4] = new SpellInfo(
				"Skittering Frenzy",
				"",
				"12",
				"",
				new String[] { "SPIDERLING ATTACK SPEED: 5 / 10 / 15 / 20 / 25%",
						"ATTACK SPEED: 60 / 80 / 100 / 120 / 140%" },
				new String[] {
						"PASSIVE:  Spiderlings gain bonus attack speed.",
						"ACTIVE: Increases the attack speed of Elise and her  Spiderlings for 3 seconds. While active, Elise heals 4 (+4% AP) health when she or her spiderlings attack." });
		eliseSpells[5] = new SpellInfo("Cocoon", "1075", "14 / 13 / 12 / 11 / 10", "50 MANA",
				new String[] { "STUN DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "ACTIVE: Elise fires a web in a line that stuns the first enemy hit." });
		eliseSpells[6] = new SpellInfo(
				"Rappel",
				"1075",
				"26 / 23 / 20 / 17 / 14",
				"",
				arrS,
				new String[] {
						"ACTIVE (ON ENEMY CAST): Elise and her  Spiderlings lift up into the air, becoming untargetable for 1 second and revealing nearby enemy targets for the duration. She then descends upon the target enemy.",
						"ACTIVE (ON GROUND CAST): Elise and her  Spiderlings lift up into the air, becoming untargetable for up to 2 seconds. During that time she can cast Rappel again to descend upon a targeted enemy. If no enemy is targeted within 2 seconds, she will descend at her original location." });
		eliseSpells[7] = new SpellInfo(
				"Spider Form / Human Form",
				"",
				"4",
				"",
				new String[] { "ON-HIT MAGIC DAMAGE: 10 / 20 / 30 / 40 (+ 30% AP)" },
				new String[] {
						"TOGGLE: Elise transforms into a menacing spider, summoning her readied  Spiderlings and granting access to arachnid abilities. While in Spider Form, Elise becomes melee and loses 425 range, deals bonus magic damage with her autoattacks and gains 10 movement speed.",
						"Elise begins with one rank in Spider Form / Human Form and can increase it at levels 6, 11, and 16." });
		champSpells[18] = eliseSpells;

		SpellInfo[] evelynnSpells = new SpellInfo[5];
		evelynnSpells[0] = new SpellInfo(
				"Shadow Walk",
				"700",
				"",
				"",
				arrS,
				new String[] {
						"PASSIVE: When out of combat for 6 seconds, Evelynn enters stealth only being able to be seen by enemy champions within 700 range or true sight. While stealthed, Evelynn regenerates 1% of her maximum mana every second and ignores unit collision.",
						"Casting spells, taking damage or dealing damage reveals Evelynn for 6 seconds." });
		evelynnSpells[1] = new SpellInfo(
				"Hate Spike",
				"500",
				"1.5",
				"16 / 22 / 28 / 34 / 40 MANA",
				new String[] { "MAGIC DAMAGE: 40 / 60 / 80 / 100 / 120 (+ 45% AP) (+ 50% Bonus AD)" },
				new String[] { "ACTIVE: Evelynn fires a line of spikes through a nearby enemy, dealing magic damage to all enemy units in its path." });
		evelynnSpells[2] = new SpellInfo(
				"Dark Frenzy",
				"",
				"15",
				"NO COST",
				new String[] { "FLAT MOVEMENT SPEED PER STACK: 4 / 8 / 12 / 16 / 20",
						"MOVEMENT SPEED: 30 / 40 / 50 / 60 / 70%" },
				new String[] {
						"PASSIVE: Evelynn's spell hits on enemy champions grant her a flat movement speed bonus for 3 seconds. This effect stacks up to 4 times.",
						"ACTIVE: Evelynn removes all slows affecting her, gains increased movement speed for 3 seconds and ignores unit collision. Champion kills and assists refresh Dark Frenzy's cooldown." });
		evelynnSpells[3] = new SpellInfo(
				"Ravage",
				"225",
				"9",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "PHYSICAL DAMAGE PER HIT: 35 / 55 / 75 / 95 / 115 (+ 50% AP) (+ 50% bonus AD)",
						"TOTAL PHYSICAL DAMAGE: 70 / 110 / 150 / 190 / 230 (+ 100% AP) (+ 100% bonus AD)",
						"ATTACK SPEED: 60 / 75 / 90 / 105 / 120%" },
				new String[] { "ACTIVE: Evelynn slashes a target twice, dealing physical damage with each strike. Evelynn then gains bonus attack speed for 3 seconds." });
		evelynnSpells[4] = new SpellInfo(
				"Agony's Embrace",
				"650",
				"150 / 120 / 90",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 15 / 20 / 25% (+ 1% per 100 AP) of enemies' current health",
						"SLOW: 30 / 50 / 70%", "SHIELD STRENGTH PER CHAMPION HIT: 150 / 225 / 300",
						"MAX SHIELD STRENGTH: 750 / 1125 / 1500" },
				new String[] {
						"ACTIVE: Evelynn impales all enemy units in target 250-radius area, dealing magic damage equal to a percentage of their current health and slowing their movement speed for 2 seconds.",
						"Evelynn siphons their pain, gaining a shield that grows in strength for each enemy champion hit and lasts up to 6 seconds." });
		champSpells[19] = evelynnSpells;

		SpellInfo[] ezrealSpells = new SpellInfo[5];
		ezrealSpells[0] = new SpellInfo(
				"Rising Spell Force",
				"",
				"",
				"",
				arrS,
				new String[] { "INNATE: Hitting a target with any of Ezreal's abilities increases his own attack speed by 10%. This effect lasts for 5 seconds and stacks up to 5 times." });
		ezrealSpells[1] = new SpellInfo(
				"Mystic Shot",
				"1150",
				"6 / 5.5 / 5 / 4.5 / 4",
				"28 / 31 / 34 / 37 / 40 MANA",
				new String[] { "PHYSICAL DAMAGE: 35 / 55 / 75 / 95 / 115 (+ 100% AD) (+ 40% AP)",
						"PROJECTILE SPEED: 2000" },
				new String[] { "ACTIVE: Ezreal fires a bolt of energy in a line that will deal physical damage and apply on-hit effects to the first enemy it hits. If it strikes an enemy unit, all of Ezreal's cooldowns will be reduced by 1 second." });
		ezrealSpells[2] = new SpellInfo(
				"Essence Flux",
				"1000",
				"9",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 80% AP)",
						"ATTACK SPEED: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Ezreal fires a wave of energy in a line. Any enemy champions it passes through are dealt magic damage, while any allied champions it travels through have their attack speed increased for 5 seconds." });
		ezrealSpells[3] = new SpellInfo(
				"Arcane Shift",
				"475",
				"19 / 17 / 15 / 13 / 11",
				"90 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 125 / 175 / 225 / 275 (+ 75% AP)" },
				new String[] { "ACTIVE: Ezreal instantly teleports to a nearby target location and fires a homing arrow at the nearest enemy unit within 750 range, dealing magic damage to it." });
		ezrealSpells[4] = new SpellInfo(
				"Trueshot Barrage",
				"Global",
				"80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 350 / 500 / 650 (+ 100% Bonus AD) (+ 90% AP)",
						"MINIMUM MAGIC DAMAGE: 105 / 150 / 195 (+ 30% Bonus AD) (+ 27% AP)", "PROJECTILE SPEED: 2000" },
				new String[] { "ACTIVE: After gathering energy for 1 second, Ezreal fires a powerful, broad energy missile that travels in a line across the whole map dealing magic damage to each enemy unit it passes through. It will deal 10% less damage for each subsequent target hit, down to a minimum of 30% damage dealt." });
		champSpells[20] = ezrealSpells;

		SpellInfo[] fiddlesticksSpells = new SpellInfo[5];
		fiddlesticksSpells[0] = new SpellInfo(
				"Dread",
				"",
				"",
				"",
				arrS,
				new String[] { "Enemy units within 1000 range have their magic resistance reduced by 10 when Fiddlesticks is visible to them." });
		fiddlesticksSpells[1] = new SpellInfo(
				"Terrify",
				"575",
				"15 / 14 / 13 / 12 / 11",
				"65 MANA",
				new String[] { "DURATION: 1.25 / 1.5 / 1.75 / 2 / 2.25" },
				new String[] { "ACTIVE: Fiddlesticks terrifies the target enemy unit, causing it to turn and flee for a short duration." });
		fiddlesticksSpells[2] = new SpellInfo(
				"Drain",
				"575",
				"10 / 9 / 8 / 7 / 6",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 60 / 90 / 120 / 150 / 180 (+ 45% AP)",
						"MAX MAGIC DAMAGE: 300 / 450 / 600 / 750 / 900 (+ 225% AP)",
						"HEAL FROM DAMAGE RATIO: 60 / 65 / 70 / 75 / 80%" },
				new String[] { "ACTIVE: Fiddlesticks creates a leash on a target enemy and channels for up to 5 seconds, dealing magic damage each second and healing himself for a percentage of the damage done. If the target moves further than 750 range of Fiddlesticks while leashed, he will stop channeling." });
		fiddlesticksSpells[3] = new SpellInfo(
				"Dark Wind",
				"750",
				"15 / 14 / 13 / 12 / 11",
				"50 / 70 / 90 / 110 / 130 MANA",
				new String[] { "MAGIC DAMAGE PER BOUNCE: 65 / 85 / 105 / 125 / 145 (+ 45% AP)",
						"MAX MAGIC DAMAGE TO THE SAME TARGET: 195 / 255 / 315 / 375 / 435 (+ 135% AP)",
						"MAGIC DAMAGE PER BOUNCE TO MINIONS: 97.5 / 127.5 / 157.5 / 187.5 / 217.5 (+ 67.5% AP)",
						"BOUNCE RANGE: 450" },
				new String[] { "ACTIVE: Fiddlesticks throws a crow that bounces to enemy units up to 4 times, dealing magic damage and silencing for 1.2 seconds with each strike. Minions and monsters take 50% increased damage. Dark Wind may strike the same target multiple times." });
		fiddlesticksSpells[4] = new SpellInfo(
				"Crowstorm",
				"800",
				"150 / 140 / 130",
				"100 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 125 / 225 / 325 (+ 45% AP)",
						"TOTAL MAGIC DAMAGE: 625 / 1125 / 1625 (+ 225% AP)" },
				new String[] { "ACTIVE: After channeling for 1.5 seconds, Fiddlesticks teleports to nearby target location with a murder of crows flying wildly around him for 5 seconds, dealing magic damage to all enemy units within 600 range each second." });
		champSpells[21] = fiddlesticksSpells;

		SpellInfo[] fioraSpells = new SpellInfo[5];
		fioraSpells[0] = new SpellInfo(
				"Duelist",
				"",
				"",
				"",
				arrS,
				new String[] { "Fiora regenerates 7 + (Fiora's level) health over 6 seconds each time she deals physical damage. Striking champions will cause this effect to stack up to 4 times." });
		fioraSpells[1] = new SpellInfo(
				"Lunge",
				"600",
				"16 / 14 / 12 / 10 / 8",
				"60 MANA",
				new String[] { "PHYSICAL DAMAGE: 40 / 65 / 90 / 115 / 140 (+ 60% bonus AD)",
						"MAX PHYSICAL DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 120% bonus AD)" },
				new String[] { "ACTIVE: Fiora dashes forward to strike her target, dealing physical damage. Fiora can perform the dash a second time within 4 seconds at no mana cost. Each" });
		fioraSpells[2] = new SpellInfo(
				"Riposte",
				"",
				"10 / 9 / 8 / 7 / 6",
				"45 MANA",
				new String[] { "ATTACK DAMAGE: 15 / 20 / 25 / 30 / 35",
						"MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 100% AP)" },
				new String[] {
						"PASSIVE: Fiora's attack damage is increased.",
						"ACTIVE: Fiora parries the next basic attack within 1.5 seconds and deals magic damage to the attacker. Works against champions, monsters, and large minions." });
		fioraSpells[3] = new SpellInfo(
				"Burst of Speed",
				"",
				"15 / 14 / 13 / 12 / 11",
				"55 MANA",
				new String[] { "ATTACK SPEED: 60 / 75 / 90 / 105 / 120%", "MOVEMENT SPEED: 7 / 9 / 11 / 13 / 15%",
						"MAX MOVEMENT SPEED: 21 / 27 / 33 / 39 / 45%" },
				new String[] {
						"ACTIVE: Fiora gains additional attack speed for 3 seconds. Each basic attack or Lunge she lands during this time increases her movement speed for 3 seconds, stacking up to 3 times. Burst of Speed resets the autoattack timer.",
						"Killing a champion refreshes the cooldown on Burst of Speed. Assists reduce the cooldown by half of the base amount." });
		fioraSpells[4] = new SpellInfo(
				"Blade Waltz",
				"400",
				"130 / 120 / 110",
				"100 MANA",
				new String[] { "PHYSICAL DAMAGE: 160 / 330 / 500 (+ 120% bonus AD)",
						"MAXIMUM SINGLE-TARGET DAMAGE: 320 / 660 / 1000 (+ 240% bonus AD)",
						"MINIMUM SINGLE-TARGET DAMAGE: 200 / 412.5 / 625 (+ 150% bonus AD)" },
				new String[] { "ACTIVE: Fiora dashes around the battlefield-becoming untargetable in the process-dealing physical damage to random enemy champion(s) 5 times. Successive hits against the same target deal 25% damage. The first and last attack will be against the same target. Each strike applies on-hit effects." });
		champSpells[22] = fioraSpells;

		SpellInfo[] fizzSpells = new SpellInfo[6];
		fizzSpells[0] = new SpellInfo(
				"Nimble Fighter",
				"",
				"",
				"",
				arrS,
				new String[] { "Fizz's dexterity allows him to ignore unit collision and take 4 / 6 / 8 / 10 / 12 / 14 reduced physical damage from auto attacks." });
		fizzSpells[1] = new SpellInfo(
				"Urchin Strike",
				"550",
				"10 / 9 / 8 / 7 / 6",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "PHYSICAL DAMAGE: 100% AD", "MAGIC DAMAGE: 10 / 40 / 70 / 100 / 130 (+ 60% AP)" },
				new String[] { "ACTIVE: Fizz dashes a fixed distance in the direction of the target enemy unit, dealing physical damage and magic damage. The physical damage applies on-hit effects and the magic damage applies on-ability effects." });
		fizzSpells[2] = new SpellInfo(
				"Seastone Trident",
				"",
				"10",
				"40 MANA",
				new String[] {
						"TOTAL MAGIC DAMAGE: 30 / 40 / 50 / 60 / 70 (+ 35% AP) (+ 4 / 5 / 6 / 7 / 8% of target's missing health)",
						"MAGIC DAMAGE: 10 / 15 / 20 / 25 / 30 (+ 25% AP)" },
				new String[] {
						"PASSIVE: Fizz's autoattacks rend his target, dealing magic damage over 3 seconds that is increased based on a percentage of the target's missing health.",
						"This effect does not stack and multiple attacks will only refresh the duration. The total damage caps at 300 against minions and monsters (100 damage per second).",
						"ACTIVE: Fizz's autoattacks are empowered for the next 5 seconds, dealing additional magic damage on-hit and applying Grievous Wounds for 3 seconds." });
		fizzSpells[3] = new SpellInfo(
				"Playful",
				"400",
				"16 / 14 / 12 / 10 / 8",
				"90 / 100 / 110 / 120 / 130 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 120 / 170 / 220 / 270 (+ 75% AP)", "SLOW: 40 / 45 / 50 / 55 / 60%" },
				new String[] {
						"ACTIVE: Fizz hops onto his trident in a nearby location, becoming untargetable for 0.75 seconds and gaining the ability to use  Trickster before the effect ends.",
						"If Fizz does not use  Trickster, he will slam the ground below him, dealing magic damage and slowing nearby enemies within 330-range for 2 seconds." });
		fizzSpells[4] = new SpellInfo(
				"Trickster",
				"400",
				"",
				"",
				new String[] { "MAGIC DAMAGE: 70 / 120 / 170 / 220 / 270 (+ 75% AP)" },
				new String[] { "ACTIVE: Fizz hops off from his trident to a nearby location, dealing magic damage to nearby enemies within 270-range. Trickster does not apply a slow." });
		fizzSpells[5] = new SpellInfo(
				"Chum the Waters",
				"1275",
				"100 / 85 / 70",
				"100 MANA",
				new String[] { "SLOW: 50 / 60 / 70% MAGIC DAMAGE: 200 / 325 / 450 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Fizz throws a fish in a line that will bind itself onto the first enemy champion it hits. A Shark will come out from the earth to eat the fish after 1.5 seconds, regardless of position.",
						"f it doesn't hit an enemy champion it will stay on an area, and it will stick to the first enemy champion that walks into the area. The fish will slow and reveal any enemy champion it is attached to.",
						"If a champion has the fish attached to them they are knocked up for 1 second. All other enemies within 250-range are knocked away from the shark. All enemies hit are dealt magic damage and are slowed for 1.5 seconds afterwards." });
		champSpells[23] = fizzSpells;

		SpellInfo[] galioSpells = new SpellInfo[5];
		galioSpells[0] = new SpellInfo("Runic Skin", "", "", "", arrS,
				new String[] { "Galio gains 50% of his total magic resistance as ability power." });
		galioSpells[1] = new SpellInfo(
				"Resolute Smite",
				"940",
				"7",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 135 / 190 / 245 / 300 (+ 60% AP)", "SLOW: 24 / 28 / 32 / 36 / 40%" },
				new String[] { "ACTIVE: Galio fires a concussive blast from his eyes to a target 235-radius area, dealing magic damage and slowing enemies hit for 2.5 seconds." });
		galioSpells[2] = new SpellInfo(
				"Bulwark",
				"800",
				"13",
				"60 MANA",
				new String[] { "ARMOR / MAGIC RESIST: 30 / 45 / 60 / 75 / 90",
						"HEAL: 25 / 40 / 55 / 70 / 85 (+ 30% AP)",
						"MAX HEAL (HITS): 125 / 200 / 275 / 350 / 425 (+ 150% AP)" },
				new String[] { "ACTIVE: Galio shields an allied champion or himself for 4 seconds, increasing their armor and magic resistance. Each time that unit takes damage, Galio is healed. The heal is 20% weaker than the last for each consecutive hit." });
		galioSpells[3] = new SpellInfo(
				"Righteous Gust",
				"1180",
				"12",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 50% AP)",
						"MOVEMENT SPEED: 20 / 28 / 36 / 44 / 52%" },
				new String[] { "ACTIVE: Galio unleashes a gust of magical wind that deals magic damage to all enemies in its path. A directional draft remains for 5 seconds, increasing the movement speed of allies passing through it." });
		galioSpells[4] = new SpellInfo(
				"Idol of Durand",
				"600",
				"150 / 135 / 120",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 220 / 330 / 440 (+ 60% AP)",
						"MAX MAGIC DAMAGE: 308 / 462 / 616 (+ 84% AP)" },
				new String[] {
						"ACTIVE: Galio becomes a statue and channels for 2 seconds, taunting nearby foes and reducing incoming physical and magic damage by 50%.",
						"When the channel ends, Galio bursts out of his statue form, dealing magic damage to enemies within range. The damage is increased by 5% for each attack suffered while channeling (maximum 40%). If the channel is canceled, the damage radius is reduced to 575 instead of normal.",
						"While channeling, Galio can cast Bulwark on himself or on allies." });
		champSpells[24] = galioSpells;

		SpellInfo[] gangplankSpells = new SpellInfo[5];
		gangplankSpells[0] = new SpellInfo(
				"Grog Soaked Blade",
				"",
				"",
				"",
				arrS,
				new String[] { "Gangplank's basic attacks apply a poison debuff for 3 seconds that can stack up to 3 times. Each stack deals 3 + (1 × level) magic damage per second and slows the target by 7%." });
		gangplankSpells[1] = new SpellInfo(
				"Parrrley",
				"625",
				"5",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "50 / 55 / 60 / 65 / 70 MANA", "EXTRA GOLD: 4 / 5 / 6 / 7 / 8" },
				new String[] { "ACTIVE: Gangplank shoots a target enemy with his pistol, dealing physical damage. If it is killed with this ability, he gains extra gold and refunds half the mana cost. This ability can critically strike and applies on-hit effects, including his passive." });
		gangplankSpells[2] = new SpellInfo(
				"Remove Scurvy",
				"",
				"22 / 21 / 20 / 19 / 18",
				"65 MANA",
				new String[] { "HEAL: 80 / 150 / 220 / 290 / 360 (+ 100% AP)" },
				new String[] { "ACTIVE: Gangplank eats a large amount of citrus fruit, instantly removing all crowd control effects on him, as well as healing himself." });
		gangplankSpells[3] = new SpellInfo(
				"Raise Morale",
				"600",
				"20",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "PASSIVE ATTACK DAMAGE BONUS: 8 / 10 / 12 / 14 / 16",
						"PASSIVE MOVEMENT SPEED BONUS: 3 / 4 / 5 / 6 / 7%",
						"ACTIVE SELF ATTACK DAMAGE BONUS: 12 / 19 / 26 / 33 / 40",
						"ACTIVE SELF MOVEMENT SPEED BONUS: 8 / 11 / 14 / 17 / 20%" },
				new String[] {
						"PASSIVE: Gangplank's attack damage and movement speed are increased permanently.",
						"ACTIVE: Gangplank fires into the air, disabling his passive boost but inspiring himself to gain additional attack damage and movement speed, with allied champions within range receiving half that amount, for 7 seconds." });
		gangplankSpells[4] = new SpellInfo(
				"Cannon Barrage",
				"Global",
				"120 / 115 / 110",
				"100 MANA",
				new String[] { "MAGIC DAMAGE PER CANNONBALL: 75 / 120 / 165 (+ 20% AP)" },
				new String[] {
						"ACTIVE: Gangplank signals his ship to fire a cannonball barrage upon a target 600-radius area for 6 seconds, granting vision of the area and slowing enemies inside it by 25%.",
						"25 cannonballs randomly drop over the duration, each one dealing magic damage to enemies within a radius of 150." });
		champSpells[25] = gangplankSpells;

		SpellInfo[] garenSpells = new SpellInfo[5];
		garenSpells[0] = new SpellInfo(
				"Perseverance",
				"",
				"",
				"",
				arrS,
				new String[] { "Garen will regenerate 0.4% of his maximum health every second if he has not been hit with an enemy ability or taken damage from any source (excluding minions) in the last 9 seconds." });
		garenSpells[1] = new SpellInfo(
				"Decisive Strike",
				"",
				"8",
				"",
				new String[] { "BONUS PHYSICAL DAMAGE: 30 / 55 / 80 / 105 / 130 (+ 140% AD)",
						"MOVEMENT SPEED DURATION: 1.5 / 2.25 / 3 / 3.75 / 4.5",
						"SILENCE DURATION: 1.5 / 1.75 / 2 / 2.25 / 2.5" },
				new String[] { "ACTIVE: Garen breaks free from all slows affecting him and gains 35% movement speed for a few seconds. Additionally, his next basic attack within 4.5 seconds will deal additional physical damage and will silence his target." });
		garenSpells[2] = new SpellInfo(
				"Courage",
				"",
				"24 / 23 / 22 / 21 / 20",
				"NO COST",
				new String[] { "DURATION: 2 / 3 / 4 / 5 / 6" },
				new String[] {
						"PASSIVE: Garen's bonus armor and magic resistance are increased by 20%.",
						"ACTIVE: Garen gains a defensive shield for a few seconds, reducing incoming damage by 30% and granting 30% crowd control reduction for the duration." });
		garenSpells[3] = new SpellInfo(
				"Judgment",
				"165",
				"13 / 12 / 11 / 10 / 9",
				"NO COST",
				new String[] {
						"PHYSICAL DAMAGE PER SECOND: 20 / 45 / 70 / 95 / 120 (+ 70 / 80 / 90 / 100 / 110% AD)",
						"TOTAL PHYSICAL DAMAGE: 60 / 135 / 210 / 285 / 360 (+ 210 / 240 / 270 / 300 / 330% AD)",
						"DAMAGE PER SECOND WITH BASE CRIT MODIFIER: 20 / 45 / 70 / 95 / 120 (+ 105 / 120 / 135 / 150 / 165% AD)" },
				new String[] {
						"ACTIVE: Garen rapidly spins his sword around his body for 3 seconds, dealing physical damage each second to enemies within range. Minions take 75% damage from Judgment. Garen ignores unit collision while spinning, but moves 20% slower when traveling through minions. After 0.5 seconds, Garen can reactivate Judgment to cancel it early.",
						"Judgment can critically strike, multiplying the total AD component by (Garen's critical strike damage modifier - 50%)." });
		garenSpells[4] = new SpellInfo(
				"Demacian Justice",
				"400",
				"160 / 120 / 80",
				"NO COST",
				new String[] { "MAGIC DAMAGE: 175 / 350 / 525 (+ 1 additional damage for every 3.5 / 3 / 2.5 of target's missing health)" },
				new String[] { "ACTIVE: Garen calls upon the might of Demacia to attempt to execute an enemy champion, dealing magic damage plus additional damage based on his target's missing health." });
		champSpells[26] = garenSpells;

		SpellInfo[] gragasSpells = new SpellInfo[5];
		gragasSpells[0] = new SpellInfo("Happy Hour", "", "8", "", arrS,
				new String[] { "On ability use, Gragas takes a drink restoring 4% of his max health." });
		gragasSpells[1] = new SpellInfo(
				"Barrel Roll",
				"850",
				"11 / 10 / 9 / 8 / 7",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 60% AP)",
						"MAXIMUM MAGIC DAMAGE: 120 / 180 / 240 / 300 / 360 (+ 90% AP)",
						"SLOW: 30 / 35 / 40 / 45 / 50%", "MAXIMUM SLOW: 45 / 52.5 / 60 / 67.5 / 75%" },
				new String[] { "ACTIVE: Gragas rolls his cask to a location, which can be activated again to explode or will explode on its own after 4 seconds, dealing magic damage to enemies in the area and slowing their movement speed for 2 seconds. The damage and slow increases as the cask ferments, up to 150% after 2 seconds." });
		gragasSpells[2] = new SpellInfo(
				"Drunken Rage",
				"",
				"8 / 7.5 / 7 / 6.5 / 6",
				"NO COST",
				new String[] {
						"DAMAGE REDUCTION: 10 / 12 / 14 / 16 / 18%",
						"BONUS MAGIC DAMAGE: 20 / 50 / 80 / 110 / 140 (+ 30% AP) (+ 8 / 9 / 10 / 11 / 12% of target's maximum health)" },
				new String[] { "ACTIVE: Gragas takes a long swig from his barrel, disabling his ability to cast or attack while slowing himself by 20% for 1 second and gaining damage reduction for 3 seconds. Upon finishing his drink, Gragas' next attack within ~5 seconds will deal bonus magic damage." });
		gragasSpells[3] = new SpellInfo(
				"Body Slam",
				"600",
				"16 / 15 / 14 / 13 / 12",
				"50 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Gragas charges forward, colliding with the first enemy unit. He deals magic damage to enemies in the area and bumps them back, stunning them for 1 second.",
						"Body Slam's cooldown is reduced by 3 seconds if Gragas collides with a unit." });
		gragasSpells[4] = new SpellInfo(
				"Explosive Cask",
				"1050",
				"100 / 90 / 80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 200 / 300 / 400 (+ 70% AP)", "KNOCKBACK DISTANCE: 600" },
				new String[] { "ACTIVE: Gragas throws his cask to a target 400-radius area, dealing magic damage to enemy units in the area and knocking them back, away from the explosion, and briefly giving vision in a 500-radius area." });
		champSpells[27] = gragasSpells;

		SpellInfo[] gravesSpells = new SpellInfo[5];
		gravesSpells[0] = new SpellInfo(
				"True Grit",
				"",
				"",
				"",
				arrS,
				new String[] { "Graves gains 1 / 2 / 3 bonus armor and magic resistance every second he remains in combat. This bonus stacks up to 10 times. Graves is considered in combat if he has dealt or received damage in the last 3 seconds." });
		gravesSpells[1] = new SpellInfo(
				"Buckshot",
				"950",
				"12 / 11 / 10 / 9 / 8",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "PHYSICAL DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 80% bonus AD)",
						"MAX PHYSICAL DAMAGE: 102 / 161.5 / 221 / 280.5 / 340 (+ 136% bonus AD)" },
				new String[] { "ACTIVE: Graves fires three bullets in a cone, dealing physical damage to all enemies in their path. Enemies at close range can be hit by multiple projectiles, but each bullet beyond the first will deal only 35% damage." });
		gravesSpells[2] = new SpellInfo(
				"Smoke Screen",
				"950",
				"20 / 19 / 18 / 17 / 16",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 60% AP)", "SLOW: 15 / 20 / 25 / 30 / 35%" },
				new String[] { "ACTIVE: Graves fires a smoke canister at the target area, dealing magic damage upon landing and creating a cloud of smoke 250 wide for 4 seconds. Enemies inside the smoke cloud will be slowed and will have their vision reduced to 675 range; everything else will look like it is in the Fog of War." });
		gravesSpells[3] = new SpellInfo(
				"Quickdraw",
				"425",
				"22 / 20 / 18 / 16 / 14",
				"40 MANA",
				new String[] { "ATTACK SPEED: 30 / 40 / 50 / 60 / 70%" },
				new String[] { "ACTIVE: Graves dashes forward, gaining an attack speed boost for 4 seconds. Using autoattacks on enemy units, but not structures, lowers the cooldown of Quickdraw by 1 second each autoattack." });
		gravesSpells[4] = new SpellInfo(
				"Collateral Damage",
				"1000",
				"100 / 90 / 80",
				"100 MANA",
				new String[] { "IMPACT PHYSICAL DAMAGE: 250 / 350 / 450 (+ 150% bonus AD)",
						"EXPLOSION PHYSICAL DAMAGE: 200 / 280 / 360 (+ 120% bonus AD)", "CONE RANGE: 800" },
				new String[] { "ACTIVE: Graves fires an explosive shell in a straight line, dealing heavy physical damage to the first champion it hits (also damages non-champion enemies whilst in flight). After hitting a champion or reaching the end of its range, the shell explodes dealing physical damage in a cone behind the target." });
		champSpells[28] = gravesSpells;

		SpellInfo[] hecarimSpells = new SpellInfo[5];
		hecarimSpells[0] = new SpellInfo(
				"Warpath",
				"",
				"",
				"",
				arrS,
				new String[] { "Hecarim ignores unit collision and gains bonus attack damage equal to 10 / 12.5 / 15 / 17.5 / 20 / 22.5 / 25 % of his bonus movement speed." });
		hecarimSpells[1] = new SpellInfo(
				"Rampage",
				"350",
				"4",
				"24 / 28 / 32 / 36 / 40 MANA",
				new String[] { "PHYSICAL DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 60% bonus AD)",
						"MINION / MONSTER DAMAGE: 40 / 63.3 / 86.7 / 110 / 133.3 (+ 40% bonus AD)" },
				new String[] {
						"ACTIVE: Hecarim cleaves nearby enemies, dealing physical damage. This skill deals only 66% damage to minions and monsters.",
						"If Hecarim damages at least one enemy unit with this attack, he gains a stack of Rampage for 8 seconds, reducing the base cooldown of this ability by 1 second. This effect can stack up to 2 times." });
		hecarimSpells[2] = new SpellInfo(
				"Spirit of Dread",
				"525",
				"22 / 21 / 20 / 19 / 18",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 20 / 30 / 40 / 50 / 60 (+ 20% AP)",
						"MAX DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 80% AP)",
						"MINION/MONSTER HEALING CAP: 60 / 90 / 120 / 150 / 180" },
				new String[] { "ACTIVE: Hecarim surrounds himself with the spirit of dread for 4 seconds, dealing magic damage per second to all enemies within its reach. Additionally, Hecarim is healed for 20% of the damage dealt by any source to enemies within the area. Healing from damage dealt to minions or monsters are capped per cast." });
		hecarimSpells[3] = new SpellInfo(
				"Devastating Charge",
				"",
				"24 / 22 / 20 / 18 / 16",
				"60 MANA",
				new String[] { "MINIMUM PHYSICAL DAMAGE: 40 / 75 / 110 / 145 / 180 (+ 50% bonus AD)",
						"MAX PHYSICAL DAMAGE: 80 / 150 / 220 / 290 / 360 (+ 100% bonus AD)" },
				new String[] {
						"ACTIVE: Hecarim gains 75% movement speed over the course of 3 seconds, starting with initial 25% upon cast, and ending one second afterward. While Hecarim is charging, he gains 150 extra attack range (325 total). His next attack knocks the target back, dealing physical damage based on how far Hecarim has traveled during Devastating Charge's duration.",
						"If Hecarim's target is beyond narrow terrain, Hecarim will leap over the terrain to his target." });
		hecarimSpells[4] = new SpellInfo(
				"Onslaught of Shadows",
				"1000",
				"140 / 120 / 100",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Hecarim summons spectral riders and charges forward with them in a line, dealing magic damage to enemies in their path. Enemies within range of where Hecarim stops will flee in terror for 1 second.",
						"The wave of spectral riders will travel the maximum distance possible in the direction of the cast, regardless of where Hecarim himself stops." });
		champSpells[29] = hecarimSpells;

		SpellInfo[] heimerdingerSpells = new SpellInfo[8];
		heimerdingerSpells[0] = new SpellInfo(
				"Techmaturgical Repair Bots",
				"1000",
				"",
				"",
				arrS,
				new String[] {
						"Heimerdinger grants himself, nearby allied  H-28G Evolution Turrets, and nearby allied champions 10 / 15 / 20 / 25 / 30 health regeneration per 5 seconds.",
						"Additionally, the effects of Techmaturgical Repair Bots will remain on allies for 5 seconds after leaving range, even after Heimerdinger's death." });
		heimerdingerSpells[1] = new SpellInfo(
				"H-28G Evolution Turret",
				"450",
				"1",
				"20 MANA + 1 TURRET KIT",
				new String[] { "STORAGE TIME: 24 / 23 / 22 / 21 / 20", "MAX TURRET RESERVE: 1 / 1 / 2 / 2 / 3",
						"ON-HIT MAGIC DAMAGE: 12 / 18 / 23 / 29 / 34 (+ 15% AP)",
						"ON-HIT CHARGE GENERATION: 1 / 2 / 3 / 4 / 5 %",
						"ENERGY BLAST MAGIC DAMAGE: 40 / 60 / 80 / 100 / 120 (+ 55% AP)" },
				new String[] {
						"ACTIVE: Heimerdinger deploys a turret at the target location. Heimerdinger stores enough parts for a new turret every several seconds (affected by cooldown reduction) but can only keep a limited number of turrets in reserve. Up to 3 turrets can be deployed at a time and deploying a fourth turret destroys the oldest one.",
						"Turrets have 525-range basic attacks and a 1100-range laser beam. The laser beam is a pass-through skill shot that fires upon reaching 100% charge. Charge generates passively and the turret's basic attacks will generate additional charge, with a maximum recharge time of 16 seconds. Turrets deactivate if Heimerdinger is more than 1000 units away for longer than 8 seconds." });
		heimerdingerSpells[2] = new SpellInfo(
				"H-28Q Apex Turret",
				"450",
				"",
				"NO COST",
				new String[] { "ON-HIT MAGIC DAMAGE: 70 / 90 / 110 (+ 30% AP)",
						"ENERGY BLAST MAGIC DAMAGE: 180 / 240 / 300 (+ 70% AP)" },
				new String[] { "UPGRADE!!! - ACTIVE: Heimerdinger constructs an Apex Turret that lasts for 8 seconds. The Apex Turret deals modified damage based on the rank in UPGRADE!!!, and its basic attacks deal 100% splash damage, apply a 25% movement speed slow and generate 20% beam charge per hit. The Apex Turret does not count toward Heimerdinger's turret limit, nor does it interact with his turret reserve." });
		heimerdingerSpells[3] = new SpellInfo(
				"Hextech Micro-Rockets",
				"1100",
				"11",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 45% AP)",
						"MAXIMUM DAMAGE TO SINGLE TARGET: 108 / 162 / 216 / 270 / 324 (+ 92% AP)",
						"MAGIC DAMAGE TO MINIONS: 36 / 54 / 72 / 90 / 108 (+ 45% AP)" },
				new String[] {
						"ACTIVE: Heimerdinger unleashes a barrage of 5 rockets that converge on the target location and fan beyond it up to a maximum range, each rocket dealing magic damage to the first enemy it hits.",
						"Enemy champions and neutral monsters that are hit by more than one rocket take 20% magic damage for each rocket beyond the first. Enemy minions take modified damage from each rocket." });
		heimerdingerSpells[4] = new SpellInfo(
				"Hextech Rocket Swarm",
				"1100",
				"",
				"NO COST",
				new String[] { "MAGIC DAMAGE: 135 / 180 / 225 (+ 45% AP)",
						"MAXIMUM DAMAGE TO SINGLE TARGET: 500 / 690 / 865 (+ 183% AP)" },
				new String[] { "UPGRADE!!! - ACTIVE: Heimerdinger launches 4 waves of rockets in quick succession. Upgraded rockets deal modified damage based on the rank in UPGRADE!!!, up to a cap on individual enemies." });
		heimerdingerSpells[5] = new SpellInfo(
				"CH-2 Electron Storm Grenade",
				"925",
				"18 / 16 / 14 / 12 / 10",
				"85 MANA",
				new String[] { "DAMAGE RADIUS: 210", "STUN RADIUS: 135", "MISSILE SPEED: 1200",
						"MAGIC DAMAGE: 60 / 100 / 140 / 180 / 220 (+ 60% AP)" },
				new String[] { "ACTIVE: Heimerdinger hurls a grenade at a targeted location, dealing magic damage and slowing enemies hit by 35% for 2 seconds. Enemies struck directly by the grenade are also stunned for 1.25 seconds." });
		heimerdingerSpells[6] = new SpellInfo(
				"CH-3X Lightning Grenade",
				"925",
				"",
				"NO COST",
				new String[] { "DAMAGE RADIUS: 420", "STUN RADIUS: 270", "MISSILE SPEED: 1200",
						"MAGIC DAMAGE PER BOUNCE: 150 / 200 / 250 (+ 60% AP)", "BOUNCE DISTANCE: 540" },
				new String[] { "UPGRADE!!! - ACTIVE: Heimerdinger hurls a grenade that bounces up to 3 times, discharging on each bounce. Each discharge deals modified damage based on the rank in UPGRADE!!!, the slow is increased to 80% and the area of effect is larger. Enemy champions can only be damaged by the grenade once, but can be slowed and stunned multiple times if circumstances permit." });
		heimerdingerSpells[7] = new SpellInfo("UPGRADE!!!", "", "", "", new String[] { "" }, new String[] { "" });
		champSpells[30] = heimerdingerSpells;

		SpellInfo[] ireliaSpells = new SpellInfo[6];
		ireliaSpells[0] = new SpellInfo(
				"Ionian Fervor",
				"1200",
				"",
				"",
				new String[] { "1 CHAMPION: 10%", "2 CHAMPION: 125%", "3 CHAMPION: 40%" },
				new String[] { "For each nearby enemy champion, Irelia reduces the duration of stuns, slows, taunts, fears, snares, immobilizes, blinds and silences." });
		ireliaSpells[1] = new SpellInfo(
				"Bladesurge",
				"650",
				"14 / 12 / 10 / 8 / 6",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "PHYSICAL DAMAGE: 20 / 50 / 80 / 110 / 140 (+ 100% total AD)" },
				new String[] { "ACTIVE: Irelia dashes forward to strike her target, dealing physical damage. This applies on-hit effects. If it kills the target, Bladesurge's cooldown refreshes and refunds 35 mana." });
		ireliaSpells[2] = new SpellInfo(
				"Hiten Style",
				"",
				"15",
				"40 MANA",
				new String[] { "HEALTH RESTORED: 5 / 7 / 9 / 11 / 13", "TRUE DAMAGE: 15 / 30 / 45 / 60 / 75",
						"HEALTH RESTORED: 10 / 14 / 18 / 22 / 26" },
				new String[] {
						"PASSIVE: Irelia's basic attacks restore health.",
						"ACTIVE: Irelia's basic attacks deal additional true damage for 6 seconds. Hiten Style's passive on-hit health restore is doubled for the duration." });
		ireliaSpells[3] = new SpellInfo(
				"Equilibrium Strike",
				"425",
				"8",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 50% AP)",
						"DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "ACTIVE: Irelia pierces her target, dealing magic damage and slowing the target by 60% for the duration. If the target has a higher health % than Irelia, she stuns the target for the same duration instead." });
		ireliaSpells[4] = new SpellInfo(
				"Transcendent Blades (Cast)",
				"1000",
				"70 / 60 / 50",
				"100 MANA",
				new String[] { "PHYSICAL DAMAGE PER BLADE: 80 / 120 / 160 (+ 50% AP) (+ 60% bonus AD)" },
				new String[] { "ACTIVE: Irelia summons 4 spirit blades and fires one in a line towards the cursor, dealing physical damage to enemies it passes through. Irelia is healed for 25% of the damage dealt to champions and 10% of the damage dealt to minions and monsters." });
		ireliaSpells[5] = new SpellInfo(
				"Transcendent Blades (Use)",
				"1000",
				"0.5",
				"",
				new String[] { "MAXIMUM PHYSICAL DAMAGE TO ONE TARGET: 320 / 480 / 640 (+ 200% AP) (+ 240% bonus AD)" },
				new String[] { "Within the next 15 seconds, Transcendent Blades can be used up to three more times at no cost." });
		champSpells[31] = ireliaSpells;

		SpellInfo[] jannaSpells = new SpellInfo[5];
		jannaSpells[0] = new SpellInfo("Tailwind", "800", "", "", arrS,
				new String[] { "The wind aids Janna's nearby allies, increasing their movement speed by 5%." });
		jannaSpells[1] = new SpellInfo(
				"Howling Gale",
				"1100-1700",
				"14 / 13 / 12 / 11 / 10",
				"90 / 105 / 120 / 135 / 150 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 85 / 110 / 135 / 160 (+ 35% AP)",
						"ADDITIONAL DAMAGE PER SECOND CHARGING: 15 / 20 / 25 / 30 / 35 (+ 10% AP)",
						"MAX MAGIC DAMAGE: 105 / 145 / 185 / 225 / 265 (+ 65% AP)" },
				new String[] { "ACTIVE: Janna summons a mighty whirlwind. On reactivation or after 3 seconds, the storm will fly in the direction it was cast, dealing magic damage to enemies and knocking them into the air for 0.8-1 second. The damage done, knock up duration and distance traveled by the whirlwind increase for each second it channels." });
		jannaSpells[2] = new SpellInfo(
				"Zephyr",
				"600",
				"12 / 11 / 10 / 9 / 8",
				"40 / 50 / 60 / 70 / 80 MANA",
				new String[] { "MOVEMENT SPEED BONUS: 4 / 6 / 8 / 10 / 12% (+ 2% per 100 AP)",
						"MAGIC DAMAGE: 60 / 115 / 170 / 225 / 280 (+ 50% AP)",
						"SLOW: 24 / 28 / 32 / 36 / 40% (+ 6% per 100 AP)" },
				new String[] {
						"PASSIVE: Janna is aided by a wind elemental, gaining movement speed and ignoring unit collision.",
						"ACTIVE: Janna launches the elemental to deal magic damage and slow an enemy's movement speed for 3 seconds (capped at 80% total). She loses the ability's passive benefits while it is on cooldown." });
		jannaSpells[3] = new SpellInfo(
				"Eye Of The Storm",
				"800",
				"10",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "SHIELD STRENGTH: 80 / 120 / 160 / 200 / 240 (+ 70% AP)",
						"ATTACK DAMAGE BONUS: 14 / 23 / 32 / 41 / 50 (+ 10% AP)" },
				new String[] {
						"ACTIVE: Janna surrounds a target ally with a wind shield that absorbs incoming damage for 5 seconds. While the shield persists, the target will also gain an attack damage bonus.",
						"This ability can be used on turrets. If a shielded turret kills an enemy champion, Janna will receive the kill." });
		jannaSpells[4] = new SpellInfo(
				"Monsoon",
				"725",
				"150 / 135 / 120",
				"100 MANA",
				new String[] { "HEAL PER SECOND: 100 / 150 / 200 (+ 60% AP)",
						"MAX AMOUNT OF HEALING: 300 / 450 / 600 (+ 180% AP)" },
				new String[] { "ACTIVE: Janna emits a powerful blast of wind, knocking back enemies within 875 range and then channels, releasing curing winds that heal allies within 875 range every half-second for 3 seconds." });
		champSpells[32] = jannaSpells;

		SpellInfo[] jarvanivSpells = new SpellInfo[5];
		jarvanivSpells[0] = new SpellInfo(
				"Martial Cadence",
				"",
				"",
				"",
				arrS,
				new String[] { "Jarvan IV's first attack on a target deals 6% / 8% / 10% of their current health as bonus physical damage. This caps at 400 damage. This effect cannot occur on the same target more than once every 6 seconds." });
		jarvanivSpells[1] = new SpellInfo(
				"Dragon Strike",
				"770",
				"10 / 9 / 8 / 7 / 6",
				"45 / 50 / 55 / 60 / 65 MANA",
				new String[] { "PHYSICAL DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 120% bonus AD)",
						"ARMOR REDUCTION: 10 / 14 / 18 / 22 / 26%" },
				new String[] {
						"ACTIVE: Jarvan IV extends his lance in a straight line, dealing physical damage and lowering the armor of all enemies hit for 3 seconds.",
						"Additionally, if the lance connects with a deployed  Demacian Standard, it will pull Jarvan to it, knocking up enemies within 180 range along his path for 0.75 seconds." });
		jarvanivSpells[2] = new SpellInfo(
				"Golden Aegis",
				"300",
				"20 / 18 / 16 / 14 / 12",
				"45 / 50 / 55 / 60 / 65 MANA",
				new String[] {
						"SHIELD STRENGTH: 50 / 90 / 130 / 170 / 210 (+ 20 / 30 / 40 / 50 / 60 per nearby enemy champion)",
						"MAX SHIELD STRENGTH: 150 / 240 / 330 / 420 / 510", "SLOW: 15 / 20 / 25 / 30 / 35%" },
				new String[] { "ACTIVE: Jarvan IV slows enemies within range for 2 seconds and shields himself for up to 5 seconds. The shield gains strength for each enemy champion within range upon activation." });
		jarvanivSpells[3] = new SpellInfo(
				"Demacian Standard",
				"830",
				"13",
				"55 MANA",
				new String[] { "ARMOR: 10 / 13 / 16 / 19 / 22", "ATTACK SPEED: 10 / 13 / 16 / 19 / 22%",
						"MAGIC DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 80% AP)",
						"ATTACK SPEED AURA: 10 / 13 / 16 / 19 / 22%" },
				new String[] {
						"PASSIVE: Permanently grants Jarvan IV bonus armor and attack speed.",
						"ACTIVE: Jarvan IV throws a Demacian flag to the target location, dealing magic damage to enemies within 75 range. The flag will remain for 8 seconds, providing an aura that increases the attack speed of allies within a radius of 600." });
		jarvanivSpells[4] = new SpellInfo(
				"Cataclysm",
				"650",
				"120 / 105 / 90",
				"100 / 125 / 150 MANA",
				new String[] { "PHYSICAL DAMAGE: 200 / 325 / 450 (+ 150% bonus AD)" },
				new String[] { "ACTIVE: Jarvan IV leaps to an enemy champion, dealing physical damage to it and creating a 325-radius circle of impassable terrain around themselves. This circle lasts for 3.5 seconds and also grants sight within 825 range. Jarvan IV can prematurely destroy the impassable terrain by activating this ability again." });
		champSpells[33] = jarvanivSpells;

		SpellInfo[] jaxSpells = new SpellInfo[5];
		jaxSpells[0] = new SpellInfo(
				"Relentless Assault",
				"",
				"",
				"",
				arrS,
				new String[] { "Basic attacks increase Jax's attack speed by 4% / 6% / 8% / 10% / 12% / 14%. Relentless Assault lasts for 2.5 seconds and stacks up to 6 times for a maximum of 24% / 36% / 48% / 60% / 72% / 84%." });
		jaxSpells[1] = new SpellInfo("Leap Strike", "700", "10 / 9 / 8 / 7 / 6", "65 MANA",
				new String[] { "PHYSICAL DAMAGE: 70 / 110 / 150 / 190 / 230 (+ 60% AP) (+ 100% bonus AD)" },
				new String[] { "ACTIVE: Jax leaps to target unit, dealing physical damage if the target is an enemy." });
		jaxSpells[2] = new SpellInfo(
				"Empower",
				"",
				"7 / 6 / 5 / 4 / 3",
				"30 MANA",
				new String[] { "MAGIC DAMAGE: 40 / 75 / 110 / 145 / 180 (+ 60% AP)" },
				new String[] { "ACTIVE: Jax's next basic attack or Leap Strike within the next 10 seconds deals additional magic damage. Empower resets the autoattack timer." });
		jaxSpells[3] = new SpellInfo(
				"Counter Strike",
				"187.5",
				"18 / 16 / 14 / 12 / 10",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "PHYSICAL DAMAGE: 50 / 75 / 100 / 125 / 150 (+ 50% bonus AD)",
						"MAX DAMAGE: 100 / 150 / 200 / 250 / 300 (+ 100% bonus AD)" },
				new String[] { "ACTIVE: For up to 2 seconds, Jax dodges all basic attacks and takes 25% less damage from area of effect abilities. At the end of the duration or if Counter Strike is activated again, Jax deals physical damage and stuns nearby enemies for 1 second. This spell deals 20% additional damage for each attack dodged to a maximum of 100% increased damage." });
		jaxSpells[4] = new SpellInfo(
				"Grandmaster's Might",
				"",
				"80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 100 / 160 / 220 (+ 70% AP)", "ARMOR: 25 / 35 / 45 (+ 30% bonus AD)",
						"MAGIC RESIST: 25 / 35 / 45 (+ 20% AP)" },
				new String[] {
						"PASSIVE: Jax deals additional magic damage on every third basic attack. The counter will reset if he does not attack for 2.5 seconds.",
						"ACTIVE: Jax gains bonus armor and magic resistance for 8 seconds." });
		champSpells[34] = jaxSpells;

		SpellInfo[] jayceSpells = new SpellInfo[9];
		jayceSpells[0] = new SpellInfo(
				"Hextech Capacitor",
				"",
				"",
				"",
				arrS,
				new String[] { "Jayce gains 40 bonus movement speed for 1.25 seconds and ignores unit collision each time  Transform   is cast." });
		jayceSpells[1] = new SpellInfo(
				"To The Skies!",
				"600",
				"16 / 14 / 12 / 10 / 8",
				"COST: 40 / 45 / 50 / 55 / 60 MANA",
				new String[] { "PHYSICAL DAMAGE: 20 / 65 / 110 / 155 / 200 (+ 100% Bonus AD)",
						"SLOW: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "ACTIVE: Jayce leaps to an enemy and smashes them, dealing physical damage to his target and to enemies around it, and then slowing them for 2 seconds." });
		jayceSpells[2] = new SpellInfo(
				"Shock Blast",
				"1050 / 1470",
				"8",
				"55 / 60 / 65 / 70 / 75 MANA",
				new String[] { "PHYSICAL DAMAGE: 60 / 115 / 170 / 225 / 280 (+ 120% Bonus AD)",
						"ACCELERATED PHYSICAL DAMAGE: 84 / 161 / 238 / 315 / 392 (+ 168% Bonus AD)" },
				new String[] {
						"ACTIVE: Jayce fires an orb of electricity that detonates upon hitting an enemy or reaching the end of its path, dealing physical damage to all enemies in the area of the explosion.",
						"If Shock Blast is fired through an  Acceleration Gate the area of effect, missile speed, range and damage will increase by 40%." });
		jayceSpells[3] = new SpellInfo(
				"Lightning Field",
				"285",
				"10",
				"40 MANA",
				new String[] { "MANA PER HIT: 6 / 8 / 10 / 12 / 14",
						"MAGIC DAMAGE PER SECOND: 25 / 42.5 / 60 / 77.5 / 95 (+ 25% AP)",
						"TOTAL MAGIC DAMAGE: 100 / 170 / 240 / 310 / 380 (+ 100% AP)" },
				new String[] {
						"PASSIVE: Jayce regenerates mana each time he strikes an enemy while in  Hammer Stance.",
						"ACTIVE: Jayce is surrounded by an electric field, dealing magic damage over 4 seconds to nearby enemies." });
		jayceSpells[4] = new SpellInfo(
				"Hyper Charge",
				"",
				"14 / 12 / 10 / 8 / 6",
				"40 MANA",
				new String[] { "DAMAGE MULTIPLIER: 70 / 85 / 100 / 115 / 130%" },
				new String[] { "ACTIVE: Jayce gains the max amount of attack speed (2.5 attacks per second) for his next 3 attacks. These attacks deal varied damage depending on rank." });
		jayceSpells[5] = new SpellInfo(
				"Thundering Blow",
				"240",
				"14 / 13 / 12 / 11 / 10",
				"40 / 50 / 60 / 70 / 80 MANA",
				new String[] {
						"TOTAL MAGIC DAMAGE: 8 / 11 / 14 / 17 / 20% of target's maximum health (+100% Bonus AD)",
						"MAX DAMAGE TO MONSTERS: 200 / 300 / 400 / 500 / 600" },
				new String[] { "ACTIVE: Jayce swings his hammer at target enemy, knocking them back and dealing magic damage equal to a percentage of the target's maximum health plus Jayce's bonus attack damage. This damage is capped against monsters." });
		jayceSpells[6] = new SpellInfo(
				"Acceleration Gate",
				"650",
				"16",
				"50 MANA",
				new String[] { "MOVEMENT SPEED: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "ACTIVE: Deploys an Acceleration Gate for 4 seconds, increasing the movement speed of all allies who pass through it for 3 seconds. This bonus fades over the duration." });
		jayceSpells[7] = new SpellInfo(
				"Transform: Mercury Cannon",
				"",
				"6",
				"NO COST",
				new String[] { "ARMOR / MAGIC RESIST REDUCTION: 10 / 15 / 20 / 25%" },
				new String[] { "ACTIVE: Transforms the Mercury Hammer into the Mercury Cannon, gaining new abilities and ranged attacks. Jayce gains 375 range, for a total of 500 range. The next attack in Cannon Stance reduces the enemy's armor and magic resist for 5 seconds." });
		jayceSpells[8] = new SpellInfo(
				"Transform: Mercury Hammer",
				"",
				"6",
				"NO COST",
				new String[] { "ARMOR / MAGIC RESIST: 5 / 15 / 25 / 35",
						"BONUS MAGIC DAMAGE: 20 / 60 / 100 / 140 (+ 40% AP)" },
				new String[] {
						"ACTIVE: Transforms the Mercury Cannon into the Mercury Hammer, gaining new abilities, melee attacks, and bonus armor and magic resist.",
						"The next attack in Hammer Stance deals additional magic damage.",
						"Jayce begins with one rank in Transform and can increase it at levels 6, 11, and 16 up to 4 ranks." });
		champSpells[35] = jayceSpells;

		SpellInfo[] jinxSpells = new SpellInfo[6];
		jinxSpells[0] = new SpellInfo(
				"Get Excited!",
				"",
				"",
				"",
				arrS,
				new String[] { "Whenever a champion or tower that Jinx has dealt damage to within the last 3 seconds is killed or destroyed, she gains 175% movement speed that decays over 4 seconds." });
		jinxSpells[1] = new SpellInfo(
				"Switcheroo! (Toggle Off)",
				"",
				"0.9",
				"",
				new String[] { "ATTACK SPEED: 10 / 18.3 / 26.6 / 35 / 43.3%",
						"TOTAL ATTACK SPEED: 30 / 55 / 80 / 105 / 130%" },
				new String[] {
						"TOGGLE OFF-POW-POW, THE MINIGUN: Jinx's basic attacks grant bonus attack speed for 2.5 seconds, stacking up to 3 times. The stacks decay one at a time when she stops attacking with her minigun.",
						"Switching to her Rocket Launcher will not clear any active stacks, but they will not grant attack speed after her first attack." });
		jinxSpells[2] = new SpellInfo(
				"Switcheroo! (Toggle On)",
				"",
				"0.9",
				"20 MANA PER ATTACK",
				new String[] { "BONUS RANGE: 75 / 100 / 125 / 150 / 175" },
				new String[] {
						"TOGGLE ON-FISHBONES, THE ROCKET LAUNCHER: Jinx gains bonus attack range and deals 10% AD bonus damage on her attacks, at the cost of mana per attack.",
						"Additionally, her attacks will splash, dealing full damage to all enemies in a ~150-radius area. The bonus damage to her target and the splash damage both scale additively with critical strikes." });
		jinxSpells[3] = new SpellInfo(
				"Zap!",
				"1500",
				"10 / 9 / 8 / 7 / 6",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "PHYSICAL DAMAGE: 10 / 60 / 110 / 160 / 210 (+ 140% AD)",
						"SLOW: 30 / 40 / 50 / 60 / 70%" },
				new String[] { "ACTIVE: After a short delay, Jinx fires a shock blast that deals physical damage to the first enemy hit, also granting sight and slowing it for 2 seconds." });
		jinxSpells[4] = new SpellInfo(
				"Flame Chompers!",
				"900",
				"24 / 22 / 20 / 18 / 16",
				"50 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 135 / 190 / 245 / 300 (+ 100% AP)" },
				new String[] { "ACTIVE: Jinx tosses out 3 chompers that, after an arm time of 0.7 seconds, explode on contact with enemy champions dealing magic damage over 1.5 seconds to enemies within ~50-unit area. The champion that sets off the chomper is also rooted the same duration. Chompers explode automatically after 5 seconds. A single champion can only set off a single chomper, but can be damaged by any number if they remain in range." });
		jinxSpells[5] = new SpellInfo(
				"Super Mega Death Rocket!",
				"Global",
				"90 / 75 / 60",
				"100 MANA",
				new String[] { "MINIMUM PHYSICAL DAMAGE: 125 / 175 / 225 (+ 50% bonus AD)",
						"MAXIMUM PHYSICAL DAMAGE: 250 / 350 / 450 (+ 100% bonus AD)",
						"ADDITIONAL DAMAGE: 25 / 30 / 35% of enemies' missing health" },
				new String[] { "ACTIVE: Jinx fires a rocket that travels in a line, exploding on the first enemy champion hit. Enemies caught in the explosion take physical damage equal to a base amount (this amount increases over the first second the rocket travels) plus a percentage of their missing health (max. 300 vs. minions and monsters[4]). The primary target of the explosion takes full damage, while nearby enemies take 80% damage." });
		champSpells[36] = jinxSpells;

		SpellInfo[] karmaSpells = new SpellInfo[8];
		karmaSpells[0] = new SpellInfo(
				"Gathering Fire",
				"",
				"",
				"",
				arrS,
				new String[] { "Damaging enemy champions with Karma's abilities refreshes 2 seconds of  Mantra's cooldown, and half that amount on basic attacks against enemy champions." });
		karmaSpells[1] = new SpellInfo(
				"Inner Flame",
				"950",
				"7 / 6.5 / 6 / 5.5 / 5",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Karma fires a ball of energy that detonates on hitting an enemy, dealing magic damage and slowing surrounding enemies by 25% for 1.5 seconds.",
						"If it hits an unseen enemy, the detonation effect will still be visible." });
		karmaSpells[2] = new SpellInfo(
				"Soulflare",
				"",
				"",
				"",
				new String[] { "Soulflare scales with ranks in Mantra.",
						"BONUS MAGIC DAMAGE: 25 / 75 / 125 / 175 (+ 30% AP)",
						"DETONATION MAGIC DAMAGE: 50 / 150 / 250 / 350 (+ 60% AP)" },
				new String[] { "MANTRA BONUS: Inner Flame deals bonus magic damage and leaves a 250-radius AoE that slows enemies inside by 50%. After 1.5 seconds the area detonates, dealing magic damage to enemies inside. If Inner Flame does not strike a target, the area is created at maximum range." });
		karmaSpells[3] = new SpellInfo(
				"Focused Resolve",
				"650",
				"16 / 15 / 14 / 13 / 12",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 60% AP)",
						"ROOT DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "ACTIVE: Karma forms a 650-range tether to target enemy champion, revealing and dealing magic damage to the target over 2 seconds at 0.66-second intervals. If the tether is not broken after the 2 seconds, the target is rooted for a short time." });
		karmaSpells[4] = new SpellInfo(
				"Renewal",
				"",
				"",
				"",
				new String[] { "Renewal scales with ranks in Mantra.",
						"BONUS MAGIC DAMAGE: 75 / 150 / 225 / 300 (+ 60% AP)",
						"MAX. HEAL: 40% (+ 2% per 100 AP) of her missing health" },
				new String[] { "MANTRA BONUS: Focused Resolve deals bonus damage and heals Karma for 20% (+ 1% per 100 AP) of her missing health upon casting and another instance of the same value if the leash is not broken." });
		karmaSpells[5] = new SpellInfo(
				"Inspire",
				"800",
				"10",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "SHIELD: 80 / 120 / 160 / 200 / 240 (+ 50% AP)",
						"BONUS MOVEMENT SPEED: 40 / 45 / 50 / 55 / 60%" },
				new String[] { "ACTIVE: Karma shields a target ally for 4 seconds and grants them bonus movement speed for 1.5 seconds." });
		karmaSpells[6] = new SpellInfo(
				"Defiance",
				"",
				"",
				"",
				new String[] { "Defiance scales with ranks in Mantra.", "AURA SHIELD: 30 / 70 / 110 / 150 (+ 30% AP)",
						"MAGIC DAMAGE: 60 / 140 / 220 / 300 (+ 60% AP)" },
				new String[] {
						"MANTRA BONUS: Inspire's shield overflows with energy, shielding allied champions within 700-range of the target for 4 seconds and granting them 60% bonus movement speed for 1.5 seconds, while dealing magic damage to enemies within 600-range of the target.",
						"Karma's target does not gain any bonus shield amount, but their bonus movement speed is increased to 60%." });
		karmaSpells[7] = new SpellInfo(
				"Mantra",
				"",
				"45 / 42 / 39 / 36",
				"NO COST",
				new String[] { "Ranks in Mantra improve the additional effects of empowered abilities." },
				new String[] {
						"ACTIVE: Karma empowers her next ability cast within the next 8 seconds, adding an additional effect. Empowered abilities share the same cooldown as their basic form.",
						"Karma begins with one rank in Mantra and can increase it at levels 6, 11, and 16." });
		champSpells[37] = karmaSpells;

		SpellInfo[] karthusSpells = new SpellInfo[5];
		karthusSpells[0] = new SpellInfo(
				"Death Defied",
				"",
				"",
				"",
				arrS,
				new String[] { "Upon dying, Karthus enters a spirit form and becomes immobile and untargetable, allowing him to continue casting spells for 7 seconds. During this time, his abilities cost no mana." });
		karthusSpells[1] = new SpellInfo(
				"Lay Waste",
				"875",
				"1",
				"20 / 26 / 32 / 38 / 44 MANA",
				new String[] { "MAGIC DAMAGE (MULTIPLE TARGET): 40 / 60 / 80 / 100 / 120 (+ 30% AP)",
						"MAGIC DAMAGE (SINGLE TARGET): 80 / 120 / 160 / 200 / 240 (+ 60% AP)" },
				new String[] { "ACTIVE: After a 0.5 second delay, Karthus creates an explosion at target 50-radius area. Enemies hit take magic damage, and this damage is doubled if Lay Waste only hits one unit." });
		karthusSpells[2] = new SpellInfo(
				"Wall of Pain",
				"1000",
				"18",
				"100 MANA",
				new String[] { "WALL LENGTH: 800 / 900 / 1000 / 1100 / 1200", "SLOW: 40 / 50 / 60 / 70 / 80%",
						"MAXIMUM WALL SIGHT EST.: 1300 / 1325 / 1350 / 1375 / 1400" },
				new String[] { "ACTIVE: Karthus creates a wall of energy between 2 obelisks at target position for 5 seconds. Enemies who pass this wall have their movement speed reduced by a large amount and their magic resistance reduced by 15% for 5 seconds." });
		karthusSpells[3] = new SpellInfo(
				"Defile",
				"425",
				"",
				"30 / 42 / 54 / 66 / 78 MANA PER SECOND",
				new String[] { "MANA RESTORED: 20 / 27 / 34 / 41 / 48",
						"MAGIC DAMAGE: 30 / 50 / 70 / 90 / 110 (+ 20% AP)" },
				new String[] {
						"TOGGLE OFF: When Karthus kills a unit, he restores mana. ",
						"TOGGLE ON: Karthus surrounds himself with the souls of his victims, draining his mana to deal magic damage to enemies in range each second." });
		karthusSpells[4] = new SpellInfo(
				"Requiem",
				"Global",
				"200 / 180 / 160",
				"150 / 175 / 200 MANA",
				new String[] { "MAGIC DAMAGE: 250 / 400 / 550 (+ 60% AP)" },
				new String[] { "ACTIVE: After channeling for 3 seconds, Karthus blasts all enemy champions regardless of their position on the map, dealing magic damage." });
		champSpells[38] = karthusSpells;

		SpellInfo[] kassadinSpells = new SpellInfo[5];
		kassadinSpells[0] = new SpellInfo("Void Stone", "", "", "", arrS,
				new String[] { "Kassadin takes 15% reduced magic damage and ignores unit collision." });
		kassadinSpells[1] = new SpellInfo(
				"Null Sphere",
				"650",
				"9",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 105 / 130 / 155 / 180 (+ 70% AP)",
						"SHIELD STRENGTH: 40 / 70 / 100 / 130 / 160 (+ 30% AP)" },
				new String[] { "ACTIVE: Kassadin fires an orb of void energy at a target enemy, dealing magic damage and interrupting channels. The excess energy forms around himself, granting a shield that absorbs magic damage for 1.5 seconds." });
		kassadinSpells[2] = new SpellInfo(
				"Nether Blade",
				"0",
				"6",
				"NO COST",
				new String[] { "MAGIC DAMAGE: 40 / 65 / 90 / 115 / 140 (+ 60% AP)",
						"MANA RESTORED: 4 / 5 / 6 / 7 / 8 % missing mana",
						"MANA RESTORED AGAINST CHAMPIONS: 20 / 25 / 30 / 35 / 40 % missing mana" },
				new String[] {
						"PASSIVE: Kassadin's basic attacks deal 20 (+10% AP) bonus magic damage on-hit.",
						"ACTIVE: Kassadin charges his Nether Blade, causing his next basic attack to deal bonus magic damage, gains 50 range (200 total range) and restore a percentage of his missing mana. Mana restored is quintupled against champions." });
		kassadinSpells[3] = new SpellInfo(
				"Force Pulse",
				"700",
				"6",
				"80 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 105 / 130 / 155 / 180 (+ 70% AP)", "SLOW: 30 / 35 / 40 / 45 / 50%" },
				new String[] {
						"PASSIVE: Kassadin draws energy from spells cast in his vicinity, gaining a charge whenever a spell is cast near him, including his own spells.",
						"ACTIVE: Upon reaching 6 charges, Kassadin can emit a pulse of void energy, dealing magic damage and slowing enemies in a 80º cone in front of him for 3 seconds." });
		kassadinSpells[4] = new SpellInfo(
				"Riftwalk",
				"700",
				"7 / 5 / 3",
				"75 / 150 / 300 / 600 / 1200 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 100 / 120 (+ 2% of max mana)",
						"BONUS DAMAGE PER STACK: 40 / 50 / 60 (+ 1% max mana)" },
				new String[] {
						"ACTIVE: Kassadin teleports to a nearby location, dealing magic damage to enemy units within 150 range upon arrival.",
						"Each subsequent Riftwalk within the next 12 seconds costs double the mana and deals bonus damage, stacking up to 4 times.",
						"TOTAL COST OF USING RIFTWALK N TIMES: 75 / 225 / 525 / 1125 / 2325" });
		champSpells[39] = kassadinSpells;

		SpellInfo[] katarinaSpells = new SpellInfo[5];
		katarinaSpells[0] = new SpellInfo(
				"Voracity",
				"0",
				"",
				"",
				arrS,
				new String[] { "Scoring a kill or assist will reduce all the cooldowns of Katarina's abilities by 15 seconds." });
		katarinaSpells[1] = new SpellInfo(
				"Bouncing Blades",
				"675",
				"10 / 9.5 / 9 / 8.5 / 8",
				"",
				new String[] { "DAGGER MAGIC DAMAGE: 60 / 85 / 110 / 135 / 160 (+ 45% AP)",
						"MARK MAGIC DAMAGE: 15 / 30 / 45 / 60 / 75 (+ 15% AP)",
						"TOTAL DAMAGE: 75 / 115 / 155 / 195 / 235 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Katarina throws a dagger that bounces quickly from enemy to enemy, dealing magic damage and marking each enemy hit for 4 seconds. Bouncing Blades hits a total of 5 unique targets (4 bounces), each striking the closest next target. Each subsequent hit deals 10% less damage.",
						"Striking a marked target with an ability or basic attack will consume the mark to deal additional magic damage." });
		katarinaSpells[2] = new SpellInfo(
				"Sinister Steel",
				"375",
				"4",
				"",
				new String[] { "MAGIC DAMAGE: 40 / 75 / 110 / 145 / 180 (+ 25% AP) (+ 60% bonus AD)",
						"MOVEMENT SPEED: 15 / 20 / 25 / 30 35%" },
				new String[] { "ACTIVE: Katarina whirls her daggers, instantly dealing magic damage to all nearby enemies. If she damages an enemy champion, she gains movement speed for 1 second." });
		katarinaSpells[3] = new SpellInfo(
				"Shunpo",
				"700",
				"12 / 10.5 / 9 / 7.5 / 6",
				"",
				new String[] { "MAGIC DAMAGE: 60 / 85 / 110 / 135 / 160 (+ 40% AP)" },
				new String[] { "ACTIVE: Katarina teleports to target unit and gains 15% damage reduction for 1.5 seconds. If the target is an enemy, the target takes magic damage." });
		katarinaSpells[4] = new SpellInfo(
				"Death Lotus",
				"550",
				"60 / 52.5 / 45",
				"",
				new String[] { "MAGIC DAMAGE PER DAGGER: 40 / 57.5 / 75 (+ 25% AP) (+ 37.5% bonus AD)",
						"MAXIMUM DAMAGE TO EACH ENEMY: 400 / 575 / 750 (+ 250% AP) (+ 375% bonus AD)" },
				new String[] {
						"ACTIVE: Katarina rapidly spins in place and channels for 2.5 seconds, throwing a barrage of up to 30 daggers at the closest 3 enemy champions within range. Each dagger deals magic damage and applies Grievous Wounds for 3 seconds, reducing regeneration or incoming healing by 50%.",
						"Death Lotus can hit a single enemy champion no more than 10 times." });
		champSpells[40] = katarinaSpells;

		SpellInfo[] kayleSpells = new SpellInfo[5];
		kayleSpells[0] = new SpellInfo(
				"Holy Fervor",
				"",
				"",
				"",
				arrS,
				new String[] { "Kayle's autoattacks against enemy champions reduce their armor and magic resistance by 3% for 5 seconds. This debuff stacks up to 5 times." });
		kayleSpells[1] = new SpellInfo(
				"Reckoning",
				"650",
				"8",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 60% AP) (+ 100% Bonus AD)",
						"SLOW: 35 / 40 / 45 / 50 / 55%" },
				new String[] { "ACTIVE: Kayle blasts a target enemy, dealing magic damage, slowing its movement speed for 3 seconds and applying a stack of Holy Fervor." });
		kayleSpells[2] = new SpellInfo(
				"Divine Blessing",
				"900",
				"15",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "HEAL: 60 / 105 / 150 / 195 / 240 (+ 45% AP)",
						"MOVEMENT SPEED: 18 / 21 / 24 / 27 / 30% (+7% per 100 AP)" },
				new String[] { "ACTIVE: Blesses a target allied champion, healing them and increasing their movement speed for 3 seconds." });
		kayleSpells[3] = new SpellInfo(
				"Righteous Fury",
				"",
				"16",
				"45 MANA",
				new String[] { "BONUS MAGIC DAMAGE: 20 / 30 / 40 / 50 / 60 (+ 40% AP)",
						"MAGIC SPLASH DAMAGE: 20 / 30 / 40 / 50 / 60 (+ 40% AP) (+ 20 / 25 / 30 / 35 / 40% AD)" },
				new String[] { "ACTIVE: Kayle ignites her sword and becomes ranged for 10 seconds, granting her bonus magic damage on her attacks and increasing her attack range by 400 (525 total range). Additionally, attacks on non-tower units damage other enemies within 150 range of the target." });
		kayleSpells[4] = new SpellInfo(
				"Intervention",
				"900",
				"90 / 75 / 60",
				"NO COST",
				new String[] { "DURATION: 2 / 2.5 / 3" },
				new String[] { "ACTIVE: Kayle bathes a target ally champion or herself in holy light, rendering the champion immune to all damage for a few seconds." });
		champSpells[41] = kayleSpells;

		SpellInfo[] kennenSpells = new SpellInfo[5];
		kennenSpells[0] = new SpellInfo(
				"Mark of the Storm",
				"",
				"",
				"",
				arrS,
				new String[] { "Enemies hit by Kennen's abilities receive one Mark of the Storm, which lasts for 6.25 seconds. These marks stack and upon receiving 3 Marks of the Storm, they detonate to stun the target for 1 second and grant Kennen 25 energy. If the stun is applied more than once within 7 seconds, it has a diminished effect and will only stun for approximately 0.5 seconds" });
		kennenSpells[1] = new SpellInfo(
				"Thundering Shuriken",
				"1050",
				"8 / 7 / 6 / 5 / 4",
				"65 / 60 / 55 / 50 / 45 ENERGY",
				new String[] { "MAGIC DAMAGE: 75 / 115 / 155 / 195 / 235 (+ 75% AP)" },
				new String[] { "ACTIVE: Kennen throws a charged shuriken in a line in front of him, dealing magic damage to the first enemy that it hits." });
		kennenSpells[2] = new SpellInfo(
				"Electrical Surge",
				"800",
				"14 / 12 / 10 / 8 / 6",
				"45 ENERGY",
				new String[] { "MAGIC DAMAGE: 40 / 50 / 60 / 70 / 80% AD",
						"MAGIC DAMAGE: 65 / 95 / 125 / 155 / 185 (+ 55% AP)" },
				new String[] {
						"PASSIVE: Every fifth basic attack will deal extra magic damage proportional to Kennen's attack damage.",
						"ACTIVE: Sends a surge of electricity through all nearby enemies afflicted by Mark of the Storm, dealing magic damage." });
		kennenSpells[3] = new SpellInfo(
				"Lightning Rush",
				"",
				"10 / 9 / 8 / 7 / 6",
				"100 / 95 / 90 / 85 / 80 ENERGY",
				new String[] { "MAGIC DAMAGE: 85 / 125 / 165 / 205 / 245 (+ 60% AP)",
						"MAGIC DAMAGE TO MINIONS & MONSTERS: 42.5 / 62.5 / 82.5 / 102.5 / 122.5 (+ 30% AP)",
						"ARMOR & MAGIC RESIST: 10 / 20 / 30 / 40 / 50" },
				new String[] {
						"ACTIVE: Kennen transforms into a ball of electricity ignoring unit collision and gaining 100% base movement speed for 2 seconds. Any enemies he passes through take magic damage, dealing half damage to minions and monsters. Kennen also gains 40 energy from the first enemy he hits. Kennen cannot use basic attacks while Lightning Rush is active.",
						"Additionally, for 4 seconds Kennen's armor and magic resistance are increased. While Lightning Rush is active, Kennen can activate it again to cancel the first part of the ability." });
		kennenSpells[4] = new SpellInfo(
				"Slicing Maelstrom",
				"550",
				"120",
				"NO COST",
				new String[] { "MAGIC DAMAGE PER BOLT: 80 / 145 / 210 (+ 40% AP)",
						"MAXIMUM SINGLE TARGET DAMAGE: 240 / 435 / 630 (+ 120% AP)", "DURATION: 3 / 4 / 5",
						"NUMBER OF BOLTS: 6 / 10 / 15", "TIME BETWEEN BOLTS: 0.5 / 0.4 / 0.33" },
				new String[] { "ACTIVE: Kennen summons a magical storm around himself that zaps a random enemy champion within range every fraction of a second, dealing magic damage. The storm hits several times, increasing with level, and cannot hit the same target more than 3 times." });
		champSpells[42] = kennenSpells;

		// may need some editting
		SpellInfo[] khaZixSpells = new SpellInfo[9];
		khaZixSpells[0] = new SpellInfo(
				"Unseen Threat",
				"",
				"",
				"",
				arrS,
				new String[] {
						"When Kha'Zix is not visible to the enemy team, he gains Unseen Threat. Unseen Threat causes his next basic attack against an enemy champion to deal 15 / 20 / 25 / 35 / 45 / 55 / 65 / 75 / 85 / 95 / 110 / 125 / 140 / 150 / 160 / 170 / 180 / 190 (10 + 5 / 10 / 15 / 10 at each level) (+ 50% AP) bonus magic damage and slow by 25% for 2 second",
						"Unseen Threat lasts until consumed and has no internal cooldown." });
		khaZixSpells[1] = new SpellInfo(
				"Taste Their Fear",
				"325",
				"3.5",
				"25 MANA",
				new String[] { "PHYSICAL DAMAGE: 70 / 100 / 130 / 160 / 190 (+ 150% bonus AD)",
						"DAMAGE TO ISOLATED TARGET: 101.5 / 145 / 188.5 / 232 / 275.5 (+ 217.5% bonus AD)" },
				new String[] {
						"PASSIVE: Kha'Zix marks enemies that are isolated from their allies.",
						"ACTIVE: Kha'Zix slashes, dealing physical damage to a single enemy. If the target was isolated, the damage dealt is increased by 45%." });
		khaZixSpells[2] = new SpellInfo(
				"Evolved Enlarged Claws",
				"375",
				"",
				"",
				arrS,
				new String[] { "Increases range of  Taste Their Fear and auto attacks by 50. Additionally,  Taste Their Fear now deals an additional 6% of the target's missing health as bonus damage (max 100 vs monsters). Against isolated targets this damage is increased by 45% to 8.7% of missing health." });
		khaZixSpells[3] = new SpellInfo(
				"Void Spike",
				"1000",
				"8",
				"55 / 60 / 65 / 70 / 75 MANA",
				new String[] { "PHYSICAL DAMAGE: 75 / 115 / 155 / 195 / 235 (+ 100% bonus AD)",
						"HEAL: 40 / 70 / 100 / 130 / 160 (+ 50% AP)" },
				new String[] { "ACTIVE: Kha'Zix fires a cluster of spikes in a line that explode on contact with an enemy, dealing physical damage to all nearby enemies and slowing them by 20% for 2 seconds. Kha'Zix is healed if he is within the explosion radius." });
		khaZixSpells[4] = new SpellInfo(
				"Evolved Spike Racks",
				"",
				"",
				"",
				arrS,
				new String[] { "Enhances  Void Spike to fire three spikes in a cone and increases the slow to 30%. Multiple explosions upon the same enemy do not deal extra damage." });
		khaZixSpells[5] = new SpellInfo(
				"Leap",
				"600",
				"22 / 20 / 18 / 16 / 14",
				"50 MANA",
				new String[] { "PHYSICAL DAMAGE: 65 / 100 / 135 / 170 / 205 (+ 20% bonus AD)" },
				new String[] { "ACTIVE: Kha'Zix leaps to an area, dealing physical damage to nearby enemies upon landing." });
		khaZixSpells[6] = new SpellInfo(
				"Evolved Wings",
				"900",
				"",
				"",
				arrS,
				new String[] { "Increases Leap's range by 300, and causes kills and assists scored by Kha'Zix to refresh  Leap's cooldown." });
		khaZixSpells[7] = new SpellInfo(
				"Void Assault",
				"",
				"100 / 90 / 80",
				"100 MANA",
				arrS,
				new String[] {
						"PASSIVE: Each rank of Void Assault allows Kha'Zix to evolve one of his abilities, granting it an additional effect.",
						"ACTIVE: Kha'Zix enters stealth for 1 second, gaining 40% bonus movement speed and ignores unit collision while stealthed.  Unseen Threat is also granted (even if Kha'Zix is revealed through stealth). Void Assault can be cast a second time within 10 seconds at no cost." });
		khaZixSpells[8] = new SpellInfo(
				"Evolved Active Camouflage",
				"",
				"",
				"",
				arrS,
				new String[] { "Allows  Void Assault to be cast up to three times and stealth duration increased by 1 second (total 2 seconds). Kha'Zix takes 50% reduced damage while in stealth. Enemy turrets ignore this damage reduction." });
		champSpells[43] = khaZixSpells;

		SpellInfo[] kogMawSpells = new SpellInfo[5];
		kogMawSpells[0] = new SpellInfo(
				"Icathian Surprise",
				"",
				"",
				"",
				arrS,
				new String[] { "Upon dying, Kog'Maw starts a chain reaction in his body which causes him to gain up to 40% movement speed gradually over the duration of 4 seconds and detonate; dealing 100 + (25 × level) true damage to surrounding enemies." });
		kogMawSpells[1] = new SpellInfo(
				"Caustic Spittle",
				"1000",
				"8",
				"60 MANA",
				new String[] { "ATTACK SPEED: 10 / 15 / 20 / 25 / 30%",
						"MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 50% AP)",
						"ARMOR & MAGIC RESIST REDUCTION: 20 / 22 / 24 / 26 / 28%" },
				new String[] {
						"PASSIVE: Increases Kog'Maw's attack speed.",
						"ACTIVE: Kog'Maw launches a corrosive projectile forward in a line, dealing magic damage to the first enemy it hits and reducing their armor and magic resistance by a percentage for 4s." });
		kogMawSpells[2] = new SpellInfo(
				"Bio-Arcane Varrage",
				"",
				"17",
				"NO COST",
				new String[] { "BONUS RANGE: 130 / 150 / 170 / 190 / 210",
						"MAGIC DAMAGE: 2 / 3 / 4 / 5 / 6% (+ 1% per 100 AP) of target's maximum health" },
				new String[] { "ACTIVE: For 8 seconds, Kog'Maw's attacks gain range and deal a percentage of the target's maximum health as additional magic damage. The bonus damage caps at 100 against minions and monsters." });
		kogMawSpells[3] = new SpellInfo(
				"Void Ooze",
				"1280",
				"12",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 70% AP)", "SLOW: 20 / 28 / 36 / 44 / 52%" },
				new String[] { "ACTIVE: Kog'Maw launches a ball of ooze that deals magic damage and slows all enemies in a line for 1 second. The ooze lingers for 4 seconds, slowing enemies who stand on it for 0.25 seconds." });
		kogMawSpells[4] = new SpellInfo(
				"Living Artillery",
				"1400 / 1700 / 2200",
				"2 / 1.5 / 1",
				"40 ( × cast) MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 (+ 30% AP) (+ 50% Bonus AD)",
						"MAGIC DAMAGE TO CHAMPIONS: 180 / 270 / 360 (+ 30% AP) (+ 50% Bonus AD)" },
				new String[] { "ACTIVE: Kog'Maw launches a ball of acid into the air that drops after 0.6 seconds at target 100-radius area, damaging and granting sight enemies hit for 4 seconds. Enemy champions take 125% extra base damage. Each subsequent Living Artillery in the next 6 seconds after a cast will cost 40 additional mana, capping at 400 per cast." });
		champSpells[44] = kogMawSpells;

		SpellInfo[] leBlancSpells = new SpellInfo[5];
		leBlancSpells[0] = new SpellInfo(
				"Mirror Image",
				"",
				"60",
				"",
				arrS,
				new String[] { "Whenever LeBlanc is below 40% health, she will become stealthed for 0.5 seconds. When the stealth ends, she creates a controllable clone of herself for 8 seconds with 53 + (17 × level) less health." });
		leBlancSpells[1] = new SpellInfo(
				"Sigil of Silence",
				"700",
				"6",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "INITIAL MAGIC DAMAGE: 55 / 80 / 105 / 130 / 155 (+ 40% AP)",
						"SECONDARY MAGIC DAMAGE: 55 / 80 / 105 / 130 / 155 (+ 40% AP)",
						"TOTAL MAGIC DAMAGE: 110 / 160 / 210 / 260 / 310 (+ 80% AP)" },
				new String[] { "ACTIVE: LeBlanc projects an orb towards her target, dealing magic damage and marking the target for 3.5 seconds. If the target takes damage from one of LeBlanc's abilities, the mark will trigger, dealing bonus magic damage and silencing the target for 1.5 seconds." });
		leBlancSpells[2] = new SpellInfo(
				"Distortion",
				"600",
				"18 / 16 / 14 / 12 / 10",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE: 85 / 125 / 165 / 205 / 245 (+ 60% AP)" },
				new String[] {
						"FIRST CAST: LeBlanc rapidly dashes to a target location, damaging enemies within a 250-radius area and leaving behind a return pad. LeBlanc can activate Distortion again in the following 3 seconds.",
						"SECOND CAST: LeBlanc blinks to the return pad." });
		leBlancSpells[3] = new SpellInfo(
				"Ethereal Chains",
				"950",
				"14 / 12.5 / 10 / 9.5 / 8",
				"80 MANA",
				new String[] { "INITIAL MAGIC DAMAGE: 40 / 65 / 90 / 115 / 140 (+ 50% AP)",
						"DELAYED MAGIC DAMAGE: 40 / 65 / 90 / 115 / 140 (+50 % AP)",
						"TOTAL MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 100% AP)" },
				new String[] {
						"ACTIVE: LeBlanc flings illusionary chains in a line towards a target location. If it hits an enemy unit, it will deal initial magic damage and leash to it, slowing their movement speed by 25% while the leash remains.",
						"If the target remains within 1000 units for the full 1.5 seconds, the target takes additional magic damage and is rooted for 1.5 seconds." });
		leBlancSpells[4] = new SpellInfo(
				"Mimic",
				"",
				"40 / 32 / 24",
				"NO COST",
				new String[] { "MIMIC: SIGIL OF SILENCE: 100 / 200 / 300 (+ 65% AP)",
						"MIMIC: DISTORTION: 150 / 300 / 450 (+ 97.5% AP)",
						"MIMIC: ETHEREAL CHAINS: 100 / 200 / 300 (+ 65% AP)",
						"MAXIMUM DAMAGE ON Q AND E: 200 / 400 / 600 (+ 130% AP)" },
				new String[] { "ACTIVE: LeBlanc casts the previous spell she cast. The mimicked spell's effects are the same but the damage is replaced with a different amount based on the rank of Mimic." });
		champSpells[45] = leBlancSpells;

		SpellInfo[] leeSinSpells = new SpellInfo[8];
		leeSinSpells[0] = new SpellInfo(
				"Flurry",
				"",
				"",
				"",
				arrS,
				new String[] { "After using an ability, Lee Sin's next 2 basic attacks within 3 seconds gain 40% attack speed and return 15 energy each." });
		leeSinSpells[1] = new SpellInfo(
				"Sonic Wave",
				"1100",
				"11 / 10 / 9 / 8 / 7",
				"50 ENERGY",
				new String[] { "PHYSICAL DAMAGE: 50 / 80 / 110 / 140 / 170 (+ 90% bonus AD)" },
				new String[] { "ACTIVE: Lee Sin shoots a wave of sound in a line, dealing physical damage to the first enemy it hits and granting true sight of it for 3 seconds. If Sonic Wave hits, Lee Sin can cast Resonating Strike within the next 3 seconds." });
		leeSinSpells[2] = new SpellInfo(
				"Resonating Strike",
				"1300",
				"",
				"30 ENERGY",
				new String[] {
						"PHYSICAL DAMAGE: 50 / 80 / 110 / 140 / 170 (+ 90% bonus AD) (+ 8% target's missing health)",
						"COMBINED DAMAGE: 100 / 160 / 220 / 280 / 340 (+ 180% bonus AD) (+ 8% target's missing health)" },
				new String[] { "ACTIVE: Lee Sin dashes to the enemy marked by Sonic Wave, dealing physical damage including 8% of the target's missing health. Minions and monsters take a maximum of 400 damage." });
		leeSinSpells[3] = new SpellInfo(
				"Safeguard",
				"700",
				"14",
				"50 ENERGY",
				new String[] { "SHIELD: 40 / 80 / 120 / 160 / 200 (+ 80% AP)" },
				new String[] { "ACTIVE: Lee Sin dashes to a target ally. If the ally is a champion, they and Lee Sin receive a shield that lasts 4 seconds and Safeguard's cooldown is halved. Lee Sin can activate Safeguard on himself to receive the shield, and can cast Iron Will within 3 seconds of using Safeguard." });
		leeSinSpells[4] = new SpellInfo("Iron Will", "", "", "30 ENERGY",
				new String[] { "LIFE STEAL / SPELL VAMP: 5 / 10 / 15 / 20 / 25%" },
				new String[] { "ACTIVE: For 4 seconds, Lee Sin gains bonus life steal and spell vamp." });
		leeSinSpells[5] = new SpellInfo(
				"Tempest",
				"650",
				"10",
				"50 ENERGY",
				new String[] { "MAGIC DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 100% bonus AD)" },
				new String[] { "ACTIVE: Lee Sin smashes the ground, dealing magic damage to all nearby enemies and granting true sight of them for 4 seconds. If Tempest hits an enemy, Lee Sin can cast Cripple within the next 3 seconds." });
		leeSinSpells[6] = new SpellInfo(
				"Cripple",
				"500",
				"",
				"30 ENERGY",
				new String[] { "SLOW: 20 / 30 / 40 / 50 / 60%" },
				new String[] { "ACTIVE: Lee Sin cripples all enemies within range that are marked by Tempest, reducing their movement and attack speed. The movement and attack speed recover over 4 seconds." });
		leeSinSpells[7] = new SpellInfo(
				"Dragon's Rage",
				"375",
				"90 / 75 / 60",
				"NO COST",
				new String[] { "PHYSICAL DAMAGE: 200 / 400 / 600 (+ 200% bonus AD)" },
				new String[] { "ACTIVE: Lee Sin launches a powerful roundhouse kick, dealing physical damage to a target champion and knocking it back 1200 units over 1 second. Enemies the target collides with take the same damage and are knocked airborne for 1 second." });
		champSpells[46] = leeSinSpells;

		SpellInfo[] leonaSpells = new SpellInfo[5];
		leonaSpells[0] = new SpellInfo(
				"Sunlight",
				"",
				"",
				"",
				arrS,
				new String[] { "Leona's spells charge any enemy unit damaged with Sunlight for 3.5 seconds. When allied champions deal any damage to those targets they consume the Sunlight debuff to deal 20 / 35 / 50 / 65 / 80 / 95 / 110 / 125 / 140 additional magic damage. This additional damage is counted as the ally's damage and it will benefit from their magic penetration. Leona is unable to activate the additional damage herself." });
		leonaSpells[1] = new SpellInfo(
				"Shield of Daybreak",
				"",
				"11 / 10 / 9 / 8 / 7",
				"45 / 50 / 55 / 60 / 65 MANA",
				new String[] { "MAGIC DAMAGE: 40 / 70 / 100 / 130 / 160 (+ 30% AP)" },
				new String[] {
						"ACTIVE: Leona's next basic attack will be a shield slam, dealing additional magic damage and stunning the target for 1.25 seconds.",
						"Aditionally, increases Leona's basic attack range by 30 (to 155) while the effect is active." });
		leonaSpells[2] = new SpellInfo(
				"Eclipse",
				"",
				"14",
				"60 MANA",
				new String[] { "ARMOR: 20 / 30 / 40 / 50 / 60 (+ 20% bonus armor)",
						"MAGIC RESISTANCE: 20 / 30 / 40 / 50 / 60 (+20% bonus magic resistance)",
						"MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 40% AP)" },
				new String[] { "ACTIVE: Leona surrounds herself with a shield of sunlight, gaining bonus armor and magic resistance for 3 seconds. When the effect ends the shield bursts, dealing magic damage to enemies within 275 range of her. If Eclipse damages any enemies, the bonuses remain for an additional 3 seconds." });
		leonaSpells[3] = new SpellInfo(
				"Zenith Blade",
				"875",
				"13 / 12 / 11 / 10 / 9",
				"60 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 100 / 140 / 180 / 220 (+ 40% AP)" },
				new String[] { "ACTIVE: Leona projects a solar image of her sword, dealing magic damage to all enemies in a line. Leona will dash to the last enemy champion struck, briefly immobilizing them as she travels." });
		leonaSpells[4] = new SpellInfo(
				"Solar Flare",
				"1200",
				"90 / 75 / 60",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 80% AP)" },
				new String[] {
						"ACTIVE: Leona calls down a beam of solar energy to a target location. After a 0.625 delay, it deals magic damage to all enemies within 250 range and slows them by 80% for 1.5 seconds. Enemies within 100 range are stunned for 1.5 seconds instead of slowed.",
						"For the duration, the beam also grants vision in a radius of 350." });
		champSpells[47] = leonaSpells;

		SpellInfo[] lissandraSpells = new SpellInfo[5];
		lissandraSpells[0] = new SpellInfo(
				"Iceborn",
				"",
				"18",
				"",
				arrS,
				new String[] { "Every 18 seconds, Lissandra's next ability costs no mana. Cooldown reduction does not affect Iceborn, but the cooldown is reduced by 1 second whenever Lissandra impairs an enemy's movement with an ability (does not apply to movement-impairing effects from items)." });
		lissandraSpells[1] = new SpellInfo(
				"Ice Shard",
				"725",
				"6 / 5.5 / 5 / 4.5 / 4",
				"85 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 110 / 145 / 180 / 215 (+ 65% AP)",
						"SLOW PERCENT: 16 / 19 / 22 / 25 / 28%" },
				new String[] { "ACTIVE: Throws a spear of ice that travels in a line and shatters when it hits an enemy, dealing magic damage and slowing its movement speed for 1.5 seconds. Shards then pass through the target, dealing the same damage to other enemies hit (but not slowing them)." });
		lissandraSpells[2] = new SpellInfo(
				"Ring of Frost",
				"450",
				"14 / 13 / 12 / 11 / 10",
				"50 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 110 / 150 / 190 / 230 (+ 60% AP)",
						"ROOT DURATION: 1.1 / 1.2 / 1.3 / 1.4 / 1.5" },
				new String[] { "ACTIVE: Freezes an area around Lissandra, dealing magic damage to nearby enemies and rooting them for a short time." });
		lissandraSpells[3] = new SpellInfo(
				"Glacial Path",
				"1050",
				"24 / 21 / 18 / 15 / 12",
				"80 / 85 / 90 / 95 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Casts a claw of ice that moves forward in a line, dealing magic damage to all enemies hit. Reactivating this ability transports Lissandra to the claw's current location.",
						"Projectile Speed: 850" });
		lissandraSpells[4] = new SpellInfo(
				"Frozen Tomb",
				"550",
				"130 / 105 / 80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 70% AP)", "SLOW: 20 / 30 / 40%" },
				new String[] {
						"ACTIVE - ENEMY CAST: Freezes target champion solid, dealing magic damage and stunning it for 1.5 seconds.",
						"ACTIVE - SELF CAST: Lissandra encases herself in a glacier for 2.5 seconds, becoming untargetable and invulnerable but unable to take any actions.",
						"Dark ice then spreads from Lissandra's target dealing magic damage to all enemies in the area as it expands. The ice lasts for 3 seconds and slows enemy Movement Speed." });
		champSpells[48] = lissandraSpells;

		SpellInfo[] lucianSpells = new SpellInfo[5];
		lucianSpells[0] = new SpellInfo(
				"Lightslinger",
				"",
				"",
				"",
				arrS,
				new String[] { "After using an ability, Lucian's next auto attack within 6 seconds will strike twice. The second shot deals 50-75% of Lucian's AD (based on level), but fully applies on-hit effects. Minions and monsters take full damage from the second shot. The second shot can critically strike. If the target is killed before the second shot can go off, the second shot will automatically shoot at something else." });
		lucianSpells[1] = new SpellInfo(
				"Piercing Light",
				"550",
				"9 / 8 / 7 / 6 / 5",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "PHYSICAL DAMAGE: 80 / 110 / 140 / 170 / 200 (+ 60 / 75 / 90 / 105 / 120% bonus AD)" },
				new String[] { "ACTIVE: After a 0.35 second delay, Lucian fires a laser in the direction of the target enemy, dealing physical damage to all enemies in a 1100-unit line. Minions take 75% damage." });
		lucianSpells[2] = new SpellInfo(
				"Ardent Blaze",
				"1000",
				"14 / 13 / 12 / 11 / 10",
				"60 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 100 / 140 / 180 / 220 (+ 90% AP) (+ 60% bonus AD)" },
				new String[] {
						"ACTIVE: Lucian fires a shot that explodes in a cross pattern upon hitting an enemy or reaching the end of its path, dealing magic damage and marking enemies hit for 6 seconds.",
						"If Lucian damages a marked target with his basic attacks or abilities, he gains 40 movement speed for 2 seconds. This does not consume the mark." });
		lucianSpells[3] = new SpellInfo(
				"Relentless Pursuit",
				"425",
				"18 / 16 / 14 / 12 / 10",
				"60 / 45 / 30 / 15 / 0 MANA",
				arrS,
				new String[] { "ACTIVE: Lucian dashes a short distance and removes all slowing effects. Relentless Pursuit's cooldown resets if Lucian scores a kill during the Culling." });
		lucianSpells[4] = new SpellInfo(
				"The Culling",
				"1400",
				"100 / 75 / 50",
				"100 MANA",
				new String[] { "PHYSICAL DAMAGE PER SHOT: 40 / 50 / 60 (+25% bonus AD) (+10% AP)",
						"SHOTS FIRED: 7.5 + (7.5 / 9 / 10.5  × attack speed at the time of cast)",
						"MAXIMUM SHOTS: 26 / 30 / 33",
						"MAXIMUM TOTAL DAMAGE: 1040 / 1500 / 1980 (+650 / 750 / 825% bonus AD) (+260 / 300 / 330% AP)" },
				new String[] {
						"ACTIVE: Lucian starts firing shots in the target direction for 3 seconds, each shot dealing physical damage to the first enemy it hits. The number of shots fired scales with his attack speed. The Culling deals quadruple damage to minions but not monsters.",
						"While using the Culling, Lucian's basic attacks are disabled and he cannot activate Piercing Light or Ardent Blaze. He can, however, move freely and activate Relentless Pursuit",
						"The Culling can be reactivated to end the effect early and it is interrupted by crowd control effects that inhibit basic attacks." });
		champSpells[49] = lucianSpells;

		SpellInfo[] luluSpells = new SpellInfo[5];
		luluSpells[0] = new SpellInfo(
				"Pix, Faerie Companion",
				"",
				"",
				"",
				arrS,
				new String[] { "Whenever Lulu or the allied target of Help, Pix! attacks an enemy (excluding structures and wards), Pix fires a barrage of 3 homing bolts toward the same target that deal 3 / 7 / 11 / 15 / 19 / 23 / 27 / 31 / 35 (+ 5% AP) magic damage each to the first enemy they each hit." });
		luluSpells[1] = new SpellInfo(
				"Glitterlance",
				"925",
				"7",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 50% AP)",
						"SLOW DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "ACTIVE: Lulu and Pix each fire a magic bolt towards a target direction, dealing magic damage and slowing enemies hit by 80% for a short time. This slow decreases to 0% (+13.3% per 100 AP) over its duration, to a maximum of 80%. An enemy can only be affected by one bolt." });
		luluSpells[2] = new SpellInfo(
				"Whimsy",
				"650",
				"18 / 16.5 / 15 / 13.5 / 12",
				"65 / 70 / 75 / 80 / 85 MANA",
				new String[] { "POLYMORPH DURATION: 1.5 / 1.75 / 2 / 2.25 / 2.5" },
				new String[] {
						"ACTIVE - ON ALLY CAST: Target allied champion gains 30% (+ 10% per 100 AP) movement speed for 5 seconds.",
						"ACTIVE - ON ENEMY CAST: Polymorphs an enemy champion for a short duration, disabling their ability to attack or cast abilities and reducing their base movement speed by 60." });
		luluSpells[3] = new SpellInfo(
				"Help, Pix!",
				"650",
				"10",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "SHIELD STRENGTH: 80 / 120 / 160 / 200 / 240 (+ 60% AP)",
						"MAGIC DAMAGE: 80 / 110 / 140 / 170 / 200 (+ 40% AP)" },
				new String[] {
						"ACTIVE - ON ALLY CAST: Commands Pix to jump to an ally. If the ally is a champion, they will receive a shield that lasts for up to 6 seconds. Additionally, Pix will then follow the ally and aid their attacks instead of Lulu's for 6 seconds.",
						"ACTIVE - ON ENEMY CAST: Pix deals magic damage to target enemy unit. Pix then follows and grants vision of them for 4 seconds." });
		luluSpells[4] = new SpellInfo(
				"Wild Growth",
				"900",
				"110 / 95 / 80",
				"100 MANA",
				new String[] { "BONUS HEALTH: 300 / 450 / 600 (+ 50% AP)", "AURA SLOW: 30 / 45 / 60%" },
				new String[] { "ACTIVE: Lulu enlarges a target allied champion, knocking up enemies within 150 range of the target. For 7 seconds, her ally gains bonus health and an aura that continually slows nearby enemies." });
		champSpells[50] = luluSpells;

		SpellInfo[] luxSpells = new SpellInfo[5];
		luxSpells[0] = new SpellInfo(
				"Illumination",
				"",
				"",
				"",
				arrS,
				new String[] { "Lux's damaging spells mark any enemies with light energy for 6 seconds. Her autoattacks or Final Spark will consume the mark, dealing 10 + (10 × level) magic damage to the target." });
		luxSpells[1] = new SpellInfo(
				"Light Binding",
				"1175",
				"15 / 14 / 13 / 12 / 11",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 70% AP)",
						"SECOND TARGET MAGIC DAMAGE: 30 / 55 / 80 / 105 / 130 (+ 35% AP)" },
				new String[] { "ACTIVE: Lux releases a sphere of light in a line, striking up to two enemy units along its path. It deals magic damage to the first enemy it touches and half that damage to a second enemy behind it. Additionally, the first enemy struck is rooted for 2 seconds, and the second enemy is rooted for 1 second." });
		luxSpells[2] = new SpellInfo(
				"Prismatic Barrier",
				"1075",
				"14 / 13 / 12 / 11 / 10",
				"60 MANA",
				new String[] { "SHIELD STRENGTH: 80 / 105 / 130 / 155 / 180 (+ 35% AP)" },
				new String[] { "ACTIVE: Lux shields herself for up to 3 seconds and throws out her wand in a line, applying the same shield to allied champions in its path. Her wand then returns to her, again shielding allied champions in its path and Lux herself upon return. When reapplied, the shield does not stack, but is refreshed." });
		luxSpells[3] = new SpellInfo(
				"Lucent Singularity",
				"1100",
				"10",
				"70 / 85 / 100 / 115 / 130 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 60% AP)", "SLOW: 20 / 24 / 28 / 32 / 36%" },
				new String[] { "ACTIVE: Lux sends an anomaly of twisted light to a target area, slowing enemies within 300 range and granting sight of a slightly larger area for up to 5 seconds. At the end of the duration or if Lucent Singularity is activated again, the zone will detonate and deal magic damage to enemies in the area." });
		luxSpells[4] = new SpellInfo(
				"Final Spark",
				"3340",
				"80 / 65 / 50",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 300 / 400 / 500 (+ 75% AP)" },
				new String[] {
						"ACTIVE: After gathering energy for half a second, Lux fires a broad and long-range beam of light in a line that deals magic damage to all enemies in the area.",
						"Any enemies that are already marked by Illumination have it ignited for additional magic damage, then re-applied." });
		champSpells[51] = luxSpells;

		SpellInfo[] malphiteSpells = new SpellInfo[5];
		malphiteSpells[0] = new SpellInfo(
				"Granite Shield",
				"",
				"",
				"",
				arrS,
				new String[] { "Malphite's skin produces a layer of rock as a shield which absorbs damage equal to 10% of his maximum health. The shield will refresh if Malphite has not received damage in the last 10 seconds" });
		malphiteSpells[1] = new SpellInfo(
				"Seismic Shard",
				"625",
				"8",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 120 / 170 / 220 / 270 (+ 60% AP)",
						"MOVEMENT SPEED STOLEN: 14 / 17 / 20 / 23 / 26%" },
				new String[] {
						"ACTIVE: Malphite sends a shard of the earth through the ground at his target, dealing magic damage upon impact and slowing them for 4 seconds. ",
						"Additionally, Malphite will increase his own movement speed for 4 seconds by the same amount of flat movement speed that the target lost." });
		malphiteSpells[2] = new SpellInfo(
				"Brutal Strikes",
				"",
				"14",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "SPLASH DAMAGE: 30 / 38 / 46 / 54 / 62% AD",
						"ATTACK DAMAGE & ARMOR INCREASE: 20 / 25 / 30 / 35 / 40%" },
				new String[] {
						"PASSIVE: Malphite's basic attacks deal a percentage of his attack damage to enemies within 200 range of the target.",
						"ACTIVE: For 6 seconds, Malphite increases his armor and attack damage by a percentage." });
		malphiteSpells[3] = new SpellInfo(
				"Ground Slam",
				"200",
				"7",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 100 / 140 / 180 / 220 (+ 30% armor) (+ 20% AP)",
						"ATTACK SPEED REDUCTION: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "ACTIVE: Malphite slams the ground, dealing magic damage to enemies within range and reducing their attack speed for 3 seconds." });
		malphiteSpells[4] = new SpellInfo(
				"Unstoppable Force",
				"1000",
				"130 / 115 / 100",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 200 / 300 / 400 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Malphite charges to the target location, and on arrival deals magic damage to enemies within 300 range and knocks them into the air for 1.5 seconds. Malphite cannot be interrupted during his charge by anything except his own death.",
						"MISSILE SPEED: 1500 + Malphite's movement speed at time of cast" });
		champSpells[52] = malphiteSpells;

		SpellInfo[] malzaharSpells = new SpellInfo[5];
		malzaharSpells[0] = new SpellInfo(
				"Summon Voidling",
				"",
				"",
				"",
				arrS,
				new String[] {
						"PASSIVE: On every fourth ability use, Malzahar summons a voidling that remains on the field until it is killed, Malzahar is killed, or 21 seconds have passed.",
						"After 7 seconds, the voidling grows, gaining 50% increased armor and attack damage. After 14 seconds, the voidling gains increased attack speed." });
		malzaharSpells[1] = new SpellInfo(
				"Call of the Void",
				"900",
				"9",
				"80 / 85 / 90 / 95 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 135 / 190 / 245 / 300 (+ 80% AP)",
						"SILENCE DURATION: 1.4 / 1.8 / 2.2 / 2.6 / 3" },
				new String[] { "ACTIVE: Malzahar opens up two portals to the Void 400 range from each other. After a short delay, power erupts from them, damaging and silencing all enemies caught between the portals." });
		malzaharSpells[2] = new SpellInfo(
				"Null Zone",
				"800",
				"14",
				"90 / 95 / 100 / 105 / 110 MANA",
				new String[] {
						"MAGIC DAMAGE PER SECOND: 4 / 5 / 6 / 7 / 8% (+1% per 100 AP) of enemies' maximum health",
						"MAX DAMAGE: 20 / 25 / 30 / 35 / 40% (+5% per 100 AP) of enemies' maximum health" },
				new String[] { "ACTIVE: Malzahar creates a 250-radius zone of negative energy for 5 seconds. Enemies that stand in the zone take magic damage every second equal to a percentage of their maximum health. Damage to monsters and minions are capped at 120." });
		malzaharSpells[3] = new SpellInfo(
				"Malefic Visions",
				"650",
				"15 / 13 / 11 / 9 / 7",
				"60 / 75 / 90 / 105 / 120 MANA",
				new String[] { "TOTAL MAGIC DAMAGE: 80 / 140 / 200 / 260 / 320 (+ 80% AP)",
						"MANA RESTORED: 10 / 14 / 18 / 22 / 26" },
				new String[] { "ACTIVE: Infects target enemy's mind, dealing magic damage over 4 seconds. If the target dies during this time, the target passes Malefic Visions to the closest enemy, refreshing the duration and restoring mana to Malzahar." });
		malzaharSpells[4] = new SpellInfo(
				"Nether Grasp",
				"700",
				"120 / 100 / 80",
				"150 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 100 / 160 / 220 (+ 52% AP)",
						"MAXIMUM DAMAGE: 250 / 400 / 550 (+ 130% AP)" },
				new String[] { "ACTIVE: Malzahar channels an engulfing void of energy for up to 2.5 seconds, suppressing and dealing magic damage to a target enemy champion while the channel holds." });
		champSpells[53] = malzaharSpells;

		SpellInfo[] maokaiSpells = new SpellInfo[5];
		maokaiSpells[0] = new SpellInfo(
				"Sap Magic",
				"",
				"",
				"",
				arrS,
				new String[] { "PASSIVE: Each time a champion's ability is used near Maokai, he gains a charge of Sap Magic. When he has 5 charges, his next basic attack will heal him for 7% of his maximum health." });
		maokaiSpells[1] = new SpellInfo(
				"Arcane Smash",
				"600",
				"6",
				"55 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 40% AP)", "SLOW: 20 / 27 / 34 / 41 / 48%" },
				new String[] { "ACTIVE: Maokai smashes the ground and sends an arcane shockwave forward, dealing magic damage and slowing enemies hit for 2 seconds. Enemies within 100 range of Maokai are also briefly knocked back." });
		maokaiSpells[2] = new SpellInfo(
				"Twisted Advance",
				"650",
				"13",
				"75 / 80 / 85 / 90 / 95 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 115 / 150 / 185 / 220 (+ 80% AP)",
						"ROOT DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "ACTIVE: Maokai transforms into a cloud of arcane energy, becoming untargetable while quickly travelling to a target enemy. Once Maokai reaches the target, the target takes magic damage and is rooted for a short time." });
		maokaiSpells[3] = new SpellInfo(
				"Sapling Toss",
				"1100",
				"12",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "IMPACT MAGIC DAMAGE: 40 / 75 / 110 / 145 / 180 (+ 40% AP)",
						"EXPLOSION MAGIC DAMAGE: 80 / 130 / 180 / 230 / 280 (+ 60% AP)",
						"MAXIMUM MAGIC DAMAGE: 120 / 205 / 290 / 375 / 460 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Maokai hurls a sapling to a target area, dealing magic damage on impact within 175 range. The sapling becomes implanted in the ground, granting 350 range vision of its surroundings for up to 35 seconds.",
						"After a 1 second delay after landing, the sapling will seek out nearby enemies. When an enemy comes within 250 range, the sapling will chase for up to 2.5 seconds and explode in an arcane blast that deals magic damage to enemies within 175 range." });
		maokaiSpells[4] = new SpellInfo(
				"Vengeful Maelstrom",
				"625",
				"40 / 30 / 20",
				"75 MANA + 30 PER SECOND",
				new String[] {
						"MAGIC DAMAGE: 100 / 150 / 200 (+ 50% AP) (+ 2 bonus damage for every 1 damage absorbed)",
						"MAX STORED DAMAGE: 200 / 250 / 300", "MAX TOTAL DAMAGE: 300 / 400 / 500 (+ 50% AP)" },
				new String[] {
						"TOGGLE: Maokai creates a great vortex of natural energy in a 575 radius area, reducing non-tower damage done to allied champions in the area by 20%. Maokai can prolong the effect as long as he has mana to spend on it.",
						"When the effect ends the energy is released, dealing magic damage to enemies within the vortex, plus bonus magic damage based off the damage stored by the damage reduction effect." });
		champSpells[54] = maokaiSpells;

		SpellInfo[] masterYiSpells = new SpellInfo[5];
		masterYiSpells[0] = new SpellInfo(
				"Double Strike",
				"",
				"",
				"",
				arrS,
				new String[] {
						"Every 4th consecutive autoattack, Master Yi strikes twice. The second attack uses an attack damage modifier of 50%, but applies on-hit effects fully and can critically strike.",
						"Double Strike's counter resets if Master Yi has not autoattacked in the last 4 seconds." });
		masterYiSpells[1] = new SpellInfo(
				"Alpha Strike",
				"600",
				"18 / 17 / 16 / 15 / 14",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "PHYSICAL DAMAGE: 25 / 60 / 95 / 130 / 165 (+ 100% AD)",
						"ADDITIONAL DAMAGE TO MINIONS & MONSTERS: 75 / 100 / 125 / 150 / 175" },
				new String[] {
						"ACTIVE Master Yi becomes untargetable and leaps to strike up to 4 enemies, dealing physical damage to each and dealing additional damage to minions and monsters.",
						"Each bounce will target the nearest enemy that has not yet been damaged. Master Yi re-appears at the initial target's location after the effect ends.",
						"Alpha Strike can critically strike, dealing additional physical damage equal to 60% AD. Basic attacks reduce the cooldown of Alpha Strike by 1 second." });
		masterYiSpells[2] = new SpellInfo(
				"Meditate",
				"",
				"35",
				"50 MANA",
				new String[] { "BASE HEALING PER SECOND: 30 / 50 / 70 / 90 / 110 (+ 30% AP)",
						"MAXIMUM HEALING PER SECOND: 60 / 100 / 140 / 180 / 220 (+ 60% AP)",
						"BASE TOTAL HEAL: 120 / 200 / 280 / 360 / 440 (+ 120% AP)",
						"DAMAGE REDUCTION: 50 / 55 / 60 / 65 / 70%" },
				new String[] {
						"ACTIVE: Master Yi channels for up to 4 seconds, restoring health each second. This healing is increased by 1% for every 1% of his missing health. Meditate also resets the autoattack timer.",
						"While channeling, Master Yi reduces incoming damage. This damage reduction is halved against turrets." });
		masterYiSpells[3] = new SpellInfo(
				"Wuju Style",
				"",
				"18 / 17 / 16 / 15 / 14",
				"NO COST",
				new String[] { "BONUS TRUE DAMAGE: 10 / 15 / 20 / 25 / 30 (+10 / 12.5 / 15 / 17.5 / 20% AD)" },
				new String[] {
						"PASSIVE: Master Yi gains 10% of his total AD as bonus attack damage.",
						"ACTIVE: Autoattacks deal bonus true damage for 5 seconds. Afterwards, the passive bonus is lost until Wuju Style is off cooldown." });
		masterYiSpells[4] = new SpellInfo(
				"Highlander",
				"",
				"75",
				"100 MANA",
				new String[] { "MOVEMENT SPEED: 25 / 35 / 45%", "ATTACK SPEED: 30 / 55 / 80%" },
				new String[] {
						"PASSIVE: Champion kills and assists reduce the remaining cooldown of Master Yi's other abilities by 70%.",
						"ACTIVE: For 10 seconds, Master Yi gains increased movement speed and attack speed, and becomes immune to all slowing effects. While active, champion kills and assists extend the duration of Highlander by 4 seconds." });
		champSpells[55] = masterYiSpells;

		SpellInfo[] missFortuneSpells = new SpellInfo[5];
		missFortuneSpells[0] = new SpellInfo(
				"Strut",
				"",
				"",
				"",
				arrS,
				new String[] { "INNATE: Miss Fortune gains 25 movement speed after not taking damage for 5 seconds, which gradually increases to 70 movement speed over 5 secon" });
		missFortuneSpells[1] = new SpellInfo(
				"Double Up",
				"650",
				"7 / 6 / 5 / 4 / 3",
				"43 / 46 / 49 / 52 / 55 MANA",
				new String[] { "FIRST TARGET PHYSICAL DAMAGE: 20 / 35 / 50 / 65 / 80 (+ 85% AD)",
						"SECOND TARGET PHYSICAL DAMAGE: 40 / 70 / 100 / 130 / 160 (+ 100% AD)" },
				new String[] { "ACTIVE: Miss Fortune fires a shot through an enemy to hit an enemy behind them, dealing physical damage to the first target and increased physical damage to the second, applying on-hit effects to both." });
		missFortuneSpells[2] = new SpellInfo(
				"Impure Shots",
				"",
				"16",
				"30 / 35 / 40 / 45 / 50 MANA",
				new String[] { "ATTACK SPEED: 20 / 30 / 40 / 50 / 60%" },
				new String[] {
						"PASSIVE: Miss Fortune's autoattacks deal 6% AD bonus magic damage, stacking cumulatively up to 5 times, for a maximum of 30% AD bonus magic damage. The stack limit increases by 1 for each rank on Bullet Time, for a maximum of 36 / 42 / 48 % AD bonus magic damage.",
						"ACTIVE: Miss Fortune gains bonus attack speed for 6 seconds and her autoattacks also apply Grievous Wounds for 2 seconds." });
		missFortuneSpells[3] = new SpellInfo(
				"Make it Rain",
				"800",
				"14 / 13 / 12 / 11 / 10",
				"80 MANA",
				new String[] { "TOTAL MAGIC DAMAGE: 90 / 145 / 200 / 255 / 310 (+ 80% AP)",
						"SLOW: 25 / 35 / 45 / 55 / 65%" },
				new String[] { "ACTIVE: Miss Fortune rains hundreds of bullets down onto target 100-radius area. This area lasts for 3 seconds, slowing and dealing magic damage every quarter of a second to enemies within." });
		missFortuneSpells[4] = new SpellInfo(
				"Bullet Time",
				"1400",
				"14 / 13 / 12 / 11 / 10",
				"100 MANA",
				new String[] { "NEW STACK LIMIT: 6 / 7 / 8", "PHYSICAL DAMAGE PER WAVE: 50 / 75 / 125 (+ 20% AP)",
						"MAX PHYSICAL DAMAGE: 400 / 600 / 1000 (+ 160% AP)" },
				new String[] {
						"PASSIVE: The stack limit for  Impure Shots is increased.",
						"ACTIVE: Miss Fortune channels for 2 seconds, spraying up to 8 waves of bullets (6 bullets per wave) in a cone in front of her. A wave is fired every quarter of a second, dealing physical damage and applying Impure Shots' passive magic damage and stack to all enemies within the area." });
		champSpells[56] = missFortuneSpells;

		SpellInfo[] mordekaiserSpells = new SpellInfo[5];
		mordekaiserSpells[0] = new SpellInfo(
				"Iron Man",
				"",
				"",
				"",
				arrS,
				new String[] { "35% of the damage dealt from abilities is converted into a temporary absorption shield. Shield generation is only half as effective against minions and monsters. Maximum shield strength is 90 + (30 × (level)). The shield decays by 3% per second." });
		mordekaiserSpells[1] = new SpellInfo(
				"Mace of Spades",
				"600",
				"8 / 7 / 6 / 5 / 4",
				"25 / 32 / 39 / 46 / 53 HEALTH",
				new String[] { "MAGIC DAMAGE: 80 / 110 / 140 / 170 / 200 (+ 40% AP) (+ 100% Bonus AD)",
						"SINGLE TARGET MAGIC DAMAGE: 132 / 181.5 / 231 / 280.5 / 330 (+ 66% AP) (+ 165% Bonus AD)" },
				new String[] {
						"ACTIVE: Mordekaiser enhances his next attack, converting it to deal magic damage and replacing the base attack damage component with a base amount of damage. He swings his mace with such force that it echoes out, striking up to 3 additional nearby targets.",
						"If the target is alone, the ability deals 65% more damage." });
		mordekaiserSpells[2] = new SpellInfo(
				"Creeping Death",
				"750",
				"20 / 18 / 16 / 14 / 12",
				"26 / 32 / 38 / 44 / 50 HEALTH",
				new String[] { "MAGIC DAMAGE PER SECOND: 24 / 38 / 52 / 66 / 80 (+ 20% AP)",
						"MAX MAGIC DAMAGE: 144 / 228 / 312 / 396 / 480 (+ 120% AP)",
						"ARMOR / MAGIC RESIST: 10 / 15 / 20 / 25 / 30" },
				new String[] { "ACTIVE: Mordekaiser creates a protective cloud of metal shards to surround an ally unit or himself for 6 seconds, increasing the target's armor and magic resistance and damaging enemies within 250 range." });
		mordekaiserSpells[3] = new SpellInfo(
				"Siphon of Destruction",
				"700",
				"6",
				"24 / 36 / 48 / 60 / 72 HEALTH",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 60% AP)" },
				new String[] { "ACTIVE: Mordekaiser afflicts all enemies in a cone in front of him, dealing magic damage." });
		mordekaiserSpells[4] = new SpellInfo(
				"Children of the Grave",
				"850",
				"120 / 105 /90 ",
				"NO COST",
				new String[] { "INITIAL MAGIC DAMAGE: 12 / 14.5 / 17% (+ 2% per 100 AP) of target's maximum health",
						"MAGIC DAMAGE PER SECOND: 1.2 / 1.45 / 1.7% (+ 0.2% per 100 AP) of target's maximum health",
						"TOTAL MAGIC DAMAGE: 24 / 29 / 34% (+ 4% per 100 AP) of target's maximum health",
						"LEASH RANGE: 1125" },
				new String[] {
						"ACTIVE: Mordekaiser deals magic damage to a target enemy champion and curses it for 10 seconds, dealing additional magic damage over time and healing himself for the damage done.",
						"If the target dies while under the effect of the curse, their soul is enslaved as a controllable ghost and will follow Mordekaiser for 30 seconds. The Ghost cannot use any active skills or items and deals magic damage with its basic attacks.",
						"The Ghost's stats are:",
						"HEALTH: The enslaved champion's total health plus 15% of Mordekaiser's total Health",
						"ATTACK DAMAGE: The enslaved champion's base AD at Lv. 1 plus its bonus AD from items and 75% of Mordekaiser's total AD",
						"ABILITY POWER: The enslaved champion's AP plus 75% of Mordekaiser's AP",
						"MOVEMENT SPEED: The enslaved champion's base movement speed plus the bonus from Mordekaiser's boots.",
						"During this time, Mordekaiser gains 20% of the enslaved champion's total AP and AD. This bonus does not affect the ghost's stats." });
		champSpells[57] = mordekaiserSpells;

		SpellInfo[] morganaSpells = new SpellInfo[5];
		morganaSpells[0] = new SpellInfo("Soul Siphon", "", "", "", arrS,
				new String[] { "Morgana is granted 10% / 15% / 20% bonus spell vamp." });
		morganaSpells[1] = new SpellInfo(
				"Dark Binding",
				"1300",
				"11",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 135 / 190 / 245 / 300 (+ 90% AP)",
						"ROOT DURATION: 2 / 2.25 / 2.5 / 2.75 / 3" },
				new String[] { "ACTIVE: Morgana releases a sphere of dark magic that travels in a line, dealing magic damage and rooting the first enemy unit it hits for a short time." });
		morganaSpells[2] = new SpellInfo(
				"Tormented Soil",
				"900",
				"10",
				"70 / 85 / 100 / 115 / 130 MANA",
				new String[] { "MINIMUM DAMAGE PER HALF SECOND: 12 / 19 / 26 / 33 / 40 (+11% AP)",
						"MAXIMUM DAMAGE PER HALF SECOND: 18 / 28.5 / 39 / 49.5 / 60 (+16.5% AP)",
						"MINIMUM TOTAL DAMAGE: 120 / 190 / 260 / 330 / 400 (+ 110% AP)",
						"MAXIMUM TOTAL DAMAGE: 180 / 285 / 390 / 495 / 600 (+ 165% AP)" },
				new String[] { "ACTIVE: Morgana infects target 175-radius area for 5 seconds, causing enemy units who stand on the location to take magic damage every half second. The damage is increased by 0.5% for every 1% of the target's missing health." });
		morganaSpells[3] = new SpellInfo(
				"Black Shield",
				"750",
				"23 / 21 / 19 / 17 / 15",
				"55 MANA",
				new String[] { "SHIELD STRENGTH: 95 / 160 / 225 / 290 / 355 (+ 70% AP)" },
				new String[] { "ACTIVE: Places a shield around target friendly champion for up to 5 seconds, absorbing magic damage and preventing disables while the shield holds." });
		morganaSpells[4] = new SpellInfo(
				"Soul Shackles",
				"600",
				"120 / 110 / 100",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 175 / 250 / 325 (+ 70% AP)",
						"TOTAL MAGIC DAMAGE PER TARGET: 350 / 500 / 650 (+ 140% AP)" },
				new String[] {
						"ACTIVE: Morgana latches chains of energy onto nearby enemy champions for 3 seconds, dealing initial magic damage to them after a brief delay of 0.5 seconds and reducing their movement speed by 20% if the target(s) stay within 1050 range.",
						"If the target(s) does not break the tether after 3 seconds, they are dealt the same amount of magic damage again and they are also stunned for 1.5 seconds." });
		champSpells[58] = morganaSpells;

		SpellInfo[] namiSpells = new SpellInfo[5];
		namiSpells[0] = new SpellInfo(
				"Surging Tides",
				"",
				"",
				"",
				arrS,
				new String[] { "When Nami's abilities hit allied champions they gain 40 (+ 10% AP) movement speed for 1.5 seconds." });
		namiSpells[1] = new SpellInfo(
				"Aqua Prison",
				"875",
				"14 / 13 / 12 / 11 / 10",
				"60 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 130 / 185 / 240 / 295 (+ 50% AP)" },
				new String[] { "ACTIVE: Nami sends a bubble into the air towards a targeted area. When it lands, it deals magic damage to all enemies in the area of impact and suspends them for 1.5 seconds." });
		namiSpells[2] = new SpellInfo(
				"Edd and Flow",
				"725",
				"9",
				"70 / 85 / 100 / 115 / 130 MANA",
				new String[] { "HEAL: 65 / 95 / 125 / 155 / 185 (+ 30% AP)",
						"MAGIC DAMAGE: 70 / 110 / 150 / 190 / 230 (+ 50% AP)" },
				new String[] {
						"ACTIVE: Nami unleashes a stream of water that bounces between allied and enemy champions. This ability can only bounce to each target once and hits up to 3 targets. The damage is modified by -15% + (7.5% per 100 AP) with each bounce.",
						"On ally hits, Ebb and Flow heals the target and bounces towards a nearby enemy champion. On enemy hits, the torrent deals magic damage and bounces towards a nearby allied champion." });
		namiSpells[3] = new SpellInfo(
				"Tidecaller's Blessing",
				"800",
				"11",
				"55 / 60 / 65 / 70 / 75 MANA",
				new String[] { "ON-HIT MAGIC DAMAGE: 25 / 40 / 55 / 70 / 85 (+ 20% AP)",
						"TOTAL MAGIC DAMAGE: 75 / 120 / 165 / 210 / 255 (+ 60% AP)",
						"SLOW: 15 / 20 / 25 / 30 / 35% (+ 5% per 100 AP)" },
				new String[] { "ACTIVE: Empowers an allied champion for 6 seconds or until they have attacked 3 times. During this time, their basic attacks deal bonus magic damage and slow the target hit for 1 second." });
		namiSpells[4] = new SpellInfo(
				"Tidal Wave",
				"2750",
				"120 / 110 / 100",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 60% AP)", "SLOW: 50 / 60 / 70%" },
				new String[] { "ACTIVE: Summons a tidal wave that moves outward in a broad line and deals magic damage to enemies it comes into contact with, briefly knocking them up and then slowing them. The slow duration increases based on how far the tidal wave has traveled, with a minimum duration of 2 seconds and a maximum duration of 4 seconds." });
		champSpells[59] = namiSpells;

		SpellInfo[] nasusSpells = new SpellInfo[5];
		nasusSpells[0] = new SpellInfo(
				"Soul Eater",
				"",
				"",
				"",
				arrS,
				new String[] { "Nasus drains his foe's spiritual energy, giving him a natural 10 / 15 / 20% life steal." });
		nasusSpells[1] = new SpellInfo(
				"Siphoning Strike",
				"",
				"8 / 7 / 6 / 5 / 4",
				"20 MANA",
				new String[] { "BONUS DAMAGE: 30 / 50 / 70 / 90 / 110 (+1 per stack of Siphoning Strike)" },
				new String[] {
						"ACTIVE: Nasus' next attack within the next 10 seconds will deal bonus physical damage. Siphoning Strike resets the autoattack timer.",
						"If the attack kills its target, Nasus gains 3 stacks of Siphoning Strike. The number of stacks gained is doubled for killing champions, large minions and large monsters. Siphoning Strike's bonus damage is increased by an amount equal to his current stacks." });
		nasusSpells[2] = new SpellInfo(
				"Wither",
				"600",
				"15 / 14 / 13 / 12 / 11",
				"80 MANA",
				new String[] { "ADDITIONAL MOVEMENT SLOW PER SECOND: 3 / 6 / 9 / 12 / 15%",
						"MAX MOVEMENT SPEED SLOW: 47 / 59 / 71 / 83 / 95%",
						"ADDITIONAL ATTACK SPEED SLOW PER SECOND: 1.5 / 3 / 4.5 / 6 / 7.5%",
						"MAX ATTACK SPEED SLOW: 23.5 / 29.5 / 35.5 / 41.5 / 47.5%" },
				new String[] {
						"ACTIVE: Nasus ages his target, slowing their movement speed by 35% for 5 seconds. The slow increases over the duration. The target's attack speed is also slowed by half the amount, initially slowed by 17.5% and increasing over the duration.",
						"If the duration of Wither is reduced by crowd control reduction, the increasing slow is applied faster so that it reaches the same max amount at the end." });
		nasusSpells[3] = new SpellInfo(
				"Spirit Fire",
				"650",
				"12",
				"70 / 85 / 100 / 115 / 130 MANA",
				new String[] { "INITIAL MAGIC DAMAGE: 55 / 95 / 135 / 175 / 215 (+ 60% AP)",
						"MAGIC DAMAGE PER SECOND: 11 / 19 / 27 / 35 / 43 (+ 12% AP)",
						"TOTAL MAGIC DAMAGE: 110 / 190 / 270 / 350 / 430 (+ 120% AP)",
						"ARMOR REDUCTION: 20 / 25 / 30 / 35 / 40" },
				new String[] { "ACTIVE: Nasus unleashes a spirit flame at a target 400-radius area, dealing magic damage to enemies caught within. The spirit flame burns for 5 seconds afterwards, dealing magic damage each second and reducing the armor of enemies within the area." });
		nasusSpells[4] = new SpellInfo(
				"Fury of the Sands",
				"",
				"120",
				"100 MANA",
				new String[] { "BONUS HEALTH: 300 / 450 / 600",
						"MAGIC DAMAGE PER SECOND: 3 / 4 / 5% (+ 1% per 100 AP) of enemies' maximum health",
						"TOTAL MAGIC DAMAGE: 45 / 60 / 75% (+ 15% per 100 AP) of enemies' maximum health" },
				new String[] {
						"ACTIVE: Nasus summons a sandstorm to empower himself for 15 seconds, enlarging his size, gaining bonus health and increasing his attack range by 50.",
						"While the storm rages, enemies within 175 range take magic damage equal to a percentage of their maximum health (max of 240 magic damage per second per enemy). Nasus converts 6.375% of the damage done by the sandstorm into bonus attack damage for himself. The maximum bonus attack damage that can be gained is 300." });
		champSpells[60] = nasusSpells;

		SpellInfo[] nautilusSpells = new SpellInfo[5];
		nautilusSpells[0] = new SpellInfo(
				"Staggering Blow",
				"",
				"",
				"",
				arrS,
				new String[] { "Nautilus's basic attacks deal an additional 2 + (6 × level) physical damage and root his target for 0.5 / 0.75 / 1 / 1.25 / 1.5 seconds. This effect cannot trigger on the same target more than once every 12 seconds." });
		nautilusSpells[1] = new SpellInfo(
				"Dredge Line",
				"1100",
				"18 / 16 / 14 / 12 / 10",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 75% AP)" },
				new String[] { "ACTIVE: Nautilus hurls his anchor forward in a line. If it hits an enemy unit, Nautilus drags himself and the unit together, dealing magic damage and briefly stunning the enemy. If the anchor hits terrain, Nautilus will drag himself forward and the cooldown is reduced by 50%." });
		nautilusSpells[2] = new SpellInfo(
				"Titan's Wrath",
				"",
				"18",
				"80 MANA",
				new String[] { "SHIELD STRENGTH: 100 / 150 / 200 / 250 / 300 (+ 15% bonus health)",
						"MAGIC DAMAGE: 40 / 55 / 70 / 85 / 100 (+ 40% AP)" },
				new String[] { "ACTIVE: Nautilus gains a shield that absorbs a certain amount of damage. The shield dissipates after 10 seconds if not already destroyed. While the shield persists, Nautilus's basic attacks are enhanced to debuff all enemies within 175 range of his target, dealing bonus magic damage over 2 seconds. Titan's Wrath also resets Nautilus' basic attack timer when first used." });
		nautilusSpells[3] = new SpellInfo(
				"Riptide",
				"600",
				"10",
				"",
				new String[] { "MAGIC DAMAGE PER WAVE: 60 / 100 / 140 / 180 / 220 (+ 50% AP)",
						"MAXIMUM MAGIC DAMAGE: 120 / 200 / 280 / 360 / 440 (+ 100% AP)",
						"SLOW: 30 / 35 / 40 / 45 / 50%" },
				new String[] {
						"ACTIVE: Nautilus slams the ground, causing the earth to explode around him in 3 waves. Each explosion deals magic damage to enemies in the area and slows them for 2 seconds. This slow diminishes over time.",
						"An enemy can be hit by more than one explosion, but take 50% reduced damage after the first." });
		nautilusSpells[4] = new SpellInfo(
				"Depth Charge",
				"825",
				"140 / 110 / 80",
				"100 MANA",
				new String[] { "PASSTHROUGH MAGIC DAMAGE: 125 / 175 / 225 (+ 40% AP)",
						"EXPLOSION MAGIC DAMAGE: 200 / 325 / 450 (+ 80% AP)", "STUN DURATION: 1 / 1.5 / 2" },
				new String[] {
						"ACTIVE: Nautilus fires a shockwave that chases a target enemy champion, dealing magic damage and knocking up enemies it passes through.",
						"The shockwave explodes upon hitting its target, dealing magic damage, knocking them up for 1 second and stunning the target." });
		champSpells[61] = nautilusSpells;

		SpellInfo[] nidaleeSpells = new SpellInfo[8];
		nidaleeSpells[0] = new SpellInfo(
				"Prowl",
				"",
				"",
				"",
				arrS,
				new String[] { "Moving through brush increases Nidalee's movement speed by 15%. The buff lasts for an additional 2 seconds after leaving brush." });
		nidaleeSpells[1] = new SpellInfo(
				"Javelin Toss",
				"1500",
				"6",
				"",
				new String[] { "MINIMUM MAGIC DAMAGE: 55 / 95 / 140 / 185 / 230 (+ 65% AP)",
						"MAXIMUM MAGIC DAMAGE: 137 / 237 / 350 / 462 / 575 (+ 162.5% AP" },
				new String[] {
						"ACTIVE: Nidalee hurls her javelin forward in a line, dealing magic damage to the first enemy it hits. After having traveled 525 units, the javelin's damage will start rapidly increasing. The damage modifier is capped at 250% at maximum range.",
						"PROJECTILE SPEED: 1300" });
		nidaleeSpells[2] = new SpellInfo(
				"Takedown",
				"",
				"5",
				"",
				new String[] { "Takedown scales with ranks in Aspect of the Cougar.",
						"BASE PHYSICAL DAMAGE: 40 / 70 / 100 (+ 100% AD)",
						"MAXIMUM PHYSICAL DAMAGE: 120 / 210 / 300 (+ 300% AD)" },
				new String[] { "ACTIVE: Nidalee's next attack will be enhanced to deal additional physical damage. The bonus damage and the attack's own damage are both increased by 2% for every 1% of the target's missing health." });
		nidaleeSpells[3] = new SpellInfo(
				"Bushwhack",
				"900",
				"18",
				"60 / 75 / 90 / 105 / 120 MANA",
				new String[] { "TOTAL MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 40% AP)",
						"ARMOR & MAGIC RESIST REDUCTION: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Nidalee lays a trap at a target location. When sprung by an enemy unit the trap deals magic damage to it over 2 seconds, revealing them and reducing their armor and magic resistance for 8 seconds. Traps last for 4 minutes." });
		nidaleeSpells[4] = new SpellInfo(
				"Pounce",
				"375",
				"3.5",
				"",
				new String[] { "Pounce scales with ranks in Aspect of the Cougar.",
						"MAGIC DAMAGE: 125 / 175 / 225 (+ 40% AP)" },
				new String[] { "ACTIVE: Nidalee lunges forward a short distance, dealing magic damage to enemies within a radius of 75 around her landing point." });
		nidaleeSpells[5] = new SpellInfo(
				"Primal Surge",
				"600",
				"10",
				"60 / 80 / 100 / 120 / 140 MANA",
				new String[] { "HEAL: 50 / 85 / 120 / 155 / 190 (+ 70% AP)", "ATTACK SPEED: 20 / 30 / 40 / 50 / 60%" },
				new String[] { "ACTIVE: Nidalee evokes the spirit of the cougar, healing a target allied champion or herself and granting them bonus attack speed for 7 seconds." });
		nidaleeSpells[6] = new SpellInfo("Swipe", "300 (estimate)", "6", "", new String[] {
				"Swipe scales with ranks in Aspect of the Cougar.", "MAGIC DAMAGE: 150 / 225 / 300 (+ 60% AP)" },
				new String[] { "ACTIVE: Nidalee claws at enemies in a cone in front of her, dealing magic damage.",
						"CONE WIDTH: 180 degrees (estimate)" });
		nidaleeSpells[7] = new SpellInfo(
				"Aspect of the Cougar",
				"",
				"4",
				"",
				new String[] { "Each rank in Aspect of the Cougar increases the ranks of all of Nidalee's cougar abilities." },
				new String[] { "TOGGLE: Nidalee transforms herself into a cougar, gaining a new set of abilities and 20 movement speed. Nidalee loses 400 range while using this ability (effective range of 125)." });
		champSpells[62] = nidaleeSpells;

		SpellInfo[] nocturneSpells = new SpellInfo[5];
		nocturneSpells[0] = new SpellInfo(
				"Umbra Blades",
				"",
				"10",
				"",
				arrS,
				new String[] { "Nocturne's attacks are periodically enhanced, damaging surrounding enemies for 120% of his total attack damage and healing himself for 10 / 18 / 26 per enemy hit. Cooldown reduction does not affect Umbra Blades, but every basic attack reduces the cooldown by 1 second." });
		nocturneSpells[1] = new SpellInfo(
				"Duskbringer",
				"1200",
				"10",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "PHYSICAL DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 75% bonus AD)",
						"MOVEMENT SPEED: 15 / 20 / 25 / 30 / 35%", "ATTACK DAMAGE: 15 / 25 / 35 / 45 / 55" },
				new String[] { "ACTIVE: Nocturne sends out a shadow blade in a line that leaves a Dusk Trail on its path, dealing physical damage to enemies it passes through and causing enemy champions hit to also leave a Dusk Trail behind their movements for 5 seconds. While on the Dusk Trail, Nocturne ignores unit collision and gains bonus movement speed and attack damage." });
		nocturneSpells[2] = new SpellInfo(
				"Shroud of Darkness",
				"",
				"20 / 18 / 16 / 14 / 12",
				"50 MANA",
				new String[] { "ATTACK SPEED: 20 / 25 / 30 / 35 / 40%", "DOUBLED SPEED: 40 / 50 / 60 / 70 / 80%" },
				new String[] {
						"PASSIVE: Nocturne empowers his blades, permanently gaining attack speed.",
						"ACTIVE: Nocturne creates a barrier that blocks the next enemy spell that hits him within the next 1.5 seconds. If Nocturne blocks a spell, the passive attack speed bonus is doubled for 5 seconds." });
		nocturneSpells[3] = new SpellInfo(
				"Unspeakable Horro",
				"425",
				"15 / 14 / 13 / 12 / 11",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 50 / 100 / 150 / 200 / 250 (+ 100% AP)",
						"FEAR: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "ACTIVE: Nocturne plants nightmares into his target's mind, dealing magic damage over 2 seconds. If Nocturne remains within 465 range of the target for the full duration, it turns and flees for a short duration." });
		nocturneSpells[4] = new SpellInfo(
				"Paranoia",
				"Global",
				"180 / 140 / 100",
				"100 MANA",
				new String[] { "LAUNCH RANGE: 2000 / 2750 / 3500", "PHYSICAL DAMAGE: 150 / 250 / 350 (+ 120% bonus AD)" },
				new String[] {
						"ACTIVE: Nocturne reduces the sight radius of all enemy champions and removes their shared vision for 4 seconds; this includes champions, minions, wards, towers, and Clairvoyance.",
						"While Paranoia is active, Nocturne can activate it again to launch himself at a target enemy champion within range, dealing physical damage." });
		champSpells[63] = nocturneSpells;

		SpellInfo[] nunuSpells = new SpellInfo[5];
		nunuSpells[0] = new SpellInfo("Visionary", "", "", "", arrS,
				new String[] { "After 5 autoattacks, Nunu's next spell will have no mana cost." });
		nunuSpells[1] = new SpellInfo(
				"Consume",
				"125",
				"13 / 12 / 11 / 10 / 9",
				"60 MANA",
				new String[] { "TRUE DAMAGE: 400 / 550 / 700 / 850 / 1000",
						"HEALTH RESTORED: 70 / 115 / 160 / 205 / 250 (+ 75% AP)",
						"BUFF DURATION: 120 / 150 / 180 / 210 / 240" },
				new String[] {
						"ACTIVE: Nunu commands his yeti to take a bite out of target enemy minion or neutral monster, dealing true damage to it and restoring Nunu's health. Nunu gains a bonus depending on what Willump consumed. Consume does not need to score the killing blow to trigger the bonuses and the individual bonuses stack.",
						"ROUGH ROCK CANDY: Golems of any size.", "Nunu increases his maximum health and size by 10%.",
						"ORNERY MONSTER TAILS: Reptiles of any size, including Dragon, Vilemaw and Baron.",
						"Nunu's attacks and spells deal 1% of his maximum health as bonus magic damage.",
						"SPOOKY MYSTERY MEAT: Wraiths and wolves of any size.",
						"Killing a unit grants Nunu 15% bonus movement speed for 3 seconds." });
		nunuSpells[2] = new SpellInfo(
				"Blood Boil",
				"700",
				"15",
				"50 MANA",
				new String[] { "ATTACK SPEED: 25 / 30 / 35 / 40 / 45%", "MOVEMENT SPEED: 8 / 9 / 10 / 11 / 12%" },
				new String[] { "ACTIVE: Invigorates an allied unit by heating their blood, increasing their attack speed and movement speed for 12 seconds. If cast on an ally, Nunu also gains the effect of Blood Boil." });
		nunuSpells[3] = new SpellInfo(
				"Ice Blast",
				"550",
				"6",
				"75 / 85 / 95 / 105 / 115 MANA",
				new String[] { "MAGIC DAMAGE: 85 / 130 / 175 / 225 / 275 (+ 100% AP)", "SLOW: 20 / 30 / 40 / 50 / 60%" },
				new String[] { "ACTIVE: Nunu throws a ball of ice at an enemy unit, dealing magic damage and slowing their movement speed by a percentage and attack speed by 25% for 3 seconds." });
		nunuSpells[4] = new SpellInfo(
				"Absolute Zero",
				"650",
				"110 / 100 / 90",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 625 / 875 / 1125 (+250% AP)",
						"MINIMUM INTERRUPTED MAGIC DAMAGE: 78.125 / 109.375 / 140.625 (+ 31.25% AP)",
						"MAXIMUM INTERRUPTED MAGIC DAMAGE: 546.875 / 765.625 / 984.375 (+ 218.75% AP)" },
				new String[] {
						"ACTIVE: Nunu starts channeling and begins to sap a large area around him of heat, slowing all nearby enemies movement speed by 50% and attack speed by 25%.",
						"After channeling for 3 seconds, he deals massive damage to all enemies caught in the area. If the channel is cancelled or interrupted early, it will deal between 12.5% and 87.5% damage, depending on how long it was channeled before being cancelled." });
		champSpells[64] = nunuSpells;

		SpellInfo[] olafSpells = new SpellInfo[5];
		olafSpells[0] = new SpellInfo("Beserker Rage", "", "", "", arrS,
				new String[] { "Olaf's attack speed increases by 1% for every 1% of his missing health." });
		olafSpells[1] = new SpellInfo(
				"Undertow",
				"400 - 1000",
				"8",
				"60 MANA",
				new String[] { "PHYSICAL DAMAGE: 70 / 115 / 160 / 205 / 250 (+100% bonus AD)",
						"SLOW PERCENT: 29 / 33 / 37 / 41 / 45%" },
				new String[] {
						"ACTIVE: Olaf throws an axe in a line to a target location, dealing physical damage and slowing enemies it passes through for between 1.5 and 2.5 seconds, depending on the distance the axe has travelled.",
						"The axe remains at the target location until Undertow is off cooldown. Olaf can pick up the axe to reduce Undertow's cooldown by 4.5 seconds. If the axe would land inside terrain, it will instead stick to the wall." });
		olafSpells[2] = new SpellInfo(
				"Vicious Strikes",
				"",
				"16",
				"30 MANA",
				new String[] { "ATTACK SPEED: 40 / 50 / 60 / 70 / 80%", "LIFE STEAL: 9 / 12 / 15 / 18 / 21%" },
				new String[] { "ACTIVE: For 6 seconds, Olaf gains bonus lifesteal and bonus attack speed. During this time, Olaf also gains 1% enhanced healing from all sources for every 2.5% of his missing health." });
		olafSpells[3] = new SpellInfo(
				"Reckless Swing",
				"325",
				"12 / 11 / 10 / 9 / 8",
				"21 / 34.5 / 48 / 61.5 / 75 (+12% AD) HEALTH",
				new String[] { "TRUE DAMAGE: 70 / 115 / 160 / 205 / 250 (+40% AD)" },
				new String[] {
						"ACTIVE: Olaf attacks with such force that it deals true damage to his target. The ability's cost is equal to 30% of the damage dealt and the cost is refunded if Reckless Swing kills the target.",
						"Olaf's basic attacks will reduce the cooldown of Reckless Swing by 1 second." });
		olafSpells[4] = new SpellInfo(
				"Ragnarok",
				"",
				"120 / 100 / 80",
				"NO COST",
				new String[] { "ARMOR / MAGIC RESIST: 10 / 20 / 30", "ATTACK DAMAGE: 40 / 60 / 80" },
				new String[] {
						"PASSIVE: Olaf gains bonus armor and magic resistance.",
						"ACTIVE: Olaf instantly removes all crowd control effects from himself and becomes immune to them for 6 seconds. During this time, he loses the passive bonus but gains bonus attack damage." });
		champSpells[65] = olafSpells;

		SpellInfo[] oriannaSpells = new SpellInfo[5];
		oriannaSpells[0] = new SpellInfo(
				"Clockwork Windup",
				"",
				"",
				"",
				arrS,
				new String[] { "Orianna's autoattacks deal 10 / 18 / 26 / 34 / 42 / 50 (+ 15% AP) bonus magic damage on hit. Subsequent attacks on the same target within 4 seconds deal an additional 20% magic damage. This bonus stacks up to 2 times, dealing a maximum of 14 / 25.2 / 36.4 / 47.6 / 58.8 / 70 (+ 21% AP) magic damage." });
		oriannaSpells[1] = new SpellInfo(
				"Command: Attack",
				"825",
				"6 / 5.25 / 4.5 / 3.75 / 3",
				"50 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 50% AP)",
						"MINIMUM MAGIC DAMAGE: 24 / 36 / 48 / 60 / 72 (+ 20% AP)" },
				new String[] { "ACTIVE: Orianna commands the Ball to fly towards the target location, dealing magic damage to all enemies that the Ball passes through or that are in the target area. However, the Ball deals 10% less damage for each subsequent target hit down to a minimum of 40% damage done. After Command: Attack is used, the Ball remains behind at the target location." });
		oriannaSpells[2] = new SpellInfo(
				"Command: Dissonance",
				"",
				"9",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 70% AP)",
						"INITIAL MOVEMENT SPEED: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Orianna commands the Ball to emit an electric pulse around its current location, dealing magic damage to enemies within 250 range and leaving an electric field on the area for 3 seconds that speeds up allies and slows enemies that walk over it. This effect diminishes to normal over 2 seconds after leaving the area." });
		oriannaSpells[3] = new SpellInfo(
				"Command: Protect",
				"1100",
				"9",
				"60 MANA",
				new String[] { "ARMOR & MAGIC RESIST: 10 / 15 / 20 / 25 / 30",
						"SHIELD STRENGTH: 80 / 120 / 160 / 200 / 240 (+ 40% AP)",
						"MAGIC DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 30% AP)" },
				new String[] {
						"PASSIVE: The allied champion the Ball is currently attached to is granted bonus armor and magic resistance.",
						"ACTIVE: Orianna commands the Ball to fly to and attach onto an allied champion, dealing damage to enemies it passes through and shielding the allied champion for 4 seconds when it arrives." });
		oriannaSpells[4] = new SpellInfo(
				"Command: Shockwave",
				"",
				"120 / 105 / 90",
				"100 / 125 / 150 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 225 / 300 (+ 70% AP)" },
				new String[] { "ACTIVE: Orianna commands the Ball to unleash a shockwave after 0.5 seconds, dealing magic damage to enemies within 400 range and flinging them into the air 350 range towards, and possibly over, the Ball." });
		champSpells[66] = oriannaSpells;

		SpellInfo[] pantheonSpells = new SpellInfo[5];
		pantheonSpells[0] = new SpellInfo(
				"Aegis Protection",
				"",
				"NO COOLDOWN",
				"NO COST",
				arrS,
				new String[] { "PASSIVE: After autoattacking or using an ability 4 times, Pantheon will block the next incoming turret attack or basic attack from an enemy champion, siege minion or large monster." });
		pantheonSpells[1] = new SpellInfo(
				"Spear Shot",
				"",
				"4",
				"45 MANA",
				new String[] { "PHYSICAL DAMAGE: 65 / 105 / 145 / 185 / 225 (+140% bonus AD)",
						"CERTAIN DEATH DAMAGE: 97.5 / 157.5 / 217.5 / 277.5 / 337.5 (+210% bonus AD)" },
				new String[] {
						"ACTIVE: Pantheon hurls his spear at a target enemy unit within 600 range, dealing physical damage.",
						"If  Heartseeker Strike has been ranked, Spear Shot will deal 50% additional damage to targets below 15% health." });
		pantheonSpells[2] = new SpellInfo(
				"Aegis of Zeonia",
				"",
				"13 / 12 / 11 / 10 / 9 ",
				"55 MANA",
				new String[] { "MAGIC DAMAGE: 50 / 75 / 100 / 125 / 150 (+ 100% AP)" },
				new String[] { "ACTIVE: Pantheon leaps upon a target enemy unit within 600 range, dealing magic damage and stunning them for 1 second. Pantheon's Aegis Protection is also refreshed" });
		pantheonSpells[3] = new SpellInfo(
				"Heartseeker Strike",
				"",
				"10 / 9 / 8 / 7 / 6 ",
				"45 / 50 / 55 / 60 / 65 MANA",
				new String[] { "PHYSICAL DAMAGE PER STRIKE: 26 / 46 / 66 / 86 / 106 (+ 120% bonus AD)",
						"TOTAL PHYSICAL DAMAGE: 80 / 140 / 200 / 260 / 320 (+ 360% bonus AD)" },
				new String[] {
						"CERTAIN DEATH - PASSIVE: Pantheon gains 100% critical strike chance and his  Spear Shots will deal 50% bonus damage against targets below 15% health.",
						"ACTIVE: Pantheon channels for 0.75 seconds, dealing physical damage to all enemies within a 700-range cone in front of him at 0.25 second intervals. Heartseeker Strike deals half damage to minions and monsters." });
		pantheonSpells[4] = new SpellInfo(
				"Grand Skyfall",
				"",
				"150 / 135 / 120",
				"125 MANA",
				new String[] { "MAGIC DAMAGE: 400 / 700 / 1000 (+ 100% AP)",
						"MINIMUM MAGIC DAMAGE: 200 / 350 / 500 (+ 50% AP)" },
				new String[] {
						"ACTIVE: Pantheon begins channelling. If Pantheon goes uninterrupted for 2 seconds he will leap into the air, becoming untargetable. Pantheon will then begin plummeting toward the ground at the target location within 5500 range, striking after 1.5 seconds and becoming targetable once more. Enemies within a 700-unit radius of the point of impact will take magic damage and are slowed by 35% for 1 second. The magic damage diminishes over the area down to 50% to enemies at the edge.",
						"If the channeling is cancelled, Grand Skyfall is put on a 10 second cooldown." });
		champSpells[67] = pantheonSpells;

		SpellInfo[] poppySpells = new SpellInfo[5];
		poppySpells[0] = new SpellInfo(
				"Valiant Fighter",
				"",
				"",
				"",
				arrS,
				new String[] { "Whenever Poppy would otherwise suffer damage greater than 10% of her current health all damage exceeding that threshold is halved; Poppy receives the first 10% normally. Valiant Fighter has no internal cooldown and is not affected by structures." });
		poppySpells[1] = new SpellInfo(
				"Devastating Blow",
				"",
				"8 / 7 / 6 / 5 / 4",
				"55 MANA",
				new String[] {
						"TOTAL MAGIC DAMAGE: 20 / 40 / 60 / 80 / 100 (+ 100% AD) (+ 60% AP) (+ 8% of target's maximum health)",
						"MAXIMUM BONUS DAMAGE: 75 / 150 / 225 / 300 / 375" },
				new String[] { "ACTIVE: Poppy's next basic attack is converted to deal magic damage and deals bonus damage equal to a flat amount plus 8% of the target's maximum health. Devastating Blow's percent health component cannot exceed a damage threshold." });
		poppySpells[2] = new SpellInfo(
				"Paragon of Demacia",
				"",
				"12",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "ARMOR & ATTACK DAMAGE PER STACK: 1.5 / 2 / 2.5 / 3 / 3.5",
						"MAX ARMOR & ATTACK DAMAGE: 15 / 20 / 25 / 30 / 35", "MOVEMENT SPEED: 17 / 19 / 21 / 23 / 25%" },
				new String[] {
						"PASSIVE: Taking damage or attacking an enemy increases Poppy's armor and attack damage for 5 seconds, stacking up to 10 times.",
						"ACTIVE: Poppy receives maximum stacks of Paragon of Demacia. Additionally, she gains increased movement speed for 5 seconds." });
		poppySpells[3] = new SpellInfo(
				"Heroic Charge",
				"525",
				"12 / 11 / 10 / 9 / 8",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 50 / 75 / 100 / 125 / 150 (+ 40% AP)",
						"COLLISION MAGIC DAMAGE: 75 / 125 / 175 / 225 / 275 (+ 40% AP)",
						"TOTAL MAGIC DAMAGE: 125 / 200 / 275 / 350 / 425 (+ 80% AP)" },
				new String[] {
						"ACTIVE: Poppy charges at an enemy in a line, dealing magic damage and carrying them along her path. If they collide with terrain, she stuns her target for 1.5 seconds, dealing additional magic damage.",
						"CARRY DISTANCE: 300 (estimate)" });
		poppySpells[4] = new SpellInfo(
				"Diplomatic Immunity",
				"900",
				"140 / 120 / 100",
				"100 MANA",
				new String[] { "DURATION: 6 / 7 / 8", "INCREASED DAMAGE: 20 / 30 / 40%" },
				new String[] { "ACTIVE: Poppy focuses intensely on a single enemy champion, dealing amplified damage to them, and becoming immune to all damage and abilities that are not from the marked champion." });
		champSpells[68] = poppySpells;

		SpellInfo[] quinnSpells = new SpellInfo[6];
		quinnSpells[0] = new SpellInfo(
				"Harrier",
				"",
				"",
				"",
				arrS,
				new String[] {
						"Valor periodically marks a nearby enemy with Vulnerability for 4.5 seconds. If Quinn attacks a Vulnerable enemy, she deals 25 / 35 / 45 / 55 / 65 / 75 / 85 / 95 / 105 / 115 / 125 / 135 / 145 / 155 / 170 / 185 / 200 / 215 (+ 50% bonus AD) bonus physical damage. This cannot occur again for 10 seconds, or 3 seconds if Quinn triggers the vulnerability. Valor will first prioritize Quinn's most recent attack target. If Quinn has not attacked anyone recently, Valor will target nearby low health units (prioritizing champions over minions).",
						"Harrier is disabled while Tag Team is active." });
		quinnSpells[1] = new SpellInfo(
				"Blinding Assault",
				"1025",
				"11 / 10 / 9 / 8 / 7",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "PHYSICAL DAMAGE: 70 / 110 / 150 / 190 / 230 (+ 65% bonus AD) (+50% AP)",
						"PHYSICAL DAMAGE: 70 / 110 / 150 / 190 / 230 (+ 65% bonus AD) (+50% AP)" },
				new String[] {
						"ACTIVE: Quinn commands Valor to fly forwards in a line, stopping when he collides with an enemy. Valor then deals physical damage and blinds nearby enemies within 210 range for 1.5 seconds.",
						"ACTIVE - TAG TEAM: Valor deals physical damage to all enemies within 275 range of himself and blinds them for 1.5 seconds." });
		quinnSpells[2] = new SpellInfo(
				"Heightened Senses",
				"2100",
				"50 / 45 / 40 / 35 / 30",
				"NO COST",
				new String[] { "ATTACK SPEED: 20 / 25 / 30 / 35 / 40%", "MOVEMENT SPEED: 20 / 30 / 40 / 50 / 60",
						"ATTACK SPEED: 40 / 50 / 60 / 70 / 80%" },
				new String[] {
						"PASSIVE: Attacking a Vulnerable target will grant Quinn bonus attack speed and flat movement speed for 3 seconds.",
						"PASSIVE - TAG TEAM: Valor gains bonus attack speed. ",
						"ACTIVE: All area within range is revealed for 2 seconds" });
		quinnSpells[3] = new SpellInfo(
				"Vault",
				"750",
				"12 / 11 / 10 / 9 / 8",
				"50 MANA",
				new String[] { "PHYSICAL DAMAGE: 40 / 70 / 100 / 130 / 160 (+ 20% bonus AD)",
						"PHYSICAL DAMAGE: 40 / 70 / 100 / 130 / 160 (+ 20% bonus AD)" },
				new String[] {
						"ACTIVE: Quinn dashes to an enemy, knocking it back a short distance, dealing physical damage and slowing the target's movement speed by 50%. This slow decays over 2 seconds.",
						"Upon reaching the target, she leaps off and lands near her maximum attack range away from the target. Valor will immediately mark this target as Vulnerable.",
						"ACTIVE - TAG TEAM: Valor dashes to an enemy and applies the same slow, knockback and physical damage, but does not mark or leap off the target." });
		quinnSpells[4] = new SpellInfo(
				"Tag Team",
				"",
				"140 / 110 / 80",
				"100 MANA",
				new String[] { "OUT OF COMBAT MOVEMENT SPEED: 80 / 90 / 100%",
						"IN COMBAT MOVEMENT SPEED: 20 / 30 / 40%" },
				new String[] { "ACTIVE: For 20 seconds, Valor replaces Quinn on the battlefield as a mobile melee attacker with alternate versions of Quinn's abilities. Valor can move through units and gains greatly increased movement speed that gradually decreases to a lower amount while in combat." });
		quinnSpells[5] = new SpellInfo(
				"Skystrike",
				"700",
				"",
				"",
				new String[] { "MINIMUM PHYSICAL DAMAGE: 100 / 150 / 200 (+ 50% bonus AD)",
						"MAXIMUM PHYSICAL DAMAGE: 200 / 300 / 400 (+ 100% bonus AD)" },
				new String[] {
						"ACTIVE - TAG TEAM: Quinn returns to perform Skystrike, dealing physical damage to all enemies within range. The damage increases by 1% for every 1% of an enemy's missing health.",
						"If Skystrike has not been cast during Tag Team, it will be cast automatically when Tag Team ends." });
		champSpells[69] = quinnSpells;

		SpellInfo[] rammusSpells = new SpellInfo[5];
		rammusSpells[0] = new SpellInfo("Spiked Shell", "", "", "", arrS,
				new String[] { "Rammus receives bonus attack damage equal to 25% of his total armor." });
		rammusSpells[1] = new SpellInfo(
				"Powerball",
				"",
				"10",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 100 / 150 / 200 / 250 / 300 (+ 100% AP)",
						"SLOW: 20 / 25 / 30 / 35 / 40%", "IMPACT RADIUS: 200 (estimate)",
						"KNOCK BACK DISTANCE: 100 (estimate)" },
				new String[] {
						"ACTIVE: Rammus enters a rolling ball state for up to 7 seconds, constantly accelerating from an initial bonus 3% move speed up to a bonus 165% move speed. While in this state, Rammus cannot attack or use  Puncturing Taunt. Activating  Defensive Ball Curl or re-activating Powerball during its duration will end the effect instantly.",
						"Upon colliding with an enemy unit, all nearby enemies are briefly knocked back, take magic damage, and are slowed for 3 seconds afterwards. Rammus reverts to his normal state as well." });
		rammusSpells[2] = new SpellInfo(
				"Defensive Ball Curl",
				"",
				"14",
				"40 MANA",
				new String[] { "ARMOR & MAGIC RESIST: 40 / 60 / 80 / 100 / 120",
						"MAGIC DAMAGE RETURNED: 15 / 25 / 35 / 45 / 55 (+ 10% armor)" },
				new String[] {
						"ACTIVE: Rammus enters a defensive stance for 6 seconds, increasing his armor and magic resistance and dealing magic damage to enemies whenever they use a basic attack against him.",
						"Defensive Ball Curl will end if  Powerball is activated during its duration." });
		rammusSpells[3] = new SpellInfo(
				"Puncturing Taunt",
				"325",
				"12",
				"50 MANA",
				new String[] { "ARMOR REDUCTION: 10 / 15 / 20 / 25 / 30", "DURATION: 1.25 / 1.5 / 1.75 / 2 / 2.25" },
				new String[] { "ACTIVE: Rammus taunts an enemy champion or monster, reducing their armor and forcing them to attack Rammus for a few seconds." });
		rammusSpells[4] = new SpellInfo(
				"Tremors",
				"",
				"60",
				"100 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 65 / 130 / 195 (+ 30% AP)",
						"MAXIMUM MAGIC DAMAGE: 520 / 1040 / 1560 (+ 240% AP)" },
				new String[] { "ACTIVE: Rammus creates an earthquake around himself for 8 seconds, dealing magic damage to units and structures within 300 range each second. Tremors does not hinder Rammus' actions." });
		champSpells[70] = rammusSpells;

		SpellInfo[] renektonSpells = new SpellInfo[6];
		renektonSpells[0] = new SpellInfo("Reign of Anger", "", "", "", arrS,
				new String[] { "Renekton gains 50% more Fury from all sources while below half health." });
		renektonSpells[1] = new SpellInfo(
				"Cull the Meek",
				"225 (estimated)",
				"8",
				"",
				new String[] { "PHYSICAL DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 80% bonus AD)",
						"HEALING CAP: 50 / 75 / 100 / 125 / 150",
						"EMPOWERED DAMAGE: 90 / 135 / 180 / 225 / 270 (+ 120% bonus AD)",
						"EMPOWERED HEALING CAP: 150 / 225 / 300 / 375 / 450" },
				new String[] {
						"ACTIVE: Renekton deals physical damage to all enemies within range, gaining 5 Fury for each target hit and healing for some of the damage dealt, up to a cap. Renekton heals for 20% of the damage dealt to champions and 5% of the damage dealt to minions and monsters.",
						"FURY BONUS: Cull the Meek deals 50% additional damage. The heal is doubled to 40% against champions and 10% against minions and monsters, and the healing cap is tripled." });
		renektonSpells[2] = new SpellInfo(
				"Ruthless Predator",
				"",
				"13 / 12 / 11 / 10 / 9",
				"",
				new String[] { "PHYSICAL DAMAGE PER HIT: 5 / 15 / 25 / 35 / 45 (+ 75% AD)",
						"TOTAL PHYSICAL DAMAGE: 10 / 30 / 50 / 70 / 90 (+ 150% AD)",
						"TOTAL EMPOWERED DAMAGE: 15 / 45 / 75 / 105 / 135 (+ 225% AD)" },
				new String[] {
						"ACTIVE: Renekton's next basic attack will hit twice, stunning his target for 0.75 seconds and dealing physical damage equal to a base amount plus a percentage of his attack damage. Each hit applies on-hit effects and grants Fury.",
						"FURY BONUS: Ruthless Predator will strike his opponent 3 times, dealing 50% additional damage and increasing the stun duration to 1.5 seconds. Each hit still applies on-hit effects, but does not grant Fury." });
		renektonSpells[3] = new SpellInfo(
				"Slice",
				"450",
				"18 / 17 / 16 / 15 / 14",
				"",
				new String[] { "PHYSICAL DAMAGE: 30 / 60 / 90 / 120 / 150 (+ 90% bonus AD)" },
				new String[] { "ACTIVE: Renekton dashes forward, dealing physical damage to enemies he hits along the way. If he hits a target he gains the ability to use Dice for 4 seconds." });
		renektonSpells[4] = new SpellInfo("Dice", "450", "", "", new String[] {
				"PHYSICAL DAMAGE: 30 / 60 / 90 / 120 / 150 (+ 90% bonus AD)",
				"EMPOWERED DAMAGE: 45 / 90 / 135 / 180 / 225 (+ 135% bonus AD)",
				"ARMOR REDUCTION: 15% / 20% / 25% / 30% / 35%", }, new String[] {
				"ACTIVE: Renekton dashes forward, dealing physical damage to enemies he hits along the way.",
				"FURY BONUS: Dice deals 50% additional damage and shreds the armor of targets hit for 4 seconds." });
		renektonSpells[5] = new SpellInfo(
				"Dominus",
				"",
				"120",
				"",
				new String[] { "HEALTH GAIN: 200 / 400 / 800", "MAGIC DAMAGE PER SECOND: 30 / 60 / 120 (+ 10% AP)",
						"MAXIMUM DAMAGE: 450 / 900 / 1800 (+ 150% AP)" },
				new String[] { "ACTIVE: Renekton empowers himself with dark energies for 15 seconds, enlarging his size and gaining bonus health. While in this state, he deals magic damage each second to enemies within 175 range and generates 5 Fury per second." });
		champSpells[71] = renektonSpells;

		SpellInfo[] rengarSpells = new SpellInfo[8];
		rengarSpells[0] = new SpellInfo(
				"Unseen Predator",
				"600 (725 with 6 Trophies on Bonetooth Necklace)",
				"",
				"",
				arrS,
				new String[] { "While in brush or in stealth, Rengar gains bonus attack range and his attacks cause him to leap at his target. This bonus lasts for ~0.5 second upon exiting brush or stealth. This will happen regardless of whether or not his target has sight of him, and has no internal cooldown." });
		rengarSpells[1] = new SpellInfo(
				"Savagery",
				"",
				"6 / 5.5 / 5 / 4.5 / 4",
				"",
				new String[] { "MODIFIED PHYSICAL DAMAGE: 20 / 40 / 60 / 80 / 100 (+100 / 105 / 110 / 115 / 120 % AD)" },
				new String[] { "ACTIVE: Rengar's next basic attack in the next 3 seconds deals modified physical damage." });
		rengarSpells[2] = new SpellInfo(
				"Empowered Savagery",
				"",
				"",
				"5 FEROCITY",
				arrS,
				new String[] { "ACTIVE: Savagery deals modified damage equal to 10 + (10 * level) (+ 150% AD). Additionally, Savagery grants Rengar bonus 47 + (3 * level) % attack speed and increases his attack damage by 10% for 5 seconds." });
		rengarSpells[3] = new SpellInfo(
				"Battle Roar",
				"500",
				"12",
				"",
				new String[] { "MAGIC DAMAGE: 50 / 80 / 110 / 140 / 170 (+ 80% AP)",
						"ARMOR & MAGIC RESISTANCE: 10 / 15 / 20 / 25 / 30",
						"BONUS PER CHAMPION/MONSTER HIT: 5 / 7.5 / 10 / 12.5 / 15" },
				new String[] { "ACTIVE: Rengar lets out a battle roar, dealing magic damage to nearby enemies and increasing his armor and magic resist for 4 seconds. Rengar gains additional armor and magic resist for each enemy champion or large monster hit." });
		rengarSpells[4] = new SpellInfo(
				"Empowered Battle Roar",
				"",
				"",
				"5 FEROCITY",
				arrS,
				new String[] { "ACTIVE: Battle Roar deals modified damage equal to 25 + (15 * level) (+ 80% AP). Additionally, Battle Roar heals Rengar for 8 + (4 × level) health, increased by 6.25% for every 1% of Rengar's missing health for up to 50 + (25 × level) health. Basic and Empowered Battle Roar's bonus defenses do not stack with each other." });
		rengarSpells[5] = new SpellInfo(
				"Bola Strike",
				"1000",
				"10",
				"",
				new String[] { "PHYSICAL DAMAGE: 50 / 100 / 150 / 200 / 250 (+ 70% bonus AD)",
						"SLOW: 60 / 65 / 70 / 75 / 80%" },
				new String[] { "ACTIVE: Rengar throws a bola in the target direction, dealing physical damage and slowing the first enemy hit for 2.5 seconds. The slow decays over the duration." });
		rengarSpells[6] = new SpellInfo(
				"Empowered Bola Strike",
				"",
				"",
				"5 FEROCITY",
				arrS,
				new String[] { "ACTIVE: Bola Strike deals modified damage equal to 25 + (25 * level) (+ 70% bonus AD). Additionally, it roots the target for 1.75 seconds." });
		rengarSpells[7] = new SpellInfo(
				"Thrill of the Hunt",
				"",
				"120 / 95 / 70",
				"",
				new String[] { "VISION RADIUS: 2000 / 3000 / 4000", "MOVEMENT SPEED: 25 / 35 / 45 %" },
				new String[] {
						"ACTIVE: Rengar activates his predatory instincts, gaining stealth after 1 second (delayed up to 3 seconds if taking damage) and vision of all nearby enemy champions for 7 / 12 seconds or until Rengar damages an enemy with one of his abilities or basic attacks. While stealthed, Rengar gains 15% / 30% bonus movement speed while moving toward an enemy champion. Enemies are made aware that Rengar is nearby if he is less than 1000 units away.",
						"Upon exiting stealth, Rengar gains unconditional bonus movement speed and generates 1 Ferocity every 1 second for 5 seconds." });
		champSpells[72] = rengarSpells;

		SpellInfo[] rivenSpells = new SpellInfo[6];
		rivenSpells[0] = new SpellInfo(
				"Runic Blade",
				"",
				"",
				"",
				arrS,
				new String[] { "Riven's abilities charge her blade for 5 seconds, causing her to do 20 / 25 / 30 / 35 / 40 / 45 / 50 % of her attack damage as bonus physical damage on her next basic attack. Riven can store up to 3 charges, and can only expend one at a time." });
		rivenSpells[1] = new SpellInfo(
				"Broken Wings",
				"260",
				"13",
				"",
				new String[] { "PHYSICAL DAMAGE: 10 / 30 / 50 / 70 / 90 (+ 40 / 45 / 50 / 55 / 60% AD)",
						"TOTAL DAMAGE: 30 / 90 / 150 / 210 / 270 (+ 120 / 135 / 150 / 165 / 180% AD)" },
				new String[] { "ACTIVE: Riven steps forward and lashes out in a series of powerful slashes that will deal physical damage to all enemies within 112.5 range. This ability can be activated a second time within 4 seconds, and a third time within 4 seconds of that. The third activation damages enemies within 150 range and also knocks them up. All three strikes deal the same damage." });
		rivenSpells[2] = new SpellInfo(
				"Ki Burst",
				"125",
				"11 / 10 / 9 / 8 / 7",
				"",
				new String[] { "PHYSICAL DAMAGE: 50 / 80 / 110 / 140 / 170 (+ 100% bonus AD)" },
				new String[] { "ACTIVE: Riven deals physical damage to all enemies within range and stuns them for 0.75 seconds." });
		rivenSpells[3] = new SpellInfo(
				"Valor",
				"325",
				"10 / 9 / 8 / 7 / 6",
				"",
				new String[] { "SHIELD: 90 / 120 / 150 / 180 / 210 (+ 100% bonus AD)" },
				new String[] { "ACTIVE: Riven dashes towards the cursor and gains a shield that absorbs incoming damage for 1.5 seconds." });
		rivenSpells[4] = new SpellInfo(
				"Blade of the Exile",
				"",
				"110 / 80 / 50",
				"",
				arrS,
				new String[] { "ACTIVE: For 15 seconds Riven's sword is reformed, granting her 20% increased attack damage and 75 increased range on her basic attacks. Also Broken Wings's normal and third area of effect radius increase to 162.5 and 200, and Ki Burst's area of effect radius increases to 135. She is also granted the ability to use Wind Slash once for the duration." });
		rivenSpells[5] = new SpellInfo(
				"Wind Slash",
				"900",
				"",
				"",
				new String[] { "BASE PHYSICAL DAMAGE: 80 / 120 / 160 (+ 60% bonus AD)",
						"MAX DAMAGE (WITH ENEMY AT 25% HEALTH OR LOWER): 240 / 360 / 480 (+ 180% bonus AD)" },
				new String[] { "ACTIVE: Riven unleashes a 2200-speed wave of energy in a cone, dealing physical damage to all enemies hit. Damage is increased by 2.67% for every 1% of an enemy's missing health, capping at 200% bonus damage (300% damage total) against enemies with 75% or more missing health." });
		champSpells[73] = rivenSpells;

		SpellInfo[] rumbleSpells = new SpellInfo[5];
		rumbleSpells[0] = new SpellInfo(
				"Junkyard Titan",
				"",
				"",
				"",
				arrS,
				new String[] { "When Rumble reaches 100 Heat he overheats for 6 seconds. While overheated Rumble cannot use his own spells, but his basic attacks deal an additional 20 + (5 × level) (+ 25% AP) magic damage. Rumble's Heat is reset to 0 after the overheat effect ends." });
		rumbleSpells[1] = new SpellInfo(
				"Flamespitter",
				"600",
				"6",
				"",
				new String[] { "MAGIC DAMAGE PER SECOND: 25 / 45 / 65 / 85 / 105 (+ 33% AP)",
						"TOTAL MAGIC DAMAGE: 75 / 135 / 195 / 255 / 315 (+ 100% AP)",
						"ENHANCED MAGIC DAMAGE PER SECOND: 37.5 / 67.5 / 97.5 / 127.5 / 157.5 (+ 50% AP)",
						"TOTAL ENHANCED MAGIC DAMAGE: 112.5 / 202.5 / 292.5 / 382.5 / 472.5 (+ 150% AP)" },
				new String[] {
						"ACTIVE: Rumble activates his flamethrower for 3 seconds, dealing magic damage every 0.5 seconds to enemy units in a cone in front of him (dealing half damage to minions). Rumble can perform other actions while Flamespitter is active.",
						"DANGER ZONE:  Flamespitter's damage is increased by 50%" });
		rumbleSpells[2] = new SpellInfo(
				"Scrap Shield",
				"",
				"6",
				"",
				new String[] { "SHIELD STRENGTH: 50 / 80 / 110 / 140 / 170 (+ 40% AP)",
						"MOVEMENT SPEED: 10 / 15 / 20 / 25 / 30%",
						"ENHANCED SHIELD STRENGTH: 62.5 / 100 / 136.5 / 175 / 212.5 (+ 50% AP)",
						"ENHANCED MOVEMENT SPEED: 12.5 / 18.75 / 25 / 31.25 / 37.5%" },
				new String[] {
						"ACTIVE: Rumble pulls up a shield, protecting him from damage for up to 2 seconds. In addition, he gains a quick burst of speed for 1 second.",
						"DANGER ZONE:  Scrap Shield's effects are increased by 25%." });
		rumbleSpells[3] = new SpellInfo(
				"Electro-Harpoon",
				"850",
				"10",
				"",
				new String[] { "MAGIC DAMAGE: 45 / 70 / 95 / 120 / 145 (+ 40% AP)",
						"TOTAL MAGIC DAMAGE: 90 / 140 / 190 / 240 / 290 (+ 80% AP)", "SLOW: 15 / 20 / 25 / 30 / 35%",
						"ENHANCED MAGIC DAMAGE: 56.25 / 87.5 / 118.75 / 150 / 181.25 (+ 50% AP)",
						"ENHANCED TOTAL MAGIC DAMAGE: 102.5 / 175 / 237.5 / 300 / 362.5 (+ 100% AP)",
						"ENHANCED SLOW: 18.75 / 25 / 31.5 / 37.5 / 43.75%" },
				new String[] {
						"ACTIVE: Rumble shoots a taser that deals magic damage and applies a slow on the first enemy it hits for 3 seconds. A second shot can be fired for no additional cost within the next 3 seconds, even if Rumble  overheats.",
						"If the second taser slows an enemy that has been slowed by the first, the slow is refreshed and its movement speed reduction is doubled.",
						"DANGER ZONE:  Electro-Harpoon's effects are increased by 25%." });
		rumbleSpells[4] = new SpellInfo(
				"The Equalizer",
				"1700",
				"105 / 90 / 75",
				"",
				new String[] { "AREA MAGIC DAMAGE PER SECOND: 130 / 185 / 240 (+ 30% AP)",
						"TOTAL MAGIC DAMAGE: 650 / 925 / 1200 (+ 150% AP)", "WALL LENGTH: 1000 (estimate)" },
				new String[] { "ACTIVE: Rumble calls down a line of rockets over the target linear location, using a click and drag targeting system. The rockets leave a trail of destruction for 5 seconds, dealing magic damage every second and slowing all enemies standing on the area by 35%." });
		champSpells[74] = rumbleSpells;

		SpellInfo[] ryzeSpells = new SpellInfo[5];
		ryzeSpells[0] = new SpellInfo(
				"Arcane Mastery",
				"",
				"",
				"",
				arrS,
				new String[] { "When Ryze casts a spell, all of his other spells have their cooldown reduced by 1 second." });
		ryzeSpells[1] = new SpellInfo("Overload", "625", "3.5", "60 MANA", new String[] {
				"COOLDOWN REDUCTION: 2 / 4 / 6 / 8 / 10%",
				"MAGIC DAMAGE: 60 / 85 / 110 / 135 / 160 (+ 40% AP) (+ 6.5% of max mana)" }, new String[] {
				"PASSIVE: Ryze gains cooldown reduction.",
				"ACTIVE: Ryze throws a charge of pure energy at an enemy unit, dealing magic damage." });
		ryzeSpells[2] = new SpellInfo(
				"Rune Prison",
				"600",
				"14",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 60% AP) (+ 4.5% of max mana)",
						"DURATION: 0.75 / 1 / 1.25 / 1.5 / 1.75" },
				new String[] { "ACTIVE: Ryze traps an enemy in a cage of magic, dealing magic damage and rooting it for a short time." });
		ryzeSpells[3] = new SpellInfo(
				"Spell Flux",
				"600",
				"14",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE: 50 / 70 / 90 / 110 / 130 (+ 35% AP) (+ 1% of max mana)",
						"MAX MAGIC DAMAGE TO ONE TARGET: 150 / 210 / 270 / 330 / 390 (+ 105% AP) (+3% of max mana)",
						"MAGIC RESIST REDUCTION: 12 / 15 / 18 / 21 / 24" },
				new String[] {
						"ACTIVE: Ryze unleashes an orb of magical power which bounces to enemy units or himself within 200 range, up to 5 times (for a total of 6 hits).",
						"Against enemies, each bounce deals magic damage and reduces magic resistance for 5 seconds. This reduction does not stack with multiple hits. The orb has no effect on Ryze if it bounces back to himself." });
		ryzeSpells[4] = new SpellInfo(
				"Desperate Power",
				"",
				"70 / 60 / 50",
				"NO COST",
				new String[] { "SPELL VAMP: 15 / 20 / 25%", "FLAT MOVEMENT SPEED: 60 / 70 / 80", "DURATION: 5 / 6 / 7" },
				new String[] { "ACTIVE: Ryze becomes supercharged, gaining spell vamp and bonus flat movement speed, and causing his spells to deal 50% of their damage to other enemies in a 200 unit radius around the original target." });
		champSpells[75] = ryzeSpells;

		SpellInfo[] sejuaniSpells = new SpellInfo[5];
		sejuaniSpells[0] = new SpellInfo(
				"Frost Aromor",
				"",
				"",
				"",
				arrS,
				new String[] { "Damaging an enemy with an ability or basic attack grants 10 / 15 / 20 / 25 bonus armor and reduces movement-slowing effects on Sejuani by 10 / 15 / 20 / 25% for 2 seconds. Subsequent damage will increase the duration by 2 seconds up to a cap of 8 seconds, with further damage refreshing the duration." });
		sejuaniSpells[1] = new SpellInfo(
				"Artic Assault",
				"650",
				"15 / 14 / 13 / 12 / 11",
				"80 / 85 / 90 / 95 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 40 / 70 / 100 / 130 / 160 (+ 40% AP) (+ 4 / 6 / 8 / 10 / 12% of enemy's maximum health)" },
				new String[] { "ACTIVE: Sejuani charges forward, knocking enemies into the air and dealing magic damage equal to a flat amount plus a percentage of their maximum health (max 300 damage to monsters). This charge stops after knocking an enemy champion into the air." });
		sejuaniSpells[2] = new SpellInfo(
				"Flail of the Nothern Winds",
				"350",
				"11 / 10 / 9 / 8 / 7",
				"40 MANA",
				new String[] { "BONUS MAGIC DAMAGE: 40 / 60 / 80 / 100 / 120 (+ 30% AP)",
						"AOE DAMAGE PER SECOND: 20 / 30 / 40 / 50 / 60 (+ 2.5% of bonus health) (+ 15% AP)",
						"TOTAL AOE DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 10% of bonus health) (+ 60% AP)",
						"MAXIMUM DAMAGE TO ONE TARGET: 120 / 180 / 240 / 300 / 360 (+ 10% of bonus health) (+ 90% AP)" },
				new String[] { "ACTIVE: Sejuani's next basic attack deals bonus magic damage to the target and enemies near it. She then swings her flail, dealing magic damage each second to enemies within range for 4 seconds. If this ability is reactivated, Sejuani immediately starts swinging her flail." });
		sejuaniSpells[3] = new SpellInfo(
				"Permafrost",
				"1000",
				"11",
				"55 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 50% AP)", "SLOW: 50 / 55 / 60 / 65 / 70%",
						"DURATION: 1.5 / 1.75 / 2 / 2.25 / 2.5" },
				new String[] {
						"PASSIVE: Sejuani's abilities and basic attacks apply Frost to enemies for 4 seconds.",
						"ACTIVE: All nearby enemies with Frost take magic damage and are slowed, and the Frost debuff is removed from the targets of Permafrost. This spell is unable to be cast if no enemies in range have the Frost debuff." });
		sejuaniSpells[4] = new SpellInfo(
				"Glacial Prison",
				"1175",
				"130 / 115 / 100",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 80% AP)", "STUN/SLOW DURATION: 1.25 / 1.5 / 1.75" },
				new String[] {
						"ACTIVE: Sejuani throws her frost-forged bola in a line. If the bola hits an enemy champion, it shatters, stunning the target and nearby enemies for a duration. If the bola reaches its maximum range, it shatters and slows enemies by 90% instead for the same duration.",
						"All enemies in the shatter area take magic damage." });
		champSpells[76] = sejuaniSpells;

		SpellInfo[] shacoSpells = new SpellInfo[5];
		shacoSpells[0] = new SpellInfo(
				"Backstab",
				"",
				"",
				"",
				arrS,
				new String[] { "Shaco deals 20% bonus damage when striking a unit from behind with his basic attacks or abilities." });
		shacoSpells[1] = new SpellInfo(
				"Deceive",
				"400",
				"11 seconds after exiting stealth",
				"90 / 80 / 70 / 60 / 50 MANA",
				new String[] { "BASE CRITICAL DAMAGE: 140 / 160 / 180 / 200 / 220%",
						"CRITICAL DAMAGE WITH BACKSTAB BONUS: 168 / 192 / 216 / 240 / 264%" },
				new String[] { "ACTIVE: Shaco instantly blinks to a target nearby location and enters stealth for up to 3.5 seconds. Dealing damage will break stealth early. His next basic attack within 6 seconds is guaranteed to critically strike for modified base critical damage. Bonus critical damage from items, runes and mastery is applied for the full amount." });
		shacoSpells[2] = new SpellInfo(
				"Jack In The Box",
				"425",
				"16",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "FEAR DURATION: 0.5 / 0.75 / 1 / 1.25 / 1.5",
						"MAGIC DAMAGE: 35 / 50 / 65 / 80 / 95 (+ 20% AP)",
						"MAXIMUM MAGIC DAMAGE: 315 / 450 / 585 / 720 / 855 (+ 180% AP)" },
				new String[] { "ACTIVE: Shaco summons a box at the target location that stealths after a 2 second delay and lasts for up to 60 seconds. When an enemy comes within 300 units, the box springs open: causing surrounding enemies to turn and flee while it attacks nearby enemies for up to 5 seconds." });
		shacoSpells[3] = new SpellInfo(
				"Two-Shiv Poison",
				"625",
				"8",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "SLOW: 10 / 15 / 20 / 25 / 30%",
						"MISS CHANCE TO NON-CHAMPION UNITS: 20 / 22.5 / 25 / 27.5 / 30%",
						"MAGIC DAMAGE: 50 / 90 / 130 / 170 / 210 (+ 100% AP) (+ 100% Bonus AD)",
						"MAGIC DAMAGE WITH BACKSTAB BONUS: 60 / 108 / 156 / 204 / 252 (+ 120% AP) (+ 120% Bonus AD)" },
				new String[] {
						"PASSIVE: Shaco's basic attacks poison his targets, reducing their movement speed for 2 seconds. It also gives affected non-champion units a chance to miss their attacks.",
						"ACTIVE: Shaco throws a dagger at a target enemy dealing magic damage and applying his slowing poison to them for 3 seconds. The passive is deactivated during the cooldown." });
		shacoSpells[4] = new SpellInfo(
				"Hallucinate",
				"",
				"100 / 90 / 80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 300 / 450 / 600 (+ 100% AP)", "LEASH RADIUS: 1125", "AOE RADIUS: 250" },
				new String[] { "ACTIVE: Shaco vanishes for 0.5 seconds, then creates a clone of himself that will last for up to 18 seconds. The clone deals 75% of Shaco's damage and receives 50% extra damage. This clone deals 50% damage to towers and inhibitors. At the end of its duration or when dying the clone will explode, dealing magic damage to nearby enemies." });
		champSpells[77] = shacoSpells;

		SpellInfo[] shenSpells = new SpellInfo[5];
		// How do we want to do these special cases of cooldowns and such
		shenSpells[0] = new SpellInfo(
				"Ki Strike",
				"",
				"",
				"(STATIC) 9",
				arrS,
				new String[] { "Shen's next basic attack deals bonus magic damage equal to 4 + (4 × Shen's level) + (10% of Shen's bonus health) and restores 10 / 20 / 30 energy. Cooldown reduction does not affect Ki Strike, but Shen's basic attacks will reduce the cooldown of Ki Strike by 1 second each." });
		shenSpells[1] = new SpellInfo(
				"Vorpal Blade",
				"475",
				"6 / 5.5 / 5 / 4.5 / 4",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 100 / 140 / 180 / 220 (+ 60% AP)",
						"HEAL: 6 / 10 / 14 / 18 / 22 (+ 1.5% Shen's maximum health)",
						"NSTANT HEAL: 2 / 3 / 5 / 6 / 7 (+ 0.5% Shen's maximum health)" },
				new String[] {
						"ACTIVE: Shen throws a blade at the target enemy, dealing magic damage and marking them for 5 seconds. Shen and allied champions that damage a marked enemy will heal over 3 seconds, with the duration refreshing upon subsequent damage.",
						"If Vorpal Blade kills the target, Shen heals for 33% of the normal amount instantly." });
		// What if the range is self?
		shenSpells[2] = new SpellInfo(
				"Feint",
				"",
				"9 / 8 / 7 / 6 / 5",
				"50 ENERGY",
				new String[] { "SHIELD: 60 / 100 / 140 / 180 / 220 (+ 60% AP)" },
				new String[] { "ACTIVE: Shen gains a shield that absorbs a certain amount of damage. The shield dissipates after 3 seconds if not already destroyed. While the shield persists, Shen's basic attacks reduce the cooldown of Ki Strike by 2 seconds." });
		shenSpells[3] = new SpellInfo(
				"Shadow Dash",
				"600",
				"16 / 14 / 12 / 10 / 8",
				"120 ENERGY",
				new String[] { "MAGIC DAMAGE: 50 / 85 / 120 / 155 / 190 (+ 50% AP)" },
				new String[] { "ACTIVE: Shen dashes along target line, dealing magic damage to enemy champions he contacts and taunting them for 1.5 seconds. While taunted, enemies are forced to attack Shen and their basic attacks deal half damage. Shen gains 40 energy for each enemy champion he contacts." });
		// This one's range is "global" so ... maybe we set a special number that indicates global and another for self.
		// Or we change them to strings
		shenSpells[4] = new SpellInfo(
				"Stand United",
				"Global",
				"200 / 180 / 160",
				"NO COST",
				new String[] { "SHIELD: 250 / 550 / 850 (+ 135% AP)" },
				new String[] { "ACTIVE: Target allied champion gains a shield that absorbs a certain amount of damage. The shield dissipates after 5 seconds if not already destroyed. After 3 seconds of channeling, Shen teleports to the allied champion." });
		champSpells[78] = shenSpells;

		SpellInfo[] shyvanaSpells = new SpellInfo[5];
		shyvanaSpells[0] = new SpellInfo(
				"Dragonborn",
				"",
				"",
				"",
				arrS,
				new String[] { "Shyvana gains 5 / 10 / 15 / 20 armor and magic resist. These bonuses are doubled in Dragon Form." });
		shyvanaSpells[1] = new SpellInfo(
				"Twin Bite",
				"",
				"10 / 9 / 8 / 7 / 6",
				"",
				new String[] { "SECOND STRIKE PHYSICAL DAMAGE: 80 / 85 / 90 / 95 / 100% AD" },
				new String[] {
						"ACTIVE: Shyvana's next autoattack will strike twice in one swift movement. The second attack will deal physical damage equal to a percentage of her total attack damage. Both attacks will trigger on-hit effects. Shyvana's autoattacks against non-structures reduce the cooldown of Twin Bite by 0.5 seconds.",
						"DRAGON FORM: Twin Bite will damage all units in front of Shyvana when she uses her next autottack instead of just her target. Each unit hit will both trigger on-hit effects and grant fury twice." });
		shyvanaSpells[2] = new SpellInfo(
				"Burnout",
				"",
				"12",
				"",
				new String[] { "MAGIC DAMAGE PER SECOND: 20 / 35 / 50 / 65 / 80 (+ 20% bonus AD)",
						"MINIMUM MAGIC DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 60% bonus AD)",
						"MAXIMUM MAGIC DAMAGE: 140 / 245 / 350 / 455 / 560 (+ 140% bonus AD)",
						"INITIAL MOVEMENT SPEED BONUS: 30 / 35 / 40 / 45 / 50%" },
				new String[] {
						"ACTIVE: Shyvana surrounds herself in flame for 3 seconds, dealing magic damage to enemies within 162.5 range each second and gaining bonus movement speed. The bonus movement speed decreases by 15% of its original value per second. Shyvana's autoattacks extend the duration of Burnout by 1 second, to a maximum of 4 extra seconds.",
						"DRAGON FORM: Shyvana now scorches the earth where she walks, leaving a trail of fire for 5 seconds that will continually deal the same magic damage per second to enemies that pass over it." });
		shyvanaSpells[3] = new SpellInfo(
				"Flame Breath",
				"925",
				"12 / 11 / 10 / 9 / 8",
				"",
				new String[] { "MAGIC DAMAGE: 60 / 100 / 140 / 180 / 220 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Shyvana unleashes a fireball that travels in a line, dealing magic damage and marking enemies hit for 5 seconds. Basic attacks against marked enemies deal bonus magic damage equal to 2% of their maximum health (max. 100 vs. monsters).",
						"DRAGON FORM: Flame Breath engulfs all units in a cone in front of Shyvana." });
		shyvanaSpells[4] = new SpellInfo(
				"Dragon's Descent",
				"1000",
				"",
				"5 FURY PER SECOND",
				new String[] { "FURY GAINED PER 1.5 SECONDS: 1 / 2 / 3", "MAGIC DAMAGE: 175 / 300 / 425 (+ 70% AP)" },
				new String[] {
						"PASSIVE: Shyvana's basic attacks generate 2 fury, even in Dragon Form or against structures. While in human form, Shyvana passively generates fury every 1.5 seconds.",
						"ACTIVE: Shyvana transforms into a dragon and dashes to a target location. Enemies along her path take magic damage and are pushed toward her target location. While in Dragon Form, Shyvana's fury decays at a rate of 5 per second. Once her fury is depleted, she will return to her normal state." });
		champSpells[79] = shyvanaSpells;

		SpellInfo[] singedSpells = new SpellInfo[5];
		singedSpells[0] = new SpellInfo("Empowered Bulwark", "", "", "", arrS,
				new String[] { "Singed gains additional health equal to 25% of his maximum mana." });
		singedSpells[1] = new SpellInfo(
				"Poison Trail",
				"",
				"",
				"13 MANA PER SECON",
				new String[] { "MAGIC DAMAGE PER SECOND: 22 / 34 / 46 / 58 / 70 (+ 30% AP)",
						"TOTAL MAGIC DAMAGE: 66 / 102 / 138 / 174 / 210 (+ 90% AP)", "CLOUD RADIUS: 20" },
				new String[] { "TOGGLE: Singed leaves a trail of poison behind him that lasts for 3.25 seconds. Enemies caught in the path will be dealt magic damage each second for 3 seconds. Continual exposure renews the poison." });
		singedSpells[2] = new SpellInfo(
				"Mega Adhesive",
				"1000",
				"14",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "SLOW: 35 / 45 / 55 / 65 / 75%" },
				new String[] { "ACTIVE: Singed creates a pool of mega adhesive on the ground in a target 175-radius area. The adhesive lasts 5 seconds, causing all enemies who touch it to be slowed as long as they are in the adhesive and for 1 second once they are out of it." });
		singedSpells[3] = new SpellInfo(
				"Fling",
				"125",
				"10",
				"100 / 110 / 120 / 130 / 140 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 75% AP)" },
				new String[] { "ACTIVE: Singed flings a target enemy unit, dealing magic damage and placing the unit behind himself." });
		singedSpells[4] = new SpellInfo(
				"Insanity Potion",
				"",
				"100",
				"150 MANA",
				new String[] { "STATS ENHANCEMENT: 35 / 50 / 65",
						"HEALTH AND MANA RESTORED OVER 25 SECS: 175 / 250 / 325" },
				new String[] { "ACTIVE: Singed drinks a potent brew of chemicals, enhancing his ability power, armor, magic resistance, movement speed, health and mana regeneration per 5 seconds. Lasts 25 seconds." });
		champSpells[80] = singedSpells;

		SpellInfo[] sionSpells = new SpellInfo[5];
		sionSpells[0] = new SpellInfo(
				"Feel No Pain",
				"",
				"",
				"",
				arrS,
				new String[] { "Sion has a 40% chance to ignore up to 30 / 40 / 50 damage each time he is hit by a basic attack. The damage reduction is calculated before armor and percentage damage reduction benefits are taken into account." });
		sionSpells[1] = new SpellInfo(
				"Cryptic Gaze",
				"550",
				"12 / 11 / 10 / 9 / 8",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 125 / 180 / 240 / 300 (+ 90% AP)" },
				new String[] { "ACTIVE: Sion's gaze terrifies a single enemy, dealing magic damage and stunning it for 1.5 seconds." });
		sionSpells[2] = new SpellInfo(
				"Death's Caress",
				"",
				"8 seconds after shield expires",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "SHIELD STRENGTH/MAGIC DAMAGE: 100 / 150 / 200 / 250 / 300 (+ 90% AP)",
						"EXPLOSION AREA: 550" },
				new String[] { "ACTIVE: Sion surrounds himself with a shield which absorbs damage for up to 10 seconds. After 4 seconds, if the shield has not been destroyed, the ability can be cast again to explode and deal magic damage to surrounding enemies. It will explode automatically after the 10 seconds have passed." });
		sionSpells[3] = new SpellInfo(
				"Enrage",
				"",
				"",
				"COST: 6 / 8 / 10 / 12 / 14 HEALTH PER ATTACK",
				new String[] { "BONUS ATTACK DAMAGE: 25 / 35 / 45 / 55 / 65",
						"HEALTH GAINED PER KILL: 1 / 1.5 / 2 / 2.5 / 3" },
				new String[] { "TOGGLE: While toggled on, Sion has increased attack damage at the cost of some health for each basic attack. While Enrage is active, Sion permanently increases his maximum health whenever he kills a unit with either his attacks or abilities. This effect is doubled against champions and large units." });
		sionSpells[4] = new SpellInfo(
				"Cannibalism",
				"",
				"90",
				"100 MANA",
				new String[] { "BONUS LIFE STEAL: 50 / 75 / 100%", "HEAL TO NEARBY ALLIES: 25 / 37.5 / 50%",
						"AOE HEAL RADIUS: 200" },
				new String[] { "ACTIVE: For 20 seconds, Sion gains bonus lifesteal and 50% attack speed. Additionally, Sion's basic attacks will heal surrounding allies for a percentage of the damage dealt." });
		champSpells[81] = sionSpells;

		SpellInfo[] sivirSpells = new SpellInfo[5];
		sivirSpells[0] = new SpellInfo(
				"Fleet of Foot",
				"",
				"",
				"",
				arrS,
				new String[] { "Sivir gains 30 / 35 / 40 / 45 / 50 movement speed for 2 seconds when she hits an enemy champion with her abilities or basic attacks." });
		sivirSpells[1] = new SpellInfo(
				"Boomerang Blade",
				"1075",
				"9",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] {
						"PHYSICAL DAMAGE: 25 / 45 / 65 / 85 / 105 (+ 70 / 80 / 90 / 100 / 110% AD) (+ 50% AP)",
						"MAXIMUM PHYSICAL DAMAGE (SINGLE TARGET): 46.25 / 83.25 / 120.25 / 159.1 / 194.25 (+ 129.5 / 148 / 166.5 / 185 / 203.5% AD) (+ 92.5% AP)",
						"MINIMUM PHYSICAL DAMAGE: 10 / 18 / 26 / 34 / 42 (+ 28 / 32 / 36 / 40 / 44% AD) (+ 20% AP)" },
				new String[] { "ACTIVE: Sivir hurls her crossblade to a target location, which then returns to her. Enemies in its path take physical damage, with 15% reduced damage to each subsequent target, down to a minimum of 40%. Each enemy can be damaged only twice." });
		sivirSpells[2] = new SpellInfo(
				"Ricochet",
				"",
				"9 / 8 / 7 / 6 / 5",
				"60 MANA",
				new String[] { "BOUNCE DAMAGE: 50 / 55 / 60 / 65 / 70% AD" },
				new String[] { "ACTIVE: Sivir's next 3 basic attacks bounce to nearby enemies, dealing a percentage of her attack damage to each additional enemy hit. There is no limit on how many enemies that can be hit, but each enemy unit can only be hit once per attack." });
		sivirSpells[3] = new SpellInfo(
				"Spell Shield",
				"",
				"22 / 19 / 16 / 13 / 10",
				"NO COST",
				new String[] { "MANA RESTORED: 80 / 95 / 110 / 125 / 140" },
				new String[] { "ACTIVE: Sivir creates a magical barrier that lasts up to 1.5 seconds, blocking the next enemy ability used on Sivir. If an ability is blocked by the shield, Sivir gains mana." });
		sivirSpells[4] = new SpellInfo(
				"On the Hunt",
				"1000",
				"120 / 100 / 80",
				"100 MANA",
				new String[] { "BONUS ATTACK SPEED: 40 / 60 / 80%", "MOVEMENT SPEED DURATION: 2 / 3 / 4" },
				new String[] {
						"PASSIVE: Sivir gains bonus Attack Speed while  Ricochet is active.",
						"ACTIVE: Sivir rallies her allies for 8 seconds, granting all nearby allies an initial 60% Movement Speed bonus that reduces to 20% after a few seconds." });
		champSpells[82] = sivirSpells;

		SpellInfo[] skarnerSpells = new SpellInfo[5];
		skarnerSpells[0] = new SpellInfo(
				"Energize",
				"",
				"",
				"",
				arrS,
				new String[] { "Each basic attack reduces Skarner's ability cooldowns by 0.5 seconds. The effect is doubled when attacking enemy champions. Attacking structures will not trigger Energize." });
		skarnerSpells[1] = new SpellInfo(
				"Crystal Slash",
				"350",
				"3.5",
				"16 / 18 / 20 / 22 / 24 MANA",
				new String[] { "PHYSICAL DAMAGE: 25 / 40 / 55 / 70 / 85 (+ 80% bonus AD)",
						"ATTACK SPEED: 8 / 10 / 12 / 14 / 16%", "STACKED BONUS: 24 / 30 / 36 / 42 / 48%",
						"BONUS MAGIC DAMAGE: 24 / 36 / 48 / 60 / 72 (+ 40% AP)" },
				new String[] { "ACTIVE: Skarner deals physical damage to all enemies within range. Hitting an enemy will grant a stacking attack speed bonus for 5 seconds that stacks up to 3 times. While Skarner has stacks, Crystal Slash deals bonus magic damage." });
		skarnerSpells[2] = new SpellInfo(
				"Crystalline Explosion",
				"",
				"16",
				"60 MANA",
				new String[] { "SHIELD: 80 / 135 / 190 / 245 / 300 (+ 80% AP)",
						"MAX MOVEMENT SPEED: 16 / 20 / 24 / 28 / 32%" },
				new String[] { "ACTIVE: Skarner gains a health shield for 6 seconds. While the shield is active, Skarner gains an accelerating movement speed that reaches full strength after 3 seconds." });
		skarnerSpells[3] = new SpellInfo(
				"Fracture",
				"1000",
				"14",
				"60 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 70% AP)", "SLOW: 45 / 50 / 55 / 60 / 65%",
						"MISSILE WIDTH: 70", "MISSILE SPEED: 1500" },
				new String[] { "ACTIVE: Skarner deals magic damage to all enemies in a line and slows them for 2.5 seconds." });
		skarnerSpells[4] = new SpellInfo(
				"Impale",
				"350",
				"130 / 120 / 110",
				"100 / 125 / 150 MANA",
				new String[] { "MAGIC DAMAGE: 100 / 150 / 200 (+ 50% AP)", "TOTAL DAMAGE: 200 / 300 / 400 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Skarner rears his stinger, rooting his target for ~0.25 seconds as he bring his stinger down: dealing magic damage and suppressing them for 1.75 seconds. For the duration, Skarner can move freely and will drag his victim around with him. At the end of the suppression, the target takes the same damage again.",
						"If Skarner loses sight of his target or if his target exceeds a range threshold during the ~0.25 seconds, the ability is canceled but does not go on cooldown." });
		champSpells[83] = skarnerSpells;

		SpellInfo[] sonaSpells = new SpellInfo[5];
		sonaSpells[0] = new SpellInfo(
				"Power Chord",
				"",
				"",
				"",
				arrS,
				new String[] { "After 3 ability casts, Sona's next basic attack will deal 13 / 20 / 27 / 35 / 43 / 52 / 62 / 72 / 82 / 92 / 102 / 112 / 122 / 132 / 147 / 162 / 177 / 192 (6 + 7 / 8 / 9 / 10 / 15 at each level) (+ 20% AP) bonus magic damage, with an additional effect depending on the last basic ability cast." });
		sonaSpells[1] = new SpellInfo(
				"Hymn of Valor",
				"700",
				"7",
				"45 / 50 / 55 / 60 / 65 MANA",
				new String[] { "MAGIC DAMAGE: 50 / 100 / 150 / 200 / 250 (+ 50% AP)",
						"ATTACK DAMAGE & ABILITY POWER: 4 / 8 / 12 / 16 / 20" },
				new String[] {
						"ACTIVATION: Sona sends out bolts of sound that deal magic damage to the two nearest enemy units within range, prioritizing champions.",
						"STANCE - PERSISTENT AURA: Sona plays the Hymn of Valor, granting nearby allied champions within 1000 range bonus attack damage and ability power. ",
						"POWER CHORD - STACCATO: If this spell was last cast when Power Chord is ready, Power Chord deals double damage." });
		sonaSpells[2] = new SpellInfo(
				"Aria of Perseverance",
				"1000",
				"7",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "HEAL: 40 / 55 / 70 / 85 / 100 (+ 25% AP)", "ARMOR & MAGIC RESIST: 6 / 7 / 8 / 9 / 10",
						"AURA ARMOR & MAGIC RESIST: 6 / 7 / 8 / 9 / 10" },
				new String[] {
						"ACTIVATION: Sona heals herself and a nearby allied champion with the lowest health percentage, granting both of them bonus armor and magic resistance for 3 seconds. ",
						"STANCE - PERSISTENT AURA: Sona plays the Aria of Perseverance, granting nearby allied champions within 1000 range bonus armor and magic resistance. ",
						"POWER CHORD - DIMINUENDO: If this spell was last cast when Power Chord is ready, Power Chord will also reduce the target's damage output by 20% (+ 2% per 100 AP) for 3 seconds." });
		sonaSpells[3] = new SpellInfo(
				"Song of Celerity",
				"1000",
				"7",
				"65 MANA",
				new String[] { "MOVEMENT SPEED: 4 / 6 / 8 / 10 / 12% (+ 2% per 100 AP)",
						"FLAT MOVEMENT SPEED: 4 / 8 / 12 / 16 / 20" },
				new String[] {
						"ACTIVATION: Sona grants nearby allies increased movement speed for 1.5 seconds. ",
						"STANCE - PERSISTENT AURA: Sona plays the Song of Celerity, granting nearby allied champions within 1000 range a flat movement speed bonus. ",
						"POWER CHORD - TEMPO: If this spell was last cast when Power Chord is ready, Power Chord will also slow the target by 40% (+ 4% per 100 AP) for 2 seconds." });
		sonaSpells[4] = new SpellInfo(
				"Crescendo",
				"1000",
				"140 / 120 / 100",
				"100 / 150 / 200 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 50% AP)" },
				new String[] { "ACTIVE: Sona plays an irresistible chord in a line, dealing magic damage to enemy champions and stunning them for 1.5 seconds, forcing them to dance." });
		champSpells[84] = sonaSpells;

		SpellInfo[] sorakaSpells = new SpellInfo[5];
		sorakaSpells[0] = new SpellInfo(
				"Salvation",
				"",
				"",
				"",
				arrS,
				new String[] { "Soraka's health and mana restoring abilities are 1% more powerful for every 2% of the target's missing health or mana." });
		sorakaSpells[1] = new SpellInfo(
				"Starcall",
				"530",
				"2.5",
				"30 / 40 / 50 / 60 / 70 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 40% AP)",
						"ASTRAL BLESSING'S COOLDOWN REDUCTION: 5 / 6.25 / 7.5 / 8.75 / 10%" },
				new String[] {
						"ACTIVE: Soraka summons a shower of stars to fall from the sky, striking all nearby enemy units within range for magic damage and reducing their magic resistance by 6 (+1% AP) for 5 seconds. This effect stacks up to 10 times.",
						"If Starcall hits at least one enemy champion,  Astral Blessing's cooldown is reduced by a percentage of its base cooldown (after factoring in cooldown reduction)." });
		sorakaSpells[2] = new SpellInfo(
				"Astral Blessing",
				"750",
				"20",
				"80 / 100 / 120 / 140 / 160 MANA",
				new String[] { "HEAL: 70 / 120 / 170 / 220 / 270 (+ 35% AP)",
						"SALVATION - MAXIMUM HEAL: 105 / 180 / 255 / 330 / 402.3 (+ 52.15% AP)",
						"BONUS ARMOR: 50 / 65 / 80 / 95 / 110 (+15% AP)" },
				new String[] { "ACTIVE: Soraka blesses a friendly unit, restoring health and granting them bonus armor for 2 seconds." });
		sorakaSpells[3] = new SpellInfo(
				"Infuse",
				"725",
				"10",
				"5% OF MAXIMUM MANA / NO COST",
				new String[] { "MANA RESTORED: 20 / 40 / 60 / 80 / 100 (+5% maximum mana)",
						"SALVATION - MAXIMUM MANA RESTORED: 30 / 60 / 90 / 120 / 150 (+7.5% maximum mana)",
						"MAGIC DAMAGE: 40 / 70 / 100 / 130 / 160 (+ 40% AP) (+5% maximum mana)",
						"SILENCE DURATION: 1.5 / 1.75 / 2 / 2.25 / 2.5" },
				new String[] {
						"ACTIVE - ALLIED CHAMPION TARGET: Soraka drains 5% of her maximum mana to restore mana to her target ally. Soraka cannot use Infuse on herself or champions who do not require mana.",
						"ACTIVE - ENEMY TARGET: Soraka silences the target and deals magic damage to them." });
		sorakaSpells[4] = new SpellInfo(
				"Wish",
				"Global",
				"160 / 145 / 130",
				"100 MANA",
				new String[] { "HEAL: 150 / 250 / 350 (+ 55% AP)",
						"SALVATION - MAXIMUM HEAL: 225 / 375 / 525 (+ 82.5% AP)" },
				new String[] { "ACTIVE: Soraka fills her allies with hope, restoring health to herself and all friendly champions. Wish can affect untargetable allies." });
		champSpells[85] = sorakaSpells;

		SpellInfo[] swainSpells = new SpellInfo[5];
		swainSpells[0] = new SpellInfo(
				"Carrion Renewal",
				"",
				"",
				"",
				arrS,
				new String[] { "Whenever Swain kills an enemy unit, he regains 9 + (1 × level) mana. On a champion kill or assist, he regains an additional 9% of his maximum mana pool." });
		swainSpells[1] = new SpellInfo(
				"Decrepify",
				"625",
				"8",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 25 / 40 / 55 / 70 / 85 (+ 30% AP)",
						"MAXIMUM MAGIC DAMAGE: 75 / 120 / 165 / 210 / 255 (+ 90% AP)", "SLOW: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Swain releases his raven at his current location to cripple an enemy, creating a tether between the target and the raven. Over the next 3 seconds, the target takes magic damage each second and is slowed. If enemies walk out 900 range of the tether, the effect ends immediately." });
		swainSpells[2] = new SpellInfo(
				"Nevermore",
				"900",
				"18 / 16 / 14 / 12 / 10",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 70% AP)" },
				new String[] { "ACTIVE: Swain marks a target 125-radius area. After a short delay talons grab onto enemy units within the area, dealing magic damage and rooting them for 2 seconds." });
		swainSpells[3] = new SpellInfo(
				"Torment",
				"625",
				"10",
				"65 / 70 / 75 / 80 / 85 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 115 / 155 / 195 / 235 (+ 80% AP)",
						"EXTRA DAMAGE: 8 / 11 / 14 / 17 / 20%",
						"TOTAL MAGIC DAMAGE: 81 / 127.65 / 176.7 / 228.15 / 282 (+ 86.4 / 88.8 / 91.2 / 93.6 / 96% AP)" },
				new String[] { "ACTIVE: Swain afflicts his target with a curse that deals magic damage to them over 4 seconds, and causes any further damage dealt by Swain during this period to be increased by a percentage. This includes items used by Swain." });
		swainSpells[4] = new SpellInfo(
				"Ravenous Flock",
				"700 (estimate)",
				"8",
				"25 INITIAL MANA PER SECOND",
				new String[] { "MAGIC DAMAGE PER RAVEN: 50 / 70 / 90 (+ 20% AP)",
						"ADDITIONAL MANA COST EACH SECOND: 5 / 6 / 7" },
				new String[] { "TOGGLE: Swain transforms into the form of a vicious raven. During this time up to 3 lesser ravens strike out each second to deal magic damage to nearby enemies, one raven per enemy and prioritizing champions. Swain is healed for 75% of the damage dealt to champions and 25% of the damage dealt to minions and monsters. The mana cost to sustain Ravenous Flock increases every second." });
		champSpells[86] = swainSpells;

		SpellInfo[] syndraSpells = new SpellInfo[6];
		syndraSpells[0] = new SpellInfo("Transcendent", "", "", "", arrS,
				new String[] { "Each of Syndra's abilities gain an extra effect at maximum rank." });
		syndraSpells[1] = new SpellInfo(
				"Dark Sphere",
				"800",
				"4",
				"40 / 50 / 60 / 70 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 110 / 150 / 190 / 230 (+ 60% AP)",
						"MAGIC DAMAGE TO CHAMPIONS (RANK 5): 264.5 (+ 69% AP)" },
				new String[] {
						"ACTIVE: Conjures a Dark Sphere at a target location, dealing magic damage. The sphere lasts for up to 6 seconds and can be manipulated by Syndra's other abilities.",
						"TRANSCENDENT BONUS: Deals 15% bonus damage against Champions." });
		syndraSpells[2] = new SpellInfo(
				"Force of Will - Grab",
				"925",
				"12 / 11 / 10 / 9 / 8",
				"60 / 70 / 80 / 90 / 100 MANA",
				arrS,
				new String[] { "ACTIVE: Grabs a dark sphere, enemy minion or neutral monster for 5 seconds. If a dark sphere is grabbed, its duration is refreshed. If a minion or monster is grabbed, it becomes untargetable, invulnerable, and disabled until released." });
		syndraSpells[3] = new SpellInfo(
				"Force of Will - Throw",
				"950",
				"",
				"",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 70% AP)",
						"SLOW: 25% / 30% / 35% / 40% / 45%" },
				new String[] {
						"ACTIVE: Throws the grasped Dark Sphere or enemy at a target area. The thrown unit, if it is an enemy, and any enemies struck take magic damage and are slowed for 1.5 second. This ability also provides vision through fog of war or brushes before it lands.",
						"TRANSCENDENT BONUS: Increases the slowing duration to 2 seconds." });
		syndraSpells[4] = new SpellInfo(
				"Scatter the Weak",
				"700",
				"18 / 16.5 / 15 / 13.5 / 12",
				"50 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 40% AP)", "MISSILE SPEED: 2500" },
				new String[] {
						"ACTIVE: Knocks enemies and Dark Spheres back, dealing magic damage to them and any enemies with which they collide. The distance of the knockback increases depending on how close the affected units are to Syndra upon cast. Dark Spheres that are knocked back also stun all enemies in their path for 1.5 seconds.",
						"TRANSCENDENT BONUS: Spell width increased by 50%." });
		syndraSpells[5] = new SpellInfo(
				"Unleashed Power",
				"675 / 750",
				"100 / 90 / 80",
				"100 MANA",
				new String[] { "DAMAGE PER SPHERE: 90 / 135 / 180 (+ 20% AP)",
						"MINIMUM DAMAGE (3 SPHERES): 270 / 405 / 540 (+ 60% AP)",
						"MAXIMUM DAMAGE (7 SPHERES): 630 / 975 / 1260 (+ 140% AP)" },
				new String[] {
						"ACTIVE: Draws upon Syndra's full cataclysmic power, harnessing all Dark Spheres to deal magic damage to her target per sphere. Unleashed Power will use the three spheres that orbit Syndra, ensuring a minimum damage.",
						"All Dark Spheres remain on the ground for 6 seconds after Unleashed Power is used.",
						"TRANSCENDENT BONUS: Cast range increased by 75." });
		champSpells[87] = syndraSpells;

		SpellInfo[] talonSpells = new SpellInfo[5];
		talonSpells[0] = new SpellInfo(
				"Mercy",
				"",
				"",
				"",
				arrS,
				new String[] { "Talon's autoattacks deal 10% additional damage to any target that is slowed, stunned, immobilized or suppressed." });
		talonSpells[1] = new SpellInfo(
				"Noxian Diplomacy",
				"",
				"8 / 7 / 6 / 5 / 4",
				"40 / 45 / 50 / 55 / 60 MANA",
				new String[] { "BONUS PHYSICAL DAMAGE: 30 / 60 / 90 / 120 / 150 (+ 30% bonus AD)",
						"DAMAGE OVER TIME: 10 / 20 / 30 / 40 / 50 (+ 100% bonus AD)",
						"TOTAL PHYSICAL DAMAGE: 40 / 80 / 120 / 160 / 200 (+ 130% bonus AD)" },
				new String[] { "ACTIVE: Talon's next autoattack within the next 6 seconds deals bonus physical damage. If the target is a champion they will also bleed for 6 seconds, granting sight of their location to Talon and taking additional physical damage each second for the duration." });
		talonSpells[2] = new SpellInfo(
				"Rake",
				"600",
				"10",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "PHYSICAL DAMAGE PER HIT: 30 / 55 / 80 / 105 / 130 (+ 60% bonus AD)",
						"TOTAL PHYSICAL DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 120% bonus AD)",
						"SLOW: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Talon sends out a volley of daggers in a cone that then quickly return back to him, dealing physical damage to any enemies it passes through. Each enemy can only be damaged once at the start of the ability and once at the end. Additionally the enemy is slowed for 2 seconds, refreshing the duration of the slow if they are hit twice." });
		talonSpells[3] = new SpellInfo(
				"Cutthroat",
				"700",
				"18 / 16 / 14 / 12 / 10",
				"35 / 40 / 45 / 50 / 55 MANA",
				new String[] { "DAMAGE AMPLIFICATION: 3 / 6 / 9 / 12 / 15%" },
				new String[] { "ACTIVE: Talon instantly appears behind his target, silencing them for 1 second and amplifying his damage against that target for 3 seconds." });
		talonSpells[4] = new SpellInfo(
				"Shadow Assault",
				"",
				"75 / 65 / 55",
				"80 / 90 / 100 MANA",
				new String[] { "PHYSICAL DAMAGE PER HIT: 120 / 170 / 220 (+ 75% bonus AD)",
						"TOTAL PHYSICAL DAMAGE: 240 / 340 / 440 (+ 150% bonus AD)" },
				new String[] { "ACTIVE: Talon disperses blades outwards in a 500-radius ring and gains stealth for up to 2.5 seconds while gaining 40% movement speed. When Talon emerges from stealth, the blades converge on his location. When the ring of blades expands and contracts, enemies hit receive physical damage. Each enemy can only be damaged once at the start of the ability and once at the end." });
		champSpells[88] = talonSpells;

		SpellInfo[] taricSpells = new SpellInfo[5];
		taricSpells[0] = new SpellInfo(
				"Gemcraft",
				"",
				"",
				"",
				arrS,
				new String[] { "After using an ability, Taric's next basic attack deals bonus magic damage equal to 20% of Taric's armor and reduces his abilities' cooldown by 2 seconds." });
		taricSpells[1] = new SpellInfo(
				"Imbue",
				"750",
				"18 / 17 / 16 / 15 / 14",
				"60 / 80 / 100 / 120 / 140 MANA",
				new String[] { "HEAL: 60 / 100 / 140 / 180 / 220 (+ 30% AP) (+ 5% bonus health)",
						"SELF HEAL: 84 / 140 / 196 / 252 / 308 (+ 42% AP) (+ 7% bonus health)" },
				new String[] { "ACTIVE: Taric channels earthen energy to heal a target allied unit. As the magic flows through them he is healed for the same amount. If Taric heals only himself, the heal will be 40% more effective." });
		taricSpells[2] = new SpellInfo(
				"Shatter",
				"",
				"10",
				"50 MANA",
				new String[] { "ARMOR: 10 / 15 / 20 / 25 / 30",
						"MAGIC DAMAGE: 40 / 80 / 120 / 160 / 200 (+ 20% armor)",
						"ARMOR REDUCTION: 5 / 10 / 15 / 20 / 25 (+ 5% armor)" },
				new String[] {
						"PASSIVE: Taric reinforces his armor with gemstones, increasing his armor while Shatter is off cooldown. He also gains a 500-range aura increasing his armor and allied champions' armor by 12% of his total armor.",
						"ACTIVE: Taric shatters his gemstones, dealing magic damage to nearby enemies within 200 range and reducing their armor for 4 seconds." });
		taricSpells[3] = new SpellInfo(
				"Dazzle",
				"625",
				"18 / 17 / 16 / 15 / 14",
				"75 MANA",
				new String[] { "STUN DURATION: 1.2 / 1.3 / 1.4 / 1.5 / 1.6",
						"MINIMUM MAGIC DAMAGE: 40 / 70 / 100 / 130 / 160 (+ 20% AP)",
						"MAXIMUM MAGIC DAMAGE: 80 / 140 / 200 / 260 / 320 (+ 40% AP)", "MISSILE SPEED: 1400" },
				new String[] { "ACTIVE: Taric fires a prismatic sphere at a target enemy. On impact the target is stunned and takes magic damage that increases the closer the target is to Taric (up to 200%)." });
		taricSpells[4] = new SpellInfo(
				"Radiance",
				"200",
				"75",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 50% AP)",
						"SELF ATTACK DAMAGE & ABILITY POWER BONUS: 30 / 50 / 70",
						"AURA ATTACK DAMAGE & ABILITY POWER BONUS: 15 / 25 / 35" },
				new String[] { "ACTIVE: Taric slams the ground with his hammer, dealing magic damage to enemies within range. For the next 10 seconds, Taric emits an aura of light that increases his attack damage and ability power, while allies within 500 range gain half of those bonuses." });
		champSpells[89] = taricSpells;

		SpellInfo[] teemoSpells = new SpellInfo[5];
		teemoSpells[0] = new SpellInfo(
				"Camouflage",
				"",
				"",
				"",
				arrS,
				new String[] { "If Teemo stands still and takes no action for 2 seconds, he becomes stealthed. Taking any action will break his camouflage, granting him 40% attack speed for 3 seconds." });
		teemoSpells[1] = new SpellInfo(
				"Blinding Dart",
				"580",
				"8",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 80% AP)",
						"BLIND DURATION: 1.5 / 1.75 / 2 / 2.25 / 2.5" },
				new String[] { "ACTIVE: Teemo shoots a dart at an enemy, dealing magic damage and blinding them for a few seconds." });
		teemoSpells[2] = new SpellInfo(
				"Move Quick",
				"",
				"17",
				"40 MANA",
				new String[] { "PASSIVE MOVEMENT SPEED: 10 / 14 / 18 / 22 / 26%",
						"ACTIVE MOVEMENT SPEED: 20 / 28 / 36 / 44 / 52%" },
				new String[] {
						"PASSIVE: Teemo gains increased movement speed. Damage from champions and structures will disable this bonus for 5 seconds.",
						"ACTIVE: For 3 seconds, Teemo doubles his passive movement speed bonus. While active, Move Quick's bonus cannot be disabled via champion or structure damage." });
		teemoSpells[3] = new SpellInfo(
				"Toxic Shot",
				"",
				"",
				"",
				new String[] { "MAGIC DAMAGE ON HIT: 10 / 20 / 30 / 40 / 50 (+ 30% AP)",
						"MAGIC DAMAGE PER SECOND: 6 / 12 / 18 / 24 / 30 (+ 10% AP)",
						"TOTAL MAGIC DAMAGE OVER TIME: 24 / 48 / 72 / 96 / 120 (+ 40% AP)",
						"TOTAL DAMAGE FOR ONE HIT: 34 / 68 / 102 / 136 / 170 (+ 70% AP)" },
				new String[] { "PASSIVE: Teemo's auto-attacks deal bonus magic damage and poison his target, causing them to take additional magic damage over 4 seconds. Subsequent attacks only refresh the duration." });
		teemoSpells[4] = new SpellInfo(
				"Noxious Trap",
				"230",
				"1",
				"75 / 100 / 125 MANA",
				new String[] { "MAGIC DAMAGE PER SECOND: 50 / 81.25 / 112.5 (+ 12.5% AP)",
						"TOTAL MAGIC DAMAGE: 200 / 325 / 450 (+ 50% AP)", "SLOW: 30 / 40 / 50%",
						"CHARGE RECEIVE TIME: 35 / 31 / 27" },
				new String[] {
						"ACTIVE: Teemo places a mushroom trap on the ground, which stealths and arms after 1 second. While armed, the traps grant vision in a 212.5 radius. If an enemy comes within 60 range of the trap, it will detonate, slowing and dealing damage over 4 seconds to nearby enemies within 200 radius. Each mushroom has 100 health and can only be destroyed by auto-attacks.",
						"Noxious Traps have a 10 minute duration. Teemo generates a new trap periodically, affected by cooldown reduction, and can only store up to 3 traps at once." });
		champSpells[90] = teemoSpells;

		SpellInfo[] threshSpells = new SpellInfo[5];
		threshSpells[0] = new SpellInfo(
				"Damnation",
				"",
				"",
				"",
				arrS,
				new String[] {
						"Thresh does not gain armor per level. Instead, Thresh collects the souls of dead enemies by approaching them or by placing Dark Passage's lantern nearby. Each soul permanently grants 0.75 armor and ability power. Champions and large minions and monsters always drop a soul. Small minions and monsters only sometimes drop a soul.",
						"A soul will only drop if the enemy unit dies within 1900 range of Thresh. Souls are visible to allies, and only become visible to enemies if the enemy team has vision of Thresh. Souls disappear if not picked up after 8 seconds." });
		threshSpells[1] = new SpellInfo(
				"Death Sentence",
				"1100",
				"20 / 18 / 16 / 14 / 12",
				"80 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+50% AP)" },
				new String[] {
						"ACTIVE: After a 0.5 second wind-up, Thresh throws out his scythe in a line and forms a tether with the first enemy hit, dealing magic damage and stunning it for 1.5 seconds. Upon hitting an enemy, Death Sentence's current cooldown is reduced by 3 seconds.",
						"While the tether persists, Thresh cannot attack and he will periodically tug on the tether, each time pulling the target a short distance toward himself. After 0.5 seconds, or instantly if he hooks a minion or monster, Thresh can reactivate the ability to use Death Leap.",
						"ACTIVE - DEATH LEAP: Thresh pulls himself to the bound enemy. This removes the stun but allows Thresh to attack again. Thresh loses the ability to activate Death Leap when the tether breaks." });
		threshSpells[2] = new SpellInfo(
				"Dark Passage",
				"950",
				"22 / 20.5 / 19 / 17.5 / 16",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "SHIELD AMOUNT: 60 / 100 / 140 / 180 / 220 (+40% AP)" },
				new String[] {
						"ACTIVE: Thresh throws his lantern to the target location where it remains for up to 6 seconds. If an ally right-clicks the lantern, they will pick it up and will be pulled to Thresh's location. If Thresh moves more than ~1500 units away, the lantern will return to him.",
						"For the next 6 seconds, allies who come near the lantern (even while Thresh is holding it) gain a shield that absorbs damage for up to 4 seconds. Allies can only receive the shield once per cast." });
		threshSpells[3] = new SpellInfo(
				"Flay",
				"400 (800 total)",
				"9",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "BONUS MAGIC DAMAGE: Souls + up to 80 / 110 / 140 / 170 / 200% AD",
						"ACTIVE MAGIC DAMAGE: 65 / 95 / 125 / 155 / 185 (+40% AP)",
						"SLOW AMOUNT: 20 / 25 / 30 / 35 / 40%" },
				new String[] {
						"PASSIVE: Thresh's basic attacks deal bonus magic damage on each hit. This value is equal to the total number of souls collected, plus a percentage of his attack damage based on the amount of time since his last attack.",
						"ACTIVE: Thresh sweeps his chain in a broad line towards a target direction. Enemies hit take magic damage, are knocked in the same direction as the chains, and are slowed afterwards for 1.5 seconds." });
		threshSpells[4] = new SpellInfo(
				"The Box",
				"450",
				"150 / 140 / 130",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 250 / 400 / 550 (+100% AP)",
						"REMAINING WALLS DAMAGE: 125 / 200 / 275 (+50% AP)" },
				new String[] { "ACTIVE: After a 0.75 second delay, Thresh summons 5 spectral walls around him that last up to 5 seconds. Enemy champions that touch a wall take magic damage and are slowed by 99% for 2 seconds, but break the wall. Once one wall is broken, the remaining walls deal half damage and apply half the slow duration. An enemy can be affected by multiple walls." });
		champSpells[91] = threshSpells;

		SpellInfo[] tristanaSpells = new SpellInfo[5];
		tristanaSpells[0] = new SpellInfo(
				"Draw a Bead",
				"",
				"",
				"",
				arrS,
				new String[] { "Tristana's attack range and Explosive Shot's cast range increases by 9 every level (excluding level 1). At level 18, the bonus is 153 (703 range at level 18)." });
		tristanaSpells[1] = new SpellInfo("Rapid Fire", "", "20", "NO COST",
				new String[] { "ATTACK SPEED: 30 / 45 / 60 / 75 / 90%" },
				new String[] { "ACTIVE: Increases Tristana's attack speed for 7 seconds." });
		tristanaSpells[2] = new SpellInfo(
				"Rocket Jump",
				"900",
				"22 / 20 / 18 / 16 / 14",
				"80 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 80% AP)" },
				new String[] { "ACTIVE: Tristana fires at the ground to propel herself to a target location, dealing magic damage and slowing surrounding units by 60% for 2.5 seconds when she lands. Rocket Jump's cooldown resets whenever Tristana gains a kill or assist." });
		tristanaSpells[3] = new SpellInfo(
				"Explosive Shot",
				"650 (803 at level 18)",
				"16",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "EXPLOSION MAGIC DAMAGE: 50 / 75 / 100 / 125 / 150 (+ 25% AP)",
						"SHOT MAGIC DAMAGE: 110 / 150 / 190 / 230 / 270 (+ 100% AP)" },
				new String[] {
						"PASSIVE: Enemies explode when slain by Tristana's basic attacks, dealing magic damage to enemies within 75 range.",
						"ACTIVE: Rends the target enemy with shrapnel, reducing healing and health regeneration by 50% and dealing magic damage over 5 seconds." });
		tristanaSpells[4] = new SpellInfo(
				"Buster Shot",
				"645",
				"60",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 300 / 400 / 500 (+ 150% AP)", "KNOCKBACK DISTANCE: 600 / 800 / 1000",
						"KNOCKBACK FORCE WIDTH: 200" },
				new String[] { "ACTIVE: Tristana fires a massive cannonball at an enemy unit, dealing magic damage and knocking them and surrounding units back." });
		champSpells[92] = tristanaSpells;

		SpellInfo[] trundleSpells = new SpellInfo[5];
		trundleSpells[0] = new SpellInfo("King's Tribute", "1000", "", "", arrS, new String[] { "" });
		trundleSpells[1] = new SpellInfo(
				"Chomp",
				"",
				"4",
				"30 MANA",
				new String[] { "PHYSICAL DAMAGE: 20 / 40 / 60 / 80 / 100 (+ 100 / 105 / 110 / 115 / 120% AD)",
						"ATTACK DAMAGE BONUS: 20 / 25 / 30 / 35 / 40" },
				new String[] {
						"ACTIVE: Trundle bites his target with this next basic attack, dealing physical damage equal to a base amount plus a percentage of his attack damage and slowing his target by 75% for 0.1 seconds.",
						"This attack increases Trundle's attack damage for 8 seconds, with his opponent losing half of this amount for the same duration." });
		trundleSpells[2] = new SpellInfo(
				"Frozen Domain",
				"900",
				"15",
				"60 MANA",
				new String[] { "MOVEMENT SPEED: 20 / 25 / 30 / 35 / 40%", "ATTACK SPEED: 20 / 35 / 50 / 65 / 80%",
						"HEALING AND REGENERATION INCREASE: 8 / 11 / 14 / 17 / 20%" },
				new String[] { "ACTIVE: Trundle coats a target 1000-radius area with ice for 8 seconds, gaining increased movement speed, attack speed, and healing and regeneration from all sources while he is on it." });
		trundleSpells[3] = new SpellInfo(
				"Pillar of Ice",
				"1000",
				"23 / 20 / 17 / 14 / 11",
				"60 MANA",
				new String[] { "PILLAR SLOW: 25 / 30 / 35 / 40 / 45%" },
				new String[] { "ACTIVE: Trundle summons an impassable pillar of ice at a target location for 6 seconds. Enemies caught in the center of the eruption are briefly knocked back. The pillar blocks movement within 62.5 range and slows enemies within 187.5 range." });
		trundleSpells[4] = new SpellInfo(
				"Subjugate",
				"700",
				"80 / 70 / 60",
				"75 MANA",
				new String[] {
						"INITIAL MAGIC DAMAGE / HEALTH DRAIN: 10 / 12 / 14% (+ 1% per 100 AP) of target's maximum health",
						"MAGIC DAMAGE / DRAIN PER SECOND: 2.5 / 3 / 3.5% (+ 0.25% per 100 AP) of target's maximum health",
						"TOTAL MAGIC DAMAGE / HEALTH DRAIN: 20 / 24 / 28% (+ 2% per 100 AP) of target's maximum health" },
				new String[] {
						"ACTIVE: Trundle drains the life force out of an enemy champion, dealing magic damage equal to a percentage of their maximum health and healing himself for the same amount, as well as stealing 40% of their armor and magic resist. Half of the health, armor, and magic resist is drained immediately and the other half over the next 4 seconds.",
						"The armor and magic resist bonus/reduction slowly decays over 4 seconds after the drain completes." });
		champSpells[93] = trundleSpells;

		SpellInfo[] tryndamereSpells = new SpellInfo[5];
		tryndamereSpells[0] = new SpellInfo(
				"Battle Fury",
				"",
				"",
				"",
				arrS,
				new String[] { "Tryndamere receives 0.35% bonus critical strike chance per point of Fury he currently has, for a maximum of 35% critical chance at 100 Fury." });
		tryndamereSpells[1] = new SpellInfo(
				"Bloodlust",
				"",
				"12",
				"",
				new String[] {
						"ATTACK DAMAGE BONUS: 5 / 10 / 15 / 20 / 25 + 0.15 / 0.2 / 0.25 / 0.3 / 0.35 per 1% of missing health",
						"MAXIMUM BONUS: 20 / 30 / 40 / 50 / 60",
						"HEAL: 30 / 40 / 50 / 60 / 70 (+ 30% AP) + 0.5 / 0.95 / 1.4 / 1.85 / 2.3 (+ 1.2% AP) per 1 fury consumed",
						"MAXIMUM HEAL: 80 / 135 / 190 / 245 / 300 (+ 150% AP)" },
				new String[] {
						"PASSIVE: Permanently grants Tryndamere increased attack damage, granting a larger bonus per 1% of health he is missing.",
						"ACTIVE: Tryndamere consumes all of his current Fury, restoring health equal to a base amount plus extra health per point of Fury consumed." });
		tryndamereSpells[2] = new SpellInfo(
				"Mocking Shout",
				"400",
				"14",
				"",
				new String[] { "ATTACK DAMAGE REDUCTION: 20 / 35 / 50 / 65 / 80", "SLOW: 30 / 37.5 / 45 / 52.5 / 60%" },
				new String[] { "ACTIVE: Decreases surrounding enemy champions' attack damage. Enemies with their backs turned to Tryndamere also have their movement speed slowed for 4 seconds." });
		tryndamereSpells[3] = new SpellInfo(
				"Spinning Slash",
				"660",
				"13 / 12 / 11 / 10 / 9",
				"",
				new String[] { "PHYSICAL DAMAGE: 70 / 100 / 130 / 160 / 190 (+ 100% AP) (+ 120% Bonus AD)",
						"SPIN RADIUS: 225" },
				new String[] {
						"ACTIVE: Tryndamere performs a spinning slash to the target location, dealing physical damage to enemies in his path. The cooldown is reduced by 1 seconds whenever Tryndamere critically strikes and doubled against champions (2 seconds).",
						"Spinning Slash grants 2 Fury per enemy hit and 10 Fury per unit killed." });
		tryndamereSpells[4] = new SpellInfo(
				"Undying Rage",
				"",
				"COOLDOWN: 110 / 100 / 90",
				"",
				new String[] { "FURY GAINED: 50 / 75 / 100" },
				new String[] {
						"ACTIVE: Tryndamere instantly receives Fury and becomes immune to death for 5 seconds during which his health cannot fall below 1. This move is usable even when stunned, silenced or suppressed. This ability has a 0.5 second delay before activating.",
						"If Tryndamere is below 3% health when Undying Rage ends, it will heal him to 3%." });
		champSpells[94] = tryndamereSpells;

		SpellInfo[] twistedFateSpells = new SpellInfo[9];
		twistedFateSpells[0] = new SpellInfo(
				"Loaded Dice",
				"",
				"",
				"",
				arrS,
				new String[] { "Upon killing a unit, Twisted Fate rolls his dice, gaining from 1 to 6 bonus gold. Naturally, Twisted Fate has a higher chance to receive a larger bonus." });
		twistedFateSpells[1] = new SpellInfo(
				"Wild Cards",
				"1450",
				"6",
				"60 / 70 / 80 / 90 / 100 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 110 / 160 / 210 / 260 (+ 65% AP)" },
				new String[] { "ACTIVE: Twisted Fate throws 3 cards forward in an arc, dealing magic damage to enemies they pass through." });
		twistedFateSpells[2] = new SpellInfo(
				"Pick A Card",
				"",
				"6",
				"40 / 55 / 70 / 85 / 100 MANA",
				new String[] { "" },
				new String[] { "ACTIVE: When first activated, cards flash over Twisted Fate's head in the following order: blue, then red, then gold (this cycle repeats itself). When he uses the ability again, he picks the current card over his head; the card picked converts his next basic attack within 6 seconds to deal magic damage and add a special effect. Twisted Fate has 6 seconds to select a card." });
		twistedFateSpells[3] = new SpellInfo("Blue Card", "", "", "", new String[] {
				"MAGIC DAMAGE: 40 / 60 / 80 / 100 / 120 (+ 100% AD) (+ 50% AP)",
				"MANA RESTORED: 50 / 75 / 100 / 125 / 150",
				"MANA RESTORED TAKING MANA COST INTO ACOUNT: 10 / 20 / 30 / 40 / 50" },
				new String[] { "Twisted Fate's next basic attack will deal magic damage and restore mana." });
		twistedFateSpells[4] = new SpellInfo(
				"Red Card",
				"",
				"",
				"",
				new String[] { "MAGIC DAMAGE: 30 / 45 / 60 / 75 / 90 (+ 100% AD) (+ 50% AP)",
						"SLOW: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "Twisted Fate's next basic attack will deal magic damage to both the target and all enemies within 100 range of the target. All damaged enemies will also be slowed for 2.5 seconds." });
		twistedFateSpells[5] = new SpellInfo("Gold Card", "", "", "", new String[] {
				"MAGIC DAMAGE: 15 / 22.5 / 30 / 37.5 / 45 (+ 100% AD) (+ 50% AP)",
				"STUN DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] { "Twisted Fate's next basic attack will deal magic damage and stun the target." });
		twistedFateSpells[6] = new SpellInfo(
				"Stacked Deck",
				"",
				"",
				"",
				new String[] { "MAGIC DAMAGE: 55 / 80 / 105 / 130 / 155 (+ 50% AP)",
						"ATTACK SPEED BONUS: 10 / 15 / 20 / 25 / 30%" },
				new String[] { "PASSIVE: Every fourth basic attack will deal bonus magic damage. In addition, Twisted Fate gains bonus attack speed." });
		twistedFateSpells[7] = new SpellInfo(
				"Destiny",
				"Global",
				"180 / 150 / 120",
				"150 / 125 / 100 MANA",
				new String[] { "DURATION: 6 / 8 / 10" },
				new String[] { "ACTIVE: Twisted Fate reveals all enemy champions, including stealthed champions, for a few seconds. While Destiny is active, Twisted Fate can use Gate once." });
		twistedFateSpells[8] = new SpellInfo(
				"Gate",
				"5500",
				"",
				"",
				new String[] { "" },
				new String[] { "ACTIVE: After channeling for 1.5 seconds, Twisted Fate teleports to the target location within range." });
		champSpells[95] = twistedFateSpells;

		SpellInfo[] twitchSpells = new SpellInfo[5];
		twitchSpells[0] = new SpellInfo(
				"Deadly Venom",
				"",
				"",
				"",
				arrS,
				new String[] { "Twitch's basic attacks apply a stack of Deadly Venom, dealing 2 / 4 / 6 / 8 true damage per second for 6 seconds. This effect can stack up to 6 times for a minimum of 12 / 24 / 36 / 48 and maximum of 72 / 144 / 216 / 288 total true damage over the duration." });
		twitchSpells[1] = new SpellInfo(
				"Ambush",
				"",
				"16",
				"60 MANA",
				new String[] { "STEALTH DURATION: 4 / 5 / 6 / 7 / 8", "ATTACK SPEED: 30 / 40 / 50 / 60 / 70%" },
				new String[] {
						"ACTIVE: For 1.25 seconds, Twitch attempts to enter stealth, which may be delayed by up to 3 seconds if he takes damage before he goes invisible. While in stealth, Twitch gains 20% bonus movement speed.",
						"When Twitch unstealths, he gains bonus attack speed for 5 seconds. Casting spells or attacking will end his stealth prematurely." });
		twitchSpells[2] = new SpellInfo(
				"Venom Cask",
				"950",
				"13 / 12 / 11 / 10 / 9",
				"50 MANA",
				new String[] { "SLOW: 25 / 30 / 35 / 40 / 45%", "PROJECTILE SPEED: 1400" },
				new String[] { "ACTIVE: Twitch hurls a cask of venom at an area, infecting struck enemies with 2 stacks of Deadly Venom and slowing them for 3 seconds." });
		twitchSpells[3] = new SpellInfo(
				"Contaminate",
				"1200",
				"12 / 11 / 10 / 9 / 8",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "BASE PHYSICAL DAMAGE: 20 / 35 / 50 / 65 / 80",
						"BONUS DAMAGE PER STACK: 15 / 20 / 25 / 30 / 35 (+ 20% AP) (+ 25% bonus AD)",
						"MAX PHYSICAL DAMAGE: 110 / 155 / 200 / 245 / 290 (+ 120% AP) (+ 150% bonus AD)" },
				new String[] { "ACTIVE: Twitch expunges all nearby enemies afflicted by Deadly Venom, dealing physical damage equal to a base amount plus bonus damage for each stack of Deadly Venom on an enemy." });
		twitchSpells[4] = new SpellInfo(
				"Rat-Ta-Tat-Tat",
				"850",
				"120 / 110 / 100",
				"100 / 125 / 150 MANA",
				new String[] { "ATTACK DAMAGE: 20 / 28 / 36" },
				new String[] { "ACTIVE: For 7 seconds, Twitch gains bonus attack damage and 300 attack range. Additionally, each of his basic attacks will pierce enemies in an 850 length line, with each unit struck reducing the attack's damage by 20% down to a minimum of 40% damage." });
		champSpells[96] = twitchSpells;

		SpellInfo[] udyrSpells = new SpellInfo[5];
		udyrSpells[0] = new SpellInfo(
				"Monkey's Agility",
				"",
				"",
				"",
				arrS,
				new String[] { "Each time Udyr switches stances, he gains 5 flat movement speed and 10% attack speed for 5 seconds. This effect can stack up to 3 times." });
		udyrSpells[1] = new SpellInfo(
				"Tiger Stance",
				"",
				"6",
				"47 / 44 / 41 / 38 / 35 MANA",
				new String[] { "ATTACK SPEED BONUS: 30 / 40 / 50 / 60 / 70%",
						"TOTAL BONUS DAMAGE OVER TIME: 30 / 80 / 130 / 180 / 230 (+ 120 / 130 / 140 / 150 / 160% AD)" },
				new String[] {
						"STANCE ACTIVATION: Udyr gains attack speed for 5 seconds. Udyr's first attack after activation will deal bonus physical damage over 2 seconds to the target.",
						"PERSISTENT EFFECT: Udyr's basic attacks deal bonus physical damage equal to 15% of his attack damage." });
		udyrSpells[2] = new SpellInfo("Turtle Stance", "", "6", "47 / 44 / 41 / 38 / 35 MANA", new String[] {
				"SHIELD STRENGTH: 60 / 100 / 140 / 180 / 220 (+ 50% AP)", "LIFE STEAL: 10 / 12 / 14 / 16 / 18%" },
				new String[] { "STANCE ACTIVATION: Udyr gains a shield for 5 seconds.",
						"PERSISTENT EFFECT: Udyr gains life steal." });
		udyrSpells[3] = new SpellInfo(
				"Bear Stance",
				"",
				"6",
				"47 / 44 / 41 / 38 / 35 MANA",
				new String[] { "MOVEMENT SPEED BONUS: 15 / 20 / 25 / 30 / 35%",
						"MOVEMENT SPEED DURATION: 2 / 2.25 / 2.5 / 2.75 / 3" },
				new String[] {
						"STANCE ACTIVATION: Udyr gains increased movement speed and ignores unit collision for a few seconds.",
						"PERSISTENT EFFECT: Udyr's basic attacks cause him to dash a short distance closer to his target and stun it for 1 second. The dash and stun cannot reoccur on the same target within 5 seconds." });
		udyrSpells[4] = new SpellInfo(
				"Phoenix Stance",
				"",
				"6",
				"47 / 44 / 41 / 38 / 35 MANA",
				new String[] { "MAGIC DAMAGE PER WAVE: 15 / 25 / 35 / 45 / 55 (+ 25% AP)",
						"TOTAL MAGIC DAMAGE: 75 / 125 / 175 / 225 / 275 (+ 125% AP)",
						"MAGIC DAMAGE PER THIRD ATTACK: 40 / 80 / 120 / 160 / 200 (+ 45% AP)", "FLAME RANGE: 625" },
				new String[] {
						"STANCE ACTIVATION: Udyr unleashes pulsing waves of fire around himself for 5 seconds, dealing magic damage each second to enemies within 250 range.",
						"PERSISTENT EFFECT: On the first attack after activation and on every third subsequent attack, Udyr engulfs enemies in flames, dealing magic damage in a cone in front of him." });
		champSpells[97] = udyrSpells;

		SpellInfo[] urgotSpells = new SpellInfo[5];
		urgotSpells[0] = new SpellInfo(
				"Zaun-Touched Bolt Augmenter",
				"",
				"",
				"",
				arrS,
				new String[] { "Urgot's autoattacks and Acid Hunter reduce all damage that his target deals by 15% for 2.5 seconds." });
		urgotSpells[1] = new SpellInfo(
				"Acid Hunter",
				"1000 (1200 with Lock-on)",
				"2",
				"40 MANA",
				new String[] { "PHYSICAL DAMAGE: 10 / 40 / 70 / 100 / 130 (+ 85% AD)" },
				new String[] {
						"ACTIVE: Urgot fires a missile in a line towards the cursor, dealing physical damage to the first enemy it hits. His passive is also applied to the target.",
						"Missile-lock can be achieved by holding the cursor over a unit afflicted by Noxian Corrosive Charge when casting, causing Acid Hunter to fly directly to the target ignoring all other units. Acid Hunter can lock onto units hidden in Fog of War, brush, and in stealth, but it will not reveal targets hit." });
		urgotSpells[2] = new SpellInfo(
				"Terror Capacitor",
				"",
				"16 / 15 / 14 / 13 / 12",
				"55 / 60 / 65 / 70 / 75 MANA",
				new String[] { "SHIELD STRENGTH: 80 / 130 / 180 / 230 / 280 (+ 80% AP)",
						"SLOW: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Urgot charges up his capacitor to gain a shield that absorbs damage for up to 7 seconds. While the shield is active, Urgot's autoattacks and Acid Hunter missiles will slow targets for 1.5 seconds." });
		urgotSpells[3] = new SpellInfo(
				"Noxian Corrosive Charge",
				"900",
				"15 / 14 / 13 / 12 / 11",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "TOTAL PHYSICAL DAMAGE: 75 / 130 / 185 / 240 / 295 (+ 60% Bonus AD)",
						"ARMOR REDUCTION: 12 / 14 / 16 / 18 / 20%" },
				new String[] { "ACTIVE: Urgot launches a corrosive charge at target 150-radius area, afflicting all targets hit for 5 seconds. Enemies afflicted by the charge have their armor reduced by a percentage and take physical damage over the duration." });
		urgotSpells[4] = new SpellInfo(
				"Hyper-Kinetic Position Reverser",
				"550 / 700 / 850",
				"120",
				"120 MANA",
				new String[] { "ARMOR & MAGIC RESIST: 60 / 90 / 120" },
				new String[] { "ACTIVE: Urgot targets an enemy champion and channels for 1 second, suppressing the target for the duration. If the channel completes, Urgot and the target will swap positions and the target will be slowed by 40% for 3 seconds. Urgot also gains bonus armor and magic resistance for 5 seconds, starting from the beginning of the channel time." });
		champSpells[98] = urgotSpells;

		SpellInfo[] varusSpells = new SpellInfo[5];
		varusSpells[0] = new SpellInfo(
				"Living Vengeance",
				"",
				"",
				"",
				new String[] { "" },
				new String[] { "On a champion kill or assist, Varus gains 40% attack speed for 6 seconds. On a minion or monster kill, Varus gains 20% attack speed for 3 seconds." });
		varusSpells[1] = new SpellInfo(
				"Piercing Arrow",
				"850 - 1475",
				"16 / 14 / 12 / 10 / 8",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MINIMUM PHYSICAL DAMAGE: 10 / 47 / 83 / 120 / 157 (+ 100% AD)",
						"MAXIMUM PHYSICAL DAMAGE: 15 / 70 / 125 / 180 / 235 (+ 160% AD)",
						"MINIMUM REDUCED DAMAGE: 3.3 / 15.7 / 27.7 / 40 / 52.3 (+ 33% AD)",
						"MAXIMUM REDUCED DAMAGE: 5 / 23.3 / 41.7 / 60 / 78.3 (+ 53% AD)" },
				new String[] {
						"FIRST CAST: Varus begins channeling his next shot, gradually increasing the range and damage of Piercing Arrow over the next 2 seconds.",
						"Varus can still move while channeling, but can't autoattack or use his other abilities, and his movement speed is slowed by 20%. After 4 seconds, Piercing Arrow is automatically cancelled, going on full cooldown and refunding half of its mana cost.",
						"SECOND CAST: Varus fires, dealing physical damage to all enemies in the arrow's path, reduced by 15% per enemy hit (down to a minimum of 33%)." });
		varusSpells[2] = new SpellInfo(
				"Blighted Quiver",
				"",
				"",
				"",
				new String[] {
						"ON-HIT MAGIC DAMAGE: 10 / 14 / 18 / 22 / 26 (+ 25% AP)",
						"MAGIC DAMAGE PER BLIGHT STACK: 2 / 2.75 / 3.5 / 4.25 / 5% (+ 2% per 100 AP) of target's max health",
						"MAXIMUM MAGIC DAMAGE: 6 / 8.25 / 10.5 / 12.75 / 15% (+ 6% per 100 AP) of target's max health" },
				new String[] {
						"PASSIVE: Varus' basic attacks deal bonus magic damage. They also apply Blight for 6 seconds, stacking up to 3 times.",
						"Varus' other abilities detonate Blight, dealing magic damage equal to a percentage of the target's maximum health per stack. This damage is capped at 360 against monsters." });
		varusSpells[3] = new SpellInfo(
				"Hail of Arrows",
				"925",
				"18 / 16 / 14 / 12 / 10",
				"80 MANA",
				new String[] { "PHYSICAL DAMAGE: 65 / 100 / 135 / 170 / 205 (+ 60% bonus AD)",
						"SLOW: 25 / 30 / 35 / 40 / 45%" },
				new String[] { "ACTIVE: Varus fires a hail of arrows that deals physical damage and desecrates the ground for 4 seconds. Desecrated Ground inflicts Grievous Wounds and slows enemy movement speed." });
		varusSpells[4] = new SpellInfo(
				"Chain of Corruption",
				"1075",
				"120 / 105 / 90",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Varus flings out a tendril of corruption that infects the first enemy champion hit, dealing magic damage and rooting them for 2 seconds.",
						"The corruption then attempts to spread towards enemy champions within 550 range, applying the same damage and root if they stay within 600 range of the infected champion for 2 seconds. The corruption will continue to spread until there are no further targets in range, but each champion may only be infected once per cast." });
		champSpells[99] = varusSpells;

		SpellInfo[] vayneSpells = new SpellInfo[5];
		vayneSpells[0] = new SpellInfo("Night Hunter", "2000", "", "", arrS,
				new String[] { "Vayne gains 30 movement speed when moving towards a visible enemy champion." });
		vayneSpells[1] = new SpellInfo(
				"Tumble",
				"300",
				"6 / 5 / 4 / 3 / 2",
				"30 MANA",
				new String[] { "BONUS PHYSICAL DAMAGE: 30 / 35 / 40 / 45 / 50% AD" },
				new String[] { "ACTIVE: Vayne quickly rolls toward the cursor's location, causing her next basic attack within 6 seconds to deal bonus damage. This ability resets the autoattack timer on cast." });
		vayneSpells[2] = new SpellInfo(
				"Silver Bolts",
				"",
				"",
				"",
				new String[] { "TRUE DAMAGE: 20 / 30 / 40 / 50 / 60 (+ 4 / 5 / 6 / 7 / 8% target's maximum health)" },
				new String[] {
						"PASSIVE: Consecutive attacks and abilities mark Vayne's target with silver rings. The third consecutive attack or spell against the same target will consume the rings, dealing true damage equal to a flat amount plus a percentage of the target's maximum health (capped at 200 against monsters).",
						"The rings are removed if Vayne attacks a different target or doesn't attack for 3 seconds." });
		vayneSpells[3] = new SpellInfo(
				"Condemn",
				"550",
				"20 / 18 / 16 / 14 / 12",
				"90 MANA",
				new String[] { "PHYSICAL DAMAGE: 45 / 80 / 115 / 150 / 185 (+ 50% bonus AD)",
						"MAXIMUM PHYSICAL DAMAGE: 90 / 160 / 230 / 300 / 370 (+ 100% bonus AD)" },
				new String[] { "ACTIVE: Vayne fires a projectile at target unit, dealing physical damage and knocking the target back 470 units. If the target is knocked into a wall, the target takes the same damage again and is stunned for 1.5 seconds. Condemn also applies Silver Bolts once." });
		vayneSpells[4] = new SpellInfo(
				"Final Hour",
				"",
				"100 / 85 / 70",
				"80 MANA",
				new String[] { "DURATION: 8 / 10 / 12", "BONUS ATTACK DAMAGE: 25 / 40 / 55" },
				new String[] { "ACTIVE: Vayne temporarily gains attack damage and enhances her other abilities. While Final Hour is active, Night Hunter's movement speed increase is tripled, and using Tumble stealths Vayne for 1 second." });
		champSpells[100] = vayneSpells;

		SpellInfo[] veigarSpells = new SpellInfo[5];
		veigarSpells[0] = new SpellInfo("Equilibrium", "", "", "", arrS,
				new String[] { "Veigar's mana regeneration is increased by 1% for each 1% of his missing mana." });
		veigarSpells[1] = new SpellInfo(
				"Beautiful Strike",
				"650",
				"8 / 7 / 6 / 5 / 4",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "ABILITY POWER PER CHAMPION KILL: 1 / 2 / 3 / 4 / 5",
						"MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 60% AP)" },
				new String[] {
						"PASSIVE: Veigar gains permanent bonus ability power when he kills a champion from any source of damage. This stacks with the active ability's AP gain.",
						"ACTIVE: Unleashes dark energy at target enemy, dealing magic damage. If this ability deals a killing blow, Veigar gains 1 ability power permanently. This bonus is doubled for large minions, large monsters, and champions." });
		veigarSpells[2] = new SpellInfo(
				"Dark Matter",
				"900",
				"10",
				"0 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 120 / 170 / 220 / 270 / 320 (+ 100% AP)" },
				new String[] { "ACTIVE: Veigar calls a great mass of dark matter to fall from the sky to the target location, which lands after a 1.25 second delay, dealing magic damage in a 112.5-radius area. This ability also provides sight of the target area through fog of war or brushes before it lands." });
		veigarSpells[3] = new SpellInfo(
				"Event Horizon",
				"650",
				"20 / 19 / 18 / 17 / 16",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "STUN DURATION: 1.5 / 1.75 / 2 / 2.25 / 2.5" },
				new String[] { "ACTIVE: Veigar twists the edges of space around the 375-radius target area for 3 seconds, stunning enemies who pass through the perimeter for a short duration." });
		veigarSpells[4] = new SpellInfo(
				"Primordial Burst",
				"650",
				"130 / 110 / 90",
				"125 / 175 / 225 MANA",
				new String[] { "MAGIC DAMAGE: 250 / 375 / 500 (+ 120% AP)" },
				new String[] { "ACTIVE: Blasts an enemy champion, dealing magic damage equal to a base amount plus 80% of the target's ability power." });
		champSpells[101] = veigarSpells;

		SpellInfo[] velkozSpells = new SpellInfo[5];
		velkozSpells[0] = new SpellInfo(
				"Organic Deconstruction",
				"",
				"",
				"",
				arrS,
				new String[] { "Vel'Koz's damaging abilities apply stacks of Deconstruction for 7 seconds, stacking up to 3 times. Upon reaching 3 stacks, the stacks detonate and the target suffers 25 + (10 × level) true damage. Basic attacks will refresh the duration, but will not add additional stacks." });
		velkozSpells[1] = new SpellInfo(
				"Plasma Fission",
				"1050",
				"7",
				"40 / 45 / 50 / 55 / 60 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 60% AP)",
						"SLOW DURATION: 1 / 1.25 / 1.5 / 1.75 / 2" },
				new String[] {
						"ACTIVE: Vel'Koz fires a bolt of energy that deals magic damage and slows the first enemy hit by 70% for a few seconds. The slow decays over the duration.",
						"Upon hitting an enemy, reaching maximum range or being reactivated, the bolt splits in two: each traveling in opposite directions perpendicular to the direction of cast. Each of the secondary bolts deal magic damage and slow the first enemies they hit, respectively." });
		velkozSpells[2] = new SpellInfo(
				"Void Rift",
				"1050",
				"(STATIC) 1.5",
				"50 / 55 / 60 / 65 / 70 MANA + 1 CHARGE",
				new String[] { "INITIAL MAGIC DAMAGE: 30 / 50 / 70 / 90 / 110 (+ 25% AP)",
						"DETONATION MAGIC DAMAGE: 45 / 75 / 105 / 135 / 165 (+ 37.5% AP)",
						"MAXIMUM DAMAGE: 75 / 125 / 175 / 225 / 275 (+ 62.5% AP)",
						"RECHARGE TIME: 19 / 18 / 17 / 16 / 15" },
				new String[] {
						"Vel'Koz stores a charge of Void Rift every few seconds and can store up to 2 charges. The recharge time is affected by cooldown reduction.",
						"ACTIVE: Vel'Koz opens a rift to the void that cuts through the ground in a line, dealing magic damage and leaving behind a trail. After a 0.25 second delay, the entire trail detonates, dealing magic damage to enemies standing upon it." });
		velkozSpells[3] = new SpellInfo(
				"Tectonic Disruption",
				"850",
				"16 / 15 / 14 / 13 / 12",
				"COST: 50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 100 / 130 / 160 / 190 (+ 50% AP)" },
				new String[] { "ACTIVE: Vel'Koz hurls an anomaly at the target location. When it lands, it collapses, dealing magic damage and suspending enemies hit for 0.75 seconds. Enemies close to Vel'Koz at the time of impact are also slightly knocked back." });
		velkozSpells[4] = new SpellInfo(
				"Lifeform Disintegration Ray",
				"1575",
				"130 / 110 / 90",
				"100 MANA",
				new String[] { "MAGIC DAMAGE PER INTERVAL: 50 / 70 / 90 (+ 6% AP)",
						"MAXIMUM DAMAGE: 500 / 700 / 900 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Vel'Koz roots himself in place and unleashes a laser forward in a line, damaging all enemies caught in its wake at 0.25 second intervals and slowing them by 20% for 1 second. The ray's trajectory will update over the duration to face the cursor and will end after either 2.5 seconds have elapsed or Vel'Koz recasts the ability.",
						"Organic Deconstruction can not be applied more frequently than once every 0.5 seconds." });
		champSpells[102] = velkozSpells;

		SpellInfo[] viSpells = new SpellInfo[5];
		viSpells[0] = new SpellInfo(
				"Blast Shield",
				"",
				"(STATIC) 18 / 13 / 8",
				"",
				arrS,
				new String[] { "When Vi's activated abilities damage an enemy, she gains a shield which absorbs damage equal to 10% of her maximum health for 3 seconds." });
		viSpells[1] = new SpellInfo(
				"Vault Breaker",
				"",
				"18 / 15.5 / 13 / 10.5 / 8",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MINIMUM PHYSICAL DAMAGE: 50 / 75 / 100 / 125 / 150 (+ 80% bonus AD)",
						"MAXIMUM PHYSICAL DAMAGE: 100 / 150 / 200 / 250 / 300 (+ 160% bonus AD)",
						"DASH RANGE: 250 - 725", "MAXIMUM AOE RANGE: 900" },
				new String[] {
						"FIRST CAST: Vi begins channeling, increasing the damage and range of Vault Breaker over 1.25 seconds. Vi can still move while channeling, but she cannot attack or use her other abilities, and her movement speed is slowed by 15%.",
						"SECOND CAST: Vi dashes towards the cursor's location, dealing physical damage and applying  Denting Blows to all enemies hit. Vi stops upon colliding with an enemy champion, knocking it back. Vault Breaker deals 75% damage to minions and monsters." });
		viSpells[2] = new SpellInfo(
				"Denting Blows",
				"",
				"",
				"",
				new String[] {
						"BONUS PHYSICAL DAMAGE: 4 / 5.5 / 7 / 8.5 / 10% (+ 1% per 35 bonus AD) of target's max health",
						"ATTACK SPEED BONUS: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "PASSIVE: Every third attack on the same target deals additional physical damage equal to a percentage of the target's maximum health, reduces the target's armor by 20%, and grants Vi bonus attack speed for 4 seconds. Denting Blows deals a maximum of 300 damage against minions and monsters." });
		viSpells[3] = new SpellInfo(
				"Excessive Force",
				"600",
				"1",
				"60 MANA + 1 CHARGE",
				new String[] { "TOTAL PHYSICAL DAMAGE: 5 / 20 / 35 / 50 / 65 (+115% AD) (+ 70% AP)",
						"CHARGE RELOAD TIME: 14 / 12.5 / 11 / 9.5 / 8 seconds" },
				new String[] { "ACTIVE: Causes Vi's next basic attack to deal increased physical damage, hitting all enemies in a cone behind the target. Vi gains a new charge of Excessive Force periodically (this reload time is reduced by cooldown reduction) and can hold up to 2 charges at once." });
		viSpells[4] = new SpellInfo(
				"Assault and Battery",
				"800",
				"150 / 115 / 80",
				"100 / 125 / 150 MANA",
				new String[] { "PHYSICAL DAMAGE: 200 / 325 / 450 (+ 140% bonus AD)",
						"PHYSICAL DAMAGE TO SECONDARY TARGETS: 150 / 243.75 / 337.5 (+105% bonus AD)" },
				new String[] {
						"ACTIVE: Vi targets an enemy champion and chases it down. She performs an uppercut upon reaching it, dealing physical damage and knocking it up for 1.25 seconds.",
						"While charging, Vi is immune to crowd control and will knock aside enemies in her way, dealing 75% damage to them." });
		champSpells[103] = viSpells;

		SpellInfo[] viktorSpells = new SpellInfo[8];
		viktorSpells[0] = new SpellInfo(
				"Evolving Technology",
				"",
				"",
				"",
				new String[] { "The Hex Core: Grants Viktor +3 ability power per level." },
				new String[] { "Viktor starts each game with  The Hex Core, an item that takes up one of his item slots, but provides him with stats and can be upgraded in the store to augment one of his abilities and improve its stats.  The Hex Core can only be upgraded once, for 1000 gold, and cannot be sold back to the store." });
		viktorSpells[1] = new SpellInfo(
				"Power Transfer",
				"600",
				"9 / 8 / 7 / 6 / 5",
				"45 / 50 / 55 / 60 / 65 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 65% AP)",
						"SHIELD: 32 / 50 / 68 / 86 / 104 (+ 26% AP)" },
				new String[] { "ACTIVE: Viktor sends a device at an enemy unit to blast them for magic damage. The device then returns to him granting a shield for up to 3 seconds." });
		viktorSpells[2] = new SpellInfo(
				"Augment: Power",
				"",
				"",
				"",
				arrS,
				new String[] { "The item now grants him +3 ability power per level, +220 health and +6 health regeneration per 5 seconds. Also,  Power Transfer increases Viktor's movement speed by 30% for 3 seconds." });
		viktorSpells[3] = new SpellInfo(
				"Gravity Field",
				"625 (812.5 if upgraded)",
				"17 / 16 / 15 / 14 / 13",
				"65 MANA",
				new String[] { "SLOW: 28 / 32 / 36 / 40 / 44%" },
				new String[] { "ACTIVE: Viktor conjures a gravitational imprisonment device at a target location for 4 seconds, slowing all enemies that pass above it. Whilst under its effect, enemies generate stacks every 0.5 seconds; at 3 stacks the target will be stunned for 1.5 seconds." });
		viktorSpells[4] = new SpellInfo(
				"Augment: Gravity",
				"",
				"",
				"",
				arrS,
				new String[] { "The item now grants him +3 ability power per level, +200 mana, +10% cooldown reduction and +5 mana regeneration per 5 seconds. Also, Gravity Field's cast range is increased by 30%." });
		viktorSpells[5] = new SpellInfo(
				"Death Ray",
				"540",
				"13 / 12 / 11 / 10 / 9",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 70% AP)" },
				new String[] { "ACTIVE: Viktor uses his robotic arm to fire a 500-unit length laser beam across the field in a chosen path, dealing magic damage to every enemy it hits." });
		viktorSpells[6] = new SpellInfo(
				"Augment: Death",
				"",
				"",
				"",
				new String[] { "ADDITIONAL BURN DAMAGE: 21 / 34.5 / 48 / 61.5 / 75 (+ 21% AP)",
						"TOTAL MAGIC DAMAGE: 91 / 149.5 / 208 / 266.5 / 325 (+ 91% AP)" },
				new String[] { "The item now grants him +3 ability power per level and +45 ability power. Also, Death Ray sets fire to enemies, dealing 30% additional magic damage over 4 seconds." });
		viktorSpells[7] = new SpellInfo(
				"Chaos Storm",
				"700",
				"120",
				"100 MANA",
				new String[] { "INITIAL MAGIC DAMAGE: 150 / 250 / 350 (+ 55% AP)",
						"MAGIC DAMAGE PER BOLT: 40 / 60 / 80 (+ 24% AP)",
						"TOTAL INITIAL MAGIC DAMAGE: 190 / 310 / 430 (+ 79% AP)",
						"TOTAL MAGIC DAMAGE: 470 / 730 / 990 (+ 247% AP)" },
				new String[] {
						"ACTIVE: Viktor conjures a chaos storm at the target location, dealing magic damage and silencing enemies in the area for 0.5 seconds. The storm cloud remains for 7 seconds afterwards, firing lightning bolts at every nearby enemy every second.",
						"While the storm is active Viktor can re-activate Chaos Storm to move it to the cursor's location, with the storm moving faster the closer it is to Viktor." });
		champSpells[104] = viktorSpells;

		SpellInfo[] vladimirSpells = new SpellInfo[5];
		vladimirSpells[0] = new SpellInfo(
				"Crimson Pact",
				"",
				"",
				"",
				arrS,
				new String[] { "Vladimir gains ability power equal to 2.5% of his bonus health and bonus health equal to 140% of his ability power. These bonuses do not stack with themselves." });
		vladimirSpells[1] = new SpellInfo(
				"Transfusion",
				"600",
				"10 / 8.5 / 7 / 5.5 / 4",
				"NO COST",
				new String[] { "MAGIC DAMAGE: 90 / 125 / 160 / 195 / 230 (+ 60% AP)",
						"HEALTH REGAINED: 15 / 25 / 35 / 45 / 55 (+ 25% AP)" },
				new String[] { "ACTIVE: Vladimir drains the lifeforce of his target, dealing magic damage and healing himself." });
		vladimirSpells[2] = new SpellInfo(
				"Sanguine Pool",
				"",
				"26 / 23 / 20 / 17 / 14",
				"20% CURRENT HEALTH",
				new String[] { "MAGIC DAMAGE PER HALF-SECOND: 20 / 33.75 / 47.5 / 61.25 / 75 (+3.75% of bonus health)",
						"MAXIMUM MAGIC DAMAGE: 80 / 135 / 190 / 245 / 300 (+15% of bonus health)", "POOL RADIUS: 150" },
				new String[] { "ACTIVE: Vladimir sinks into a pool of blood, gaining 37.5% bonus movement speed that decays exponentially for 1 second and becoming untargetable for 2 seconds. Enemies who stand upon the pool are slowed by 40%, and are dealt magic damage every half second while Vladimir heals himself for 12.5% of the damage done." });
		vladimirSpells[3] = new SpellInfo(
				"Tides of Blood",
				"610",
				"4.5",
				"30 / 40 / 50 / 60 / 70 HEALTH",
				new String[] { "MAXIMUM COST: 60 / 80 / 100 / 120 / 140 health",
						"MAGIC DAMAGE: 60 / 85 / 110 / 135 / 160 (+ 45% AP)",
						"MAXIMUM MAGIC DAMAGE: 120 / 170 / 220 / 270 / 320 (+ 45% AP)",
						"HEALING AND REGENERATION INCREASE PER STACK: 4 / 5 / 6 / 7 / 8%" },
				new String[] {
						"ACTIVE: Vladimir unleashes a torrent of blood, damaging all enemies within range.",
						"Each cast of Tides of Blood gives him an Empowered stack that lasts 10 seconds and stacks up to 4 times. Each Empowered stack increases Vladimir's healing and regeneration by a percentage, and also increases both the base damage and cost of his next Tides of Blood by 25% per stack." });
		vladimirSpells[4] = new SpellInfo(
				"Hemoplague",
				"700",
				"150 / 135 / 120",
				"NO COST",
				new String[] { "MAGIC DAMAGE: 150 / 250 / 350 (+ 70% AP)" },
				new String[] { "ACTIVE: Vladimir infects all enemies in the target 175-radius area with a virulent plague which increases the damage they take from all sources by 12% for 5 seconds. After these 5 seconds, infected enemies take magic damage." });
		champSpells[105] = vladimirSpells;

		SpellInfo[] volibearSpells = new SpellInfo[5];
		volibearSpells[0] = new SpellInfo(
				"Chosen of the Storm",
				"",
				"(STATIC) 120",
				"",
				arrS,
				new String[] { "When Volibear's health drops below 30% of his maximum health, he will heal for 30% of his maximum health over the next 6 seconds." });
		volibearSpells[1] = new SpellInfo(
				"Rolling Thunder",
				"",
				"12 / 11 / 10 / 9 / 8",
				"40 MANA",
				new String[] { "BONUS PHYSICAL DAMAGE: 30 / 60 / 90 / 120 / 150",
						"BONUS MOVEMENT SPEED TOWARD CHAMPIONS: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "ACTIVE: Volibear gains 15% movement speed for the next 4 seconds. This bonus increases when headed toward a nearby visible enemy champion. Additionally, Volibear's next autoattack during this time will deal bonus physical damage and will toss the target behind himself." });
		volibearSpells[2] = new SpellInfo(
				"Frenzy",
				"400",
				"18",
				"35 MANA",
				new String[] { "ATTACK SPEED PER STACK: 8 / 11 / 14 / 17 / 20%",
						"MAX ATTACK SPEED: 24 / 33 / 42 / 51 / 60%",
						"BASE PHYSICAL DAMAGE: 80 / 125 / 170 / 215 / 260 (+ 15% of bonus health)",
						"MAX PHYSICAL DAMAGE: 160 / 250 / 340 / 430 / 520 (+ 30% of bonus health)" },
				new String[] {
						"PASSIVE: Volibear temporarily gains bonus attack speed after an autoattack. This bonus stacks up to 3 times and lasts for 4 seconds.",
						"ACTIVE: While Volibear has 3 stacks of Frenzy, he can activate this ability to bite a target enemy. The stacks are not consumed. The bite will deal physical damage that scales with his own bonus health. This damage is further increased by 1% for every 1% of the target's missing health." });
		volibearSpells[3] = new SpellInfo(
				"Majestic Roar",
				"425",
				"11",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 60% AP)", "SLOW: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "ACTIVE: Volibear lets out a powerful roar that deals magic damage and slows nearby enemies for 3 seconds. Minions, monsters and pets are also feared for the duration." });
		volibearSpells[4] = new SpellInfo(
				"Thunder Claws",
				"",
				"100 / 90 / 80",
				"100 MANA",
				new String[] { "MAGIC DAMAGE PER BOLT: 75 / 115 / 155 (+ 30% AP)",
						"MAX TOTAL DAMAGE PER BOLT: 300 / 460 / 620 (+ 120% AP)" },
				new String[] { "ACTIVE: For the next 12 seconds, Volibear's autoattacks will blast his target with lightning that will also bounce to up to 3 nearby enemies within 300 range. Each bolt of lightning will deal magic damage and will only hit each target once per autoattack." });
		champSpells[106] = volibearSpells;

		SpellInfo[] warwickSpells = new SpellInfo[5];
		warwickSpells[0] = new SpellInfo(
				"Eternal Thirst",
				"",
				"",
				"",
				arrS,
				new String[] { "Each of Warwick's autoattacks deal 3 / 3.5 / 4 / 4.5 / 5 / 5.5 / 6 / 6.5 / 7 / 8 / 9 / 10 / 11 / 12 / 13 / 14 / 15 / 16 (2.5 + 0.5 / 1 at each level) additional magic damage and heal him for the same amount. Each successive attack against the same target will stack this amount of healing and damage up to a maximum of 3 stacks. The stacks remain for 4 seconds." });
		warwickSpells[1] = new SpellInfo(
				"Hungering Strike",
				"400",
				"10 / 9 / 8 / 7 / 6",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] {
						"MAX MAGIC DAMAGE TO CHAMPIONS: 8 / 10 / 12 / 14 / 16% of target's maximum health (+ 100% AP)",
						"FLAT MINIMUM DAMAGE: 75 / 125 / 175 / 225 / 275 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Warwick swipes at a target enemy, dealing magic damage for the greater value between a flat minimum amount or a percentage of the target's maximum health, plus additional bonus damage based on his ability power. Hungering Strike can only deal the flat damage to minions and monsters.",
						"Warwick heals himself for 80% of the damage dealt (after reductions)." });
		warwickSpells[2] = new SpellInfo(
				"Hunter's Call",
				"1250",
				"24 / 22 / 20 / 18 / 16",
				"35 MANA",
				new String[] { "ATTACK SPEED: 40 / 50 / 60 / 70 / 80%", "ALLY ATTACK SPEED: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: For 10 seconds, Warwick increases his attack speed and increases the attack speeds of all allies within range by half as much." });
		warwickSpells[3] = new SpellInfo(
				"Blood Scent",
				"1500 / 2300 / 3100 / 3900 / 4700",
				"4",
				"",
				new String[] { "MOVEMENT SPEED: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "TOGGLE: Warwick reveals enemy champions within range with less than 50% health. While any enemies are revealed this way, Warwick has increased movement speed." });
		warwickSpells[4] = new SpellInfo(
				"Infinite Duress",
				"700",
				"90 / 80 / 70",
				"100 / 125 / 150 MANA",
				new String[] { "MAGIC DAMAGE PER HIT: 50 / 67 / 84 (+ 40% bonus AD)",
						"TOTAL DAMAGE: 250 / 335 / 420 (+ 200% bonus AD)" },
				new String[] { "ACTIVE: Warwick blinks to the front of an enemy champion and channels for 1.5 seconds, suppressing the target for 1.8 seconds and dealing magic damage 5 times in 1/3-second intervals. Warwick gains 30% life steal for the duration. Each damaging strike applies on-hit effects, life steal, and maximum stacks of Eternal Thirst." });
		champSpells[107] = warwickSpells;

		SpellInfo[] wukongSpells = new SpellInfo[5];
		wukongSpells[0] = new SpellInfo(
				"Stone Skin",
				"1400",
				"",
				"",
				arrS,
				new String[] { "Wukong's armor and magic resistance are increased by 4 / 6 / 8 for each visible nearby enemy champion." });
		wukongSpells[1] = new SpellInfo(
				"Crushing Blow",
				"",
				"9 / 8 / 7 / 6 / 5",
				"40 MANA",
				new String[] { "TOTAL PHYSICAL DAMAGE: 30 / 60 / 90 / 120 / 150 (+ 110% AD)",
						"ARMOR REDUCTION: 10 / 15 / 20 / 25 / 30%" },
				new String[] { "ACTIVE: Wukong's next attack within the next 5 seconds deals bonus physical damage, gains 125 range (300 total range) and reduces the enemy's armor by a percentage for 3 seconds." });
		wukongSpells[2] = new SpellInfo(
				"Decoy",
				"",
				"18 / 16 / 14 / 12 / 10",
				"50 / 55 / 60 / 65 / 70 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 115 / 160 / 205 / 250 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Wukong becomes stealthed for 1.5 seconds and leaves behind a decoy of himself.",
						"DECOY: The decoy is uncontrollable and cannot move or attack. After 1.5 seconds, it will vanish, dealing magic damage in a radius of 175." });
		wukongSpells[3] = new SpellInfo(
				"Nimbus Strike",
				"625",
				"8",
				"45 / 50 / 55 / 60 / 65 MANA",
				new String[] { "PHYSICAL DAMAGE: 60 / 105 / 150 / 195 / 240 (+ 80% Bonus AD)",
						"ATTACK SPEED BONUS: 30 / 35 / 40 / 45 / 50%" },
				new String[] { "ACTIVE: Wukong dashes on a cloud toward a target enemy and sends out images to hit up to two more within 187.5 range of the target. Each enemy struck is dealt physical damage. Upon hitting his target, he gains an attack speed bonus for 4 seconds." });
		wukongSpells[4] = new SpellInfo(
				"Cyclone",
				"162.5",
				"120 / 105 / 90",
				"100 MANA",
				new String[] { "PHYSICAL DAMAGE PER SECOND: 20 / 110 / 200 (+ 110% AD)",
						"MAXIMUM PHYSICAL DAMAGE: 80 / 440 / 800 (+ 440% AD)" },
				new String[] { "ACTIVE: Wukong's staff grows outward as he spins around for up to 4 seconds, dealing physical damage per second to enemies around him and gaining a 5% move speed bonus per half second. Enemies are knocked up into the air the first time they are hit by the spin. Wukong cannot attack or use other basic abilities while spinning, but can deactivate it early." });
		champSpells[108] = wukongSpells;

		SpellInfo[] xerathSpells = new SpellInfo[5];
		xerathSpells[0] = new SpellInfo(
				"Mana Surge",
				"",
				"",
				"",
				arrS,
				new String[] { "Every 12 seconds, Xerath's next basic attack will restore 30 / 33 / 36 / 42 / 48 / 54 / 63 / 72 / 81 / 90 / 102 / 114 / 126 / 138 / 150 / 165 / 180 / 195 (27 + 3 / 6 / 9 / 12 / 15 at each level) mana. The amount of mana restored is doubled if the attack target is a champion. This does not apply to structures." });
		xerathSpells[1] = new SpellInfo(
				"Arcanopulse",
				"750 to 1400",
				"9 / 8 / 7 / 6 / 5",
				"80 / 90 / 100 / 110 / 120 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 75% AP)" },
				new String[] {
						"FIRST CAST: Xerath starts channeling for 3 seconds. Xerath can move while channeling, but cannot attack or cast his other abilities. Over the first 1.5 seconds of the channel, Arcanopulse's range will gradually increases while his movement speed is slowed by up to 50%.",
						"After the 3 seconds, Arcanopulse will cancel and half the mana cost is refunded.",
						"SECOND CAST: After a brief cast time, Xerath fires a beam of energy in a line that deals magic damage to all enemies hit." });
		xerathSpells[2] = new SpellInfo(
				"Eye of Destruction",
				"1100",
				"14 / 13 / 12 / 11 / 10",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 60% AP)",
						"EMPOWERED DAMAGE: 90 / 135 / 180 / 225 / 270 (+ 90% AP)",
						"EMPOWERED SLOW: 60 / 65 / 70 / 75 / 80%" },
				new String[] { "ACTIVE: Xerath calls down a blast of arcane energy which strikes after a 0.5 second delay, dealing magic damage and slowing enemies in a target 200-radius area by 10% for 2.5 seconds. Enemies hit directly take an empowered amount of damage and are slowed by a greater amount instead. The empowered slow decays down to 10% over the duration." });
		xerathSpells[3] = new SpellInfo(
				"Shocking Orb",
				"1050",
				"13 / 12.5 / 12 / 11.5 / 11",
				"60 / 65 / 70 / 75 / 80 MANA",
				new String[] { "MAGIC DAMAGE: 80 / 110 / 140 / 170 / 200 (+ 45% AP)" },
				new String[] { "ACTIVE: Xerath fires a orb of energy forward in a line that detonates on striking an enemy, dealing magic damage and stunning them for between 0.75 and 2 seconds. The stun duration increases as the orb travels." });
		xerathSpells[4] = new SpellInfo(
				"Rite of the Arcane",
				"3200 / 4400 / 5600",
				"130 / 115 / 100",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 190 / 245 / 300 (+ 43% AP)",
						"MAXIMUM SINGLE TARGET DAMAGE: 570 / 735 / 900 (+ 130% AP)" },
				new String[] {
						"ACTIVE: Xerath anchors himself to his current location for up to 10 seconds. While anchored, Xerath is immune to displacement effects and gains the ability to cast Arcane Barrage up to three times, but cannot cast his other abilities.",
						"Rite of the Arcane can be cancelled early by moving or attacking and will automatically end once Arcane Barrage has been cast 3 times. If Rite of the Arcane ends without using a single cast of Arcane Barrage, the cooldown is reduced by 50%. Interrupting crowd control effects, with the exception of displacement effects, will interrupt Rite of the Arcane and put if on full cooldown.",
						"ARCANE BARRAGE - ACTIVE: Xerath calls down a blast of arcane energy which strikes after a 0.5 second delay, dealing magic damage to enemies within a moderate area." });
		champSpells[109] = xerathSpells;

		SpellInfo[] xinZhaoSpells = new SpellInfo[5];
		xinZhaoSpells[0] = new SpellInfo(
				"Challenge",
				"",
				"",
				"",
				arrS,
				new String[] { "Basic attacks and Audacious Charge challenge Xin Zhao's target, reducing their armor by 15% for 3 seconds. Only one target can be affected by Challenge at any time." });
		xinZhaoSpells[1] = new SpellInfo(
				"Three Talon Strike",
				"",
				"9 / 8 / 7 / 6 / 5",
				"30 MANA",
				new String[] { "BONUS PHYSICAL DAMAGE: 15 / 30 / 45 / 60 / 75 (+ 20% AD)",
						"TOTAL BONUS DAMAGE: 45 / 90 / 135 / 180 / 225 (+ 60% AD)" },
				new String[] { "ACTIVE: Xin Zhao's next 3 basic attacks deal bonus physical damage and reduce his other abilities' cooldowns by 1 second each. The third strike also knocks the target into the air for 1 second." });
		xinZhaoSpells[2] = new SpellInfo("Battle Cry", "", "16 / 15 / 14 / 13 / 12", "40 MANA", new String[] {
				"HEAL: 26 / 32 / 38 / 44 / 50 (+ 70% AP)", "ATTACK SPEED: 40 / 50 / 60 / 70 / 80%" }, new String[] {
				"PASSIVE: Xin Zhao heals himself on every third basic attack. ",
				"ACTIVE: Xin Zhao increases his attack speed for 5 seconds." });
		xinZhaoSpells[3] = new SpellInfo(
				"Audacious Charge",
				"600",
				"14 / 13 / 12 / 11 / 10",
				"60 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 105 / 140 / 175 / 210 (+ 60% AP)", "SLOW: 25 / 30 / 35 / 40 / 45%" },
				new String[] { "ACTIVE: Xin Zhao charges at an enemy, dealing magic damage to all enemies within 112.5 range and slowing them for 2 seconds." });
		xinZhaoSpells[4] = new SpellInfo(
				"Crescent Sweep",
				"187.5",
				"120 / 110 / 100",
				"100 MANA",
				new String[] {
						"TOTAL PHYSICAL DAMAGE: 75 / 175 / 275 (+ 100% bonus AD) (+ 15% of enemies' current health)",
						"ARMOR AND MAGIC RESIST PER CHAMPION HIT: 15 / 20 / 25",
						"MAX ARMOR / MAGIC RESIST BONUS: 75 / 100 / 125" },
				new String[] {
						"ACTIVE: Xin Zhao unleashes a sweep around him, knocking enemies back and dealing physical damage equal to a base amount plus 15% of their current health (capped at 600 against monsters). Xin Zhao gains bonus armor and magic resistance for each champion struck, lasting for 6 seconds.",
						"Crescent Sweep will not knock back the enemy currently affected by Challenge." });
		champSpells[110] = xinZhaoSpells;

		SpellInfo[] yasuoSpells = new SpellInfo[5];
		yasuoSpells[0] = new SpellInfo(
				"Way of the Wanderer",
				"",
				"",
				"",
				arrS,
				new String[] {
						"INTENT: Yasuo's critical strike chance is doubled, but the damage dealt by his critical strikes is reduced by 10% (25% on Steel Tempest).",
						"RESOLVE: At maximum Flow, the next time Yasuo would take damage from a champion or monster he first converts his Flow into a shield that absorbs damage. After 1.5 seconds, if not already depleted, Yasuo loses all his Flow." });
		// another weird one
		yasuoSpells[1] = new SpellInfo(
				"Steel Tempest",
				"See below",
				"(STATIC) 5 / 4.75 / 4.5 / 4.25 / 4",
				"",
				new String[] { "PHYSICAL DAMAGE: 20 / 40 / 60 / 80 / 100 (+ 100% AD)" },
				new String[] {
						"Consecutive successful casts of Steel Tempest within 10 seconds form a chain.",
						"FIRST ACTIVE: Yasuo thrusts his sword forward, dealing physical damage to all enemies in a 475-unit line. If cast while using Sweeping Blade, the area of effect is changed to a ~375-radius circle around Yasuo.",
						"SECOND ACTIVE: Same as the first active.",
						"THIRD ACTIVE: Yasuo brandishes his sword causing a whirlwind to tear forward in a ~900-unit line, dealing physical damage and knocking airborne all enemies hit. If cast while using Sweeping Blade, the area of effect is changed to an ~375-radius circle around Yasuo. This active resets the chain.",
						"Steel Tempest can critically strike, having a 25% damage penalty. Without any additional critical damage the bonus damage equals 50% of Yasuo's attack damage. Additionally, on-hit effects will be applied to the first enemy hit within 475-unit range. The cooldown and cast time of Steel Tempest is reduced based on Yasuo's bonus attack speed and unaffected by cooldown reduction." });
		yasuoSpells[2] = new SpellInfo(
				"Wind Wall",
				"400",
				"26 / 24 / 22 / 20 / 18",
				"",
				new String[] { "FLOW: 3 / 6 / 9 / 12 / 15%", "WALL WIDTH: 300 / 350 / 400 / 450 / 500" },
				new String[] {
						"PASSIVE: Yasuo generates a percentage of his maximum Flow whenever he uses Sweeping Blade in addition to the amount that is generated for the distance moved.",
						"ACTIVE: Yasuo creates a gust of wind that travels forward to form a wall 400 units away from himself. The wall slowly drifts forward over 3.75 seconds, blocking all enemy projectiles with the exception of tower hits." });
		yasuoSpells[3] = new SpellInfo(
				"Sweeping Blade",
				"475",
				"(STATIC) 0.5 / 0.4 / 0.3 / 0.2 / 0.1",
				"",
				new String[] { "MARK DURATION: 10 / 9 / 8 / 7 / 6",
						"MAGIC DAMAGE: 70 / 90 / 110 / 130 / 150 (+ 60% AP)",
						"MAXIMUM DAMAGE: 140 / 180 / 220 / 260 / 300 (+ 60% AP)" },
				new String[] {
						"ACTIVE: Yasuo dashes 475 units in the direction of the target enemy, dealing magic damage and marking them briefly. The speed of the dash scales with Yasuo's bonus movement speed.",
						"Each cast increases the next dash's base damage by 25% for 5 seconds, up to 100% bonus damage. Yasuo cannot use Sweeping Blade on an enemy that's already been marked." });
		yasuoSpells[4] = new SpellInfo(
				"Last Breath",
				"1200",
				"80 / 55 / 30",
				"",
				new String[] { "PHYSICAL DAMAGE: 200 / 300 / 400 (+ 150% bonus AD)" },
				new String[] {
						"ACTIVE: Yasuo blinks to the nearest visible airborne enemy champion to the cursor, instantly generating maximum Flow. Upon arriving, he suspends all airborne units within a 400-radius of his target in the air for 1 second while dealing physical damage to all of them. Once he lands, Yasuo gains 50% penetration to bonus armor for 15 seconds.",
						"Casting Last Breath will reset the chain on Steel Tempest." });
		champSpells[111] = yasuoSpells;

		SpellInfo[] yorickSpells = new SpellInfo[5];
		yorickSpells[0] = new SpellInfo(
				"Unholy Covenant",
				"",
				"",
				"",
				new String[] { "GHOUL HEALTH: 35% of Yorick's maximum health", "ATTACK DAMAGE: 35% of Yorick's AD",
						"ARMOR: 10 + (2 × level)", "MAGIC RESIST: 10 + (2 × level)", "ATTACK SPEED: 0.670",
						"MOVE SPEED: 300 / 340 / 390 / 443" },
				new String[] {
						"Yorick takes 5% less damage and his basic attacks deal 5% more damage for each of his active summons. All of Yorick's basic abilities summon a Ghoul and Omen of Death summons a Revenant.",
						"GHOULS: Ghouls last for 5 seconds. Their health and damage are calculated from Yorick's totals. They also have special effects determined by the ability used to summon them." });
		yorickSpells[1] = new SpellInfo(
				"Omen of War",
				"",
				"9 / 8 / 7 / 6 / 5",
				"40 MANA",
				new String[] { "TOTAL PHYSICAL DAMAGE: 30 / 60 / 90 / 120 / 150 (+ 120% AD)",
						"SPECTRAL GHOUL ATTACK DAMAGE: 8 / 16 / 24 / 32 / 40 (+ 35% AD)",
						"MOVEMENT SPEED INCREASE: 15 / 20 / 25 / 30 / 35%" },
				new String[] {
						"ACTIVE: Yorick's next basic attack within 10 seconds will deal bonus physical damage and summon a Spectral Ghoul.",
						"SPECTRAL GHOUL: Has higher attack damage than other Ghouls. Grants itself and Yorick a movement speed buff." });
		yorickSpells[2] = new SpellInfo(
				"Omen of Pestilence",
				"600",
				"12",
				"55 / 60 / 65 / 70 / 75 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 100% AP)", "SLOW: 20 / 25 / 30 / 35 / 40%",
						"DECAYING GHOUL SLOW AURA: 10 / 12.5 / 15 / 17.5 / 20%" },
				new String[] {
						"ACTIVE: Yorick summons a Decaying Ghoul that arrives with a violent explosion, dealing magic damage in a 100-radius area and slowing enemies hit for 1.5 seconds.",
						"DECAYING GHOUL: Has a 62.5-radius aura that slows nearby enemies." });
		yorickSpells[3] = new SpellInfo(
				"Omen of Famine",
				"550",
				"10 / 9 / 8 / 7 / 6",
				"55 / 60 / 65 / 70 / 75 MANA",
				new String[] { "MAGIC DAMAGE: 55 / 85 / 115 / 145 / 175 (+ 100% Bonus AD)",
						"RAVENOUS GHOUL HEAL ON ATTACK: 35% of Yorick's AD" },
				new String[] {
						"ACTIVE: Yorick steals life from his target, dealing magic damage, healing himself for 40% of the damage dealt and summoning a Ravenous Ghoul behind them.",
						"RAVENOUS GHOUL: Heals Yorick with each attack. This effect is halved when attacking minions and monsters." });
		yorickSpells[4] = new SpellInfo(
				"Omen of Death",
				"900",
				"120 / 105 / 90",
				"100 MANA",
				new String[] { "REVENANT HEALTH: 50 / 75 / 100% of the ally's health",
						"ATTACK DAMAGE: 45 / 60 / 75% of the ally's AD" },
				new String[] {
						"ACTIVE: Yorick conjures a Revenant in the image of an allied champion. If that ally takes lethal damage before the Revenant dies, the Revenant sacrifices itself to reanimate them and give them 10 seconds to enact vengeance.",
						"REVENANT: A Revenant lasts 10 seconds. It has health and attack damage calculated from the target's totals. It can be controlled by holding the alt key and using the right mouse button or by reactivating this ability." });
		champSpells[112] = yorickSpells;

		SpellInfo[] zacSpells = new SpellInfo[5];
		zacSpells[0] = new SpellInfo(
				"Cell Division",
				"",
				"(STATIC) 300",
				"",
				arrS,
				new String[] {
						"Each time Zac uses an ability on enemies, he sheds a chunk of himself to a nearby location. Zac can move over these chunks to reabsorb them, regaining 4% of his maximum health. Enemies may move over these chunks to destroy them.",
						"Upon taking fatal damage, Zac splits into 4 bloblets that attempt to recombine. Each bloblet has 12% of Zac's maximum health, and 50% of his armor and magic resistance. If any of these bloblets remain after 8 seconds, Zac will revive with 10-50% health depending on the health of the surviving chunks." });
		zacSpells[1] = new SpellInfo(
				"Stretching Strike",
				"550",
				"9 / 8.5 / 8 / 7.5 / 7",
				"4% OF CURRENT HEALTH",
				new String[] { "BASE MAGIC DAMAGE: 40 / 55 / 70 / 85 / 100", "SLOW: 20 / 25 / 30 / 35 / 40%" },
				new String[] { "ACTIVE: Zac lashes out with an elastic punch, dealing magic damage to enemies in a line and slowing them for 2 seconds." });
		zacSpells[2] = new SpellInfo(
				"Unstable Matter",
				"",
				"4",
				"4% OF CURRENT HEALTH",
				new String[] { "BASE MAGIC DAMAGE: 40 / 55 / 70 / 85 / 100",
						"ADDITIONAL DAMAGE: 4 / 5 / 6 / 7 / 8% (+ 2% per 100 AP) of enemies' maximum health" },
				new String[] { "ACTIVE: Zac's body explodes outward, dealing magic damage equal to a base amount plus a percentage of their maximum health to all nearby enemies (max 200 damage against minions and monsters)." });
		zacSpells[3] = new SpellInfo(
				"Elastic Slingshot",
				"",
				"24 / 21 / 18 / 15 / 12",
				"4% OF CURRENT HEALTH",
				new String[] { "MAGIC DAMAGE: 80 / 120 / 160 / 200 / 240 (+ 70% AP)",
						"MAX CHANNEL TIME: 0.9 / 1.0 / 1.1 / 1.2 / 1.3", "MAX RANGE: 1150 / 1250 / 1350 / 1450 / 1550" },
				new String[] {
						"ACTIVE: Zac faces the cursor and begins channeling. After channeling or after reactivating the ability he launches himself towards the target location, dealing magic damage to all enemies hit and knocking them back for 0.5 seconds. The range of Elastic Slingshot increases based on how long Zac channels.",
						"Can be cancelled by moving, refunding 50% of the health cost and halving the cooldown." });
		zacSpells[4] = new SpellInfo(
				"Let's Bounce!",
				"",
				"130 / 115 / 100",
				"NO COST",
				new String[] { "MAGIC DAMAGE PER BOUNCE: 140 / 210 / 280 (+ 40% AP)",
						"MAX MAGIC DAMAGE TO THE SAME TARGET: 350 / 525 / 700 (+ 100% AP)" },
				new String[] {
						"ACTIVE: Zac leaps into the air and begins to bounce on the ground, up to a maximum of 4 bounces. Each bounce deals magic damage to nearby enemies upon impact, knocks them up for 1 second, and slows them by 20% for 1 second. Enemies hit more than once take half damage and are not knocked up.",
						"Zac gains an accelerating movement speed buff (20-50%) while bouncing. During this time, Zac can still move and use Unstable Matter, but is unable to activate Stretching Strike or Elastic Slingshot." });
		champSpells[113] = zacSpells;

		SpellInfo[] zedSpells = new SpellInfo[5];
		zedSpells[0] = new SpellInfo(
				"Contempt for the Weak",
				"",
				"",
				"",
				arrS,
				new String[] { "Zed's basic attacks against targets below 50% health deal 6 / 8 / 10% of the target's maximum health as bonus magic damage. This effect can only occur once every 10 seconds on the same target." });
		zedSpells[1] = new SpellInfo(
				"Razor Shuriken",
				"900",
				"6",
				"75 / 70 / 65 / 60 / 55 ENERGY",
				new String[] { "PHYSICAL DAMAGE: 75 / 115 / 155 / 195 / 235 (+ 100% bonus AD)",
						"SECONDARY DAMAGE: 45 / 69 / 93 / 117 / 141 (+ 60% bonus AD)",
						"MIMICKED SHURIKEN: 37.5 / 57.5 / 77.5 / 97.5 / 117.5 (+ 50% bonus AD)",
						"MIMICKED SECONDARY DAMAGE: 22.5 / 34.5 / 46.5 / 58.5 / 70.5 (+ 30% bonus AD)" },
				new String[] {
						"ACTIVE: Zed throws his spinning blades forward, dealing physical damage to the first enemy they pass through and 60% damage to enemies thereafter.",
						"LIVING SHADOW: Active shadows will also throw a shuriken in the direction of the target point. Additional shuriken striking the same enemy deal 50% damage and restore energy." });
		zedSpells[2] = new SpellInfo(
				"Living Shadow",
				"550",
				"18 / 17 / 16 / 15 / 14",
				"40 / 35 / 30 / 25 / 20 ENERGY",
				new String[] { "BONUS ATTACK DAMAGE: 5 / 10 / 15 / 20 / 25% Bonus AD",
						"ENERGY RESTORED: 20 / 25 / 30 / 35 / 40" },
				new String[] {
						"PASSIVE: Zed's bonus attack damage is increased by a percentage.",
						"ACTIVE: Zed's shadow dashes forward, remaining in place for 4 seconds. Reactivating Living Shadow will cause Zed to swap places with this shadow.",
						"LIVING SHADOW: Zed's shadows mimic his basic abilities. If a target is struck twice by a mimicked ability, Zed restores some energy. Energy can only be restored once per mimicked cast." });
		zedSpells[3] = new SpellInfo(
				"Shadow Slash",
				"290",
				"4",
				"50 ENERGY",
				new String[] { "PHYSICAL DAMAGE: 60 / 90 / 120 / 150 / 180 (+ 80% bonus AD)",
						"SLOW: 20 / 25 / 30 / 35 / 40%", "OVERLAPPING SLOW: 30 / 37.5 / 45 / 52.5 / 60%" },
				new String[] {
						"ACTIVE: Zed spins his blades, creating a burst of shadow energy and dealing physical damage to nearby enemies. Each enemy champion hit reduces Living Shadow's cooldown by 2 seconds.",
						"LIVING SHADOW: Active shadows also slash, dealing physical damage to nearby enemies and slowing them for 1.5 seconds. Enemies hit by both slashes are slowed more and restore energy but will not take additional damage." });
		zedSpells[4] = new SpellInfo(
				"Death Mark",
				"625",
				"120 / 100 / 80",
				"NO COST",
				new String[] { "PHYSICAL DAMAGE: 100% AD + 20 / 35 / 50% of damage dealt" },
				new String[] {
						"ACTIVE: Zed becomes untargetable for 0.75 seconds and dashes to the target enemy champion. Upon arrival, he marks the target for death and spawns a shadow that lasts for 6 seconds at the cast location. Reactivating Death Mark will cause Zed to swap places with this shadow.",
						"After 3 seconds, Death Mark will trigger, dealing flat physical damage plus a percentage of all physical and magic damage dealt to the marked champion while it was active." });
		champSpells[114] = zedSpells;

		SpellInfo[] ziggsSpells = new SpellInfo[5];
		ziggsSpells[0] = new SpellInfo(
				"Short Fuse",
				"",
				"12",
				"",
				arrS,
				new String[] { "Every 12 seconds, Ziggs' next basic attack deals 20 / 24 / 28 / 32 / 36 / 40 / 48 / 56 / 64 / 72 / 80 / 88 / 100 / 112 / 124 / 136 / 148 / 160 (16 + 4 / 8 / 12 at each level) (+ 25 / 30 / 35% AP) bonus magic damage. The cooldown is reduced by 4 seconds whenever Ziggs uses an ability but not from other sources of cooldown reduction. Short Fuse deals 50% bonus (150% total) damage to enemy structures." });
		ziggsSpells[1] = new SpellInfo(
				"Bouncing Bomb",
				"850",
				"6 / 5.5 / 5 / 4.5 / 4",
				"50 / 60 / 70 / 80 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 75 / 120 / 165 / 210 / 255 (+ 65% AP)", "MAXIMUM RANGE: 1400",
						"EXPLOSION RADIUS: 150", "INITIAL THROW SPEED: 1700" },
				new String[] { "ACTIVE: Ziggs throws a bouncing bomb to a target area. If the bomb contacts an enemy or bounces three times then it explodes, dealing magic damage in an area. The distance of each bounce is dependent on how far it was originally thrown." });
		ziggsSpells[2] = new SpellInfo(
				"Satchel Charge",
				"1000",
				"26 / 24 / 22 / 20 / 18",
				"65 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 105 / 140 / 175 / 210 (+ 35% AP)", "RADIUS: 325" },
				new String[] { "ACTIVE: Ziggs flings an explosive charge to the target area. The charge gives sight nearby and detonates after 4 seconds or when this ability is activated again. The explosion deals magic damage and enemies hit are knocked away. Ziggs is also knocked away, but takes no damage." });
		ziggsSpells[3] = new SpellInfo(
				"Hexplosive Minefield",
				"900",
				"16",
				"70 / 80 / 90 / 100 / 110 MANA",
				new String[] { "MAGIC DAMAGE PER MINE: 40 / 65 / 90 / 115 / 140 (+ 30% AP)",
						"REDUCED DAMAGE PER MINE: 16 / 26 / 36 / 46 / 56 (+ 12% AP)",
						"MAX SINGLE TARGET DAMAGE: 200 / 325 / 450 / 575 / 700 (+ 150% AP)",
						"SLOW: 20 / 25 / 30 / 35 / 40%", "SCATTER RADIUS: 250" },
				new String[] { "ACTIVE: Ziggs scatters 11 proximity mines that detonate on enemy contact, dealing magic damage and slowing the enemy for 1.5 seconds. Enemies take 40% damage for each mine they detonate beyond the first. Mines disarm automatically after 10 seconds." });
		ziggsSpells[4] = new SpellInfo(
				"Mega Inferno Bomb",
				"5300",
				"120 / 105 / 90",
				"100 MANA",
				new String[] { "MAGIC DAMAGE: 250 / 375 / 500 (+ 90% AP)",
						"SECONDARY MAGIC DAMAGE: 200 / 300 / 400 (+ 72% AP)", "PRIMARY RADIUS: 275",
						"SECONDARY RADIUS: 550" },
				new String[] { "ACTIVE: Ziggs deploys his ultimate creation, the Mega Inferno Bomb, hurling it an enormous distance. Enemies in the primary blast zone take full magic damage (double damage to minions, but not monsters) while those further away take 80%." });
		champSpells[115] = ziggsSpells;

		SpellInfo[] zileanSpells = new SpellInfo[5];
		zileanSpells[0] = new SpellInfo(
				"Heightened Learning",
				"",
				"",
				"",
				arrS,
				new String[] { "Increases experience gain of all allied champions by 8%. This bonus is unavailable while Zilean is dead." });
		zileanSpells[1] = new SpellInfo(
				"Time Bomb",
				"700",
				"10",
				"70 / 85 / 100 / 115 / 130 MANA",
				new String[] { "MAGIC DAMAGE: 90 / 145 / 200 / 260 / 320 (+ 90% AP)" },
				new String[] { "ACTIVE: Zilean places a ticking time bomb on any unit, allied or enemy, which detonates after 4 seconds, dealing magic damage in a 330-unit area. Bombs will detonate immediately if the holder dies or if another bomb is placed on them." });
		zileanSpells[2] = new SpellInfo("Rewind", "", "18 / 15 / 12 / 9 / 6", "50 MANA", arrS,
				new String[] { "ACTIVE: Zilean reduces the cooldowns of all of his other abilities by 10 seconds." });
		zileanSpells[3] = new SpellInfo(
				"Time Warp",
				"700",
				"20",
				"80 MANA",
				new String[] { "DURATION: 2.5 / 3.25 / 4 / 4.75 / 5.5" },
				new String[] { "ACTIVE: Zilean bends time around a champion, slowing an enemy champion or increasing an ally champion's movement speed by 55% for a short time." });
		zileanSpells[4] = new SpellInfo(
				"Chrono Shift",
				"900",
				"180",
				"125 / 150 / 175 MANA",
				new String[] { "HEALTH REGAINED: 600 / 850 / 1100 (+ 200% AP)" },
				new String[] { "ACTIVE: Zilean places a protective time rune on an allied champion for 7 seconds. If the target takes lethal damage during that time, they will be placed in stasis - making them untargetable and invulnerable. After 2 seconds, the target is revived with a set amount of health." });
		champSpells[116] = zileanSpells;

		SpellInfo[] zyraSpells = new SpellInfo[5];
		zyraSpells[0] = new SpellInfo(
				"Rise of the Thorns",
				"1500 (estimate)",
				"",
				"",
				arrS,
				new String[] { "Upon death, Zyra returns to her plant form for up to 8 seconds. After 2 seconds, she can use any learned ability to fire a Vengeful Thorn in a line towards the cursor, dealing 80 + (20 x level) true damage to every enemy it passes through." });
		zyraSpells[1] = new SpellInfo(
				"Deadly Bloom",
				"800",
				"7 / 6.5 / 6 / 5.5 / 5",
				"75 / 80 / 85 / 90 / 95 MANA",
				new String[] { "MAGIC DAMAGE: 70 / 105 / 140 / 175 / 210 (+ 65% AP)" },
				new String[] {
						"ACTIVE: After a short delay, thorns shoot from the ground at a target location, dealing magic damage to enemies within the area.",
						"RAMPANT GROWTH: If Deadly Bloom hits a seed, a Thorn Spitter grows that lasts for 10 seconds. Thorn Spitters have a long ranged attack and deal 23 + (6.5 × level) (+ 20% AP) magic damage." });
		zyraSpells[2] = new SpellInfo(
				"Rampant Growth",
				"850",
				"",
				"1 SEED",
				new String[] { "COOLDOWN REDUCTION: 2 / 4 / 6 / 8 / 10%",
						"SEED RECHARGE TIME INCLUDING ITSELF: 16.7 / 15.4 / 14.1 / 12.9 / 11.7" },
				new String[] {
						"PASSIVE: Grants bonus cooldown reduction.",
						"ACTIVE: Plants a seed at a target point for 30 seconds, granting sight of a small area around it. Zyra generates seeds over time, can hold up to 2 seeds, and cannot plant more than 4 seeds at a time.",
						"After 1.5 seconds, if an enemy champion steps on a seed, it will be destroyed, but they will be revealed by true sight for 2 seconds.",
						"If Zyra's spells hit a seed they will sprout into a plant, automatically attacking nearby enemies for 10 seconds. Plant damage is based on Zyra's level. Extra plants striking the same target deal 50% less damage." });
		zyraSpells[3] = new SpellInfo(
				"Grasping Roots",
				"1100",
				"12",
				"70 / 75 / 80 / 85 / 90 MANA",
				new String[] { "MAGIC DAMAGE: 60 / 95 / 130 / 165 / 200 (+ 50% AP)",
						"ROOT DURATION: 0.75 / 1 / 1.25 / 1.5 / 1.75" },
				new String[] {
						"ACTIVE: Sends vines forward in a line, dealing magic damage and rooting enemies hit for a short duration.",
						"RAMPANT GROWTH: If Grasping Roots hits a seed, a Vine Lasher grows that lasts for 10 seconds. Vine Lashers have a short ranged attack that deals 23 + (6.5 × level) (+ 20% AP) magic damage and slows enemies hit by 30% for 2 seconds." });
		zyraSpells[4] = new SpellInfo(
				"Stranglethorns",
				"700",
				"130 / 120 / 110",
				"100 / 120 / 140 MANA",
				new String[] { "MAGIC DAMAGE: 180 / 265 / 350 (+ 70% AP)" },
				new String[] {
						"ACTIVE: Summons the fury of nature, growing a twisted thicket at the target location which deals magic damage to all enemies in the area as it expands. After 2 seconds, the vines snap upward knocking enemies into the air for 1 second.",
						"RAMPANT GROWTH: Plants within the thicket are enraged, increasing their attack speed by 50%." });
		champSpells[117] = zyraSpells;

	}

	// gets the Champion Spell Array
	public SpellInfo[][] getSpellArray()
	{
		return champSpells;
	}
}
