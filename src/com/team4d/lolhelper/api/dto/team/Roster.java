package com.team4d.lolhelper.api.dto.team;

import java.util.ArrayList;

public class Roster {
	private ArrayList<TeamMemberInfo> memberList;	
	private long ownerId;
	/**
	 * @return the memberList
	 */
	public ArrayList<TeamMemberInfo> getMemberList() {
		return memberList;
	}
	/**
	 * @return the ownerId
	 */
	public long getOwnerId() {
		return ownerId;
	}
}
