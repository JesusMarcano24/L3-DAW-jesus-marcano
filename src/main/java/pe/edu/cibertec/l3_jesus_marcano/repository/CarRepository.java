package pe.edu.cibertec.l3_jesus_marcano.repository;

import org.springframework.data.repository.CrudRepository;
import pe.edu.cibertec.l3_jesus_marcano.entity.Car;

public interface CarRepository extends CrudRepository<Car, Integer> {
}
