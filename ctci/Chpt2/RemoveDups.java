/*
	CTCI Problem 2.1 Remove Duplicates
*/
import java.io.*;
import java.util.*;
class RemoveDups extends LinkedList{
	static void removeDupsWithBuffer(LinkedList list){
		Node head = list.head;
		HashSet<Integer> set = new HashSet<Integer>();
		Node currNode = head;
		Node prevNode = null;
		while(currNode != null){
			if(set.contains(currNode.data)){
				prevNode.next = currNode.next;
				currNode = currNode.next;
				continue;
			}
			else{
				set.add(currNode.data);
			}
			prevNode = currNode;
			currNode = currNode.next;
		}
	}
	
	static void removeDupsWoBuffer(LinkedList list){
		Node head = list.head;
		Node currNode1 = head;
		Node currNode2 = null;
		Node prevNode = null;
		while(currNode1 != null){
			currNode2 = currNode1.next;
			while(currNode2 != null){
				if(currNode2.data == currNode1.data && currNode1.next == currNode2){
					currNode1.next = currNode2.next;
					currNode2 = currNode2.next;
					prevNode = currNode1;
					continue;
				}
				else if(currNode2.data == currNode1.data && currNode1.next != currNode2){
					prevNode.next = currNode2.next;
					currNode2 = currNode2.next;
					continue;
				}
				prevNode = currNode2;
				currNode2 = currNode2.next;
			}
			currNode1 = currNode1.next;
		}
	}
	
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.insert(0);
		list.insert(0);
		list.insert(1);
		list.insert(1);
		list.insert(1);
		list.insert(5);
		list.insert(1);
		list.insert(1);
		list.insert(2);
		list.insert(2);
		list.insert(3);
		list.insert(2);
		list.insert(5);
		list.insert(5);
		list.printList();
		//removing duplicates
		System.out.println("Removing Dups with buffer");
		removeDupsWithBuffer(list);
		list.printList();
		System.out.println("Removing Dups without buffer");
		removeDupsWoBuffer(list);
		list.printList();
	}
}
