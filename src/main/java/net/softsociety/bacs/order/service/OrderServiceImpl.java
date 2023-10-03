package net.softsociety.bacs.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.menu.entity.menu.Menu;
import net.softsociety.bacs.menu.entity.menuOption.MenuOption;
import net.softsociety.bacs.menu.entity.menuOption.MenuOptionRepository;
import net.softsociety.bacs.menu.entity.menu.MenuRepository;
import net.softsociety.bacs.menu.exception.MenuErrorCode;
import net.softsociety.bacs.order.dto.CreateOrderDTO;
import net.softsociety.bacs.order.dto.RecipeDTO;
import net.softsociety.bacs.order.dto.RecipeOptionDTO;
import net.softsociety.bacs.order.entity.*;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        // 주문 객체 생성
        Order order = Order.builder()
                .store(store)
                .toGo(dto.toGo())
                .build();
        orderRepository.save(order);

        List<OrderRecipe> orderRecipes = dto.recipeDTOList().stream()
                .map(recipeDTO -> createOrderRecipe(recipeDTO, order))
                .collect(Collectors.toList());

        order.setOrderRecipes(orderRecipes);
        order.setTotalPrice(orderRecipes);
        log.debug("-------order: {}", order);
    }



    private OrderRecipe createOrderRecipe(RecipeDTO recipeDTO, Order order) {
        Menu menu = menuRepository.findById(recipeDTO.menu_no())
                .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);

        OrderRecipe orderRecipe = OrderRecipe.builder()
                .menuAmount(recipeDTO.menuAmount())
                .menu(menu)
                .order(order)
                .build();
        recipeRepository.save(orderRecipe);

        List<RecipeOption> recipeOptions = recipeDTO.recipeOptionDTOList().stream()
                        .map(recipeOptionDto -> createRecipeOptions(recipeOptionDto, orderRecipe))
                        .toList();
        recipeOptionRepository.saveAll(recipeOptions);
        orderRecipe.addRecipeOptions(recipeOptions);
        orderRecipe.setRecipePrice(recipeOptions, menu, orderRecipe.getMenuAmount());
        log.debug("-------orderRecipe: {}", orderRecipe);
        log.debug("-------recipeOptions: {}", recipeOptions);

        return orderRecipe;
    }

    private RecipeOption createRecipeOptions(RecipeOptionDTO recipeOptionDTO, OrderRecipe orderRecipe) {
        MenuOption option = menuOptionRepository.findById(recipeOptionDTO.option_no())
                .orElseThrow(MenuErrorCode.MENU_OPTION_NULL::defaultException);

        return RecipeOption.builder()
                .option(option)
                .roAmount(recipeOptionDTO.roAmount())
                .orderRecipe(orderRecipe)
                .build();
    }
//확인후 해야함
    //@Override
   // public List<Order> orderList(String storeId){
     //   List<Order> orderList = orderRepository.findByStoreId(storeId);
       // return orderList;
   // }
}
