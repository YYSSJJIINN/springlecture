package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {

    public static void main(String[] args) {

        // Java코드로 클래스의 정보 얻기
        System.out.println("---------- 목차. 1. Class 타입의 Class 메타 정보 추출 ----------");
        Class class1 = Account.class;
        System.out.println("class1 = " + class1);

        /* 설명. Object 클래스의 getClass() 메서드를 호출하면 Class 타입으로 리턴받아 정보를 뜯어볼 수 있다.*/
        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

        /* 설명. Class.forName() 메서드를 호출하여 런타임시 로딩하고 그 클래스의 메타정보를 Class 타입으로 반환해준다. */
        try {
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            // Integer 자료형 배열을 로드할 수 있다.
            Class class4_1 = Class.forName("[I");
            System.out.println("class4_1 = " + class4_1);
            Class class4_2 = int[].class;
            System.out.println("class4_2 = " + class4_2);

            // Double 자료형 배열을 로드할 수 있다.
            Class class5 = Class.forName("[D");
            System.out.println("class5 = " + class5);
            Class class6 = double[].class;
            System.out.println("class6 = " + class6);

            // String 자료형 배열을 로드할 수 있다.
            Class class7 = Class.forName("[Ljava.lang.String;");
            System.out.println("class7 = " + class7);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // Java코드로 필드의 정보 얻기
        System.out.println("---------- 목차. 2. 필드 정보 추출 ---------------");
        /* Note. 접근제어자 상관 없이 모두 뜯을 수 있음. */
        Field[] fields = Account.class.getDeclaredFields();

        for(Field field : fields) {

            System.out.println("modifiers : " + Modifier.toString(field.getModifiers()) +
                    ", type : " + field.getType() +
                    ", name : " + field.getName());
        }

        System.out.println("---------- 목차. 3. 생성자 정보를 반환 ---------------");
        Constructor[] constructors = Account.class.getConstructors();

        for(Constructor con : constructors) {

            System.out.println("name : " + con.getName());

            Class[] params = con.getParameterTypes();
            for(Class param : params) {
                System.out.println("paramType : " + param.getTypeName());
            }
        }

        // Java코드로 메서드의 정보 얻기
        System.out.println("---------- 목차. 4. 메소드 정보 추출 ---------------");
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;

        for(Method method : methods) {

            System.out.println(Modifier.toString(method.getModifiers()) + " " +
                    method.getReturnType().getSimpleName() + " " +
                    method.getName());

            if("getBalance".equals(method.getName())) {
                getBalanceMethod = method;
            }
        }

        try {
            /* 설명. invoke 메소드로 메소드를 호출할 수 있다. */
            System.out.println(getBalanceMethod.invoke(((Account) constructors[1].newInstance())));

        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}
