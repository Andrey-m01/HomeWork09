public class MyHashMap {
    public class MyLinkedListMap {

        private Node start, end;
        private int size = 0;

        public void add(Object value, Object key) {
            Node node = new Node(value, key);
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

        public Object get(int index){
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
            Object data, key;
            Node next;

            public Node(Object data, Object key) {
                this.data = data;
                this.key = key;
            }
        }
    }

    MyLinkedListMap[] bucket = new MyLinkedListMap[8];

     public void put(Object key, Object value){
         int test = key.hashCode();
         int [] steps = {-1610612737, -1073741826, -536870915, -4, 536870907, 1073741818, 1610612729, 2147483640};
         for (int i = 0; i < steps.length; i++) {
             steps[i] = Integer.MIN_VALUE+((i+1)*(Integer.MAX_VALUE/4));
         }
         System.out.println();

     }


//        put(Object key, Object value) добавляет пару ключ + значение
//        remove(Object key) удаляет пару по ключу
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        get(Object key) возвращает значение(Object value) по ключу
}


//    Написать свой класс MyHashMap как аналог классу HashMap.
//
//        Нужно делать с помощью односвязной Node.
//
//        Не может хранить две ноды с одинаковых ключами одновременно.
//
//        Методы
//
//        put(Object key, Object value) добавляет пару ключ + значение
//        remove(Object key) удаляет пару по ключу
//        clear() очищает коллекцию
//        size() возвращает размер коллекции
//        get(Object key) возвращает значение(Object value) по ключу