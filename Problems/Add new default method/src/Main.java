import java.util.Scanner;

interface Flying {
    // returns height of flying in meters
    int getHeight();

    default int getHeightInKm() {
        return (int) getHeight() / 1000;
    }
}