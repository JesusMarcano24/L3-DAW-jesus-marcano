package pe.edu.cibertec.l3_jesus_marcano.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.l3_jesus_marcano.dto.CarDetailDto;
import pe.edu.cibertec.l3_jesus_marcano.dto.CarDto;
import pe.edu.cibertec.l3_jesus_marcano.response.*;
import pe.edu.cibertec.l3_jesus_marcano.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("manage-car")
public class ManageApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindCarsResponse findCars(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDto> optional = manageService.getAllCarsById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDto carDto = optional.get();
                    return new FindCarsResponse("01", "", List.of(carDto));
                } else {
                    return new FindCarsResponse("02", "Car not found", null);
                }
            } else {
                List<CarDto> cars = manageService.getAllCars();
                if (!cars.isEmpty()) {
                    return new FindCarsResponse("01", "", cars);
                } else {
                    return new FindCarsResponse("03", "Car list not found", cars);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarsResponse("99", "Service not found", null);
        }
    }

    @GetMapping("/detail")
    public FindCarByIdResponse findCarById(@RequestParam(value = "id", defaultValue = "0") String id) {
        try {
            if (Integer.parseInt(id) > 0) {
                Optional<CarDetailDto> optional = manageService.getCarById(Integer.parseInt(id));
                if (optional.isPresent()) {
                    CarDetailDto carDetailDto = optional.get();
                    return new FindCarByIdResponse("01", "", carDetailDto);
                } else {
                    return new FindCarByIdResponse("02", "Car not found", null);
                }
            } else {
                return new FindCarByIdResponse("03", "Incorrect Parameter", null);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return new FindCarByIdResponse("99", "Service not found", null);
        }
    }

    @PostMapping("/update")
    public UpdateCarResponse updateCar(@RequestBody CarDto carDto) {
        try {
            if (manageService.updateCar(carDto)) {
                return new UpdateCarResponse("01", "");
            } else {
                return new UpdateCarResponse("02", "Car couldn't be updated");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "Service not found");
        }
    }

    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarDetailDto carDetailDto) {
        try {
            if (manageService.addCar(carDetailDto)) {
                return new CreateCarResponse("01", "");
            } else {
                return new CreateCarResponse("02", "Car couldn't be created");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "Service not found");
        }
    }

    @DeleteMapping("/delete")
    public DeleteCarResponse deleteCar(@RequestParam(value = "car_id", defaultValue = "0") String cardId) {
        try {
            if (Integer.parseInt(cardId) > 0) {
                if (manageService.deleteCarById(Integer.parseInt(cardId))) {
                    return new DeleteCarResponse("01", "");
                } else {
                    return new DeleteCarResponse("02", "Car couldn't be deleted");
                }
            } else {
                return new DeleteCarResponse("03", "Incorrect Parameter");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "Service not found");
        }
    }
}
