class Solution {
    Node deleteMid(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        if (count <= 1)
            return null;
        temp = head;
        int mid = count / 2;
        while (mid - 1 > 0) {
            temp = temp.next;
            mid--;
        }
        temp.next = temp.next.next;
        return head;
    }
}
