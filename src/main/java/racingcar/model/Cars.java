package racingcar.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cars {
    private final Map<String, Integer> cars;

    public Cars(String carNames) {
        this.cars = new HashMap<>();
        makeValidatedCars(carNames);
    }

    private void makeValidatedCars(String input) {
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        Arrays.stream(carNames).forEach(carName -> cars.put(carName, 0));
    }

    private void validateCarNames(String[] carNames) {
        if (carNames[0].isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (invalidCarName(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean invalidCarName(String[] carNames) {
        return Arrays.stream(carNames).anyMatch(carName -> carName.length() > 5);
    }
}
