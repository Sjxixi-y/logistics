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

// 执行操作
function YAndN(id1, id2, str1, str2) {
    document.getElementById(id1).className = str1;
    document.getElementById(id2).innerHTML = str2;
}