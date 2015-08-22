package DataStructure.CS.Algorithm;

import DataStructure.CS.Infra.LinkNode;

/**
 * This is the linkList creator class
 * 
 * The content of the head: value the node number next pointer to linkNode
 * 
 * @author mingchen
 * @date 2015年8月22日
 */
public class LinkCreator {
	public LinkNode head;

	/**
	 * 
	 * Constructor function of Class
	 */
	public LinkCreator() {
		head = new LinkNode(0);
		head.next = null;
	}

	/**
	 * append value of the linknode to the tail [taking no consideration of
	 * replication]
	 * 
	 * @param value
	 *            void 2015年8月22日
	 */
	public void append(int value) {
		LinkNode pointer = head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		LinkNode ln = new LinkNode(value);
		ln.next = null;
		pointer.next = ln;
		incr();
	}

	/**
	 * Create LinkList from array
	 * 
	 * @param values
	 * @return LinkNode 2015年8月22日
	 */
	public LinkNode createLinkList(int[] values) {
		for (int key : values) {
			insertAfterHead(key);
		}
		return head;
	}

	/**
	 * first check whether the value in list ,if not insert
	 * 
	 * @param value
	 *            void 2015年8月22日
	 */
	public void insert(int value) {
		LinkNode pointer = head.next;
		LinkNode pre = pointer;
		while (pointer != null) {
			pre = pointer;
			if (pointer.value == value) {
				break;
			}
			pointer = pointer.next;
		}
		if (pre == null) {
			LinkNode ln = new LinkNode(value);
			ln.next = null;
			head.next = ln;
			incr();
		} else if (pre.value != value) {
			LinkNode ln = new LinkNode(value);
			ln.next = null;
			pre.next = ln;
			incr();
		}


	}

	/**
	 * create linklist with no replication
	 * 
	 * @param array
	 *            void 2015年8月22日
	 */
	public void createLinkListNoRep(int[] array) {
		for (int key : array) {
			insert(key);
		}
	}

	/**
	 * clear linklist
	 * 
	 * void 2015年8月22日
	 */
	public void clear() {
		head.value = 0;
		head.next = null;
	}

	/**
	 * insert node after head
	 * 
	 * @param value
	 *            void
	 * 
	 *            2015年8月22日
	 */
	public void insertAfterHead(int value) {
		LinkNode pointer = head.next;
		LinkNode ln = new LinkNode(value);
		ln.next = pointer;
		head.next = ln;
		incr();
	}

	/**
	 * reverse the link list
	 * 
	 * void 2015年8月22日
	 */
	public void reverseList() {
		LinkNode pointer = head.next;
		LinkNode forward;
		head.next = null;
		while (pointer != null) {
			forward = pointer.next;
			pointer.next = head.next;
			head.next = pointer;
			pointer = forward;
		}
	}

	/**
	 * sort the linklist
	 * 
	 * void 2015年8月22日
	 */
	public void sort() {
		LinkNode pointer = head.next, forward;
		head.next = null;
		while (pointer != null) {
			LinkNode p = head.next, pre = head;
			while (p != null) {
				if (p.value > pointer.value) {
					break;
				}
				pre = p;
				p = p.next;
			}
			forward = pointer.next;
			pointer.next = pre.next;
			pre.next = pointer;
			pointer = forward;
		}
	}

	/**
	 * increment the head counter
	 * 
	 * void
	 * 
	 * 2015年8月22日
	 */
	private void incr() {
		head.value += 1;
	}

	/**
	 * display content of the linklist
	 * 
	 * void
	 * 
	 * 2015年8月22日
	 */
	public void displayLink() {
		LinkNode pointer = head;
		System.out.println("Number of nodes:" + head.value);
		String console = "";
		while (pointer.next != null) {

			pointer = pointer.next;
			console += String.valueOf(pointer.value) + " ";
		}
		System.out.println(console);
	}
}
