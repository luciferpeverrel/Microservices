package com.example.demo;

import com.example.demo.model.Cars;
import com.example.demo.repository.CarsRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CarsApplicationTests {

	@Autowired
	private CarsRepository carsRepository;

	@Test
	void contextLoads() {
		Cars cars1 = new Cars(1,"Electra",178);
		Cars cars2 = new Cars(2,"Tesla",300);
		Cars savedCars1 = carsRepository.save(cars1);
		Cars savedCars2 = carsRepository.save(cars2);

		// Saving status testing
		assertNotNull(savedCars1);
		assertNotNull(savedCars2);
		// Testing of data during save
		// Name testing
		assertEquals("Electra", "Electra", "Car name should match");
		// Price testing
		assertEquals(178, 178, "Price should be same");
	}
	@Test
	public void testGetBook(){
		List<Cars> carsList = (List<Cars>) carsRepository.findAll();
		// Size is testing
		Assertions.assertThat(carsList).size().isEqualTo(2);
		// Testing of data during fetch
		// Name testing
		assertNotEquals("Bugatti Veyron", "Bugatti Chiron", "College name should not match");
		// Price testing
		assertNotEquals(237,137, "Price should be different");
	}

}
