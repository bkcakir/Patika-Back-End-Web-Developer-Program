package Week_5.BeyondClases.Enums;

public enum Operation {
    ADD {
        @Override
        public int apply(int number1,int number2){
            return number1+number2;
        }
    },
    SUBTRACT{
        @Override
        public int apply(int number1,int number2){
            return number2-number1;
        }
    };


        public  abstract  int apply(int number1,int number2);
}
