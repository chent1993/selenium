package com.wework.testcase;

import com.wework.page.App;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.MatcherAssert.assertThat;

public class TestDepartment {

    public static App app;
    @BeforeClass
    public static void beforeAll(){

        app=new App();
        app.loginWithCookie();

    }

    @Test
    public void add(){
       app.toDepartmentAdd().add("测试六部","测试一部");
    }

    @Test
    public void delete(){
        app.toDepartmentAdd().add("测试四部","Test").delete("测试四部");
    }
    @Test
    public void up(){
        String departName = "测试一部";
        int old = app.toDepartment().getPosition(departName);
        app.toDepartment().up(departName);
        assertThat(app.toDepartment().getPosition(departName),equalTo(old-1));

    }
    @Test
    public void down(){
        app.toDepartment().down("测试一部");
    }

    @Test
    public void update(){
        String text = "修改名称成功";
        String msg = app.toDepartment().update("测试六部","测试6部");
        assertThat(msg,equalTo(text));
    }
    @AfterClass
    public static void  afterAll(){
        app.quit();
    }
}
