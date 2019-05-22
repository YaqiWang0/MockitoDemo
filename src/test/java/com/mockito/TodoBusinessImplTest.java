package com.mockito;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

 public class TodoBusinessImplTest {
    @Test
    public void test(){
        List<Integer> scores= Arrays.asList(99,100,101,105);
        assertThat(scores,hasSize(4));
        assertThat(scores,hasItems(99,100));
        assertThat(scores,everyItem(lessThan(190)));
        //String
        assertThat("",isEmptyString());
        assertThat(null,isEmptyOrNullString());
        //Array
        Integer[] marks={1,2,3};
        assertThat(marks, Matchers.<Integer>arrayWithSize(3));
        assertThat(marks, arrayContaining(1,2,3));
        assertThat(marks,arrayContainingInAnyOrder(2,1,3));
    }
}