package edu.illinois.cs.cs125.spring2019.mp1.lib;


public class Transform {


    public static RGBAPixel[][] shiftLeftRight(RGBAPixel[][] originalImage,
                                               int amount) {
        if (amount == 0) {
            return originalImage;
        } else if (originalImage == null) {
            return originalImage;
        }
        RGBAPixel[][] shift = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                shift[i][j] = RGBAPixel.getFillValue();
                int originalImageRow = i + amount;
                if (originalImageRow <= (originalImage.length - 1) && originalImageRow >= 0) {
                    shift[i][j] = originalImage[originalImageRow][j];
                }
            }
        }
        return shift;
    }


    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage,
                                           final int amount) {
        return shiftLeftRight(originalImage, -amount);
    }

    public static RGBAPixel[][] shiftLeft(RGBAPixel[][] originalImage,
                                          int amount) {
        return shiftLeftRight(originalImage, amount);
    }


    public static RGBAPixel[][] shiftUpDown(RGBAPixel[][] originalImage,
                                            int amount) {
        if (amount == 0) {
            return originalImage;
        } else if (originalImage == null) {
            return originalImage;
        }
        RGBAPixel[][] shift = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < shift.length; i++) {
            for (int j = 0; j < shift[i].length; j++) {
                shift[i][j] = RGBAPixel.getFillValue();
                int originalImageColoumn = j + amount;
                if (originalImageColoumn >= 0 && originalImageColoumn < originalImage[i].length) {
                    shift[i][j] = originalImage[i][originalImageColoumn];
                }
            }
        }
        return shift;
    }

    public static RGBAPixel[][] shiftUp(RGBAPixel[][] originalImage, int amount) {
        return shiftUpDown(originalImage, amount);
    }

    public static RGBAPixel[][] shiftDown(RGBAPixel[][] originalImage,
                                          int amount) {
        return shiftUpDown(originalImage, -amount);
    }

    //* FLIP FUNCTION *//
    public static RGBAPixel[][] flipVertical(RGBAPixel[][] originalImage) {
        RGBAPixel[][] flip = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                flip[i][j] = originalImage[i][originalImage[i].length - j - 1];
            }
        }
        return flip;
    }


    public static RGBAPixel[][] flipHorizontal(RGBAPixel[][] originalImage) {
        RGBAPixel[][] flip = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                flip[i][j] = originalImage[originalImage.length - i - 1][j];
            }
        }
        return flip;
    }


    //* ROTATE FUNCTION *//

    private static RGBAPixel[][] rotateRightSquareArray(RGBAPixel[][] originalImage, int rowStart, int coloumnStart, int squareLength) {

        RGBAPixel[][] rotate = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                rotate[i][j] = RGBAPixel.getFillValue();
            }
        }
        for (int i = 0; i < squareLength; i++) {
            for (int j = 0; j < squareLength; j++) {
                int originalImageGreenI = squareLength - j - 1;
                int originalImageGreenJ = i;
                rotate[i + rowStart][j + coloumnStart] = originalImage[originalImageGreenI + rowStart][originalImageGreenJ + coloumnStart];
            }
        }
        return rotate;
    }

    public static RGBAPixel[][] rotateLeft(RGBAPixel[][] originalImage) {
        // For Image Left
        int rowLength = originalImage.length;
        int coloumnLength = originalImage[0].length;
        if (rowLength == coloumnLength) {
            return rotateRightSquareArray(originalImage, 0, 0, rowLength);
        } else if (rowLength > coloumnLength) {
            return rotateRightSquareArray(originalImage, (rowLength - coloumnLength) / 2, 0, coloumnLength);
        } else {
            return rotateRightSquareArray(originalImage, 0, (coloumnLength - rowLength) / 2, rowLength);
        }
    }

    private static RGBAPixel[][] rotateLeftSquareArray(RGBAPixel[][] originalImage, int rowStart, int coloumnStart, int squareLength) {

        RGBAPixel[][] rotate = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                rotate[i][j] = RGBAPixel.getFillValue();
            }
        }
        for (int i = 0; i < squareLength; i++) {
            for (int j = 0; j < squareLength; j++) {
                int originalImageGreenI = j;
                int originalImageGreenJ = squareLength - i - 1;
                rotate[i + rowStart][j + coloumnStart] = originalImage[originalImageGreenI + rowStart][originalImageGreenJ + coloumnStart];
            }
        }
        return rotate;
    }


    public static RGBAPixel[][] rotateRight(RGBAPixel[][] originalImage) {
        // For Image Right
        int rowLength = originalImage.length;
        int coloumnLength = originalImage[0].length;
        if (rowLength == coloumnLength) {
            return rotateLeftSquareArray(originalImage, 0, 0, rowLength);
        } else if (rowLength > coloumnLength) {
            return rotateLeftSquareArray(originalImage, (rowLength - coloumnLength) / 2, 0, coloumnLength);
        } else {
            return rotateLeftSquareArray(originalImage, 0, (coloumnLength - rowLength) / 2, rowLength);
        }
    }

    //* SHRINK AND EXPAND FUNCTION *//

    public static RGBAPixel[][] shrinkVertical(RGBAPixel[][] originalImage, int amount) {
        RGBAPixel[][] rotate = new RGBAPixel[originalImage.length][originalImage[0].length];
        return null;
    }

    public static RGBAPixel[][] shrinkHorizontal(RGBAPixel[][] originalImage, int amount) {
        return null;
    }

    public static RGBAPixel[][] expandHorizontal(RGBAPixel[][] originalImage, int amount) {

        RGBAPixel[][] expand = new RGBAPixel[originalImage.length][originalImage[0].length];
        int middle = (originalImage.length / 2) ;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                int distance = i - middle;
                if (distance >= 0) {
                    int groupNo = distance / amount;
                    expand[i][j] = originalImage[groupNo + middle][j];
                } else if (distance < 0) {
                    distance = (-distance) - 1;
                    int groupNo = distance / amount;
                    expand[i][j] = originalImage[middle - groupNo - 1][j];
                }
            }
        }
        return expand;
    }

    public static RGBAPixel[][] expandVertical(RGBAPixel[][] originalImage,
                                               int amount) {
        RGBAPixel[][] expand = new RGBAPixel[originalImage.length][originalImage[0].length];
        int middle = (originalImage[0].length / 2) ;
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                int distance = j - middle;
                if (distance >= 0) {
                    int groupNo = distance / amount;
                    expand[i][j] = originalImage[i][groupNo + middle];
                } else if (distance < 0) {
                    distance = (-distance) - 1;
                    int groupNo = distance / amount;
                    expand[i][j] = originalImage[i][middle - groupNo - 1];
                }
            }
        }
        return expand;
    }


    //* GREEN SCREEN FUNCTION *//
    public static RGBAPixel[][] greenScreen(RGBAPixel[][] originalImage) {
        RGBAPixel[][] green = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                RGBAPixel p = originalImage[i][j];
                if (p.getGreen() == 255 && p.getBlue() == 0 && p.getRed() == 0) {
                    green[i][j] = RGBAPixel.getFillValue();
                } else {
                    green[i][j] = p;
                }
            }
        }
        return green;
    }

}
























