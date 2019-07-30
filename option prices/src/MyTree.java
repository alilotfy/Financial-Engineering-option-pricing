import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.naming.Context;
public class MyTree {

Node root;


	
	
public MyTree(int n,BigDecimal s,BigDecimal u,BigDecimal d) {
	
	if(n==0) {
		return;
	}
	int counter=1;
	Node x;
	Node y;
	Node[] arr1=new Node[1];
	Node[] arr2=new Node[2];
	while(counter<=n) {
		if(counter==1) {
			x=new Node(new BigDecimal(0));
			y=new Node(new BigDecimal(0));
			this.root=new Node(new BigDecimal(0));
			this.root.left=x;
			this.root.right=y;
			this.root.left.value=d.multiply(s);
			this.root.right.value=u.multiply(s);
			arr1=new Node[1];
			arr1[0]=this.root;
			arr2=new Node[2];
			arr2[0]=x;
			arr2[1]=y;
			counter++;
			continue;
		}
		arr1=arr2;
		arr2=new Node[counter+1];
		for(int i=0;i<arr2.length;i++) {
			arr2[i]=new Node(new BigDecimal(0));
		}
		// connecting the nodes using the follwing loop
		for(int i=0;i<arr1.length;i++) {
			if(arr2[i].visited) {
				continue;
			}
			arr1[i].left=arr2[i];
			arr1[i].right=arr2[i+1];
			arr2[i].value=arr1[i].value.multiply(d);
			arr2[i+1].value=arr1[i].value.multiply(u);
		}
		counter++;	
		
	}
	
	
}
public static void printer (Node[] arr) {
	for(int i=0;i<arr.length;i++) {
		System.out.println(arr[0].value+" ");
	}
	System.out.println();
}

	

	
	
	
	
	
	
	
	
}
