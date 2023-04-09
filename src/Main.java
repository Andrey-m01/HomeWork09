public class Main {
    public static void main(String[] args) {

        MyArrayList myArrayList = new MyArrayList();

        myArrayList.add(1222);
        myArrayList.add(1232);
        myArrayList.add(1242);

        System.out.println(myArrayList);

        myArrayList.remove(1);

        System.out.println(myArrayList);

        MyLinkedList linkedList = new MyLinkedList();

        linkedList.add(56416);
        linkedList.add(5613);
        linkedList.add(5644);

        System.out.println("---------");

        System.out.println(linkedList.size());

        System.out.println("---------");

        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        linkedList.remove(0);

        System.out.println(linkedList.size());

        System.out.println("---------");
        for (int i = 0; i < linkedList.size(); i++) {
            System.out.println(linkedList.get(i));
        }

        System.out.println("\n  --MyQueue-- \n");

        MyQueue myQueue = new MyQueue();

        myQueue.add(12);
        myQueue.add(13);
        myQueue.add("14");
        myQueue.add(15);

        System.out.println(myQueue.size());
        System.out.println("---------");

        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());
        System.out.println(myQueue.peek());
        System.out.println(myQueue.poll());

        System.out.println(myQueue.size());

        System.out.println("\n  --MyStack-- \n");

        MyStack myStack = new MyStack();

        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);

        System.out.println(myStack.size());

        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());

        System.out.println("\n  --myHashMap-- \n");

        MyHashMap myHashMap = new MyHashMap();

        myHashMap.put("kjndvkj","seprgj");
        myHashMap.put("kj","sepj");
        myHashMap.put( "kjn34kj","1212");
        myHashMap.put("kjn3453kj","seprgj");

        System.out.println(myHashMap.size() + "\n");

        myHashMap.remove("kj");
        System.out.println(myHashMap.get("kj"));


        System.out.println(myHashMap.size() + "\n");

    }
}