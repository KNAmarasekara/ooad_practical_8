import java.util.ArrayList;
import java.util.Scanner;

//main
public class ToDoList{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> tasks = new ArrayList<>();

        // a.
        System.out.println("Enter tasks one by one (enter -99 to finish):");
        while (true) {
            System.out.print("Task: ");
            String task = sc.nextLine();
            
            if (task.equals("-99")) {
                break;
            }
            tasks.add(task);
        }

        // b.
        System.out.print("Enter the index of the task to remove: ");
        try {
            int index = Integer.parseInt(sc.nextLine().trim());
            if (index >= 0 && index < tasks.size()) {
                tasks.remove(index);
                System.out.println("Task removed successfully.");
            } else {
                System.out.println("Invalid index. No task removed.");
            }
        }
            catch (NumberFormatException e) {
                  System.out.println("Invalid index. No task removed.");
        }

        // c.
        System.out.println("Total number of tasks: " + tasks.size());

        // d.
        System.out.println("Remaining tasks:");
        for (String t : tasks) {
            System.out.println(t);
        }
    
    }
}
