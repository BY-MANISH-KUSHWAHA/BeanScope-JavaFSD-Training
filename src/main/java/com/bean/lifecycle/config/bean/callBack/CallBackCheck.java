package com.bean.lifecycle.config.bean.callBack;

public class CallBackCheck {
    public static void main(String[] args) throws Exception{
        // Forward Call
        new CallBackCheck().ForwardCall(new CallBackCheck());
        System.out.println();
        System.out.println();


        // Follow the step for Call back call.
        //Step 1
        new CallBackCheck().someMethod(new CallBack(){
            // Step 2
            @Override
            public void call(){
                // Step 5
                System.out.println("I'm from Call back");
            }
        }); // Function Definition passing it as a parameter to someMethod
    } // Function Call of someMethod
    public  void someMethod(CallBack callBack){
        // Step 3
        System.out.println("Actual Method Call");
        // Step 4
        callBack.call(); // Function Call

    }

    public void ForwardCall(CallBackCheck obj){
        System.out.println("Forward Call");
        obj.PrintSomethind();
    }

    public void PrintSomethind(){
        System.out.println("I'm from Forward Call.");
    }

    public interface CallBack{
        void call();
    }
}
