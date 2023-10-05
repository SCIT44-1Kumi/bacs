package net.softsociety.bacs.order.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record OrderResponseDTO(

        Long id,

        int totalPrice,

        boolean toGo,

        boolean cancelled,

        LocalDateTime orderDate,

        List<OrderRecipeResponseDTO> orderRecipes
        
) {
}
