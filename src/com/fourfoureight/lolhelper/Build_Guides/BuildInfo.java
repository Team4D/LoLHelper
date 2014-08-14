package com.fourfoureight.lolhelper.Build_Guides;

public class BuildInfo {
	//Build Guide Variables - Start (4), Rush (4), As Needed (5)
	private String[] start = {
			"total_transparent",
			"total_transparent",
			"total_transparent",
			"total_transparent"};
	private String[] rush = {
			"total_transparent"
			,"total_transparent"
			,"total_transparent"
			,"total_transparent"};
	private String[] asNeeded = {
			"total_transparent",
			"total_transparent",
			"total_transparent",
			"total_transparent",
			"total_transparent"};
	
	private boolean exists = false;
	private String name = "";
	
	public BuildInfo(){
		
	}
	
	public boolean exists(){
		return exists;
	}
		
	public void setName(String set){
		name = set;
	}
	public String getName(){
		return name;
	}
	public void setStart(String set){
		exists = true;
		start[0]=set;
		start[1]="total_transparent";
		start[2]="total_transparent";
		start[3]="total_transparent";
	}
	
	public void setStart(String set1, String set2){
		exists = true;
		start[0]=set1;
		start[1]=set2;
		start[2]="total_transparent";
		start[3]="total_transparent";
	}
	
	public void setStart(String set1, String set2, String set3){
		exists = true;
		start[0]=set1;
		start[1]=set2;
		start[2]=set3;
		start[3]="total_transparent";
	}
	
	public void setStart(String set1, String set2, String set3, String set4){
		exists = true;
		start[0]=set1;
		start[1]=set2;
		start[2]=set3;
		start[3]=set4;
	}
	
	public void setRush(String set){
		exists = true;
		rush[0]=set;
		rush[1]="total_transparent";
		rush[2]="total_transparent";
		rush[3]="total_transparent";
	}
	
	public void setRush(String set1, String set2){
		exists = true;
		rush[0]=set1;
		rush[1]=set2;
		rush[2]="total_transparent";
		rush[3]="total_transparent";
	}
	
	public void setRush(String set1, String set2, String set3){
		exists = true;
		rush[0]=set1;
		rush[1]=set2;
		rush[2]=set3;
		rush[3]="total_transparent";
	}
	
	public void setRush(String set1, String set2, String set3, String set4){
		exists = true;
		rush[0]=set1;
		rush[1]=set2;
		rush[2]=set3;
		rush[3]=set4;
	}
	
	public void setAsNeeded(String set){
		exists = true;
		asNeeded[0]=set;
		asNeeded[1]="total_transparent";
		asNeeded[2]="total_transparent";
		asNeeded[3]="total_transparent";
		asNeeded[4]="total_transparent";
	}
	
	public void setAsNeeded(String set1, String set2){
		exists = true;
		asNeeded[0]=set1;
		asNeeded[1]=set2;
		asNeeded[2]="total_transparent";
		asNeeded[3]="total_transparent";
		asNeeded[4]="total_transparent";
	}
	
	public void setAsNeeded(String set1, String set2, String set3){
		exists = true;
		asNeeded[0]=set1;
		asNeeded[1]=set2;
		asNeeded[2]=set3;
		asNeeded[3]="total_transparent";
		asNeeded[4]="total_transparent";
	}
	
	public void setAsNeeded(String set1, String set2, String set3, String set4){
		exists = true;
		asNeeded[0]=set1;
		asNeeded[1]=set2;
		asNeeded[2]=set3;
		asNeeded[3]=set4;
		asNeeded[4]="total_transparent";
	}
	
	public void setAsNeeded(String set1, String set2, String set3, String set4, String set5){
		exists = true;
		asNeeded[0]=set1;
		asNeeded[1]=set2;
		asNeeded[2]=set3;
		asNeeded[3]=set4;
		asNeeded[4]=set5;
	}
	
	public String[] getStart(){
		return start;
	}

	public String[] getRush(){
		return rush;
	}

	public String[] getAsNeeded(){
		return asNeeded;
	}
	
	public void clear(){
		exists=false;
		for(int i=0; i<4; i++){
			start[i]="total_transparent";
			rush[i]="total_transparent";
			asNeeded[i]="total_transparent";
		}
		asNeeded[4]="total_transparent";
		name="";
	}
}
