public class MyStack {
    private Node start, end;
    private int size = 0;
    class Node {
        Object data;
        Node previews, next;
        public Node(Object data) {
            this.data = data;
        }
    }

    public void push(Object value){
        Node node = new Node(value);
        if (size == 0) {
            start = end = node;
        } else {
            end.next = node;
            node.previews=end;
            end = node;
        }
        size++;
    } //добавляет элемент в конец
    
    public void remove(int index){
        Node node = start;
        if (index < size & index > -1) {
            for (int i = 0; i < index - 1; i++) {
                node = node.next;
            }
            if (index == size) {
                node.next = null;
                end = node;
            } else if (index == 0){
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

    public Object peek(){
        if (size>0){
            return end.data;
        }
        return null;
    } //возвращает первый элемент в стеке (LIFO)

     public Object pop(){
         if (size>0){
             Node node = end;
             end=end.previews;
             size--;
             return node.data;
         }
         return null;
     } //возвращает первый элемент в стеке и удаляет его из коллекции

}


//    Написать свой класс MyStack как аналог классу Stack, который работает по принципу LIFO (last-in-first-out).
//
//        Можно делать либо с помощью Node либо с помощью массива.
//
//        Методы
//
//        push(Object value) добавляет элемент в конец
//        remove(int index) удаляет элемент под индексом
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        peek() возвращает первый элемент в стеке (LIFO)
//        pop() возвращает первый элемент в стеке и удаляет его из коллекции
