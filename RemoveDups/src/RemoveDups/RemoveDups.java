package RemoveDups;

import java.util.*;

public class RemoveDups {
	public static void main(String args[]){
		int option;
		List l=new List();
		while(true){
			System.out.println("Enter your choice");
			System.out.println("1. Insert Begin"+"\n"+"2. RemoveDups");
			System.out.println("Enter 0 to exit");
			Scanner sc=new Scanner(System.in);
			option=sc.nextInt();
			switch(option){
			case 1: l.insertBegin();
			l.print();
			break;
			case 2: l.removeDupsUnsorted();
			break;
			case 0:System.exit(0);
			}
		}
		}

}
class List{
	private class Node{
		int data;
		Node next;
	}
	Node head=null;
	public void print(){
		Node n=new Node();
		n=head;
		while(n!=null){
			System.out.print(n.data+"->");
			n=n.next;
		}
	}
	
	public void insertBegin(){
		Node node=new Node();
		if(head==null){
			head=node;
			Scanner sc=new Scanner(System.in);
			head.data=sc.nextInt();
			head.next=null;
		}
		else{
			node.next=head;
			Scanner sc=new Scanner(System.in);
			node.data=sc.nextInt();
			head=node;
		}
	}
	public void removeDups(){
		Node node=head;
		Node next;
		while(node.next!=null){
			if(node.data==node.next.data){
				next=node.next.next;
				node.data=0;
				node.next=null;
				node=next;
			}
			else{
				node=node.next;
			}
		}
	}
	public void removeDupsUnsorted(){
		HashMap h=new HashMap();
		Node node=head.next;
		h.put(head.data, true);
		while(node.next!=null){
			if(h.containsKey(node.data)){
				node=node.next;
			}
			else{
				h.put(node.data, true);
			}
		}
		System.out.println(h.keySet());
	}
}