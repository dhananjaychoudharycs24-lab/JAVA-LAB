import java.util.*;
import CIE.*;
import SEE.*;

public class FinalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Personal[] p = new Personal[n];
        Internals[] in = new Internals[n];
        External[] ex = new External[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details of student " + (i + 1));

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int[] internal = new int[5];
            System.out.println("Enter internal marks of 5 subjects: ");
            for (int j = 0; j < 5; j++)
                internal[j] = sc.nextInt();

            int[] external = new int[5];
            System.out.println("Enter SEE marks of 5 subjects: ");
            for (int j = 0; j < 5; j++)
                external[j] = sc.nextInt();

            p[i] = new Personal(usn, name, sem);
            in[i] = new Internals(internal);
            ex[i] = new External(usn, name, sem, external);
        }

        System.out.println("\n----- FINAL MARKS OF STUDENTS -----");
        for (int i = 0; i < n; i++) {
            p[i].displayPersonal();
            System.out.println("Final Marks (per subject): ");
            for (int j = 0; j < 5; j++) {
             
                int finalMarks = in[i].internalMarks[j] + (ex[i].seeMarks[j] / 2);
                System.out.print(finalMarks + " ");
            }
            System.out.println("\n------------------------------------");
        }

        sc.close();
    }
}
