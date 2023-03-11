package uaslp.objetos.list;

public interface List {

    void addAtTail(String data);

    void addAtFront(String data);

    void remove(int index);

    void removeAll();

    void setAt(int index, String data);

    String getAt(int index);

    void removeAllWithValue(String data);

    int getSize();

    boolean isEmpty();

    Iterator getIterator();

}
