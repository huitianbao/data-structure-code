package sort;



public class Main {
	public static void main(String[] args){
		SortTree sorttree=new SortTree();
		
		
		Student s1=new Student(123, "张三");
		Student s2=new Student(124,"李四");
		Student s3=new Student(125,"王二");
		
		sorttree.insertRecurse(s1);
		sorttree.insertRecurse(s2);
		sorttree.insertRecurse(s3);
		
		Student s4=sorttree.serachRecurse(123);
		System.out.println("Student s4=sorttree.serachRecurse(123) s4 name:"+s4.name);
		
		
	}

}
