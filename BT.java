package BinaryTree1;
import java.util.*;
import java.util.Scanner;

public  class BT<T> {
  
	T data;
	BT<T> left;
	BT<T> right;
	
	BT(T data){
	this.data=data;	
	}
	
	 public static  BT <Integer> takeInput(Scanner s){		
	 int rootData;
	 System.out.println("Enter root data");
	 rootData=s.nextInt();
				
	 if(rootData==-1){
	 return null;
	 }		
	 BT<Integer> root=new BT<>(rootData);
	 root.left=takeInput(s);
			root.right=takeInput(s);
			return root;			
			} 
	
	 	 
	 public static void print(BT<Integer> root) {
	 
	 if(root==null){
	   return;
	 }
	 String tobePrinted=root.data+ "";
	 
	 if(root.left!=null){
		 tobePrinted+="L:"+ root.left.data+ ",";
	 }
	 if(root.right!=null){
		 tobePrinted+="R:"+ root.right.data;
	 }
	 System.out.println(tobePrinted);
	 print(root.left);
	 print(root.right);
	 	 
	 }
	 
	 
	public static BT<Integer> takeInputLevelWise() {		 
	

			Scanner s = new Scanner(System.in);
			QueueUsingLL<BT<Integer>> pendingNodes = new QueueUsingLL<>();
			System.out.println("Enter root data");
			int rootData = s.nextInt();
			if (rootData == -1) {
				return null;
			}
			BT<Integer> root = new BT<Integer>(rootData);
			pendingNodes.enqueue(root);
			
			while (!pendingNodes.isEmpty()) {
				BT<Integer> front;
				try {
					front = pendingNodes.dequeue();
				} catch (QueueEmptyException e) {
					return null;
				}
				System.out.println("Enter left child of " + front.data);
				int leftChild = s.nextInt();
				if (leftChild != -1) {
					BT<Integer> child = new BT<Integer>(leftChild);
					pendingNodes.enqueue(child);
					front.left = child;
				}
				
				System.out.println("Enter right child of " + front.data);
				int rightChild = s.nextInt();
				if (rightChild != -1) {
					BT<Integer> child = new BT<Integer>(rightChild);
					pendingNodes.enqueue(child);
					front.right = child;
				}
			}
			return root;
		}		
	 
	public static void  printLevelwise(BT<Integer> root){
	  
	 if(root == null){
		 return;
	 }
	 Queue<BT<Integer>> pendingNode=new LinkedList<>();
	 pendingNode.add(root);    
	 while(!pendingNode.isEmpty()){
		    BT<Integer> front= pendingNode.poll();

			if(front!=null){
				System.out.print(front.data+":");
		    if(front.left==null){
				System.out.print("L:-1");
			}
			else{
				System.out.print("L:"+front.left.data);
			}
			 if(front.right==null){
				System.out.print(",R:-1");
			}
			else{
				System.out.print(",R:"+front.right.data);
			}
			System.out.println();
		    pendingNode.add(front.left);
			pendingNode.add(front.right);
			}

			}
	 }
	 
	public static int count(BT<Integer> root){
	if(root==null){
		return 0;
	}
//	int ans=1;
//	ans+=count(root.left);
//	ans+=count(root.right);		 
//	return ans;	 
	return 1+count(root.left)+count(root.right);
	}
	
	public static int height(BT<Integer> root) {
		
	if(root==null){
		return 0;
	}
	int left=height(root.left);
	int right=height(root.right);
	return 1+ Math.max(left, right);
		
	}
	
     public static boolean isNodePresent(BT<Integer> root,int x) {
		if (root == null) {
			return false;
		}
	   	if (root.data == x) {
			return true;
		} else {
			return (isNodePresent(root.left, x) || isNodePresent(root.right, x));
		}
	}

	public static int Largest(BT<Integer>root) {
		
	if(root==null){
		return 0;
	}
	int leftlargest=Largest(root.left);
	int rightlargest=Largest(root.right);
	return Math.max(root.data,Math.max(leftlargest, rightlargest));
	}	
	
	public static int Smallest(BT<Integer>root) {
		
		if(root==null){
			return Integer.MAX_VALUE;
		}
		int leftsmallest=Smallest(root.left);
		int rightsmallest=Smallest(root.right);
		return Math.min(root.data,Math.min(leftsmallest,rightsmallest));
		}
	
	public static int numLeaves(BT<Integer> root){
	        if(root==null){
	            return 0;
	        }
	        if(root.left==null &&root.right==null){
	            return 1;
	        }
	        return numLeaves(root.left)+numLeaves(root.right);
	      }	
		
	public static void printatDepth(BT<Integer>root,int k) {	
		
	if(root==null){
		return ;
	}
	
	if(k==0){
	System.out.println(root.data+ "");
	return;
	}
	printatDepth(root.left,k-1);
	printatDepth(root.right,k-1);
	return;		
	}
	
	public static void printNodesWithoutSibling(BT<Integer> root) {
	
		if (root==null)
        {
            return; 
        }
        
        if (root.left==null && root.right==null)
        {
            return;
        }
        
        if (root.left==null)
        {
            System.out.print(root.right.data+" ");
            printNodesWithoutSibling(root.right);
        }
        else if (root.right==null)
        {
            System.out.print(root.left.data+" ");
            printNodesWithoutSibling(root.left);
            
        }
        else
        {
            printNodesWithoutSibling(root.left);
            printNodesWithoutSibling(root.right);
        }
	}
	
	public static void  nodeAtDepth(BT<Integer> root,int pos){
	    
		if(root==null){
			return ;
		}
		root.data=pos;
	    nodeAtDepth(root.left,pos+1);
	    nodeAtDepth(root.right,pos+1);
		}	  
	
    public static BT<Integer> removeleafs(BT<Integer> root) {
	
	if(root==null){
	return null;
	}
	
	if(root.left==null && root.right==null){
	return null;	
	}
	
	root.left=removeleafs(root.left);
	root.right=removeleafs(root.right);		
			
	return root;	
	}

    public static boolean isbalanced(BT<Integer> root) {
       	
    	if(root==null) {
            return true;
          }
        int leftHeight=height(root.left);
        int rightHeight=height(root.right);
        
        if(Math.abs(leftHeight-rightHeight)>1){
            return false;
            }
        
        boolean isLeftBalanced = isbalanced(root.left);
        boolean isRightBalanced = isbalanced(root.right);
        return isLeftBalanced && isRightBalanced ;
        }   	
    
    public static int heightbalanced(BT<Integer> root) {
    
    if(root==null){
    	return 0;
    }
    
    int leftheight=heightbalanced(root.left);
    if(leftheight==-1)return -1;
    int rightheight=heightbalanced(root.right);
    if(rightheight==-1)return -1;
    
    if(Math.abs(leftheight-rightheight)>1){
    	return -1;
    	
    }
    return Math.max(leftheight, rightheight)+1;
    
    }
   
    public static boolean isbalancedbetter(BT<Integer> root) {
    	
    return heightbalanced(root)!=-1;	
    	
    	
    	
   	
    }

    public static int diameterOfBinaryTree(BT<Integer> root){
	   	int dia[]=new int [1];
		 heightq(root,dia);
		 return dia[0];
	}

	public static int heightq(BT<Integer> root,int[] dia){
     
	 if(root==null){
		 return 0;
	 }

    int lh=heightq(root.left, dia);
	int rh=heightq(root.right, dia);
	dia[0]=Math.max(dia[0],lh+rh);
	return 1+ Math.max(lh, rh);

	 }

	public static int dia(BT<Integer> root) {
		
	if(root==null){
	return 0; 
	}		
	int opt1=height(root.left)+height(root.right);
	int op2=dia(root.left);
	int op3=dia(root.right);		
	return Math.max(opt1,Math.max(op2,op3));	
    	
	}
   
	public static BT<Integer> buildTree(int[] pre, int[] in) {
		

	return buildTreeHelper(pre,0,pre.length-1,in,0,in.length-1);
	}
    
	public static BT<Integer> buildTreeHelper(int pre[],int preS,int preE,int in[],int inS,int inE){
    
    if(inS>inE){
		return null;
	}
    
	int rootData=pre[preS];
	BT<Integer> root=new BT<Integer>(rootData);
   	int rootIndex=-1;
	for(int i=inS;i<=inE;i++){
		 if(in[i]==rootData){
            rootIndex=i;
			break;
		 }
	}
    if(rootIndex==-1){
       return null;
	}
  int leftInS=inS;
  int leftInE=rootIndex-1;
  int leftpreS=preS+1;
  int leftpreE=leftInE-leftInS+leftpreS;
  int rightInS=rootIndex+1;
  int rightInE=inE;
  int rightpreS=leftpreE+1;
  int rightpreE=preE;
 root.left=buildTreeHelper(pre,leftpreS,leftpreE,in,leftInS,leftInE);
 root.right=buildTreeHelper(pre,rightpreS,rightpreE,in,rightInS,rightInE);
 return root;

	}
	

	public static void insertDuplicateNode(BT<Integer> root) {
     
    if(root==null){return ;}

    insertDuplicateNode(root.left);
	insertDuplicateNode(root.right); 
	
    BT<Integer> newNode = new BT<>(root.data);
	BT<Integer> temp = root.left;
	root.left=newNode;
	newNode.left=temp;

	
		
	}
	
	public static pair<Integer,Integer> getMinAndMax(BT<Integer> root){
	
		if(root==null){
			 pair<Integer,Integer> ans=new pair<Integer,Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);
			 return ans;  
		 }
	     
	    pair<Integer,Integer> leftpair=getMinAndMax(root.left);
		pair<Integer,Integer> rightpair=getMinAndMax(root.right);

		int min=Math.min(root.data,Math.min(leftpair.min,rightpair.min));
		int max=Math.max(root.data,Math.max(leftpair.max,rightpair.max));

		pair<Integer,Integer> ans=new pair<Integer,Integer>(min,max);
		return ans; 

		}
	
	public static void printrootToleaf(BT<Integer>root,String s,int k) {
	if(root==null) {return;}	
	
	int rootData=root.data;
	s+=rootData+ " ";
	if(root.data==k && root.left==null && root.right==null){
		System.out.println(s);
	}
		
	printrootToleaf(root.left,s,k-rootData);	
	printrootToleaf(root.right,s,k-rootData);		
	}
		
	public static boolean nodeToroot(BT<Integer>root,ArrayList<Integer> a,int k) {
	
	if(root==null){return false;}	
	
	
	if(root.data==k){
	a.add(root.data); 
	return true;
	}
	
	if(nodeToroot(root.left,a,k)||nodeToroot(root.right,a,k)){
	   a.add(root.data);
	   return true;
	}
	return false;	
	}
	
	
	public static boolean rootTonode(BT<Integer>root,ArrayList<Integer> a,int k) {

		if(root==null){return false;}	
		
		a.add(root.data);
		if(root.data==k){		 
		return true;
		}
		
		if(rootTonode(root.left,a,k)||rootTonode(root.right,a,k)){
		   return true;
		}
		
	a.remove(a.size()-1);
	return false;	
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//    BNT <Integer> root=new BTN <>(3);
//    BNT<Integer> node1=new BNT<>(1);
//    root.left=node1;   
//    BTN<Integer> node2=new BTN<>(2);
//    root.right=node2;
	
//   Scanner s=new Scanner(System.in);		
//   BT<Integer> root=takeInput(s);

	  //Takeinput iterative	 
    BT<Integer> root=takeInputLevelWise();
//	  print(root);
	
//count number of nodes  
//     int ans=count(root);
//	System.out.println("Total number of nodes are:" + ans);
	
//find node	 
//  int x=4; 
//  boolean ans=isNodePresent(root,x);  
//  System.out.println(ans);	 

//Largest number data 
//    int a=Largest(root);
//    System.out.println(a);	 

//number of leafs
//  int leafs=numLeaves(root);
//  System.out.print(leafs);
 
//print depth at root  
//  printatDepth(root,2);
//  print(root);
  
//print Nodes without sibling
//  printNodesWithoutSibling(root);
//  print(root);
 
//remove leafs
// BT<Integer> ans=removeleafs(root);
// printLevelwise(ans); 

//check if tree is balanced  
//  int h=height(root);  
//  System.out.println("height of root is " + h );  
//    System.out.println("is balanced "+ isbalancedbetter(root));
 
// diameter of tree
//   int dia= diameterOfBinaryTree(root);
//   System.out.println(dia);
    
//Insert duplicate Node
//    insertDuplicateNode(root);
//    printLevelwise(root);
 
//Smallest
//    int a=Smallest(root);
//    System.out.println(a);
    
//max and min together
//    pair<Integer,Integer>ans=getMinAndMax(root);
//    System.out.print(ans.min+ "," +ans.max);

 //root to leaf
//    printrootToleaf(root,"",13);
    
// nodeTOroot path
// ArrayList<Integer> ar=new ArrayList<>();
// boolean ans=rootTonode(root,ar,5);
// System.out.println(ans+""+ar);

//rootTonode
// ArrayList<Integer> ar=new ArrayList<>();
// boolean ans=rootTonode(root,ar,5);
// System.out.println(ans+""+ar);

	}
}

//