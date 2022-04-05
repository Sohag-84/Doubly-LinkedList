package Lab_3;

public class DoublyLinkedList {
    static Node head;
    static Node tail;
    
    void addFirst(int d){
        Node cur = new Node(d);
        cur.next = head;
        cur.prev = null;
        //check linkedList already exits or not
        if(head != null){
            head.prev = cur;
        }
        else{
            tail = cur;
        }
        head = cur;
    }
    
    void addMiddle(Node cur,int d,int pos){
        Node temp = new Node(d);
        for (int i = 0; i < pos-1; i++) {
            if(cur != null){
                cur = cur.next;
            }
        }
        temp.next = cur.next;
        temp.prev = cur;
            
        cur.next.prev = temp;
        cur.next = temp;
    }
    
    void addLast(Node cur,int d){
        Node temp = new Node(d);
        while(cur.next != null){
            cur = cur.next;
        }
        temp.next = null;
        temp.prev = cur;
        cur.next = temp;
        tail = temp;
    }
    
    void delete(Node cur,int pos){
        
        if(pos==0){
            cur = cur.next;
            cur.prev = null;
            head = cur;
        }else{
            for (int i = 0; i < pos-1; i++) 
            {
                if(cur != null){
                    cur = cur.next;
                }
            }
            if(cur.next == tail){
                cur.next = null;
                tail = cur;
            }else{
                cur.next = cur.next.next;
                cur.next.prev = cur;
            }
           
            
        }  
    }
    
    void traverse(Node cur){
        while(cur != null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("The items of linked list are: ");
        DoublyLinkedList d = new DoublyLinkedList();
        d.addFirst(5);
        d.addFirst(10);
        d.addFirst(15);
        d.addMiddle(head, 20, 2);
        d.addMiddle(head, 12, 3);
        d.addLast(head, 6);
        d.delete(head, 4);
        d.delete(head,4);
        d.traverse(head);
    }
}
