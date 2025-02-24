package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
/* @Aspect:
 * pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 어노케티션이다.
 * (Aspect = advice + pointcut)
 * */
@Aspect
public class LoggingAspect {

    /* 설명. Joinpoint:
     *  타겟 클래스의 메소드에서 advice를 적용할 수 있는 지점들을 조인포인트(joinpoint)라고 한다.
     *  포인트컷(pointcut)은 여러 조인포인트들에 advice(advice)를 적용할 곳을 지정한 것이다.
     *  해당 조인포인트에서 advice가 동작한다.
     *
     * 설명. 포인트컷 표현식
     *  execution([수식어] 리턴타입 [클래스이름].이름(파라미터)
     *  1. 수식어: public, private 등 수식어를 명시(생략 가능)
     *  2. 리턴 타입: 리턴 타입을 명시 -> 리턴타입이 *이라면 신경안쓴다는 뜻
     *  3. 클래스명(패키지명 포함) 및 메소드 이름: 클래스명과 메소드명을 명시
     *  4. 파라미터(매개변수): 메소드의 파라미터를 명시
     *  5. "*": 1개 이면서 모든 값이 올 수 있음
     *  6. "..": 0개 이상의 모든 값이 올 수 있음
     *  ex1) execution(public Integer com.ohgiraffers.section01.advice.*.*(*))
     *   : com.ohgiraffers.section01.advice 패키지에 속해 있는 바로 다음 하위 클레스에
     *     파라미터가 1개인 모든 메소드이자 접근제어자가 public이고 반환형이 Integer인 경우
     *  ex2) execution(* com.ohgiraffers.section01.advice.annotation..stu*(..))
     *   : com.ohgiraffers.section01.advice 패키지 및 하위 패키지에 속해 있고
     *     이름이 stu로 시작하는 파라미터가 0개 이상인 모든 메소드이며
     *     접근제어자와 반환형은 상관 없음
     *  --------------------------------------------------------------------------------------------------------
     *  공식 홈페이지 설명 : https://docs.spring.io/spring-framework/reference/core/aop/ataspectj/pointcuts.html
     * */
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")    // 리턴타입이 *와일드카드다.
//    @Pointcut("execution(MemberDTO com.ohgiraffers.section01.aop.*Service.*(..))")  // 리턴타입이 MemberDTO가 됐다.
    public void logPointcut() {

    }

    /* 목차. 1. @Before Advice : 대상 메서드가 실행되기 이전에 주입되는(weaving) 어드바이스 */
    // Service.*(..)는 서비스로 끝나는 클래스들 내부의 모든 메서드의 전달인자 상관없이라는 뜻이다.
//    @Before("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")    // pointcut
//    @Before("LoggingAspect.logPointcut()")
    @Before("logPointcut()")
    public void logBefore(JoinPoint joinPoint) {    // 여기 부터 끝까지는 무엇을 할지 정해둔 advice다.

        System.out.println("[Before] 타켓 오브젝트는? : " + joinPoint.getTarget());

        System.out.println("[Before] 타켓 메서드 시그니처는? : " + joinPoint.getSignature());

        /* JoinPoint의 매개변수를 출력 <--- 단, 타겟 메서드의 매개변수가 하나라도 존재한다면 */
        if (joinPoint.getArgs().length > 0) {
            System.out.println("[Before] 타켓 메서드의 매개변수가 있나? : " + joinPoint.getArgs()[0]);
        }
    }

    /* 목차. 2. @After Advice : 대상 메서드가 실행된 이후에 주입되는(weaving) 어드바이스
     * 단, 대상 메서드가 정상 종료되든, 중간에 예외가 발생하든 관계 없이 모두 실행됨.
     * */
    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[After] 타켓 오브젝트는? : " + joinPoint.getTarget());

        System.out.println("[After] 타켓 메서드 시그니처는? : " + joinPoint.getSignature());

        /* JoinPoint의 매개변수를 출력 <--- 단, 타겟 메서드의 매개변수가 하나라도 존재한다면 */
        if (joinPoint.getArgs().length > 0) {
            System.out.println("[After] 타켓 메서드의 매개변수가 있나? : " + joinPoint.getArgs()[0]);
        }
    }

    /* 목차. 3. @AfterReturning Advice : returning 속성에 사용된 이름(returning = "result")과
     * 메서드의 반환형으로 넘어오는 매개변수 이름(Object result)이 일치해야 한다.
     * 또한 기존에 작성하던 JoinPoint 매개변수는 바늗시 첫 번째 매개변수로써 선언해야 한다.
     * */
    @AfterReturning(pointcut = "logPointcut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) {     // 이 친구는 참조할 반환값까지 매개변수에 넣어줘야함.

        System.out.println("[AfterReturning] 반환 값은? : " + result);

        /* AfterReturning 어드바이스는 반환값 자체를 변수로 취급할 수 있으므로 값을 조작할 수도 있다. */
        // result가 최상위 타입인 Object로 되어있어서 Map타입으로 강제형변환
        if(result !=null && result instanceof Map) {
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(222L, "반환값 가동됨~"));
        }
    }

    /* 목차. 4. @AfterThrowing Advice : 타겟 메서드가 정상적으로 종료되기 전, 예외가 발생했을 때 실행되는 어드바이스다.
     * 위에서 보았던 @AfterReturning과 마찬가지ㅗㄹ throwing 속성의 이름과 매개변수의 이름이 동일해야 한다.
     * */
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) {

        System.out.println("[AfterThrowing] 발생한 예외는? : " + exception);
    }

    /* 목차. 5. @Around Advice : 가장 강력한 어드바이스다.
     * 이 advice는 join point를 완전히 장악하기 때문에 앞서 살펴본 4가지 advice 모두
     * 이 around advice 하나로 커버할 수 있다.
     * 심지어 원본 join point를 언제 실행할지, 실행 자체를 할지 안할지,
     * 계속 실행할지 예외를 던질지의 여부까지도 제어할 수 있다.
     * Around advice의 join point 매개변수는 ProceedingJoinPoint로 고정되어 있다.
     * 이는 JoinPoint의 하위 인터페이스로, 원본 join point의 진행 시점을 제어할 수 있다.
     * Join point를 진행하는 호출 자체를 잊어버리는 경우가 종종 발생하기 때문에 사용시 주의해야 하며
     * 최소한의 요건을 충족하면서도 가장 기능이 약한(또는 스코프가 좁은) advice를 채택하는 것이 바람직하다.
     * */
    @Around("logPointcut()")
    public Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        // @Before보다 먼저 동작함
        System.out.println("[Around] before : " + proceedingJoinPoint.getSignature().getName());

        // 타겟 메서드 호출을 진행시킴(본인이 결정함)
        Object result = proceedingJoinPoint.proceed();

        // @After보다 나중에 동작함
        System.out.println("[Around] after : " + proceedingJoinPoint.getSignature().getName());

        // 실행된 타겟 메서드를 반환 (다른 advice가 다시 실행할 수 있도록 반환해주는 것)
        return result;
    }
}
