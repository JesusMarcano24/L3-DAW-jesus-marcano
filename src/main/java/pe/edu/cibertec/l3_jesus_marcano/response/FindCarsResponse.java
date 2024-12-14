package pe.edu.cibertec.l3_jesus_marcano.response;

import pe.edu.cibertec.l3_jesus_marcano.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {
}
