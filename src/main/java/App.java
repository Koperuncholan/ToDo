import model.ToDo;
import service.TodoService;
import service.TodoServiceImpl;
import utils.ToDoUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ToDoUtils toDoUtils = new ToDoUtils();
        ArrayList<ToDo> toDos = toDoUtils.getToDos();
        TodoServiceImpl todoServiceImpl = new TodoServiceImpl(toDos,sc);
        todoServiceImpl.printMainMenu();
    }
}
