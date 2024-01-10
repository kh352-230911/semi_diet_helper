package com.sh.diet.food.model.service;

import com.sh.diet.food.model.entity.FoodData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FoodDataServiceTest {

    FoodDataService foodDataService;

    @BeforeEach
    public void beforeEach() {
        this.foodDataService = new FoodDataService();
    }

    @DisplayName("MemberService객체는 null이 아니다.")
    @Test
    public void test1(){
        assertThat(foodDataService).isNotNull();
    }

    @DisplayName("존재하는 음식이 정상적으로 조회된다.")
    @Test
    public void test2(){
        String foodNo = "F1";
        FoodData foodData = foodDataService.findByFoodNo(foodNo);
        System.out.println(foodData);
        // 객체
        assertThat(foodData).isNotNull();
        // 필드
        assertThat(foodData.getName()).isNotNull();
        assertThat(foodData.getFoodNo()).isNotNull();
        assertThat(foodData.getKcal()).isNotZero();
        assertThat(foodData.getCarbo()).isNotZero();

    }

    @DisplayName("모든 음식을 조회할 수 있다")
    @Test
    public void test3() {
        List<FoodData> foodDatas = foodDataService.findAll();
        assertThat(foodDatas)
                .isNotNull()
                .isNotEmpty();
        foodDatas.forEach((foodData) -> {
            System.out.println(foodData);
            assertThat(foodData.getFoodNo()).isNotNull();
            assertThat(foodData.getKcal()).isNotZero();
            assertThat(foodData.getName()).isNotNull();
            assertThat(foodData.getProt()).isNotZero();
        });
    }

    @Disabled
    @DisplayName("음식추가")
    @Test
    void test4() {
        FoodData foodData = new FoodData(null, "테스트음식",100, 5, 10, 20);
        int result = foodDataService.insertFoodData(foodData);
        assertThat(result).isEqualTo(1);

    }

    @Disabled
    @DisplayName("음식 수정")
    @Test
    void test5() {
        FoodData foodData = foodDataService.findByFoodNo("F21");
        foodData.setName("테스트수정");
        int result = foodDataService.updateFoodData(foodData);
        assertThat(result).isEqualTo(1);
    }
    @DisplayName("음식 삭제")
    @Test
    void test6() {
        String foodNo = "F21";
        FoodData foodData = foodDataService.findByFoodNo(foodNo);
        assertThat(foodData).isNotNull();

        int result = foodDataService.deleteFoodData(foodNo);
        assertThat(result).isEqualTo(1);

        FoodData _foodData = foodDataService.findByFoodNo(foodNo);
        assertThat(_foodData).isNull();
    }


}
