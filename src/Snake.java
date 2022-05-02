public class Snake {
    private int  tail;
    private int head;

    public Snake(int tail, int head){
        this.tail = tail;
        this.head = head;

    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return tail;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

}
