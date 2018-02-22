/*
	Author: Chetan Patil
	Data Structure: Trie
*/
import java.util.*;
public class Trie{
	class TrieNode{
		Character data;
		HashMap<Character, TrieNode> children = new HashMap<Character,TrieNode>();
		public TrieNode(Character data){
			this.data = data;
		}
	}
	TrieNode root = new TrieNode('\0');
	public void insert(String data){
		char[] arr = data.toCharArray();
		TrieNode node = root;
		for(Character c : arr){
			if(node.children.containsKey(c)){
				node = node.children.get(c);
				continue;
			}
			TrieNode newNode = new TrieNode(c);
			node.children.put(c, newNode);
			node = newNode;		
		}
		node.children.put('*', new TrieNode('*'));
	}
	
	public boolean check(String data){
		char[] arr = data.toCharArray();
		TrieNode node = root;
		for(Character c : arr){
			if(node.children.containsKey(c)){
				node = node.children.get(c);
				continue;
			}
			return false;
		}
		if(node.children.containsKey('*')){
			return true;
		}
		return false;
	}
}

