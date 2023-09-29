package net.softsociety.bacs.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.menu.entity.menu.Menu;
import net.softsociety.bacs.menu.entity.menuOption.MenuOption;
import net.softsociety.bacs.menu.entity.menuOption.MenuOptionRepository;
import net.softsociety.bacs.menu.entity.menu.MenuRepository;
import net.softsociety.bacs.menu.exception.MenuErrorCode;
import net.softsociety.bacs.order.dto.CreateOrderDTO;
import net.softsociety.bacs.order.entity.*;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final StoreRepository storeRepository;
    private final OrderRepository orderRepository;
    private final OrderRecipeRepository recipeRepository;
    private final RecipeOptionRepository recipeOptionRepository;
    private final MenuRepository menuRepository;
    private final MenuOptionRepository menuOptionRepository;

    @Override
    public void createOrder(String storeId, CreateOrderDTO dto) {
        // 매장 정보 조회
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        // 주문 객체 임시생성
        Order order = Order.builder()
                .store(store)
                .toGo(dto.toGo())
                .build();
        // 주문상품 객체 생성(멀티 쓰레드로 병렬처리)
        List<OrderRecipe> orderRecipes = dto.recipeDTOList().parallelStream()
                .map(recipeDTO -> {
                    // 메뉴 정보 조회
                    Menu menu = menuRepository.findById(recipeDTO.menu_no())
                            .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);
                    // 메뉴상품 객체 임시생성
                    OrderRecipe orderRecipe = OrderRecipe.builder()
                            .menu(menu)
                            .menuAmount(recipeDTO.menuAmount())
                            .build();

                    // 메뉴상품 옵션 객체 병렬 처리로 생성
                    List<RecipeOption> recipeOptions = recipeDTO.recipeOptionDTOList().parallelStream()
                            .map(recipeOptionDto -> {
                                // 메뉴 옵션 정보 조회
                                MenuOption menuOption = menuOptionRepository.findById(recipeOptionDto.option_no())
                                        .orElseThrow(MenuErrorCode.MENU_OPTION_NULL::defaultException);
                                // 주문 상품 옵션 객체 생성
                                RecipeOption recipeOption =  RecipeOption.builder()
                                        .option(menuOption)
                                        .roAmount(recipeOptionDto.roAmount())
                                        .roPrice(menuOption.getOptionPrice() * recipeOptionDto.roAmount()) // 개별 옵션 가격 * 옵션 수량
                                        .orderRecipe(orderRecipe)
                                        .build();
                                // 주문 상품에 주문상품옵션 객체 추가
                                orderRecipe.addRecipeOption(recipeOption);
                                // 주문 상품 옵션 스트림객체로 반환
                                return recipeOption;
                            })
                            // List객체로 변환
                            .toList();
                    // saveAll() 로 주문상품옵션을 List로 받아 db에 insert
                    recipeOptionRepository.saveAll(recipeOptions);
                    // 주문 상품에 옵션 가격을 포함한 가격 값 초기화
                    orderRecipe.setRecipePrice(recipeOptions);
                    // 주문 상품에 주문 정보 초기화
                    orderRecipe.setOrder(order);
                    // 주문 상품 스트림객체로 반환
                    return orderRecipe;
                })
                // 주문상품 List로 변환
                .toList();
        // 주문 상품 가격을 포함한 총합 가격 값 초기화
        order.setTotalPrice(orderRecipes);
        // saveAll() 로 주문 상품 리스트를 db에 insert
        recipeRepository.saveAll(orderRecipes);

        // 주문 객체를 db에 insert
        orderRepository.save(order);
    }
}
