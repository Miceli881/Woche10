package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class ToDoControllerTest {
    
    @Test
    public void testCreate() {
        ToDoController controller = new ToDoController();
        var todo = new ToDo(1, "t", "d");
        controller.createTodo(1, todo);
        assertEquals(1, controller.count());
        assertEquals(1, controller.todo().size());
    }

    @Test
    public void testPing() {
        ToDoController controller = new ToDoController();
        assertEquals("{ \"status\": \"ok\", \"userId\": \"admin\", \"languageCode\": \"de\",\"version\": \"0.0.1\"}", controller.ping());
    }

    @Test
    public void testGetTodo() {
        ToDoController controller = new ToDoController();
        var originalTodo = new ToDo(1, "important todo", "this is very important to test jenkins functionality");
        controller.createTodo(1, originalTodo);
        
        var todo = controller.getTodo(1);
        assertEquals("important todo", todo.getTitle());
        assertEquals("this is very important to test jenkins functionality", todo.getDescription());
    }

    @Test void testCreateAndDeleteTodo() {
        ToDoController controller = new ToDoController();
        var originalTodo = new ToDo(1, "important todo", "this is very important to test jenkins functionality");
        controller.createTodo(1, originalTodo);
        
        var todo = controller.getTodo(1);

        assertNotNull(todo);

        controller.deleteTodo(1);
        
        var todoAfter = controller.getTodo(1);
        
        assertNull(todoAfter);

    }


}
