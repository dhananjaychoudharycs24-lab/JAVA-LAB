package CIE;

public class Internals {
    public int[] internalMarks = new int[5];

    public Internals(int[] marks) {
        for (int i = 0; i < 5; i++) {
            this.internalMarks[i] = marks[i];
        }
    }

    public void displayInternals() {
        System.out.print("Internal Marks: ");
        for (int m : internalMarks)
            System.out.print(m + " ");
        System.out.println();
    }
}
