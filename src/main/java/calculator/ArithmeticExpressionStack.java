package calculator;


interface Stack{
    boolean isEmpty();
    String pop();
    void clear();
}

public class ArithmeticExpressionStack implements Stack {
    private int stackSize;
    private int flag;
    private String stack[];

    public ArithmeticExpressionStack(String[] equation, int stackSize){
        clear();
        flag = 0;
        this.stackSize = stackSize;
        stack = equation;
    }

    public String pop(){
        if(isEmpty()){
            return "스택이 존재하지 않습니다.";
        }
        else{
            return stack[flag++];
        }
    }

    public boolean isEmpty(){
        return (flag == this.stackSize);
    }

    public void clear(){
        if(!isEmpty()){
            flag = -1;
            this.stackSize = stackSize;
        }
    }

    public int getStackSize(){
        return this.stackSize;
    }

}
