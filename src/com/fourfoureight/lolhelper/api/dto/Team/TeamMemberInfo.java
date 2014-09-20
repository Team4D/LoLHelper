package com.fourfoureight.lolhelper.api.dto.Team;


public class TeamMemberInfo {
	private long inviteDate;	
	private long joinDate;	
	private long playerId;	
	private String status;
	
	/**
	 * @return the inviteDate
	 */
	public long getInviteDate() {
		return inviteDate;
	}
	/**
	 * @param inviteDate the inviteDate to set
	 */
	public void setInviteDate(long inviteDate) {
		this.inviteDate = inviteDate;
	}
	/**
	 * @return the joinDate
	 */
	public long getJoinDate() {
		return joinDate;
	}
	/**
	 * @param joinDate the joinDate to set
	 */
	public void setJoinDate(long joinDate) {
		this.joinDate = joinDate;
	}
	/**
	 * @return the playerId
	 */
	public long getPlayerId() {
		return playerId;
	}
	/**
	 * @param playerId the playerId to set
	 */
	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
