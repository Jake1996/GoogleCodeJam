import java.util.ArrayList;
import java.util.Scanner;
/**
 * https://code.google.com/codejam/contest/635101/dashboard#s=p0
 * @author jatin
 *
 */
public class FileFixIt {
	public static Tree<String> tree;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		int temp = tc;
		while(tc--!=0) {
			int n,m;
			n = in.nextInt();
			m = in.nextInt();
			String existing[] = new String[n];
			String toBe[] = new String[m];
			in.nextLine();
			for(int i =0;i<n;i++) existing[i] = in.nextLine();
			for(int i =0;i<m;i++) toBe[i] = in.nextLine();
			tree = new Tree<String>();
			tree.add("/");
			for(int i=0;i<n;i++) {
				String path[] = existing[i].split("/");
				build(path);
			}
			int count=0;
			for(int i=0;i<m;i++) {
				String path[] = toBe[i].split("/");
				count+=build(path);
			}
			System.out.println("Case #"+(temp-tc)+": "+count);
		}
		in.close();
	}
	public static int build(String path[]) {
		int count = 0;
		int i=1;
		TreeNode<String> ref ;
		ref  = tree.getRoot();
		while(i<path.length) {
			count+=ref.insertChild(path[i])==true?1:0;
			ref = ref.getChild(path[i]);
			i++;
		}
		return count;
	}
}
class Tree<T> {
	private TreeNode<T> root;
	public Tree() {
		
	}
	public boolean add(T data) {
		if(root==null) {
			root = new TreeNode<T>();
			root.setData(data);
			return true;
		}
		else {
			return root.insertChild(data);
		}
	}
	public TreeNode<T> getRoot() {
		return root;
	}
}

class TreeNode<T> {
	private ArrayList<TreeNode<T>> children;
	private T data;
	public TreeNode() {
		children = new ArrayList<>();
	}
	public ArrayList<TreeNode<T>> getChildren() {
		return children;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public boolean contains(T val) {
		for(int i =0;i<children.size();i++) {
			if(children.get(i).data.equals(val))
				return true;
		}
		return false;
	}
	public TreeNode<T> getChild(T val) {
		for(int i =0;i<children.size();i++) {
			if(children.get(i).data.equals(val))
				return children.get(i);
		}
		return null;
	}
	public boolean insertChild(T val) {
		if(!this.contains(val)) {
			TreeNode<T> t = new TreeNode<T>();
			t.data = val;
			children.add(t);
			return true;
		}
		return false;
	}
}
