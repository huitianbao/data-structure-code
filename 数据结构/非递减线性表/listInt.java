
public interface listInt {
	void clear();

	boolean isEmpty();
	
	int getLength();
	
	Object get(int index);
	
	int locate(Object obj);
	
	void insert(int index, Object obj);

	Object remove(int index);

	void traverse();
	
	Object findMin();

}
