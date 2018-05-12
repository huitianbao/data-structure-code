package sort;

public class SortTree {


	
	
	private Node root;
	
	public SortTree(){
		this.root=null;
		
	}
	
	
	public Student searchNorecurse(int key)//di gui
	{
		Node p=this.root;
		while(p!=null){
			Student tmp=p.element;
			if(tmp.stu_id==key){
				return tmp;
			}
			
			else if(tmp.stu_id>key){
				p=p.left;
			}
			else{
				p=p.right;
			}
		}
		return null;
	}
	
	
	public Student serachRecurse(int key){
		return do_searchRecurse(root,key);
		
	}
	
	
	private Student do_searchRecurse(Node node,int key){
		if(node==null){
			return null;//                   I think should throw exception
		}
		
		Student tmp=node.element;
		
		if(tmp.stu_id==key){
			return tmp;
		}
		
		else if(tmp.stu_id>key){
			do_searchRecurse(node.left,key);
			}
		
		else{
			do_searchRecurse(node.right,key);
		}
		return tmp;////////////////////////
		
	}
	
	
	public Node searchNorecurseForNode(int key)//di gui
	{
		Node p=this.root;
		while(p!=null){
			Node tmp=p;
			if(tmp.element.stu_id==key){
				return tmp;
			}
			
			else if(tmp.element.stu_id>key){
				p=p.left;
			}
			else{
				p=p.right;
			}
		}
	
		return null;
	}
	
	
    private boolean isleaf(Node node) {
		
		return node.left==null&&node.right==null;
	}
	public Student removeNorecurse(int key){
		Node node=searchNorecurseForNode(key);
		if(node==null){
			return null;
		}
		
		if(!isleaf(node)){
			return null;
			
		}
		
		Node parent=node.parent;
		if(parent.left==node){
			parent.left=null;
		}
		
		else{
			parent.right=null;
		}
		
		
		return node.element;
	}

	public Student removeRecurse(int key){
		Student result=serachRecurse(key);
//Ӧ�����ж�  result�Ƿ���Ҷ�ڵ�
		if(result!=null){
			this.root=do_removeRecurse(this.root,key);
		}
		
		return result;
		
	}
	
	private Node do_removeRecurse(Node node,int key){//  дNode����ֵ����Ϊ�˷��ر�ɾ����Ԫ��
                                                             дNode��Ϊ��ɾ�� ������һ����¼ Node�ڵ������  name  id
		if(node==null){
			return null;
		}
		
		int tmp_key=node.element.stu_id;
		
		if(tmp_key==key){
			if(!isleaf(node)){//����Ҷ�ڵ㣬��ɾ
				return node;
			}
			
			else{            //��Ҷ�ڵ�
				return null;//�� node��Ϊ�գ���ɾ��
			}
			
		}
		
		else if(tmp_key>key){
			node.left=do_removeRecurse(node.left,key);//����   node.left=
			return node;
			}
		
		else{
			node.right=do_removeRecurse(node.right,key);
			return node;
		
		}
		
		
	}

	
	private Node do_insertRecurse(Node node,Student stu){
		if(node==null){
			return null;////-------------------?????????????????????????????




		}
		Student tmp=node.element;
		if(tmp.stu_id==stu.stu_id){
			
		}
		else if(tmp.stu_id>stu.stu_id){
			node.left=do_insertRecurse(node.left,stu);
		}
		else{
			node.right=do_insertRecurse(node.right,stu);
		}
		
		return node;
	}
	
	
	public void insertRecurse(Student stu){
		this.root=do_inserRecurse(this.root,stu);
	}
}


