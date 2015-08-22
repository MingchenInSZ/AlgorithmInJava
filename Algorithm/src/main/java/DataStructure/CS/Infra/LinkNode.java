package DataStructure.CS.Infra;

/**
 * The linkList node class
 * 
 * @author mingchen
 * @date 2015年8月19日
 */
public class LinkNode {
	// the parameters value and the next pointer
	public int value;
	public LinkNode next = null;

	/**
	 * 
	 * Constructor function of Class
	 * 
	 * @param value
	 */
	public LinkNode(int value) {
		this.value = value;
		next = null;
	}
}
