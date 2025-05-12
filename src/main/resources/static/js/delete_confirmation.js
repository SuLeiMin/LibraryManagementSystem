/**
 *  削除ボタンをクリックすると、このメッセージボックスが表示する
 */

document.addEventListener('DOMContentLoaded', function() {
    const deleteForms = document.querySelectorAll('form[onsubmit]');

    deleteForms.forEach(form => {
        form.addEventListener('submit', function(event) {
            const confirmation = confirm('本当に削除しますか？');
            if (!confirmation) {
                event.preventDefault();
            }
        });
    });
});
