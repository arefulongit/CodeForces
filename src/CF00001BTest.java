import org.junit.Assert;
import org.junit.jupiter.api.Test;

class CF00001BTest {

    @Test
    void main() {
    }


    @Test
    void convertA1ToRC() {
        CF00001B cf = new CF00001B();
        String exp1 = "R1C1";
        String act1 = cf.convertA1ToRC.apply("A1");
        Assert.assertEquals(exp1, act1);
        String exp2 = "R23C55";
        String act2 = cf.convertA1ToRC.apply("BC23");
        Assert.assertEquals(exp1, act1);
    }

     @Test
    void getColumnNameByColumnNumber() {
        CF00001B cf = new CF00001B();
         String exp1 = "A";
         String act1 = cf.getColumnNameByColumnNumber("1");
         Assert.assertEquals(exp1,act1);
        String exp2 = "Z";
        String act2 = cf.getColumnNameByColumnNumber("26");
        Assert.assertEquals(exp2,act2);
         String exp3 = "AA";
         String act3 = cf.getColumnNameByColumnNumber("27");
         Assert.assertEquals(exp3,act3);
         String exp4 = "AZ";
         String act4 = cf.getColumnNameByColumnNumber("52");
         Assert.assertEquals(exp4,act4);
    }

    @Test
    void sort() throws Exception {
        CF00001B cf = new CF00001B();
        String exp1 = "R23C55";
        String act1 = cf.sort("BC23");
        Assert.assertEquals(exp1,act1);
        String exp2 = "RZ228";
        String act2 = cf.sort("R228C494");
        Assert.assertEquals(exp2,act2);
    }
}