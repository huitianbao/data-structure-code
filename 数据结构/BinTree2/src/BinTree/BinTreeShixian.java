package BinTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinTreeShixian {

	public TreeNode root;
	
	
	//构造
	public BinTreeShixian(){
		this.root=null;
	}
	
	
	//获取节点内容
	private void access(TreeNode node){
		System.out.print(node.data);

		 //* 前序
		// * 后序
		 //* 中序肯定不一样
		 
		
		int depth1=do_depth(node.left)+do_depth(node.right)+1;
		for(int i=1;i<=depth1;i++){
			System.out.print("---");
		}
		
		
	}
	
	
	
	public int depth(){
		return do_depth(this.root);
	}
	
	
	public  int do_depth(TreeNode node){
		if(node==null){
			return 0;
		}
		int dl=do_depth(node.left);
		int dr=do_depth(node.right);
		return Math.max(dl, dr)+1;
		
	}
	
		
		
		
	
		
	

	
	
	//前序
	public void do_PerorderTraverse(TreeNode node){
		if(node!=null){
			access(node);
			do_PerorderTraverse(node.left);
			do_PerorderTraverse(node.right);
			
	}
	
}
	
	//中序
	public void do_InorderTraverse(TreeNode node){
		if(node!=null){
		do_InorderTraverse(node.left);
		access(node);
		do_InorderTraverse(node.right);
		}
		
	}
	
	
	//后序
	public void do_postOrderTraverse(TreeNode node){
		if(node!=null){
		do_postOrderTraverse(node.left);
		do_postOrderTraverse(node.right);
		access(node);
		}
		
	}
	
	
	//层次
	public void levelOrderTraverse(){

		Queue q=new LinkedList();
		q.add(this.root);
		
		while(!q.isEmpty()){
			TreeNode node=(TreeNode)q.remove();
			access(node);
			if(node.left!=null){
				q.add(node.left);
				
			}
			if(node.right!=null){
				q.add(node.right);
				
			}
		}
		
	}
	
	//---------------------------------------------------
	public boolean isEmpty(){
		return this.root==null;
	}
	
	public TreeNode root(){
		return this.root;
	}
	
	
	public void insertRoot(Object data){
		if(isEmpty()){//只有树为空时才能插入
			this.root=new TreeNode(data);
			
			
		}
	}
	
	public TreeNode insertLeft(TreeNode node,Object data){
		if(node.left!=null){
			throw new IllegalStateException("已经有左孩子");
			
		}
		
		else{
			TreeNode tmp=new TreeNode(data);
			node.left=tmp;
			tmp.parent=node;
			return tmp;
			
		}
	}
	
	public TreeNode insertRight(TreeNode node,Object data){
		if(node.right!=null){
			throw new IllegalStateException("已经有右孩子");
			
		}
		else{
			TreeNode tmp=new TreeNode(data);
			node.right=tmp;
			tmp.parent=node;
			return tmp;
		}
	}
	
	public TreeNode find(Object data){
		return do_find(this.root,data);
	}
	
	private TreeNode do_find(TreeNode node,Object data){
		if(node==null){
			return null;
			
		}
		
		if(node.data.equals(data)){
			return node;
			
		}else{
			TreeNode result=do_find(node.left,data);
			if(result!=null){
				return result;
			}else{
				return do_find(node.right,data);
				
				//----------------------------------to do   to add something
			}
		}
	
	}

	
	public void clear(){
		//this.root=null;
		
		do_clear(this.root);
	}
	
	public void do_clear(TreeNode node){
		if(node==null){
			return;
		}
		else{
			do_clear(node.left);
			do_clear(node.right);
			node.left=null;
			node.right=null;
			
		}
	}

	
	public TreeNode parent(TreeNode node){
		return node.parent;
		
	}
	
	
	public TreeNode leftSibling(TreeNode node){
		TreeNode parent=node.parent;
		
		if(parent==null){
			return null;
			
		}
		
		/*
		if(parent.left==node){
			return null;
		}	
		
		if(parent.left!=node){
			return parent.left;
		}
		
		*/
		
		return parent.left==node?null:parent.left;

		
		
	}
	
	
	public TreeNode rightSibling(TreeNode node){
		TreeNode parent=node.parent;
		
		if(parent==null){
			return null;
			
		}
		
		/*
		if(parent.right==node){
			return null;
		}	
		
		if(parent.right!=node){
			return parent.right;
		}
		
		*/
		else{
		return parent.right==node?null:parent.right;
		}

	}
	
	
	
	
	
	
	
	
	
	
}
