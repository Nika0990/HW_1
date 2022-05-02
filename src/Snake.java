public class Snake {
    private int  length;
    private int head;

    public Snake(int tail, int head){
        this.length = tail;
        this.head = head;

    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getTail() {
        return length;
    }

    public void setTail(int tail) {
        this.length = tail;
    }

}
