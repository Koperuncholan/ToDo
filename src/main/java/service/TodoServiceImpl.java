package service;

import model.ToDo;

import java.security.cert.TrustAnchor;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TodoServiceImpl implements TodoService {

    private ArrayList<ToDo> toDos;
    private Scanner sc;

    public TodoServiceImpl(ArrayList<ToDo> toDos, Scanner sc) {
        this.toDos = toDos;
        this.sc = sc;
    }

    @Override
    public void addTodo() {
        System.out.println("AddToDo");
        System.out.println("************");
        System.out.println("Enter Your Items : ");
        String itemName = sc.next();
        ToDo toDo = new ToDo();
        toDo.setId(toDos.size() + 1);
        toDo.setItemName(itemName);
        toDo.setCompleted(false);
        toDos.add(toDo);

    }

    @Override
    public void viewTodo() {
        System.out.println("ViewToDo");
        System.out.println("************");
        for (ToDo toDo : toDos) {
            System.out.println(toDo.getId() + " . " + toDo.getItemName()
                    + " Completed Status - " + (toDo.isCompleted() ? "Yes" : "No"));
        }


    }

    @Override
    public void updateTodo() {
        System.out.println("UpdateToDo");
        System.out.println("************");
        for (ToDo toDo : toDos) {
            System.out.println(toDo.getId() + " . " + toDo.getItemName()
                    + " Completed Status - " + (toDo.isCompleted() ? "Yes" : "No"));
        }
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        ToDo toDo = toDos.get(choice - 1);
        toDo.setCompleted(true);
        System.out.println("************");


    }

    public void printMainMenu() {
        while (true) {
            System.out.println("1.AppToDo");
            System.out.println("2.ViewToDo");
            System.out.println("3.UpdateToDo");
            System.out.println("4.Exit");
            System.out.println("Enter your choice");
            int choice = 0;
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException exception) {
                System.out.println(exception);
                System.out.println("Invalid Choice");
                printMainMenu();
            }
            switch (choice) {
                case 1 -> addTodo();
                case 2 -> viewTodo();
                case 3 -> updateTodo();
                case 4 -> System.exit(0);
                default -> System.out.println("Invalid Choice");
            }


        }
    }
}
