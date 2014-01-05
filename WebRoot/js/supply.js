if( NavBar ){
	NavBar.setActive("navbar-supply");
	
}

$('#left-menu a').click(function(e) {
	e.preventDefault();
	$(this).tab('show');
})