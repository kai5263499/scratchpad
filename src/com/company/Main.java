package com.company;

public class Main {



    public static void main(String[] args) {
        System.out.println("walkGraph");
        System.out.println(TreeTest.walkGraph(TreeTest.getTestTree()));

        System.out.println("paths");
        System.out.println(TreeTest.paths(TreeTest.getTestTree()));

        System.out.println("wordCount");
        System.out.println(TreeTest.wordCount("Genesis 1:1: In the beginning, God created the heavens and the earth.\n" +
                "Genesis 1:2: The earth was without form and void, and darkness was over the face of the deep. And the Spirit of God was hovering over the face of the waters. \n" +
                "\n" +
                "\n" +
                "Genesis 1:3: And God said, “Let there be light,” and there was light.\n" +
                "Genesis 1:4: And God saw that the light was good. And God separated the light from the darkness.\n" +
                "Genesis 1:5: God called the light Day, and the darkness he called Night. And there was evening and there was morning, the first day. \n" +
                "\n" +
                "\n" +
                "Genesis 1:6: And God said, “Let there be an expanse in the midst of the waters, and let it separate the waters from the waters.”\n" +
                "Genesis 1:7: And God made the expanse and separated the waters that were under the expanse from the waters that were above the expanse. And it was so.\n" +
                "Genesis 1:8: And God called the expanse Heaven. And there was evening and there was morning, the second day. \n" +
                "\n" +
                "\n" +
                "Genesis 1:9: And God said, “Let the waters under the heavens be gathered together into one place, and let the dry land appear.” And it was so.\n" +
                "Genesis 1:10: God called the dry land Earth, and the waters that were gathered together he called Seas. And God saw that it was good. \n" +
                "\n" +
                "\n" +
                "Genesis 1:11: And God said, “Let the earth sprout vegetation, plants yielding seed, and fruit trees bearing fruit in which is their seed, each according to its kind, on the earth.” And it was so.\n" +
                "Genesis 1:12: The earth brought forth vegetation, plants yielding seed according to their own kinds, and trees bearing fruit in which is their seed, each according to its kind. And God saw that it was good.\n" +
                "Genesis 1:13: And there was evening and there was morning, the third day. \n" +
                "\n" +
                "\n" +
                "Genesis 1:14: And God said, “Let there be lights in the expanse of the heavens to separate the day from the night. And let them be for signs and for seasons, and for days and years,\n" +
                "Genesis 1:15: and let them be lights in the expanse of the heavens to give light upon the earth.” And it was so.\n" +
                "Genesis 1:16: And God made the two great lights—the greater light to rule the day and the lesser light to rule the night—and the stars.\n" +
                "Genesis 1:17: And God set them in the expanse of the heavens to give light on the earth,\n" +
                "Genesis 1:18: to rule over the day and over the night, and to separate the light from the darkness. And God saw that it was good.\n" +
                "Genesis 1:19: And there was evening and there was morning, the fourth day. \n" +
                "\n" +
                "\n" +
                "Genesis 1:20: And God said, “Let the waters swarm with swarms of living creatures, and let birds fly above the earth across the expanse of the heavens.”\n" +
                "Genesis 1:21: So God created the great sea creatures and every living creature that moves, with which the waters swarm, according to their kinds, and every winged bird according to its kind. And God saw that it was good.\n" +
                "Genesis 1:22: And God blessed them, saying, “Be fruitful and multiply and fill the waters in the seas, and let birds multiply on the earth.”\n" +
                "Genesis 1:23: And there was evening and there was morning, the fifth day. \n" +
                "\n" +
                "\n" +
                "Genesis 1:24: And God said, “Let the earth bring forth living creatures according to their kinds—livestock and creeping things and beasts of the earth according to their kinds.” And it was so.\n" +
                "Genesis 1:25: And God made the beasts of the earth according to their kinds and the livestock according to their kinds, and everything that creeps on the ground according to its kind. And God saw that it was good. \n" +
                "\n" +
                "\n" +
                "Genesis 1:26: Then God said, “Let us make man in our image, after our likeness. And let them have dominion over the fish of the sea and over the birds of the heavens and over the livestock and over all the earth and over every creeping thing that creeps on the earth.” \n" +
                "\n" +
                "\n" +
                "Genesis 1:27: So God created man in his own image,\n" +
                "in the image of God he created him;\n" +
                "male and female he created them. \n" +
                "\n" +
                "\n" +
                "Genesis 1:28: And God blessed them. And God said to them, “Be fruitful and multiply and fill the earth and subdue it and have dominion over the fish of the sea and over the birds of the heavens and over every living thing that moves on the earth.”\n" +
                "Genesis 1:29: And God said, “Behold, I have given you every plant yielding seed that is on the face of all the earth, and every tree with seed in its fruit. You shall have them for food.\n" +
                "Genesis 1:30: And to every beast of the earth and to every bird of the heavens and to everything that creeps on the earth, everything that has the breath of life, I have given every green plant for food.” And it was so.\n" +
                "Genesis 1:31: And God saw everything that he had made, and behold, it was very good. And there was evening and there was morning, the sixth day. \n" +
                "\n"));

        ConcurrencyTest concurrencyTest = new ConcurrencyTest(1,2);
    }
}
