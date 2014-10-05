package com.team4d.lolhelper.api.dto;

public enum Region
{
	BR("br"),
	EUNE("eune"),
	EUW("euw"),
	KR("kr"),
	LAN("lan"),
	LAS("las"),
	NA("na"),
	OCE("oce"),
	RU("ru"),
	TR("tr"),
	GLOBAL("global");

	private String name = null;

	Region(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}
