/**
 * 注册
 */

/**
 * 判断是否存在用户
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
                // 后台查询存在，不能注册
                document.getElementById("registerSubmit").disabled = "disabled";
                YAndN("registerPassword1", "registerPassword1_span", "form-group has-error has-feedback", "X");
            } else {
                // 不存在，可以注册
                document.getElementById("loginButton").disabled = null;
                YAndN("registerPassword1", "registerPassword1_span", "form-group has-success has-feedback", "√");
            }
        }
    }
}


/**
 * 对用户名绑定一个失去焦点事件
 */
document.getElementById("registerUsername_input").onblur = function () {
    // 校验用户名是否匹配
    if (checkName(this.value)) {
        userYAdnF(this);
    } else {
        document.getElementById("registerSubmit").disabled = "disabled";
        YAndN("registerUsername", "registerUsername_span", "form-group has-error has-feedback", "X");
    }
}

/**
 * 密码校验
 */
document.getElementById("registerPassword1_input").onblur = function () {
    // 非空
    if (this.value != null && this.value !== "") {
        YAndN("registerPassword1", "registerPassword1_span", "form-group has-success has-feedback", "√");
    } else {
        YAndN("registerPassword1", "registerPassword1_span", "form-group has-error has-feedback", "X");
    }
}

/**
 * 再次输入密码
 */
document.getElementById("registerPassword2_input").onblur = function () {
    // 非空
    if (this.value != null && this.value !== "") {
        let value = document.getElementById("registerPassword1_input").value;
        if (value.value === this.value)
            YAndN("registerPassword2", "registerPassword2_span", "form-group has-success has-feedback", "√");
    } else {
        YAndN("registerPassword2", "registerPassword2_span", "form-group has-error has-feedback", "X");
    }
}