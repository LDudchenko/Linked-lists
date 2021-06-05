public class LinkedList {
    private Node start;
    private Node end;

    public void fillList(int length){
        start = new Node();
        end = start;
        for(int i=1; i<length; i++){
            end.next = new Node();
            end = end.next;
        }
    }

    public void fillList(int arr[]){
        start = new Node(arr[0]);
        end = start;
        for(int i=1; i<arr.length; i++){
            end.next = new Node(arr[i]);
            end = end.next;
        }
    }

    public void printList(){
        Node element = start;
        while(element!=null){
            System.out.print(element.data+" ");
            element = element.next;
        }
        System.out.println();
    }

    public void removeElement(int index) {
        if(index<0||index>this.getLength()-1){
            System.out.println("Неверный индекс!");
            return;
        }
        Node previous = new Node();
        Node element = start;
        if (index == 0) {
            start = start.next;
        } else {
            int i = 0;
            while (i != index) {
                previous = element;
                element = element.next;
                i++;
            }
            previous.next = element.next;
        }
    }

    public int getLength(){
        Node element = start;
        int length =0;
        while(element!=null){
            element = element.next;
            length++;
        }
        return length;
    }

    public int findElement(int el){
        Node element = start;
        int count=0;
        while(element!=null){
            if(element.data==el){
                return count;
            }
            element=element.next;
            count++;
        }
        return -1;
    }

    public void changePlaces(int index){
        if(index<0||index>this.getLength()-2){
            System.out.println("Неверный индекс!");
            return;
        }
        Node element = start;
        Node previous = element;

        if(index==0){
            Node nextElement = start.next;
            Node temp = nextElement.next;
            start = nextElement;
            start.next = element;
            element.next = temp;
            return;
        }

        for(int i=0; i<index; i++){
            previous = element;
            element = element.next;
        }
        Node nextElement = element.next;
        previous.next = nextElement;
        Node temp = nextElement.next;
        nextElement.next = element;
        element.next = temp;
    }

    public int lastZeroElement(){
        Node element = start;
        int index = -1;
        int count =0;
        while(element!=null){
            if(element.data ==0){
                index = count;
            }
            element = element.next;
            count++;
        }
        return index;
    }

    public void insertEnd(int data){
        end.next = new Node(data);
        end = end.next;
    }

    public void insertStart(int data){
        Node element = new Node(data);
        element.next = start;
        start = element;
    }

    public void insert(int index, int data){
        if(index<0||index>this.getLength()-1){
            System.out.println("Неверный индекс!");
            return;
        }

        if(index == this.getLength() -1){
            end.next = new Node(data);
            end = end.next;
            return;
        }

        Node element = start;
        int i = 0;
        while(i!=index){
            element = element.next;
            i++;
        }
        Node temp = element.next;
        element.next = new Node(data);
        element.next.next = temp;
    }

}

class Node{
    int data;
    Node next;

    public Node(){
        data = 0;
        next = null;
    }

    public Node(int data){
        this.data = data;
        next = null;
    }
}