class Task {
    int taskId;
    String taskName;
    String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public void display() {
        System.out.println(taskId + " " + taskName + " " + status);
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

public class TaskManagement {

    Node head;

    public void addTask(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        System.out.println("Task added successfully.");
    }

    public Task searchTask(int taskId) {
        Node current = head;

        while (current != null) {
            if (current.task.taskId == taskId) {
                return current.task;
            }

            current = current.next;
        }

        return null;
    }

    public void traverseTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        Node current = head;

        while (current != null) {
            current.task.display();
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("No tasks found.");
            return;
        }

        if (head.task.taskId == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Node current = head;

        while (current.next != null) {
            if (current.next.task.taskId == taskId) {
                current.next = current.next.next;
                System.out.println("Task deleted successfully.");
                return;
            }

            current = current.next;
        }

        System.out.println("Task not found.");
    }

    public static void main(String[] args) {

        TaskManagement taskList = new TaskManagement();

        taskList.addTask(new Task(101, "Complete Assignment", "Pending"));
        taskList.addTask(new Task(102, "Attend Meeting", "Completed"));
        taskList.addTask(new Task(103, "Submit Project", "Pending"));
        taskList.addTask(new Task(104, "Review Code", "In Progress"));

        System.out.println("\nAll Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching Task with ID 102:");
        Task result = taskList.searchTask(102);

        if (result != null) {
            result.display();
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task with ID 103:");
        taskList.deleteTask(103);

        System.out.println("\nTasks After Deletion:");
        taskList.traverseTasks();
    }
}