package krish.bmi;

public class PoundModel {

    private double kiloyawyeet;

    public PoundModel(String a){
        this.kiloyawyeet = Double.parseDouble(a);

    }

    /** @param a
     *           dwqdqdwdwwwwwwwwwwwwww
     * @return
     */

    public String toPoundyeet(){
        double pound1 = this.kiloyawyeet*2.205;
        String result = String.format("%.2f", pound1);
        return result;

    }

    public static void main(String[] args) {
        PoundModel myModel = new PoundModel("100");
        System.out.println(myModel.toPoundyeet());

        //int x = 12312;
        //String result123 = String.format("%d", x);
        //System.out.println(result123);

    }
}
