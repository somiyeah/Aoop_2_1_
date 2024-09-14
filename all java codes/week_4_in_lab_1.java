public class week_4_in_lab_1 {
    public static void main(String[] args) {
        // Create an instance of GalleryApp
        GalleryApp galleryApp = new GalleryApp();

        // Show a PNG image
        galleryApp.show("image.png");

        // Show a JPG image
        galleryApp.show("image.jpg");
    }
}

interface ImageViewer {
    void show();
}

interface PngShower extends ImageViewer {
    void showPng();
}

interface JpgShower extends ImageViewer {
    void showJpg();
}

class AdvancedImageViewer {
    void showPng() {
        System.out.println("Showing PNG image");
    }

    void showJpg() {
        System.out.println("Showing JPG image");
    }
}

class ImageAdapter implements ImageViewer {
    private AdvancedImageViewer advancedImageViewer;

    public ImageAdapter(AdvancedImageViewer advancedImageViewer) {
        this.advancedImageViewer = advancedImageViewer;
    }

    @Override
    public void show() {
        // Determine the image format based on the filename (you can implement more sophisticated logic)
        String filename = "image.png"; // Replace with the actual filename
        if (filename.endsWith(".png")) {
            advancedImageViewer.showPng();
        } else if (filename.endsWith(".jpg")) {
            advancedImageViewer.showJpg();
        } else {
            System.out.println("Unsupported image format");
        }
    }
}

class GalleryApp {
    private ImageViewer imageViewer;

    public GalleryApp() {
        // Create an instance of ImageAdapter using AdvancedImageViewer
        imageViewer = new ImageAdapter(new AdvancedImageViewer());
    }

    public void show(String filename) {
        imageViewer.show();
    }
}