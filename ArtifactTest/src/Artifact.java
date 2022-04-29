public class Artifact
{
        int number;
        int time;
        String culture;

        public Artifact(int number, int time, String culture)
        {
            this.number = number;
            this.time = time;
            this.culture = culture;
        }

        public Artifact(int number, String culture)
        {
            this.number = number;
            this.culture = culture;
        }

        public Artifact(int number) {
            this.number = number;
        }

        public static void main(String[] args)
        {
            Artifact v1 = new Artifact(100,212121,"Ацтеки");
            Artifact v2 = new Artifact(120, "Ацтеки" );
            Artifact v3 = new Artifact(130);
            System.out.println(v1.time);
            System.out.println(v2.culture);
            System.out.println(v3.number);
        }

}