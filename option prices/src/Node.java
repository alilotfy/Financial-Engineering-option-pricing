import java.math.BigDecimal;
public class Node {

	BigDecimal value;
	Node right;
	Node left;
	boolean visited=false;
	public Node(BigDecimal value) {
		this.value=value;
		this.right=null;
		this.left=null;
	}
	
	public void creator(int number) {
		if(number==1) {
			return;
		}
		number--;
		//this.left=new Node(0);
		//this.right=new Node(0);
		this.left.creator(number);
		this.right.creator(number);
	}
	
	
}
