public class CollatzNumber {

    private int number;
    private int maxStep;
    private int maxValue;

    CollatzNumber(int number){
        this.number = number;
    }
    void setNumber(int number){
        this.number = number;
    }
    void setStep(int maxStep){
        this.maxStep = maxStep;
    }
    void setMaxValue(int maxValue){
        this.maxValue = maxValue;
    }
    int getNumber(){
        return number;
    }
    int getMaxStep(){
        return maxStep;
    }
    int getMaxValue(){
        return maxValue;
    }

    @Override
    public String toString(){
        return "Number "+getNumber()+" took "+getMaxStep()+" steps\n"+"Highest number reached was "+getMaxValue();
    }
}
