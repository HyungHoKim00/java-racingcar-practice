package racingcar;

import racingcar.controller.CarController;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        CarController controller = new CarController(new InputView(), new OutputView());
        controller.run();
    }
}
