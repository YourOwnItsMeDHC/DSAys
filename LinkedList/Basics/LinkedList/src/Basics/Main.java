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

        list.deleteFirst();
        list.display();              // 40->30->79->20->10->5->6->END

        list.deleteLastD();
        list.display();              // 40->30->79->20->10->5->END

        list.delete(4);
        list.display();              // 40->30->79->20->5->END

        int deletedItem = list.delete(2);
        list.display();                                          // 40->30->20->5->END
        System.out.println("Deleted Item is : " + deletedItem);  // Deleted Item is : 79

    }
}