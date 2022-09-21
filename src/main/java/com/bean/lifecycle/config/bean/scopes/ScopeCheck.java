package com.bean.lifecycle.config.bean.scopes;

public class ScopeCheck {
    // Members
    int a = 10;

    public void add() throws Exception {
        int c;
        try {
            throw new Exception("Hello");
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}

// Member variable scope ==> Class Scope Check
// Method Parameter Scope ==> add()
// Exception Handler Parameter Scope ==> try{} catch
// Local Variable Scope ==> int c
