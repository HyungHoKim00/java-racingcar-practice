package racingcar.view;

public class OutputView {
    public void printCarNamesRequestMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTriesRequestMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printProgressStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printProgress(String progress) {
        System.out.println(progress);
    }

    public void printWinners(String winners) {
        System.out.println();
        System.out.println(winners);
    }
}
