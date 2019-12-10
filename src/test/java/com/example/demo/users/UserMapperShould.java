package com.example.demo.users;

import com.example.demo.Status;
import com.example.demo.UserMapper;
import com.example.demo.model.Users;
import com.example.demo.model.UserResponse;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UserMapperShould {

    private UserMapper mapper;
    private Users userInput;
    private UserResponse expectedOutput;

    @Before
    public void setup(){
        mapper=new UserMapper();
        userInput= new Users("Petros","Efthymiou", 40, Status.PLATINUM);
        userInput.setId(1);
        expectedOutput = new UserResponse(1,"Petros", "Efthymiou", 40, "platinum");


    }

    @Test
    public void mapUserToUserResponse(){
        UserResponse output= mapper.mapUserToUserResponse(userInput);
       // Assert.assertEquals(expectedOutput,output);
        Assert.assertThat(expectedOutput, Matchers.samePropertyValuesAs(output));

    }
}
