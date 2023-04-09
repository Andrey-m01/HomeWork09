import java.util.Arrays;

public class MyArrayList {
private Object[] data = new Object[0];


    @Override
    public String toString() {
        return  Arrays.toString(data);
    }

    public void add(Object value){
        Object[] tData = new Object[data.length+1];
        for (int i =0;i< data.length;i++) {
            tData[i] = data[i];
        }
        tData[tData.length-1]=value;
        data=tData;
    } //добавляет элемент в конец

    public void remove(int index){
        Object[] tData = new Object[data.length-1];
        int j = 0;
        for (int i =0;i<data.length;i++) {
            if(i!=index) {
                tData[j] = data[i];
                j++;
            }
        }
        data=tData;
    } //удаляет элемент под индексом

    public void clear(){
        data = new Object[0];
    } //очищает коллекцию

    public int size(){
        return data.length;
    } //возвращает размер коллекции

    public Object get(int index){
        return data[index];
    }

//    Написать свой класс MyArrayList как аналог классу ArrayList.
//
//    Можно использовать 1 массив для хранения данных.
//
//    Методы
//
//    add(Object value) добавляет элемент в конец
//    remove(int index) удаляет элемент под индексом
//    clear() очищает коллекцию
//    size() возвращает размер коллекции
//    get(int index) возвращает элемент под индексом

}
