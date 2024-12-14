package pe.edu.cibertec.l3_jesus_marcano.dto;

import java.util.Date;

public record CarDto(Integer car_id,
                     String make,
                     String model,
                     String license_plate,
                     String owner_name,
                     Date purchase_date,
                     Integer mileage,
                     String color) {
}
