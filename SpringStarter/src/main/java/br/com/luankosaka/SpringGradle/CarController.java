package br.com.luankosaka.SpringGradle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("cars")
public class CarController {
    @Autowired
    private CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus(code = HttpStatus.CREATED)
    public Car create(@RequestBody Car car) {
        return this.carRepository.save(car);
    }

    @GetMapping
    public List<Car> findAll() {
        return this.carRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Car> findById(@PathVariable("id") Long id) {
        return this.carRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void removeById(@PathVariable("id") Long id) {
        this.carRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateById(@PathVariable("id") Long id, @RequestBody Car car) {
        this.carRepository.findById(id).map(record -> {
            record.setName(car.getName());
            record.setColor(car.getColor());
            record.setYear(car.getYear());
            Car updated = this.carRepository.save(record);
            return updated;
        });
    }
}
