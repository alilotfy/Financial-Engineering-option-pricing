import java.math.BigDecimal;
import java.math.RoundingMode;
public class Options {
	
	public static int  counterr(Node root) {
		if(root==null) {
			return 0;
		}
		if(root.visited==false) {
			root.visited=true;
			System.out.println(root.value);
			return 1+counterr(root.left)+counterr(root.right);
		}
		else {
			return counterr(root.left)+counterr(root.right);
		}
		
	}
	
	public static BigDecimal getmax(BigDecimal x,BigDecimal y) {
		if(x.compareTo(y)==1) {
			return x;
		}
		return y;
	}
	
	
	
	
	public static void getvalue(Node root,BigDecimal p,BigDecimal k,BigDecimal r) {
	if(root.right==null && root.left==null && root.visited==false) {
		root.value=getmax(new BigDecimal(0),root.value.subtract(k));
		root.visited=true;
		return;
	}
	if(root.visited==false) {
		
	root.visited=true;
	getvalue(root.right, p, k, r);
	getvalue(root.left,p,k,r);
	root.value=((p.multiply(root.right.value)).add((new BigDecimal(1).subtract(p)).multiply(root.left.value))).divide(r,100,RoundingMode.HALF_UP);
	}
		
	}
	
	
	public static void  navigator(Node root,String s) {
		for(int i=0;i<s.length();i++) {
			if("u".equals(""+s.charAt(i))) {
				root=root.right;
			}
			else {
				root=root.left;
			}
		}
		System.out.println(root.value);
		
	}
	
	public static void main(String[] args) {
		int n=1000;
		BigDecimal r=new BigDecimal(1.25);
		BigDecimal s=new BigDecimal(50);
		BigDecimal u=new BigDecimal(2);
		BigDecimal d=new BigDecimal(0.5);
		BigDecimal p=(r.subtract(d)).divide(u.subtract(d));
		BigDecimal k=new BigDecimal(50);
		MyTree t=new MyTree(n,s,u,d);
		getvalue(t.root, p, k, r);
		//navigator(t.root, "dd");
		System.out.println(t.root.value);
		
		
	
	}

}
