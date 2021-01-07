import processing.core.PApplet;

public class TryProcessingOOP extends PApplet {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    public static final int MAJOR_AXIS = 15;
    public static final int MINOR_AXIS = 15;
    public static final int NUMBER_OF_BALLS = 4;
    public static final int WHITE_BACKGROUND = 255;
    public static final int X_POSITION = 0;
    public static int INITIAL_BALL_SPEED = 0;

    public static class RollingBall {
        int xPosition;
        int yPosition;
        int ballSpeed;

        public int getxPosition() {
            return xPosition;
        }

        public void setxPosition() {
            this.xPosition += ballSpeed;
        }

        public int getyPosition() {
            return yPosition;
        }

        public RollingBall(int xPosition, int yPosition, int ballSpeed) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.ballSpeed = ballSpeed;
        }
    }

    RollingBall [] balls;

    public static void main(String[] args) {
        PApplet.main("TryProcessingOOP", args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    @Override
    public void setup() {
        background(WHITE_BACKGROUND);
        balls = new RollingBall[NUMBER_OF_BALLS];
        for (int ballIndex = 0; ballIndex < NUMBER_OF_BALLS; ballIndex++) {
            balls[ballIndex] = new RollingBall(X_POSITION, (HEIGHT * (ballIndex+1)) / 5, ++INITIAL_BALL_SPEED);
        }
    }

    @Override
    public void draw() {
        int ballIndex = 0;
        while (ballIndex < NUMBER_OF_BALLS) {
            drawEllipse(balls[ballIndex]);
            ballIndex++;
        }
    }

    public void drawEllipse(RollingBall ball) {
        ellipse(ball.getxPosition(), ball.getyPosition(), MAJOR_AXIS, MINOR_AXIS);
        ball.setxPosition();
    }
}

