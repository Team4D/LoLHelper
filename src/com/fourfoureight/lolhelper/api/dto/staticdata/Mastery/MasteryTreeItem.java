/**
 * 
 */
package lolapi.dto.staticdata.Mastery;

/**
 * @author Shyos
 * 
 */
public class MasteryTreeItem {
	private String masteryId;
	private String prereq;
	/**
	 * @return the masteryId
	 */
	public String getMasteryId() {
		return masteryId;
	}
	/**
	 * @param masteryId the masteryId to set
	 */
	public void setMasteryId(String masteryId) {
		this.masteryId = masteryId;
	}
	/**
	 * @return the prereq
	 */
	public String getPrereq() {
		return prereq;
	}
	/**
	 * @param prereq the prereq to set
	 */
	public void setPrereq(String prereq) {
		this.prereq = prereq;
	}
}
