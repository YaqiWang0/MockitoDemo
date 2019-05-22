package com.business;

import com.data.api.TodoService;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

public class TodoBusinessImplTest {

    @Test
    public void retrieveTodosRelatedToSpring() {


        TodoService todoServiceMock=mock(TodoService.class);
        List<String> value=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(value);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos =todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        assertEquals(2,filteredTodos.size());
    }
    @Test
    public void retrieveTodosRelatedToSpring_usingBDD() {
        //Given
        TodoService todoServiceMock=mock(TodoService.class);
        List<String> value=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(value);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceMock);
        //When
        List<String> filteredTodos =todoBusiness.retrieveTodosRelatedToSpring("Dummy");
        //Then
        assertThat(filteredTodos.size(),is(2));

    }
@Test
    public void testDeleteTodosRelatedToSpring_usingBDD() {
        //Given
        TodoService todoServiceMock=mock(TodoService.class);
        List<String> value=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(value);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceMock);
        //When
       todoBusiness.deleteTodosNotRelatedToSpring("Dummy");
        //Then
        verify(todoServiceMock,times(1)).deleteTodo("Learn to Dance");
        then(todoServiceMock).should().deleteTodo("Learn to Dance");

    }
    @Test
    public void testDeleteTodosRelatedToSpring_usingBDD_argumentCapture() {
        //Declare Argument Captor
        ArgumentCaptor<String> stringArgumentCaptor=ArgumentCaptor.forClass(String.class);
        //Define Argument captor in specific method call
        //capture the argument
        //Given
        TodoService todoServiceMock=mock(TodoService.class);
        List<String> value=Arrays.asList("Learn Spring MVC","Learn Spring","Learn to Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(value);
        TodoBusinessImpl todoBusiness=new TodoBusinessImpl(todoServiceMock);
        //When
        todoBusiness.deleteTodosNotRelatedToSpring("Dummy");
        //Then

        then(todoServiceMock).should().deleteTodo(stringArgumentCaptor.capture());

        assertThat(stringArgumentCaptor.getValue(),is("Learn to Dance"));
    }

}