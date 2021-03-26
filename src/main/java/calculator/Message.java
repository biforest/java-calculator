package calculator;

import java.util.HashMap;

/**
 * Message class
 * - message output class
 *
 * return type : void
 */
public class Message {
    HashMap<String, String> exceptionMessageList = new HashMap<String, String>();

    // Result output method when operation is normally performed
    public void calculationResult(int result){
        System.out.print("결과 : ");
        System.out.println(result);
    }

    // Error message list management method
    private void exceptionMessageList(){
        exceptionMessageList.put("NOT_OPERATOR", "사칙연산 기호에 해당하지 않는 기호가 존재합니다.");
        exceptionMessageList.put("INVALID_EQUATION", "잘못된 연산식입니다.");
        exceptionMessageList.put("INVALID_DIVIDE", "0으로 나눌수가 없습니다.");
    }

    // Error message output method
    public void exceptionResult(String exceptionKeyword){
        exceptionMessageList();
        System.out.println(exceptionMessageList.get(exceptionKeyword));
    }
}
