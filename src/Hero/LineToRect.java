package Hero;

public class LineToRect {

    public static boolean isLineIntersectRectangle(double linePointX1,
                                                    double linePointY1,
                                                    double linePointX2,
                                                    double linePointY2,
                                                    double rectangleLeftTopX,
                                                    double rectangleLeftTopY,
                                                    double rectangleRightBottomX,
                                                    double rectangleRightBottomY) {
        double lineHeight = linePointY1 - linePointY2;
        double lineWidth = linePointX2 - linePointX1;
        double t1 = lineHeight * rectangleLeftTopX + lineWidth * rectangleLeftTopY;
        double t2 = lineHeight * rectangleRightBottomX + lineWidth * rectangleRightBottomY;
        double t3 = lineHeight * rectangleLeftTopX + lineWidth * rectangleRightBottomY;
        double t4 = lineHeight * rectangleRightBottomX + lineWidth * rectangleLeftTopY;
        double c = linePointX1 * linePointY2 - linePointX2 * linePointY1;
        if ((t1 + c >= 0 && t2 + c <= 0)
                || (t1 + c <= 0 && t2 + c >= 0)
                || (t3 + c >= 0 && t4 + c <= 0)
                || (t3 + c <= 0 && t4 + c >= 0)) {
            if (rectangleLeftTopX > rectangleRightBottomX) {
                double temp = rectangleLeftTopX;
                rectangleLeftTopX = rectangleRightBottomX;
                rectangleRightBottomX = temp;
            }

            if (rectangleLeftTopY < rectangleRightBottomY) {
                double temp1 = rectangleLeftTopY;
                rectangleLeftTopY = rectangleRightBottomY;
                rectangleRightBottomY = temp1;
            }

            if ((linePointX1 < rectangleLeftTopX && linePointX2 < rectangleLeftTopX)
                    || (linePointX1 > rectangleRightBottomX && linePointX2 > rectangleRightBottomX)
                    || (linePointY1 > rectangleLeftTopY && linePointY2 > rectangleLeftTopY)
                    || (linePointY1 < rectangleRightBottomY && linePointY2 < rectangleRightBottomY)) {
                return false;
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

}
