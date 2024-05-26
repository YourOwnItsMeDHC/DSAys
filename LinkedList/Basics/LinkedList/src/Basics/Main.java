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

        list.deleteLast();
        list.display();              // 40->30->20->END
        list.deleteLast();
        list.display();              // 40->30->END

        list.find(30);






        DLL list2 = new DLL();

        list2.insertFirst(1);
        list2.insertFirst(2);
        list2.insertFirst(3);
        list2.insertFirst(4);
        list2.insertFirst(5);
        list2.insertFirst(6);
        list2.insertFirst(7);
        list2.insertFirst(8);
        list2.insertFirst(9);
        list2.insertFirst(10);

        list2.display();          // 10->9->8->7->6->5->4->3->2->1->END
        System.out.println();

        list2.displayRevD(list2.head);    // END<-1<-2<-3<-4<-5<-6<-7<-8<-9<-10<-
        System.out.println();

        list2.display2WhileLoop();
        System.out.println();
        // Print in reverse :
        // 1->2->3->4->5->6->7->8->9->10->START

        list2.insertLast(55);        // 55 is inserted after 1

        list2.display();           // 10->9->8->7->6->5->4->3->2->1->55->END
        System.out.println();

        System.out.println("Node's value at index 6 is : " + list2.findNodeValue(6));
        // Node's value at index 6 is : 4

        list2.insertIndex(6, 7980);
        list2.display();                           // 10->9->8->7->6->5->7980->4->3->2->1->55->END
        System.out.println();

        list2.find(7980);                    // Node with value 7980 is present at the index : 6
        list2.find(111);                     // No node found with the value 111

        list2.insertAfter(6, 74);
        list2.display();                          // 10->9->8->7->6->74->5->7980->4->3->2->1->55->END
        System.out.println();

        list2.insertAfter(99, 100);
        // No node found with the value 99
        // Specified node 99 not found, after which I do wanna insert






        CLL list3 = new CLL();
        list3.insert(100);
        list3.insert(200);
        list3.insert(300);
        list3.insert(400);
        list3.insert(500);
        list3.insert(600);
        list3.insert(700);
        list3.insert(800);
        list3.display();                  // 100->200->300->400->500->600->700->800->HEAD
        System.out.println();

        list3.delete(100);
        list3.display();                  // 200->300->400->500->600->700->800->HEAD
        System.out.println();

        list3.delete(700);
        list3.display();                  // 200->300->400->500->600->800->HEAD


//        Recursive Insertion
        LL list4 = new LL();

        list4.insertFirst(10);
        list4.insertFirst(20);
        list4.insertFirst(30);
        list4.insertFirst(40);
        list4.insertFirst(50);
        System.out.println();
        list4.display();               // 50->40->30->20->10->END

        list4.insertRecur(79, 3);
        list4.display();               // 50->40->30->79->20->10->END



        // 148. Sort List - Recursive bubble sort approach-2 (check other 3 approaches as well)
        LL list5 = new LL();

        list5.insertFirst(56);
        list5.insertFirst(109);
        list5.insertFirst(54);
        list5.insertFirst(98);
        list5.insertFirst(65);
        System.out.println("Before applying Buuble Sort : ");
        list5.display();               // 109->98->65->56->54->END

        list5.sortList();


        System.out.println("After applying Buuble Sort : ");
        list5.display();               // 50->40->30->20->10->END

    }
}