/**
 * 登录
 */

/**
 * 判断是否存在此用户
 * @param obj
 */
function userYAdnF(obj) {
    // 1. 获取 ajax 对象
    let ajax = createAJAX();
    // 2.准备提交
    ajax.open('GET', "user?action=judge&name=" + obj.value);
    // 3. 提交
    ajax.send(null);
    // 4. 等待
    ajax.onreadystatechange = function () {
        if (ajax.readyState === 4 && ajax.status === 200) {
            let text = ajax.responseText;
            if (text === "1") {
                // 后台查询存在，开放登录
                document.getElementById("loginButton").disabled = null;
                YAndN("loginUsername", "loginUsername_span", "form-group has-success has-feedback", "√");
            } else {
                // 不存在，关闭登录
                document.getElementById("loginButton").disabled = "disabled";
                YAndN("loginUsername", "loginUsername_span", "form-group has-error has-feedback", "X");
            }
        }
    }
}

/**
 * 对用户名绑定一个失去焦点事件
 */
document.getElementById("loginUsername_input").onblur = function () {
    // 校验用户名是否匹配
    if (checkName(this.value)) {
        userYAdnF(this);
    } else {
        document.getElementById("loginButton").disabled = "disabled";
        YAndN("loginUsername", "loginUsername_span", "form-group has-error has-feedback", "X");
    }
}

/**
 * 密码校验
 */
document.getElementById("loginPassword_input").onblur = function () {
    // 非空
    if (this.value != null && this.value !== "") {
        YAndN("loginPassword", "loginPassword_span", "form-group has-success has-feedback", "√");
    } else {
        YAndN("loginPassword", "loginPassword_span", "form-group has-error has-feedback", "X");
    }
}
