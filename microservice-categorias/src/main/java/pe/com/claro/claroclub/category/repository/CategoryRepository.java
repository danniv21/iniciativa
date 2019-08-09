package pe.com.claro.claroclub.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.com.claro.claroclub.category.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	  @Query("SELECT c FROM Category c WHERE c.enable = ?1 ORDER BY c.order_cat")
	  List<Category> findByEnable(int enable);

	
}
