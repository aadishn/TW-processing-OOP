import processing.core.PApplet;

public class TryProcessingOOP extends PApplet {
    public static final int WIDTH = 700;
    public static final int HEIGHT = 700;
    public static final int majorAxis = 15;
    public static final int minorAxis = 15;
    public static final int numberOfBalls = 4;
    public static final int whiteBackground = 255;
    public static int ballSpeed = 0;

    public static class RollingBall {
        int xPosition;
        int yPosition;
        int ballSpeed;

        public RollingBall(int xPosition, int yPosition, int ballSpeed) {
            this.xPosition = xPosition;
            this.yPosition = yPosition;
            this.ballSpeed = ballSpeed;
        }
    }

    RollingBall [] Balls;

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
        background(whiteBackground);
        Balls = new RollingBall[numberOfBalls];
        for (int ballIndex = 0; ballIndex < numberOfBalls; ballIndex++) {
            Balls[ballIndex] = new RollingBall(0, (HEIGHT * (ballIndex+1)) / 5, ++ballSpeed);
        }
    }

    @Override
    public void draw() {
        int ballIndex = 0;
        while (ballIndex < numberOfBalls) {
            drawingEllipse(Balls[ballIndex]);
            ballIndex++;
        }
    }

    public void drawingEllipse(RollingBall ball) {
        ellipse(ball.xPosition, ball.yPosition, majorAxis, minorAxis);
        ball.xPosition += ball.ballSpeed;
    }
}

