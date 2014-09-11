package com.fourfoureight.lolhelper.General_Info;

// Description:
// Utility class ChampionAttributes to store a champion is good at some
// strategy or not.
// Caller: TeamBuilder.java, TeamBuilderData.java

public class ChampionAttributes
{

	private final String name;
	private final int[] attribute = new int[10];
	/*
	 * Strategy ratings are stored in the attribute array.
	 * index0: HardEngage;
	 * index1: SplitPush;
	 * index2: Poke;
	 * index3: CatchOut;
	 * index4: WomboCombo;
	 * index5: DunkSquad;
	 * index6: YordleOnly;
	 * index7: FullReviveBungaloo;
	 * index8: EarlyGame;
	 * index9: LateGame;
	 * values encoding: 0 means not good at, 10 means fair, 20 means very good at.
	 */

	private final int[] position = new int[5];

	/*
	 * position array stores the suitable positions for each champion.
	 * index0: top;
	 * index1: middle;
	 * index2: ADC;
	 * index3: support;
	 * index4: jungle;
	 * values encoding: 0 means not good at this position, 1 means good at.
	 */

	// Default constructor
	public ChampionAttributes()
	{
		this.name = "NONAME";
		for (int i = 0; i < 10; i++)
		{
			this.attribute[i] = 0;
		}
		for (int i = 0; i < 5; i++)
		{
			this.position[i] = 0;
		}
	}

	// Constructor with champion data
	public ChampionAttributes(String name, int[] attribute, int[] position)
	{
		this.name = name;
		for (int i = 0; i < 10; i++)
		{
			this.attribute[i] = attribute[i];
		}
		for (int i = 0; i < 5; i++)
		{
			this.position[i] = position[i];
		}
	}

	// return the name of a champion
	public String getName()
	{
		return this.name;
	}

	// return the certain strategy rating for a champion.
	public int getAttribute(int strategy)
	{
		return this.attribute[strategy];
	}

	// return a champion is good at some position or not.
	public int getPosition(int pos)
	{
		return this.position[pos];
	}
}
