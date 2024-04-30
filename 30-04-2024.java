class node {
    int data;
    Node next;

    node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    
    Node addTwoLists(Node num1, Node num2) {
        num1 = reverse(num1);
        num2 = reverse(num2);

        Node sum = null;
        int carry = 0;

        while (num1 != null || num2 != null || carry != 0) {
            int newVal = carry;

            if (num1 != null) {
                newVal += num1.data;
                num1 = num1.next;
            }
            if (num2 != null) {
                newVal += num2.data;
                num2 = num2.next;
            }

            carry = newVal / 10;
            newVal %= 10;

            Node newNode = new Node(newVal);
            newNode.next = sum;
            sum = newNode;
        }

        return removeLeadingZeros(sum);
    }

    Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    Node removeLeadingZeros(Node head) {
        Node current = head;
        Node prev = null;

        while (current != null && current.data == 0) {
            prev = current;
            current = current.next;
            if (prev != null) {
                prev.next = null;
            }
        }

        return (current != null) ? current : new Node(0);
    }

    void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
    }


}
