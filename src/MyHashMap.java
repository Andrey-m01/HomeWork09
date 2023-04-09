public class MyHashMap {
    private int[] steps = {-1610612737, -1073741826, -536870915, -4, 536870907, 1073741818, 1610612729, 2147483647};
    public class MyLinkedListMap {

        private Node start, end;
        private int size = 0;

        public <V,K> void add(V value, K key) {
            Node node = new Node(value, key);
            if (size == 0) {
                start = end = node;
            } else {
                end.next = node;
                node.previews=end;
                end = node;
            }
            size++;
        } //добавляет элемент в конец

        public <K> boolean remove(K key) {
            Node node = start;
            int counter = 0;
            do {
                if (key == node.key) {
                    if (counter == size) {
                        node.next = null;
                        end = node;
                    } else if (counter == 0) {
                        //node.next=node.next.next;
                        start = node.next;
                    } else {
                        node.next = node.next.next;
                    }
                    size--;
                    return true;
                }

                counter++;
            } while (node.next!=null);



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
            Node previews, next;

            public <E,K> Node(E data, K key) {
                this.data = data;
                this.key = key;
            }
        }
    }

    MyLinkedListMap[] bucket = new MyLinkedListMap[8];

     public <V,K> void put(V value,K key){
         int hashKey = key.hashCode();
         for (int i = 0; i < steps.length; i++) {
             if (hashKey<=steps[i]) {
                 bucket[i].add(value, key);
                 return;
             }
         }
     } //добавляет пару ключ + значение



    public <K> void remove(K key){
        int hashKey = key.hashCode();
        for (int i = 0; i < steps.length; i++) {
            if (hashKey<=steps[i]) {
                bucket[i].remove(key);
                return;
            }
        }
    } //удаляет пару по ключу
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