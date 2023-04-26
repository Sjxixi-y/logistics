// 获取ajax
function createAJAX() {
    let ajax;
    try {
        ajax = new ActiveXObject("microsoft.xmlhttp");
    } catch (el) {
        ajax = new XMLHttpRequest();
    }
    return ajax;
}

// 校验用户名
function checkName(name) {
    // 第一位为字母，其他任意，长度为 5-10位
    let reg = /^[a-zA-X][a-zA-Z\d]{4,9}$/;
    return reg.test(name);
}

// 判断是否存在此用户
function userYAdnF(obj) {
    let flog = false;
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
            if (text === '1')
                flog = true;
        }
    }
    return flog;
}

// 对用户名绑定一个失去焦点事件
document.getElementById("username").onblur = function () {
    // 校验用户名是否匹配
    if (checkName(this.value)) {
        // 后台查询是否存在
        if (userYAdnF(this)) {
            document.getElementById("span_username").innerHTML = "正确".fontcolor("green");
        } else {
            document.getElementById("span_username").innerHTML = "用户名不存在".fontcolor("red");
        }
    } else {
        document.getElementById("span_username").innerHTML = "用户名不满足格式".fontcolor("red");
    }
}