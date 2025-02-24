package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {

    public static void main(String[] args) {
        /* 설명. Java 리플렉션(Reflection)이란?
         *  Java의 런타임 환경에서 실행 중인 클래스, 메서드, 필드 등의 정보를 동적으로 조회하고 조작할 수 있는 기법을 말한다.
         *  일반적인 용어 자체의 뜻은 '반사'나 '투영'이라는 의미를 가지며, 컴파일된 Java 코드(.class)로부터
         *  클래스의 구조를 분석하여 메서드와 필드 정보를 얻어내거나, 이를 이용해 런타임 중에 동적으로
         *  객체의 동작을 수정할 수 있는 강력한 기능을 제공한다.
         *  리플렉션은 다양한 Java 프레임워크 및 라이브러리에서 사용된다: Spring Framework, MyBatis, Hibernate, Jackson 등.
         *  예를 들어, 스프링에서는 리플렉션을 사용하여 개발자가 등록한 bean을 런타임 시에 애플리케이션 내에서 동적으로 생성하고 사용할 수 있게 한다.
         *  (리플렉션의 사용 예제는 다음 Oracle의 공식 문서를 참고하면 된다: https://docs.oracle.com/javase/tutorial/reflect/)
         *  ------------------------------------------------------------------------------------------------------------------------------------
         *  [주의!] Refletion은 강력한 도구이지만 무분별하게 남용해서는 안 된다.
         *  1. 오버헤드 발생:
         *    - 리플렉션을 사용하면 성능이 저하될 수 있다.
         *    - 런타임에 많은 메타데이터를 처리해야 하므로, 성능에 민감한 애플리케이션에서는 신중히 사용해야 한다.
         *  2. 캡슐화 저해:
         *    - 리플렉션은 private 필드나 메서드에도 접근할 수 있기 때문에, 객체의 캡슐화 원칙을 저해할 수 있다.
         *    - 이는 코드의 안정성과 유지보수성을 떨어뜨릴 수 있다.
         *  ------------------------------------------------------------------------------------------------------------------------------------
         *  리플렉션이 사용되는 주요 사례
         *  1. IoC 컨테이너:
         *    - Spring의 IoC 컨테이너는 리플렉션을 활용하여 빈(Bean)을 동적으로 생성하고 관리한다.
         *    - 이를 통해 클래스의 생성자, 메서드, 필드를 동적으로 분석해 의존성을 주입한 후 객체를 초기화한다.
         *    - 덕분에 개발자는 직접 소스 코드 상에서 객체를 생성하는 구문을 작성하지 않아도 되어 핵심 로직에만 집중 가능하다.
         *  2. AOP(Aspect-Oriented Programming):
         *    - Spring AOP는 리플렉션을 이용해 메서드 호출을 가로채고, 부가 기능을 적용한다.
         *    - AOP는 프록시 객체를 통해 메서드의 메타데이터를 런타임에 분석하여 로깅, 보안, 트랜잭션 관리 등의 부가 기능을 동적으로 추가한다.
         *    - 덕분에 핵심 로직(primary concern)과 부가 기능(cross-cutting concern)을 분리시키는 동시에,
         *      런타임에도 불구하고 부가 기능을 동적으로 유연하게 추가할 수 있다.
         *  3. MyBatis 매퍼: MyBatis는 리플렉션을 통해 SQL 매핑 파일과 자바 객체를 연결한다.
         *  4. log4jdbc: 이 라이브러리는 리플렉션을 사용하여 JDBC 호출을 가로채고 로깅한다.
         */

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
