package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class InOutProcessorTest extends NSTest {
    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    void numericCheck() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("aaa","가나다","1ㅠ4");
            verify("[ERROR] 숫자를 입력하세요","[ERROR] 숫자를 입력하세요","[ERROR] 숫자를 입력하세요");
        }
    }

    @Test
    void lengthCheck() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("1","12","1234");
            verify("[ERROR] 세 자리 숫자를 입력하세요","[ERROR] 세 자리 숫자를 입력하세요","[ERROR] 세 자리 숫자를 입력하세요");
        }
    }

    @Test
    void duplicationCheck() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("111","112","122","131");
            verify("[ERROR] 서로 다른 숫자를 입력하세요","[ERROR] 서로 다른 숫자를 입력하세요"
                    ,"[ERROR] 서로 다른 숫자를 입력하세요","[ERROR] 서로 다른 숫자를 입력하세요");
        }
    }

    @Test
    void restartCheck() {
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1, 3, 5);
            running("135","ㅁ","a","3");
            verify("3스트라이크", "게임 끝", "종료하려면 2를 입력하세요", "종료하려면 2를 입력하세요", "종료하려면 2를 입력하세요", "종료하려면 2를 입력하세요");
        }
    }

    @AfterEach
    void tearDown() {
        outputStandard();
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
