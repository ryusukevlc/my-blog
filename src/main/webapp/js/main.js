/**
 * 
 */
 
 //記事を削除する時のダイアログ表示
 function articleDelete() {
	var result = window.confirm("削除しますか？");
	
	if (result) {
		document.deleteForm.submit();
	} else {
		
	}
	
}
 