package leetcode.editor.cn.list;

public class MyLinkedList<T> {

    private Node<T> node;

    private int length;

    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();

    }

    public class Node<T> {

        private T value;

        private Node<T> next;

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node<T> getNext() {
            return next;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }
    }
}
