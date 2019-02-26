import java.security.spec.DSAGenParameterSpec;
import java.util.Scanner;
public class SinglyLinkedList {
    Node head;
    static class Node{
        int data;
        Node next;
        Node(int x){
            data=x;
            next=null;
        }
    }
   public static SinglyLinkedList insert(SinglyLinkedList obj,int data){
            Node n=new Node(data);
            Node ptr=obj.head;
            if(obj.head==null){
                obj.head=n;
                return obj;
            }
            else{
                ptr=obj.head;
                while(ptr.next!=null){
                    ptr=ptr.next;
                }
                ptr.next=n;
            }
            return obj;
    }
    public static SinglyLinkedList insertAtStart(SinglyLinkedList obj,int data){
        Node n=new Node(data);
        n.next=obj.head;
        obj.head=n;
        return obj;
    }
    public static SinglyLinkedList deleteNodeWithValue(SinglyLinkedList obj,int data){
        Node current=obj.head,prev=null;
        Node next=current.next;
            while(current!=null){
                if(current.data==data){
                            if(prev==null){
                                obj.head=current.next;
                                return obj;
                            }
                            else if(current.next==null){
                                prev.next=null;
                                return obj;
                            }
                            else{
                                prev.next=current.next;
                                return obj;
                            }
                }
                else{
                    prev=current;
                    current=current.next;
                }
            }
        System.out.println("No Such Data Found");
        return obj;
    }
    public static SinglyLinkedList deleteNodeWithPos(SinglyLinkedList obj,int pos){
        Node current=obj.head,prev=null;
        Node next=current.next;
        if(pos==0){
            obj.head=current.next;
            return obj;
        }
        else {
            while (pos > 0) {
                prev = current;
                current = current.next;
                pos--;
            }
            if(current==null){
                System.out.println("Not a Valid Position");
            }
            else if(current.next==null){
                prev.next=null;
                return obj;
            }
            else{
                prev.next=current.next;
                return obj;
            }

        }
        return obj;
    }
    public static void Display(SinglyLinkedList obj){
        Node ptr=obj.head;
        while(ptr!=null){
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList obj=new SinglyLinkedList();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
        int size=sc.nextInt();
        for(int i=0;i<size;i++){
            System.out.println("Enter "+(i+1)+"th value");
            int value=sc.nextInt();
            obj=insert(obj,value);
        }
        Display(obj);
        System.out.println("\nEnter value to insert at first");
        int num=sc.nextInt();
        insertAtStart(obj,num);
        Display(obj);
        System.out.println("Enter the data to delete");
        int deldata=sc.nextInt();
        obj=deleteNodeWithValue(obj,deldata);
        Display(obj);
        System.out.println("Enter the positon to delete (Remember List start with zero)");
        int delposition=sc.nextInt();
        obj=deleteNodeWithPos(obj,delposition);
        Display(obj);
    }


}
