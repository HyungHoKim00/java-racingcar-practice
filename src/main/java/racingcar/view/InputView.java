package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String POSITIVE_INTEGER_PATTERN = "^[1-9]\\d*$";
    private static final String ERR_MSG_NOT_POSITIVE_INTEGER = "입력이 양의 정수가 아닙니다.";

    public String carName() {
        return Console.readLine();
    }

}
