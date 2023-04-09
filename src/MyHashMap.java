public class MyHashMap {
    private int[] steps = {-1610612737, -1073741826, -536870915, -4, 536870907, 1073741818, 1610612729, 2147483647};
    public class MyLinkedListMap {

        private Node start, end;
        private int size = 0;

        public MyLinkedListMap() {
        }

        public <K,V> void add(K key,V value) {
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
            int counter = 1;
            do {
                if (key.equals(node.key)) {
                    if (counter == size) {
                        end = node.previews;
                        node.previews.next = null;
                    } else if (counter == 1) {
                        start = node.next;
                        start.previews=null;
                    } else {
                        node.previews.next = node.next;
                        node.next.previews=node.previews;
                    }
                    size--;
                    return true;
                }
                node = node.next;
                counter++;
            } while (node.next!=null);
            return false;
        } //удаляет элемент под индексом

        public void clear(){
            start = end = null;
            size = 0;
        } //очищает коллекцию

        public int size(){
            return size;
        } //возвращает размер коллекции

        public <K> Object get(K key){
            Node node = start;
            do {
                if (key.equals(node.key)) {
                    return node.data;
                }
                node = node.next;
            } while (node.next!=null);
            return false;
        } //возвращает элемент под индексом

        class Node {
            Object data, key;
            Node previews, next;

            public <K,E> Node(K key, E data) {
                this.data = data;
                this.key = key;
            }
        }
    }

    MyLinkedListMap[] bucket = new MyLinkedListMap[8];
    {
        clear();
//        for (int i = 0; i < bucket.length; i++) {
//         bucket[i]=new MyLinkedListMap();
//        }
    }

     public <V,K> void put(K key, V value){
         int hashKey = key.hashCode();
         for (int i = 0; i < steps.length; i++) {
             if (hashKey<=steps[i]) {
                 bucket[i].add(key, value);
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

    public void clear(){
        for (int i = 0; i < bucket.length; i++) {
            bucket[i]=new MyLinkedListMap();
        }
    } //очищает коллекцию

    public int size(){
        int count = 0;
        for (int i = 0; i < bucket.length; i++) {
            count += bucket[i].size();
        }
        return count;
    } //возвращает размер коллекции

    public <E> Object get(E key){
        int hashKey = key.hashCode();
        for (int i = 0; i < steps.length; i++) {
            if (hashKey<=steps[i]) {
                return bucket[i].get(key);
            }
        }
        return false;
    } //возвращает значение(Object value) по ключу
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