package org.loggedfuskater;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LFSTest {

    static class TestData {
        private String input;
        private int padding;
        private String expectedOutput;
        TestData(String input, int padding, String expectedOutput) {
            this.input = input;
            this.padding = padding;
            this.expectedOutput = expectedOutput;
        }
    }

    private static final TestData[] TEST_DATA = {
            // Empty input
            new TestData ("",0,"ExtremelyTipsyBunny"),
        // Test padding, positive and negative cases. Also, same input -> same output regardless of padding size.
            new TestData ("asdf",-42,"QuickRootedSwing"),
            new TestData ("asdf",0,"QuickRootedSwing"),
            new TestData ("asdf",2,"QuickRootedSwing5012"),
            new TestData ("asdf",4,"QuickRootedSwing5012F6C6"),
            new TestData ("asdf",8,"QuickRootedSwing5012F6C60B27661C"),
            new TestData ("asdf",200,"QuickRootedSwing5012F6C60B27661C"),
        // Test a few unique UUID:s
        new TestData ("ac968750-7ca2-4dde-908b-aacbbed2f470",1,"SomewhatCleanPearF4"),
        new TestData ("3e3278cd-6030-400d-9c0d-ef9be0119853",5,"QuickTipsyBobA2DEC84AEE"),
        new TestData ("6745dc33-2fbd-4311-8884-10aab93199a9",7,"NextSluggishSwing7F2343BF6927EA"),
        // Big data blob
        new TestData ("mc093284750932nv2ono2hvfnoh3fo9ch3fxh23omhf293u4hfcqoiuwnhfc093u4hfc2938hnfc209u3hfc092hu3fc092nu3hfc92u3h4fc92nu3h4nfc923h40fc92h340fu2h34fc9u2nh3409uh2304hufc2093u4hfc0\nfcn9n2j43fc 9hu23cfj32fc2\nfc234ufh2o3ihfoh4f92c3hnfc928h43c92mj3fc23\ncfhfcliuw hfroiwuehgoiwuregoiwuecpowi hcpoqiwjecpoiqwhecp9824r+9u3h4f9283 h4f8w73hfwo83fou3wh4fcpoqihfp2u3h4fc983h4fcpu3nh4fcpoh3pf2h34pfc8h3p48hcqp348hfcqp384hfcpq834nfcpq9834hfcpq3h4fc",
                0,"SometimesCleanGame")
    };

    @Test
    public void test() {
        for (TestData testData : TEST_DATA) {
            Assertions.assertEquals(testData.expectedOutput, LFS.obf(testData.input, testData.padding));
        }
    }
}
