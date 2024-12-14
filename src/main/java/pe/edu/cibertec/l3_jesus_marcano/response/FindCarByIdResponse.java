package pe.edu.cibertec.l3_jesus_marcano.response;

import pe.edu.cibertec.l3_jesus_marcano.dto.CarDetailDto;

public record FindCarByIdResponse(String code,
                                  String error,
                                  CarDetailDto user) {
}
