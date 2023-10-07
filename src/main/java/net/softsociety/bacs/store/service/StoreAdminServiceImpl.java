package net.softsociety.bacs.store.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.order.entity.*;
import net.softsociety.bacs.store.dto.SaleTodayDTO;
import net.softsociety.bacs.order.dto.response.OrderRecipeResponseDTO;
import net.softsociety.bacs.order.dto.response.OrderResponseDTO;
import net.softsociety.bacs.order.dto.response.RecipeOptionResponseDTO;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import net.softsociety.bacs.store.projection.SalesWeekResultProjection;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class StoreAdminServiceImpl implements StoreAdminService {


    private final OrderRepository orderRepository;
    private final StoreRepository storeRepository;
    private final OrderRecipeRepository recipeRepository;
    private final RecipeOptionRepository recipeOptionRepository;

    @Override
    public Optional<Long> saleToday(SaleTodayDTO dto) {
        Store store = storeRepository.findByStoreId(dto.storeId())
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);

        return orderRepository.saleToday(store.getId());
    }

    @Override
    public List<SalesWeekResultProjection> salesWeek(String storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        List<SalesWeekResultProjection> result = orderRepository.salesWeek(store.getId());

        result.forEach(data -> log.debug("------------result:{}", data));
        return result;
    }

    @Override
    public List<OrderResponseDTO> getOrderPendingList(String storeId) {
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        List<OrderResponseDTO> orderResponseDTOList = orderRepository.findAllByStoreAndCancelledIsFalseOrderByOrderDateAsc(store).stream()
                .map(order -> {
                    List<OrderRecipeResponseDTO> orderRecipeResponseDTOList = createOrderRecipeDTOList(order);
                    log.debug("--------orderRecipeResponseDTOList: {}", orderRecipeResponseDTOList);
                    return OrderResponseDTO.builder()
                            .id(order.getId())
                            .orderDate(order.getOrderDate())
                            .toGo(order.isToGo())
                            .cancelled(order.isCancelled())
                            .totalPrice(order.getTotalPrice())
                            .orderRecipes(orderRecipeResponseDTOList)
                            .build();
                })
                .toList();
        log.debug("--------List<OrderResponseDTO>: {}", orderResponseDTOList);
        return orderResponseDTOList;
    }
    private List<OrderRecipeResponseDTO> createOrderRecipeDTOList(Order order) {
        return recipeRepository.findAllByOrder(order).stream()
                .map(orderRecipe -> {
                    List<RecipeOptionResponseDTO> recipeOptionResponseDTOList = createRecipeOptionDTOList(orderRecipe);
                    log.debug("----------recipeOptionResponseDTOList: {}", recipeOptionResponseDTOList);
                    return OrderRecipeResponseDTO.builder()
                            .id(orderRecipe.getId())
                            .menuAmount(orderRecipe.getMenuAmount())
                            .recipeOptions(recipeOptionResponseDTOList)
                            .menu(orderRecipe.getMenu())
                            .recipePrice(orderRecipe.getRecipePrice())
                            .build();
                })
                .toList();
    }

    private List<RecipeOptionResponseDTO> createRecipeOptionDTOList(OrderRecipe orderRecipe) {
        return recipeOptionRepository.findAllByOrderRecipe(orderRecipe).stream()
                .map(recipeOption -> RecipeOptionResponseDTO.builder()
                        .id(recipeOption.getId())
                        .roAmount(recipeOption.getRoAmount())
                        .option(recipeOption.getOption())
                        .build())
                .toList();
    }

}
