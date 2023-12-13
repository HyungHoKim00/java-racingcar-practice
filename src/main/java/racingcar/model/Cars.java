package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cars {
    private static final String FORWARD_MARK = "-";
    private static final String INVALID_CAR_NAME = "[ERROR] 차 이름 오류";
    private static final int INVALID_FORWARD_AMOUNT = -1;
    private static final int FORWARD_CONDITION = 4;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private final Map<String, Integer> cars;

    public Cars(String carNames) {
        this.cars = new HashMap<>();
        makeValidatedCars(carNames);
    }

    public void tryForward() {
        cars.forEach((key, value) -> {
            if (isForward()) {
                cars.replace(key, value + 1);
            }
        });
    }

    public String makeProgress() {
        StringBuilder progress = new StringBuilder();
        cars.forEach(
                (key, value) -> progress.append(key).append(" : ").append(FORWARD_MARK.repeat(value)).append("\n"));
        return progress.toString();
    }

    public String getWinners() {
        int max = cars.values().stream()
                .max(Integer::compareTo)
                .orElse(INVALID_FORWARD_AMOUNT);
        List<String> winnerNames = cars.keySet().stream()
                .filter(key -> cars.get(key) == max)
                .toList();
        StringBuilder winners = new StringBuilder("최종 우승자 : ");
        winnerNames.forEach(winnerName -> winners.append(winnerName).append(","));
        return winners.substring(0, winners.length() - 1);
    }

    private boolean isForward() {
        return Randoms.pickNumberInRange(0, 9) >= FORWARD_CONDITION;
    }

    private void makeValidatedCars(String input) {
        String[] carNames = input.split(",");
        validateCarNames(carNames);
        Arrays.stream(carNames).forEach(carName -> cars.put(carName, 0));
    }

    private void validateCarNames(String[] carNames) {
        if (carNames[0].isEmpty()) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
        if (invalidCarName(carNames)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME);
        }
    }

    private static boolean invalidCarName(String[] carNames) {
        return Arrays.stream(carNames).anyMatch(carName -> carName.length() > MAX_CAR_NAME_LENGTH);
    }
}
