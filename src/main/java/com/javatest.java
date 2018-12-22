package com;


import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Created by NJTZ on 2018/12/21.
 */
public class javatest {
    /**
     * Created by NJTZ on 2018/12/21.
     */
    public static class ContrastTest {
        public static void main(String[] args) {
            /*Person person = new Person();
            person.setName("lisi");
            person.setAge(24);*/
            //System.out.println(person.age);

            /**
             * automatic resource management
             */
            //H:/git_repository/helloworld/build/resources/main/test.txt
            /*Path file= Paths.get("H:/git_repository/helloworld/build/resources/main/test.txt");
            Charset charset= Charset.forName("UTF-8");
            try(BufferedReader bufferedReader= Files.newBufferedReader(file,charset)){
                String line;
                while ((line=bufferedReader.readLine())!=null){
                    System.out.println(line);
                }
            }catch (IOException e){
                e.printStackTrace();
            }*/
            /**
             * Lambda 表达式
             * 基本语法： （parameters）->expression
             * 或        （parameters）->statements
             */
            Runnable runnable=()-> {System.out.println("Run");};
            new Thread(runnable).run();

            ArrayList<String> list = new ArrayList<>();
            list.add("zhangsan");
            list.add("lisi");
            list.add("wangwu");
            /*list.forEach(
                    System.out::println //双冒号操作符
            );*/
            list.forEach(str-> System.out.println(str));

        }
    }
}
