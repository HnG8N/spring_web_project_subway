/**
 * 재료 선택시 모두 선택하지 않으면 다음으로 진행되지 않게 체크함.
 */

function validateForm() {
    // 빵 길이 선택 확인
    var breadLength = document.querySelector('input[name="breadLength"]:checked');
    if (!breadLength) {
        alert('빵 길이를 선택하세요.');
        return false;
    }

    // 빵 선택 확인
    var bread = document.querySelector('input[name="bread"]:checked');
    if (!bread) {
        alert('빵을 선택하세요.');
        return false;
    }

    // 토스팅 선택 확인
    var warm = document.querySelector('input[name="warm"]:checked');
    if (!warm) {
        alert('토스팅 여부를 선택하세요.');
        return false;
    }

    // 치즈 선택 확인
    var cheese = document.querySelector('input[name="cheese"]:checked');
    if (!cheese) {
        alert('치즈를 선택하세요.');
        return false;
    }

    // 야채 최소한 하나 이상 선택 확인
    var veggies = document.querySelectorAll('input[name^="vegetable"]:checked');
    if (veggies.length === 0) {
        alert('야채를 최소한 하나 이상 선택하세요.');
        return false;
    }

    // 소스 선택 확인
    var sauce = document.querySelector('input[name="sauce"]:checked');
    if (!sauce) {
        alert('소스를 선택하세요.');
        return false;
    }

    // 모든 유효성 검사 통과시 true 반환
    return true;
}
