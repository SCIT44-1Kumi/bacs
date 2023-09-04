package net.softsociety.bacs.domain.dto.category;

import lombok.Data;

@Data
public class DeleteCategoryDTO {
    private int categoryNum;
    private String storeId;
}
