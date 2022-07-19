import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BouncingBallShould {

    //Three conditions must be met for a valid experiment:
    //    Float parameter "h" in meters must be greater than 0
    //    Float parameter "bounce" must be greater than 0 and less than 1
    //    Float parameter "window" must be less than h.
    @Test
    void all_parameters_must_be_positive() {
        double h = 0;
        double bounce = 0;
        double window = 0;
        final BouncingBall ball = new BouncingBall(h,bounce,window);
        assertThat(ball.bouncingBall()).isEqualTo(-1);
    }

    @Test
    void the_bounce_parameter_must_be_greater_than_0_and_less_than_1() {
        double h = 1;
        double bounce = 1.5;
        double window = 3;
        final BouncingBall ball = new BouncingBall(h,bounce,window);
        assertThat(ball.bouncingBall()).isEqualTo(-1);
    }

    @Test
    void calculate_bounce() {
        assertThat(new BouncingBall(3.0,0.66,1.5).bouncingBall()).isEqualTo(3);
        assertThat(new BouncingBall(30.0,0.66,1.5).bouncingBall()).isEqualTo(15);
    }
}
