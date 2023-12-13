package racingcar.controller;

import racingcar.model.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {
    private final InputView inputView;
    private final OutputView outputView;
    private Cars cars;
    private int tries;

    public CarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        this.cars = validateCars();
        this.tries = validateTries();
        outputView.printProgressStartMessage();
        for (int i = 0; i < tries; i++) {
            race();
        }
        outputView.printWinners(cars.getWinners());
    }

    private void race() {
        cars.tryForward();
        outputView.printProgress(cars.makeProgress());
    }


    private Cars validateCars() {
        outputView.printCarNamesRequestMessage();
        String carNames;
        while (true) {
            try {
                carNames = inputView.readCarNames();
                return new Cars(carNames);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateTries() {
        outputView.printTriesRequestMessage();
        int tries;
        while (true) {
            try {
                tries = inputView.readTries();
                return tries;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
