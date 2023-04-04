public class Kolbasa extends Product{

    private String vid_kolbasy;
    public Kolbasa(String name, double price, int value, String vid_kolbasy) {
        super(name, price, value);
        this.vid_kolbasy = vid_kolbasy;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Колбаса ").append(vid_kolbasy).append(" ").append(super.toString());
        return res.toString();
    }
}
