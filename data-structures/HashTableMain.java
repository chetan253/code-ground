
/*Created by Chetan on Oct 29th, 2017*/

class LinkedListNode{
	String key;
	int value;
	LinkedListNode next;
	
	public LinkedListNode(String key, int value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
class HashTable{
	int TABLE_SIZE = 0;
	int size = 0;
	LinkedListNode table[];
	
	public HashTable(int TABLE_SIZE){
		this.TABLE_SIZE =TABLE_SIZE;
		table = new LinkedListNode[TABLE_SIZE];
		for(int i = 0 ; i < TABLE_SIZE; i++){
			table[i] = null;
		}
	}
	public int getHashValue(String key){
		int x = key.hashCode();
		int hashVal = x % TABLE_SIZE;
		if(hashVal < 0){
			hashVal += TABLE_SIZE;
		}
		return hashVal;
	}
	//inserting value in hashtable
	public void insert(String key, int value){
		int hashVal = getHashValue(key);
		if(table[hashVal] == null){
			table[hashVal] = new LinkedListNode(key, value);
		}
		else{
			LinkedListNode entry = table[hashVal];
			while(entry.next != null && !entry.key.equals(key)){
				entry = entry.next; 
			}
			if(entry.key.equals(key)){
				entry.value = value;
			}
			else{
				entry.next = new LinkedListNode(key, value);
			}
		}
		size++;
	}
	//get the value of given key
	public int get(String key){
		int hashVal = getHashValue(key);
		LinkedListNode entry = table[hashVal];
		while(entry != null){
			if(entry.key.equals(key)){
				return entry.value; //the next element in entry to be deketed will be the first element in tha bucket
			}
			else{
				entry = entry.next;
			}
		}
		return 0;
	}
	
	
	
	public void remove(String key){
		int hashVal = getHashValue(key);
		if(table[hashVal] != null){
			LinkedListNode entry = table[hashVal];
			LinkedListNode prevEntry = null;
			while(entry.next != null && !entry.key.equals(key)){
				prevEntry = entry;
				entry = entry.next;
			}
			if(entry.key.equals(key)){
				if(prevEntry == null){
					table[hashVal] = entry.next;
				}
				else{
					prevEntry.next = entry.next;
				}
				size--;
			}
		}
	}
	
	//get size of table
	public int getSize(){
		return size;
	}
	//print all items in table
	public void printAllItems(){
		for(int i = 0; i < TABLE_SIZE; i++){
			System.out.println("Bucket " + i);
			LinkedListNode entry = table[i];
			while(entry != null){
				System.out.println("Key : "+ entry.key + " Val: " + entry.value+ " hashcode: "+getHashValue(entry.key));
				
				entry = entry.next;
			}
		}
	}
}
public class HashTableMain{
	public static void main(String[] args){
		HashTable table = new HashTable(5);
		table.insert("pineapple", 50);
		table.insert("apple", 10);
		table.insert("mango", 20);
		table.insert("water", 120);
		table.printAllItems();
		int val1 = table.get("apple");
		table.remove("apple");
		table.printAllItems();
		System.out.println(val1);
	}
}
