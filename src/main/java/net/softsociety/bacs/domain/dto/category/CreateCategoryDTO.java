package net.softsociety.bacs.domain.dto.category;

import lombok.Data;

@Data
public class CreateCategoryDTO
{
    private String categoryName;
    private String storeId;
}
