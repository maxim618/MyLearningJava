package optimized_code_variant;

import java.util.LinkedList;
import java.util.List;

public class Solution {
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

        System.out.println(addTwoNumbers2(listNode1,listNode2));

        System.out.println(addTwoNumbers3(listNode1,listNode2));

    }
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int x;
            if (l1 != null) x = l1.val;
            else x = 0;
            int y;
            if (l2 != null) y = l2.val;
            else y = 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return dummyHead.next;
    }
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        return addTwoNumbersHelper(l1, l2, 0);
    }

    private static ListNode addTwoNumbersHelper(  ListNode l1, ListNode l2, int  carry) {
        // Базовый случай: если оба списка пусты и нет переноса
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }
        int x;
        int y;
        if (l1 != null) {
            x = l1.val;
        } else {
            x = 0;
        }
        if (l2 != null) {
            y = l2.val;
        }
        else {
            y = 0;
        }
        int sum = carry + x + y;
        carry = sum / 10;

        ListNode resultNode = new ListNode(sum % 10);
        // Рекурсивный вызов для следующего узла
        resultNode.next = addTwoNumbersHelper((l1 != null) ? l1.next : null,
                (l2 != null) ? l2.next : null,
                carry);
        return resultNode;
    }
    public static ListNode addTwoNumbers3 (ListNode l1, ListNode l2) {
        List<Integer> nums1 = new LinkedList<>();
        List<Integer> nums2 = new LinkedList<>();

        // Заполнение списков значениями из связных списков
        while (l1 != null) {
            nums1.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            nums2.add(l2.val);
            l2 = l2.next;
        }

        // Объединение и суммирование значений с учетом переноса
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        for (int i = 0; i < Math.max(nums1.size(), nums2.size()) || carry != 0; i++) {
            int x = (i < nums1.size()) ? nums1.get(i) : 0;
            int y = (i < nums2.size()) ? nums2.get(i) : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
        }

        return dummyHead.next;
    }

}
