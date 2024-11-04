package javaOOP;

public abstract class A_Tree {

    // abstract là có ham có phần thân có hàm k cũng được
    //interface thì bac buoôộc tat ca cacs hàm abstract hết

    // Phương thức trừu tượng, có tham so
    void set_tree_name(String name){

    }

    // Phương thức trừu tượng không tham so
    abstract void cut_tree();
}
