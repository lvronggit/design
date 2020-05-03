package effective;

public class MuriBuilder {

    private final int serviceSize;

    private final int fat;

    private final int calories;

    public static class Builder{


        private final int serviceSize;

        private  int fat;

        private  int calories;

        public Builder(int serviceSize) {
            this.serviceSize = serviceSize;
        }


        public Builder fat(int val){
            fat = val;
            return this;
        }

        public Builder calories(int val){
            calories = val;
            return this;
        }

    }


    public MuriBuilder(Builder builder) {
        serviceSize = builder.serviceSize;
        fat = builder.fat;
        calories = builder.calories;
    }
}
