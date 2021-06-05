public class DoubleLinkedList {
    NodeForDoubleList start;
    NodeForDoubleList end;

    public void fillList(int length){
        start = new NodeForDoubleList();
        end = start;
        for(int i=0; i<length; i++){
            end.next = new NodeForDoubleList();
            end.next.previous = end;
            end = end.next;
        }
    }

    public void fillList(int[] arr){
        start = new NodeForDoubleList(arr[0]);
        end = start;
        for(int i=1; i<arr.length; i++){
            end.next = new NodeForDoubleList(arr[i]);
            end.next.previous = end;
            end = end.next;
        }
    }

    public void printList(){
        NodeForDoubleList element = start;
        while(element!=null){
            System.out.print(element.data+" ");
            element = element.next;
        }
        System.out.println();
    }

    public int findElement(int el){
        NodeForDoubleList element = start;
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

    public void removeElement(int index) {
        if(index<0||index>this.getLength()-1){
            System.out.println("Неверный индекс!");
            return;
        }
        NodeForDoubleList element = start;
        if (index == 0) {
            start = start.next;
            start.previous =null;
        } else {
            int i = 0;
            while (i != index) {
                element = element.next;
                i++;
            }
            if(index == this.getLength()-1){
                element.previous.next = null;
                end = end.previous;
            }
            else {
                element.previous.next = element.next;
                element.next.previous = element.previous;
            }
        }
    }

    public int getLength(){
        NodeForDoubleList element = start;
        int length =0;
        while(element!=null){
            element = element.next;
            length++;
        }
        return length;
    }

    public void insertEnd(int data){
        end.next = new NodeForDoubleList(data);
        end.next.previous =end;
        end = end.next;
    }

    public void insertStart(int data){
        NodeForDoubleList element = new NodeForDoubleList(data);
        element.next = start;
        start.previous = element;
        start = element;
    }

    public void insert(int index, int data){
        if(index<0||index>this.getLength()-1){
            System.out.println("Неверный индекс!");
            return;
        }

        if(index == this.getLength() -1){
            end.next = new NodeForDoubleList(data);
            end.next.previous =end;
            end = end.next;
            return;
        }

        NodeForDoubleList element = start;
        int i = 0;
        while(i!=index){
            element = element.next;
            i++;
        }
        NodeForDoubleList temp = element.next;
        element.next = new NodeForDoubleList(data);
        element.next.previous = element;
        element.next.next = temp;
        element.next.next.previous = element.next;

    }
}

class NodeForDoubleList{
    int data;
    NodeForDoubleList next;
    NodeForDoubleList previous;

    public NodeForDoubleList(){
        data = 0;
        next = null;
        previous = null;
    }

    public NodeForDoubleList(int data){
        this.data = data;
        next = null;
        previous = null;
    }
}
