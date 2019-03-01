package edu.illinois.cs.cs125.spring2019.mp1.lib;

public class Transform {
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage,
                                           final int amount) {
        return shiftLeftRight(originalImage, -amount);
    }

    public static RGBAPixel[][] shiftLeft(RGBAPixel[][] originalImage,
                                               int amount) {
        return shiftLeftRight(originalImage, amount);
    }

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

    public static RGBAPixel[][] shiftUp(RGBAPixel[][] originalImage,
                                        int amount) {
        RGBAPixel[][] shift = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < shift.length; i++) {
            for (int j = 0; j < shift[i].length; j++) {
                if (j - amount >= 0) {
                    shift[i][j - amount] = originalImage[i][j];
                }
                if (shift[i][j] == null) {
                    shift[i][j] = RGBAPixel.getFillValue();
                }
            }
        }
       //  RGBAPixel.printArray(shift);
        return shift;
    }

    public static RGBAPixel[][] shiftDown(RGBAPixel[][] originalImage,
                                          int amount) {
        RGBAPixel[][] shift = RGBAPixel.copyArray(originalImage);
        for (int i = 0; i < shift.length; i++) {
            for (int j = 0; j < shift[i].length; j++) {
                if (j + amount <= originalImage[0].length) {
                    shift[i][j + amount] = originalImage[i][j];
                }
                if (shift[i][j] == null) {
                    shift[i][j] = RGBAPixel.getFillValue();
                }
            }
        }
       //  RGBAPixel.printArray(shift);
        return shift;
    }

    public static RGBAPixel[][] rotateRight(RGBAPixel[][] originalImage) {
        return null;
    }

    public static RGBAPixel[][] rotateLeft(RGBAPixel[][] originalImage) {
        return null;

    }

    public static RGBAPixel[][] flipVertical(RGBAPixel[][] originalImage) {
        return null;
    }


    public static RGBAPixel[][] flipHorizontal(RGBAPixel[][] originalImage) {
        return null;
    }



    public static RGBAPixel[][] shrinkVertical(RGBAPixel[][] originalImage,
                                               int amount) {
        return null;
    }

    public static RGBAPixel[][] expandVertical(RGBAPixel[][] originalImage,
                                               int amount)  {
        return null;
    }

    public static RGBAPixel[][] shrinkHorizontal(RGBAPixel[][] originalImage,
                                                 int amount) {
        return null;
    }

    public static RGBAPixel[][] expandHorizontal(RGBAPixel[][] originalImage,
                                                 int amount) {
        return null;
    }

    public static RGBAPixel[][] greenScreen(RGBAPixel[][] originalImage) {
        return null;
    }

}






















