package pe.com.claro.claroclub.departamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pe.com.claro.claroclub.departamento.entity.Department;


@Repository
@Transactional
public interface CuponDepartamentoRepository extends JpaRepository<Department, Long> {
	
	@Query("SELECT cs.store.department FROM CouponStore cs WHERE cs.coupon.expiration_date >= now() GROUP BY cs.store.department ORDER BY cs.store.department.name ASC")
	List<Department> findAllDepartments();
	
}
