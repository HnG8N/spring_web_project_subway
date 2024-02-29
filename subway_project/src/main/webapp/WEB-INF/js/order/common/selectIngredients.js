/**
 * 재료 선택시 모두 선택하지 않으면 다음으로 진행되지 않게 체크함.
 */

function validateForm() {
    var form = document.querySelector('form[action="addcart"]');
    var radioAndCheckboxes = form.querySelectorAll('input[type="radio"], input[type="checkbox"]');

    for (var i = 0; i < radioAndCheckboxes.length; i++) {
        if ((radioAndCheckboxes[i].type === 'radio' || radioAndCheckboxes[i].type === 'checkbox') && !radioAndCheckboxes[i].checked) {
            alert('모두 선택해주세요.');
            return false; // 폼 제출을 막습니다.
        }
    }
    return true; // 모든 조건이 충족되면 폼을 제출합니다.
}
