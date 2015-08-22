package DataStructure.CS.Algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import DataStructure.CS.Infra.TreeNode;

/**
 * Tree operations
 * 
 * @author mingchen
 * @date 2015年8月22日
 */
public class TreeOperation {
	public TreeNode root;

	/**
	 * 
	 * Constructor function of Class
	 */
	public TreeOperation() {
		root = null;
	}

	/**
	 * insert a value into the tree
	 * 
	 * @param value
	 *            void
	 * 
	 *            2015年8月22日
	 */
	public void insert(int value) {

		if (root == null) {
			root = new TreeNode(value);
			root.left = null;
			root.right = null;
		} else {
			TreeNode node = search(value);
			if(node!=null){
				TreeNode tn = new TreeNode(value);
				if (value > node.value) {
					node.right = tn;
				} else {
					node.left = tn;
				}
			}
		}
	}

	/**
	 * Search a value in a tree if in return null else return its father node
	 * 
	 * @param value
	 * @return TreeNode
	 * 
	 *         2015年8月22日
	 */
	public TreeNode search(int value) {
		TreeNode head = root, pre = root;
		while (head != null && head.value != value) {
			pre = head;
			if (head.value < value) {
				head = head.right;
			} else {
				head = head.left;
			}
		}
		if (head == null) {
			return pre;
		}
		return null;
	}

	/**
	 * recursive preorder
	 * 
	 * @param root
	 *            void
	 * 
	 *            2015年8月22日
	 */
	public void preOrder(TreeNode root) {
		if(root != null){
			System.out.println(root.value);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	/**
	 * recursive in order
	 * 
	 * @param root
	 *            void
	 * 
	 *            2015年8月22日
	 */
	public void inOrder(TreeNode root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.value);
			inOrder(root.right);
		}
	}

	/**
	 * recursive post order
	 * 
	 * @param root
	 *            void
	 * 
	 *            2015年8月22日
	 */
	public void postOrder(TreeNode root) {
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.println(root.value);
		}
	}

	/**
	 * level order traverse
	 * 
	 * @param root
	 *            void
	 * 
	 *            2015年8月22日
	 */
	public void levelOrder(TreeNode root) {
		List<TreeNode> list = new LinkedList<TreeNode>();
		list.add(root);
		StringBuffer str = new StringBuffer();
		while (!list.isEmpty()) {
			TreeNode node = list.remove(0);
			str.append(node.value);
			str.append(" ");
			if (node.left != null) {
				list.add(node.left);
			}
			if (node.right != null) {
				list.add(node.right);
			}
		}
		System.out.println(str);
	}

	/**
	 * Tree height
	 * 
	 * @param root
	 * @return int
	 * 
	 *         2015年8月22日
	 */
	public int treeHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;

	}

	/**
	 * Tree breadth
	 * 
	 * @param root
	 * @return int
	 * 
	 *         2015年8月22日
	 */
	public int treeBreadth(TreeNode root) {
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		int breadth = 0;
		while (!queue.isEmpty()) {
			LinkedList<TreeNode> list = new LinkedList<TreeNode>();
			for (TreeNode tn : queue) {
				if (tn.left != null) {
					list.add(tn.left);
				}
				if (tn.right != null) {
					list.add(tn.right);
				}
			}
			if (breadth < list.size()) {
				breadth = list.size();
			}
			queue.clear();
			queue.addAll(list);
			list.clear();
		}
		return breadth;
	}

	/**
	 * no-recursive pre order traverse
	 * 
	 * void
	 * 
	 * 2015年8月22日
	 */
	public void preOrderTraverse() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		StringBuffer str = new StringBuffer();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				str.append(root.value);
				str.append(" ");
				stack.add(root);
				root = root.left;
			}
			root = stack.pop();
			root = root.right;
		}
		System.out.println(str);
	}

	/**
	 * no-recursive in order traverse
	 * 
	 * void
	 * 
	 * 2015年8月22日
	 */
	public void inOrderTraverse() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		StringBuffer str = new StringBuffer();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			str.append(root.value);
			str.append(" ");
			root = root.right;
		}
		System.out.println(str);
	}

	/**
	 * no-recursive post order traverse
	 * 
	 * void
	 * 
	 * 2015年8月22日
	 */
	public void postOrderTraverse() {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<Boolean> index = new Stack<Boolean>();
		StringBuffer str = new StringBuffer();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				index.push(false);
				root = root.left;
			}
			if (!index.peek().booleanValue()) {
				root = stack.peek();
				index.pop();
				index.push(true);
				root = root.right;
			} else {
				root = stack.pop();
				str.append(root.value);
				str.append(" ");
				index.pop();
				root = null;
			}
		}
		System.out.println(str);
	}
}
