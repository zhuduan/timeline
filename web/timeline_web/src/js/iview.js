export function inputOnFocus(e) {
  var el = e.target;
  el.parentNode.className = 'form-group-label control-focus';
}

export function inputOnBlur(e) {
  var el = e.target;
  if(el.value != ''){
  }else{
    el.parentNode.className = 'form-group-label';
  }
}

export function validateEmail(str){
  var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
  return reg.test(str);
}

export function validatePhone(str){
  var reg = /^1[3|4|5|8][0-9]\d{4,8}$/;
  return reg.test(str);
}

export default {
  inputOnFocus,
  inputOnBlur,
  validateEmail,
  validatePhone
}
