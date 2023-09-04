package net.softsociety.bacs.domain.dto.category;

import lombok.Data;

@Data
public class UpdateCategoryDTO
{
    private int categoryNum;
    private String categoryName;
    private String storeId;
}
