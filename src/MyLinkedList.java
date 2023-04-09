public class MyLinkedList {

    private Node start, end;
    private int size = 0;


    public <E> void add(E value) {
        Node node = new Node(value);
        if (size == 0) {
            start = end = node;
        } else {
            end.next = node;
            end = node;
        }
        size++;
    } //добавляет элемент в конец



    public void remove(int index) {
        Node node = start;
        if (index < size & index > -1) {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            if (index == size) {
                node.next = null;
                end = node;
            } else if (index == 0){
                //node.next=node.next.next;
                start = node.next;
            }else{
                node.next = node.next.next;
            }
            size--;
        }else {
            throw new IndexOutOfBoundsException();
        }

    } //удаляет элемент под индексом

        public void clear(){
            start = end = null;
            size = 0;
        } //очищает коллекцию

        public int size(){
            return size;
        } //возвращает размер коллекции

        public <E> Object get(int index){
            Node node = start;
            if (index < size & index > -1) {
                for (int i = 0; i < index; i++) {
                    node = node.next;
                }
            }else {
                throw new IndexOutOfBoundsException();
            }
            return node.data;
        } //возвращает элемент под индексом


    class Node {
        Object data;
        Node next;
        public <E> Node(E data) {
            this.data = data;
        }
    }

}


//    Написать свой класс MyLinkedList как аналог классу LinkedList.
//
//        Нельзя использовать массив. Каждый элемент должен быть отдельным
//        объектом-посредником(Node - нода) который хранит ссылку на предыдущий
//        и следующий элемент коллекции (двусвязный список).
//
//        Методы
//
//        add(Object value) добавляет элемент в конец
//        remove(int index) удаляет элемент под индексом
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        get(int index) возвращает элемент под индексом