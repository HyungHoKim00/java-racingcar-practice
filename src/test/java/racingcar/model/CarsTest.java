package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private Cars cars;

    @DisplayName("cars 초기화")
    @BeforeEach
    void clearCars() {
        cars = new Cars("pobi,jun");
    }

    @DisplayName("차 전진")
    @Test
    void carGoesForward() {
        for (int i = 0; i < 10_000; i++) {
            cars.tryForward();
        }

        boolean result = cars.makeProgress().contains("-");
        boolean expected = true;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("차 진행 상황 생성")
    @Test
    void makeCarProgress() {
        String progress = cars.makeProgress();

        boolean result = progress.contains("pobi : ")
                && progress.contains("jun : ");
        boolean expected = true;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("우승자 명단 생성")
    @Test
    void makeWinners() {
        String winners = cars.getWinners();

        boolean result = winners.contains("최종 우승자 ")
                && winners.contains("pobi")
                && winners.contains("jun");
        boolean expected = true;

        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("잘못된 차 이름 에러")
    @Test
    void longNameThrowsException() {
        assertThatThrownBy(() -> cars = new Cars("popobi"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
