package ch.zhaw.iwi.devops.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

}
