/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.estudo.spring.dominio;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import lombok.Data;

@Data
public class Taco {
    
     @NotNull
     @Size(min=5,message="Name must be at least 5 characters long")
    private String name;
     @NotNull
     @Size(min=1,message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
