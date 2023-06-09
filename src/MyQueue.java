public class MyQueue <T> {
    private Node start, end;
    private int size = 0;
    class Node <D>{
        D data;
        Node next;
        public <E> Node(E data) {
            this.data = (D) data;
        }
    }


        public <E> void add(E value){
            Node node = new Node(value);
            if (size == 0) {
                start = end = node;
            } else {
                end.next = node;
                end = node;
            }
            size++;
        } //добавляет элемент в конец

    public void clear(){
        start = end = null;
        size = 0;
    } //очищает коллекцию

    public int size(){
        return size;
    } //возвращает размер коллекции

    public T peek(){
        if (size>0){
            return (T) start.data;
        }
        return null;
    } //возвращает первый элемент в очереди (FIFO)

    public T poll(){
        if (size>0){
            Node node = start;
            start=start.next;
            size--;
            return (T) node.data;
        }
        return null;
    } //возвращает первый элемент в очереди и удаляет его из коллекции


}


//    Написать свой класс MyQueue как аналог классу Queue, который будет работать по принципу FIFO (first-in-first-out).
//
//        Можно делать либо с помощью Node либо с помощью массива.
//
//        Методы
//
//        add(Object value) добавляет элемент в конец
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        peek() возвращает первый элемент в очереди (FIFO)
//        poll() возвращает первый элемент в очереди и удаляет его из коллекции

