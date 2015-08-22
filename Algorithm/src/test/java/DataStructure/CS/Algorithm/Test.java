package DataStructure.CS.Algorithm;

public class Test {
	public static void main(String[] args) {
		int[] arr = { 2, 9, 3, 7, 5, 10, 1, 2 };
		TreeOperation to = new TreeOperation();
		for (int key : arr) {
			to.insert(key);
		}
		to.postOrder(to.root);
		System.out.println("------------------------------------");
		to.postOrderTraverse();
	}

}
