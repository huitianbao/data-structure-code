
public class Linklist implements listInt{
	
	private Node head;

	public Linklist() {
		this.head = null;
	}

	@Override
	public void clear() {
		// 1 this.header=null;
		Node p = this.head;
		while (p != null) {
			this.head = p.next;
			p = p.next;
		}

	}

	@Override
	public boolean isEmpty() {

		return this.head == null;
	}

	@Override
	public int getLength() {

		Node p = this.head;
		int count = 0;

		while (p != null) {
			count++;
			p = p.next;
		}

		return count;
	}

	@Override
	public Object get(int index) {
		/*
		if(index<1||index>getLength()){
			throw new IllegalArgumentException("index 范围错误");
			
		}
		*/
		
		//加了之后就报错  to do ...............
		
		Node p = this.head;
		int count = 0;
		while (p!=null) {
			count++;
			if(count==index){
				return p.element;	
			}
			p = p.next;

		}
		return null;
		

	}

	@Override
	public void insert(int index, Object obj) {
		/*
		if(index<1||index>getLength()){
			throw new IllegalArgumentException("index 范围错误");
			
		}
		*/
		//加了之后就报错  to do ...............
		
		
		if (index == 1) {
			Node node = new Node();
			node.element = obj;
			node.next = this.head;
			this.head = node;

		} else {

			Node node = new Node();           
			Node p = this.head;

			// 移动指针
			int count = 0;
			while (p != null) {
				count++;
				if (count == index - 1)
					break;

				p = p.next;
			}

			node.next = p.next;
			p.next = node;

			node.element = obj;
		}
	}

	@Override
	public Object remove(int index) {
		
		/*
		if(index<1||index>getLength()){
			throw new IllegalArgumentException("index 范围错误");
			
		}
		*/
		//加了之后就报错  to do ...............
		
		

		Node p = this.head;

		if (index < 1 || index > getLength()) {
			throw new IllegalArgumentException("参数错误");
		}

		if (index == 1) {
			Node temp = this.head;
			this.head = temp.next;
		}

		else {
			// 移动指针
			int count = 0;

			while (p != null) {
				count++;
				if (count == index - 1)
					break;
				p = p.next;
			}

			// delete element
			Node temp = p.next;
			p.next = temp.next;
			temp.next = null;

		}
		return null;
	}

	@Override
	public void traverse() {
		Node p = this.head;
		while (p != null) {
			System.out.print(p.element.toString() + " ");
			p=p.next;

		}

	}

	@Override
	public Object findMin() {
		
		Node p=this.head;
		Object min=p.element;
		while(p!=null){
			if((int)(p.element)<(int)(min)){
				min=p.element;
			}
			
		}
		
		return min;
	}

	@Override
	public int locate(Object obj) {
		Node p=this.head ;
		int count =0;
		while(p!=null)
		{
			count++;
			if(obj.equals(p.element ))
				return count;
		}
		return -1;
	}
	

}
