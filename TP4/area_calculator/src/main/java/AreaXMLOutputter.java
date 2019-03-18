public class AreaXMLOutputter {
    SumProvider sp;

    AreaXMLOutputter(SumProvider sp1) { sp = sp1;}

    public String output() {
        return "<area>" + sp.sum() + "</area>";
    }

}
