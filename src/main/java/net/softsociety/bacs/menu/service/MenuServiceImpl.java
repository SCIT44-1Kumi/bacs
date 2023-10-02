package net.softsociety.bacs.menu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.category.entity.CategoryRepository;
import net.softsociety.bacs.category.exception.CategoryErrorCode;
import net.softsociety.bacs.menu.dto.*;
import net.softsociety.bacs.menu.entity.menu.Menu;
import net.softsociety.bacs.menu.entity.menuOption.MenuOption;
import net.softsociety.bacs.menu.entity.menuOption.MenuOptionRepository;
import net.softsociety.bacs.menu.entity.menu.MenuRepository;
import net.softsociety.bacs.menu.exception.MenuErrorCode;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
@Transactional
public class MenuServiceImpl implements MenuService {

    private final StoreRepository storeRepository;
    private final CategoryRepository categoryRepository;
    private final MenuRepository menuRepository;
    private final MenuOptionRepository menuOptionRepository;

    /**
     * @param storeId
     * @param data    생성할 메뉴객체, 메뉴와 함션 생성할 메뉴 옵션 배열
     */
    @Override
    public void createMenu(String storeId, InsertMenuDTO data) {
        // 매장 확인
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        // 카테고리 확인
        Category category = categoryRepository.findByIdAndStore(data.categoryNo(), store)
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);

        //메뉴 객체 생성
        Menu menu = Menu.builder()
                .menuName(data.menuName())
                .menuPrice(data.menuPrice())
                .menuImg(data.menuImg())
                .menuDesc(data.menuDesc())
                .category(category)
                .build();

        // DB 저장
        menuRepository.save(menu);
        log.debug("------menu: {}", menu.getId());
        category.addMenu(menu); // 카테고리에 메뉴객체 추가

        // 메뉴 옵션 객체를 리스트로 생성
        // stream()사용해서 개별작업
        List<MenuOption> options = data.options().stream()
                // 메뉴 옵션객체를 반복적으로 생성.
            .map(optionDto -> MenuOption.builder()
                    .optionName(optionDto.optionName())
                    .optionValue(optionDto.optionValue())
                    .optionPrice(optionDto.optionPrice())
                    .menu(menu)
                    .build())
                // 만들어진 메뉴 객체를 모아서 List<MenuOption>으로 만들어줌
            .collect(Collectors.toList());
        log.debug("---------options: {}", options);
        // 리스트를 통째로 넘겨서 DB에 저장
        menuOptionRepository.saveAll(options);
        menu.addMenuOptions(options); // 메뉴에 메뉴 옵션 저장.
    }

    /**
     * 메뉴 삭제
     *
     * @param storeId
     * @param data
     */
    @Override
    public void deleteMenu(String storeId, DeleteMenuDTO data) {
        Menu menu = menuRepository.findById(data.menuNo())
                        .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);
        menuRepository.delete(menu);
    }

    /**
     * 메뉴 옵션 삭제
     *
     * @param data
     */
    @Override
    public void deleteMenuOption(DeleteMenuOptionDTO data) {
        MenuOption menuOption = menuOptionRepository.findById(data.optionNo())
                .orElseThrow(MenuErrorCode.MENU_OPTION_NULL::defaultException);
        menuOptionRepository.delete(menuOption);
    }

    /**
     * 메뉴 수정
     *
     * @param storeId
     * @param dto
     */
    @Override
    public void updateMenu(String storeId, UpdateMenuDTO dto) {
        Menu menu = menuRepository.findById(dto.menuNo())
                .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);
        menu.update(
                dto.menuName(),
                dto.menuPrice(),
                dto.menuImg(),
                dto.menuDesc(),
                dto.category()
        );
    }

    /**
     * 메뉴 옵션 수정
     * @param dto
     */
    @Override
    public void updateMenuOption(UpdateMenuOptionDTO dto) {
        MenuOption menuOption = menuOptionRepository.findById(dto.optionNo())
                .orElseThrow(MenuErrorCode.MENU_OPTION_NULL::defaultException);
        menuOption.update(
                dto.optionName(),
                dto.optionValue(),
                dto.optionPrice(),
                dto.menu()
        );
    }


    /**
     * 카테고리별 메뉴 리스트
     * @param storeId
     * @param dto
     * @return List<Menu>
     */
    @Override
    public List<Menu> selectMenuList(String storeId, GetMenusDTO dto) {
        return menuRepository.findAllByCategory(dto.category());
    }
}
