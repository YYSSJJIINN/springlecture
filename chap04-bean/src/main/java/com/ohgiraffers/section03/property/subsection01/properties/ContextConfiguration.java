package com.ohgiraffers.section03.property.subsection01.properties;

import com.ohgiraffers.common.Beverage;
import com.ohgiraffers.common.Bread;
import com.ohgiraffers.common.Product;
import com.ohgiraffers.common.ShoppingCart;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
/* @PropertySource 어노테이션에 문자열로 읽어들일 properties 파일의 경로를 적어준다.
 * 이 때, resources 폴더 하위부터 작성해주면 되고, 폴더 간 구분은 슬래쉬(/)
 * 또는 역슬래쉬(\\)를 사용한다.
 * 해당 어노테이션을 사용하면 복잡한 try-catch문 없이 간단하게 외부 설정 파일을 읽어들일 수 있다.
 * */
@PropertySource("section03/property/subsection01/properties/product-info.properties")
public class ContextConfiguration {

    // 필드선언 뿐만아니라 초기화까지 해준다.
    // 자주 바뀌는 내용은 소스코드쪽이 아니라 외부설정파일에 빼주는게 바람직하다.
    // product-info.propertyies를 생성했다.
//    private String carpBreadName = "붕어빵";
//    private int carpBreadPrice = 1000;
//    private String milkName = "딸기우유";
//    private int milkPrice = 1700;
//    private int miklCapacity = 350;

    /* 치환자(placeholder) 문법을 이용해 properties 파일에 저장된 key값을 입력하면
     * value 값을 가져올 수 있다.
     * 이 때, 공백을 사용하면 값을 읽어올 수 없으니 공백 문자의 유무에 주의한다.
     * 콜론(:)을 사용하면 key값을 못찾거나 값을 읽어올 수 없는 경우에 대체할 기본값을 설정할 수 있다.
     * */
    @Value("${bread.carpbread.name:빵}")
    private String carpBreadName;
    @Value("${bread.carpbread.price:}")
    private int carpBreadPrice;
    @Value("${beverate.milk.name}")
    private String milkName;
    @Value("${beverate.milk.price}")
    private int milkPrice;
    @Value("${beverate.milk.capacity}")
    private int miklCapacity;

    @Bean
    public Product carpBread() {
        return new Bread(carpBreadName, carpBreadPrice, new Date());
    }

    @Bean
    public Product milk() {
        return new Beverage(milkName, milkPrice, miklCapacity);
    }

    @Bean
    public Product water(
            @Value("${beverate.water.name}")String waterName,
            @Value("${beverate.water.price}")int waterPrice,
            @Value("${beverate.water.capacity}")int waterCapacity
    ) {
        return new Beverage(waterName, waterPrice, waterCapacity);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}