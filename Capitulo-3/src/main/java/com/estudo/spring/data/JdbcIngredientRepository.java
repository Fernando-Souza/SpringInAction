package com.estudo.spring.data;

import com.estudo.spring.dominio.Ingredient;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcIngredientRepository implements IngredientRepository {

    
    private JdbcTemplate jdbcTemplante;

    @Autowired
    public JdbcIngredientRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplante = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll() {
        return jdbcTemplante.query("select id, name, type from Ingredient", this::mapRowToIngredient);
    }

    @Override
    public Optional<Ingredient> findById(String id) {
        List<Ingredient> results = jdbcTemplante.query(
                "select id, name, type from Ingredient where id=?", this::mapRowToIngredient, id);
        return results.isEmpty() ? Optional.empty() : Optional.of(results.get(0));
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {
        return new Ingredient(row.getString("id"), 
                row.getString("name"), 
                Ingredient.Type.valueOf(row.getString("type")));

    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        
       jdbcTemplante.update("insert into Ingredient (id,name,type) values(?,?,?)",
               ingredient.getId(),
               ingredient.getName(),
               ingredient.getType().toString());
               
               return ingredient;
    }

}
