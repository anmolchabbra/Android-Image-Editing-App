package edu.illinois.cs.cs125.spring2019.mp1.lib;

public class Transform {
    public static RGBAPixel[][] shiftRight(final RGBAPixel[][] originalImage,
                                           final int amount) {
      //  RGBAPixel[][] shift = new RGBAPixel[originalImage.length][originalImage[0].length];
        RGBAPixel[][] shift = RGBAPixel.copyArray(originalImage);
        if (amount == 0) {
            return originalImage;
        } else if (amount < 0) {
            return null;
        } else if (originalImage == null) {
            return originalImage;
        } else {
            for (int i = 0; i < originalImage.length; i++) {
                for (int j = 0; j < originalImage[i].length; j++) {
                    shift[i][j] = RGBAPixel.getFillValue();
                    if (i + amount <= (originalImage.length - 1)) {
                        shift[i + amount][j] = originalImage[i][j];
                    }

                }
            }
            RGBAPixel.printArray(shift);
            return shift;
        }
    }

    public static RGBAPixel[][] shiftLeft(RGBAPixel[][] originalImage,
                                          int amount) {
        RGBAPixel[][] shift = RGBAPixel.copyArray(originalImage);
        for (int i = 0; i < shift.length; i++) {
            for (int j = 0; j < shift[i].length; j++) {
                if (i - amount >= 0) {
                    shift[i - amount][j] = originalImage[i][j];
                }
                if (shift[i][j] == null) {
                    shift[i][j] = RGBAPixel.getFillValue();
                }
            }
        }
        // RGBAPixel.printArray(shift);
        return shift;
    }

    public static RGBAPixel[][] shiftUp(RGBAPixel[][] originalImage,
                                        int amount) {
        RGBAPixel[][] shift = RGBAPixel.copyArray(originalImage);
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
        RGBAPixel[][] rotate = RGBAPixel.copyArray(originalImage);
        int i;
        int j;
          if (rotate.length == rotate[0].length) {
              for (i = 0; i < rotate.length; i++) {
                  for (int j = 0; j < rotate[i].length; j++) { 
                      rotate[j][i] = originalImage[i][j];
                      RGBAPixel[][] transpose = RGBAPixel.copyArray(rotate);
                      rotate[rotate.length - i - 1][j] = transpose[i][j];
                  }
              }
          } else {
                if (rotate.length > rotate[j].length) {
                    rotate[0][j] = RGBAPixel.getFillValue();
                    rotate[rotate.length - 1][j] = RGBAPixel.getFillValue();
                    if (i > 0 && i < rotate.length - 1) {
                        rotate[j][i] = originalImage[i][j];
                        RGBAPixel[][] transpose = RGBAPixel.copyArray(rotate);
                        rotate[rotate.length - i - 1][j] = transpose[i][j];
                    }
                } else {
                    rotate[i][1] = RGBAPixel.getFillValue();
                    rotate[i][rotate[j].length - 1] = RGBAPixel.getFillValue();
                    if (j > 0 && j < rotate.length - 1) {
                        rotate[j][i] = originalImage[i][j];
                        RGBAPixel[][] transpose = RGBAPixel.copyArray(rotate);
                        rotate[rotate.length - i - 1][j] = transpose[i][j];
                    }
                }
    }
        RGBAPixel.printArray(rotate);
        return rotate;
                }

    public static RGBAPixel[][] rotateLeft(RGBAPixel[][] originalImage) {
        RGBAPixel[][] rotate = RGBAPixel.copyArray(originalImage);
        if (rotate.length == rotate[0].length) {
            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    rotate[j][i] = originalImage[i][j];
                    RGBAPixel[][] transpose = RGBAPixel.copyArray(rotate);
                    rotate[j][rotate.length - i - 1] = transpose[i][j];
                }
            }
        } else if (rotate.length > rotate[0].length) {
            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    rotate[0][j] = RGBAPixel.getFillValue();
                    rotate[rotate.length - 1][j] = RGBAPixel.getFillValue();
                    if (i > 0 && i < rotate.length - 1) {
                        rotate[j][i] = originalImage[i][j];
                        RGBAPixel[][] transpose = RGBAPixel.copyArray(rotate);
                        rotate[i][rotate.length - i - 1] = transpose[i][j];
                    }
                }
            }
        } else {
            for (int i = 0; i < rotate.length; i++) {
                for (int j = 0; j < rotate[i].length; j++) {
                    rotate[i][1] = RGBAPixel.getFillValue();
                    rotate[i][rotate[j].length - 1] = RGBAPixel.getFillValue();
                    if (j > 0 && j < rotate.length - 1) {
                        rotate[j][i] = originalImage[i][j];
                        RGBAPixel[][] transpose = RGBAPixel.copyArray(rotate);
                        rotate[i][rotate.length - i - 1] = transpose[i][j];
                    }
                }
            }
        }
        // RGBAPixel.printArray(rotate);
        return rotate;
    }

    public static RGBAPixel[][] flipVertical(RGBAPixel[][] originalImage) {
       // RGBAPixel[][] flip = new RGBAPixel[originalImage.length][originalImage[0].length];
        RGBAPixel[][] flip = RGBAPixel.copyArray(originalImage);
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                flip[i][flip[0].length - j - 1] = originalImage[i][j];
            }
        }
        return flip;
    }


    public static RGBAPixel[][] flipHorizontal(RGBAPixel[][] originalImage) {
        RGBAPixel[][] flip = new RGBAPixel[originalImage.length][originalImage[0].length];
        for (int i = 0; i < originalImage.length; i++) {
            for (int j = 0; j < originalImage[i].length; j++) {
                flip[flip.length - i - 1][j] = originalImage[i][j];
            }
        }
        return flip;
    }
}






















