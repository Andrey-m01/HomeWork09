public class MyHashMap <V,K>{
    private final int[] steps = {-1610612737, -1073741826, -536870915, -4, 536870907, 1073741818, 1610612729, 2147483647};
    public static class MyLinkedListMap <E,K>{

        private Node start, end;
        private int size = 0;

        public MyLinkedListMap() {
        }

        public <K,V> void add(K key,V value) {
            Node node = new Node(key, value);
            if (size == 0) {
                start = end = node;
            } else {
                end.next = node;
                node.previews=end;
                end = node;
            }
            size++;
        }

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
            } while (node!=null);
            return false;
        }

        public int size(){
            return size;
        }

        public <K> E get(K key){
            Node node = start;
            while (node!=null) {
                if (key.equals(node.key)) {
                    return (E) node.data;
                }
                node = node.next;
            }
            return (E) "";
        }

        static class Node <K,E>{
            E data;
            K key;
            Node previews, next;

            public Node(K key, E data) {
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

    public <K> V get(K key){
        int hashKey = key.hashCode();
        for (int i = 0; i < steps.length; i++) {
            if (hashKey<=steps[i]) {
                return (V) bucket[i].get(key);
            }
        }
        return null;
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