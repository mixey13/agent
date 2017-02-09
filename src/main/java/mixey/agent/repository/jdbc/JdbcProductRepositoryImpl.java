package mixey.agent.repository.jdbc;

import mixey.agent.model.Product;
import mixey.agent.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JdbcProductRepositoryImpl implements ProductRepository {
    private static final BeanPropertyRowMapper<Product> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Product.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleJdbcInsert insertProduct;

    public JdbcProductRepositoryImpl(DataSource dataSource) {
        this.insertProduct = new SimpleJdbcInsert(dataSource)
            .withTableName("products")
            .usingGeneratedKeyColumns("id");
    }

    @Override
    public Product save(Product product) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("id", product.getId())
                .addValue("title", product.getTitle())
                .addValue("description", product.getDescription());

        if(product.isNew()) {
            Number newKey = insertProduct.executeAndReturnKey(map);
            product.setId(newKey.intValue());
        } else {
            namedParameterJdbcTemplate.update("UPDATE products SET title=:title, description=:description WHERE id=:id", map);
        }
        return product;
    }

    @Override
    public boolean delete(Integer id) {
        return jdbcTemplate.update("DELETE FROM products WHERE id=?", id) != 0;
    }

    @Override
    public Product get(Integer id) {
        return jdbcTemplate.queryForObject("SELECT id, title, description FROM products WHERE id=?", ROW_MAPPER, id);
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT * FROM products", ROW_MAPPER);
    }
}
