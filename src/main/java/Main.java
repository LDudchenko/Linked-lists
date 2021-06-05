
public class Main {
    public static void main(String[] args) {
        /*Створити (реалізувати, без використання Java Collection framework) однобічно
        зв’язаний список, вивести його. Якщо в списку є шуканий елемент, то вилучити
        його, а два наступні поміняти місцями.*/
        System.out.println("Задание а:");
        int[] arr = new int[]{10,0,9,90,0,6,770,8,46,1,2};
        int requiredElement = 90;

        LinkedList linkedList = new LinkedList();
        linkedList.fillList(arr);
        linkedList.printList();
        int index = linkedList.findElement(requiredElement);
        if(index!=-1) {
            linkedList.removeElement(index);
            linkedList.changePlaces(index);
            linkedList.printList();
        }
        else{
            System.out.println("Элемента " +requiredElement+" нет в списке!");
        }
        /*Видалити зі списку три елементи, які знаходяться після останнього нульового елементу*/
        System.out.println("Задание б:");
        index = linkedList.lastZeroElement();
        if(index==-1) {
            System.out.println("Элемента 0 нет в списке!");
        }
        else {
            index++;
            for (int i = 0; i < 3; i++) {
                if (linkedList.getLength() <= index) {
                    break;
                }
                linkedList.removeElement(index);
            }
        }
        linkedList.printList();

        /*Створити (реалізувати, без використання Java Collection framework) двобічно
        зв’язаний список, вивести його. Якщо в двобічно зв’язаному списку є шуканий
        елемент, то вилучити його.*/
        System.out.println("Задание в:");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.fillList(arr);
        doubleLinkedList.printList();
        index = doubleLinkedList.findElement(requiredElement);
        if(index!=-1) {
            doubleLinkedList.removeElement(index);
            doubleLinkedList.printList();
        }else{
            System.out.println("Элемента " +requiredElement+" нет в списке!");
        }
    }
}
