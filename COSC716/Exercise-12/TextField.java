public class TextField implements Widget {
    private int width;
    private int height;

    public TextField(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println("This is a TextField with width: " + width + " and height: " + height);
    }
}
