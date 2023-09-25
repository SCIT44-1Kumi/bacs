package net.softsociety.bacs.menu.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.softsociety.bacs.category.entity.Category;
import net.softsociety.bacs.category.entity.CategoryRepository;
import net.softsociety.bacs.category.exception.CategoryErrorCode;
import net.softsociety.bacs.menu.dto.*;
import net.softsociety.bacs.menu.entity.Menu;
import net.softsociety.bacs.menu.entity.MenuOption;
import net.softsociety.bacs.menu.entity.MenuOptionRepository;
import net.softsociety.bacs.menu.entity.MenuRepository;
import net.softsociety.bacs.menu.exception.MenuErrorCode;
import net.softsociety.bacs.store.entity.Store;
import net.softsociety.bacs.store.entity.StoreRepository;
import net.softsociety.bacs.store.exception.StoreErrorCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

//    private final MenuDAO dao;
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
        Store store = storeRepository.findByStoreId(storeId)
                .orElseThrow(StoreErrorCode.STORE_NULL::defaultException);
        Category category = categoryRepository.findByCategoryNumAndStore(data.categoryNum(), store)
                .orElseThrow(CategoryErrorCode.CATEGORY_NULL::defaultException);

        Menu menu = menuRepository.save(data.menu());
        category.addMenu(menu);
        List<MenuOption> newOptions = menuOptionRepository.saveAll(data.options());
        for(MenuOption option : newOptions) {
            menu.addMenuOption(option);
        }
//
//
//        ArrayList<MenuOption> options = data.options();
//
////        menu.setCategoryNum(data.categoryNum());
////        int n = dao.createMenu(menu);
//        log.debug("=======메뉴=======: {}, {}", n, menu);
//        for(BacsMenuOption option : options) {
//            option.setMenuNum(menu.getMenuNum());
//            log.debug("{}", option);
//        }
//        int m = dao.createOptions(options);
//        return n != 0;
    }

    /**
     * 메뉴 삭제
     *
     * @param storeId
     * @param data
     */
    @Override
    public void deleteMenu(String storeId, DeleteMenuDTO data) {
        Menu menu = menuRepository.findByMenuNum(data.menuNum())
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
        MenuOption menuOption = menuOptionRepository.findByOptionNum(data.optionNum())
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
        Menu menu = menuRepository.findByMenuNum(dto.menuNum())
                .orElseThrow(MenuErrorCode.MENU_NULL::defaultException);
        menu.update(
                dto.menuName(),
                dto.menuPrice(),
                dto.menuImg(),
                dto.menuDesc(),
                dto.category_id()
        );
    }

    /**
     * 메뉴 옵션 수정
     * @param dto
     */
    @Override
    public void updateMenuOption(UpdateMenuOptionDTO dto) {
        MenuOption menuOption = menuOptionRepository.findByOptionNum(dto.optionNum())
                .orElseThrow(MenuErrorCode.MENU_OPTION_NULL::defaultException);
        menuOption.update(
                dto.optionName(),
                dto.optionValue(),
                dto.optionPrice(),
                dto.menu_id()
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
        return menuRepository.findByCategory_id(dto.category());
    }
}
