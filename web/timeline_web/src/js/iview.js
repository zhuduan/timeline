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

export default {
  inputOnFocus,
  inputOnBlur
}
