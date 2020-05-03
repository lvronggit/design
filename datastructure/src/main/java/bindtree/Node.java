package bindtree;


public class Node {

    int iData;  //key
    double fData; // value
    Node leftChild; //树子节点左边
    Node rightChild; //树子节点右边

    public Node insert(int iData, int fData){
        this.iData = iData;
        this.fData = fData;
        return this;
    }

    public int getiData() {
        return iData;
    }

    public void setiData(int iData) {
        this.iData = iData;
    }

    public double getfData() {
        return fData;
    }

    public void setfData(double fData) {
        this.fData = fData;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "iData=" + iData +
                ", fData=" + fData +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
