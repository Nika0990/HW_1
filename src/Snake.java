public class Snake {
    private int  length;
    private int head;

    public Snake(int length, int head){
        this.length = length;
        this.head = head;

    }

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

}
