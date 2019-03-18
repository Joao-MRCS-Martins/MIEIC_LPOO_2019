public class AreaStringOutputter {
    private SumProvider sp ;

    AreaStringOutputter(SumProvider sp1) {sp = sp1;}

    public String output() {
        return "Sum of areas: " + sp.sum();
    }

}
