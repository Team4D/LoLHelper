/**
 * 
 */
package lolapi.dto.staticdata.Mastery;

import java.util.List;

/**
 * @author Shyos
 * 
 */
public class MasteryTree {
	private List<MasteryTreeList> Defense;
	private List<MasteryTreeList> Offense;
	private List<MasteryTreeList> Utility;

	/**
	 * @return the defense
	 */
	public List<MasteryTreeList> getDefense() {
		return Defense;
	}

	/**
	 * @param defense
	 *            the defense to set
	 */
	public void setDefense(List<MasteryTreeList> defense) {
		Defense = defense;
	}

	/**
	 * @return the offense
	 */
	public List<MasteryTreeList> getOffense() {
		return Offense;
	}

	/**
	 * @param offense
	 *            the offense to set
	 */
	public void setOffense(List<MasteryTreeList> offense) {
		Offense = offense;
	}

	/**
	 * @return the utility
	 */
	public List<MasteryTreeList> getUtility() {
		return Utility;
	}

	/**
	 * @param utility
	 *            the utility to set
	 */
	public void setUtility(List<MasteryTreeList> utility) {
		Utility = utility;
	}
}
