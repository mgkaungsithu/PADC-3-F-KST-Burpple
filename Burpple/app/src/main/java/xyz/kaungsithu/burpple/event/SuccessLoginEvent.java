package xyz.kaungsithu.burpple.event;


import xyz.kaungsithu.burpple.data.vo.LogInUserVO;

/**
 * Created by Lenovo on 1/21/2018.
 */

public class SuccessLoginEvent {

    private LogInUserVO loginUserList;

    public LogInUserVO getLoginUserList() {
        return loginUserList;
    }

    public SuccessLoginEvent(LogInUserVO loginUserList) {
        this.loginUserList = loginUserList;
    }
}
