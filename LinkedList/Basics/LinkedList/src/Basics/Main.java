package Basics;
public class Main {
    public static void main(String[] args) {
        LL list = new LL();

        list.insertFirst(10);
        list.insertFirst(20);
        list.insertFirst(30);
        list.insertFirst(40);
        list.insertFirst(50);
        list.display();               // 50->40->30->20->10->END

        list.insertLast(5);
        list.insertLast(6);
        list.display();              // 50->40->30->20->10->5->6->END

        list.insert(79, 3);
        list.display();              // 50->40->30->79->20->10->5->6->END
    }
}