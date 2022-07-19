import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BouncingBallShould {

    @Test
    void return_negative_one_when_height_parameter_less_than_zero() {
        final BouncingBall ball = new BouncingBall(0, 0.06, 1.5);
        assertThat(ball.bouncingBall()).isEqualTo(-1);
    }

    @Test
    void return_negative_one_when_bounce_less_than_0_and_greater_than_1() {
        final BouncingBall ball = new BouncingBall(1, 5, 3);
        assertThat(ball.bouncingBall()).isEqualTo(-1);
    }

    @Test
    void return_negative_one_when_Window_parameter_greater_than_height() {
        final BouncingBall ball = new BouncingBall(1, 0.66, 3);
        assertThat(ball.bouncingBall()).isEqualTo(-1);
    }

    @Test
    void calculate_bounce() {
        assertThat(new BouncingBall(3.0,0.66,1.5).bouncingBall()).isEqualTo(3);
        assertThat(new BouncingBall(30.0,0.66,1.5).bouncingBall()).isEqualTo(15);
    }
}
