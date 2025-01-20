import java.util.Random;

class ListNode {
    int value;
    ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }
}

public class ShuffleLinkedList {
    private static final Random random = new Random();

    // Main function to shuffle the linked list
    public static ListNode shuffle(ListNode head) {
        if (head == null || head.next == null) {
            return head; // Base case: empty or single-node list is already "shuffled"
        }

        // Step 1: Split the list into two halves
        ListNode mid = getMiddle(head);
        ListNode secondHalf = mid.next;
        mid.next = null; // Split the list into two

        // Step 2: Recursively shuffle both halves
        ListNode left = shuffle(head);
        ListNode right = shuffle(secondHalf);

        // Step 3: Merge the two halves randomly
        return mergeRandomly(left, right);
    }

    // Function to find the middle of the linked list
    private static ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Function to merge two lists randomly
    private static ListNode mergeRandomly(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0); // Temporary node to build the shuffled list
        ListNode current = dummy;

        while (left != null && right != null) {
            // Randomly pick an element from either left or right
            if (random.nextBoolean()) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }

        // Append any remaining elements
        if (left != null) {
            current.next = left;
        }
        if (right != null) {
            current.next = right;
        }

        return dummy.next; // Return the shuffled list
    }

    // Helper function to print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a sample linked list
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Original list:");
        printList(head);

        // Shuffle the linked list
        ListNode shuffled = shuffle(head);

        System.out.println("Shuffled list:");
        printList(shuffled);
    }
}
