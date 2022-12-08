
public class Main {
    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(9,new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9)))))));
        ListNode listNode2 = new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))));
        //8,9,9,9,0,0,0,1
        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(1,new ListNode(9, new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9,new ListNode(9))))))))));
        ListNode result1 = addTwoNumbers(listNode1,listNode2);
        ListNode result2 = addTwoNumbers(listNode3,listNode4);
        System.out.println(result1);
        System.out.println(result2);

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int deepList1 = nodeDepth(l1, 1);
        int deepList2 = nodeDepth(l2, 1);
        int deepMass;
        if (deepList1 > deepList2) {
            deepMass = deepList1;
        } else {
            deepMass = deepList2;
        }
        long[] mass1 = nextNodeReader(l1,new long[deepList1],0);
        long[] mass2 = nextNodeReader(l2,new long[deepList2],0);
        long sumMass1 = arrayAdds(mass1);
        long sumMass2 = arrayAdds(mass2);
        long sum = sumMass1 + sumMass2;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (deepMass!=0) {
            current.next = new ListNode((int) (sum%10));
            sum/=10;
            current = current.next;
            deepMass--;
        }
        if(sum == 1) {
            current.next = new ListNode(1);
        }
        return dummy.next;
    }
    private static int nodeDepth (ListNode node, int deep) {//вычисление глубины списка
        if (node.next!=null) {
           deep = nodeDepth (node.next, ++deep);
        }
        return deep;
    }
    private static long[] nextNodeReader (ListNode node, long[] mass, int index) {
        if (node!=null) {
            mass[index] = node.val;
            nextNodeReader(node.next,mass, ++index);
        }
        return mass;
    }
    private static long arrayAdds (long[] mass) {
        long sum = 0;
        for (int i = mass.length - 1; i >= 0; i--) {
            sum = 10 * sum + mass[i];
        }
        return sum;
    }
}
