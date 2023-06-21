
package com.estudo.spring.dominio;

import com.estudo.spring.data.IngredientRef;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Taco {
    
    private long id;
    private Date createdAt = new Date();    
    @NotNull
     @Size(min=5,message="Name must be at least 5 characters long")
    private String name;
    
     @Size(min=1,message="You must choose at least 1 ingredient")
    private List<IngredientRef> ingredientsRef= new ArrayList<>();
    
     public void addIngredient(Ingredient ingredient){
         this.ingredientsRef.add(new IngredientRef(ingredient.getId()));
     }
}
